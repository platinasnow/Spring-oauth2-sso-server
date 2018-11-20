package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

	@GetMapping(value = "/exit")
	public String revokeToken(HttpServletRequest request, String redirectUrl) {
	    request.getSession().invalidate();
		return "redirect:"+redirectUrl;
	}
}
