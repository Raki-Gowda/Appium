package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class longPress extends Base {
	@Test
	public void LongPress() throws InterruptedException {
		d.findElement(AppiumBy.accessibilityId("Views")).click();
		
		d.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]")).click();
		
		d.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		
		WebElement element = d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"People Names\")"));
		
		longPressAction(element);
		
		String sampleMenu = d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")")).getText();
		
		assertEquals(sampleMenu, "Sample menu");
		
		assertTrue(d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Sample menu\")")).isDisplayed());
		Thread.sleep(2000);
		
	}
	
	
	

}
