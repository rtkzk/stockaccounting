package com.stockaccounting.masterscripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNGBase 
{
	public Stockaccounting_lib sl=new Stockaccounting_lib(); 
 
	@BeforeTest
	  public void AdminLgn() 
	  {
	  sl.AdminLgn("admin","master");
	  }

	  @AfterTest
	  public void logout()
	  {
	  sl.logout();
	  }

	  @BeforeSuite
	  public void OpenApp() throws IOException
	  {
	 // SL=new stockaccounting_lib();
	  sl.openApp("http://webapp.qedgetech.com");
	  }

	  @AfterSuite
	  public void close() 
	  {
	  sl.close();
	  }

	}
