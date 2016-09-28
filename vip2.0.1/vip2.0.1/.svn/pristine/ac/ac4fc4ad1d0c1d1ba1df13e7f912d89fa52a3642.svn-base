package com.moon.vip.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

	@RequestMapping("/notFoundException") 
	public String toNotFoundExceptionPage() {
		return "/page/error/notFoundException";
	}
	@RequestMapping("/error") 
	public String toErrorPage() {
		return "/page/error/error";
	}
	@RequestMapping("/noPower") 
	public String toNoPowerPage() {
		return "/page/error/noPower";
	}
}
