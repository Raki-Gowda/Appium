package org.RakiGowda.pageObjects.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

public class product_Catalog {
	AndroidDriver d;
	
	public product_Catalog(AndroidDriver d) {
		this.d = d;
		PageFactory.initElements(new AppiumFieldDecorator(d), this);
	}
	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ADD TO CART\"]")
	private List<WebElement> addToCart;
//	d.findElements(By.xpath("//android.widget.TextView[@text=\"ADD TO CART\"]")).get(0).click();
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart_icon;
//	d.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
	
	public void addItemToCartByIndex(int index) {
		addToCart.get(index).click();
	}
	public cartPage gotToCart() throws InterruptedException {
		try {
			cart_icon.click();
		} catch (Exception e) {
			TouchAction touchAction = new TouchAction(d);
			int xPoint = 980;
			int yPoint = 132;
			touchAction.tap(PointOption.point(xPoint , yPoint)).perform();
		}
		Thread.sleep(2000);
		return new cartPage(d);
	}
	

}
