package com.syx.log;

import org.junit.Test;
import org.apache.log4j.Logger;

public class LogTest {

	private Logger log = Logger.getLogger(LogTest.class);
	
	@Test
	public void run(){
		log.info("test logging...");
	}

}
