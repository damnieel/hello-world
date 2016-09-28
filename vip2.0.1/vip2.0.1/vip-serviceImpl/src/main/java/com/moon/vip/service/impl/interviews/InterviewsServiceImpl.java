package com.moon.vip.service.impl.interviews;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.moon.vip.application.interviews.InterviewsMapper;
import com.moon.vip.application.interviews.InterviewsSqlMapper;
import com.moon.vip.application.sys.OPManagerSqlMapper;
import com.moon.vip.infra.vo.interviews.InterviewsVO;
import com.moon.vip.infra.vo.interviews.OPManagerVO;
import com.moon.vip.infra.vo.student.StudentVO;
import com.moon.vip.infra.vo.sys.SearchVO;
import com.moon.vip.model.interviews.Interviews;
import com.moon.vip.service.interviews.IInterviewsService;
import com.moon.vip.service.sys.IOrgProfessionalService;

@Service("iInterviewsService")
public class InterviewsServiceImpl implements IInterviewsService {
	@Autowired
	InterviewsMapper interviewsMapper;
	@Autowired
	InterviewsSqlMapper interviewsSqlMapper;
	@Autowired
	OPManagerSqlMapper oPManagerSqlMapper;
	@Autowired
	private IOrgProfessionalService iOrgProfessionalService;
	
	private static final String MAKINGMONEY="为了挣钱，找个好工作";
	private static final String WORKNEED="工作需要";
	private static final String CARVEOUT="创业";
	private static final String INTERESTING="对课程感兴趣";
	private static final String OTHER="其他";

	public List<InterviewsVO> getAllInterviewsInfo(SearchVO searchVO) {
		if(null==searchVO){
			return interviewsSqlMapper.selectInterviewItems(null);
		}
		searchVO = convertOrgId(searchVO);
		if(null != searchVO.getKeyWord()){
			String keyWord = "%"+searchVO.getKeyWord()+"%";
			searchVO.setKeyWord(keyWord);
		}
		return interviewsSqlMapper.selectInterviewItems(searchVO);
	}

	public int findItemsCount(SearchVO searchVO) {
		
		searchVO = convertOrgId(searchVO);
		
		if(null==searchVO){
			return interviewsSqlMapper.selectItemsCount(null);
		}
		if(null != searchVO.getKeyWord()){
			String keyWord = "%"+searchVO.getKeyWord()+"%";
			searchVO.setKeyWord(keyWord);
		}
		return interviewsSqlMapper.selectItemsCount(searchVO);
	}
	
	public int deleteInterviewsById(List<Integer> idList) {
		return interviewsSqlMapper.deleteInterviewsById(idList);
	}

	public int updateInterviewsInfo(InterviewsVO interview) {
		Interviews record=new Interviews();
		record=interviewsMapper.selectByPrimaryKey(interview.getId());
		record.setLearnAimCode(interview.getLearnAimCode());
		switch (interview.getLearnAimCode()) {
		case 1:record.setLearnAimContent(MAKINGMONEY);
			break;
		case 2:record.setLearnAimContent(WORKNEED);
			break;
		case 3:record.setLearnAimContent(CARVEOUT);
			break;
		case 4:record.setLearnAimContent(INTERESTING);
			break;
		case 5:record.setLearnAimContent(interview.getLearnAimContent());
			break;
		default:record.setLearnAimContent(OTHER);
			break;
		}
		
		record.setNote(interview.getNote());
	    record.setSuggest(interview.getSuggest());
		record.setPuzzle(interview.getPuzzle());
		record.setInterviewTime(interview.getInterviewTime());
		return interviewsMapper.updateByPrimaryKeySelective(record);
	}
   
	public InterviewsVO findInterviewsInfo(int id) {
		return interviewsSqlMapper.selectInterviewItem(id);
	}
	
	public int insertInterviewsInfo(Interviews record) {
		switch (record.getLearnAimCode()) {
		case 1:record.setLearnAimContent(MAKINGMONEY);
			break;
		case 2:record.setLearnAimContent(WORKNEED);
			break;
		case 3:record.setLearnAimContent(CARVEOUT);
			break;
		case 4:record.setLearnAimContent(INTERESTING);
			break;
		case 5:record.setLearnAimContent(record.getLearnAimContent());
			break;
		default:record.setLearnAimContent(OTHER);
			break;
		}
		return interviewsMapper.insertSelective(record);
	}

	public List<InterviewsVO> getAllBaseInfo(String qq) {
		if(StringUtils.isEmpty(qq)){
			return null;
		}
		List<InterviewsVO> list=interviewsSqlMapper.selectAddBaseInfoByQq(qq);
		return list;
	}

	public List<OPManagerVO> getAllTeacherCode(int professionId) {
		List<OPManagerVO> list=oPManagerSqlMapper.selectByProfessionId(professionId);
		return list;
	}

	public String findProfessionCode(String qq, int id) {
		return interviewsSqlMapper.selectProfessionCode(id, qq);
	}
	
	/***解析组织机构**/
	private SearchVO convertOrgId(SearchVO searchVO){
		if(searchVO.getOrganizationId()!=0){
			searchVO.setSearchOpClaIds(
					iOrgProfessionalService.covertOrgSearch(searchVO.getOrganizationId()));
		}
		return searchVO;
	}

}
