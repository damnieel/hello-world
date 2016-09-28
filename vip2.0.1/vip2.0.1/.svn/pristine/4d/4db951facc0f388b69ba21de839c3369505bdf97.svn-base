package com.moon.vip.service.impl.onReadStudent;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.assignment.SchoolAssignmentDetailSqlMapper;
import com.moon.vip.application.inspect.InspectDetailSqlMapper;
import com.moon.vip.application.interviews.InterviewsSqlMapper;
import com.moon.vip.application.student.ArchProfOrgProfClassSqlMapper;
import com.moon.vip.application.student.ArchivesProfOrgProfSqlMapper;
import com.moon.vip.application.student.StudentArchivesSqlMapper;
import com.moon.vip.application.student.StudentClassMapper;
import com.moon.vip.application.student.StudentClassSqlMapper;
import com.moon.vip.application.student.StudentProfessionalSqlMapper;
import com.moon.vip.application.sys.CodeTableSqlMapper;
import com.moon.vip.application.sys.OrganizationalProfessionalSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.IsValidType;
import com.moon.vip.infra.constants.Message;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.attendance.DelAttenParamsVO;
import com.moon.vip.infra.vo.onReadPage.OnReadPageStudentsVO;
import com.moon.vip.infra.vo.onReadPage.ParamsVO;
import com.moon.vip.infra.vo.sys.OrgProfessionalInfoVO;
import com.moon.vip.model.assignment.SchoolAssignmentDetail;
import com.moon.vip.model.student.StudentClass;
import com.moon.vip.service.onReadStudent.IDivideGradeService;
import com.moon.vip.service.sys.IOrgProfessionalService;

@Service("iDivideGradeService")
public class DivideGradeServiceImpl implements IDivideGradeService {

	private Logger logger = Logger.getLogger(DivideGradeServiceImpl.class);
	@Autowired
	private ArchProfOrgProfClassSqlMapper archProfOrgProfClassSqlMapper;

	@Autowired
	private ArchivesProfOrgProfSqlMapper archivesProfOrgProfSqlMapper;
	@Autowired
	private StudentArchivesSqlMapper studentArchivesSqlMapper;
	@Autowired
	private StudentProfessionalSqlMapper studentProfessionalSqlMapper;
	@Autowired
	private OrganizationalProfessionalSqlMapper organizationalProfessionalSqlMapper;

	@Autowired
	private InterviewsSqlMapper interviewsSqlMapper;

	@Autowired
	private StudentClassMapper studentClassMapper;

	@Autowired
	private InspectDetailSqlMapper inspectDetailSqlMapper;

	@Autowired
	private SchoolAssignmentDetailSqlMapper schoolAssignmentDetailSqlMapper;

	@Autowired
	private StudentClassSqlMapper studentClassSqlMapper;

	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;

	@Autowired
	private CodeTableSqlMapper codeTableSqlMapper;

	private ParamsVO convertOrgId(ParamsVO paramsVO) {
		if (paramsVO.getOrganizationId() != null) {
			paramsVO.setSearchOpClaIds(iOrgProfessionalService.covertOrgSearch(paramsVO.getOrganizationId()));
		}
		return paramsVO;
	}

	public List<OnReadPageStudentsVO> selectUndivStudent(ParamsVO paramsVO) {
		paramsVO = convertOrgId(paramsVO);
		List<OnReadPageStudentsVO> list = archProfOrgProfClassSqlMapper.selectUndivStudent(paramsVO);
		list = convertCodeTable(list);
		return list;
	}

	public int selectUndivStudentCount(ParamsVO paramsVO) {
		paramsVO = convertOrgId(paramsVO);
		return archProfOrgProfClassSqlMapper.selectUndivStudentCount(paramsVO);
	}

