package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class DragandDrop extends Base
{
	@Test
	public void dragdropgeature() throws InterruptedException {
		d.findElement(AppiumBy.accessibilityId("Views")).click();;
		d.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();;
		 WebElement from_element = d.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
		 draganddropgestures(from_element, 650,579);
		 sleep(2);
		 assertEquals(d.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");
	}

}
