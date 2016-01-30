package com.hutu.weixin.weiliaotuan.core.dao;

import java.util.List;

import com.hutu.weixin.weiliaotuan.core.domain.po.User;

public interface UserDao {
    int deleteByPrimaryKey(String useraccount);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String useraccount);
    User selectByPrimaryid(int id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    User selectSelective(User record);
    
    List<User> selectPlayingByHallKey(Integer hallid);
    
    List<User> selectDynamicUsersByPrimaryKey(Integer dynamicid);
}