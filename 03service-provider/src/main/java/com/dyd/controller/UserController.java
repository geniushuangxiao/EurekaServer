package com.dyd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dyd.entity.bean.User;
import com.dyd.entity.dao.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/add")
	public @ResponseBody String add() {
		// 增
		User user = new User("Bob", "666@hotmail.com");
		userRepository.save(user);

		// 查
		Iterable<User> all = userRepository.findAll();

		// 改
		for (User u : all) {
			u.setEmail("999@hotmail.com");
			userRepository.save(u);
		}

		// 删
		userRepository.delete(user);
		return "Success";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<User> all() {
		return userRepository.findAll();
	}

}
