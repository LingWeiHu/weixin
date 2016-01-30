package com.hutu.weixin.weiliaotuan.core.dao;

import java.util.List;

import com.hutu.weixin.weiliaotuan.core.domain.po.RoleAuthority;

public interface RoleAuthorityDao {
    int deleteByPrimaryKey(Integer raid);

    int insert(RoleAuthority record);

    int insertSelective(RoleAuthority record);

    RoleAuthority selectByPrimaryKey(Integer raid);

    int updateByPrimaryKeySelective(RoleAuthority record);

    int updateByPrimaryKey(RoleAuthority record);
    
    List<RoleAuthority> selectAllByRoleId(Short roleId);
    
    List<RoleAuthority> selectAll();
    
    List<RoleAuthority> selectAllByAuthorityId(Integer authorityId);
}