	public List<OnReadPageStudentsVO> selectDivedStudent(ParamsVO paramsVO) {
		paramsVO = convertOrgId(paramsVO);
		List<OnReadPageStudentsVO> onReadListOriginal = archProfOrgProfClassSqlMapper.selectDivedStudent(paramsVO);
		List<OnReadPageStudentsVO> onReadList = convertCodeTable(onReadListOriginal);
		List<OnReadPageStudentsVO> treeList = new ArrayList<OnReadPageStudentsVO>();
		List<String> index = new ArrayList<String>();

		Map<String, OnReadPageStudentsVO> map = new HashMap<String, OnReadPageStudentsVO>();
		for (int i = 0; i < onReadList.size(); i++) {
			String keyParam = onReadList.get(i).getId().toString() + onReadList.get(i).getName()
					+ onReadList.get(i).getProfessionId() + onReadList.get(i).getProfessionName();
			if (map.isEmpty()) {// 如果map为空，就放key和object进去
				map.put(keyParam, onReadList.get(i));
				index.add(keyParam);
			} else {
				OnReadPageStudentsVO studentVO = map.get(keyParam);
				if (studentVO == null) {// map中没有相同object
					map.put(keyParam, onReadList.get(i));
					index.add(keyParam);
				} else {// map中有同名， 同专业的人
					List<OnReadPageStudentsVO> list = studentVO.getOnReadList();
					if (list.size() == 0) {
						OnReadPageStudentsVO vo = new OnReadPageStudentsVO();
						BeanUtils.copyProperties(studentVO, vo);
						list.add(vo);
					}
					list.add(onReadList.get(i));
					studentVO.setOnReadList(list);
					map.put(keyParam, studentVO);
				}
			}
		}
		// map转化为list
		for (String key : index) {
			treeList.add(map.get(key));
		}
		return treeList;
	}

	/**
	 * 根据码表内容 转换字段<br/>
	 */
	public List<OnReadPageStudentsVO> convertCodeTable(List<OnReadPageStudentsVO> onReadListOriginal) {
		Map<String, Object> map = new HashMap<String, Object>();

		for (OnReadPageStudentsVO vo : onReadListOriginal) {

			String isArrears = vo.getIsArrears();
			if (isArrears != null) {
				if (map.get(isArrears) == null) {
					String temp = codeTableSqlMapper.selectByTypeAndCodeKey("yesOrNo", isArrears);
					if (temp == null) {
						temp = "无";
						logger.info("码表中type(yesOrNo)不存在" + isArrears);
					} else {
						map.put(vo.getIsArrears(), temp);
						vo.setIsArrears(temp);
					}
				} else {
					vo.setIsArrears((String) map.get(vo.getIsArrears()));
				}
			}

			String isRefund = vo.getIsRefund();
			if (isRefund != null) {
				if (map.get(isRefund) == null) {
					String temp = codeTableSqlMapper.selectByTypeAndCodeKey("yesOrNo", isRefund);
					if (temp == null) {
						temp = "无";
						logger.info("码表中type(yesOrNo)不存在" + isRefund);
					} else {
						map.put(isRefund, temp);
						vo.setIsRefund(temp);
					}
				} else {
					vo.setIsRefund((String) map.get(isRefund));
				}
			}

			String gradeStatue = vo.getGradeStatue();
			if (gradeStatue != null) {
				if (map.get(gradeStatue) == null) {
					String temp = codeTableSqlMapper.selectByTypeAndCodeKey("gradeStatus", gradeStatue);
					if (temp == null) {
						temp = "无";
						logger.info("码表中type(gradeStatus)不存在" + gradeStatue);
					} else {
						map.put(gradeStatue, temp);
						vo.setGradeStatue(temp);
					}
				} else {
					vo.setGradeStatue((String) map.get(gradeStatue));
				}
			}

			String codeStatus = vo.getCodeStatus();
			if (codeStatus != null) {
				if (map.get(codeStatus) == null) {
					String temp = codeTableSqlMapper.selectByTypeAndCodeKey("profStatus", codeStatus);
					if (temp == null) {
						temp = "无";
						logger.info("码表中type(profStatus)不存在" + codeStatus);
					} else {
						map.put(codeStatus, temp);
						vo.setCodeStatus(temp);
					}
				} else {
					vo.setCodeStatus((String) map.get(codeStatus));
				}
			}

		}
		return onReadListOriginal;
	}

	public int selectDivedStudentCount(ParamsVO paramsVO) {
		paramsVO = convertOrgId(paramsVO);
		return archProfOrgProfClassSqlMapper.selectDivedStudentCount(paramsVO);
	}

	public String hasInterviews(ParamsVO paramsVO) {
		String result = null;
		Integer index = 0;

		String[] idArrs = paramsVO.getIdArray().split(",");
		String[] nameArrs = paramsVO.getNameArray().split(",");
		String[] profOrgIdArrs = paramsVO.getProfOrgIdArray().split(",");
		for (int i = 0; i < idArrs.length; i++) {
			if (idArrs[i].equalsIgnoreCase("")) {
				continue;
			}
			if (hasInterview(Integer.valueOf(idArrs[i]), Integer.valueOf(profOrgIdArrs[i]))) {// 没有访谈记录
				if (index == 6) {
					result = result + "...";
				} else if (index > 6) {
					continue;
				} else {
					result = (result == null) ? "" : result;
					result = result + nameArrs[i];
					index++;
				}
			}
		}
		result = (result == null) ? null : ("学员：" + result + "有访谈记录, 请先删除访谈记录");
		logger.info(result);
		return result;
	}

