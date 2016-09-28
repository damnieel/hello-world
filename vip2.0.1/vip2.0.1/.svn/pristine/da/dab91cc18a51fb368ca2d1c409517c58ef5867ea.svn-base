package com.moon.vip.controller.message;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.moon.socket.WebsocketEndPoint;
import com.moon.vip.controller.BaseController;


@Controller
@RequestMapping("/admin/websocket")
public class WebSocketController extends BaseController{
	
	
	@Autowired
	private WebsocketEndPoint websocketEndPoint;

//	@Bean  //这个注解会从Spring容器拿出Bean
//	public WebsocketEndPoint infoHandler() {
//		return new WebsocketEndPoint(null);
//	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		Integer username = 1;
		HttpSession session = request.getSession(true);
		session.setAttribute("userId", username);
		mv.setViewName("/page/login");
		return  mv;
	}

	@RequestMapping("/send")
	@ResponseBody
	public String send() {
		Integer username = (Integer) getSession().getAttribute("userId");
        System.out.println(username);
		websocketEndPoint.sendMessageToAll(("哈哈哈哈s"));
		websocketEndPoint.sendMessageToUser(username, ("你好，测试！！！！"));
		
		return null;
	}

}
 