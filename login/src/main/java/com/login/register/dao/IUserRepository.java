package com.login.register.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.login.register.bean.UserModel;

@Repository
public interface IUserRepository extends JpaRepository<UserModel, String>{
    UserModel findByEmail(String email);
    UserModel findByUserName(String userName);
}