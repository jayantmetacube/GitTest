import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


	public class Mobile {
		
/*
	@BeforeClass
	public AndroidDriver<AndroidElement> setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	
	return driver;
	}*/
	
	
	public void testCal() throws Exception 
	
	{
	try
	{
		File f = new File("src");
		File fs = new File(f,"ApiDemos-debug.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		//capabilities.setCapability("VERSION", "4.4.2"); 
		//capabilities.setCapability("deviceName","Android Device");
		capabilities.setCapability("deviceName","Galaxy S6 edge");
		capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		capabilities.setCapability("platformName","Android");
	 
	   //capabilities.setCapability("appPackage", "com.android.calculator2");
	   capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
	// This package name of your app (you can get it from apk info app)
		//capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
		capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");// This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	  AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	   //locate the Text on the calculator by using By.name()
	   MobileElement two= driver.findElement(By.xpath("//android.widget.Button[@text='2']"));
	   two.click();
	  
	   MobileElement plus= driver.findElement(By.xpath("//android.widget.Button[@text='+']"));
	   plus.click();
	   MobileElement four= driver.findElement(By.xpath("//android.widget.Button[@text='4']"));
	   four.click();
	   MobileElement equalTo= driver.findElement(By.xpath("//android.widget.Button[@text='=']"));
	   equalTo.click();
	   //locate the edit box of the calculator by using By.tagName()
	   MobileElement results=  driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.sec.android.app.popupcalculator:id/txtCalc']"));
		//Check the calculated value on the edit box
	assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

	}
	
	catch(Exception e)
	{
	  System.out.println(e);
		
	}
	}
	//@AfterClass
	/*public void teardown()
	
	{
		//close the app
		driver.quit();
	}*/
	}


