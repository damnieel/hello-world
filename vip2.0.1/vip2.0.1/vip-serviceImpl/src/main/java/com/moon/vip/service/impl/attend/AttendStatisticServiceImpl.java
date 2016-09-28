package com.moon.vip.service.impl.attend;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.moon.vip.application.inspect.InspectDetailSqlMapper;
import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.constants.EnumAttendException;
import com.moon.vip.infra.exception.AttendanceException;
import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.attendance.AttendNumsVO;
import com.moon.vip.infra.vo.attendance.OrgNameAndAttenDataVO;
import com.moon.vip.infra.vo.attendance.StatisticAttenDataVO;
import com.moon.vip.infra.vo.search.StatisticSearchParams;
import com.moon.vip.model.sys.OrganizationalProfessional;
import com.moon.vip.service.attend.IAttenStatisticService;
import com.moon.vip.service.report.IReportService;

@Service("attenStatisticService")
public class AttendStatisticServiceImpl implements IAttenStatisticService {
	@Autowired
	private OrganizationalProfessionalSqlMapper organizationalProfessionalSqlMapper;
	@Autowired
	private InspectDetailSqlMapper inspectDetailSqlMapper;
	@Autowired
	@Qualifier("attendReportService")
	private IReportService<AttendNumsVO> attendReportService;
	private static Logger logger = Logger.getLogger(AttendStatisticServiceImpl.class);

