package com.hexa.samplejpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.samplejpa.entity.Product;

public interface ProductService {
	List<Product>searchProducts(String querry);
	public Product createProduct(Product p);

}
