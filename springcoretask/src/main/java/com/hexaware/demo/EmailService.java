package com.hexaware.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("emailservice")
public class EmailService {
	private Datasource ds;
	
	@Autowired
	public EmailService(Datasource ds)
	{
		this.ds=ds;
	}
    public void sendemail()
    {
    	this.ds.returnConnection();
    }
}