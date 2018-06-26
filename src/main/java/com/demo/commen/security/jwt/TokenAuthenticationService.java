package com.demo.commen.security.jwt;


import com.demo.commen.utils.JSONResult;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class TokenAuthenticationService implements Serializable{

//    @Value("${jwt.expirationtime}")
//    private Long EXPIRATIONTIME;
//
//    @Value("${jwt.secret}")
//    private String SECRET;

    public static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    public static final String HEADER_STRING = "Authorization";// 存放Token的Header Key


    // JWT生成方法

    /**
     * JWT生成方法
     * @param response
     * @param username
     */
//    public void addAuthentication(HttpServletResponse response, String username) {
//
//        // 生成JWT
//        String JWT = Jwts.builder()
//                // 保存权限（角色）
//                .claim("authorities", "ROLE_ROOT,AUTH_WRITE")
//                // 用户名写入标题
//                .setSubject(username)
//                // 有效期设置
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
//                // 签名设置
//                .signWith(SignatureAlgorithm.HS512, SECRET)
//                .compact();
//
//        // 将 JWT 写入 body
//        try {
//            response.setContentType("application/json");
//            response.setStatus(HttpServletResponse.SC_OK);
//            response.getOutputStream().println(JSONResult.fillResultString(0, "", JWT));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 负责认证JWT最后生成验证令牌
//     * @param request
//     * @return
//     */
//    public Authentication getAuthentication(HttpServletRequest request) {
//        // 从Header中拿到token
//        String token = request.getHeader(HEADER_STRING);
//
//        if (token != null) {
//            // 解析 Token
//            Claims claims = Jwts.parser()
//                    // 验签
//                    .setSigningKey(SECRET)
//                    // 去掉 Bearer
//                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
//                    .getBody();
//
//            // 拿用户名
//            String user = claims.getSubject();
//
//            // 得到 权限（角色）
//            List<GrantedAuthority> authorities =  AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
//
//            // 返回验证令牌
//            return user != null ?
//                    new UsernamePasswordAuthenticationToken(user, null, authorities) :
//                    null;
//        }
//        return null;
//    }


}
