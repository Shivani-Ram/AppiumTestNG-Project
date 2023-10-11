package testScripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Boat {

	private static AppiumDriver driver;
	
	@Test
	private void tc01() throws MalformedURLException {
	 
		// Set up desired capabilities
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("udid", "7HJF9SWS6D4DCACE");
		dc.setCapability("deviceName", "OPPO A31");
		dc.setCapability("noReset", true);
		dc.setCapability("appPackage", "boatlifestylein.android.app");
		dc.setCapability("appActivity", "boatlifestylein.android.app.activities.SplashActivity");

		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver(url, dc);

		System.out.println("Application 1 started...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		// Select Profile tab
		WebDriverWait profTab = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement tab3 = profTab.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.ImageView[3]")));
		tab3.click();

		// Login Page
		WebElement login = driver.findElement(AppiumBy.id("boatlifestylein.android.app:id/profile_35_login_button"));
		login.click();

		// Enter email
		WebElement email = driver.findElement(AppiumBy.id("boatlifestylein.android.app:id/editTxt_edit_username"));
		email.click();
		email.sendKeys("shivani.ramachandran@impigertech.com");

		// Enter Password
		WebElement password = driver.findElement(AppiumBy.id("boatlifestylein.android.app:id/editTxt_password"));
		password.click();
		password.sendKeys("boat@05");

		// Click Login Button
		WebElement login_btn = driver.findElement(AppiumBy.id("boatlifestylein.android.app:id/btn_login"));
		login_btn.click();

		// Logout
		WebElement logout_btn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='LOGOUT']"));
		logout_btn.click();
		// Confirm Logout
		WebElement ok_btn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='OK']"));
		ok_btn.click();
		
		System.out.println("Boat App Login & Logout Successful");


	}

}
