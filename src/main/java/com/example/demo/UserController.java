package com.example.demo;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Admin;
import com.example.demo.dto.UserInfoResponse;

@RestController
public class UserController {

	@RequestMapping("/user/me")
    public Principal user(Principal principal) {
        return principal;
    }
	
	@RequestMapping("/user/me2")
    public UserInfoResponse user2(Principal principal) {
		UserInfoResponse item = new UserInfoResponse();
		item.setUserPrincipal(principal.getName());
		item.setResult(true);
		item.setMessage("success");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		item.setAdmin((Admin)authentication.getPrincipal());
        return item;
    }
	
}
