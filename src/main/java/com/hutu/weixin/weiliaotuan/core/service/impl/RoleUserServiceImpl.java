package com.hutu.weixin.weiliaotuan.core.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutu.weixin.weiliaotuan.core.dao.RoleUserDao;
import com.hutu.weixin.weiliaotuan.core.domain.po.RoleUser;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;
import com.hutu.weixin.weiliaotuan.core.service.RoleUserService;
import com.hutu.weixin.weiliaotuan.core.util.StringUtility;

@Service
public class RoleUserServiceImpl implements RoleUserService {

	private static final Logger LOGGER = Logger.getLogger(RoleUserServiceImpl.class);

	@Autowired
	RoleUserDao roleUserDao;

	public ServiceResult<RoleUser> getRoleUser(String userAccount) {
		ServiceResult<RoleUser> serviceResult = new ServiceResult<RoleUser>();
		serviceResult.setErrorCode("RoleUserServiceImpl-0001");

		if (StringUtility.IsNullOrEmpty(userAccount)) {
			serviceResult.setShowMessage("参数userAccount不能为空");
			return serviceResult;
		}

		try {
			serviceResult.setReturnResultList(this.roleUserDao.selectAllByUserAccount(userAccount));
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}
		return serviceResult;
	}

	public ServiceResult<String> addRoleUser(String userAccount, int roleid) {
		ServiceResult<String> serviceResult = new ServiceResult<String>();
		serviceResult.setErrorCode("RoleUserServiceImpl-0002");
		try {
			RoleUser record = new RoleUser();
			record.setCreatedate(new Date());
			record.setEnabled("1");
			record.setRoleid(roleid);
			record.setUseraccount(userAccount);
			roleUserDao.insert(record);
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}
		return serviceResult;
	}

}
