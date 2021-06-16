package com.testau;

import io.appium.java_client.andriod.AndriodDriver;

import io.appium.java_client.andriod.AndriodElement;

import io.appium.java_client.pagefactory.AndriodElement;

public class PageObjectPage1 extends BasePage{

public class PageObjectPage1(AndriodDriver driver)
{
super(driver);
}
@AndriodFindBy(xpath="//"[@txt="iPhone XR (64GB) - Yellow']")

public PageObjectPage2 clickOniPhone() throws IE  {
.click();

return new PageObjectPage2(driver);
}
}

 