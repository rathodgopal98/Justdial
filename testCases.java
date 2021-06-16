package testCases;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Amazon;
import pages.Flipkart;
import pages.Compare;
 
public class testCases {
 
 public static void main(String[] args) throws InterruptedException {
 
 System.setProperty("webdriver.chrome.driver", "---Exact path to chromedriver.exe---");
 WebDriver driver = new ChromeDriver();

 
 //Creating object of home page
AmazonPage home = new HomePage(driver);
 
 //Creating object of Login page
FlipkartPage login = new LoginPage(driver);
 
 //Creating object of Dashboard
Compare dashboard = new Compare(driver);
 
 //Click on Login button
 home.clickLogin();
 
 public boolean CompareTwoProductsUsingXPATHAxes(String searchString,ArrayList<String> skuList) {
 
		try {
			String PRODUCT = searchString;
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.flipkart.com/"");
                        driver.get("https://www.amazon.com/"");
 
 
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
 
               //Close browser instance
               driver.quit();
 }
 
}