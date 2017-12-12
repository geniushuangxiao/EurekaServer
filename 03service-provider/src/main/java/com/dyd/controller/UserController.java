package com.dyd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dyd.entity.bean.User;
import com.dyd.entity.dao.UserRepository;

@RestController("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/add")
	private @ResponseBody String add() {
		User user = new User("Bob", "666@hotmail.com");
		userRepository.save(user);
		return "Success";
	}

	@GetMapping("/all")
	public @ResponseBody Iterable<User> all() {
		return userRepository.findAll();
	}

}