	public void updateValidArchProf(String idArray, String profOrgIdArray) {
		String[] idArrs = idArray.split(",");
		String[] profOrgIdArrs = profOrgIdArray.split(",");
		for (int i = 0; i < idArrs.length; i++) {
			if (idArrs[i].equalsIgnoreCase("")) {
				continue;
			}
			// 删除学员信息 学员信息不做删除
			// studentArchivesSqlMapper.updateValidArch(Integer.valueOf(idArrs[i]));
			// 删除专业信息
			studentProfessionalSqlMapper.updateValidProfByStudentId(Integer.valueOf(idArrs[i]),
					Integer.valueOf(profOrgIdArrs[i]));
		}
	}

	public void divideGrade(ParamsVO paramsVO) {
		Integer profOrgId = paramsVO.getProfOrgId();
		if (profOrgId == null) {
			if (paramsVO.getProfOrgIdArray() == null) {
				throw new BusinessException(EnumCodeException.E0001);
			}
			String[] profOrgIdList = paramsVO.getProfOrgIdArray().split(",");
			profOrgId = Integer.valueOf(profOrgIdList[0]);
		}
		String[] idList = paramsVO.getIdArray().split(",");
		String[] gradeOrgList = paramsVO.getGradeOrgIdArray().split(",");
		// 插入相关的班级表信息
		StudentClass studentClass = new StudentClass();
		for (int i = 0; i < idList.length; i++) {
			for (int j = 0; j < gradeOrgList.length; j++) {
				studentClass.setOpProId(profOrgId);
				studentClass.setOpClaId(Integer.valueOf(gradeOrgList[j]));
				studentClass.setStudentId(Integer.valueOf(idList[i]));
				studentClass.setStatus("reading");
				studentClass.setIsValid(IsValidType.Y_VALUE);
				studentClass.setCreateTime(new Date());
				studentClass.setCreator(paramsVO.getCreator());

				studentClassMapper.insertSelective(studentClass);
			}
		}
	}

	public List<OrgProfessionalInfoVO> getClassesByprofName(String profName) {
		logger.info("获取专业下班级，专业为： " + profName);
		int profOrgId = organizationalProfessionalSqlMapper.selectProfByName(profName);
		List<OrgProfessionalInfoVO> orgProfClassList = organizationalProfessionalSqlMapper
				.selectOrgInfoByParentId(profOrgId);
		return orgProfClassList;
	}

	public Message delDivedStudent(ParamsVO paramsVO) {
		logger.info("删除已分班数据");
		Message msg = new Message();
		Map<Integer, String> errorMap = new HashMap<Integer, String>();
		String[] idArray = paramsVO.getIdArray().split(",");
		String[] nameArray = paramsVO.getNameArray().split(",");
		String[] gradeOrgIdArray = paramsVO.getGradeOrgIdArray().split(",");
		String[] gradeIdArray = paramsVO.getGradeIdArray().split(",");
		String[] profOrgIdArray = paramsVO.getProfOrgIdArray().split(",");
		int index = 0;

		/**
		 * 判断是否有访谈记录、作业记录和考勤记录
		 */
		for (int i = 0; i < idArray.length; i++) {
			/*
			 * 删除已分班 访谈记录不做限制 if(hasInterview(Integer.valueOf(idArray[i]),
			 * Integer.valueOf(profOrgIdArray[i]))) { errorMap.put(index, "学员："
			 * + nameArray[i] + "有访谈记录， 请先删除访谈记录"); index ++; }
			 */
/*			if (hasInspect(Integer.valueOf(idArray[i]), Integer.valueOf(gradeOrgIdArray[i]),
					Integer.valueOf(profOrgIdArray[i]))) {
				errorMap.put(index, "学员：" + nameArray[i] + "有考勤记录， 请先删除考勤记录");
				index++;
			}
			if (hasAssignment(Integer.valueOf(idArray[i]), Integer.valueOf(gradeOrgIdArray[i]),
					Integer.valueOf(profOrgIdArray[i]))) {
				errorMap.put(index, "学员：" + nameArray[i] + "有作业记录， 请先删除作业记录");
				index++;
			}*/
			
			if (hasInspect(Integer.valueOf(idArray[i]), Integer.valueOf(gradeOrgIdArray[i]), Integer.valueOf(profOrgIdArray[i]))) {
				DelAttenParamsVO parms = new DelAttenParamsVO();
				parms.setStuId(Integer.valueOf(idArray[i]));
				parms.setClassId(Integer.valueOf(gradeOrgIdArray[i]));
				int res = inspectDetailSqlMapper.updateRecordByParams(parms);
				if (res == 0) {
					errorMap.put(index, "学员：" + nameArray[i] + "更新考勤记录失败");
					index++;
				}
			}
			if (hasAssignment(Integer.valueOf(idArray[i]), Integer.valueOf(gradeOrgIdArray[i]), Integer.valueOf(profOrgIdArray[i]))) {
			
				int res = schoolAssignmentDetailSqlMapper.updateRecordByParams(Integer.valueOf(idArray[i]), Integer.valueOf(gradeOrgIdArray[i]), Integer.valueOf(profOrgIdArray[i]));
				if (res == 0) {
					errorMap.put(index, "学员：" + nameArray[i] + "更新作业记录失败");
					index++;
				}
			}
			
			
			
		}
		if (errorMap.isEmpty()) {
			for (int i = 0; i < gradeIdArray.length; i++) {
				StudentClass sc = new StudentClass();
				sc.setId(Integer.valueOf(gradeIdArray[i]));
				sc.setModifyTime(new Date());
				sc.setModifyUser(paramsVO.getCreator());
				sc.setIsValid("N");
				studentClassMapper.updateByPrimaryKeySelective(sc);
			}
			msg.setResult(true);
		} else {
			msg.setResult(false);
			// msg.setMsg(errorMap.toString());
			msg.setMsg("该学员专业没有分配班级考勤/作业！");
		}
		return msg;
	}

