package org.RakiGowda.AppiumFramework;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.RakiGowda.pageObjects.android.cartPage;
import org.RakiGowda.pageObjects.android.formPage;
import org.RakiGowda.pageObjects.android.product_Catalog;
import org.RakiGowda.pageObjects.utils.androidActions;
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

public class generalStore extends Base {

	

	@Test
	public void cart_amt() throws InterruptedException {
		androidActions actions = new androidActions(d);
	    p.setNamefeild("Rakesh Kumar N");
		p.genderOptions("female");
        p.setCountrySelection("Argentina");
        product_Catalog pc = p.submitForm();
		
		 
		pc.addItemToCartByIndex(0);
		pc.addItemToCartByIndex(0);
		actions.sleep(4);
		cartPage cp = pc.gotToCart();
		actions.sleep(2);
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.attributeContains(d.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		assertEquals(cp.Our_productprize(), cp.App_CartAmount());
			
//			d.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();		
			actions.sleep(2);
			
			cp.Terms_and_conditions_longpress();
			
            cp.checkBox_check();
			
			cp.click_proceed();
			
			actions.sleep(5);
			
			
//			Set<String> contexthandles = d.getContextHandles();
//
//
//			for(String CH:contexthandles) {
//				System.out.println(CH);
//			}
//			actions.sleep(5);
//			//Not working
//			d.context("WEBVIEW_com.androidsample.generalstore");
//			actions.sleep(3);
//			d.findElement(By.name("q")).sendKeys("Rahul shetty academy");
//			actions.sleep(2);
//			d.findElement(By.name("q")).sendKeys(Keys.ENTER);
//			actions.sleep(3);
//			d.pressKey(new KeyEvent(AndroidKey.BACK));
//			d.context("NATIVE_APP");
//			
//
//				
//			
			actions.sleep(5);
	}
}
