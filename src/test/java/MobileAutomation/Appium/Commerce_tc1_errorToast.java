package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Commerce_tc1_errorToast extends Base{
	
	@SuppressWarnings("deprecation")
	@Test
	public void toast_error() {
//		d.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rakesh Kumar N");
//		d.hideKeyboard();
		d.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();	
		d.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")")).click();
		d.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		String toast_message= d.findElement(AppiumBy.xpath("//android.widget.Toast[1]")).getAttribute("name");
		assertEquals(toast_message,"Please enter your name");
	}

}
