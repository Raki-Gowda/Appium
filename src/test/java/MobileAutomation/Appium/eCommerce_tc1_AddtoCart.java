package MobileAutomation.Appium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc1_AddtoCart extends Base {
	@Test
	public void add_to_Cart() throws InterruptedException {
	
	d.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rakesh Kumar N");
	d.hideKeyboard();
	d.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();	
	d.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
	d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")")).click();
	d.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
	
	int productCount = d.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
	
	for(int i=0;i<productCount;i++) {
		String productName = d.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	    if(productName.equals("Jordan 6 Rings")) {
	    	d.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
	    	Thread.sleep(2);
	    	d.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	    }
	}
	Thread.sleep(2);
}
}
