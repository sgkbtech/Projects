package com.tekclan.demo.Core;

import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.tekclan.demo.Utils.CustomException;





public class SeleniumBase {
	
	
	 protected WebDriver driver;
	 protected static final Logger log = Logger.getLogger(SeleniumBase.class);
	 
	  protected void clickOnElement(String elementLocator) {
		    By locator = ObjectLocators.getBySelector(elementLocator);
		    WebElement element = driver.findElement(locator);
		    if (element.isDisplayed()) { // can be replaced with Expected
		      // conditions' elementToBeClickable
		      element.click();
		      log.info("Clicked on element: " + locator);
		    }
		  }
	  
	  protected String getWindowHandle() {
		    return driver.getWindowHandle();
		  }
	  
	  protected int getNumberOfOpenWindows() {
		    return driver.getWindowHandles().size();
		  }
	  protected void pageLoadTime(int loadTimeInSec) {
		    driver.manage().timeouts().pageLoadTimeout(loadTimeInSec, TimeUnit.SECONDS);

		  }
	  protected void clearText(String elementLocator) {
		    By locator = ObjectLocators.getBySelector(elementLocator);
		    WebElement element = driver.findElement(locator);
		    if (element.isDisplayed()) { // can be replaced with Expected
		      // conditions' elementToBeClickable
		      element.clear();
		      log.info("Element cleared: " + locator);
		    }
		  }

	  
	  protected void switchToWindowByTitle(String titleOfNewWindow) {
		    Set<String> windowHandles = driver.getWindowHandles();
		    for (String windowHandle : windowHandles) {
		      driver.switchTo().window(windowHandle);
		      if (driver.getTitle().contains(titleOfNewWindow)) {
		        break;
		      }
		    }
		  }
	  
	  protected void type(String elementLocator, String text) {
		    // By locator = ObjectLocators.getBySelector(elementLocator);
		    log.info("Entering Text");
		    By locator = ObjectLocators.getBySelector(elementLocator);
		    WebElement element = driver.findElement(locator);
		    
		    element.sendKeys(text);
		    
		    log.info("Entered " + text + " into the " + elementLocator + " text field");
		  }

	  
	  protected void switchToDefaultContent() {
		    driver.switchTo().defaultContent();
		  }
	  private List<WebElement> findElements(By by) throws CustomException {
		    try {
		      return driver.findElements(by);
		    } catch (NoSuchElementException e) {
		      String msg = "Element could not be located " + by.toString();
		      log.info(msg);
		      throw new CustomException(msg);
		    }
		  }
	  
	  protected boolean isElementPresent(String propKey) {
		    By locator = ObjectLocators.getBySelector(propKey);
		    log.debug("Checking the presence of the Element: " + propKey + " : " + propKey);
		    return isElementPresent(locator);
		  }
	  private boolean isElementPresent(By by) {
		    try {
		      WebElement element = driver.findElement(by);
		      if (element != null) {
		        log.debug("Element is present: " + by.toString());
		        return true;
		      }
		      log.warn("Element is NOT present: " + by.toString());
		      return false;
		    } catch (NoSuchElementException e) {
		      return false;
		    } catch (Exception e) {
		      log.warn(e.getMessage(), e);
		      return false;
		    }
		  }
	  
	  protected String getText(String elementLocator) {
		    By locator = ObjectLocators.getBySelector(elementLocator);
		    log.info("Getting the text of the element: " + locator);
		    return this.driver.findElement(locator).getText();
		  }
	  
	  protected void acceptAlert() {
		    log.info("Confirming the operation");
		    driver.switchTo().alert().accept();
		  }
	  protected void dismissAlert() {
		    log.info("Cancelling the operation");
		    driver.switchTo().alert().dismiss();
		  }

}
