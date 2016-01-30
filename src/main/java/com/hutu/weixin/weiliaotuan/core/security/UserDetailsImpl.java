package com.hutu.weixin.weiliaotuan.core.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6508254410693836L;

	private String password;
    private String username;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    /**
     * 姓名
     */
    private String trueName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 是否是初始密码
     */
    private boolean isInitPassword;

    private Collection<? extends GrantedAuthority> authorities;

    public Collection<? extends GrantedAuthority> getAuthorities() {
	return this.authorities;
    }

    public String getPassword() {
	return this.password;
    }

    public String getSex() {
	return this.sex;
    }

    public String getTrueName() {
	return this.trueName;
    }

    public String getUsername() {
	return this.username;
    }

    public boolean isAccountNonExpired() {
	return this.isAccountNonExpired;
    }

    public boolean isAccountNonLocked() {
	return this.isAccountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
	return this.isCredentialsNonExpired;
    }

    public boolean isEnabled() {
	return this.isEnabled;
    }

    public boolean isInitPassword() {
	return this.isInitPassword;
    }

    public void setAccountNonExpired(boolean isAccountNonExpired) {
	this.isAccountNonExpired = isAccountNonExpired;
    }

    public void setAccountNonLocked(boolean isAccountNonLocked) {
	this.isAccountNonLocked = isAccountNonLocked;
    }

    public void setAuthorities(
	    Collection<? extends GrantedAuthority> authorities) {
	this.authorities = authorities;
    }

    public void setCredentialsNonExpired(boolean isCredentialsNonExpired) {
	this.isCredentialsNonExpired = isCredentialsNonExpired;
    }

    public void setEnabled(boolean isEnabled) {
	this.isEnabled = isEnabled;
    }

    public void setIsInitPassword(boolean isInitPassword) {
	this.isInitPassword = isInitPassword;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public void setSex(String sex) {
	this.sex = sex;
    }

    public void setTrueName(String trueName) {
	this.trueName = trueName;
    }

    public void setUsername(String username) {
	this.username = username;
    }

}