	private boolean hasInspect(int id, int gradeOrgId, int profOrgId) {// 考勤
		int res = inspectDetailSqlMapper.selectCountByStudentId(id, gradeOrgId, profOrgId);
		if (res == 0) {
			return false;
		}
		return true;
	}

	private boolean hasAssignment(int id, int gradeOrgId, int profOrgId) {// 作业
		int res = schoolAssignmentDetailSqlMapper.selectCountByStudentId(id, gradeOrgId, profOrgId);
		if (res == 0) {
			return false;
		}
		return true;
	}

	private boolean hasInterview(int id, int profOrgId) {
		int res = interviewsSqlMapper.selectByStudentId(id, profOrgId);
		if (res == 0) {
			return false;
		}
		return true;
	}

	public String selectGradeByStudentId(ParamsVO paramsVO) {
		return studentClassSqlMapper.selectGradeByStudentId(paramsVO);
	}

	public Message reDivideGrade(ParamsVO paramsVO) {
		logger.info("重新分班参数：paramsVO" + paramsVO);
		Message msg = new Message();
		msg.setResult(true);
		if (paramsVO.getIdArray() == null) {
			logger.error("登陆超时，请重新操作");
			msg.setResult(false);
			msg.setMsg("登陆超时，请重新操作");
			return msg;
		}
		String dataGradeOrgArray = studentClassSqlMapper.selectGradeByStudentId(paramsVO);
		if (dataGradeOrgArray == null) {
			String selectGradeOrgArray = paramsVO.getGradeOrgIdArray();
			String[] selectList = selectGradeOrgArray.split(",");
			for (String selectGradeId : selectList) {
				ParamsVO insertParam = new ParamsVO();
				insertParam.setIdArray(paramsVO.getIdArray());
				insertParam.setGradeOrgIdArray(selectGradeId);
				insertParam.setProfOrgId(paramsVO.getProfOrgId());
				insertParam.setCreator(paramsVO.getCreator());
				divideGrade(insertParam);
			}
			msg.setResult(true);
			msg.setMsg("分班成功！");
			return msg;

		}

		String[] getGradeOrgArray = paramsVO.getGradeOrgIdArray().split(",");
		String[] dataArray = dataGradeOrgArray.split(",");

		if (dataGradeOrgArray.equalsIgnoreCase(paramsVO.getGradeOrgIdArray())) {
			logger.info("用户并没有增减班级信息");
			msg.setResult(false);
			msg.setMsg("用户并没有增减班级信息");
			return msg;
		}

		/**
		 * 通过对比两个数组来确定哪些id需要插入新数据，哪些需要删除旧数据
		 */
		for (int i = 0; i < getGradeOrgArray.length; i++) {
			if (dataGradeOrgArray.contains(getGradeOrgArray[i])) {
				// 如果数据库中该学员已有这个班级信息
				continue;
			} else {
				// 如果数据库中没有该班级信息，则需要重新插入
				ParamsVO insertParam = new ParamsVO();
				insertParam.setIdArray(paramsVO.getIdArray());
				insertParam.setGradeOrgIdArray(getGradeOrgArray[i]);
				insertParam.setProfOrgId(paramsVO.getProfOrgId());
				insertParam.setCreator(paramsVO.getCreator());
				divideGrade(insertParam);
			}
		}
		for (int i = 0; i < dataArray.length; i++) {
			if (paramsVO.getGradeOrgIdArray().contains(dataArray[i])) {
				// 如果前端选择的班级id包含数据库中原有的班级id
				continue;
			} else {
				// 如果前端选择的班级id， 没有数据库中原有的班级id， 就需要删除数据库中的班级id
				ParamsVO delParam = new ParamsVO();
				delParam.setIdArray(paramsVO.getIdArray());
				delParam.setNameArray(paramsVO.getNameArray());
				delParam.setProfOrgId(paramsVO.getProfOrgId());
				delParam.setGradeOrgIdArray(dataArray[i]);// dataArray 班级id，
															// 区别于班级信息id
				int gradeInfoId = studentClassSqlMapper.selectGradeInfoId(delParam);
				delParam.setGradeIdArray(String.valueOf(gradeInfoId));// 班级信息的id
				delParam.setProfOrgIdArray(paramsVO.getProfOrgId().toString());
				delParam.setCreator(paramsVO.getCreator());
				msg = delDivedStudent(delParam);
				if (!msg.isResult()) {
					msg.setMsg("该学员分配班级没有考勤记录或作业记录，更新失败！");
				}
			}
		}
		return msg;
	}

