package com.hutu.weixin.weiliaotuan.core.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hutu.weixin.weiliaotuan.core.dao.AuthorityDao;
import com.hutu.weixin.weiliaotuan.core.domain.po.Authority;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;
import com.hutu.weixin.weiliaotuan.core.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	AuthorityDao authorityDao;

	private static final Logger LOGGER = Logger.getLogger(AuthorityServiceImpl.class);

	public ServiceResult<Authority> getAuthority() {
		ServiceResult<Authority> serviceResult = new ServiceResult<Authority>();
		serviceResult.setErrorCode("AuthorityServiceImpl-0001");

		try {
			serviceResult.setReturnResultList(this.authorityDao.selectAll());
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}

	public ServiceResult<Authority> getAuthority(String authURL) {
		ServiceResult<Authority> serviceResult = new ServiceResult<Authority>();
		serviceResult.setErrorCode("AuthorityServiceImpl-0002");

		try {
			Authority authority = new Authority();
			authority.setAuthorityurl(authURL);
			serviceResult.setReturnResult(this.authorityDao.selectOne(authority));
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}

	public ServiceResult<String> insertAuthority(String authority) {
		// TODO Auto-generated method stub
		ServiceResult<String> serviceResult = new ServiceResult<String>();
		serviceResult.setErrorCode("AuthorityServiceImpl-0003");
		try {
			ObjectMapper mapper = new ObjectMapper();  
			Authority authoritys = (Authority) mapper.readValue(authority, Authority.class);
			Authority authorityes = new Authority();
			authorityes.setAuthorityurl(authoritys.getAuthorityurl());
			authorityes.setId(authoritys.getId());
			authorityes.setAuthoritycode(authoritys.getAuthoritycode());
			authorityes.setAuthorityname(authoritys.getAuthorityname());
			authorityes.setCreatedate(new Date());
			authorityes.setEnabled(authoritys.getEnabled());
			authorityes.setCreator(authoritys.getCreator());
			authorityes.setCreatorid(authoritys.getCreatorid());
			
			authorityDao.insertSelective(authorityes);
			serviceResult.setReturnResult("");
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}
	public ServiceResult<String> updateAuthority(String authority) {
		// TODO Auto-generated method stub
		ServiceResult<String> serviceResult = new ServiceResult<String>();
		serviceResult.setErrorCode("AuthorityServiceImpl-0003");
		try {
			ObjectMapper mapper = new ObjectMapper();  
			Authority authoritys = (Authority) mapper.readValue(authority, Authority.class);
			Authority authorityes = new Authority();
			authorityes.setAuthorityurl(authoritys.getAuthorityurl());
			authorityes.setId(authoritys.getId());
			authorityes.setAuthoritycode(authoritys.getAuthoritycode());
			authorityes.setAuthorityname(authoritys.getAuthorityname());
			authorityes.setEnabled(authoritys.getEnabled());
			authorityes.setModifydate(new Date());
			authorityes.setModiferid(authoritys.getModiferid());
			authorityes.setModifer(authoritys.getModifer());
			authorityDao.updateByPrimaryKeySelective(authorityes);
			serviceResult.setReturnResult("");
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}
}
