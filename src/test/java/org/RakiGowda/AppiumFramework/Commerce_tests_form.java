package org.RakiGowda.AppiumFramework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Commerce_tests_form extends Base{
	
	
	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public void toast_error() {
//		d.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rakesh Kumar N");
//		d.hideKeyboard();
		d.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();	
//		d.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
//		d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
//		d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")")).click();
		d.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toast_message= d.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getAttribute("name");
		assertEquals(toast_message,"Please enter your name");
	}
	
	@Test(priority = 2)
	public void fillForm_positiveFlow() {
		d.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rakesh Kumar N");
		d.hideKeyboard();
		d.findElement(By.xpath("//android.widget.RadioButton[@text=\"Male\"]")).click();	
		d.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")")).click();
		int toast_message= d.findElements(AppiumBy.xpath("//android.widget.Toast[1]")).size();
		assertTrue(toast_message<1);
		d.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

}
}