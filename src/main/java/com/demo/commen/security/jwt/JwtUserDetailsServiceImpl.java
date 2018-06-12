package com.demo.commen.security.jwt;

import com.demo.commen.security.entity.JwtUserFactory;
import com.demo.modules.sys.dao.UserDao;
import com.demo.modules.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 从用户名可以查到用户并返回的方法
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = new User();
        u.setLoginName(username);
        User user = userDao.getByLoginName(u);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            return JwtUserFactory.create(user);
        }

    }
}
