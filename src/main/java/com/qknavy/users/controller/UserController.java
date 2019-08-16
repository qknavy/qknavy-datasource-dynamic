package com.qknavy.users.controller;

import com.qknavy.datasources.druid.DynamicDataSource.Dynamic;
import com.qknavy.datasources.druid.DynamicDataSource.DynamicIdentifier;
import com.qknavy.users.entity.User;
import com.qknavy.users.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/{dbid}/add", method = RequestMethod.POST)
    @Dynamic
    @ResponseBody
    public String add(@DynamicIdentifier @PathVariable(value = "dbid") String dbid, String name, int age, double money){
        User user = new User();
        user.setAge(age);
        user.setMoney(money);
        user.setName(name);
        userService.save(user);
        return "success";
    }
}