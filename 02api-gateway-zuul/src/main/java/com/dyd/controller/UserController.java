package com.dyd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dyd.entity.bean.User;
import com.dyd.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@ApiOperation("添加用户")
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<User> add(@RequestParam String username, @RequestParam String password,
			@RequestParam String[] roles, @RequestParam(required = false) String email) {
		User user = userService.addUser(username, password, roles, email);
		return ResponseEntity.ok(user);
	}

}
