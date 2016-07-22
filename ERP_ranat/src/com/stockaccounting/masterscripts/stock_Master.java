package com.stockaccounting.masterscripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;



public class stock_Master 
{
	public static Properties pr;
	public static FileInputStream fis;
	public static WebDriver driver;
	public static String expval,actval;
	
	
	public String openApp(String URL) throws IOException 
    {
    pr=new Properties();
    fis=new FileInputStream("D:\\puja\\automation scripts\\Stock Accounting\\src\\com\\ERP\\properties\\repository.properties");
	pr.load(fis);	
	expval="Login";
    driver=new FirefoxDriver();
    driver.get(URL);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
    
    
    actval=driver.findElement(By.id(pr.getProperty("submit"))).getText();
    
    if (expval.equalsIgnoreCase(actval)) 
    {
    	return "pass";	
	}
    else
    {
    	return "fail";
    }
    
    }
	
	public String Login(String uname,String pwd) 
	{
		driver.findElement(By.id(pr.getProperty("reset"))).click();
	    driver.findElement(By.id(pr.getProperty("uname"))).sendKeys(uname);;
	    driver.findElement(By.id(pr.getProperty("pwd"))).sendKeys(pwd);
	    driver.findElement(By.id(pr.getProperty("submit"))).click();
	    
	    expval="Administrator";
	    actval= driver.findElement(By.xpath(pr.getProperty("admin"))).getText();
	    if (expval.equalsIgnoreCase(actval)) 
	    {
			return "Pass";
		}
	    else
	    {
	    	return "Fail";
	    }
		
	}
	
	
	public String supplier_creation(String sname,String addy,String city,String Country,String Cntctprsn,String phnnum,String email,String mobnum,String notes)
	{
		  driver.findElement(By.linkText("Suppliers")).click();
	      driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a/span")).click();
	      driver.findElement(By.id("x_Supplier_Name")).sendKeys(sname);
	      driver.findElement(By.id("x_Address")).sendKeys(addy);
	      driver.findElement(By.id("x_City")).sendKeys(city);
	      driver.findElement(By.id("x_Country")).sendKeys(Country);
	      driver.findElement(By.id("x_Contact_Person")).sendKeys(Cntctprsn);
	      driver.findElement(By.id("x_Phone_Number")).sendKeys(phnnum);
	      driver.findElement(By.id("x__Email")).sendKeys(email);
	      driver.findElement(By.id("x_Mobile_Number")).sendKeys(mobnum);
	      driver.findElement(By.id("x_Notes")).sendKeys(notes);
	      driver.findElement(By.id("btnAction")).click();
	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	      Sleeper.sleepTightInSeconds(5);
	      driver.findElement(By.xpath(".//*[@class='ajs-button btn btn-primary']")).click();
	      
	      expval="Add succeeded";
	      actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	      if (expval.equalsIgnoreCase(actval)) 
	      {
	    	  return "Pass";
		  } 
	      else
	      {
	    	  return "fail";
		  }
	      
	}
	
	
	public String st_categories(String ctgryname)
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
	      
	      expval="Add succeeded";
	      actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	      if (expval.equalsIgnoreCase(actval)) 
	      {
	    	  return "Pass";
		  } 
	      else
	      {
	    	  return "fail";
		  }
	}

	public String UOM(String UOM_id,String UOM_descrptn)
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
	      
	      expval="Add succeeded";
	      actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	      if (expval.equalsIgnoreCase(actval)) 
	      {
	    	 //System.out.println(expval+ "is equal to "+ actval+ ", Test pass"); 
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
	      
	      expval="Add succeeded";
	      actval=driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[3]/div/div")).getText();
	      if (expval.equalsIgnoreCase(actval)) 
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
		
		expval="Login";
		actval=driver.findElement(By.id("btnsubmit")).getText();
	    
	    if (expval.equalsIgnoreCase(actval)) 
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
