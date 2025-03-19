package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc1_Cart_Amount extends Base{
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
		
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.attributeContains(d.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		
		List<WebElement> productPrizes = d.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		Double sum = (double) 0;
		
		for(int i=0;i<productPrizes.size();i++) {
			String amountString = productPrizes.get(i).getText();
			amountString = amountString.substring(1);
			
			sum = sum + Double.parseDouble(amountString);
		}
		String AppValue = d.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		float ToTalAmt = Float.parseFloat(AppValue.substring(1));
		System.out.println("Our Value "+sum);
		System.out.println("App value " +ToTalAmt);
		
		assertEquals(sum, ToTalAmt);
		if(sum  ==  ToTalAmt) {
			d.findElement(By.className("android.widget.CheckBox")).click();
			
			d.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			
			sleep(5);
		}
	}


}
