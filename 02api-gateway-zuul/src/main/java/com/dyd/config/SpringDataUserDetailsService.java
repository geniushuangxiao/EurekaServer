package com.dyd.config;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.dyd.entity.bean.User;
import com.dyd.entity.bean.UserAuthority;
import com.dyd.entity.dao.UserRepository;

@Component
public class SpringDataUserDetailsService implements UserDetailsService {
	private static final Logger log = LoggerFactory.getLogger(SpringDataUserDetailsService.class);
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (!userRepository.findAll().iterator().hasNext()) {
			Set<UserAuthority> authorities = new HashSet<UserAuthority>();
			authorities.add(new UserAuthority("admin"));
			User user = new User(username, encoder.encode(""), authorities);
			return user;
		}
		try {
			return userRepository.findOne(username);
		} catch (Exception e) {
			String errMessage = String.format("An error occurred while executing userRepository.findByUsername(%s)",
					username);
			log.error(errMessage, e);
			throw new UsernameNotFoundException(errMessage, e);
		}
	}

}
