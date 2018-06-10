package com.demo.modules.sys.service;

import com.demo.commen.base.BaseService;
import com.demo.modules.sys.entity.User;

public interface UserService extends BaseService <User> {

    /**
     * 根据登录名，校验用户
     * @param user
     * @return true 校验通过可登陆， false 校验失败
     */
    boolean verifyUserByLoginName (User user);

}
