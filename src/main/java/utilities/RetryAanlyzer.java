package utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAanlyzer implements IRetryAnalyzer {
	
	private int count=0;
	private static int maxretrycount=2;
	
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxretrycount) {
			count++;
			return true;
		}
		return false;
	}
}
