package com.hutu.weixin.weiliaotuan.core.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutu.weixin.weiliaotuan.core.dao.RoleAuthorityDao;
import com.hutu.weixin.weiliaotuan.core.domain.po.RoleAuthority;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;
import com.hutu.weixin.weiliaotuan.core.service.RoleAuthorityService;

@Service
public class RoleAuthorityServiceImpl implements RoleAuthorityService {
	
	private static final Logger LOGGER=Logger.getLogger(RoleAuthorityServiceImpl.class);
	
	@Autowired
	RoleAuthorityDao roleAuthorityDao;

	public ServiceResult<RoleAuthority> getRoleAuthority(Short roleId) {
		ServiceResult<RoleAuthority> serviceResult=new ServiceResult<RoleAuthority>();
		serviceResult.setErrorCode("RoleAuthorityServiceImpl-0001");
		
		try {
			serviceResult.setReturnResultList(this.roleAuthorityDao.selectAllByRoleId(roleId));
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}
		
		return serviceResult;
	}

	public ServiceResult<RoleAuthority> getRoleAuthorityList() {
		ServiceResult<RoleAuthority> serviceResult=new ServiceResult<RoleAuthority>();
		serviceResult.setErrorCode("RoleAuthorityServiceImpl-0002");
		
		try {
			serviceResult.setReturnResultList(this.roleAuthorityDao.selectAll());
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}
		
		return serviceResult;
	}

	public ServiceResult<RoleAuthority> getRoleAuthority(Integer authorityId) {
		ServiceResult<RoleAuthority> serviceResult=new ServiceResult<RoleAuthority>();
		serviceResult.setErrorCode("RoleAuthorityServiceImpl-0003");
		
		try {
			serviceResult.setReturnResultList(this.roleAuthorityDao.selectAllByAuthorityId(authorityId));
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}
		
		return serviceResult;
	}

}
