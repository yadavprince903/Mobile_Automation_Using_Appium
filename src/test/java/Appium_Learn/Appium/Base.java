package Appium_Learn.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Base {
 public	AndroidDriver driver;
	AppiumDriverLocalService server;
	
	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		 server= new AppiumServiceBuilder()
				.withAppiumJS(new File("C:/Users/Admin/AppData/Roaming/npm/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1")
				.usingPort(4723).build();
		server.start();
		UiAutomator2Options options =new UiAutomator2Options();
		options.setDeviceName("MyPhone");
		options.setApp("C:/Users/Admin/Desktop/Appium learning/Appium/src/test/java/Resources/ApiDemos-debug.apk");
		
		 driver =new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
		server.close();
	}

}
