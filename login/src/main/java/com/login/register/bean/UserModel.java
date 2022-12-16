package com.login.register.bean;

import javax.persistence.*;
import javax.validation.constraints.Email;
import org.springframework.lang.NonNull;


@Entity
@Table(name="users")
public class UserModel {
    
    @Id
    private String userName;
    
    @Email
    @Column(unique = true)
    @NonNull
    private String email;
    
    @NonNull
    private String password;

    public UserModel() {

    }
   
    public String getuserName() {
        return userName;
    }

    public void setuserName(String string) {
        this.userName = string;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
   
   public String getPassword() {
        return password;
    }

   public void setPassword(String password) {
        this.password = password;
    }
   
   @Override
   public String toString() {
        return "UserModel [userName=" + userName + ", email=" + email + ", password=" + password + "]";
    }
}