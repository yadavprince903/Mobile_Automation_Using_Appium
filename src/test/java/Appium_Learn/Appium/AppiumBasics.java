package Appium_Learn.Appium;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {
	@Test
	public void AppiumTest() throws MalformedURLException {
		
		AppiumDriverLocalService server= new AppiumServiceBuilder()
				.withAppiumJS(new File("C:/Users/Admin/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723).build();
		server.start();
		UiAutomator2Options options =new UiAutomator2Options();
		options.setDeviceName("MyPhone");
		options.setApp("C:/Users/Admin/Desktop/Appium learning/Appium/src/test/java/Resources/ApiDemos-debug.apk");
		
		AndroidDriver driver =new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.quit();
		server.close();
	}

}
