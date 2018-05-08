package com.demo.modules.sys.entity;

import com.demo.commen.base.DataEntity;

public class User extends DataEntity<User> {

    public static final String SALT = "com.dashwood";

    private String name;
    private String loginName;
    private String password;

    public User() {
        super();
    }

    public User(String id) {
        super(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
