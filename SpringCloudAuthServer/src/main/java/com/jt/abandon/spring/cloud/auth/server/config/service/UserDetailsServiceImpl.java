package com.jt.abandon.spring.cloud.auth.server.config.service;

import com.jt.abandon.spring.cloud.auth.server.entity.Permission;
import com.jt.abandon.spring.cloud.auth.server.entity.User;
import com.jt.abandon.spring.cloud.auth.server.service.PermissionService;
import com.jt.abandon.spring.cloud.auth.server.service.UserService;
import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10834
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    @Resource
    private UserService userService;

    @Resource
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("[UserDetailsServiceImpl].[loadUserByUsername]入参: username = {}", username);
        //查询用户信息
        User user = userService.getByUsername(username);
        logger.info("[UserDetailsServiceImpl].[loadUserByUsername]用户查询结果: user = {}", user.toString());
        //初始化权限List
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (!StringUtils.isEmpty(user)) {
            //查询用户对应权限
            List<Permission> permissions = permissionService.selectByUserId(user.getId());
            logger.info("[UserDetailsServiceImpl].[loadUserByUsername]用户权限查询结果: permissions.size = {}", StringUtils.isEmpty(permissions) ? null : permissions.size());
            if (!StringUtils.isEmpty(permissions)) {
                permissions.forEach(permission -> {
                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getEnName());
                    grantedAuthorities.add(grantedAuthority);
                });
            }
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
