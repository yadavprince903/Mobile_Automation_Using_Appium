package Appium_Learn.Appium;


import org.testng.Assert;
import org.testng.annotations.Test;
import Appium_Learn.Appium.pageobjects.Android.GS_login_page;
import Appium_Learn.Appium.pageobjects.Android.GS_product_page;

public class GeneralStoreTests extends Base{
	
	GS_login_page gspage=new GS_login_page(driver);
	GS_product_page gs_product_page=new GS_product_page(driver);
	
	@Test
	public void FillForm()  {
		gspage.SetNameField("Prince Yadav");
		gspage.SetGender("female");
		gspage.SelectCountryDropdown("Argentina");
		gspage.Submit();
		
	}
	
	@Test
	public void ValidateToast() {
		gspage.SetGender("female");
		gspage.SelectCountryDropdown("Argentina");
		gspage.Submit();
		Assert.assertEquals(gspage.getToastMessage(), "Please enter your name");
	}
	
	@Test
	public void AddItemToCart() {
				
		gspage.SetNameField("Prince Yadav");
		gspage.SetGender("female");
		gspage.SelectCountryDropdown("Argentina");
		gspage.Submit();
		gs_product_page.ScrollUptoProduct("Jordan 6 Rings");
		gs_product_page.addItemToCart("Jordan 6 Rings");
		gs_product_page.gotoCart();
		gs_product_page.waitforcartpage();
		Assert.assertEquals(gs_product_page.getproductname(),"Jordan 6 Rings");
		
	}

}
