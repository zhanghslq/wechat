package com.yb.test;

import org.apache.log4j.Logger;

public class TestLog {
	public static void main(String[] args) {
		Logger log = Logger.getLogger(TestLog.class);
		//PropertyConfigurator.configure("log4j.properties");
		//log.debug("yes,debug");
		//log.info("yes,info");
		log.error("yes,error");
		//log.warn("yes,warn");
	}
}
