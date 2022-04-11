package org.test;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ExecuteFailedTCs implements IRetryAnalyzer {

	int minCount=1, maxCount=10;
	
	public boolean retry(ITestResult result) {
		if(minCount<maxCount) {
			minCount++;
			return true;
		}
		return false;
	}

}
