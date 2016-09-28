package com.moon.vip.application.student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.student.StudentClassVO;
import com.moon.vip.infra.vo.student.StudentFilesVO;
import com.moon.vip.infra.vo.student.StudentLearnStateVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.model.student.StudentProfessionalAttach;
/**
 * 
* @ClassName: StudentFilesMapper 
* @Description: TODO(学院档案mapper)  
* @Param:   
* @author qingyu <a href="mailto:2190234029@qq.com">dengrihui</a>
* @date 2016年1月8日 上午10:41:35 
*
 */
public interface StudentFilesMapper {
	/**
	 * 档案信息条目
	 */
	List<StudentFilesVO> selectFileList(SearchVO param);
	/**
	 * 档案信息条目总数
	 */
	int selectTotalRecord(SearchVO param);

	/**
	 * 个人信息
	 */
	StudentFilesVO selectFilesInfoById(@Param("id") Integer id);
	/**
	 * 更新基础信息
	 */
	int updateStudyBasisById(@Param("id") Integer id, @Param("stuBasis") String stuBasis);
	/**
	 * 专业情况信息
	 */
	StudentLearnStateVO selectLearningInfoById(@Param("id") Integer id);
	/**
	 * 班级信息
	 */
	List<StudentClassVO> selectClassInfoById(@Param("studentId") Integer studentId);
	/**
	 * 身份证
	 */
	StudentFilesVO selectIdCardPicById(@Param("id") Integer id);
	/**
	 *查询所有附件
	 */
	List<StudentProfessionalAttach> selectProfessionalAttach(@Param("spId") Integer spId,@Param("type") String type);
	
	StudentProfessionalAttach selectProfessionalAttachById(@Param("id") Integer id);
}