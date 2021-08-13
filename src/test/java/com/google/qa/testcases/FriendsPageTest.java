package com.google.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.CheckMail;
import com.google.qa.pages.FriendsPage;
import com.google.qa.pages.LoginPage;
import com.google.qa.util.TestUtil;

public class FriendsPageTest extends TestBase{
	LoginPage loginpage;
	CheckMail checkmail;
	FriendsPage friendspage;
	TestUtil testutil;
	String sheetName="contacts";
	public FriendsPageTest() throws IOException {
		super();
		
	}
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage = new LoginPage();
		friendspage= new FriendsPage();
		 testutil = new TestUtil();
		checkmail=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
/*	@Test(priority=1)
	public void verifyHomeTitleTest() throws InterruptedException {
		String gmailtitlenames=checkmail.verifyFacebookPagetitle();
		Assert.assertEquals(gmailtitlenames, "Facebook – log in or sign up", "page title is not matched");
	}*/
	
	/*@Test(priority=2)
	public void verifylinkTest() {
		Assert.assertTrue(friendspage.verifylink(), "BirthDay title not present on the page");
		
		
	}*/
	//,dataProvider="getgoogleData"
	/*@Test(priority = 1)
	public void validatenewData(String a, String b, String c, String d) {
		friendspage.enterdetails(a,b,c,d);
		
	}*/
	
	@DataProvider
	/*public Object[][] getgoogleData(){
		//Object data[][]=TestUtil.getTestData(sheetName);
		Object data[][]="data";
		return data;
	}*/
	
	
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
