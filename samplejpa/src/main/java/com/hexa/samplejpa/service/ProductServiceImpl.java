package com.hexa.samplejpa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.samplejpa.entity.Product;
import com.hexa.samplejpa.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {
	private ProductRepository productRepository;
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository=productRepository;
	}
	
	@Override
	public List<Product>searchProducts(String querry){
		List<Product>productList=productRepository.searchProducts(querry);
		return productList;
	}

	@Override
	public Product createProduct(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}

}
