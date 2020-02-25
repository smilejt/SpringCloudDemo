package com.jt.abandon.spring.cloud.auth.server.service;

import com.jt.abandon.spring.cloud.auth.server.entity.Permission;

import java.util.List;

/**
 * @author 10834
 */
public interface PermissionService {

    /**
     * 查询用户权限列表
     *
     * @param userId 用户ID
     * @return 查询结果集
     */
    default List<Permission> selectByUserId(Long userId) {
        return null;
    }
}
