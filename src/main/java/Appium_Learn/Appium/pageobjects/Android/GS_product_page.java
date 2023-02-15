package Appium_Learn.Appium.pageobjects.Android;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.AndroidGestures;
import utilities.CommonLib;

public class GS_product_page extends AndroidGestures {
	
	AndroidDriver driver;
	public GS_product_page(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);				
	}
	
	@AndroidBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> products;
	
	@AndroidBy(id="com.androidsample.generalstore:id/productAddCart")
	private WebElement AddTocartBtn;
	
	@AndroidBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement CartBtn;
	
	@AndroidBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement cartpagetitle;
	
	@AndroidBy(id="com.androidsample.generalstore:id/productName")
	private WebElement productName;
	
	
	public void ScrollUptoProduct(String product) {
		driver.findElement(AppiumBy.
				  androidUIAutomator("new UiScrollable(newUiSelector)).scrollIntoView(text(\""+product+"\"));"));
	}
	
	public void addItemToCart(String product) {		
		for (WebElement item : products) {
			
			if(item.getText().equalsIgnoreCase(product));
			AddTocartBtn.click();
		}
	}
	
	public void gotoCart() {
	 CartBtn.click();
	}
	
	public void waitforcartpage() {
		CommonLib.waituntilattributecontains(cartpagetitle, driver);
	}
	
	public String getproductname() {
	 return	productName.getText();
	}

}
