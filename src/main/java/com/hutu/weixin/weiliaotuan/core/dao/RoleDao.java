package com.hutu.weixin.weiliaotuan.core.dao;

import java.util.List;

import com.hutu.weixin.weiliaotuan.core.domain.po.Role;

public interface RoleDao {
    int deleteByPrimaryKey(Short roleid);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Short roleid);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectAll();
    
    List<Role> selectAllByIdList(List<Short> roleIdList);
}