package com.actitime.generics;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	
	@BeforeSuite
	public void executionstart()
	{
		Reporter.log("execution started" , true);
	}
	
	@Parameters("browser")
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@BeforeMethod
	public void enterURL()
	{
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);	
	}
	
	@AfterClass
	public void teardown()
	{
		//driver.quit();
	}
	
	@AfterSuite
	public void executioncomplete()
	{
		Reporter.log("execution completed" , true);
	}
}