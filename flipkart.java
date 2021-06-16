package Pages;
public class FlipkartHomePage extends BasePage {

public void NavigateTo()
{



public static void main (String[] args)  {
WebDriver river = new FirefoxDriver();
driver.get("http://www.amazon.com/");
driver.findelement(By.id("id="twotabsearchtextbox")).sendKeys("iphone xr 64gb - yellow");
driver.findelement(By.id("id="nav-search-submit-button")).click();
Action sendPageDown = actions.sendKeys(Keys.PAGE_DOWN).build();
sendPageDowmn.perform();
