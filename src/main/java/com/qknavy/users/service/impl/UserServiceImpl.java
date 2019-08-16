package com.qknavy.users.service.impl;

//import com.qknavy.datasources.druid.DynamicDataSource.Dynamic;
import com.qknavy.users.entity.User;
import com.qknavy.users.mapper.UserMapper;
import com.qknavy.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService
{
    @Autowired
    private UserMapper userMapper;

//    @Dynamic
    @Override public boolean save(User user)
    {
        int result = userMapper.insert(user);
        return result > 0;
    }
}
