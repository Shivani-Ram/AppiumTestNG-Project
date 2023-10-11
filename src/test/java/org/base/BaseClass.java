package org.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {

	public static AppiumDriver driver;

	@Parameters({ "deviceName_", "udid_", "platformVersion_", "url_" })

	@BeforeTest
	public void setup(String deviceName_, String udid_, String platformVersion_, String url_)
			throws MalformedURLException {

		try {

			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setCapability("automationName", "Appium");
			dc.setCapability("deviceName", deviceName_);
			dc.setCapability("udid", udid_);
			dc.setCapability("platformVersion", platformVersion_);
			dc.setCapability("platformName", "Android");
			dc.setCapability("noReset", true);
			dc.setCapability("appPackage", "com.coloros.calculator");
			dc.setCapability("appActivity", "com.android.calculator2.Calculator");

			// Set default port
			driver = new AndroidDriver(new URL("http://" + url_), dc);

			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	       
			Thread.sleep(5000);

		} catch (Exception e) {
			System.out.println("Cause is : " + e.getCause());
			System.out.println("Message is : " + e.getMessage());
			e.printStackTrace();
		}
	}

}
