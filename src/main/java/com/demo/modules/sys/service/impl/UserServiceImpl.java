package com.demo.modules.sys.service.impl;

import com.demo.modules.sys.dao.UserDao;
import com.demo.modules.sys.entity.User;
import com.demo.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User get(String id) {

        return userDao.get(id);
    }

    @Override
    public User get(User user) {
        return userDao.get(user);
    }

    @Override
    public List<User> findList(User user) {

        return userDao.findList(user);
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll(Collection<User> collection) {

    }
}
