package com.moon.vip.service.impl.sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.moon.vip.application.student.StudentProfessionalSqlMapper;
import com.moon.vip.application.sys.CodeTableSqlMapper;
import com.moon.vip.application.sys.ProfessionSequenceSqlMapper;
import com.moon.vip.infra.constants.EnumCodeException;
import com.moon.vip.infra.constants.SysConstantsVal;
import com.moon.vip.infra.exception.BusinessException;
import com.moon.vip.infra.vo.student.CodeTableVO;
import com.moon.vip.infra.vo.sys.SequenceVO;
import com.moon.vip.service.sys.IProfessionSquenceService;

@Service("professionSquenceService")
public class ProfessionSquenceServiceImpl implements IProfessionSquenceService{

	private static Logger logger = Logger.getLogger(ProfessionSquenceServiceImpl.class);
	@Autowired
	private ProfessionSequenceSqlMapper professionSequenceSqlMapper;
	@Autowired
	private StudentProfessionalSqlMapper studentProfessionalSqlMapper;
	@Autowired
	private CodeTableSqlMapper codeTableSqlMapper;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	
	public SequenceVO selectSequence(SequenceVO sequenceVO) {
		return professionSequenceSqlMapper.selectSequence(sequenceVO);
	}

	public int updateSequence(SequenceVO sequenceVO) {
		return professionSequenceSqlMapper.updateSequence(sequenceVO);
	}

	public int insertSequence(SequenceVO sequenceVO) {
		return professionSequenceSqlMapper.insertSequence(sequenceVO);
	}

	/***按报名时间生成专业编号（报名时间(年月yyyy-MM)和专业id）***/
	public String getStudentCode(Date enterDate,Integer professionId){
		if(enterDate == null || professionId == null) {
			throw new BusinessException(EnumCodeException.E0011);
		}
		logger.info(String.format("传入的报名时间: %s, 专业ID为: %s", sdf.format(enterDate), professionId));
		String enterDateStr = sdf.format(enterDate);
		SequenceVO sequenceVO = new SequenceVO();
		sequenceVO.setProduceDate(enterDateStr);
		sequenceVO.setProfessionId(professionId);
		SequenceVO querySequence = selectSequence(sequenceVO);
		if(querySequence == null) {
			logger.info("在学员专业序列号表，插入新记录");
			sequenceVO.setSequence(0);
			insertSequence(sequenceVO);
			return cycle(enterDateStr, sequenceVO);
		}
		return cycle(enterDateStr, querySequence);
	}
	
	 /**
	 * 日期：2016年1月20日 上午11:00:15<br/>
	 * 描述：根据报名时间，当前序列号 返回学员编号<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:00:15 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @param enterDateStr
	 * @param professinalId
	 * @param seq
	 * @return<br/>
	 * String
	 */
	private String produceSequence(String enterDateStr, Integer professinalId, Integer seq) {
		String[] enter = enterDateStr.split("-");
		if(enter.length != 2) {
			throw new BusinessException(EnumCodeException.E0012);
		}
		StringBuilder seqBuilder = new StringBuilder();
		if(queryProfessionalPrexf().get(professinalId) == null) {
			throw new BusinessException(EnumCodeException.E0013);
		}
		//学生专业好添加前缀、年、月
		seqBuilder.append(queryProfessionalPrexf().get(professinalId)).append(enter[0]).append(enter[1]);
		String seqStr =seq.toString();
		if(seqStr.length() < SysConstantsVal.SEQ_LENGTH) {
			for(int i = seqStr.length(); i < SysConstantsVal.SEQ_LENGTH; i++) {
				seqBuilder.append("0");
			}
		}
		seqBuilder.append(seqStr);
		logger.info(String.format("生成的学员专业编号: %s", seqBuilder));
		return seqBuilder.toString();
	}
	
	 /**
	 * 日期：2016年1月20日 上午11:34:16<br/>
	 * 描述：查询码表中专业前缀信息，并将其转换为map<br/>
	 * 修改说明（时间、人）：<br/>
	 * 上午11:34:16 Roy <br/>
	 * 修改备注：TODO<br/>
	 * @return<br/>
	 * Map<Integer,String>
	 */
	private Map<Integer, String> queryProfessionalPrexf() {
		List<CodeTableVO> codeTableList = codeTableSqlMapper.selectListByType(SysConstantsVal.PROFESSIONAL_PREX);
		Map<Integer, String> codeTableMap = Maps.newHashMap();
		for(CodeTableVO codeTable : codeTableList) {
			if(codeTable.getCodeKey() != null && codeTable.getCodeValue() != null) {
				codeTableMap.put(Integer.parseInt(codeTable.getCodeKey()), codeTable.getCodeValue());
			}
		}
		return codeTableMap;
	}

	/*****当生成的编号存在时，循环判断，直到取出不重复的学员专业编号*****/
	private String cycle(String enterDateStr, SequenceVO sequenceVO) {
		SequenceVO newSequence = selectSequence(sequenceVO);
		String studentCode = produceSequence(enterDateStr, sequenceVO.getProfessionId(), newSequence.getSequence() + 1);
		updateSequence(newSequence);
		List<Integer> studentIdList = studentProfessionalSqlMapper.getStudentIdByCode(studentCode);
		if(studentIdList == null || studentIdList.size() == 0){
			return studentCode;
		}
		newSequence = selectSequence(newSequence);
		try {
			Thread.sleep(300L);
		} catch (InterruptedException e) {
			logger.error(e.getLocalizedMessage());
		}
		return cycle(enterDateStr, newSequence);
	}
	
}
