package com.moon.vip.service.student;

import java.util.List;

import com.moon.vip.infra.vo.Message;
import com.moon.vip.infra.vo.student.StudentClassVO;
import com.moon.vip.infra.vo.student.StudentFilesVO;
import com.moon.vip.infra.vo.student.StudentLearnStateVO;
import com.moon.vip.infra.vo.student.StudentProfessionalVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.model.student.StudentClass;
import com.moon.vip.model.student.StudentProfessional;
import com.moon.vip.model.student.StudentProfessionalAttach;

public interface IStudentFilesService {
	
	public List<StudentFilesVO> getAllFileInfo(SearchVO param);
	
	public int selectTotalRecord(SearchVO param);
	
	public StudentFilesVO getStudentFilesInfo(Integer id);

	public int updateStudyBasis(Integer id, String stuBasis);

	public StudentLearnStateVO getLearningStateInfo(Integer id);

	public List<StudentClassVO> getStudentClassInfo(Integer studentId);
	
	public Message updateLearningStateInfo(StudentProfessional record,List<Integer> idList,List<Double> scList);
	
	public Message updateLearningStateInfo(StudentProfessional record);
	
	public int updateStudentClassInfo(StudentClass record);
	
	public StudentFilesVO getIdCardPic(Integer id);
	
	public int insertProfessionalAttach(StudentProfessionalAttach attach);
	
	public int deleteProfessionalAttach(Integer id);
	
	public List<StudentProfessionalAttach> queryProfessionalAttach(Integer spId,String type);
}
