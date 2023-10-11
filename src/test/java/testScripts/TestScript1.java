package testScripts;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestScript1 extends BaseClass {

	@Parameters({ "deviceName_", "udid_", "platformVersion_", "url_" })
	@Test
	private void tc01(String device, String id, String version, String url) {

		WebElement one = driver.findElement(By.id("com.coloros.calculator:id/digit_1"));
		WebElement plus1 = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
		WebElement two = driver.findElement(By.id("com.coloros.calculator:id/digit_2"));

		WebElement equalTo = driver.findElement(By.id("com.coloros.calculator:id/eq"));

		WebElement clr = driver.findElement(By.id("com.coloros.calculator:id/clr"));

		WebElement three = driver.findElement(By.id("com.coloros.calculator:id/digit_3"));
		WebElement plus2 = driver.findElement(By.id("com.coloros.calculator:id/op_add"));
		WebElement twoo = driver.findElement(By.id("com.coloros.calculator:id/digit_2"));

		one.click();
		plus1.click();
		two.click();

		equalTo.click();
		clr.click();

		three.click();
		plus2.click();
		twoo.click();

		System.out.println("Success");

	}

}
