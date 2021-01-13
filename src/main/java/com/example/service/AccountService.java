package com.example.service;

import com.example.pojo.Account;
import com.example.pojo.User;

public interface AccountService {


    User checkLogn(String account, String password, String type);

    void delete(Long user_Id);

    void register(User user, Account account);

    void updatePassword(String password, Long account_Id);
}
