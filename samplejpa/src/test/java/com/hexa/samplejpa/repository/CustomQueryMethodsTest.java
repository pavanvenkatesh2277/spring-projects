package com.hexa.samplejpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomQueryMethodsTest {
	@Autowired
	private ProductRepository prodRepo;
	@Test
	void searchProductsTest() {
		prodRepo.searchProducts("Mouse");
	}
	@Test
	void searchProductsTest1() {
		prodRepo.searchProducts("keyboard");
	}

}
