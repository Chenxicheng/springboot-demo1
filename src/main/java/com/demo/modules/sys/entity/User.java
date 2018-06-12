package com.demo.modules.sys.entity;

import com.demo.commen.base.DataEntity;
import com.google.common.collect.Lists;

import java.util.List;

public class User extends DataEntity<User> {

    public static final String SALT = "com.dashwood";

    private String name;
    private String loginName;
    private String password;
    private String phone;
    private String email;

    private List<Role> roleList = Lists.newArrayList();


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
