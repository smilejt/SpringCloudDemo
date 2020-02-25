package com.jt.abandon.spring.cloud.auth.server.service;

import com.jt.abandon.spring.cloud.auth.server.entity.User;

/**
 * @author 10834
 */
public interface UserService {
    /**
     *  通过用户名查询用户
     * @param username 用户名
     * @return 用户对象
     */
    default User getByUsername(String username) {
        return null;
    }
}
