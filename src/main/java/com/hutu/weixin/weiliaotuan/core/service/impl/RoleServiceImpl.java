package com.hutu.weixin.weiliaotuan.core.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutu.weixin.weiliaotuan.core.dao.RoleDao;
import com.hutu.weixin.weiliaotuan.core.domain.po.Role;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;
import com.hutu.weixin.weiliaotuan.core.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	private static final Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);

	@Autowired
	RoleDao roleDao;

	public ServiceResult<Role> getRoleList() {
		ServiceResult<Role> serviceResult = new ServiceResult<Role>();
		serviceResult.setErrorCode("RoleServiceImpl-0001");

		try {
			serviceResult.setReturnResultList(this.roleDao.selectAll());
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}

	public ServiceResult<Role> getRoleList(List<Short> roleIdList) {
		ServiceResult<Role> serviceResult = new ServiceResult<Role>();
		serviceResult.setErrorCode("RoleServiceImpl-0002");

		try {
			serviceResult.setReturnResultList(this.roleDao.selectAllByIdList(roleIdList));
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}

}
