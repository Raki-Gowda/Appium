package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class SwipeDemo extends Base{
	
	@Test
	public void swipeGesture() {
		d.findElement(AppiumBy.accessibilityId("Views")).click();
		
		d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Gallery\")")).click();
		
		d.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		
		WebElement ele = d.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)"));
//		new UiSelector().className("android.widget.ImageView").instance(0)
		assertEquals(d.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)")).getAttribute("focusable"),"true");
		
		swipeGesture(ele,"left");
		assertEquals(d.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)")).getAttribute("focusable"),"false");
	}
	

}
