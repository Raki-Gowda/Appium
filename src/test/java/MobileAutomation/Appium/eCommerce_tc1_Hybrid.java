package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc1_Hybrid extends Base {

	

	@Test
	public void cart_amt() throws InterruptedException {
		d.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rakesh Kumar N");
		d.hideKeyboard();
		d.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();	
		d.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"))"));
		d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Argentina\")")).click();
		d.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		d.findElements(By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();
		d.findElements(By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();
		
		d.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		sleep(2);
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.attributeContains(d.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		
		List<WebElement> productPrizes = d.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		Float sum = (float) 0.0;
		
		for(int i=0;i<productPrizes.size();i++) {
			String amountString = productPrizes.get(i).getText();
			amountString = amountString.substring(1);
			
			sum = sum + Float.parseFloat(amountString);
		}
		String AppValue = d.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		float ToTalAmt = Float.parseFloat(AppValue.substring(1));
		System.out.println("Our Value "+sum);
		System.out.println("App value " +ToTalAmt);
		
		assertEquals(sum, ToTalAmt);
			
//			d.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();		
			sleep(2);
			
			WebElement element = d.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			longPressAction(element);
			
			sleep(3);
			d.findElement(By.id("android:id/button1")).click();
			sleep(1);
			
            d.findElement(By.className("android.widget.CheckBox")).click();
			
			d.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			
			sleep(5);
			
			
			Set<String> contexthandles = d.getContextHandles();


			for(String CH:contexthandles) {
				System.out.println(CH);
			}
			sleep(5);
			//Not working
			d.context("WEBVIEW_com.androidsample.generalstore");
			sleep(3);
			d.findElement(By.name("q")).sendKeys("Rahul shetty academy");
			sleep(2);
			d.findElement(By.name("q")).sendKeys(Keys.ENTER);
			sleep(3);
			d.pressKey(new KeyEvent(AndroidKey.BACK));
			d.context("NATIVE_APP");
			

				
			
		    sleep(5);
	}
}
