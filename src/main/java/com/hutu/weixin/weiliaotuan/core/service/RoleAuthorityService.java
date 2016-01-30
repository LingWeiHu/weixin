package com.hutu.weixin.weiliaotuan.core.service;

import com.hutu.weixin.weiliaotuan.core.domain.po.RoleAuthority;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;

public interface RoleAuthorityService {
	ServiceResult<RoleAuthority> getRoleAuthority(Short roleId);
	
	ServiceResult<RoleAuthority> getRoleAuthorityList();
	
	ServiceResult<RoleAuthority> getRoleAuthority(Integer authorityId);
}
