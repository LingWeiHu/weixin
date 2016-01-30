package com.hutu.weixin.weiliaotuan.core.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.hutu.weixin.weiliaotuan.core.domain.po.Role;
import com.hutu.weixin.weiliaotuan.core.domain.po.RoleUser;
import com.hutu.weixin.weiliaotuan.core.domain.po.User;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;
import com.hutu.weixin.weiliaotuan.core.service.RoleService;
import com.hutu.weixin.weiliaotuan.core.service.RoleUserService;
import com.hutu.weixin.weiliaotuan.core.service.UserService;
import com.hutu.weixin.weiliaotuan.core.util.CollectionUtility;
import com.hutu.weixin.weiliaotuan.core.util.StringUtility;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserService userService;
	@Autowired
	RoleUserService roleUserService;
	@Autowired
	RoleService roleService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if (StringUtility.IsNullOrEmpty(username))
			throw new UsernameNotFoundException("用户名不能为空值");

		// 获取用户信息
		ServiceResult<User> userServiceResult = this.userService.getUser(username);
		if (!StringUtility.IsNullOrEmpty(userServiceResult.getErrorCode()))
			throw new UsernameNotFoundException(String.format("获取用户信息异常（%s-%s）", userServiceResult.getErrorCode(),
					userServiceResult.getShowMessage()));

		User user = userServiceResult.getReturnResult();
		if (user == null)
			throw new UsernameNotFoundException("用户不存在");
		
		// 获取用户具有的角色
		ServiceResult<RoleUser> roleUserServiceResult = this.roleUserService.getRoleUser(username);
		if (!StringUtility.IsNullOrEmpty(roleUserServiceResult.getErrorCode()))
			throw new UsernameNotFoundException(String.format("获取用户角色异常（%s-%s）", roleUserServiceResult.getErrorCode(),
					roleUserServiceResult.getShowMessage()));
		List<RoleUser> roleUserList = roleUserServiceResult.getReturnResultList();
		if (CollectionUtility.isNullOrEmpty(roleUserList))
			throw new UsernameNotFoundException("用户尚未指定角色");

		// 获取角色集合
		ServiceResult<Role> roleServiceResult = roleService.getRoleList();
		if (!StringUtility.IsNullOrEmpty(roleServiceResult.getErrorCode()))
			throw new UsernameNotFoundException(String.format("获取角色集合异常（%s-%s）", roleServiceResult.getErrorCode(),
					roleServiceResult.getShowMessage()));

		List<Role> roleList = roleServiceResult.getReturnResultList();
		if (CollectionUtility.isNullOrEmpty(roleList))
			throw new UsernameNotFoundException("尚未设置角色");

		UserDetailsImpl userDetails = new UserDetailsImpl();
		userDetails.setUsername(user.getUseraccount());
		userDetails.setPassword(user.getUserpassword());
		userDetails.setEnabled("1".equals(user.getUseraccountenable()));
		userDetails.setAccountNonExpired(user.getUseraccountexpiredate() == null);
		userDetails.setAccountNonLocked(user.getUseraccountlockdate() == null);
		userDetails.setCredentialsNonExpired(user.getUserpasswordexpiredate() == null);
		userDetails.setIsInitPassword("0".equals(user.getUserpasswordflag()));

		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority grantedAuthority = null;
		for (RoleUser roleUser : roleUserList) {
			for (Role role : roleList) {
				if (role.getId().equals(roleUser.getRoleid())) {
					grantedAuthority = new SimpleGrantedAuthority(role.getRolename());
					grantedAuthorities.add(grantedAuthority);
					break;
				} // if
			} // for
		} // for
		userDetails.setAuthorities(grantedAuthorities);
		return userDetails;
	}

}
