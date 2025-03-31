package org.RakiGowda.AppiumFramework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.RakiGowda.pageObjects.android.formPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	public static AndroidDriver d;
	public AppiumDriverLocalService service;
	public formPage p;
	
	@BeforeClass
	public void Start() throws InterruptedException, MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//KaHa//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
//		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
//		options.setApp("C:\\Users\\KaHa\\Documents\\01 - Selenium\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setApp("C:\\Users\\KaHa\\Documents\\01 - Selenium\\Appium\\src\\test\\java\\resources\\General-Store.apk");
		options.setDeviceName("Appium");
		options.setChromedriverExecutable("C:\\Users\\KaHa\\Documents\\01 - Selenium\\Appium\\src\\test\\java\\resources\\chromedriver.exe");
		options.setPlatformName("Android");
		
		
		d = new AndroidDriver( new URI("http://127.0.0.1:4723/wd/hub").toURL(), options);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3);
		
	     p = new formPage(d);
		
	}
	
	
	@AfterClass
	public void stop() {
		d.quit();
//		service.stop();
	}
	

}
