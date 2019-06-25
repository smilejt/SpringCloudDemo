package com.jt.abandon.spring.cloud.auth.server.mapper;

import com.jt.abandon.spring.cloud.auth.server.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoMapper {

    UserInfo findByAccount(String account);
}
