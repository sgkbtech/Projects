package com.tekclan.demo.Core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.tekclan.demo.Utils.CustomException;


public class EnvParameters {
	public static final String TEST_ROOT_DIR;
	public static final String EXECUTION_ENV;
	public static final String BROWSER_NAME;
	
	private static final String PROP_FILE = "config.properties";

	private static Properties properties = new Properties();
	
	static {
		// Loading General Configurations
		TEST_ROOT_DIR = System.getProperty("user.dir");
		FileInputStream in = null;
		try {
			in = new FileInputStream(TEST_ROOT_DIR + File.separator + PROP_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new CustomException(
					PROP_FILE + " -> Config file not found, Please specify the correct config file");
		}

		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new CustomException("Failure loading property file -> " + e.getMessage());
		}
		// Load EXECUTION_ENV
		 if (properties.getProperty("execution.env") != null
				&& !(properties.getProperty("execution.env").equalsIgnoreCase(""))) {
			EXECUTION_ENV = properties.getProperty("execution.env");
		} else {
			throw new CustomException(
					"execution.env property not set, " + "it is mandate to define the execution.env property");
		}
		
		
		

	
		
		// Load BROWSER_NAME from browser.name property
         if (properties.getProperty("Browser") != null
                && !(properties.getProperty("Browser").equalsIgnoreCase(""))) {
          BROWSER_NAME = properties.getProperty("Browser");
        } else {
          BROWSER_NAME = "";
        }

		
		

}
}
