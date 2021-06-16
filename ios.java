package com.testau;


import io.appium.java_client.ios.IOSDriver;

import io.appium.java_client.pagefactory.IOSBy;

public class PageObjectPage1 extends BasePage{

public class PageObjectPage1(IOSDriver driver)
{
super(driver);
}
@iOSBy(xpath="//"[@txt="iPhone XR (64GB) - Yellow']")

public PageObjectPage2 clickOniPhone() throws IE  {
iPhone.click();

return new PageObjectPage2(driver);
}
}
