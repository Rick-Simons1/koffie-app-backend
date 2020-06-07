package com.example.koffieapp;

import koffieApp.KoffieAppApplication;
import koffieApp.dao.UserDao;
import koffieApp.domain.User;
import koffieApp.repository.UserCrudRepository;
import koffieApp.repository.UserQueryRepository;
import koffieApp.service.CoffeeService;
import koffieApp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;



@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest(classes = KoffieAppApplication.class)
class UserServiceTests {

	@Autowired
	UserService userService;
	@Autowired
	UserCrudRepository userCrudRepository;
	@Autowired
	UserQueryRepository userQueryRepository;
	@Autowired
	UserDao userDao;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	void Test_Register_NewUser() {
		User testuser = new User();
		testuser.setPassword("password");
		testuser.setUsername("testusernameRegister");
		testuser.setName("testname");

		userService.registerUser(testuser);
		User foundUser = userQueryRepository.findUserByUsername(testuser.getUsername());

		assertEquals(testuser.getId(), foundUser.getId());

	}

	@Test
	void Test_update_user(){
		User testuser = new User();
		testuser.setPassword("password");
		testuser.setUsername("testusernameUpdate");
		testuser.setName("testname");
		userDao.saveUser(testuser);
		testuser.setName("updatedtestnameUpdate");
		userService.updateUser(testuser);

		User testUserFromDb = userDao.getUserById(testuser.getId());

		assertEquals("updatedtestnameUpdate", testUserFromDb.getName());
	}

	@Test
	void Test_updateUser_forSameNameError(){
		User testuser = new User();
		testuser.setPassword("password");
		testuser.setUsername("testusernameUpdateSameName");
		testuser.setName("testname");
		userDao.saveUser(testuser);
		User testusersameName = new User();
		testusersameName.setPassword("password");
		testusersameName.setUsername("testusernameUpdateSameName");
		testusersameName.setName("testnameSameName");

		String response = userService.updateUser(testusersameName);

		assertEquals("nameExists", response);
	}

	@Test
	void Test_updateUserPassword_success(){
		User testuser = new User();
		testuser.setPassword("password");
		testuser.setUsername("testusernameUpdatePasswdSuccess");
		testuser.setName("testname");
		String encryptedPasswd = bCryptPasswordEncoder.encode(testuser.getPassword());
		testuser.setPassword(encryptedPasswd);
		userDao.saveUser(testuser);
		String oldPasswd = "password";
		String newPasswd = "newpassword";

		userService.updateUserPassword(testuser.getId(),oldPasswd,newPasswd);

		User updatedPasswdUser = userDao.getUserById(testuser.getId());

		assertEquals(true, bCryptPasswordEncoder.matches(newPasswd, updatedPasswdUser.getPassword()));

	}

	@Test
	void Test_updateUserPassword_DidntMatchError(){
		User testuser = new User();
		testuser.setPassword("password");
		testuser.setUsername("testusernameUpdatePasswdSuccess");
		testuser.setName("testname");
		String encryptedPasswd = bCryptPasswordEncoder.encode(testuser.getPassword());
		testuser.setPassword(encryptedPasswd);
		userDao.saveUser(testuser);
		String oldPasswd = "passwordWrong";
		String newPasswd = "newpassword";

		String response = userService.updateUserPassword(testuser.getId(),oldPasswd,newPasswd);

		assertEquals("didntMatch",response );

	}





}
