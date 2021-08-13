package com.google.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.qa.base.TestBase;
import com.google.qa.pages.CheckMail;
import com.google.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	CheckMail gmailpage;
public LoginPageTest() throws IOException {
	super();
}		

@BeforeMethod
public void setUp() throws IOException {
	initialization();
	 loginpage= new LoginPage();
}

@Test(priority=1)
public void loginPageTitleTest() {
	String title=loginpage.validateloginPagetitle();
	Assert.assertEquals(title, "Gmail");
}

@Test(priority=2)
public void gmaillogoTest() {
	boolean flag=loginpage.ValidategoogleImage();
	Assert.assertTrue(flag);
}

@Test(priority=3)
public void loginTest() throws Exception {
	gmailpage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));//as the return type of login is the gmail page
}

@AfterMethod
public void tearDown() {
	driver.quit();
}
}

