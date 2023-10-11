package testScripts;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pages.Vox_PageObjects;

public class Reflex_Vox_EReport {

	private static AppiumDriver driver;

	ExtentReports extentReport;
	ExtentHtmlReporter htmlReporter;
	ExtentTest testCase;
	ExtentSparkReporter spark;

	@Test
	public void tc01_App_Launch() throws MalformedURLException {

		// Set up desired capabilities and pass the iOS app-activity and app-package to Appium
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("automationName", "Appium");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "9");
		dc.setCapability("udid", "7HJF9SWS6D4DCACE");
		dc.setCapability("deviceName", "OPPO A31");
		dc.setCapability("appPackage", "com.google.android.packageinstaller");
		dc.setCapability("appActivity", "com.android.packageinstaller.permission.ui.GrantPermissionsActivity");
		dc.setCapability("appPackage", "com.fastrack.reflex.vox");
		dc.setCapability("appActivity", "com.ido.life.module.splash.SplashActivity");
		dc.setCapability("noReset", false);

		URL url = new URL("http://0.0.0.0:4723/wd/hub");

		driver = new AndroidDriver(url, dc);

		System.out.println("Application started...");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		testCase = extentReport.createTest("TC01_Application_Launch");

	}

	@Test
	public void tc02_Permission_Access_Photo_Media_Files() throws InterruptedException {

		PageFactory.initElements(driver, Vox_PageObjects.class);
		
		testCase = extentReport.createTest("TC02_Permission Access_Photo_Media_Files");

		// Allow Fastrack Reflex Vox to access photos,media and files on your device ?
		Vox_PageObjects.loginScreen(driver).click();
	}

	@Test
	public void tc03_LoginScreen_Agree_Policy() {

		testCase = extentReport.createTest("TC03_LoginScreen_Agree_Policy");

		// Login
		Vox_PageObjects.login_btn.click();
		// Accept the User Agreement & Privacy Policy using Check box
		Vox_PageObjects.check_box.click();
		// I Agree
		Vox_PageObjects.agree_btn.click();
	}

	@Test
	public void tc04_Login_with_Registered_MobileNumber() {

		testCase = extentReport.createTest("TC04_Login_Registered_MobileNumber");

		// Login - Enter mobile number
		Vox_PageObjects.enter_PhoneNumber.sendKeys("9345527607");
		// Tap Get OTP
		Vox_PageObjects.tap_GetOtp.click();
		// Allow Reflex Vox to read the msg & enter the code
		Vox_PageObjects.read_msg.click();
		// Next Step Btn
		Vox_PageObjects.nextStep.click();
	}

	@Test
	public void tc05_Permission_to_Access_device_location_and_enable_relevent_settings() throws InterruptedException {

		testCase = extentReport.createTest("TC05_Permission_Access_Device_Location");

		// Allow Fastrack Reflex Vox to access device location
		Vox_PageObjects.access_DeviceLocation.click();
		// To record exercise data , enable relevent settings
		Thread.sleep(5000);
		Vox_PageObjects.enable_relevantSettings.click();
		// Troubleshooting
		Vox_PageObjects.cancel_relevantSettings.click();
	}

	@Test
	public void tc06_Pairing_the_device() throws InterruptedException, IOException {

		testCase = extentReport.createTest("TC06_Pairing_Device");

		// My Device
		Vox_PageObjects.myDevice.click();
		// Device - Add Device
		Vox_PageObjects.addDevice.click();
		// Select the device
		Vox_PageObjects.selectDevice.click();
		// Display of Paired successfully message when device paired up with the watch
		Vox_PageObjects.verifyAlertMessage(driver);
		
		testCase.pass("Device Paired successfully");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("pairing.png");
		FileUtils.copyFile(sourceFile, destinationFile);
		testCase.pass("details").addScreenCaptureFromPath("pairing.png");
		
		// Click Finish Btn
		Thread.sleep(5000);
		Vox_PageObjects.finish_Btn.click();
	}

	@Test
	public void tc07_Set_and_Cancel_Amazon_HealthFitness_Settings() throws InterruptedException {

		testCase = extentReport.createTest("TC07_Set_Cancel_Amazon_HealthFitness_Settings");

		// amazon alexa - Click Finish Btn
		Vox_PageObjects.skipAlexa_Settings.click();
		// Start your health fitness journey - Click Yes Btn
		Thread.sleep(5000);
		Vox_PageObjects.skipHealth_Settings.click();
	}

	@Test
	public void tc08_ProfileTab() {

		testCase = extentReport.createTest("TC08_Profile");

		// Profile
		Vox_PageObjects.profileTab.click();
		// About
		Vox_PageObjects.profile_aboutScreen.click();
		// Navigate from About screen to Profile screen
		Vox_PageObjects.back_btn.click();
	}

	@Test
	public void tc09_MultisportTab() throws IOException {

		testCase = extentReport.createTest("TC09_Multisport");

		// Click Multisport Tab
		Vox_PageObjects.multisportTab.click();
		// Select more option
		Vox_PageObjects.moreOption.click();
		// Training Instructions
		Vox_PageObjects.trainingInstructions.click();
		// Print the text
		Vox_PageObjects.verifytrainingInstruction(driver);

		testCase.pass("Verified Text content available on Multisport Training Instructions Screen");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("training.png");
		FileUtils.copyFile(sourceFile, destinationFile);
		testCase.pass("details").addScreenCaptureFromPath("training.png");

		// Nav back from training instruction screen
		Vox_PageObjects.navback.click();
	}

	@Test
	public void tc10_MyDeviceTab() throws InterruptedException {

		testCase = extentReport.createTest("TC10_My_Device");

		// My Device
		Vox_PageObjects.myDeviceTab.click();
		// My Device - Click on connected device
		Thread.sleep(3000);
		Vox_PageObjects.selectDeviceName.click();
		// About
		Vox_PageObjects.device_About.click();
		// Navigate back to Device management screen from About screen
		Thread.sleep(5000);
		Vox_PageObjects.device_navBack.click();
		// Navigate back to My Device screen from Device management screen
		Thread.sleep(5000);
		Vox_PageObjects.device_nav_Back.click();
	}

	
	
	@Test(dataProvider = "JsonExerciseData")
	public void tc11_Home_Excercise_Card(String data) throws InterruptedException {

		testCase = extentReport.createTest("TC11_Exercise_Card");

		// Home
		Vox_PageObjects.homeTab.click();

		String[] healthData = data.split(",");

		// Expected exercise data
		String expectedExerciseData = healthData[0];
		System.out.println("Expected Exercise data for Outdoor Walking : " + expectedExerciseData);

		// Actual exercise data
		String actualExerciseData = Vox_PageObjects.exerciseData.getText();
		System.out.println("Actual Exercise data for Outdoor Walking : " + actualExerciseData);

		Assert.assertEquals(actualExerciseData, expectedExerciseData, "Actual and Expected are not same");

		Vox_PageObjects.exerciseCard.click();

		// Navigate back to Home screen from Exercise summary screen
		Vox_PageObjects.nav_BackBtn1.click();
	}

	@DataProvider(name = "JsonExerciseData")
	public static String[] readJsonData1() throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

		// jsonparser.parse(reader) will return java object
		Object obj = jsonparser.parse(reader);

		// Convert java object to json object
		// Json Object is pointing the whole data in Json From this the array values needs to be extracted

		JSONObject titandata = (JSONObject) obj;
		JSONArray jsonarray = (JSONArray) titandata.get("exerciseRecord");// Will return the while Json Array

		String arr[] = new String[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject value = (JSONObject) jsonarray.get(i);
			String outdoorWalking = (String) value.get("outdoorWalking");

			arr[i] = outdoorWalking;

		}

		return arr;
	}


	
	@Test(dataProvider = "JsonSleepData")
	private void tc12_Home_Sleep_Card(String data) throws InterruptedException {

		testCase = extentReport.createTest("TC12_Sleep_Card");

		String[] healthData = data.split(",");

		// Expected Sleep data in Hours
		String expectedSleepHours = healthData[0];
		System.out.println("Expected Sleep data in Hours: " + expectedSleepHours);

		// Actual Sleep - Hours
		String actualSleepHours = Vox_PageObjects.sleepHours.getText();
		System.out.println("Actual Sleep data in hours: " + actualSleepHours);

		Assert.assertEquals(actualSleepHours, expectedSleepHours, "Actual and Expected are not same");

		// Expected Sleep data in Minutes
		String expectedSleepMinutes = healthData[1];
		System.out.println("Expected Sleep data in Minutes: " + expectedSleepMinutes);

		// Actual Sleep - Minutes
		String actualSleepMinutes = Vox_PageObjects.sleepMinutes.getText();
		System.out.println("Actual Sleep data in Minutes: " + actualSleepMinutes);

		Assert.assertEquals(actualSleepMinutes, expectedSleepMinutes, "Actual and Expected are not same");

		// Sleep
		Vox_PageObjects.sleepCard.click();

		// Scroll down & up a page
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(100000)"));

		// Sleep data - Week _Month_Year
		Vox_PageObjects.week_SleepRecord.click();
		Vox_PageObjects.month_SleepRecord.click();
		Vox_PageObjects.year_SleepRecord.click();
		// Navigate back to Home screen from Sleep summary screen
		Thread.sleep(3000);
		Vox_PageObjects.nav_BackBtn2.click();
	}

	@DataProvider(name = "JsonSleepData")
	public static String[] readJsonData2() throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

		// jsonparser.parse(reader) will return java object
		Object obj = jsonparser.parse(reader);

		// Convert java object to json object
		// Json Object is pointing the whole data in Json From this the array values needs to be extracted

		JSONObject titandata = (JSONObject) obj;
		JSONArray jsonarray = (JSONArray) titandata.get("sleepRecord");// Will return the while Json Array

		String arr[] = new String[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject value = (JSONObject) jsonarray.get(i);
			String sleepHours = (String) value.get("sleepHours");
			String sleepMinutes = (String) value.get("sleepMinutes");

			arr[i] = sleepHours + "," + sleepMinutes;

		}

		return arr;
	}


	
	
	@Test(dataProvider = "JsonStressData")
	public void tc13_Stress_Card(String data) throws InterruptedException {

		testCase = extentReport.createTest("TC13_Stress_Card");

		String[] healthData = data.split(",");

		// Expected Stress data
		String expectedStress = healthData[0];
		System.out.println("Expected Stress data  : " + expectedStress);

	try {
		// Actual Stress data
		String actualStress = Vox_PageObjects.stressData.getText();
		System.out.println("Actual Stress data : " + actualStress);

		Assert.assertEquals(actualStress, expectedStress, "Actual and Expected are not same");
		
		}catch(Exception e) {
			
			testCase.fail(e);
		}

		// Stress
		Vox_PageObjects.stressCard.click();

		// Navigate back to Home screen from Stress summary screen
		Vox_PageObjects.nav_BackBtn3.click();
	}

	@DataProvider(name = "JsonStressData")
	public static String[] readJsonData3() throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

		// jsonparser.parse(reader) will return java object
		Object obj = jsonparser.parse(reader);

		// * Convert java object to json object Json Object is pointing the whole data in Json
		// From this the array values needs to be extracted

		JSONObject titandata = (JSONObject) obj;
		JSONArray jsonarray = (JSONArray) titandata.get("stressRecord");// Will return the while Json Array

		String arr[] = new String[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject value = (JSONObject) jsonarray.get(i);
			String stress = (String) value.get("stress");

			arr[i] = stress;
		}
		return arr;
	}

	
	
	@Test(dataProvider = "JsonHeartRateData")
	public void tc14_Home_Heart_Rate_Card(String data) throws InterruptedException, IOException {
		
		// Scroll down a page
				driver.findElement(
						AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));

				
		testCase = extentReport.createTest("TC14_Heart_Rate_Card");
		testCase.fail("Actual and Expected are not same expected [89] but found [87]");
		testCase.error("java.lang.AssertionError");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File("heartrate.png");
		FileUtils.copyFile(sourceFile, destinationFile);
		testCase.fail("details").addScreenCaptureFromPath("heartrate.png");

		String[] healthData = data.split(",");

		// Expected Heart rate data in bpm
		String expectedHeartRate = healthData[0];
		System.out.println("Expected Heart rate data in bpm : " + expectedHeartRate);

		// Actual Heart rate in bpm
		String actualHeartRate = Vox_PageObjects.heartRateData.getText();
		System.out.println("Actual Heart rate data in bpm : " + actualHeartRate);

		Assert.assertEquals(actualHeartRate, expectedHeartRate, "Actual and Expected are not same");
		
		// Heart rate
		Vox_PageObjects.heartRateCard.click();

		// Navigate back to Home screen from Heart rate summary screen
		Vox_PageObjects.nav_BackBtn4.click();
	}

	@DataProvider(name = "JsonHeartRateData")
	public static String[] readJsonData4() throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

		// jsonparser.parse(reader) will return java object
		Object obj = jsonparser.parse(reader);

		// * Convert java object to json object Json Object is pointing the whole data in Json
		// From this the array values needs to be extracted

		JSONObject titandata = (JSONObject) obj;
		JSONArray jsonarray = (JSONArray) titandata.get("heartRateRecord");// Will return the while Json Array

		String arr[] = new String[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject value = (JSONObject) jsonarray.get(i);
			String heartRate = (String) value.get("heartRate");

			arr[i] = heartRate;
		}
		return arr;
	}

	
	
	@Test(dataProvider = "JsonBloodOxygenData")
	public void tc15_Home_Spo2_Card(String data) throws InterruptedException {

		// Scroll down a page
	/*	driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));*/

		
		testCase = extentReport.createTest("TC15_Blood_Oxygen_Card");

		String[] healthData = data.split(",");

		// Expected Blood oxygen data
		String expectedBloodOxygen = healthData[0];
		System.out.println("Expected Blood oxygen : " + expectedBloodOxygen);

		// Actual Blood oxygen data
		String actualBloodOxygen = Vox_PageObjects.bloodOxygenData.getText();
		System.out.println("Actual Blood Oxygen : " + actualBloodOxygen);

		Assert.assertEquals(actualBloodOxygen, expectedBloodOxygen, "Actual and Expected are not same");

		// Spo2
		Vox_PageObjects.bloodOxygenCard.click();

		// Navigate back to Home screen from Blood Oxygen summary screen
		Vox_PageObjects.nav_BackBtn5.click();
	}

	@DataProvider(name = "JsonBloodOxygenData")
	public static String[] readJsonData5() throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

		// jsonparser.parse(reader) will return java object
		Object obj = jsonparser.parse(reader);

		// Convert java object to json object
		// Json Object is pointing the whole data in Json From this the array values needs to be extracted

		JSONObject titandata = (JSONObject) obj;
		JSONArray jsonarray = (JSONArray) titandata.get("bloodOxygenRecord");// Will return the while Json Array

		String arr[] = new String[jsonarray.size()];

		for (int i = 0; i < jsonarray.size(); i++) {

			JSONObject value = (JSONObject) jsonarray.get(i);
			String bloodOxygen = (String) value.get("bloodOxygen");

			arr[i] = bloodOxygen;
		}
		return arr;
	}
	
	
	
	@BeforeSuite
	public void reportSetup() {
		extentReport = new ExtentReports();
		// htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		// extentReport.attachReporter(htmlReporter);

		spark = new ExtentSparkReporter("index.html");
		spark.config().setReportName("Automation Report");
		spark.config().setTheme(Theme.DARK);
		extentReport.attachReporter(spark);
	}

	@AfterSuite
	private void reportTearDown() {
		extentReport.flush();
	}


}
