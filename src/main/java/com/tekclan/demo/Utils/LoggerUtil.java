package com.tekclan.demo.Utils;

import org.apache.log4j.Logger;


public class LoggerUtil {
	  static Logger logger = Logger.getLogger(LoggerUtil.class);
	
	public static void log(String message) {
        logger.info(message);
        
    }

}
