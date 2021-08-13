package com.google.qa.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class CheckMail extends TestBase{
	@FindBy(xpath="//span[text()='Mohammed Hamed']")
	@CacheLookup// this is used to store the xpath/name/id to the cache memory to improves the script run performance.
	WebElement facebooktitle;
	

	
	public CheckMail() throws Exception {
		PageFactory.initElements(driver, this);
		
	}
	
	
	public String verifyFacebookPagetitle() {
		return driver.getTitle();
	}
	public boolean verifyUsername() {
		System.out.println("taken the screenshot");
		return facebooktitle.isDisplayed();	
	
			
			
			
				}

}
