package com.tekclan.demo.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.tekclan.demo.Core.EnvParameters;




public class WebObjects {
	protected static Properties props = new Properties();
	
	 static {

		    FileInputStream webStream = null;
		    try {
		     
		        webStream = new FileInputStream(EnvParameters.TEST_ROOT_DIR + File.separator + "ObjectRepo"
		            + File.separator + "PROP" + File.separator + "Web_ObjectRepository.properties");
		        props.load(webStream);
		     
		      

		    } catch (IOException e) {
		      props = null;

		      // do nothing
		      // System.err.println("Failed to read:
		      // ObjectRepository.properties");
		    }
		  }
	 
	 
	  public static String getLocator(String locatorName) {
	    if (props == null) {
	      // System.err.println("Failed to read:
	      // ObjectRepository.properties");
	      throw new CustomException(
	          "Failed to read: Web_ObjectRepository.properties -> It is either not present or not readable");

	    }
	    String locvalue = props.getProperty(locatorName);
	    return locvalue;
	  }


}
