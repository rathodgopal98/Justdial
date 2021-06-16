package Pages;
public class AmazonHomePage extends BasePage {

public void NavigateTo()
{

driver.navigate().to(""https://www.flipkart.com/");
driver.findelement(By.id("id="twotabsearchtextbox")).sendKeys("iphone xr 64gb - yellow");
driver.findelement(By.id("id="nav-search-submit-button")).click();
Action sendPageDown = actions.sendKeys(Keys.PAGE_DOWN).build();
sendPageDown.perform();

}

