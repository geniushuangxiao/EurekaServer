package com.dyd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	/**
	 * <h2>添加用户账号</h2>
	 * accountNonExpired，accountNonLocked，credentialsNonExpired，enabled默认均为true
	 * 
	 * @param username
	 * @param password
	 * @param roles
	 * @param email
	 * @return
	 */
	@ApiOperation("添加用户")
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<User> add(@RequestParam String username, @RequestParam String password,
			@RequestParam String[] roles, @RequestParam(required = false) String email) {
		User user = userService.addUser(username, password, roles, email);
		return ResponseEntity.ok(user);
	}

	@ApiOperation("删除用户")
	@DeleteMapping("/delete")
	public @ResponseBody ResponseEntity<String> delete(@RequestParam String username) {
		userService.deleteUser(username);
		String resMsg = String.format("Delete user named %s success.", username);
		return ResponseEntity.ok(resMsg);
	}
}
