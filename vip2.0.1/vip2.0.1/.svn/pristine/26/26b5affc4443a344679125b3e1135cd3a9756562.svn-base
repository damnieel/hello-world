package com.moon.vip.service.student;

import java.util.List;

import com.moon.vip.infra.vo.student.StudentVO;

/**
 *  学员信息模块与重复数据模块
 * IStudentArchivesService<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月28日-下午8:48:35 <BR>
 * @version 1.0.0
 * 
 */
public interface IStudentArchivesSearchService {
	
	/**
     * 学员信息展示列表<BR>
     * 方法名：selectAllStudent<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月28日-下午8:35:42 <BR>
     * @return List<StudentVO><BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public	List<StudentVO> selectAllStudent(StudentVO studentVO);
    
    /**
     * 查询学员总数<BR>
     * 方法名：selectAllStudentCount<BR>
     * 创建人：娴贵 <BR>
     * 时间：2015年12月31日-下午8:01:56 <BR>
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int selectAllStudentCount(StudentVO studentVO);
    
    /**
     * 修改学员基础信息<BR>
     * 方法名：updateStudent<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年2月18日-上午10:44:45 <BR>
     * @param studentVO
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int updateStudent(StudentVO studentVO);
    
    /**
     * 验证修改后的学员信息是否存在<BR>
     * 方法名：selectStuExist<BR>
     * 创建人：娴贵 <BR>
     * 时间：2016年2月18日-下午3:48:46 <BR>
     * @param studentVO
     * @return int<BR>
     * @exception <BR>
     * @since  1.0.0
    */
    public int selectStuExist(StudentVO studentVO);
}
