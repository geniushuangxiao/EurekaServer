package com.dyd.version.entity.dao;

import org.springframework.data.repository.CrudRepository;

import com.dyd.version.entity.bean.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
