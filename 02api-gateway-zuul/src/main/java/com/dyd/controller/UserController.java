package com.dyd.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dyd.entity.bean.User;
import com.dyd.entity.bean.UserAuthority;
import com.dyd.entity.dao.UserAuthorityRepository;
import com.dyd.entity.dao.UserRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserAuthorityRepository authorityRepositoty;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@ApiOperation("添加用户")
	@PostMapping("/add")
	public @ResponseBody ResponseEntity<User> add(@RequestParam String username, @RequestParam String password,
			@RequestParam String[] roles, @RequestParam(required = false) String email) {
		for (String role : roles) {
			if (null == authorityRepositoty.findOne(role)) {
				authorityRepositoty.save(new UserAuthority(role));
			}
		}
		String encryptedPassword = encoder.encode(password);
		Set<UserAuthority> roleSet = new HashSet<UserAuthority>();
		for (String role : roles) {
			roleSet.add(new UserAuthority(role));
		}
		User user = new User(username, encryptedPassword, roleSet);
		userRepository.save(user);
		return ResponseEntity.ok(user);
	}

}
