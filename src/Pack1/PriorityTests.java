package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//depends on methods and listeners and priority method execution.
@Listeners(CustomIExecutionListener.class)
public class PriorityTests {
	WebDriver driver;
	@BeforeMethod
	public void beforemethod(){
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test(priority=4)
	public void google() throws Exception{		
		driver.get("http://google.com");
	}
	@Test(priority=2)
	public void gmail() throws Exception{		
		driver.get("http://google.com");
		driver.findElement(By.linkText("Gmail")).click();
		driver.findElement(By.id("Email")).sendKeys("vardhan.kg");
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Passwd")).sendKeys("vardhan.kg");
		driver.findElement(By.id("signIn")).click();
	}
	
	@Test(priority=1)
	public void quikr() throws Exception{		
		driver.get("http://quikr.com");
	}
	
	@Test(priority=3)
	public void yahoo() throws Exception{		
		driver.get("http://yahoo.com");
	}
	
	@AfterMethod
	public void aftermethod(){
		driver.quit();
	}

}
