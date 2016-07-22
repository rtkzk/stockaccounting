package com.stockaccounting.masterscripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import com.stockaccounting.masterscripts.Stockaccounting_lib;

public class NewTest {
  public Stockaccounting_lib sl=new stockaccounting_lib()
  {
  @BeforeTest
  public void AdminLogin() 
  {
	  sl.AdminLgn("admin","master");
  }
  }

  @AfterTest
  public void logout()
  {
	  sl.logout();
  }

  @BeforeSuite
  public void OpenApp() 
  {
	  sl.openApp("http://webapp.qedgetech.com");
  }

  @AfterSuite
  public void closeApp() 
  {
	  sl.Appclose();
  }
}
}
