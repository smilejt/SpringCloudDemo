package com.jt.abandon.spring.cloud.auth.server.mapper;

import com.jt.abandon.spring.cloud.auth.server.entity.Permission;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.MyMapper;

import java.util.List;

/**
 * @author 10834
 */
public interface PermissionMapper extends MyMapper<Permission> {

    /**
     * 根据用户ID查询用户权限列表
     *
     * @param userId 用户ID
     * @return 查询结果集
     */
    List<Permission> selectByUserId(@Param("userId") Long userId);
}
