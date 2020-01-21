package com.Sulekha.User.UserSide;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Need_Page extends ExtentReportnew {
	
	 static JavascriptExecutor js =(JavascriptExecutor)driver;
	
	@BeforeClass(alwaysRun = true)
	public static void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\ALLMY\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www4.sulekha.com/stretch-ceiling-repair-services/");
		String actualTitle = driver.getTitle();
		logger = extent.startTest("SETUP");
		System.out.println(actualTitle);
	}

	@Test(priority=0 ,enabled = true)
	public static void need_india_page() throws InterruptedException {

		ListingUser.Indiapage_City_lcf(driver);
		logger = extent.startTest("City section on LCF -INDIA PAGE");
		
}

	@Test(priority = 1)
	public static void filter_india_page() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println(driver);
		//js.executeScript("window.scrollBy(0,1600)");
		String city_filter_section = driver.findElement(By.xpath("//div[@class='filter']/ul/li[1]")).getText();
		if (city_filter_section.contains("Chennai")) {
			System.out.println("City option is displayed");
		}else
			System.out.println("Filter section , city selection is not displayed");
	}
	
	@Test(priority = 2)
	public static void Get_Quote() throws IOException {

		ListingUser.GetQuote(driver).click();
		driver.switchTo().frame(0);
	logger = extent.startTest("GET QUOTE");
	ListingUser.LCF_selection(driver);	
	
		}	

	@Test(priority = 3)
	public static void Save_To_Phone() throws InterruptedException, IOException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		ListingUser.Save_to_mobile(driver).click();
		String Save_1 = driver.findElement(By.xpath("//h4[contains(text(),'Get contact details')]")).getText();
		System.out.println(Save_1);
		logger = extent.startTest("SAVE TO PHONE");
		Assert.assertEquals("Get contact details", Save_1);
		//Form submission
	   ListingUser.SAVE_TO_FONE(driver);
	
	}


}
	