package Appium_Learn.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MiscellaneuosAppium extends Base {

	@Test
	public void WifiSettings() {
		
				driver.findElement(AppiumBy.accessibilityId("Preference")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
				driver.findElement(By.id("android:id/checkbox")).click();
				DeviceRotation landscape= new DeviceRotation(0,0,90);
				driver.rotate(landscape);
				driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
								
				Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
				driver.findElement(By.id("android:id/edit")).sendKeys("airtelwifi");
				driver.setClipboardText("xyz");		
				driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());				
				driver.findElement(By.id("android:id/button1")).click();
				driver.pressKey(new KeyEvent(AndroidKey.BACK));
				driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
	
}
