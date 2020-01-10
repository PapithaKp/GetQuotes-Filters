package com.Sulekha.User.UserSide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ListingUser {

	// static WebDriver driver;

	static By Get_Qte = By.xpath("//div[@class='span9 listing-wrap']/ol/li[1]/div/div[3]/button[2]");

	static By Savemob = By.xpath("//div[@class='span9 listing-wrap']/ol/li[1]/div/div[3]/button[1]");

	static By listcount = By.xpath("//div[@class='span9 listing-wrap']/ol/li");

	static By Tnc = By.xpath("//a[@class='tnc'][1]//parent::div[@class='head']");

	static By imagesload = By.id("listingtabcontent");

	static By filter =By.xpath("//a[@class='input sd-link f-icon'][contains(text(),'Default')]");
	
	static By filter_Review =By.xpath("//div[@class='sd-menu']/ul/li/a[contains(text(),'Review')]");
	
	// SAVE TO PHONE
	public static WebElement Save_to_mobile(WebDriver driver) {
		
		return driver.findElement(Savemob);
	}	

//GET QUOTE 
	public static WebElement GetQuote(WebDriver driver) {
		return driver.findElement(Get_Qte);
	}
	
	public static WebElement filters(WebDriver driver) {
		 driver.findElement(filter);
		 driver.findElement(filter_Review);
		 return null;
}
	
	
}