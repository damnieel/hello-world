package com.moon.vip.application.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.interviews.OPManagerVO;
import com.moon.vip.infra.vo.sys.ClassManagerVO;


public interface OPManagerSqlMapper {
	List<OPManagerVO> selectByProfessionId(@Param("professionId") Integer professionId);
    /**
      * 根据类型和班级Id修改班级管理人员<br/>
      * @Author：  陈海  - （怡宝 ）<br/>
      * @param userCode 
      * @Title: updateByClaIdAndType <br/>
      * @return int    返回类型 <br/>
      * @date 2016年1月19日 上午11:20:22 <br/>
      * @throws <br/>
      *
     */
	int updateByClaIdAndType(@Param("id")Integer orgId, @Param("empCode")String teachCode, @Param("type")String type, @Param("userCode")String userCode);
	
	
	/**
	  * 获取专业下管理者<br/>
	  * @Author：  陈海  - （怡宝 ）<br/>
	  * @Title: getProMag <br/>
	  * @return List<ClassManagerVO>    返回类型 <br/>
	  * @date 2016年1月22日 下午7:45:48 <br/>
	  * @throws <br/>
	  *
	 */
	List<ClassManagerVO> getProMag(@Param("type")String type, @Param("id")Integer proId);
}