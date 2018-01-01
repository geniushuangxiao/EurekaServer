package com.dyd.controller;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.FormLoginRequestBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.dyd.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private UserService userService;// 不可删除

	@Before
	public void before() throws Exception {
		FormLoginRequestBuilder login = formLogin().user("admin").password("admin");
		mvc.perform(login).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	}

	@Test
	@WithMockUser
	public void addTest() throws Exception {
		this.mvc.perform(post("/user/add").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username", "abc")
				.param("password", "abc").param("roles", "['ADMIN']")).andDo(print()).andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
	}

	@Test
	@WithMockUser
	public void deleteTest() throws Exception {
		this.mvc.perform(
				delete("/user/delete").contentType(MediaType.APPLICATION_FORM_URLENCODED).param("username", "abc"))
				.andDo(print()).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	}
}
