package com.stockaccounting.masterscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;


public class Stockaccounting_lib 
{
public static Properties PR;
public static FileInputStream fis;
 public static WebDriver driver;
 public static String Eval,Aval;
 
 //Launching URL
 
 public String openApp(String URL) throws IOException
 {
	 PR=new Properties();
	 fis=new FileInputStream("D:\\RTKSeleniumProject\\ERP_ranat\\src\\com\\stockaccounting\\properties\\repository.properties");
	 PR.load(fis);
	 Eval="Login";
	 driver=new FirefoxDriver();
	 driver.get(URL);
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	 Aval=driver.findElement(By.id(PR.getProperty("Loginbutton"))).getText();
	 if(Eval.equalsIgnoreCase(Aval))
	 {
		 return "pass";
	 }
	 else
	 {
		 return "failed";
	 }
 }
	 
 //Login
 
 
public String AdminLgn(String un,String pwd)
 {
	 Eval="Administrator";
	 //reset
	 driver.findElement(By.id(PR.getProperty("reset"))).click();
	 driver.findElement(By.id(PR.getProperty("un"))).sendKeys(un);
	 driver.findElement(By.id(PR.getProperty("pwd"))).sendKeys(pwd);
	 driver.findElement(By.id(PR.getProperty("Loginbutton"))).click();	 
	 Aval=driver.findElement(By.xpath(".//*[@id='msUserName']/font/strong")).getText();

if(Eval.equalsIgnoreCase(Aval))
		{
	return "system login successfully";
		}
else
{
	return "login not seccessfull";
}
 }
  public String Supplier(String sname,String saddr,String city,String country,String cperson,String pnumber,String email,String mnumber,String note)

{
	
	driver.findElement(By.xpath(PR.getProperty("path"))).click();
	driver.findElement(By.xpath(PR.getProperty("path1"))).click();
	//driver.findElement(By.id("x_Supplier_Number"));
	//Sleeper.sleepTightInSeconds(4);
	driver.findElement(By.id(PR.getProperty("sname"))).sendKeys(sname);
	driver.findElement(By.id(PR.getProperty("saddr"))).sendKeys(saddr);
	driver.findElement(By.id(PR.getProperty("scity"))).sendKeys(city);
	driver.findElement(By.id(PR.getProperty("scountry"))).sendKeys(country);
	driver.findElement(By.id(PR.getProperty("cperson"))).sendKeys(cperson);
	driver.findElement(By.id(PR.getProperty("pnumber"))).sendKeys(pnumber);
	driver.findElement(By.id(PR.getProperty("semail"))).sendKeys(email);
	driver.findElement(By.id(PR.getProperty("smnumber"))).sendKeys(mnumber);
	driver.findElement(By.id(PR.getProperty("note"))).sendKeys(note);
	driver.findElement(By.id(PR.getProperty("add"))).click();
	List<WebElement> Cok=driver.findElements(By.xpath(PR.getProperty("OK")));
	System.out.println(Cok.size());
	for (int i = 0; i <Cok.size(); i++) 
	{
		System.out.println(Cok.get(i).getText());
		if (Cok.get(i).getText().contains("OK")) 
		{
			Cok.get(i).click();
			
		}
	}
	
	Sleeper.sleepTightInSeconds(3);
	Eval="Add succeeded";
	Aval=driver.findElement(By.xpath(PR.getProperty("availornot"))).getText();
	System.out.println(Aval);
	
	List<WebElement>sok=driver.findElements(By.xpath(PR.getProperty("addsucceded")));
	System.out.println(sok.size());
	for (int i = 0; i <sok.size(); i++) 
	{
		System.out.println(sok.get(i).getText());
		if (sok.get(i).getText().contains("OK")) 
		{
			sok.get(i).click();
			
		}
	}
	
	if(Eval.equalsIgnoreCase(Aval))
	{
      return "Pass";
	}
else
{
      return "Fail";
}
}
//StockItem
  public String StockItemCategory(String ctgryname)
	{
		  driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();
	      Actions act= new Actions(driver);
	      act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")));
	      act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a")));
	      act.click();
	      act.build().perform();
	      driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	      driver.findElement(By.id("x_Category_Name")).sendKeys(ctgryname);
	      driver.findElement(By.id("btnAction")).click();
	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	      Sleeper.sleepTightInSeconds(2);
	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	      
	      Eval="Add succeeded";
	      Aval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	      if (Eval.equalsIgnoreCase(Aval)) 
	      {
	    	  return "Pass";
		  } 
	      else
	      {
	    	  return "fail";
		  }
	}
	public String UOM1(String UOM_id,String UOM_descrptn)
	{
		  driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();
	      Actions act= new Actions(driver);
	      act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")));
	      act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")));
	      act.click();
	      act.build().perform();
	      driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	      driver.findElement(By.id("x_UOM_ID")).sendKeys(UOM_id);
	      driver.findElement(By.id("x_UOM_Description")).sendKeys(UOM_descrptn);
	      driver.findElement(By.id("btnAction")).click();
	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	      Sleeper.sleepTightInSeconds(2);
	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	      
	      Eval="Add succeeded";
	      Aval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	      if (Eval.equalsIgnoreCase(Aval)) 
	      {
	    		  return "Pass";
		  } 
	      else
	      {
	    	  return "fail";
		  }
	}
	      public String st_items(String st_categories,String sname,String stname,String UOM_id,String purchs_price,String sel_price,String notes)
	  	{
	  		  Actions act= new Actions(driver);
	  	      act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")));
	  	      act.click();
	  	      act.build().perform();
	  	      driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	  	      Select stockcategory = new Select(driver.findElement(By.id("x_Category")));
	  	      stockcategory.selectByVisibleText(st_categories);
	  	      Select suppliernum= new Select(driver.findElement(By.id("x_Supplier_Number")));
	  	      suppliernum.selectByVisibleText(sname);
	  	      driver.findElement(By.id("x_Stock_Name")).sendKeys(stname);
	  	      Select uom= new Select(driver.findElement(By.id("x_Unit_Of_Measurement")));
	  	      uom.selectByValue(UOM_id);
	  	      driver.findElement(By.id("x_Purchasing_Price")).sendKeys(purchs_price);
	  	      driver.findElement(By.id("x_Selling_Price")).sendKeys(sel_price);
	  	      driver.findElement(By.id("x_Notes")).sendKeys(notes);
	  	      driver.findElement(By.id("btnAction")).click();
	  	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	  	      Sleeper.sleepTightInSeconds(2);
	  	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	  	      
	  	      Eval="Add succeeded";
	  	      Aval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	  	      if (Eval.equalsIgnoreCase(Aval)) 
	  	      {
	  	    	  return "Pass";
	  		  } 
	  	      else
	  	      {
	  	    	  return "fail";
	  		  }
	  	}
	  	
	  	public String logout()
	  	{
	  		driver.findElement(By.linkText("Logout")).click();
	  		Sleeper.sleepTightInSeconds(2);
	  		driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	  		Sleeper.sleepTightInSeconds(2);
	  		
	  		Eval="Login";
	  		Aval=driver.findElement(By.id("btnsubmit")).getText();
	  	    
	  	    if (Eval.equalsIgnoreCase(Aval)) 
	  	    {
	  	    	return "pass";	
	  		}
	  	    else
	  	    {
	  	    	return "fail";
	  	    }
	  	}
	  	
	  	public void close()
	  	{
	  		driver.close();
	  		
	  	}

			  	
	  }



	
		
	