package com.google.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.google.qa.util.TestUtil;
import com.google.qa.util.WebEventListener;

public class TestBase {
public static WebDriver driver;
public static Properties prop;
public  static EventFiringWebDriver ef_driver;
public static WebEventListener eventListener;

public TestBase() throws IOException {
	prop=new Properties();
	try {
		FileInputStream ip=new FileInputStream("D:\\Eclipse\\GoogleAutomationTesting\\src\\main\\java\\com\\google\\qa\\config\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}

public static void initialization() throws IOException {
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\webdrivers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		ef_driver = new EventFiringWebDriver(driver);// create object of event firing web driver class
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		ef_driver.register(eventListener);
		driver = ef_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		System.out.println(prop.getProperty("url"));
	}
}

}
