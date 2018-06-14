package com.demo.commen.security.entity;

import com.demo.modules.sys.entity.Role;
import com.demo.modules.sys.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

/**
 * JwtUser工厂
 */
public class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getRoleList())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> roleList) {
        return roleList.stream()
                .map(r -> {
                    return new SimpleGrantedAuthority(r.getName());
                })
                .collect(Collectors.toList());
    }

}
