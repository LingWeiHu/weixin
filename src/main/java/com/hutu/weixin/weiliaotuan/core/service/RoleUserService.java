package com.hutu.weixin.weiliaotuan.core.service;

import com.hutu.weixin.weiliaotuan.core.domain.po.RoleUser;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;

public interface RoleUserService {
	ServiceResult<RoleUser> getRoleUser(String userAccount);
	
	ServiceResult<String> addRoleUser(String userAccount,int roleid);
}
