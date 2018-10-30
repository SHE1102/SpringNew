package com.syx.log;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:")
public class LogTest {

	private Logger log = Logger.getLogger(LogTest.class);
	@Test
	public void run(){
		log.info("test logging...");
	}

}
