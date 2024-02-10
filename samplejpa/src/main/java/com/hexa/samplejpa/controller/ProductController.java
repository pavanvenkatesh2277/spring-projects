package com.hexa.samplejpa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.samplejpa.entity.Product;
import com.hexa.samplejpa.service.ProductService;

@RestController
@RequestMapping("/api/v1/productapp")
public class ProductController {
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	@GetMapping("/searchProducts")
	public ResponseEntity<List<Product>>searchProducts(@RequestParam String query){
		return ResponseEntity.ok(productService.searchProducts(query));
	}
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> createProduct(@RequestBody Product p) {
		return ResponseEntity.ok(productService.createProduct(p));
	}

}
