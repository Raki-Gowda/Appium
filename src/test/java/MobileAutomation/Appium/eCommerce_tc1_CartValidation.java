package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;import javax.swing.tree.ExpandVetoException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.functions.ExpectedCondition;

public class eCommerce_tc1_CartValidation extends Base{
	
	@Test
	public void cartVaidation() throws InterruptedException {
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
		    if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
		    	d.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		    	Thread.sleep(2);
		    }
		}
		d.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(d.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		String lastpageProduct = d.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		
		assertEquals(lastpageProduct, "Jordan 6 Rings");
	}


}
