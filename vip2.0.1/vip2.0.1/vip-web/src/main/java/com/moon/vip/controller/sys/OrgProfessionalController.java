package com.moon.vip.controller.sys;

import java.util.HashSet;
import java.util.TreeSet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.moon.vip.controller.BaseController;
import com.moon.vip.service.sys.IOrgProfessionalService;
import com.moon.vip.service.sys.IRuleService;

/**
 * 
* @ClassName: OrgProfessionalController 
* @Description: TODO(联动下拉框)  
* @Param:   
* @author qingyu <a href="mailto:2190234029@qq.com">dengrihui</a>
* @date 2016年1月4日 下午4:30:01 
*
 */
@Controller
@RequestMapping("/orgProfessional")
public class OrgProfessionalController extends BaseController {
	@Autowired
	private IOrgProfessionalService orgProfessionalService;
	private final Integer supperRole=1;
	 @Autowired
	  private IRuleService ruleService;
	@RequestMapping(value ="/showComboBox")
	@ResponseBody
	private JSONArray showComboBox(HttpSession session) throws Exception{
		HashSet<Integer> authSet = super.achieveAuth();
		if (authSet.contains(supperRole)) {
			authSet.clear();
			authSet.add(supperRole);
		}
		JSONArray array=new JSONArray();
		String text=orgProfessionalService.convertAuthToJSONArray(authSet);
		array=JSONArray.parseArray(text);
		return array;
	}
}
