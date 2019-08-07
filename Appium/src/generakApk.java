import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import  static io.appium.java_client.touch.TapOptions.tapOptions;
import  static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static java.time.Duration.ofSeconds;
import  static io.appium.java_client.touch.offset.ElementOption.element;

public class generakApk

{   
	//public  static AndroidDriver<AndroidElement> driver;
	public AndroidDriver<AndroidElement> driver ;
	initialiseApk2 apk = new initialiseApk2();
	
    @BeforeTest
	public void driverInitiate() throws MalformedURLException, InterruptedException
	
	{
		
		 driver = initialiseApk2.Capabilities();
		
	}
	
	
		
    /*public AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException, InterruptedException
	
	 {
		File f = new File("src");
		File fs = new File(f,"General-Store.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("BROWSER_NAME", "Android");
		capabilities.setCapability("automationName", "uiautomator2");
		//capabilities.setCapability("VERSION", "4.4.2"); 
		//capabilities.setCapability("deviceName","Android Device");
		capabilities.setCapability("deviceName","Galaxy S6 edge");
		capabilities.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");		
	    capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");// This is Launcher activity of your app (you can get it from apk info app)
        
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);	
		return driver;
		
	}*/
	
	
	
	@Test
	public void scenario1() throws InterruptedException, MalformedURLException
	
	{	
      //this.driver
		TouchAction t = new TouchAction(driver);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");
		driver.hideKeyboard();
        driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));").click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
                + "new UiSelector().text(\"Jordan 6 Rings\"));");
       /* int count = driver.findElements(By.id("com.androidsample.generalstore:id/productImage")).size();
        
        for (int i=0;i<count;i++)
        {
        	String name = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
        	if (name.equalsIgnoreCase("Jordan 6 Rings"))
        	{
        		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
        		break;
        	}
        	}/*       
        /*For Verifying the toast messages in appium
        String toastmessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		System.out.println(toastmessage);
		Assert.assertEquals("Please enter your name", toastmessage);*/
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(0).click();
        driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(1).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
      /*  Thread.sleep(3000);
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
        double sum= 0;
        for (int i=0;i<count;i++)
        {
        	
       String   p =  driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
       Double amnt1 = amount(p);
       sum = sum + amnt1;
       
       }
       String total = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
       Double finalamnt = amount(total);
       Assert.assertEquals(sum, finalamnt);
       System.out.println("Passed");*/
        WebElement e2 = driver.findElement(By.xpath("//android.widget.CheckBox[@text='Send me e-mails on discounts related to selected products in future']"));

        t.tap(tapOptions().withElement(element(e2))).perform();
        WebElement e1 = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        t.longPress(longPressOptions().withElement(element(e1))).perform();
       WebElement e3 = driver.findElement(By.id("android:id/button1"));
       t.tap(tapOptions().withElement(element(e3))).perform();
       
       WebElement e4 = driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
       t.tap(tapOptions().withElement(element(e4))).perform();
       Thread.sleep(7000);
       Set<String> contextnames = driver.getContextHandles();
       driver.context((String) contextnames.toArray()[1]);
       driver.findElement(By.name("q")).sendKeys("keysToSend");
       
     
        //t.longPress(longPressOptions().withElement(element(e1)).withDuration(ofSeconds(2))).moveTo(element(e2)).release().perform();
       
    }
	
	   public static Double amount(String p)
	   
	   {
		   p = p.substring(1);
		   Double amnt = Double.parseDouble(p);
		   return amnt;      
	   }
	
	}