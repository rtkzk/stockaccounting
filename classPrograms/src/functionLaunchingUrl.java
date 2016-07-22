import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class functionLaunchingUrl {
	static String url="http://orangehrm.com";
	static WebDriver driver;
	
	public static void main(String[] args) {
		String res;
		res=LaunchApp(url);
		
		
	}
	public static void launchApp(String url)
	{
		driver.get(url);
		if(driver.findElement(By.id("btnLogin"))).isDisplayed();
		{
			return "pass";
		}
		else
		{
			return "failed";
			
			public static String adminlogout(String logout)
			{
				driver=new FirefoxDriver();
				driver.findElement(By.id("logout")).click();
				Aval=driver.findElement(By.xpath(".//*[@id='msLoginDialog']/div/div/div[1]/h4")).getText();
				if(Aval.equalsIgnoreCase(Eval))
				{
					return "system logout successfylly";
				}
				else
				{
					return "system redirected to some other page";
				}
				public static void adminClose()
				{
					driver.close();
				}
				
				
		}
	}

}
