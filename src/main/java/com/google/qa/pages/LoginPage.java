package com.google.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.qa.base.TestBase;

public class LoginPage extends TestBase{

	
		
		@FindBy(xpath="//input[@type='text']")
		WebElement gmailuser;
		@FindBy(xpath="//input[@type='password']")
		WebElement gmailpassword;
		@FindBy(xpath="//span[contains(text(),'Next')]")
		WebElement nextbtn;
		@FindBy(xpath="//button[contains(text(),'Log In')]")
		WebElement signInbtn;
		@FindBy (xpath="//*[@id='logo']")
		WebElement LogoTest;
		
		public LoginPage() throws IOException {
			PageFactory.initElements(driver, this);//to initialize page objects,all webbelements declared above will be initialized to the driver;
		}
		public String validateloginPagetitle() {
			return driver.getTitle();
		}
		public boolean ValidategoogleImage() {
			return LogoTest.isDisplayed();
		}
		public CheckMail login(String un, String pwd) throws Exception {
			gmailuser.sendKeys(un);
			//nextbtn.click();			
			gmailpassword.sendKeys(pwd);
			signInbtn.click();
			return new CheckMail();
		}

}
