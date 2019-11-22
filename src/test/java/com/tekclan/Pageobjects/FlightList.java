package com.tekclan.Pageobjects;

import java.util.Set;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;

import com.tekclan.demo.Utils.WebObjects;

public class FlightList extends SearchPage {

	public FlightList(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
  String price=WebObjects.getLocator("price");
  String bookbtn=WebObjects.getLocator("price");
  String close=WebObjects.getLocator("price");
  
  public void selectFlight() {
	  
	  String parentWinHandle = driver.getWindowHandle();
      System.out.println("Parent window handle: " + parentWinHandle);
  Set<String> winHandles = driver.getWindowHandles();
	  for(String handle: winHandles){
          if(!handle.equals(parentWinHandle)){
          driver.switchTo().window(handle);
          try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          System.out.println("Title of the new window: " +
driver.getTitle());
  }
          }
	 pageLoadTime(10);
	 clickOnElement(close);
	  clickOnElement(price);
	  clickOnElement(bookbtn);
	  
  }
  
}
