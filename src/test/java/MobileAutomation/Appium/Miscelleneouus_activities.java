package MobileAutomation.Appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javax.management.openmbean.KeyAlreadyExistsException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscelleneouus_activities extends Base{
	
	@Test
	public void WifiSettingname() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		d.findElement(AppiumBy.accessibilityId("Preference")).click();
		
		d.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		
		d.findElement(By.id("android:id/checkbox")).click();
		
		DeviceRotation landsccape = new DeviceRotation(0, 0, 90);
		
		d.rotate(landsccape);
		
		d.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)")).click();
		
		String alertitle = d.findElement(AppiumBy.id("android:id/alertTitle")).getText();
		
		d.setClipboardText("Rakesh  wifi");
		
		d.findElement(AppiumBy.id("android:id/edit")).sendKeys(d.getClipboardText());
		
		d.pressKey(new KeyEvent(AndroidKey.ENTER));
		
		assertEquals(alertitle, "WiFi settings");
		
		d.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		d.pressKey(new KeyEvent(AndroidKey.BACK));
		
		d.pressKey(new KeyEvent(AndroidKey.HOME));
		
	    	
	
		
		
		
		
		
		
	}

}
