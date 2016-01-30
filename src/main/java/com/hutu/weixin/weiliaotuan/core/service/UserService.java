package com.hutu.weixin.weiliaotuan.core.service;

import com.hutu.weixin.weiliaotuan.core.domain.po.User;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;

public interface UserService {

	ServiceResult<String> validateUserToken(String userName,String passWord);
	
	ServiceResult<User> getUser(String userName,String passWord);
	
	ServiceResult<User> getUser(String userName);
	
	ServiceResult<String> regiest(String userName,String passWord);
	
	ServiceResult<String> updatepwd(String userName,String passWord,String newpassWord);
}
