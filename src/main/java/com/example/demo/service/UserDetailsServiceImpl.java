package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminDao;
import com.example.demo.dto.Admin;

@Service("securityService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired private AdminDao adminDao;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Admin admin = new Admin();
		admin.setId(userName);
		admin = adminDao.findAdmin(admin);
		if(admin != null){
			//계정 잠김 상태 체크
			Boolean accountNonLocked = new Boolean(true);
			if("Y".equals(admin.getLockedYn())){	//계정 잠겨있는 상태
				accountNonLocked = false;
			}else{		//계정 잠겨있지 않은 상태
				accountNonLocked = true;
			}
			
			// 메뉴 권한 조회
			List<GrantedAuthority> authList = getAuthorities(adminDao.findAuthorities(admin));
			return new Admin(admin.getIdx(), userName, admin.getName(), admin.getPassword(), admin.getRole(), authList, true, accountNonLocked, true);
		}else{
			return new Admin(false);
		}
	}

	private List<GrantedAuthority> getAuthorities(List<String> authorities) {
		// 시큐리티 권한 setting
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		for(String auth : authorities){
			authList.add(new SimpleGrantedAuthority(auth));
		}
		return authList;
	}
	
}
