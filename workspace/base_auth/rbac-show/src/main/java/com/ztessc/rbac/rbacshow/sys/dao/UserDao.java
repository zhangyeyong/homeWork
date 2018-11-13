package com.ztessc.rbac.rbacshow.sys.dao;

import com.ztessc.rbac.rbacshow.sys.entity.User;

/**
 * Created by Administrator on 2018/1/24 0024.
 */
public interface UserDao {

    /**
     * 功能描述：根据账号来获取用户信息
     * @param login
     * @return
     */
    User findByLogin(String login);

}
