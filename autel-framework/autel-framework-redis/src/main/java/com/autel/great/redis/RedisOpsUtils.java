package com.autel.great.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Component
public class RedisOpsUtils {

    private static RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        RedisOpsUtils.redisTemplate = redisTemplate;
    }

    public static void hashSet(String key, String field, Object value) {
        redisTemplate.opsForHash().put(key, field, value);
    }

    public static Object hashGet(String key, String field) {
        return redisTemplate.opsForHash().get(key, field);
    }

    public static Set<Object> hashKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    public static boolean hashCheck(String key, String field) {
        return redisTemplate.opsForHash().hasKey(key, field);
    }

    public static boolean hashDel(String key, Object[] fields) {
        return redisTemplate.opsForHash().delete(key, fields) > 0;
    }

    public static long hashLen(String key) {
        return redisTemplate.opsForHash().size(key);
    }

    public static boolean expireKey(String key, long timeout) {
        return redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public static void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public static void setWithExpire(String key, Object value, long expire) {
        redisTemplate.opsForValue().set(key, value, expire, TimeUnit.SECONDS);
    }

    public static long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    public static boolean checkExist(String key) {
        return redisTemplate.hasKey(key);
    }

    public static boolean del(String key) {
        return RedisOpsUtils.checkExist(key) && redisTemplate.delete(key);
    }

    public static Set<String> getAllKeys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    public static void listRPush(String key, Object... value) {
        if (value.length == 0) {
            return;
        }
        for (Object val : value) {
            redisTemplate.opsForList().rightPush(key, val);
        }
    }

    public static List<Object> listGet(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    public static List<Object> listGetAll(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    public static Long listLen(String key) {
        return redisTemplate.opsForList().size(key);
    }

    public static Boolean zAdd(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    public static Boolean zRemove(String key, Object... value) {
        return redisTemplate.opsForZSet().remove(key, value) > 0;
    }

    public static Set<Object> zRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    public static Object zGetMin(String key) {
        Set<Object> objects = zRange(key, 0, 0);
        if (CollectionUtils.isEmpty(objects)) {
            return null;
        }
        return objects.iterator().next();
    }

    public static Double zScore(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    public static Double zIncrement(String key, Object value, double delta) {
        return redisTemplate.opsForZSet().incrementScore(key, value, delta);
    }
}
