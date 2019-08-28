package com.qknavy.users.controller;

import com.alibaba.fastjson.JSON;
import com.qknavy.BaseTest;
import com.qknavy.users.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@AutoConfigureMockMvc
public class UserControllerTest extends BaseTest{

    @Test
    public void add() {
        User user = new User();
        user.setAge(100);
        user.setMoney(18800);
        user.setName("老刘");
        String postBody = JSON.toJSON(user).toString();
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/users/10001/add")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content(postBody))
                    .andExpect(MockMvcResultMatchers.status().is(200));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}