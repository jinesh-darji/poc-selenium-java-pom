package com.ubix.listeners;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class CustomRetryAnalyzer  implements IRetryAnalyzer{
	private static final int maxRetryCount = 2; // You can adjust the maximum retry count as needed
    private int retryCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
}
