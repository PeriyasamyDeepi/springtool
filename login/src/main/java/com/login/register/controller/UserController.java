package com.login.register.controller;

import java.util.List;
import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.login.register.bean.Request;
import com.login.register.bean.UserModel;
import com.login.register.exception.UserNotFoundException;
import com.login.register.service.IUserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private IUserService service;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Request request) {
        
        UserModel user = service.findByUserName(request.getUsername());
        if(encoder.matches(request.getPassword(), user.getPassword())){
            return ResponseEntity.ok(user);
        }
        else {
            throw new UserNotFoundException("Invalid UserName or password");
        }
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> userSignup(@Valid @RequestBody UserModel signUpRequest) {
        return service.addUser(signUpRequest); 
    }
     
    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUser() {
        List<UserModel> list = service.findAll();
        return ResponseEntity.ok(list);
    }
          
    @GetMapping("/{email}")
    public ResponseEntity<?> getUserByEmail(@PathVariable("email") String email) {
        UserModel user = service.findUserByEmail(email);
        return ResponseEntity.ok(user);
    }      
}