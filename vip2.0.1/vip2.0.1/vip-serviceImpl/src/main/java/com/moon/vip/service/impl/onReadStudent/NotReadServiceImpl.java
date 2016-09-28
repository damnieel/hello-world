package com.moon.vip.service.impl.onReadStudent;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.student.ArchProfOrgProfClassSqlMapper;
import com.moon.vip.application.student.StudentClassMapper;
import com.moon.vip.application.student.StudentClassSqlMapper;
import com.moon.vip.application.student.StudentProfessionalMapper;
import com.moon.vip.application.student.StudentProfessionalSqlMapper;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.vo.onReadPage.OnReadPageStudentsVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.model.student.StudentClass;
import com.moon.vip.model.student.StudentProfessional;
import com.moon.vip.service.onReadStudent.IDivideGradeService;
import com.moon.vip.service.onReadStudent.INotReadService;
import com.moon.vip.service.sys.IOrgProfessionalService;

@Service("iNotReadService")
public class NotReadServiceImpl implements INotReadService {
	private Logger logger = Logger.getLogger(NotReadServiceImpl.class);
	@Autowired
	private ArchProfOrgProfClassSqlMapper archProfOrgProfClassSqlMapper;
	
	@Autowired
	private StudentClassSqlMapper studentClassSqlMapper;
	
	@Autowired
	private StudentProfessionalMapper studentProfessionalMapper;
	
	@Autowired
	private StudentProfessionalSqlMapper studentProfessionalSqlMapper;
	
	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;
	
	@Autowired
	private IDivideGradeService iDivideGradeService;
	
	private ParamsVO convertOrgId(ParamsVO paramsVO){
		if(paramsVO.getOrganizationId() != null) {
			paramsVO.setSearchOpClaIds(
					iOrgProfessionalService.covertOrgSearch(paramsVO.getOrganizationId()));
		}
		return paramsVO;
	}
	public int selectNotReadStudentCount(ParamsVO paramsVO) {
		paramsVO = convertOrgId(paramsVO);
		return archProfOrgProfClassSqlMapper.selectNotReadStudentCount(paramsVO);
	}

	public List<OnReadPageStudentsVO> selectNotReadStudent(ParamsVO paramsVO) {
		paramsVO = convertOrgId(paramsVO);
		List<OnReadPageStudentsVO> list = archProfOrgProfClassSqlMapper.selectNotReadStudent(paramsVO);
		list = iDivideGradeService.convertCodeTable(list);
		return list;
	}

	public Message backReadAction(ParamsVO paramsVO) {
		logger.info("开始复学 paramsVO: " + paramsVO);
		Message msg = new Message();
		msg.setResult(true);
		int profInfoId = 0;
		String[] idArray = paramsVO.getIdArray().split(",");
		String[] nameArray = paramsVO.getNameArray().split(",");
		String[] profOrgIdArray = paramsVO.getProfOrgIdArray().split(",");
		String[] statusArray = paramsVO.getStatusArray().split(",");

		//判断数据的正确性并获取专业信息的id
		if(paramsVO.getStatusArray().contains("drop")) {
			msg.setResult(false);
			msg.setMsg("学员中有退学状态， 退学不能再复学");
			return msg;
		}
		for(int i=0;i<idArray.length;i++) {
			//获取专业信息id
			ParamsVO selectData = new ParamsVO();
			selectData.setIdArray(idArray[i]);
			selectData.setStatusArray(statusArray[i]);
			selectData.setProfOrgIdArray(profOrgIdArray[i]);
			profInfoId = studentProfessionalSqlMapper.selectProfIdtoUpdata(selectData);
			
			//更新专业表
			StudentProfessional sp = new StudentProfessional();
			sp.setModifyTime(new Date());
			sp.setModifyUser(paramsVO.getCreator());
			sp.setChangeTime(new Date());
			sp.setChangeReason("非在读页面， 批量复学");
			sp.setStatus("reading");
			sp.setId(profInfoId);
			
			int k = studentProfessionalMapper.updateByPrimaryKeySelective(sp);
			if(k==0) {
				msg.setResult(false);
				msg.setMsg(String.format("更新数据库失败: 姓名-%s", nameArray[i]));
				return msg;
			}
		}
		return msg;
	}

}
