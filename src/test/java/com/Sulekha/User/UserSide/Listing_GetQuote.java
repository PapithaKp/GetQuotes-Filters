package com.Sulekha.User.UserSide;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Listing_GetQuote extends ExtentReportnew {

	@BeforeClass
	public static void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\ALLMY\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.sulekha.com/ac-services/ypcity");
		logger = extent.startTest("SETUP");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Best AC Service in Ypcity, Top Air Conditioner Service in Ypcity | Sulekha Ypcity";
		assertEquals(expectedTitle, actualTitle);
	}

	@Test(priority = 1)
	public static void Get_Quote() throws IOException {

		String GET_1 = driver.findElement(By.xpath("//h1[contains(text(),'AC Service in Ypcity')]")).getText();
		ListingUser.GetQuote(driver).click();
		driver.switchTo().frame(0);
		logger = extent.startTest("GET QUOTE");
		
		
		
	}
}
