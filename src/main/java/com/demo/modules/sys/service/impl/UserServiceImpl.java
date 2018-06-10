package com.demo.modules.sys.service.impl;

import com.demo.commen.utils.EncryptionUtils;
import com.demo.commen.utils.StringUtils;
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
        User user = userDao.get(id);
        user.setPassword(null);
        return user;
    }

    @Override
    public User get(User user) {
        user = userDao.get(user);
        user.setPassword(null);
        return user;
    }

    @Override
    public List<User> findList(User user) {

        return userDao.findList(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void save(User user) {



        /*if (StringUtils.isNotBlank(user.getId())) {
            userDao.update(user);
        } else {
            userDao.insert(user);
        }*/
    }

    @Override
    @Transactional(readOnly = false)
    public void insert(User user) {
        String md5Pwd = EncryptionUtils.md5(User.SALT+user.getPassword());

        user.setPassword(md5Pwd);

        user.preInsert();
        userDao.insert(user);

        userDao.deleteUserRole(user);

        if (user.getRoleList() != null && user.getRoleList().size() > 0) {
            userDao.insertUserRole(user);
        }


    }

    @Override
    @Transactional(readOnly = false)
    public void update(User user) {

        if (StringUtils.isNotBlank(user.getPassword())) {
            String md5Pwd = EncryptionUtils.md5(User.SALT+user.getPassword());

            user.setPassword(md5Pwd);

            userDao.updatePasswordById(user);
        }
        userDao.updateUserInfo(user);

        userDao.deleteUserRole(user);

        if (user.getRoleList() != null && user.getRoleList().size() > 0) {
            userDao.insertUserRole(user);
        }
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

    @Override
    public boolean verifyUserByLoginName(User user) {

        User dataUser = userDao.getByLoginName(user);

        if (dataUser != null) {
            String md5Pwd = EncryptionUtils.md5(User.SALT+user.getPassword());

            if (md5Pwd.equals(dataUser.getPassword())) {
                return true;
            }
        }

        return false;
    }
}
