package com.moon.vip.service.impl.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moon.vip.application.student.ProfessionalMapper;
import com.moon.vip.infra.vo.student.ProfessionalVO;
import com.moon.vip.service.student.IProfessionalService;

/**
 * 职业数据模块
 * ProfessionalServiceImpl<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月23日-下午8:05:05 <BR>
 * @version 1.0.0
 * 
 */
@Service("ProfessionalService")
public class ProfessionalServiceImpl implements IProfessionalService {
	
	@Autowired
	private ProfessionalMapper professionalMapper;

	/***展示全部职业数据***/
	public List<ProfessionalVO> selectAllProfessional(Integer offset, Integer pageSize) {
		return professionalMapper.selectAllProfessional(offset, pageSize);
	}

    /***获取总数***/
	public int selectProCount() {
		return professionalMapper.selectProCount();
	}
	
	/***添加职业数据***/
	public int insertProfessional(ProfessionalVO professionalVO) {
		return professionalMapper.insertProfessional(professionalVO);
	}
	
	/***查询码表中职业数据key和order的最大值***/
	public ProfessionalVO selectMaxKey() {
		return professionalMapper.selectMaxKey();
	}

	/***修改职业数据***/
	public int updateProfessional(ProfessionalVO professionalVO) {
		return professionalMapper.updateProfessional(professionalVO);
	}

	/***批量删除职业数据***/
	public int deleteProfessional(List<Integer> id) {
		return professionalMapper.deleteProfessional(id);
	}

	/***根据专业查询专业前缀（用于学员编号）***/
	public ProfessionalVO selectCoursePrefix(Integer course) {
		return professionalMapper.selectCoursePrefix(course);
	}
	
	/*** 查询所有下拉框中的值 （用于学员信息）***/
	public List<ProfessionalVO> selectALLDownbox() {
		return professionalMapper.selectALLDownbox();
	}

	/***根据id查看详情***/
	public ProfessionalVO selectDetail(Integer id) {
		return professionalMapper.selectDetail(id);
	}

	/***查询是否存在职业数据***/
	public int selectIsExist(String codeValue) {
		return professionalMapper.selectIsExist(codeValue);
	}


}
