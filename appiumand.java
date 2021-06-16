importjava.io.File;
importjava.net.MalformedURLException;
import java.net.URL;
importjava.util.List;
 
importorg.openqa.selenium.By;
importorg.openqa.selenium.WebDriver;
importorg.openqa.selenium.WebElement;
importorg.openqa.selenium.remote.CapabilityType;
importorg.openqa.selenium.remote.DesiredCapabilities;
importorg.openqa.selenium.remote.RemoteWebDriver;
importorg.testng.annotations.*;
 
public class appium {
 
 WebDriver driver;
 
 @BeforeClass
 public void setUp() throws Exception {
 
//location of the app
 File app = new File("C:\\Users\\Rathod\\Downloads", "sample.apk");
  
 //To create an object of Desired Capabilities
 DesiredCapabilities capability = new DesiredCapabilities();
//OS Name
 capability.setCapability("device","Android");
 capability.setCapability(CapabilityType.BROWSER_NAME, "");
//Mobile OS version. In My case its running on Android 4.2
 capability.setCapability(CapabilityType.VERSION, "4.2");
 capability.setCapability("app", app.getAbsolutePath());
//To Setup the device name
 capability.setCapability("deviceName","Moto G");
 capability.setCapability("platformName","Android");
//set the package name of the app
 capability.setCapability("app-package", "com.example.android.contactmanager-1");
 //set the Launcher activity name of the app
 capability.setCapability("app-activity", ".ContactManager");
//driver object with new Url and Capabilities
 driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
 }
 
 @Test
public void testApp() throws MalformedURLException{
 
System.out.println("App launched");
 // locate Add Contact button and click it
WebElementaddContactButton = driver.findElement(By.name("Add Contact"));
addContactButton.click();
 //locate input fields and type name and email for a new contact and save it
 List&amp;lt;WebElement&amp;gt;textFields = driver.findElements(By.className("android.widget.EditText"));
textFields.get(0).sendKeys("Neeraj Test");
textFields.get(1).sendKeys("9999999999");
textFields.get(2).sendKeys("testemail@domain.com");
driver.findElement(By.name("Save")).click();
 //insert assertions here
 }
 }