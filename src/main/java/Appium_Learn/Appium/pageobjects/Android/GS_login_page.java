package Appium_Learn.Appium.pageobjects.Android;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.AndroidGestures;

public class GS_login_page  extends AndroidGestures{
	AndroidDriver driver;
	
	public GS_login_page(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement namefield;
	
	@AndroidFindBy(id="om.androidsample.generalstore:id/radioFemale")
	private WebElement FemaleRadioButton;
	@AndroidFindBy(id="om.androidsample.generalstore:id/radioMale")
	private WebElement MaleRadioButton;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement CountryDropdown;
	
	@AndroidBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement LetsShop;
	
	@AndroidBy(xpath  ="//android.widget.toast)[1]")
	private WebElement toastMessage;
	
	public void SetNameField(String name) {
		namefield.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void SetGender(String gender) {
		if(gender.equalsIgnoreCase("male")) {
			MaleRadioButton.click();
		}
		else {
			FemaleRadioButton.click();
		}
	}
	
	public void SelectCountryDropdown(String country) {
		CountryDropdown.click();
		ScrollDowntotext(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text]='"+country+"']")).click();
		
	}
	public void Submit() {
		LetsShop.click();
	}
	
	public String getToastMessage() {
		
		return	toastMessage.getAttribute("value");
		
	}
	
	
}
