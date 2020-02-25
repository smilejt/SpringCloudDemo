package com.jt.abandon.spring.cloud.auth.server.service.impl;

import com.jt.abandon.spring.cloud.auth.server.entity.User;
import com.jt.abandon.spring.cloud.auth.server.mapper.UserMapper;
import com.jt.abandon.spring.cloud.auth.server.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

/**
 * @author 10834
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    @Override
    public User getByUsername(String username) {
        try{
            logger.info("[UserServiceImpl].[getByUsername]入参: username = {}", username);
            Example example = new Example(User.class);
            example.createCriteria().andEqualTo("username", username);
            return userMapper.selectOneByExample(example);
        }catch (Exception e){
            logger.error("[UserServiceImpl].[getByUsername]处理异常: ", e);
            return null;
        }
    }
}
