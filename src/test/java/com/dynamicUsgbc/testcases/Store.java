package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class Store extends BaseClass{

	@Test
	@Parameters({"rowNum" ,"PaymentSheet","SignInSheet","Storesheet"})
	public void StoreFlow(int rowNum, String Storesheet, String paymentSheet, String SignInSheet) throws Exception {
		
		String country   = data.getCellData(Storesheet, "Country", rowNum);
		String street1	 = data.getCellData(Storesheet, "Street1", rowNum);
		String street2 	 = data.getCellData(Storesheet, "Street2", rowNum);
		String city		 = data.getCellData(Storesheet, "City", rowNum);
		String state 	 = data.getCellData(Storesheet, "State", rowNum);
		String zip       = data.getCellData(Storesheet, "Zip", rowNum);
		String serviceType = data.getCellData(Storesheet, "ServiceType", rowNum);
		String school 	   = data.getCellData(Storesheet, "School", rowNum);
		String studentId   = data.getCellData(Storesheet, "StudentId", rowNum);
		String graduation  = data.getCellData(Storesheet, "Graduation", rowNum);
		
		String email = data.getCellData(SignInSheet, "Email",rowNum);
		String password = data.getCellData(SignInSheet, "Password", rowNum);
		
		String NameOnCard = data.getCellData(paymentSheet, "Name", rowNum);
		String CardNumber = data.getCellData(paymentSheet, "CardNumber", rowNum);
		String ExpirationMonth = data.getCellData(paymentSheet, "ExpMonth", rowNum);
		String ExpirationYear = data.getCellData(paymentSheet, "ExpYear", rowNum);
		String SecurityCode = data.getCellData(paymentSheet, "SecurityCode", rowNum);
		String BillCountry = data.getCellData(paymentSheet, "Country", rowNum);
		String BillStreetAdd1 = data.getCellData(paymentSheet, "Street1", rowNum);
		String BillStreetAdd2 = data.getCellData(paymentSheet, "Street2", rowNum);
		String BillCity = data.getCellData(paymentSheet, "City", rowNum);
		String BillState = data.getCellData(paymentSheet, "State", rowNum);
		String BillZipCode = data.getCellData(paymentSheet, "Zip", rowNum);
		
		CommonMethod.ExtentReportConfig();
		CommonMethod.setUrl(StoreUrl);
		CommonMethod.sleep(1000);
		CommonMethod.click("geenApplePins");
		CommonMethod.sleep(1000);
		CommonMethod.click("addToCart");
		CommonMethod.click("clickCheckout");
		
		//CommonMethod.selectdropdown("shippingCountry", country);
		//CommonMethod.moveToElement("shippingAdd1");
		CommonMethod.sendKeys("CommunityAdd1", street1);
		System.out.println("im here");
		CommonMethod.sendKeys("CommunityAdd2", street2);
		CommonMethod.sendKeys("CommunityCity", city);
		CommonMethod.selectdropdown("CommunityState", state);
		CommonMethod.moveToElement("CommunityZip");
		CommonMethod.sendKeys("CommunityZip",zip );
		System.out.println("im here");
		CommonMethod.selectdropdown("selectServiceType", serviceType);
		Thread.sleep(4000);
		CommonMethod.click("IsStudent");
		CommonMethod.sendKeys("SchoolName", school);
		CommonMethod.sendKeys("StudentId", studentId);
		CommonMethod.sendKeys("GraduationDate", graduation);
		CommonMethod.click("HearEmail");
		data.setCellData(Storesheet,"TotalAmount" , rowNum, CommonMethod.getText("finalShippingPrice"));
		CommonMethod.click("CommunityContinue");
		Thread.sleep(3000);

		CommonMethod.sendKeys("SignInEmailId", email);
		CommonMethod.sendKeys("SignInpassword", password);
		CommonMethod.click("CommunityContinue");
		
		CommonMethod.sendKeys("NameOnCard", NameOnCard);
		CommonMethod.sendKeys("CardNumber", CardNumber);
		CommonMethod.selectdropdown("ExpirationMonth", ExpirationMonth);
		CommonMethod.selectdropdown("ExpirationYear", ExpirationYear);
		CommonMethod.sendKeys("SecurityCode", SecurityCode);
		CommonMethod.selectdropdown("BillCountry", BillCountry);
		CommonMethod.sendKeys("BillStreetAdd1", BillStreetAdd1);
		CommonMethod.sendKeys("BillStreetAdd2", BillStreetAdd2);
		CommonMethod.sendKeys("BillCity", BillCity);
		CommonMethod.selectdropdown("BillState", BillState);
		CommonMethod.sendKeys("BillZipCode", BillZipCode);
		CommonMethod.click("PaymentSubmitButton");
		CommonMethod.sleep(3000);
		
		CommonMethod.assertEqualsmessage("VerifyStoreCity", city, "billing City is not correct");
		CommonMethod.assertEqualsmessage("VerifyStoreState", state, "Billing State is not correct");
		
		CommonMethod.takeScreenshot("StoreFlow");
		
	}
}
