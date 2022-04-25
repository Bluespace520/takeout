package com.dy.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * 自定义元数据对象处理器
 */
@Component
@Slf4j
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Autowired
    private HttpServletRequest request;

    /**
     * 插入操作，自动填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter("createTime")){
            metaObject.setValue("createTime", LocalDateTime.now());
        }
        if (metaObject.hasSetter("updateTime")){
            metaObject.setValue("updateTime",LocalDateTime.now());
        }
        if (request.getSession().getAttribute("employee") != null ){
            if (metaObject.hasSetter("createUser")){
                metaObject.setValue("createUser",request.getSession().getAttribute("employee"));
            }
            if (metaObject.hasSetter("updateUser")){
                metaObject.setValue("updateUser",request.getSession().getAttribute("employee"));
            }

        }
        if (request.getSession().getAttribute("user")!= null){
            if (metaObject.hasSetter("createUser")){
                metaObject.setValue("createUser",request.getSession().getAttribute("user"));
            }
            if (metaObject.hasSetter("updateUser")){
                metaObject.setValue("updateUser",request.getSession().getAttribute("user"));
            }
        }

    }

    /**
     *更新操作，自动填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {

        if (metaObject.hasSetter("createTime")){
            metaObject.setValue("createTime", LocalDateTime.now());
        }

        if (metaObject.hasSetter("updateTime")){
            metaObject.setValue("updateTime",LocalDateTime.now());
        }
        if (request.getSession().getAttribute("employee") != null ){
            if (metaObject.hasSetter("createUser")){
                metaObject.setValue("createUser",request.getSession().getAttribute("employee"));
            }
            if (metaObject.hasSetter("updateUser")){
                metaObject.setValue("updateUser",request.getSession().getAttribute("employee"));
            }

        }
        if (request.getSession().getAttribute("user")!= null){
            if (metaObject.hasSetter("createUser")){
                metaObject.setValue("createUser",request.getSession().getAttribute("user"));
            }
            if (metaObject.hasSetter("updateUser")){
                metaObject.setValue("updateUser",request.getSession().getAttribute("user"));
            }
        }
    }
}
