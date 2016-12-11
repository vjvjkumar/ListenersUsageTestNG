package Pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
//depends on methods and listeners and priority method execution.
//@Listeners(CustomTestListener.class)
public class MytestListeners {
	WebDriver driver;
	@BeforeMethod
	public void beforemethod(){
		//System.out.println("Test execution started");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void google() throws Exception{		
		driver.get("http://google.com");
	}
	@Test(dependsOnMethods="google")
	public void gmail() throws Exception{		
		driver.get("http://google.com");
		driver.findElement(By.linkText("Gmail")).click();
		driver.findElement(By.id("Email")).sendKeys("vardhan.kg");
		driver.findElement(By.id("next")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("Passw")).sendKeys("vardhan.kg");
		driver.findElement(By.id("signIn")).click();
	}
	
	@Test(dependsOnMethods="gmail")
	public void quikr() throws Exception{		
		driver.get("http://quikr.com");
	}
	
	@Test(dependsOnMethods="gmail")
	public void yahoo() throws Exception{		
		driver.get("http://yahoo.com");
	}
	
	@AfterMethod
	public void aftermethod(){
		driver.quit();
		//System.out.println("Test executed successfully");
	}

}
