package com.ecom.testcases;
import org.testng.annotations.Test;
import com.ecom.baseclass.BaseTest;

public class SmokeTest extends BaseTest {

	
	@Test(groups= {"smoke"})
	public void smoketest() {
		logger.info("app url opens successfully and smoke test is passed");
		
	}
}
