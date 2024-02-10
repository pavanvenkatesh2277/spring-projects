package com.hexa.samplejpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MethosGenerationTest {
	@Autowired
	private ProductRepository prodRepo;
	@Test
	void searchProductTest() {
		prodRepo.searchProducts("mouse");
	}
	@Test
	void searchProduct1Test() {
		prodRepo.searchProducts("keyboard");
	}

}
