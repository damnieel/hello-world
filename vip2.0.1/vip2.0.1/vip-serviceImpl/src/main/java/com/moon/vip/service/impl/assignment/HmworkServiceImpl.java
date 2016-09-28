package com.moon.vip.service.impl.assignment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.moon.vip.application.assignment.HomeworkSqlMapper;
import com.moon.vip.application.assignment.SchoolAssignmentDetailMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.util.DateUtil;
import com.moon.vip.infra.vo.homework.ClassHmworkVO;
import com.moon.vip.infra.vo.homework.ClassAndTeacherVO;
import com.moon.vip.infra.vo.homework.LackHmworkStudentVO;
import com.moon.vip.infra.vo.homework.StudentHmworkVO;
import com.moon.vip.infra.vo.search.LackHmworkSearchParams;
import com.moon.vip.infra.vo.search.SearchParamsWithDept;
import com.moon.vip.model.assignment.SchoolAssignmentClass;
import com.moon.vip.model.assignment.SchoolAssignmentDetail;
import com.moon.vip.service.assignment.IHmworkService;
import com.moon.vip.service.search.SearchBase;

/**
 * 学生作业提交情况登记服务实现类
 * HomeworkServiceImpl<BR>
 * 创建人:lqc <BR>
 * 时间：2015年12月25日-上午9:15:00 <BR>
 * @version 2.0.0
 *
 */
@Service("hmworkService")
public class HmworkServiceImpl implements IHmworkService {

	private static Logger logger = Logger.getLogger(HmworkServiceImpl.class);
	@Autowired
	@Qualifier("HmworkRecordSearch")
	private SearchBase<SearchParamsWithDept,ClassAndTeacherVO> hmworkRecordSearchService;
	@Autowired
	@Qualifier("lackHmworkSearch")
	private SearchBase<LackHmworkSearchParams,LackHmworkStudentVO> lackHmworkSearchService;
	@Autowired
	private HomeworkSqlMapper hmworkSqlMapper;
	@Autowired
	private SchoolAssignmentDetailMapper schlAssignDetialMapper;
	
	public int getCountAllClassByDeptAndKey(SearchParamsWithDept searchParams) {
		validateSearchParams(searchParams);
		return hmworkRecordSearchService.getSearchResultCount(searchParams);
	}
	
	public List<ClassAndTeacherVO> searchAllClassByDeptAndKeyPage(SearchParamsWithDept searchParams) {
		validateSearchParams(searchParams);
		return hmworkRecordSearchService.search(searchParams);
	}

	public int getCountAllHmworkRecordByClassId(SearchParamsWithDept searchParams) {
		validateSearchParams(searchParams);
		if(searchParams.getOrgProCalId() == 0) return 0;
		return hmworkSqlMapper.getCountAllHmworkRecordByClassId(searchParams);
	}

	public List<ClassHmworkVO> seachAllHmworkRecordByClassIdPage(SearchParamsWithDept searchParams) {
		validateSearchParams(searchParams);
		List<SchoolAssignmentClass> classList = hmworkSqlMapper.findAllHmworkRecordByClassIdPage(searchParams);
		if(classList == null) return null;
		/*List<Integer> sacIdList = new ArrayList<Integer>();*/
		List<ClassHmworkVO> classHnworkVOList = new ArrayList<ClassHmworkVO>();
		ClassHmworkVO classHmworkVO;
		for(SchoolAssignmentClass classMdl: classList){
			classHmworkVO = new ClassHmworkVO();
		    BeanUtils.copyProperties(classMdl, classHmworkVO);
		    classHnworkVOList.add(classHmworkVO);
		    /*sacIdList.add(classMdl.getId());*/
		}
		
		/*List<StudentHmworkVO> stuHmworkVOList = getAllStudentsHmworkBySacIds(sacIdList);
		for(ClassHmworkVO chmVO:classHnworkVOList){
			if(chmVO.getId() == null) continue;
			for(StudentHmworkVO stuHmVO : stuHmworkVOList){
				if(chmVO.getId().equals(stuHmVO.getSacId())){
					chmVO.getStudentHomeworkList().add(stuHmVO);
					stuHmworkVOList.remove(stuHmVO);
				}
			}	
		}*/
		
		return classHnworkVOList;
	}
	
	// 验证搜索参数不为空
	private boolean validateSearchParams(SearchParamsWithDept searchParams) {
		if(searchParams==null){
			logger.warn("学生作业搜索参数为空");
			throw new BusinessException(EnumCodeException.E0001);
		}
		return true;
	}

