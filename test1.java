package qa.mobile;

import org.testng.annotations.Test;

public class test1  {
@Test{

public class CompareTwoProducts {
 
	public static void main(String[] args) {
		ArrayList<String> listofSKU= new ArrayList<String>();
		listofSKU.add("a");
		listofSKU.add("b");
		listofSKU.add("c");
	}
 
	
	public void CompareTwoProductsUsingForLoopCollections(String searchString,String sku1, String sku2) {
 
		try {
			String PRODUCT = searchString;
 
			//Browser Set Up and navigate
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(""https://www.amazon.com/"");//difference btw and naviogate/get
 
			//Checkpoint
			String expected_title = "iphone xr 64gb - yellow";
			String actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, expected_title, "Title is correct");
 
 
			//Search for item
			WebElement txtbx_search = driver.findElement(By.id("searchBox_Global"));
			txtbx_search.sendKeys(PRODUCT);
 
			driver.findElement(By.id("search-submit-anchor")).click();
 
			//Check point
			expected_title = "Product Search";
			actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, expected_title, "Product search Title is correct");
 
			//Find list of all the Checkbox
			List<WebElement> col_of_chkbx = driver.findElements(By.xpath("//div[@class='search-results']//input[@type='checkbox']"));
			List<WebElement> col_of_skus = driver.findElements(By.xpath("//div[@class='prod-number-container vpn_breakword']//span[2]"));
 
			for(int i=0;i<=col_of_skus.size();i++) {
				if (col_of_skus.get(i).getText().trim().equalsIgnoreCase(sku1)) {
					col_of_chkbx.get(i).click();
				}
				if (col_of_skus.get(i).getText().trim().equalsIgnoreCase(sku2)) {
					col_of_chkbx.get(i).click();
				}
			}
 
 
 
		}catch(Exception e) {
			Assert.assertFalse(false, "Exception thrown. Exception: " + e.toString());;	
		}
 
	}
 
	//Using XPATH
	public void CompareTwoProductsUsingXPATH(String searchString,String sku1, String sku2) {
 
		try {
			String PRODUCT = searchString;
 
			//Browser Set Up and navigate
			System.setProperty("webdriver.chrome.driver", "R:\\_Rathod\\Automation\\dependencies\\chromedriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com/");//difference btw and naviogate/get
 
			//Checkpoint
			String expected_title = "iphone xr 64gb - yellow";
			String actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, expected_title, "Title is correct");
 
 
			//Search for item
			WebElement txtbx_search = driver.findElement(By.id("searchBox_Global"));
			txtbx_search.sendKeys(PRODUCT);
 
			driver.findElement(By.id("search-submit-anchor")).click();
 
			//Check point
			expected_title = "Product Search";
			actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, expected_title, "Product search Title is correct");
 
			//SKU 1 Check box
			WebElement sku1_checkbx = 
					driver.findElement(By.xpath("//input[@type = 'checkbox' and @value = '"+sku1+"']"));
 
			//sku2
			WebElement sku2_checkbx = 
					driver.findElement(By.xpath("//input[@type = 'checkbox' and @value = '"+sku2+"']"));
			sku1_checkbx.click();
			sku2_checkbx.click();
 
 
		}catch(Exception e) {
			Assert.assertFalse(false, "Exception thrown. Exception: " + e.toString());;	
		}
 
	}
 
 
	//Using XPATH Axes
	public boolean CompareTwoProductsUsingXPATHAxes(String searchString,ArrayList<String> skuList) {
 
		try {
			String PRODUCT = searchString;
 
			
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://ca.ingrammicro.com/");//difference btw and naviogate/get
 
			//Checkpoint
			String expected_title = ""https://www.flipkart.com/"";
			String actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, expected_title, "Title is correct");
 
 
			//Search for item
			WebElement txtbx_search = driver.findElement(By.id("searchBox_Global"));
			txtbx_search.sendKeys(PRODUCT);
 
			driver.findElement(By.id("search-submit-anchor")).click();
 
			//Check point
			expected_title = "Product Search";
			actual_title = driver.getTitle();
			Assert.assertEquals(actual_title, expected_title, "Product search Title is correct");
 
 
			//span[contains(text(),'387DDH')]/ancestor::div[@class='prod-details']		
			//sku2
			for (int i=0;i<skuList.size();i++) {
 
				//Error Validation if any Product is Not Found
				try {
					WebElement sku_cckbx = 
							driver.findElement(By.xpath("//span[contains(text(),'"+skuList.get(i)+"')]/parent::div/parent::div/parent::div/parent::div/preceding-sibling::div[@class='prod-compare-checkbox']/input"));
					//or 
					driver.findElement(By.xpath("//span[contains(text(),'"+skuList.get(i)+"')]/ancestor::div[@class='prod-details']"));
					sku_cckbx.click();	
					Reporter.log("SKU selected: " + skuList.get(i));
					
				}catch(Exception e) {// NoSuchElement Exception here
					e.printStackTrace();
					return false;
				}
 
			}
			
			//Code to Click on Compare and Compare the values of the Products
		}catch(Exception e) {
			Assert.assertFalse(false, "Exception thrown. Exception: " + e.toString());;	
		}
	
 
	}
 
}


public void ()
}
@BeforeClass
public void beforeClass()  {
DesiredCapabilities capabilities = new DesiredCapabilities();
 capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
 capabilities.setCapability("deviceName", "Samsung");
 capabilities.setCapability("platformVersion", "10.0");
 capabilities.setCapability("platformName", "Android");
 capabilities.setCapability("app", app.getAbsolutePath());
 capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
 capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
 driver = new AndroidDriver<MobileElement>(new URL("https://127.0.0.1:4723/wd/hub"), capabilities);
 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
 Thread.sleep(10000);
}

@AfterClass
public void  afterClass()

{
driver.quit();
}