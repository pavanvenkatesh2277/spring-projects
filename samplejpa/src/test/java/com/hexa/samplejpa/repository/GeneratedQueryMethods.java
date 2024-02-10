package com.hexa.samplejpa.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.samplejpa.entity.Product;

@SpringBootTest
public class GeneratedQueryMethods {
	public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	@Autowired
	private ProductRepository prodRepo;

	@Disabled
	@Test
	void findDistinctByNameTest() {
		Product resultObject = prodRepo.findDistinctByName("laptop");
		LOGGER.log(Level.INFO, "result object :" + resultObject);
	}

	@Disabled
	@Test
	void findByNameContainingTest() {
		List<Product> resultObject = prodRepo.findByNameContaining("laptop");
		LOGGER.log(Level.INFO, "result object :" + resultObject);
		resultObject.forEach((p) -> {
			System.out.println(p);
		});
	}

	@Disabled
	@Test
	void findByPriceBetweenTest() {
		BigDecimal startPrice = new BigDecimal(1000.00);
		BigDecimal endPrice = new BigDecimal(40000.00);
		List<Product> foundList = prodRepo.findByPriceBetween(startPrice, endPrice);
		LOGGER.log(Level.INFO, "found records :" + foundList);
	}
	
	@Disabled
	@Test
	void findByDateCreatedBetweenTest() {
		LocalDateTime startDate = LocalDateTime.parse("2024-02-08T15:54:45.748633");
		LocalDateTime endDate = LocalDateTime.parse("2024-02-08T16:05:45.748633");
		List<Product> resultobj = prodRepo.findByDateCreatedBetween(startDate, endDate);
		LOGGER.log(Level.INFO, "Products Between startdate and enddate :" + resultobj);
		resultobj.forEach((p) -> {
			System.out.println(p);
		});
		}
	

	@Disabled
	@Test
	void findByNameInMethodTest() {
		List<String> names = Arrays.asList("footware", "mobile");
		List<Product> productList = prodRepo.findByNameIn(names);
		productList.forEach((p) -> {
			LOGGER.log(Level.INFO, "List of Products" + p);
		});
	}
}