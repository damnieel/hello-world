package com.moon.vip.service.impl.student;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.student.StudentArchivesSearchSqlMapper;
import com.moon.vip.infra.vo.student.StudentVO;
import com.moon.vip.service.student.IStudentArchivesSearchService;

/**
 * 学员信息模块与重复数据模块
 * StudentArchivesServiceImpl<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月28日-下午8:55:01 <BR>
 * @version 1.0.0
 * 
 */
@Service("StudentArchivesSearchService")
public class StudentArchivesSearchServiceImpl implements IStudentArchivesSearchService{
	private static Logger logger = Logger.getLogger(StudentArchivesSearchServiceImpl.class);
	
	@Autowired
	private StudentArchivesSearchSqlMapper studentArchivesSqlMapper;

	
	/***学员信息展示列表***/
	public List<StudentVO> selectAllStudent(StudentVO studentVO) {
		return studentArchivesSqlMapper.selectAllStudent(studentVO);
	}

	/*** 查询学员总数***/
    public int selectAllStudentCount(StudentVO studentVO){
    	return studentArchivesSqlMapper.selectAllStudentCount(studentVO);
    }

    /***修改学员基础信息***/
	public int updateStudent(StudentVO studentVO) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(new Date());
		logger.info("信息修改时间："+s+"信息修改人："+studentVO.getModifyUser());
		return studentArchivesSqlMapper.updateStudent(studentVO);
	}
	
	/***验证修改后的学员信息是否存在***/
	public int selectStuExist(StudentVO studentVO) {
		return studentArchivesSqlMapper.selectStuExist(studentVO);
	}


}
