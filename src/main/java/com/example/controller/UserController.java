package com.example.controller;

import com.example.pojo.Account;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/mysql")
    @ResponseBody
    public List<User> tofindAll() {
        List<User> userList = service.findAll();
        return userList;
    }


}
