package com.google.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;

import com.google.qa.base.TestBase;

public class FriendsPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Birthdays')]")
	WebElement birtdaylnk;

	public FriendsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

public void enterdetails(String a,String b, String c, String d) {
	System.out.println(a +"  "+b+" "+c+" "+d);
}
public boolean verifylink() {
	return birtdaylnk.isDisplayed();
}
}
