package org.RakiGowda.pageObjects.android;

import java.util.List;

import org.RakiGowda.pageObjects.utils.androidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class cartPage extends androidActions{
    AndroidDriver d;
	
	public cartPage(AndroidDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(new AppiumFieldDecorator(d), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrice;
//	List<WebElement> productPrizes = d.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement totalAmount;
	
	
	@AndroidFindBy(id ="com.androidsample.generalstore:id/termsButton" )
		private WebElement t_and_c;
//		WebElement element = d.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
    
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
//    d.findElement(By.className("android.widget.CheckBox")).click();
	
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	private WebElement proceed__button;
//	d.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	
	public float Our_productprize() {
		Float sum = (float) 0.0;
		
		for(int i=0;i<productPrice.size();i++) {
			String amountString = productPrice.get(i).getText();
			amountString = amountString.substring(1);
			
			sum = sum + Float.parseFloat(amountString);
		}
		
		System.out.println("Our Value "+sum);
		return sum;
	}
	
	
	public float App_CartAmount() {
		String amount = totalAmount.getText();
		float ToTalAmt = Float.parseFloat((amount).substring(1));
		System.out.println("App value " +ToTalAmt);
		return ToTalAmt;
	}
	
       
       public void Terms_and_conditions_longpress() throws InterruptedException {
		    longPressAction(t_and_c);
		    
		   sleep(3);
			d.findElement(By.id("android:id/button1")).click();
			sleep(1);
		    
       }
		
		public void checkBox_check() {
			checkBox.click();
		}
	
	    
	    public void click_proceed() {
	    	proceed__button.click();
	    }
}
