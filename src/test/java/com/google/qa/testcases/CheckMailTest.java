package com.google.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.CheckMail;
import com.google.qa.pages.FriendsPage;
import com.google.qa.pages.LoginPage;

public class CheckMailTest extends TestBase{
	
	LoginPage loginpage;
	CheckMail checkmail;
	FriendsPage friendpage;
	
	
	public CheckMailTest() throws IOException {
		super();
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		
		checkmail=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomeTitleTest() throws InterruptedException {
		String gmailtitlenames=checkmail.verifyFacebookPagetitle();
		Assert.assertEquals(gmailtitlenames, "Facebook – log in or sign up", "page title is not matched");
	}
	
	@Test(priority=2)
	public void verifyusernameTest() {
		Assert.assertTrue(checkmail.verifyUsername());
	
	}
		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
