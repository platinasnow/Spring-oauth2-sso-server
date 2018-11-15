package com.example.demo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Admin implements UserDetails {

	private Integer idx;
	private String id;
	private String password;
	private String changePassword;
	private String name;
	private String email;
	private String dept;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private String role;
	private String lockedYn;
	private int lockCount;
	private String passInitYn;
	private Date lastLoginDate;
	private String authority;
	@JsonIgnore
	private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	private List<String> authList; /* ���Ѹ���Ʈ */
	private boolean enabled = true;
	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;

	private Date regDate;
	private String regId;
	private Date uptDate;
	private String uptId;

	public Admin() {
	}

	public Admin(boolean enabled) {
		this.enabled = enabled;
	}

	public Admin(Integer idx, String id, String name, String password, String role, List<GrantedAuthority> authorities, boolean accountNonExpired,
			boolean accountNonLocked, boolean enabled) {
		super();
		this.idx = idx;
		this.id = id;
		this.name = name;
		this.password = password;
		this.role = role;
		this.authorities = (List<GrantedAuthority>) authorities;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.enabled = enabled;
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLockedYn() {
		return lockedYn;
	}

	public void setLockedYn(String lockedYn) {
		this.lockedYn = lockedYn;
	}

	public int getLockCount() {
		return lockCount;
	}

	public void setLockCount(int lockCount) {
		this.lockCount = lockCount;
	}

	public String getPassInitYn() {
		return passInitYn;
	}

	public void setPassInitYn(String passInitYn) {
		this.passInitYn = passInitYn;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getRegId() {
		return regId;
	}

	public void setRegId(String regId) {
		this.regId = regId;
	}

	public Date getUptDate() {
		return uptDate;
	}

	public void setUptDate(Date uptDate) {
		this.uptDate = uptDate;
	}

	public String getUptId() {
		return uptId;
	}

	public void setUptId(String uptId) {
		this.uptId = uptId;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public List<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public List<String> getAuthList() {
		return authList;
	}

	public void setAuthList(List<String> authList) {
		this.authList = authList;
	}

	@Override
	public String getUsername() {
		return this.id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public String getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(String changePassword) {
		this.changePassword = changePassword;
	}

}
