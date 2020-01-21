package com.Sulekha.User.UserSide;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ListingPage extends ExtentReportnew {

	// static WebDriver driver;
	static String h1 = "AC Service in Ypcity";
	static JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	@BeforeClass(alwaysRun = true)
	public static void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\ALLMY\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ListingUser.Site_url(driver);
		String actualTitle = driver.getTitle();
		logger = extent.startTest("SETUP");
		System.out.println(actualTitle);
	}

	@Test(priority = 1)
	public static void Get_Quote() throws IOException {

		ListingUser.GetQuote(driver).click();
		driver.switchTo().frame(0);
	logger = extent.startTest("GET QUOTE");
	ListingUser.LCF_selection(driver);	
	
		}	

	@Test(priority = 2)
	public static void Save_To_Phone() throws InterruptedException, IOException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		ListingUser.Save_to_mobile(driver).click();
		String Save_1 = driver.findElement(By.xpath("//h4[contains(text(),'Get contact details')]")).getText();
		System.out.println(Save_1);
		logger = extent.startTest("SAVE TO PHONE");
		Assert.assertEquals(h1, Save_1);
	}

	@Test(priority = 3)
	public static void Filter_listing() throws InterruptedException, IOException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		jse.executeScript("scroll(0,600);");
		driver.findElement(By.xpath("//div[@class='bankoffer active']//span[@class='close']")).click();
		ListingUser.filters(driver).click();
		WebElement rveiew_filter = driver
				.findElement(By.xpath("//div[@class='sd-menu']/ul/li/a[contains(text(),'Review')]"));
		rveiew_filter.click();
		System.out.println(rveiew_filter.getText());
		logger = extent.startTest("Clicked REVIEW option on droplist");
	}

	@Test(priority = 4)
	public static void Listing_ViewMore() throws InterruptedException, IOException {
		driver.navigate().refresh();
		Thread.sleep(4000);
		jse.executeScript("scroll(0,2500);");
		ListingUser.Listing_View(driver).click();
		Thread.sleep(5000);
		WebElement view = driver.findElement(By.xpath("//a[@class='btn-t pagination loadlist']"));
		if (view.isDisplayed()) {
			System.out.println("VIEW MORE FEATURE is working fine");
			logger = extent.startTest("VIEW_MORE - Link checking");
		} else {
			System.out.println("VIEW MORE FEATURE is  not working fine");
			logger = extent.startTest("VIEW_MORE - Link checking");
		}
	}
	@Test(priority = 5)
	public static void Filter_locality() throws InterruptedException, IOException {
		driver.navigate().refresh();
		jse.executeScript("scroll(0,1600);");
		WebElement locality_downarrow=driver.findElement(By.xpath("//div[@class='filter']/ul/li//strong[contains(text(),'Locality')]"));
		locality_downarrow.click();
		if(	ListingUser.Filter_locality(driver).isDisplayed()) {
		System.out.println(driver.findElement(By.xpath("//div[@class='filter']/ul/li/div[@class='filter-panel sa-panel']//ul[@id='ul-localities']/li")).getText());
			System.out.println("Locality option is enabled for city page");
		logger = extent.startTest("Locality section - Visible in city page");
		}else {
			System.out.println("Locality section is not displaye");
			logger = extent.startTest("Locality section - Not-Visible in city page\"");
		}
		}

	@AfterMethod
	public void endReport() {
		extent.flush();
		
	}
	
}
