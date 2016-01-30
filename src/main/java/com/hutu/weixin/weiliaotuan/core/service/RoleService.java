package com.hutu.weixin.weiliaotuan.core.service;

import java.util.List;

import com.hutu.weixin.weiliaotuan.core.domain.po.Role;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;

public interface RoleService {
	ServiceResult<Role> getRoleList();
	
	ServiceResult<Role> getRoleList(List<Short> roleIdList);
}
