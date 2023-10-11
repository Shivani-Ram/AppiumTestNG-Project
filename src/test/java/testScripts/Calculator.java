package testScripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Calculator {

	private static AppiumDriver driver;

	@Test
	private void tc02() throws MalformedURLException {

		// Set up desired capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("udid", "7HJF9SWS6D4DCACE");
		dc.setCapability("deviceName", "OPPO A31");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "com.coloros.calculator");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver(url, dc);

		System.out.println("Application 2 started...");
		
		WebElement one = driver.findElement(By.id("com.coloros.calculator:id/digit_1"));
		one.click();

		WebElement plus1 = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
		plus1.click();

		WebElement two = driver.findElement(By.id("com.coloros.calculator:id/digit_2"));
		two.click();

		WebElement equalTo = driver.findElement(By.id("com.coloros.calculator:id/eq"));
		equalTo.click();

		WebElement clr = driver.findElement(By.id("com.coloros.calculator:id/clr"));
		clr.click();
		
		System.out.println("Calculator App launched & addition of numbers Succeeded");


	}
}
