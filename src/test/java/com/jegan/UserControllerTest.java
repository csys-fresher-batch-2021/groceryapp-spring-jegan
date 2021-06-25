package com.jegan;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jegan.controller.UserRegistrationController;
import com.jegan.model.UserRegistration;
import com.jegan.service.UserRegistrationService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
 class UserControllerTest {


	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private UserRegistrationService userServiceMock;
	
	@InjectMocks
	UserRegistrationController userControl;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	 void testLogin() throws Exception {
		
		UserRegistration user = new UserRegistration();
		user.setUserEmail("jegan@gmail.com");
		user.setPassWord("Jegan@123");
		when(userServiceMock.userLogin(any(String.class),any(String.class)))
				.thenReturn(true);
		String userJson = new ObjectMapper().writeValueAsString(user);
		mockMvc.perform(post("/UserLogin").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.infoMessage").value("Successfully Logged In"));

			}

}
