package Appium_Learn.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import utilities.AndroidGestures;

public class ViewsTest extends Base {

	@Test(enabled = false)
	public void LongpressGesture()  {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement peopleName=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		//clib.LogPress(peopleName,driver);
		WebElement sample_menu=driver.findElement(By.id("android:id/title"));
		Assert.assertEquals(sample_menu.getText(), "Sample menu");
		Assert.assertTrue(sample_menu.isDisplayed());
		
	}
	
	@Test(enabled = false)
	public void scrolltoWebview() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		 driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector)).scrollIntoView(text(\"WebView\"));"));
			
		//clib.ScrollDown("WebView");
		Thread.sleep(1000);
		
	}
	
	@Test
	public void swipetogallery() {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
		WebElement FirstImage= driver.findElement(By.xpath("(//android.widget.ImageView)[1]"));
		Assert.assertEquals(FirstImage.getAttribute("focusable"),"true");
	//	clib.Swipe(FirstImage, "left",driver);
		Assert.assertEquals(FirstImage.getAttribute("focusable"),"false");
		
		
		
	}
}
