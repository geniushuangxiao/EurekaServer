package com.dyd.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.dyd.entity.bean.UserAuthority;

public interface UserAuthorityRepository extends CrudRepository<UserAuthority, String> {
}
