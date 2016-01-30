package com.hutu.weixin.weiliaotuan.core.dao;

import java.util.List;

import com.hutu.weixin.weiliaotuan.core.domain.po.Authority;

public interface AuthorityDao {
    int deleteByPrimaryKey(Integer authorityid);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(Integer authorityid);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);
    
    List<Authority> selectAll();
    
    Authority selectOne(Authority record);
}