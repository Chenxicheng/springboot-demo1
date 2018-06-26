package com.demo.modules.sys.service.impl;

import com.demo.commen.utils.EncryptionUtils;
import com.demo.commen.utils.StringUtils;
import com.demo.modules.sys.dao.RoleDao;
import com.demo.modules.sys.dao.UserDao;
import com.demo.modules.sys.entity.Role;
import com.demo.modules.sys.entity.User;
import com.demo.modules.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

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

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

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


            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

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

        User dataUser = userDao.getByUsername(user);

        if (dataUser != null) {
            String md5Pwd = EncryptionUtils.md5(User.SALT+user.getPassword());

            if (md5Pwd.equals(dataUser.getPassword())) {
                return true;
            }
        }

        return false;
    }

    @Override
    @Transactional(readOnly = false)
    public void updateUserInfoWithoutPwd(User user) {
        userDao.updateUserInfo(user);

        userDao.deleteUserRole(user);

        if (user.getRoleList() != null && user.getRoleList().size() > 0) {
            userDao.insertUserRole(user);
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void updatePassword(User user) {
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        userDao.updatePasswordById(user);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        User u = userDao.getByUsername(user);

        if (u != null) {

            List<Role> roleList = roleDao.findRoleListByUserId(u.getId());

            u.setRoleList(roleList);

            return u;
        }

        return null;
    }
}
