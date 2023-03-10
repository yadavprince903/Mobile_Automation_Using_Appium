package Appium_Learn.Appium;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends Base {
	@Test
	public void WifiSettings() {
		
				driver.findElement(AppiumBy.accessibilityId("Preference")).click();
				driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
				driver.findElement(By.id("android:id/checkbox")).click();
				driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
								
				Assert.assertEquals(driver.findElement(By.id("android:id/alertTitle")).getText(),"WiFi settings");
							
				driver.findElement(By.id("android:id/edit")).sendKeys("airtelwifi");
				driver.findElement(By.id("android:id/button1")).click();
		
	}

}
