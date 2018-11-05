package com.example.demo.dao;

import java.util.List;

import com.example.demo.dto.Admin;

public interface AdminDao {
	
	public Admin findAdmin(Admin admin);
	
	public List<String> findAuthorities(Admin admin);
	
}
