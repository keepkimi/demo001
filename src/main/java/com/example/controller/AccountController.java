package com.example.controller;

import com.example.mapper.UserMapper;
import com.example.pojo.Account;
import com.example.pojo.User;
import com.example.service.AccountService;
import com.example.vo.Data;
import com.example.vo.SysResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(value = "AccountController", description = "AccountController")
public class AccountController {

    @Autowired(required = false)
    private AccountService accountService;
    @Autowired(required = false)
    private UserMapper userMapper;
    @RequestMapping("/logn")
    @ResponseBody
    @ApiOperation("/登录操作")
    public SysResult logn(String account,String password,String type){
        User user = accountService.checkLogn(account,password,type);
        return new SysResult(user);
    }
    @RequestMapping("/deleteAccount")
    @ApiOperation("/删除操作")
    public SysResult deleteAccount(Long user_Id){
        accountService.delete(user_Id);
        return new SysResult("ok");
    }
    @RequestMapping("/updatePassword")
    @ApiOperation("/修改密码操作")
    public SysResult updatePassword(String password,Long account_Id){
        accountService.updatePassword(password,account_Id);
        return  new SysResult("ok");
    }

    @RequestMapping("/register")
    @ApiOperation("/注册操作")
    @ResponseBody
    public SysResult register(User user, Account account){
        accountService.register(user,account);
        return new SysResult(user);
    }



}
