package com.demo.commen.security.entity;

import org.springframework.security.core.GrantedAuthority;

/**
 * 权限类
 * 负责存储权限和角色
 */
public class GrantedAuthorityImpl implements GrantedAuthority {
    private String authority;

    public GrantedAuthorityImpl (String authority) {
        this.authority = authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
