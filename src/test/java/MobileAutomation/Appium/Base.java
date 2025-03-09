package MobileAutomation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
	
	public static AndroidDriver d;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void Start() throws InterruptedException, MalformedURLException, URISyntaxException {
		service = new AppiumServiceBuilder().withAppiumJS(new File("C://Users//KaHa//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		
//		service.start();
		UiAutomator2Options options = new UiAutomator2Options();
		options.setApp("C:\\Users\\KaHa\\Documents\\01 - Selenium\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setDeviceName("Appium");
		options.setPlatformName("Android");
		
		
		d = new AndroidDriver( new URI("http://127.0.0.1:4723/wd/hub").toURL(), options);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	public void longPressAction(WebElement element) {
		((JavascriptExecutor) d).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"duration",2000
			));
	}
	
	public void scrollToEnd() {
		boolean canScrollMore;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) d).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 1.0
			)); 
		}
		while(canScrollMore);
	}
	
	public void swipeGesture(WebElement ele,String direction) {
		((JavascriptExecutor) d).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
		
	} 
	
	
	@AfterClass
	public void stop() {
		d.quit();
//		service.stop();
	}
	

}
