package com.moon.vip.service.interviews;

import java.util.List;

import com.moon.vip.infra.vo.interviews.InterviewsVO;
import com.moon.vip.infra.vo.interviews.OPManagerVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.model.interviews.Interviews;

public interface IInterviewsService {
	public List<InterviewsVO> getAllInterviewsInfo(SearchVO searchVO);

	public int findItemsCount(SearchVO searchVO);

	public int deleteInterviewsById(List<Integer> idList);

	public int updateInterviewsInfo(InterviewsVO interview);

	public InterviewsVO findInterviewsInfo(int id);

	public int insertInterviewsInfo(Interviews record);

	public List<InterviewsVO> getAllBaseInfo(String qq);
	
	public String findProfessionCode(String qq,int id);

	public List<OPManagerVO> getAllTeacherCode(int professionId);
}
