package org.RakiGowda.pageObjects.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class androidActions {
	
	
	AndroidDriver d;
	public androidActions(AndroidDriver d) {
		this.d = d;
		PageFactory.initElements(new AppiumFieldDecorator(d), this);
	}

public Double getFormattedAmount(String amount) {
		
		Double Price = Double.parseDouble(amount);
		
		return Price;
				
	}
	
	public void scrollIntoView(String text) {
		d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}
	
	public void sleep(int a) throws InterruptedException {
		Thread.sleep(a * 1000);
	}
	
	public void draganddropgestures(WebElement from_element,int toX, int toY) {
		((JavascriptExecutor) d).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) from_element).getId(),
			    "endX", 650,
			    "endY", 579
			));
	}
	
	public void longPressAction(WebElement element) {
		((JavascriptExecutor) d).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"duration",2000
			));
	}
	
	public void scrollToEnd() {
		boolean canScrollMore;
		do {
		 canScrollMore = (Boolean) ((JavascriptExecutor) d).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 1.0
			)); 
		}
		while(canScrollMore);
	}
	
	public void swipeGesture(WebElement ele,String direction) {
		((JavascriptExecutor) d).executeScript("mobile: swipeGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
		
	} 
	

}
