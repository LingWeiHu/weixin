package com.hutu.weixin.weiliaotuan.core.service;

import com.hutu.weixin.weiliaotuan.core.domain.po.Authority;
import com.hutu.weixin.weiliaotuan.core.domain.pojo.ServiceResult;

public interface AuthorityService {
	ServiceResult<Authority> getAuthority();
	
	ServiceResult<Authority> getAuthority(String authURL);
	
	ServiceResult<String> updateAuthority(String authority);
	
	ServiceResult<String> insertAuthority(String authority);
}
