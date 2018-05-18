package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class CommunityRegistration extends BaseClass {

	@Test
	@Parameters({"rowNum" ,"PaymentSheet","SignInSheet","communitySheet"})
	public void CommunityRegistrationFlow(int rowNum,String paymentSheet,String SignInSheet,String communitySheet) throws IOException {
		
		String communityName = data.getCellData(communitySheet, "CommunityName", rowNum);
		String country = data.getCellData(communitySheet, "Country", rowNum);
		String street1 = data.getCellData(communitySheet, "Street1", rowNum);
		String street2 = data.getCellData(communitySheet, "Street2", rowNum);
		String city = data.getCellData(communitySheet, "City", rowNum);
		String state = data.getCellData(communitySheet, "State", rowNum);
		String zip = data.getCellData(communitySheet, "Zip", rowNum);
		String schoolName = data.getCellData(communitySheet, "SchoolName", rowNum);
		String studentId = data.getCellData(communitySheet, "StudentID", rowNum);
		String graduationDate = data.getCellData(communitySheet, "GraduationDate", rowNum);
		String dob = data.getCellData(communitySheet, "DOB", rowNum);
		
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
		
		CommonMethod.setUrl(CommunityRegistrationUrl);
		
		CommonMethod.selectdropdown("communityName", communityName);
		CommonMethod.selectdropdown("communityCountry", country);
		CommonMethod.moveToElement("CommunityAdd1");
		CommonMethod.sendKeys("CommunityAdd1", street1);
		CommonMethod.moveToElement("CommunityAdd2");
		CommonMethod.sendKeys("CommunityAdd2", street2);
		CommonMethod.sendKeys("CommunityCity", city);
		CommonMethod.selectdropdown("CommunityState", state);
		CommonMethod.moveToElement("CommunityZip");
		CommonMethod.sendKeys("CommunityZip", zip);
		CommonMethod.click("IsStudent");
		CommonMethod.sendKeys("SchoolName", schoolName);
		CommonMethod.sendKeys("StudentId", studentId);
		CommonMethod.moveToElement("GraduationDate");
		CommonMethod.sleep(2000);
		CommonMethod.sendKeys("GraduationDate", graduationDate);
		CommonMethod.click("IsEmergingProff");
		CommonMethod.moveToElement("EmergingProffDOB");
		CommonMethod.sendKeys("EmergingProffDOB", dob);
		CommonMethod.sleep(3000);
		CommonMethod.click("HearEmail");
		CommonMethod.click("tickAgree");
		CommonMethod.sleep(2000);
		String[] splits = CommonMethod.getText("CommunityRegAmt").split(" ");
		String Amount = splits[1];
		data.setCellData(communitySheet, "TotalAmount", rowNum, Amount);
		CommonMethod.click("CommunityContinue");
		CommonMethod.sleep(2000);
		
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
		
		CommonMethod.assertEqualsmessage("ReceiptCommunityName", communityName, "Community Name is not correct");
		CommonMethod.takeScreenshot("communityregistration");
		
	}
}
