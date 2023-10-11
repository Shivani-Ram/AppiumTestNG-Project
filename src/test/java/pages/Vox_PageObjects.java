package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import testScripts.Reflex_Vox_EReport;

public class Vox_PageObjects extends Reflex_Vox_EReport{
	
	// Allow Fastrack Reflex Vox to access photos,media and files on your device ?
	@FindBy(xpath="//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']")
	public static WebElement access_Photo_Media_Files;
		
	public static WebElement loginScreen(AppiumDriver driver) {
		//Navigate to login screen
		return driver.findElement(By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']"));
	}


	//LoginScreen_Agree_Policy
	@FindBy(id="com.fastrack.reflex.vox:id/btn_login")
	public static WebElement login_btn; 
	//Software usage agreement & policy
	@FindBy(id="com.fastrack.reflex.vox:id/rb_protocol_policy")
	public static WebElement check_box;
    //Agree - policy 
	@FindBy(id="com.fastrack.reflex.vox:id/tv_confirm")
	public static WebElement agree_btn;
	
	
	//Login_Registered_MobileNumber 
	@FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.EditText")
	public static WebElement enter_PhoneNumber; 
    //Tap Get otp
	@FindBy(id = "com.fastrack.reflex.vox:id/me_get_code_btn")
	public static WebElement tap_GetOtp;	
	// Allow Reflex Vox to read the msg & enter the code
	@FindBy(id = "com.google.android.gms:id/positive_button")
	public static WebElement read_msg;
    //Next Step
    @FindBy(id = "com.fastrack.reflex.vox:id/tv_right_bottom")
	public static WebElement nextStep;

    
	// Allow Fastrack Reflex Vox to access device location
    @FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	public static WebElement access_DeviceLocation;
	// To record exercise data , enable relevent settings
    @FindBy(id = "com.fastrack.reflex.vox:id/tv_set")
	public static WebElement enable_relevantSettings;
	// Troubleshooting
    @FindBy(id = "com.fastrack.reflex.vox:id/tv_cancel")
	public static WebElement cancel_relevantSettings;

 
     //Dashboard Screen - Footer menu (My device)
     @FindBy(id = "com.fastrack.reflex.vox:id/rb_tab_device")
	 public static WebElement myDevice;
     //Add device
     @FindBy(id = "com.fastrack.reflex.vox:id/addDeviceTv")
	 public static WebElement addDevice;
     //Select device
     @FindBy(xpath = "//android.widget.TextView[@text='FT_ReflexSW2_123F']")
	 public static WebElement selectDevice;
     //verify the text - pairing confirmation
     public static String verifyAlertMessage(AppiumDriver driver) {
		 WebElement alertTxt = driver.findElement(By.xpath("//android.widget.TextView[@text='Paired successfully']"));
		 //WebElement alertTxt = driver.findElement(By.xpath("\"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[@text='Paired successfully']"));
		 String text = alertTxt.getText();
		 System.out.println("Alert : "+ text);
		 return text;		
	  }
     //Click finish - pairing popup
     @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
     //@FindBy(id = "com.fastrack.reflex.vox:id/tv_finish") 
	 public static WebElement finish_Btn;

	 
     //Skip Amazon Alexa
     @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[5]")
     //@FindBy(id = "com.fastrack.reflex.vox:id/rtv_close")
	 public static WebElement skipAlexa_Settings;
	 //Start your health & fitness journey
     @FindBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView")
     //@FindBy(id = "com.fastrack.reflex.vox:id/tv_confirm")
	 public static WebElement skipHealth_Settings;

        
     //Profile Tab
     @FindBy(id = "com.fastrack.reflex.vox:id/rb_tab_user")
	 public static WebElement profileTab;
     //About
     @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout[8]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	 public static WebElement profile_aboutScreen;
     //Nav back 
     @FindBy(id = "com.fastrack.reflex.vox:id/title_leftBtn")
	 public static WebElement back_btn;


     
     //Multisport tab
     @FindBy(id = "com.fastrack.reflex.vox:id/rb_tab_sport")
	 public static WebElement multisportTab;
     //Select More option
     @FindBy(id = "com.fastrack.reflex.vox:id/img_more")
	 public static WebElement moreOption;
     //click training instruction
     @FindBy(id = "com.fastrack.reflex.vox:id/tv_sport_explain")
	 public static WebElement trainingInstructions;
     //Verify & print the training instructions
     public static String verifytrainingInstruction(AppiumDriver driver) {
		 WebElement alertTxt = driver.findElement(By.id("com.fastrack.reflex.vox:id/tv_explain_content"));
		 String text = alertTxt.getText();
		 System.out.println("Training Instructions : "+ text);
		 return text;		
	  } 
     //nav back - training screen
     @FindBy(id = "com.fastrack.reflex.vox:id/title_leftBtn")
	 public static WebElement navback;

     

	 //My Device 
     @FindBy(id = "com.fastrack.reflex.vox:id/rb_tab_device")
	 public static WebElement myDeviceTab;
     //select device name
     @FindBy(id = "com.fastrack.reflex.vox:id/mtv_device_custom_name")
	 public static WebElement selectDeviceName;
     //Device management - about
     @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
	 public static WebElement device_About;
     //device nav back
     @FindBy(id = "com.fastrack.reflex.vox:id/leftImgId")
	 public static WebElement device_navBack;
     //device nav back
     @FindBy(id = "com.fastrack.reflex.vox:id/leftImgId")
	 public static WebElement device_nav_Back;

    
     //Home - Exercise Card
     @FindBy(id = "com.fastrack.reflex.vox:id/rb_tab_home")
	 public static WebElement homeTab;
     //Actual exercise data 
     @FindBy(id = "com.fastrack.reflex.vox:id/tv_value")
	 public static WebElement exerciseData;
     //exercise card
     @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	 public static WebElement exerciseCard;
	 // Navigate back to Home screen from Exercise summary screen
     @FindBy(id = "com.fastrack.reflex.vox:id/title_leftBtn")
	 public static WebElement nav_BackBtn1;


     //Home - Sleep Card
     // Actual Sleep - Hours
     @FindBy(id = "com.fastrack.reflex.vox:id/tv_hour")
	 public static WebElement sleepHours;
     // Actual Sleep - Minutes
     @FindBy(id = "com.fastrack.reflex.vox:id/tv_minute")
	 public static WebElement sleepMinutes;
     //sleep card
     @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	 public static WebElement sleepCard;
     @FindBy(id = "com.fastrack.reflex.vox:id/rrb_week")
	 public static WebElement week_SleepRecord;
     @FindBy(id = "com.fastrack.reflex.vox:id/rrb_month")
	 public static WebElement month_SleepRecord;
     @FindBy(id = "com.fastrack.reflex.vox:id/rrb_year")
	 public static WebElement year_SleepRecord;
	 // Navigate back to Home screen from Sleep summary screen
     @FindBy(id = "com.fastrack.reflex.vox:id/leftImgId")
	 public static WebElement nav_BackBtn2;

        
     //Home - Stress Card
     //@FindBy(xpath="//android.widget.TextView[@text='Normalstress']")
     @FindBy(xpath="//android.widget.TextView[@text='30']")
     //@FindBy(id = "com.fastrack.reflex.vox:id/tv_pressure")
	 public static WebElement stressData;
     //stress card
     @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	 public static WebElement stressCard;
     // Navigate back to Home screen from Stress summary screen
     @FindBy(id = "com.fastrack.reflex.vox:id/leftImgId")
	 public static WebElement nav_BackBtn3;

 
     //Home - Heart rate Card
     @FindBy(id = "com.fastrack.reflex.vox:id/tv_heart_rate")
	 public static WebElement heartRateData;
     //heart rate card
     @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	 public static WebElement heartRateCard;
     // Navigate back to Home screen from Heart rate summary screen
     @FindBy(id = "com.fastrack.reflex.vox:id/leftImgId")
	 public static WebElement nav_BackBtn4;

 
     //Home - Blood Oxygen Card
     @FindBy(id = "com.fastrack.reflex.vox:id/tv_oxy")
	 public static WebElement bloodOxygenData;
     //Spo2 card
     @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView")
	 public static WebElement bloodOxygenCard;
     // Navigate back to Home screen from Blood Oxygen summary screen
     @FindBy(id = "com.fastrack.reflex.vox:id/leftImgId")
	 public static WebElement nav_BackBtn5;

     
     
}
