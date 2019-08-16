package com.qknavy.users.service;

import com.qknavy.users.entity.User;

public interface IUserService
{
    /**
     *  保存数据
     *
     * @param user
     * @return
     */
    public boolean save(User user);
}
