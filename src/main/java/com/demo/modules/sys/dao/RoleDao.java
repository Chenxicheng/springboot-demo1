package com.demo.modules.sys.dao;

import com.demo.commen.base.CrudDao;
import com.demo.modules.sys.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao extends CrudDao<Role> {

    /**
     * 根据用户id获取该用户所拥有的角色
     * @param userId
     * @return
     */
    List<Role> findRoleListByUserId (String userId);



}
