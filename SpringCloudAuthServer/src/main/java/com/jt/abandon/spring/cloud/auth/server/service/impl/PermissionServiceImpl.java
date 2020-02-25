package com.jt.abandon.spring.cloud.auth.server.service.impl;

import com.jt.abandon.spring.cloud.auth.server.entity.Permission;
import com.jt.abandon.spring.cloud.auth.server.mapper.PermissionMapper;
import com.jt.abandon.spring.cloud.auth.server.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 10834
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> selectByUserId(Long userId) {
        try{
            logger.info("[PermissionServiceImpl].[selectByUserId]入参: userId = {}", userId);
            return permissionMapper.selectByUserId(userId);
        }catch (Exception e){
            logger.error("[PermissionServiceImpl].[selectByUserId]处理异常: ", e);
            return null;
        }

    }
}
