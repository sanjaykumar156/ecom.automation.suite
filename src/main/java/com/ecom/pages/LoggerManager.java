package com.ecom.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {
	public static Logger getlogger(Class<?> clazz) {
		return LogManager.getLogger(clazz);
	}

}
