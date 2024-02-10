package com.hexaware.demo;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("sql")
@Primary
public class MySqlDataSource implements Datasource{
	public void returnConnection()
    {
    	System.out.println("MySql Connected....");
    }
}