package com.dy.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.dy.common.R;
import com.dy.entity.User;

import java.util.Map;

public interface UserService extends IService<User> {
    R<User> login(Map map);

    /**
     * 用户退出
     * @return
     */
    R<String> logout();

    /**
     * 修改用户信息
     * @param user
     */
    void updateUserById(User user);

    /**
     * 会员分页条件查询
     * @param pageInfo
     * @param name
     * @return
     */
    R<Page> pageQuery(Page pageInfo, String name);
}
