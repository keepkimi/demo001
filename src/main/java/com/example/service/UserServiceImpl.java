package com.example.service;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired(required = false)
    private UserMapper mapper;
    @Override
    public List<User> findAll() {
        return mapper.selectList(null);
    }

}
