package com.moon.vip.service.impl.assignment;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.assignment.HomeworkSqlMapper;
import com.moon.vip.infra.vo.homework.StudentHmworkVO;
import com.moon.vip.service.assignment.IClassService;

@Service("classService")
public class ClassServiceImpl implements IClassService {
	private static Logger logger = Logger.getLogger(ClassServiceImpl.class);
	@Autowired
	private HomeworkSqlMapper hmworkSqlMapper;

	public List<StudentHmworkVO> getAllStudentsByClassId(int classId) {
		logger.info(String.format("查询班级[%d]学生",classId));
		return hmworkSqlMapper.findStudentsByClassId(classId);
	}

}
