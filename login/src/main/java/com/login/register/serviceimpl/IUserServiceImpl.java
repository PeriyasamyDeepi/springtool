package com.login.register.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.register.bean.UserModel;
import com.login.register.dao.IUserRepository;
import com.login.register.service.IUserService;

@Service
public class IUserServiceImpl implements IUserService {
    
    @Autowired
    private IUserRepository repository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @Override
    public ResponseEntity<?> addUser(UserModel signUpRequest) {
        UserModel user = new UserModel();
        
        if(repository.findById(signUpRequest.getuserName()).isPresent()){
            return ResponseEntity.badRequest().body("username is already exists");
        }
        
        if((signUpRequest.getPassword().length()<8 || signUpRequest.getPassword().length()>16)) {
            return ResponseEntity.badRequest().body("please check your password");
        }
            
        user.setuserName(signUpRequest.getuserName());
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(encoder.encode(signUpRequest.getPassword()));
        repository.save(user);
        return ResponseEntity.ok(user);
    }



   @Override
    public UserModel findUserByEmail(String email) {
        return repository.findByEmail(email);
    }
    
    @Override
    public UserModel findByUserName(String userName) {
        return repository.findByUserName(userName);
    }
    
    @Override
    public List<UserModel> findAll() {
        return repository.findAll();
    }  
}