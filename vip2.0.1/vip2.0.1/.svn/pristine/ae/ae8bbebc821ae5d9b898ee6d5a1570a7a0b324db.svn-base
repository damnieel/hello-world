package com.moon.vip.controller.student;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.infra.constants.IsValidType;
import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.student.ProfessionalVO;
import com.moon.vip.service.student.IProfessionalService;

/**
 * 职业数据模块 ProfessionalController<BR>
 * 创建人:娴贵 <BR>
 * 时间：2015年12月23日-下午8:15:10 <BR>
 * 
 * @version 1.0.0
 * 
 */
@Controller
@RequestMapping("/professional/professional")
public class ProfessionalController {

	@Autowired
	private IProfessionalService iProfessionalService;

	/**
	 * 职业数据页面<BR>
	 * 方法名：Professional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午8:17:10 <BR>
	 * 
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	@RequestMapping("/professionalList")
	public ModelAndView professionalList() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/page/professional/professionalList");
		return mv;
	}

	/**
	 * 职业数据模板页<BR>
	 * 方法名：ProfessionalTemplate<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午8:18:14 <BR>
	 * 
	 * @return ModelAndView<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/professionalTemplate")
	public ModelAndView professionalTemplate(ProfessionalVO professionalVO) {
		ModelAndView mv = new ModelAndView();
		List<ProfessionalVO> professionalVOs = iProfessionalService.selectAllProfessional(professionalVO.getOffset(),
				professionalVO.getPageSize());
		int count = iProfessionalService.selectProCount();
		// mv.addObject("offset", professionalVO.getOffset());
		mv.addObject("count", count);
		mv.addObject("list", professionalVOs);
		mv.setViewName("/page/professional/professionalTemplate");
		return mv;
	}
   /**
    * 
    * 描述：专业总数<br/>
    * 日期：2016年7月1日 上午9:35:01<br/>
    * 修改说明（时间、人）：<br/>
    * @author qinyu <br/>
    * 修改备注：TODO<br/>
    * @param professionalVO
    * @return<br/>
    * int
    */
	@RequestMapping(value = "/professinalCount")
	@ResponseBody
	public int professinalCount(ProfessionalVO professionalVO) {
		int count = iProfessionalService.selectProCount();
		return count;
	}

	/**
	 * 添加职业数据<BR>
	 * 方法名：insertProfessional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午8:29:44 <BR>
	 * 
	 * @return int<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	@RequestMapping("/insertProfessional")
	@ResponseBody
	public String insertProfessional(HttpSession session, ProfessionalVO professionalVO) {
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
		ProfessionalVO vo = iProfessionalService.selectMaxKey();
		/*** 查询是否有职业数据 ***/
		if (vo != null) {
			int a = Integer.valueOf(vo.getCodeKey()) + 1;
			int b = vo.getCodeOrder() + 1;
			professionalVO.setCodeKey(String.valueOf(a));
			professionalVO.setCodeValue(professionalVO.getCodeValue());
			professionalVO.setCodeOrder(b);
		} else {
			professionalVO.setCodeKey("1");
			professionalVO.setCodeValue(professionalVO.getCodeValue());
			professionalVO.setCodeOrder(1);
		}
		professionalVO.setType("professional");
		professionalVO.setTypeName("职业");
		professionalVO.setCreateTime(new Date());
		professionalVO.setCreator(employee.getEmployeeCode());
		professionalVO.setModifyTime(new Date());
		professionalVO.setIsValid(IsValidType.Y_VALUE);
		int count = iProfessionalService.selectIsExist(professionalVO.getCodeValue());
		if (count == 0) {
			int i = iProfessionalService.insertProfessional(professionalVO);
			if (i > 0) {
				return "success";
			}
		}
		return "fail";
	}

	/**
	 * 修改职业数据<BR>
	 * 方法名：updateProfessional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午8:32:45 <BR>
	 * 
	 * @return int<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	@RequestMapping("/updateProfessional")
	@ResponseBody
	public String updateProfessional(ProfessionalVO professionalVO, HttpSession session) {
		EmployeeLoginVO employee = (EmployeeLoginVO) session.getAttribute("employee");
		professionalVO.setCreator(employee.getEmployeeCode());
		professionalVO.setCreateTime(new Date());
		int count = iProfessionalService.selectIsExist(professionalVO.getCodeValue());
		if (count == 0) {
			if (professionalVO.getId() != 0) {
				int i = iProfessionalService.updateProfessional(professionalVO);
				if (i > 0) {
					return "success";
				}
			}
		}
		return "fail";
	}

	/**
	 * 批量删除职业数据<BR>
	 * 方法名：deleteProfessional<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2015年12月23日-下午8:31:37 <BR>
	 * 
	 * @return int<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	@RequestMapping("/deleteProfessional")
	@ResponseBody
	public String deleteProfessional(ProfessionalVO professionalVO) {
		String id2 = professionalVO.getDegree();
		String[] id1 = id2.split(",");
		List<Integer> id = new ArrayList<Integer>();
		for (int i = 0; i < id1.length; i++) {
			id.add(Integer.valueOf(id1[i]));
		}
		int i = iProfessionalService.deleteProfessional(id);
		if (i > 0) {
			return "success";
		}
		return "fail";
	}

	/**
	 * 查看详情<BR>
	 * 方法名：selectDetail<BR>
	 * 创建人：娴贵 <BR>
	 * 时间：2016年1月8日-下午5:07:58 <BR>
	 * 
	 * @param id
	 * @return String<BR>
	 * @exception <BR>
	 * @since 1.0.0
	 */
	@RequestMapping(value = "/selectDetail/{id}")
	@ResponseBody
	public Map<Integer, Object> selectDetail(@PathVariable("id") Integer id) {
		ProfessionalVO vo = iProfessionalService.selectDetail(id);
		String ss = vo.getCodeValue();
		int ids = vo.getId();
		Map<Integer, Object> m = new HashMap<Integer, Object>();
		m.put(1, ss);
		m.put(2, ids);
		return m;
	}

}
