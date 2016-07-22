package com.stockaccounting.masterscripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login 
{
@FindBy(id="btnreset")
WebElement reset;

@FindBy(id="username")
WebElement un;

@FindBy(id="password")
WebElement pwd;

@FindBy(id="btnsubmit")
WebElement submit;

public void AdmLgn(String username,String Password)
{
	reset.click();
	un.sendKeys(username);
	pwd.sendKeys(Password);
	submit.click();
	
	}	
}

