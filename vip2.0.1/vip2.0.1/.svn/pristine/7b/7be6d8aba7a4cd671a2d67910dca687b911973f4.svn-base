package com.moon.vip.controller.sys;

import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.moon.vip.infra.vo.EmployeeLoginVO;
import com.moon.vip.infra.vo.RoleVO;
import com.moon.vip.infra.vo.sys.MenuVO;
import com.moon.vip.service.sys.IMenuService;

/**
 * 
 * @ClassName: MenuController 
 * @Description: TODO(获取主菜单和子菜单) 
 * @author 大枫 
 * @date 2015年12月24日 上午11:05:11 
 *
 */
@Controller
@RequestMapping("/admin/menu")
public class MenuController {
	
	
	
	@Autowired
	private IMenuService menuService;
	
	private Logger logger = Logger.getLogger(MenuController.class);
	/**
	 * 
	 * 导航菜单页面<BR>
	 * 方法名：left<BR>
	 * 创建人：chenhai <BR>
	 * 时间：2015年8月11日-上午10:55:26 <BR>
	 * @return ModelAndView<BR>
	 * @param  [参数1]   [参数1说明]
	 * @param  [参数2]   [参数2说明]
	 * @exception <BR>
	 * @since  1.0.0
	 */	
	@RequestMapping("/left")
	public ModelAndView left() {
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("/page/sys/left");
		return modelAndView;
	}
	/**
	 * 获取主菜单<br/> 
	 * @Title: getMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月24日 上午11:07:40  <br/> 
	 * @param session
	 * @return
	 * List<MenuVO>
	 * @throws  <br/>
	 */
	@RequestMapping(value="/getMenu",method=RequestMethod.GET)
	@ResponseBody
	public List<MenuVO> getMenu(HttpSession session) {
		EmployeeLoginVO employeeVO = (EmployeeLoginVO) session.getAttribute("employee");
		List<RoleVO> roleList = employeeVO.getRoleList();
		HashSet<Integer> roles = menuService.getRolesStr(roleList);
		List<MenuVO> menu = menuService.getMenu(roles);
		return menu;
	}
	
	/**
	 * 获取子菜单<br/> 
	 * @Title: getSubMenu <br/> 
	 * @Description: TODO <br/> 
	 * @auther hanfeng <br/> 
	 * @version 创建时间：2015年12月24日 上午11:08:00  <br/> 
	 * @param session
	 * @return
	 * List<MenuVO>
	 * @throws  <br/>
	 */
	@RequestMapping(value="/getSubMenu",method=RequestMethod.GET)
	@ResponseBody
	public List<MenuVO> getSubMenu( HttpSession session) {
		
		EmployeeLoginVO employeeVO = (EmployeeLoginVO) session.getAttribute("employee");
		List<RoleVO> roleList = employeeVO.getRoleList();
		HashSet<Integer> roles = menuService.getRolesStr(roleList);
		List<MenuVO> menu = menuService.getSubMenu(roles);
		return menu;
	}	

}
