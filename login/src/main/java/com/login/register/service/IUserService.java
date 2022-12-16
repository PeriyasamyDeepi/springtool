package com.login.register.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.login.register.bean.UserModel;

public interface IUserService {
    
    public ResponseEntity<?> addUser(UserModel user);
    public UserModel findByUserName(String userName);
    public UserModel findUserByEmail(String email);
    public List<UserModel> findAll();
}