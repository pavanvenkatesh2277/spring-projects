package com.hexa.samplejpa.repository;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hexa.samplejpa.entity.Product;

@SpringBootTest
public class JPAQueriesTest {
	
	public final static Logger LOGGER=Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	@Autowired
	ProductRepository productRepo;
	
	@Disabled
	@Test
	void saveMethodTest() {
		Product p=new Product((long)300,"available","Laptop","laptop essentials",new BigDecimal(5000.00),true,"lenovo i5.png",
				LocalDateTime.now(),LocalDateTime.now());
		
		Product savedProduct=productRepo.save(p);
		LOGGER.log(Level.INFO, "savedProduct :" +savedProduct);
		
	}
	
	@Disabled
	@Test
	void saveMethodUpdateTest() {
		Long id=1L;
		Optional<Product> existingProduct=productRepo.findById(id);
		if(existingProduct.isPresent()) {
		Product obj=existingProduct.get();
		LOGGER.log(Level.INFO, "existingProduct :" +obj);
		//update the object
		obj.setName("lenovo");
		obj.setDescription("powerful processor");
		//productRepo.save(existingProduct);
		Product updatedProduct=productRepo.save(obj);
		LOGGER.log(Level.INFO, "savedProduct :" +updatedProduct);
		}
		else {
			LOGGER.log(Level.INFO, "object not present..");
		}
	}
	
	@Test
	void saveAll() {
		Product p1=new Product((long)300,"available","jeans","mens clothing",new BigDecimal(5000.00),true,"mens1.png",
				LocalDateTime.now(),LocalDateTime.now());
		
		Product p2=new Product((long)300,"available","t shirt","mens clothing ",new BigDecimal(2500.00),true,"lmens2.png",
				LocalDateTime.now(),LocalDateTime.now());
		
		Product p3=new Product((long)300,"available","formal shows","footware",new BigDecimal(1500.00),true,"blackmen.png",
				LocalDateTime.now(),LocalDateTime.now());
		Product p4=new Product((long)300,"available","Laptop","Laptop essentials",new BigDecimal(15000.00),true,"moto.png",
				LocalDateTime.now(),LocalDateTime.now());
		
		Product p5=new Product((long)300,"available","Laptop","laptop Bag ",new BigDecimal(1000.00),true,"lenovo nitro.png",
				LocalDateTime.now(),LocalDateTime.now());
		
		Product p6=new Product((long)300,"available","headset","wired headphone",new BigDecimal(2500.00),true,"oneplus buds.png",
				LocalDateTime.now(),LocalDateTime.now());
		List<Product> saveProductsList=productRepo.saveAll(List.of(p1,p2,p3));
		LOGGER.log(Level.INFO, "List of objects"+saveProductsList);
	}

	@Disabled
	@Test
	void findAllMethodTest() {
		List<Product> productList=productRepo.findAll();
		productList.forEach((p)->{
			LOGGER.log(Level.INFO, "List of objects"+p);
		});
	}
	
	@Disabled
	@Test
	void deleteByIdMethodTest() {
		Long id=1L;
		productRepo.deleteById(id);
		Optional<Product> opt=productRepo.findById(1L);
		if(!opt.isPresent())
		{
			LOGGER.log(Level.INFO, "object not present..");
		}
		}
	

	@Disabled
	@Test
	void deleteMethodTest() {
		Long id=2L;
		Optional<Product> opt=productRepo.findById(id);
		Product p=opt.get();
		productRepo.delete(p);
		opt=productRepo.findById(id);
		if(!opt.isPresent())
		{
			LOGGER.log(Level.INFO, "object deleted..");
		}
	}
	
	@Disabled
	@Test
	void deleteAllMethod() {
		productRepo.deleteAll();
	}
	@Disabled
	@Test
	void deleteAllWithSelected() {
		Optional<Product> opt1=productRepo.findById(3L);
		Product p1=opt1.get();
		Optional<Product> opt2=productRepo.findById(6L);
		Product p2=opt2.get();
		productRepo.deleteAll(List.of(p1,p2));
		//if(opt1.isEmpty() && opt2.isEmpty())
		if(productRepo.findById(3L).isEmpty() && productRepo.findById(6L).isEmpty())
		{
			LOGGER.log(Level.INFO, "record deleted..");
		}
	}
	
	@Disabled
	@Test
	void existByIdmethodTest() {
		boolean existStatus=productRepo.existsById((long)5);
		LOGGER.log(Level.INFO, "record exixt status.."+existStatus);
	}
	
	@Disabled
	@Test
	void countMethodTest() {
		Long Count=productRepo.count();
		LOGGER.log(Level.INFO, "number of records:"+Count);}
}