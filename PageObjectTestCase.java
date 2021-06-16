package com.testmobilescrits;

import org.testng.annotations.Test;

import com.testautoamtion.Utility.BowserUtility;
import com.testautomation.mobile.pages.PageObjectPage1;

import io.appium.java_client.andriod.AndriodDriver;

public class PageObjectTestCase   {

@Test

public void pageObjectTestCase()   {
     Andriodiver driver=BrowserUtility.getAndriodDriver();

try{

 PageObjectPage1  pageObjectPage1=new  PageObjectPage1(driver);
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

e.printStackTrace();

}
return driver;
}




			Assert.assertFalse(false, "Exception thrown. Exception: " + e.toString());;	
		}
	
 
	}
 
}






