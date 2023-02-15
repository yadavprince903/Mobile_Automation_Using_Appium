package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;



public class AndroidGestures {
	AndroidDriver driver;
	
	public AndroidGestures(AndroidDriver driver) {
		this.driver=driver;
	}

	public void LogPress(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 2000));

	}
	
	public void Swipe(WebElement element,String direction) {

		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
						"direction", direction,
						"percent",0.75));

	}
	
	public void dragNdrop(WebElement source,int x,int y) {

		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) source).getId(),
						"endX", x,
						"endY",y));

	}

	
	  public void ScrollDowntotext(String elementname) {
	  
	  driver.findElement(AppiumBy.
	  androidUIAutomator("new UiScrollable(newUiSelector)).scrollIntoView(text(\""
	  +elementname+"\"));"));
	  
	  
	  
		/*
		 * boolean canScrollMore = (Boolean) ((JavascriptExecutor)
		 * driver).executeScript("mobile: scrollGesture", ImmutableMap.of( "left", 100,
		 * "top", 100, "width", 200, "height", 200, "direction", "down", "percent", 3.0
		 * ));
		 */
	  
	  }
	  
	 
	 

}
