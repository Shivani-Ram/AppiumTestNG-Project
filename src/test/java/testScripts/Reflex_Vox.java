package testScripts;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Reflex_Vox {

	public static AppiumDriver driver;

	@Test
	private void tc01_AppLaunch_and_Permission_to_Access_photo_media_files() throws MalformedURLException, InterruptedException {
		// Set up desired capabilities and pass the Android app-activity and app-package to Appium
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

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}
	
	@Test
	public void tc02_Permission_Access_Photo_Media_Files() throws InterruptedException {
		// Allow Fastrack Reflex Vox to access photos,media and files on your device ?
		Thread.sleep(5000);
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement allow_btn = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']")));
		allow_btn.click();
	}
	
	
	@Test
	public void tc03_LoginScreen_Agree_Policy() {
		// Login
		WebElement login_btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/btn_login"));
		login_btn.click();
		// Accept the User Agreement & Privacy Policy using Check box
		WebElement accept_btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/rb_protocol_policy"));
		accept_btn.click();
		// I Agree
		WebElement agree_btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_confirm"));
		agree_btn.click();
	}

	
	@Test
	private void tc04_Login_with_Registered_MobileNumber() {
		// Login
		// Enter mobile number
		WebElement enter_MobileNum = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.EditText"));
		enter_MobileNum.sendKeys("9345527607");
		// Tap Get OTP
		WebElement getOtp_btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/me_get_code_btn"));
		getOtp_btn.click();
		// Allow Reflex Vox to read the msg & enter the code
		WebElement allow_btn2 = driver.findElement(By.id("com.google.android.gms:id/positive_button"));
		allow_btn2.click();
		// Next Step Btn
		WebElement next_btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_right_bottom"));
		next_btn.click();
	}
	
	
	@Test
	private void tc05_Permission_to_Access_device_location_and_enable_relevent_settings() throws InterruptedException {
		// Allow Fastrack Reflex Vox to access device location
		WebElement allow_btn3 = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
		allow_btn3.click();
		
		//Sync all historical data WebElement skip =
		//driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_action_delay"));
		//skip.click();

		// To record exercise data , enable relevent settings
		Thread.sleep(5000);
		WebElement set_btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_set"));
		set_btn.click();
		// Troubleshooting
		WebElement cancel_btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_cancel"));
		cancel_btn.click();
	}
	
	
	@Test
	private void tc06_Pairing_the_device() throws InterruptedException {
		// My Device
		WebElement deviceTab = driver.findElement(By.id("com.fastrack.reflex.vox:id/rb_tab_device"));
		deviceTab.click();
		// Device - Add Device
		WebElement addDevice_Btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/addDeviceTv"));
		addDevice_Btn.click();
		// Select the device
		Thread.sleep(3000);
		WebDriverWait select_device = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement d1 = select_device.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='FT_ReflexSW2_123F']")));
		d1.click();
		// Display of Paired successfully message when device paired up with the watch
		WebElement device_pairing = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[@text='Paired successfully']"));
		String text1 = device_pairing.getText();
		System.out.println(text1);
		// Click Finish Btn
		WebElement btn1 = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_finish"));
		btn1.click();
	}


	@Test
	private void tc07_Set_and_Cancel_Amazon_HealthFitness_Settings() throws InterruptedException {
		// amazon alexa - Click Finish Btn
		WebElement btn2 = driver.findElement(By.id("com.fastrack.reflex.vox:id/rtv_close"));
		btn2.click();
		// Start your health fitness journey - Click Yes Btn
		WebDriverWait yes_btn = new WebDriverWait(driver, Duration.ofSeconds(120));
		WebElement d2 = yes_btn.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.fastrack.reflex.vox:id/tv_confirm")));
		//WebElement d2 = yes_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Yes'")));
		//WebElement d2 = yes_btn.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")));
		d2.click();
	}

	
	@Test
	public void tc08_ProfileTab() {
		//Profile
	    driver.findElement(By.id("com.fastrack.reflex.vox:id/rb_tab_user")).click();
	    //About
	    WebDriverWait wait1 =new WebDriverWait(driver,Duration.ofSeconds(60));	
	    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[8]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")));
	    driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[8]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")).click();
	    // Navigate from About screen to Profile screen
		WebDriverWait sr24 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement eab9 = sr24.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fastrack.reflex.vox:id/title_leftBtn']")));
		eab9.click();
	}
	


	@Test
	public void tc09_MultisportTab() {
		//Click Multisport Tab
	     WebDriverWait wait1 =new WebDriverWait(driver,Duration.ofSeconds(60));	      
	     wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RadioGroup/android.widget.RadioButton[2]")));
	     //driver.findElement(AppiumBy.accessibilityId("tabbar_sport_n")).click();
	     driver.findElement(By.id("com.fastrack.reflex.vox:id/rb_tab_sport")).click();
	     //Select more option
	     WebElement el2 = driver.findElement(By.id("com.fastrack.reflex.vox:id/img_more"));
 	     //WebElement el2 = driver.findElement(AppiumBy.accessibilityId("Sport more"));
 	     el2.click();
 	     //Training Instructions
 	     WebElement el4 = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_sport_explain"));
 	     //WebElement el4 = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Training Instructions\"]"));
 	     el4.click();
 	     //Print the text
 	     WebElement trainingTxt = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_explain_content"));
 	     //WebElement trainingTxt = driver.findElement(By.xpath("//android.widget.TextView[@text=\"Indoor cycling, cricket, pool swimming, open swimming, rowing machine, yoga and fitness exercises needs to be initiated on the watch. Under training records you can find all the details.\"]"));
		 String text = trainingTxt .getText();
		 System.out.println("Training Instructions : "+ text);
 	     //Nav back from training instruction screen
		 WebElement back_btn = driver.findElement(By.id("com.fastrack.reflex.vox:id/title_leftBtn"));
		 back_btn.click();	 		
	} 
	
	
	

	@Test
	public void tc10_MyDeviceTab() throws InterruptedException {
		// My Device
		WebElement deviceTab = driver.findElement(By.id("com.fastrack.reflex.vox:id/rb_tab_device"));
		deviceTab.click();
		// My Device - Click on connected device
		Thread.sleep(3000);
		WebDriverWait device = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element5 = device.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.fastrack.reflex.vox:id/mtv_device_custom_name")));
		element5.click();
		// About
		WebElement about_screen = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"));
		about_screen.click();
		// Navigate back to Device management screen from About screen
		WebDriverWait h5 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement el8 = h5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fastrack.reflex.vox:id/leftImgId']")));
		//WebElement element8 = driver.findElement(By.id("com.fastrack.reflex.vox:id/leftImgId"));
		el8.click();
		// Navigate back to My Device screen from Device management screen
		Thread.sleep(3000);
		WebDriverWait h4 = new WebDriverWait(driver, Duration.ofSeconds(60));
		WebElement el = h4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fastrack.reflex.vox:id/leftImgId']")));
		el.click();	 
	}
	

	

	
	 @Test(dataProvider = "JsonExerciseData")
	 public void tc11_Home_Excercise_Card(String data) throws InterruptedException {
    	    // Home
    		WebElement home = driver.findElement(By.id("com.fastrack.reflex.vox:id/rb_tab_home"));
    		home.click();
    	    
	        String[] healthData = data.split(",");

	        // Expected exercise data 
	        String expectedExerciseData = healthData[0];
	        System.out.println("Expected Exercise data for Outdoor Walking : " + expectedExerciseData);

	        // Actual exercise data
			String actualExerciseData = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_value")).getText();
	        System.out.println("Actual Exercise data for Outdoor Walking : " + actualExerciseData);

	        Assert.assertEquals(actualExerciseData, expectedExerciseData, "Actual and Expected are not same");

	        // Exercise
		    WebDriverWait wait1 =new WebDriverWait(driver,Duration.ofSeconds(60));	      
		    wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"))).click();
    	           
			// Navigate back to Home screen from Exercise summary screen
			WebDriverWait element2 = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement back_btn = element2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fastrack.reflex.vox:id/title_leftBtn']")));
			back_btn.click();     
	    }
     
     @DataProvider(name = "JsonExerciseData")
     public static String[] readJsonData1() throws IOException, ParseException {

         JSONParser jsonparser = new JSONParser();
         FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

         // jsonparser.parse(reader) will return java object
         Object obj = jsonparser.parse(reader);
         /*
          * Convert java object to json object Json Object is pointing the whole data in
          * Json From this the array values needs to be extracted
          */
         JSONObject titandata = (JSONObject) obj;
         JSONArray jsonarray = (JSONArray) titandata.get("exerciseRecord");// Will return the while Json Array

         String arr[] = new String[jsonarray.size()];

         for (int i = 0; i < jsonarray.size(); i++) {

             JSONObject value = (JSONObject) jsonarray.get(i);
             String outdoorWalking = (String) value.get("outdoorWalking");

             arr[i] = outdoorWalking ;

         }

         return arr;
     }
	
	
	
	
	
	@Test(dataProvider = "JsonSleepData")
	private void tc12_Home_Sleep_Card(String data) throws InterruptedException {
		// Home
		//WebElement home = driver.findElement(By.id("com.fastrack.reflex.vox:id/rb_tab_home"));
		//home.click();

		String[] healthData = data.split(",");

		// Expected Sleep data in Hours
		String expectedSleepHours = healthData[0];
		System.out.println("Expected Sleep data in Hours: " + expectedSleepHours);

		// Actual Sleep - Hours
		String actualSleepHours = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_hour")).getText();
		System.out.println("Actual Sleep data in hours: " + actualSleepHours);

		Assert.assertEquals(actualSleepHours, expectedSleepHours, "Actual and Expected are not same");

		// Expected Sleep data in Minutes
		String expectedSleepMinutes = healthData[1];
		System.out.println("Expected Sleep data in Minutes: " + expectedSleepMinutes);

		// Actual Sleep - Minutes
		String actualSleepMinutes = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_minute")).getText();
		System.out.println("Actual Sleep data in Minutes: " + actualSleepMinutes);

		Assert.assertEquals(actualSleepMinutes, expectedSleepMinutes, "Actual and Expected are not same");

		// Sleep
		WebElement sleep = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
		sleep.click();

		// Scroll down & up a page
		driver.findElement(
				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));
		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(100000)"));

		// Sleep data - Week _Month_Year
		WebElement week = driver.findElement(By.id("com.fastrack.reflex.vox:id/rrb_week"));
		week.click();
		WebElement month = driver.findElement(By.id("com.fastrack.reflex.vox:id/rrb_month"));
		month.click();
		WebElement year = driver.findElement(By.id("com.fastrack.reflex.vox:id/rrb_year"));
		year.click();
		// Navigate back to Home screen from Sleep summary screen
		Thread.sleep(3000);
		WebDriverWait element2 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement back_btn = element2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fastrack.reflex.vox:id/leftImgId']")));
		back_btn.click();
	}

	@DataProvider(name = "JsonSleepData")
	public static String[] readJsonData2() throws IOException, ParseException {

		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

		// jsonparser.parse(reader) will return java object
		Object obj = jsonparser.parse(reader);
		/*
		 * Convert java object to json object Json Object is pointing the whole data in
		 * Json From this the array values needs to be extracted
		 */
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

         String[] healthData = data.split(",");

         // Expected Stress data 
         String expectedStress = healthData[0];
         System.out.println("Expected Stress data  : " + expectedStress);

         // Actual Stress data
 		 String actualStress = driver.findElement(By.xpath("//android.widget.TextView[@text='30']")).getText();
 		 //String actualStress = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_pressure")).getText();
         //String actualStress = driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"29 Relax\"]")).getText();
         System.out.println("Actual Stress data : " + actualStress);

         Assert.assertEquals(actualStress, expectedStress, "Actual and Expected are not same");

         // Stress
         WebElement hr = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
         hr.click();
         
        // Navigate back to Home screen from Stress summary screen
        Thread.sleep(3000);
 		WebDriverWait element2 = new WebDriverWait(driver, Duration.ofSeconds(20));
 		WebElement back_btn = element2.until(ExpectedConditions
 				.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fastrack.reflex.vox:id/leftImgId']")));
 		back_btn.click();
     }

     @DataProvider(name = "JsonStressData")
     public static String[] readJsonData3() throws IOException, ParseException {

         JSONParser jsonparser = new JSONParser();
         FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

         // jsonparser.parse(reader) will return java object
         Object obj = jsonparser.parse(reader);

         // * Convert java object to json object Json Object is pointing the whole data in Json 
         //From this the array values needs to be extracted

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
     public void tc14_Home_Heart_Rate_Card(String data) throws InterruptedException {

          String[] healthData = data.split(",");

          // Expected Heart rate data in bpm
          String expectedHeartRate = healthData[0];
          System.out.println("Expected Heart rate data in bpm : " + expectedHeartRate);

          // Actual Heart rate in bpm
          String actualHeartRate = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_heart_rate")).getText();
          System.out.println("Actual Heart rate data in bpm : " + actualHeartRate);

          Assert.assertEquals(actualHeartRate, expectedHeartRate, "Actual and Expected are not same");

          // Heart rate
          WebElement hr = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
          hr.click();
          
          // Navigate back to Home screen from Heart rate summary screen
          Thread.sleep(3000);
   		  WebDriverWait element2 = new WebDriverWait(driver, Duration.ofSeconds(20));
   		  WebElement back_btn = element2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fastrack.reflex.vox:id/leftImgId']")));
   		  back_btn.click();
      }

      @DataProvider(name = "JsonHeartRateData")
      public static String[] readJsonData4() throws IOException, ParseException {

          JSONParser jsonparser = new JSONParser();
          FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

          // jsonparser.parse(reader) will return java object
          Object obj = jsonparser.parse(reader);

          // * Convert java object to json object Json Object is pointing the whole data in Json 
          //From this the array values needs to be extracted

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
  	private void tc15_Home_Spo2_Card(String data) throws InterruptedException {

  		// Scroll down & up a page
  		driver.findElement(
  				AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(100000)"));

  		String[] healthData = data.split(",");

  		// Expected Blood oxygen data
  		String expectedBloodOxygen = healthData[0];
  		System.out.println("Expected Blood oxygen : " + expectedBloodOxygen);

  		// Actual Blood oxygen data
  		String actualBloodOxygen = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_oxy")).getText();
  		System.out.println("Actual Blood Oxygen : " + actualBloodOxygen);

  		Assert.assertEquals(actualBloodOxygen, expectedBloodOxygen, "Actual and Expected are not same");

  		// Spo2
  		WebElement spo2 = driver.findElement(By.xpath(
  				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView"));
  		spo2.click();
  		// Navigate back to Home screen from Blood Oxygen summary screen
  		Thread.sleep(3000);
  		WebDriverWait element3 = new WebDriverWait(driver, Duration.ofSeconds(20));
  		WebElement back_btn = element3.until(ExpectedConditions
  				.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fastrack.reflex.vox:id/leftImgId']")));
  		back_btn.click();
  	}

  	@DataProvider(name = "JsonBloodOxygenData")
  	public static String[] readJsonData5() throws IOException, ParseException {

  		JSONParser jsonparser = new JSONParser();
  		FileReader reader = new FileReader(System.getProperty("user.dir") + "/jsonfiles/titantestdata.json");

  		// jsonparser.parse(reader) will return java object
  		Object obj = jsonparser.parse(reader);
  		/*
  		 * Convert java object to json object Json Object is pointing the whole data in
  		 * Json From this the array values needs to be extracted
  		 */
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
     
      

}
