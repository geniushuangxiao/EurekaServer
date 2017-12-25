package com.dyd.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dyd.entity.bean.User;
import com.dyd.entity.dao.UserRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@ApiOperation("添加用户")
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<User> add(@RequestBody User user) {
		return ResponseEntity.ok(userRepository.save(user));
	}

	@ApiOperation("修改用户")
	@PostMapping("modify")
	public @ResponseBody ResponseEntity<User> modify(@RequestBody User user) {
		return ResponseEntity.ok(userRepository.save(user));
	}

	@ApiOperation("删除用户")
	@DeleteMapping("/delete")
	public @ResponseBody ResponseEntity<Object> delete(@RequestParam long id) {
		userRepository.delete(id);
		return ResponseEntity.ok().build();
	}

	@ApiOperation("查询所有用户")
	@GetMapping("/all")
	public @ResponseBody List<User> all() {
		Iterator<User> iterator = userRepository.findAll().iterator();
		List<User> users = new ArrayList<User>();
		while (iterator.hasNext()) {
			users.add(iterator.next());
		}
		return users;
	}

}
