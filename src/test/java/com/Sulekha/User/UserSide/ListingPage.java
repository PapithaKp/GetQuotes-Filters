package com.Sulekha.User.UserSide;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ListingPage extends ExtentReportnew  {

	//static WebDriver driver;
	static String h1 = "AC Service in Ypcity";
	

	@BeforeClass
	public static void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\ALLMY\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.sulekha.com/ac-services/ypcity");
		logger = extent.startTest("2");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Best AC Service in Ypcity, Top Air Conditioner Service in Ypcity | Sulekha Ypcity";
		assertEquals(expectedTitle,actualTitle);
		}

	@Test(priority = 1)
	public static void Get_Quote() throws IOException {
		
		String GET_1 = driver.findElement(By.xpath("//h1[contains(text(),'AC Service in Ypcity')]")).getText();
		ListingUser.GetQuote(driver).click();
		driver.switchTo().frame(0);
		System.out.println(GET_1);
		logger = extent.startTest("passTest");
		Assert.assertEquals(h1, GET_1);
	
	}
	@Test(priority = 2)
	public static void Save_To_Phone() throws InterruptedException, IOException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		ListingUser.Save_to_mobile(driver).click();
		String Save_1 = driver.findElement(By.xpath("//h4[contains(text(),'Get contact details')]")).getText();
		System.out.println(Save_1);
		logger = extent.startTest("passTest");
		Assert.assertEquals(h1, Save_1);
		 
	}
	
	@AfterClass
	public void endReport() {
		
		extent.flush();
	   extent.close();
	}
	
}