	public List<StatisticAttenDataVO> getStatisticData(StatisticSearchParams params) {
		validParams(params);
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(10));
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 任务拒绝策略，启用主线程
		List<StatisticAttenDataVO> resultList = new ArrayList<StatisticAttenDataVO>();
		List<OrganizationalProfessional> list = findChildOrg(params.getOrgProCalId(),params.getOpClaIds());
		for (int i = 0; i < 3; i++) {
			StatisticAttenDataVO statistic = new StatisticAttenDataVO();
			statistic.setPercentType(i);
			List<OrgNameAndAttenDataVO> orgNameAndData = new ArrayList<OrgNameAndAttenDataVO>();
			for (int k = 0; k < list.size(); k++) {
				OrgNameAndAttenDataVO orgAndAtten = new OrgNameAndAttenDataVO();
				orgAndAtten.setOrgName(list.get(k).getName());
				orgAndAtten.setOrgId(list.get(k).getId());
				orgNameAndData.add(orgAndAtten);
			}
			statistic.setOrgNameAndData(orgNameAndData);
			resultList.add(statistic);
		}
		for (int k = 0; k < list.size(); k++) {
			creatThread(executor, k, resultList, params);
		}
		executor.shutdown();
		while (true) {
			if (executor.isTerminated()) {
				break;
			} // 等待线程结束

		}
		return resultList;
	}

	private void creatThread(ThreadPoolExecutor executor, final Integer i, final List<StatisticAttenDataVO> resultList,
			final StatisticSearchParams params) {
		    Runnable command = new Runnable() {
			public void run() {
				getStatisticData(i, resultList, params);
			}
		};
		executor.execute(command);
	}

	/** 获取出勤次数信息，并统计出勤率 **/
	private void getStatisticData(Integer i, List<StatisticAttenDataVO> resultList, StatisticSearchParams params) {
		logger.info("X*************");
		Integer parentOrgId = resultList.get(0).getOrgNameAndData().get(i).getOrgId();
		String orgName = resultList.get(0).getOrgNameAndData().get(i).getOrgName();
		if (parentOrgId == 0) {
			throw new AttendanceException(EnumAttendException.SYSERR0000);
		}
		List<Integer> list = organizationalProfessionalSqlMapper.getAllProId(parentOrgId);
		if (list == null || list.size() == 0) {
			logger.error(String.format("该部门没有设置专业[%s]", orgName));
			throw new AttendanceException(EnumAttendException.SYSERR0001);
		}
		AttendNumsVO attendNums = new AttendNumsVO();
		switch (params.getTimeRangeType()) {
		case 5:
			attendNums = inspectDetailSqlMapper.getStatisticData(list, params);
			break; // 根据时间段
		case 4:
			attendNums = getThisTimeRpt(4, params, list);
			break; // 本月
		case 3:
			Date lastmonth = DateUtil.getLastMonth(new Date());
			List<AttendNumsVO> monthlist = attendReportService.getMonthlyReport(lastmonth,parentOrgId,params.getOpClaIds());
			if (monthlist != null && monthlist.get(0) != null) {
				attendNums = monthlist.get(0);
			} else {
				logger.warn(String.format("部门[%s]月报[%s]尚未生成", parentOrgId, lastmonth));
			/*	attendReportService.makeMonthlyReport(lastmonth, parentOrgId);
				logger.info(String.format("尝试再次生成该部门[%s]月报", parentOrgId));
				monthlist = attendReportService.getMonthlyReport(lastmonth,parentOrgId,params.getOpClaIds());
				if (monthlist != null && monthlist.get(0) != null) {
					attendNums = monthlist.get(0);
				}*/
			}
			break;
		case 2 : 
			attendNums =getThisTimeRpt(2,params,list);
			break; //本周
		case 1 :  	
			 Date lastWeek = DateUtil.getLastWeek(new Date());
			 List<AttendNumsVO> weekList = new ArrayList<AttendNumsVO>();
			 weekList = attendReportService.getWeeklyReport(lastWeek, parentOrgId,params.getOpClaIds());
			 if( weekList.get(0) != null){
			   attendNums = weekList.get(0);
			 } else{
			   logger.warn(String.format("部门[%s]周报[%s]尚未生成",parentOrgId,lastWeek));
			  /* attendReportService.makeWeeklyReport(lastWeek, parentOrgId);
			   logger.info(String.format("尝试再次生成该部门[%s]周报", parentOrgId));
			   weekList  =  attendReportService.getWeeklyReport(lastWeek, parentOrgId,params.getOpClaIds());
			   if( weekList.get(0) != null){
			    attendNums = weekList.get(0);
			   }*/
			 }
			 break;
		default:
			throw new AttendanceException(EnumAttendException.DAERR0011);
		}
	
		computePercent(i, resultList, attendNums, orgName);
	}

	/** 根据条件获取本周周报，或者本月月报 **/
	private AttendNumsVO getThisTimeRpt(Integer type, StatisticSearchParams params, List<Integer> list) {
		if (type == 2) {
			params.setStartDate(DateUtil.getWeekStartTime(new Date()));
		} else {
			params.setStartDate(DateUtil.getMonthStartTime(new Date()));
		}
		params.setEndDate(new Date());
		return inspectDetailSqlMapper.getStatisticData(list, params); // 根据时间段
	}

	private boolean validParams(StatisticSearchParams params) {
		if (params.getOrgProCalId() == 0) {
			throw new AttendanceException(EnumAttendException.DAERR0000);
		}
		if (params.getTimeRangeType() == 5 && params.getStartDate() == null && params.getEndDate() == null) {
			throw new AttendanceException(EnumAttendException.DAERR0011);
		}
		return true;

	}

	private double changeNum(double a) {
		DecimalFormat df = new DecimalFormat("#.00");
		return Double.valueOf(df.format(a));
	}

	private void computePercent(Integer i, List<StatisticAttenDataVO> resultList, AttendNumsVO attendNums,
			String orgName) {
		if (attendNums == null) {
			logger.warn(String.format("该部门尚未有考勤记录[%s]", orgName));
		//	setZero(resultList, i);
		} else {
			int at = attendNums.getAttendanceSums();
			int ab = attendNums.getAbsenceSums();
			int le = attendNums.getLeaveSums();
			int sum = at + ab + le;
			if (sum != 0) {
			 // setZero(resultList, i);
			//}else{
			double attendPercent = changeNum((double) at / sum * 100);
			double absentPercent = changeNum((double) ab / sum * 100);
			double leavePercent = changeNum(100 - absentPercent - attendPercent);
			resultList.get(0).getOrgNameAndData().get(i).setPercent(attendPercent);
			resultList.get(1).getOrgNameAndData().get(i).setPercent(absentPercent);
			resultList.get(2).getOrgNameAndData().get(i).setPercent(leavePercent);
			}
		}
	}
/*	private void setZero( List<StatisticAttenDataVO> resultList,Integer i){
		resultList.get(0).getOrgNameAndData().get(i).setPercent(0);
		resultList.get(1).getOrgNameAndData().get(i).setPercent(0);
		resultList.get(2).getOrgNameAndData().get(i).setPercent(0);
	}*/
    /**获取下一级机构**/
	private List<OrganizationalProfessional> findChildOrg(Integer parentId, HashSet<Integer> hashSet) {
		List<OrganizationalProfessional> list = new ArrayList<OrganizationalProfessional>();
		list = organizationalProfessionalSqlMapper.findChildOrg(parentId,hashSet);
		return list;
	}

}
