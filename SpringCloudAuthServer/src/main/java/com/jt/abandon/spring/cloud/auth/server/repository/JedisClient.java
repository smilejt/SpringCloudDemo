package com.jt.abandon.spring.cloud.auth.server.repository;

/**
 * @createData: 2019-06-24 17:17
 * @author: LongJunTao
 * @Description:
 */
public interface JedisClient {
    String get(String key);
    String set(String key, String value);
    String hget(String hkey, String key);
    long hset(String hkey, String key, String value);
    long del(String key);
    long hdel(String hkey, String key);
    long expire(String key, int second);
}
