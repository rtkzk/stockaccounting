package com.stockaccounting.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.stockaccounting.masterscripts.login;
import com.stockaccounting.masterscripts.stockAccountingHomepage;

public class SAexe
{
@Test
public void loginexe()
{
	WebDriver driver=new FirefoxDriver();
	driver.get("http://webapp.qedgetech.com/");
	driver.manage().window().maximize();
	login lgn=PageFactory.initElements(driver,login.class);
	lgn.AdmLgn("admin","master");

	stockAccountingHomepage sh=PageFactory.initElements(driver,stockAccountingHomepage.class);
sh.sitems();
sh.supplier();
sh.purchases();
}
	
	
	
}
