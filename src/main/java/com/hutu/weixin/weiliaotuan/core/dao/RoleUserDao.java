package com.hutu.weixin.weiliaotuan.core.dao;

import java.util.List;

import com.hutu.weixin.weiliaotuan.core.domain.po.RoleUser;

public interface RoleUserDao {
    int deleteByPrimaryKey(Integer ruid);

    int insert(RoleUser record);

    int insertSelective(RoleUser record);

    RoleUser selectByPrimaryKey(Integer ruid);

    int updateByPrimaryKeySelective(RoleUser record);

    int updateByPrimaryKey(RoleUser record);
    
    List<RoleUser> selectAllByUserAccount(String userAccount);
}