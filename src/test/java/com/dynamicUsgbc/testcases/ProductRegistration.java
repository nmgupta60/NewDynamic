package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ProductRegistration extends BaseClass{
	
	@Test
	@Parameters
	public void ProductRegistrationFlow() throws Exception {
		
		CommonMethod.ExtentReportConfig();
		CommonMethod.setUrl(ProductUrl);
		CommonMethod.sleep(1000);
		CommonMethod.takeScreenshot("Product");
		
	}

}
