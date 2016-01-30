package com.hutu.weixin.weiliaotuan.core.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hutu.weixin.weiliaotuan.core.dao.RoleUserDao;
import com.hutu.weixin.weiliaotuan.core.dao.UserDao;
import com.hutu.weixin.weiliaotuan.core.domain.po.RoleUser;
import com.hutu.weixin.weiliaotuan.core.domain.po.User;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;
import com.hutu.weixin.weiliaotuan.core.service.UserService;
import com.hutu.weixin.weiliaotuan.core.util.StringUtility;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	UserDao userDao;
	@Autowired
	RoleUserDao roleUserDao;
	
	public ServiceResult<User> getUser(String userName) {
		ServiceResult<User> serviceResult = new ServiceResult<User>();
		serviceResult.setErrorCode("UserServiceImpl-0001");

		if (StringUtility.IsNullOrEmpty(userName)) {
			serviceResult.setShowMessage("用户名不能为空");
			return serviceResult;
		}
		try {
			serviceResult.setReturnResult(userDao.selectByPrimaryKey(userName));
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}

	public ServiceResult<String> validateUserToken(String userName, String passWord) {
		ServiceResult<String> serviceResult = new ServiceResult<String>();
		serviceResult.setErrorCode("UserServiceImpl-0002");

		if (StringUtility.IsNullOrEmpty(userName)) {
			serviceResult.setShowMessage("用户名不能为空");
			return serviceResult;
		}
		if (StringUtility.IsNullOrEmpty(passWord)) {
			serviceResult.setShowMessage("密码不能为空");
			return serviceResult;
		}
		try {

			User user = userDao.selectByPrimaryKey(userName);
			serviceResult.setErrorCode("");
			if (user == null)
				serviceResult.setShowMessage("账户不存在");
			else {
				// 判断密码
				if (!passWord.equals(user.getUserpassword())) {
					serviceResult.setShowMessage("无效的用户名或密码");
					return serviceResult;
				}
				// 账号状态
				String temp = user.getUseraccountenable();
				if (!StringUtility.IsNullOrEmpty(temp)) {
					if ("0".equals(temp)) {
						serviceResult.setShowMessage("账号不可用");
						return serviceResult;
					}
				}
				serviceResult.setReturnResult(userName);
				serviceResult.setErrorCode("");
			}

		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}

	public ServiceResult<User> getUser(String userName, String passWord) {
		ServiceResult<User> serviceResult = new ServiceResult<User>();
		serviceResult.setErrorCode("UserServiceImpl-0003");

		if (StringUtility.IsNullOrEmpty(userName)) {
			serviceResult.setShowMessage("参数userName不能为空");
			return serviceResult;
		}
		if (StringUtility.IsNullOrEmpty(passWord)) {
			serviceResult.setShowMessage("参数passWord不能为空");
			return serviceResult;
		}
		try {
			User user = new User();
			user.setUseraccount(userName);
			user.setUserpassword(passWord);

			serviceResult.setReturnResult(userDao.selectSelective(user));
			serviceResult.setErrorCode("");
		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}

		return serviceResult;
	}
	/**
	 * 注册
	 * 
	 * @author kz
	 * 
	 */
	public ServiceResult<String> regiest(String userName, String passWord) {
		// TODO Auto-generated method stub
		ServiceResult<String> serviceResult = new ServiceResult<String>();
		serviceResult.setErrorCode("UserServiceImpl-0004");

		if (StringUtility.IsNullOrEmpty(userName)) {
			serviceResult.setShowMessage("用户名不能为空");
			return serviceResult;
		}
		if (StringUtility.IsNullOrEmpty(passWord)) {
			serviceResult.setShowMessage("密码不能为空");
			return serviceResult;
		}
		try {

			User user = userDao.selectByPrimaryKey(userName);
			System.out.println(user);
			if (user != null)
				serviceResult.setShowMessage("用户已存在！");
			else {
				
				User account = new User();
				account.setUseraccount(userName);
				account.setUserpassword(passWord);
				account.setUseraccountcreatedate(new Date());
				account.setUserpasswordflag("0");//用户密码状态(0-初始密码，1-非初始密码，2-重置)
				account.setUseraccountenable("1");//用户账号状态（0-不可用，1-可用）
				int id = userDao.insertSelective(account);
				//同时将用户的权限信息添加，初始化用户都是普通用户，只有特殊的用户，需要重新申请权限 胡金金  20151216 补充
				RoleUser record = new RoleUser();
				record.setCreatedate(new Date());
				record.setCreator(userName);
				record.setCreatorid(id);
				record.setEnabled("1");
				record.setRoleid(2);//普通用户  默认id =2;
				record.setUseraccount(userName);
				roleUserDao.insert(record);
				serviceResult.setReturnResult("");
				serviceResult.setErrorCode("");
			}

		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
			System.out.println(e);
		}
		return serviceResult;
}

	/**
	 * 修改密码
	 * 
	 * @author kz
	 * 
	 */
	public ServiceResult<String> updatepwd(String userName,String passWord,String newpassWord) {
		ServiceResult<String> serviceResult = new ServiceResult<String>();
		serviceResult.setErrorCode("UserServiceImpl-0005");
		try {

			User user = userDao.selectByPrimaryKey(userName);
			System.out.println(user);
			if (user == null)
				serviceResult.setShowMessage("用户不存在！");
			else {
				if(!passWord.equals(user.getUserpassword())){
					serviceResult.setShowMessage("密码与原密码不符！");
				}else{
				User account = new User();
				account.setUseraccount(userName);
				account.setUserpassword(newpassWord);
				account.setUserpasswordflag("1");////用户密码状态(0-初始密码，1-非初始密码，2-重置)
				userDao.updateByPrimaryKeySelective(account);
				serviceResult.setReturnResult("");
				serviceResult.setErrorCode("");
				}
			}

		} catch (Exception e) {
			serviceResult.setShowMessage("执行异常。详情参见错误代码。");
			LOGGER.error(e);
		}
		return serviceResult;
	}

}
