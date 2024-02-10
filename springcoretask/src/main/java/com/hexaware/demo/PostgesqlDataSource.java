package com.hexaware.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("post")
//@Primary
public class PostgesqlDataSource implements Datasource{
    public void returnConnection()
    {
    	System.out.println("Postgesql connected....");
    }
}