	public Message reDivideGradeConfirm(ParamsVO paramsVO) {
		Message msg = new Message();
		Map<Integer, String> errorMap = new HashMap<Integer, String>();
		String[] idArray = paramsVO.getIdArray().split(",");
		String[] nameArray = paramsVO.getNameArray().split(",");
		Integer profOrgId = paramsVO.getProfOrgId();
		int index = 0;
		String dataGradeOrgArray = studentClassSqlMapper.selectGradeByStudentId(paramsVO);
		if (dataGradeOrgArray == null) {
			String selectGradeOrgArray = paramsVO.getGradeOrgIdArray();
			String[] selectList = selectGradeOrgArray.split(",");
			for (String selectGradeId : selectList) {
				ParamsVO insertParam = new ParamsVO();
				insertParam.setIdArray(paramsVO.getIdArray());
				insertParam.setGradeOrgIdArray(selectGradeId);
				insertParam.setProfOrgId(paramsVO.getProfOrgId());
				insertParam.setCreator(paramsVO.getCreator());
				divideGrade(insertParam);
			}
			msg.setResult(true);
			msg.setMsg("分班成功！");
			return msg;

		}
		String[] gradeOrgIdArray = dataGradeOrgArray.split(",");

		/**
		 * 判断是否有访谈记录、作业记录和考勤记录
		 */
		for (int i = 0; i < idArray.length; i++) {
			/*
			 * 删除已分班 访谈记录不做限制 if(hasInterview(Integer.valueOf(idArray[i]),
			 * profOrgId)) { errorMap.put(index, "学员：" + nameArray[i] +
			 * "有访谈记录， 请先删除访谈记录"); index ++; }
			 */
			if (hasInspect(Integer.valueOf(idArray[i]), Integer.valueOf(gradeOrgIdArray[i]), profOrgId)) {
				
				DelAttenParamsVO parms = new DelAttenParamsVO();
				parms.setStuId(Integer.valueOf(idArray[i]));
				parms.setClassId(Integer.valueOf(gradeOrgIdArray[i]));
				int res = inspectDetailSqlMapper.updateRecordByParams(parms);
				if (res == 0) {
					errorMap.put(index, "学员：" + nameArray[i] + "更新考勤记录失败");
					index++;
				}
			}
			if (hasAssignment(Integer.valueOf(idArray[i]), Integer.valueOf(gradeOrgIdArray[i]), profOrgId)) {
			
				int res = schoolAssignmentDetailSqlMapper.updateRecordByParams(Integer.valueOf(idArray[i]), Integer.valueOf(gradeOrgIdArray[i]), profOrgId);
				if (res == 0) {
					errorMap.put(index, "学员：" + nameArray[i] + "更新作业记录失败");
					index++;
				}
			}
		}
		if (!errorMap.isEmpty()) {
			msg.setResult(false);
			// msg.setMsg(errorMap.toString());
			msg.setMsg("该学员专业没有分配班级有考勤/作业！");
			return msg;
		}
		msg.setResult(true);
		return msg;
	}

}
