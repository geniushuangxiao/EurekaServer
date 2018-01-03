package com.dyd.version.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dyd.version.entity.bean.Product;
import com.dyd.version.entity.dao.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@PostMapping("/add")
	public @ResponseBody ResponseEntity<Product> add(@RequestBody Product product) {
		Product save = productRepository.save(product);
		return ResponseEntity.ok(save);
	}
}
