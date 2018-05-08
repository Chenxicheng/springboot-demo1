package com.demo.modules.sys.dao;

import com.demo.commen.base.CrudDao;
import com.demo.modules.sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends CrudDao<User> {
    /**
     * 根据用户名获取用户信息
     * @param user
     * @return
     */
    User getByLoginName(User user);
}
