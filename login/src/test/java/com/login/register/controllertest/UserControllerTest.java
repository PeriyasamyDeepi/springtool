package com.login.register.controllertest;
  
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.login.register.service.IUserService;
import com.login.register.app.LoginAndRegistrationApplication;
import com.login.register.bean.*;
  
@SpringBootTest(classes = LoginAndRegistrationApplication.class)
class UserControllerTest {
  
  @Autowired 
  private IUserService service;
  
  @Test
  public void addUserTest(){
	  UserModel usersModel = new UserModel(); usersModel.setuserName("martin");
	  usersModel.setEmail("martinvadali@gmail.com");
	  usersModel.setPassword("Marti@iiitn48042");
	  service.addUser(usersModel); assertNotNull(service.findByUserName("martin"));
  }
  
  @Test
  public void findByEmailTest() {
	  
	  assertNotNull(service.findUserByEmail("martinvadali@gmail.com"));
  }
  
  @Test
  public void findByUserNameTest() {
	  assertNull(service.findByUserName("martin babu"));
  }
  
  @Test
  public void getAllUsersTest() {
	  List<UserModel> list = service.findAll();
	  assertEquals(1, list.size()); 
  }
}
 