package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mapper.AccountMapper;
import com.example.mapper.UserMapper;
import com.example.pojo.Account;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired(required = false)
    private AccountMapper accountMapper;
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public User checkLogn(String account, String password, String type){
        if (account==null||"".equals(account)||password==null||"".equals(password)){
            throw new IllegalArgumentException("账号或密码为空");

        }
        QueryWrapper<Account> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("account",account);
        queryWrapper.eq("password",password);
        Account account1= accountMapper.selectOne(queryWrapper);
        if(account1==null||account1.getAccountId()==null){
            throw new RuntimeException("查无此人");
        }

        Long userId=account1.getUserId();
        return userMapper.selectById(userId);
    }

    @Override
    public void delete(Long user_Id) {
        User acc  = userMapper.selectById(user_Id);
        userMapper.deleteById(user_Id);
        accountMapper.deleteById(acc.getUserId());
    }

    @Override
    public void register(User user, Account account) {
        if(user==null||account==null){
            throw new IllegalArgumentException("传入信息有误！！！");
        }

        userMapper.insert(user);
        System.out.println(user.getUserId());
        accountMapper.insert(account.setUserId(user.getUserId()));



    }

    @Override
    public void updatePassword(String password, Long account_Id) {
        Account account = new Account().setAccountId(account_Id).setPassword(password);
        accountMapper.updateById(account);

    }
}
