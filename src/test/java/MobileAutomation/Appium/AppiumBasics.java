package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends Base{
	
	@Test
	public void WifiSettingname() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		d.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		d.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		
		d.findElement(By.id("android:id/checkbox")).click();
		
		d.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
		
		String alertitle = d.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		
		d.findElement(AppiumBy.id("android:id/edit")).sendKeys("Rakesh  wifi");
		
		assertEquals(alertitle, "WiFi settings");
		
		d.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
	    	
	
		
		
		
		
		
		
	}

}
