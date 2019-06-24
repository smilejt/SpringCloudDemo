package com.jt.abandon.spring.cloud.auth.dao;

import com.jt.abandon.spring.cloud.auth.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserInfoDao {

    UserInfo findByAccount(String account);
}
