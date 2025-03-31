package org.RakiGowda.pageObjects.android;

import org.RakiGowda.pageObjects.utils.androidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class formPage extends androidActions{ 
	AndroidDriver d;
	
	public formPage(AndroidDriver d) {
		super(d);
		this.d = d;
		PageFactory.initElements(new AppiumFieldDecorator(d), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
//	d.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rakesh Kumar N");
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOptions;
//	d.findElement(By.xpath("//android.widget.RadioButton[@text=\"Female\"]")).click();
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleOptions;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countrySpinner;
//	d.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
//	d.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	
	public void setNamefeild(String name) {
		nameField.sendKeys(name);
		d.hideKeyboard();
	}
	
	public void genderOptions(String  gender) {
		if(gender.contains("female")) {
			femaleOptions.click();
		}else {
		}
	}
	
	public void setCountrySelection(String contry) {
		countrySpinner.click();
		scrollIntoView(contry);
		d.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\""+contry+"\")")).click();	
	    
	}
	
	public product_Catalog submitForm() {
		shopButton.click();
		return new product_Catalog(d);
	}
	


	 
}
   