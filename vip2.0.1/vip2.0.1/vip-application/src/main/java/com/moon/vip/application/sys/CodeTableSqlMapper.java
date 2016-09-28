package com.moon.vip.application.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.student.CodeTableVO;

public interface CodeTableSqlMapper {
   
	public String selectByTypeAndCodeValue(@Param("type") String type, 
						@Param("codeValue") String codeValue);
	
	public String selectByTypeAndCodeKey(@Param("type") String type, 
						@Param("codeKey") String codeKey);
	public List<CodeTableVO> selectListByType(@Param("type") String type);
}