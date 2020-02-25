package com.jt.abandon.spring.cloud.auth.server.service.impl;

import com.jt.abandon.spring.cloud.auth.server.mapper.RoleMapper;
import com.jt.abandon.spring.cloud.auth.server.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 10834
 */
@Service
public class RoleServiceImpl implements RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Resource
    RoleMapper roleMapper;
}
