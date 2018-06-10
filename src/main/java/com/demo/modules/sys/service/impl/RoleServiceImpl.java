package com.demo.modules.sys.service.impl;

import com.demo.modules.sys.dao.RoleDao;
import com.demo.modules.sys.entity.Role;
import com.demo.modules.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role get(String id) {
        return null;
    }

    @Override
    public Role get(Role role) {
        return null;
    }

    @Override
    public List<Role> findList(Role role) {
        return null;
    }

    @Override
    public void save(Role role) {

    }

    @Override
    @Transactional(readOnly = false)
    public void insert(Role role) {

        role.preInsert();
        roleDao.insert(role);

    }

    @Override
    @Transactional(readOnly = false)
    public void update(Role role) {
        roleDao.update(role);
    }

    @Override
    public void delete(Role role) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll(Collection<Role> collection) {

    }
}
