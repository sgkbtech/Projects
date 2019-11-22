package com.tekclan.Test;

import org.testng.annotations.Test;

import com.tekclan.Pageobjects.FlightList;
import com.tekclan.Pageobjects.SearchPage;
import com.tekclan.demo.Core.DriverBase;

public class FirstTest extends DriverBase {
	
	
	@Test
	public void SearchFlights() {
		driver.get("https://www.cheapair.com/");
		SearchPage objSearchpage = new SearchPage(driver);
		objSearchpage.searchFlights("Chennai Intl. Airport (MAA) Madras, India", "Bangkok, Thailand");
		FlightList objFlightList = new FlightList(driver);
		objFlightList.selectFlight();
	}

}
