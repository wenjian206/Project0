package com.training.pms.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.training.pms.model.Accounts;
import com.training.pms.model.Login;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class LoginDAOImplTest {
	LoginDAO loginDAO;
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		loginDAO = new LoginDAOImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	@Order(value = 1)
	@DisplayName("Testing register")
	void testRegister() {
		Login login = new Login(-1,"Zee","Zee@123");
		Accounts account = new Accounts(-1,"Zee",0);
		assertTrue(loginDAO.register(login,account));
	}
	
	@Test
	@Order(value = 2)
	@DisplayName("Testing validate")
	void testValidate() {
		String username = "Ahmed";
		String password = "Ahmed@123";
		assertTrue(loginDAO.validate(username,password));
	}
	
	@Test
	@Order(value = 3)
	@DisplayName("Testing users' accounts exists ")
	void testIsAccountExists() {
		String username = "Neha";
		boolean actual = loginDAO.isAccountExists(username);
		assertTrue(actual);
	}
	
	@Test
	@Order(value = 4)
	@DisplayName("Testing users' accounts exists - 2 ")
	void testIsAccountExists2() {
		String username = "HJNJNUUHD";
		boolean actual = loginDAO.isAccountExists(username);
		assertFalse(actual);
	}

}
