package com.Sulekha.User.UserSide;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	
	public static String screenshotz(WebDriver driver,String Sc1) throws IOException {
		   
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot Ts= (TakesScreenshot) driver;
		File source= Ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"/screenshotName/"+Sc1+dateName+".png";
		File Target = new File(destination);
		try {
			FileUtils.copyFile(source, Target);
		} 
		catch (Exception e) 
		{
			System.out.println("Screenshots failed");
		}

	     return destination;
            
	}
	
	}

