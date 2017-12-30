package com.dyd.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.dyd.entity.bean.User;

public interface UserRepository extends CrudRepository<User, String> {
}
