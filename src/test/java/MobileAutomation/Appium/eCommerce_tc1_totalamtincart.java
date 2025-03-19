package MobileAutomation.Appium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc1_totalamtincart extends Base {
	@Test
	public void total_amt() throws InterruptedException{
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
		sleep(2);
		d.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		sleep(2);
		
		d.navigate().back();
       d.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nike Blazer Mid '77\"))"));
				
       int productCount1 = d.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")).size();
		for(int L=0;L<productCount1;L++) {
			String productName = d.findElements(By.id("com.androidsample.generalstore:id/productName")).get(L).getText();
		    if(productName.equalsIgnoreCase("Nike Blazer Mid '77")) {
		    	d.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
		    	Thread.sleep(2);
		    }
		    
		}
		
		sleep(2);
		d.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		WebDriverWait wait = new WebDriverWait(d,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.attributeContains(d.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		
		int totalAmt = d.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		
		int total_sum = 0;
		String b = "";
		String c = "";
		for(int j = 0;j<totalAmt;j++) {
		    String a =  d.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(j).getText();
		    if(j<1) {
		        for(int x = 0;x<a.length();x++) {
			        if(a.charAt(x) != '$') {
				       b = b + a.charAt(x);
			        }
		     }}else {
		
			     for(int x = 0;x<a.length();x++) {
				    if(a.charAt(x) != '$') {
					   c = c + a.charAt(x);
				    }
			     }
			
		   }
		}
		float total =Float.parseFloat(b) + Float.parseFloat(c);
		String cartAmt = d.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		String e = "";
		for(int x = 0;x<cartAmt.length();x++) {
			if(cartAmt.charAt(x) != '$') {
				e = e + cartAmt.charAt(x);
			}
		}System.out.println("Our Value "+total);
		System.out.println("App value " +e);
		
		if(total == Float.parseFloat(e)) {
			d.findElement(By.className("android.widget.CheckBox")).click();
			
			d.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
			
			sleep(5);
		}
		
	}

}
