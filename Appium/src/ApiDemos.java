import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import  static io.appium.java_client.touch.TapOptions.tapOptions;
import  static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static java.time.Duration.ofSeconds;
import  static io.appium.java_client.touch.offset.ElementOption.element;

public class ApiDemos

{
	@Test
	public static void Capabilities() throws MalformedURLException, InterruptedException
	
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
		/*capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");		
	    capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");// This is Launcher activity of your app (you can get it from apk info app)
        */
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        /*driver.findElement(By.xpath("//android.widget.TextView[@text='Preference']")).click();
       
        driver.findElement(By.xpath("//android.widget.TextView[@text='3. Preference dependencies']")).click();
      
        driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='android:id/checkbox']")).click();
       
        driver.findElement(By.xpath("//android.widget.TextView[@text='WiFi settings']")).click();
       
        driver.findElement(By.xpath("//android.widget.EditText[@resource-id='android:id/edit']")).sendKeys("Jayant");

        driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
        //driver.findElementByAndroidUIAutomator("text(\"views\")");
        int num = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
        System.out.println(num);
      */
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		/*driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='2. Inline']")).click();
		driver.findElement(By.xpath("//*[@content-desc='9']")).click();
        TouchAction t = new TouchAction(driver);
       WebElement e1 = driver.findElement(By.xpath("//*[@content-desc='15']"));
       WebElement e2 = driver.findElement(By.xpath("//*[@content-desc='45']")); 
       // t.tap(tapOptions().withElement(element(e1))).perform();
     
        //For swipping from one point to another
        t.longPress(longPressOptions().withElement(element(e1)).withDuration(ofSeconds(2))).moveTo(element(e2)).release().perform();*/
        //System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='Sample menu']")).isDisplayed());
		
		//For Scrolling
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Rating Bar\"));");
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		TouchAction t = new TouchAction(driver);
		WebElement e1 = driver.findElement(By.xpath("//android.view.View[@index='1']"));
		WebElement e2 = driver.findElement(By.xpath("//android.view.View[@index='2']"));
		t.longPress(longPressOptions().withElement(element(e1)).withDuration(ofSeconds(2))).moveTo(element(e2)).release().perform();
	}
	
	
	public void BasicTest()
	{
		
		
		
	}
	
	

}
