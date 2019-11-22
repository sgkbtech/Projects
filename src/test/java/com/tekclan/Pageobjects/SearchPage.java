package com.tekclan.Pageobjects;

import org.openqa.selenium.WebDriver;

import com.tekclan.demo.Core.ObjectLocators;
import com.tekclan.demo.Core.SeleniumBase;
import com.tekclan.demo.Utils.WebObjects;

public class SearchPage extends SeleniumBase {
	
	String from=WebObjects.getLocator("from");
	String to=WebObjects.getLocator("to");
	String datetxt=WebObjects.getLocator("datetxt");
	String date=WebObjects.getLocator("date");
	String search=WebObjects.getLocator("searchbtn");
	String oneway=WebObjects.getLocator("oneway");

	
public SearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver=driver;
	}


public void searchFlights(String fro,String t) {
	clickOnElement(oneway);
	clearText(from);
	type(from,fro);
	type(to,t);
	
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	clickOnElement(datetxt);
	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	clickOnElement(date);
	
	clickOnElement(search);
	
}
}
