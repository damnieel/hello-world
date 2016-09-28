package com.moon.vip.application.interviews;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.moon.vip.infra.vo.interviews.InterviewsVO;
import com.moon.vip.infra.vo.sys.SearchVO;

public interface InterviewsSqlMapper {
    
    List<InterviewsVO> selectInterviewItems(SearchVO searchVO);
    
    InterviewsVO selectInterviewItem(@Param("id")int id);
    
    List<InterviewsVO> selectAddBaseInfoByQq(@Param("qq")String qq);
    
    int selectItemsCount(SearchVO searchVO);
    
    String selectProfessionCode(@Param("id")int id,@Param("qq")String qq);
    
    int deleteInterviewsById(@Param("idList") List<Integer> idList);
    
	/**
	 * 判断该学员是否有访谈记录<br/> 
	 * @Title: selectByStudentId <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月29日 下午6:31:30  <br/> 
	 * @param id
	 * @return
	 * int
	 * @throws  <br/>
	 */
	public Integer selectByStudentId(@Param("id")int id, @Param("profOrgId")int profOrgId);
}