	// 验证作业提交记录不为空
	private  boolean validateHmworkRecordNull(ClassHmworkVO classHmworkVO) {
		if(classHmworkVO == null || 
				classHmworkVO.getStudentHomeworkList() == null ||
				classHmworkVO.getStudentHomeworkList().size() == 0){
				return true;
			}
		return false;
	}
	// 验证作业提交记录完整性
	private boolean validateHmworkRecordEntire(ClassHmworkVO classHmworkVO) {
		if(validateHmworkRecordNull(classHmworkVO)) return false;
		if(classHmworkVO.getClassId() == null ||
				classHmworkVO.getCreateTime() == null ||
				classHmworkVO.getCreator() == null ||
				classHmworkVO.getCheckDate() == null){
			return false;
		}
		for(StudentHmworkVO studentHmworkVO : classHmworkVO.getStudentHomeworkList()) {
			if(studentHmworkVO.getStudentId() == null ||
					studentHmworkVO.getCheckStatus() == null){
				return false;
			}
		}
		return true;
	}
	
	public int saveHmworkRecord(ClassHmworkVO classHmworkVO) {
		if(!validateHmworkRecordEntire(classHmworkVO)) return 0;
		// 处理学生提交作业记录
		List<SchoolAssignmentDetail> assignmentDetailList = new ArrayList<SchoolAssignmentDetail>();
		SchoolAssignmentDetail assignmentDetail;
		int submitNumber =  0;
		int hiatusNumber =  0;
		for(StudentHmworkVO studentHmworkVO : classHmworkVO.getStudentHomeworkList()){
			if(studentHmworkVO.getCheckStatus() != null && studentHmworkVO.getCheckStatus() == 1){
				submitNumber++;
			}else{
				hiatusNumber++;
			}
			assignmentDetail= new SchoolAssignmentDetail();
			BeanUtils.copyProperties(classHmworkVO, assignmentDetail);
			BeanUtils.copyProperties(studentHmworkVO, assignmentDetail);
			assignmentDetailList.add(assignmentDetail);
		}
		classHmworkVO.setSubmitNumber(submitNumber);
		classHmworkVO.setHiatusNumber(hiatusNumber);
		SchoolAssignmentClass classMdl = new SchoolAssignmentClass();
		BeanUtils.copyProperties(classHmworkVO, classMdl);
		hmworkSqlMapper.insertSAClassSelective(classMdl);
		// 在学生提交作业详细信息中写入关联表ID
		for(SchoolAssignmentDetail asd : assignmentDetailList){
			asd.setSacId(classMdl.getId());
		}	
		return hmworkSqlMapper.insertSADetailSelectiveBatch(assignmentDetailList);
	}

	public int updateHmworkRecord(ClassHmworkVO classHmworkVO) {
		if(!validateHmworkRecordEntire(classHmworkVO) ||
				classHmworkVO.getId() == null) return 0;
		removeHmworkRecordById(classHmworkVO);
		return saveHmworkRecord(classHmworkVO);
	}

	public int removeHmworkRecordById(ClassHmworkVO classHmworkVO) {
		if(classHmworkVO == null ||
				classHmworkVO.getId() == null) return 0;
		hmworkSqlMapper.deleteHmworkDetailBySacId(classHmworkVO.getId());
		hmworkSqlMapper.deleteHmworkRecordById(classHmworkVO.getId());
		return 0;
	}
	
	public List<LackHmworkStudentVO> searchLackHmworkStudentPage(LackHmworkSearchParams searchParams) {
		validateSearchParams(searchParams);
		if(searchParams.getEndDate() == null){
			searchParams.setEndDate(new Date());
		}
		if(searchParams.getStartDate() == null){
			searchParams.setEndDate(DateUtil.getWeekStartTime(searchParams.getEndDate()));;
		}
		return lackHmworkSearchService.search(searchParams);
	}

	public int getCountSearchLackHmworkStudent(LackHmworkSearchParams searchParams) {
		// TODO Auto-generated method stub
		return lackHmworkSearchService.getSearchResultCount(searchParams);
	}

	public List<StudentHmworkVO> getAllStudentsHmworkBySacIds(List<Integer> sacIds) {
		if(sacIds == null) return null;
		logger.info(String.format("查询班级作业提交学生列表[%s]", sacIds.toString()));
		return hmworkSqlMapper.findSADetailBySacIds(sacIds);
	}
	
	
}
