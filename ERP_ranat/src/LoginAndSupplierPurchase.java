import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.Select;


public class LoginAndSupplierPurchase {

	
	public static void main(String[] args) 
		{
			ProfilesIni pr=new ProfilesIni();
			FirefoxProfile fp=pr.getProfile("ranaSelenium");
		
		WebDriver driver=new FirefoxDriver(fp);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
        String  expurl ="Login";
		
		
		driver.get("http://webapp.qedgetech.com/");
		 String acturl=driver.findElement(By.id("btnsubmit")).getText();
		if(expurl.equalsIgnoreCase(acturl))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("Failed");
		}
		driver.findElement(By.id("btnreset")).click();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("master");
		driver.findElement(By.id("btnsubmit")).click();
		/*driver.findElement(By.linkText("Suppliers")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		driver.findElement(By.id("x_Supplier_Name")).sendKeys("ABCD123");
		driver.findElement(By.id("x_Address")).sendKeys("Hyderabad");
		driver.findElement(By.id("x_City")).sendKeys("Hyderabad");
		driver.findElement(By.id("x_Country")).sendKeys("India");
		driver.findElement(By.id("x_Contact_Person")).sendKeys("suresh babu");
		driver.findElement(By.id("x_Phone_Number")).sendKeys("9898989898");
		driver.findElement(By.id("x__Email")).sendKeys("suresh@gmail.com");
		driver.findElement(By.id("x_Mobile_Number")).sendKeys("7878787878");
		driver.findElement(By.id("x_Notes")).sendKeys("This supplier supplys Electronic goods");
		driver.findElement(By.id("btnAction")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		Sleeper.sleepTightInSeconds(5);
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();*/
		//stockItem
		/*Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")));
		act.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_categories']/a")));
		act.click();
		act.build().perform();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		driver.findElement(By.id("x_Category_Name")).sendKeys("Mobile");
		driver.findElement(By.id("btnAction")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();*/
		//unit of measurement
		/*Actions act1=new Actions(driver);
		act1.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")));
		act1.moveToElement(driver.findElement(By.xpath(".//*[@id='mi_a_unit_of_measurement']/a")));
		act1.click();
		act1.build().perform();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		driver.findElement(By.id("x_UOM_ID")).sendKeys("adc123");
		driver.findElement(By.id("x_UOM_Description")).sendKeys("Have a nice day");
		driver.findElement(By.id("btnAction")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button")).click();*/
		//stock creation
	
		driver.findElement(By.xpath(".//*[@id='mi_a_stock_items']/a")).click();
		driver.findElement(By.xpath(".//*[@id='ewContentColumn']/div[3]/div[1]/div[1]/div[1]/div/a")).click();
		
		//drop down element
		
		WebElement mb=driver.findElement(By.id("x_Category"));
		Select st=new Select(mb);
		st.selectByVisibleText("Mobile");
		
		WebElement m=driver.findElement(By.id("x_Supplier_Number"));
		Select t=new Select(m);
		t.selectByVisibleText("abcd");
		
		driver.findElement(By.id("x_Stock_Name")).sendKeys("cd player");
		
		WebElement b=driver.findElement(By.id("x_Unit_Of_Measurement"));
		Select n=new Select(b);
		n.selectByVisibleText("100 KGs");
		
		driver.findElement(By.id("x_Purchasing_Price")).sendKeys("2000");
		driver.findElement(By.id("x_Selling_Price")).sendKeys("3000");
		driver.findElement(By.id("x_Notes")).sendKeys("1000 profit");
		driver.findElement(By.id("btnAction")).click();
		driver.findElement(By.xpath("html/body/div[17]/div[2]/div/div[4]/div[2]/button[1]")).click();
		
		
	
	}

}



	
