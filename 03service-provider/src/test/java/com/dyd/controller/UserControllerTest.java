package com.dyd.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alibaba.fastjson.JSONObject;
import com.dyd.entity.bean.User;
import com.dyd.entity.dao.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	@Autowired
	private MockMvc mvc;
	@MockBean
	private UserRepository userRepository;

	@Test
	public void addTest() throws Exception {
		User user = new User("abc", "abc@163.com");
		given(this.userRepository.save(user)).willReturn(user);
		String content = JSONObject.toJSONString(user);
		this.mvc.perform(post("/user/add").contentType(MediaType.APPLICATION_JSON).content(content)).andDo(print())
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	}

	@Test
	public void allTest() throws Exception {
		List<User> users = new ArrayList<User>();
		users.add(new User("abc", "abc@163.com"));
		given(this.userRepository.findAll()).willReturn(users);
		this.mvc.perform(get("/user/all")).andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
	}
}
