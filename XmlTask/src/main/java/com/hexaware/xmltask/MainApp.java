package com.hexaware.xmltask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
      ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
      Employee employee = (Employee) applicationContext.getBean("employee");
      System.out.println(employee);
   }
}