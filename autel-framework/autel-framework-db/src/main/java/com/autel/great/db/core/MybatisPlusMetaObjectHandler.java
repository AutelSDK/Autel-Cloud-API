package com.autel.great.db.core;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Component
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Long.class,
                LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        this.strictInsertFill(metaObject, "updateTime", Long.class,
                LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Long.class,
                LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
}
