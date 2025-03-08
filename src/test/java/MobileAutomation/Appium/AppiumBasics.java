package MobileAutomation.Appium;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class AppiumBasics extends Base{
	
	@Test
	public void WifiSettingname() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		d.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		
	}

}
