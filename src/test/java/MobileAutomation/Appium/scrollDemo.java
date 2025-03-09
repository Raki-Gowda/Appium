package MobileAutomation.Appium;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class scrollDemo extends Base{
	@Test
	public void scrollGesture() throws InterruptedException {
		d.findElement(AppiumBy.accessibilityId("Views")).click();
		
//		d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
	   scrollToEnd();
			
		Thread.sleep(2000);
	}

}
