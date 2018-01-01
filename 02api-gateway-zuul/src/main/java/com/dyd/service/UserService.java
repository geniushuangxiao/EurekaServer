package com.dyd.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dyd.entity.bean.User;
import com.dyd.entity.bean.UserAuthority;
import com.dyd.entity.dao.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Secured({ "ROLE_ADMIN" })
	public User addUser(String username, String password, String[] roles, String email) {
		String encryptedPassword = encoder.encode(password);
		Set<UserAuthority> roleSet = new HashSet<UserAuthority>();
		for (String role : roles) {
			roleSet.add(new UserAuthority(role));
		}
		User user = new User(username, encryptedPassword, roleSet);
		userRepository.save(user);
		user.eraseCredentials(); // 将密码擦除
		return user;
	}

	@Secured({ "ROLE_ADMIN" })
	public void deleteUser(String username) {
		userRepository.delete(username);
	}

}
