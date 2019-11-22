package com.tekclan.demo.Core;

import java.io.File;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import com.tekclan.demo.Utils.LoggerUtil;




public class DriverBase {
	protected WebDriver driver;
	
	@BeforeMethod(alwaysRun = true)
	public void testSetup() throws Exception {

		
			String browser = EnvParameters.BROWSER_NAME;	
		if (browser.equals("chrome")) {
			try {
				setupChromeDriver();
				driver =new ChromeDriver();
			} catch (Exception e) {
				LoggerUtil.log(e.getMessage());
			}
		
      }
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		

	}
	private static void setupChromeDriver() throws Exception {

		String ChromProp = "webdriver.chrome.driver";
		new EnvParameters();
		File targetChromedriver = null;
		
			targetChromedriver = new File(EnvParameters.TEST_ROOT_DIR + File.separator + "drivers" + File.separator
					+ "chrome" + File.separator + "win" + File.separator + "chromedriver.exe");
		
			if (targetChromedriver.exists()) {

			System.setProperty(ChromProp, targetChromedriver.getAbsolutePath());

			return;
		}
	}
	

}
