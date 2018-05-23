package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class SponsorEditVerify extends BaseClass{
	@Test
	@Parameters({"rowNum" ,"sponsorSheet","PaymentSheet", "SignInSheet"})
	public void SponsorshipFlow(int rowNum, String sponsorSheet,String paymentSheet, String signInSheet) throws IOException {
		
		String communityName  = data.getCellData(sponsorSheet, "CommunityName", rowNum);
		String amount   = data.getCellData(sponsorSheet, "Amount", rowNum);
		String startDate = data.getCellData(sponsorSheet, "StartDate", rowNum);
		String endDate   = data.getCellData(sponsorSheet, "EndDate", rowNum);
		String country   = data.getCellData(sponsorSheet, "Country", rowNum);
		String street1	 = data.getCellData(sponsorSheet, "Street1", rowNum);
		String street2 	 = data.getCellData(sponsorSheet, "Street2", rowNum);
		String city		 = data.getCellData(sponsorSheet, "City", rowNum);
		String state 	 = data.getCellData(sponsorSheet, "State", rowNum);
		String zip       = data.getCellData(sponsorSheet, "Zip", rowNum);
		
		String email = data.getCellData(signInSheet, "Email",rowNum);
		String password = data.getCellData(signInSheet, "Password", rowNum);
		
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
		
		String newAmount = data.getCellData(sponsorSheet,"NewAmount", rowNum);
		
		CommonMethod.setUrl(SponsorshipUrl);
		CommonMethod.selectdropdown("communityName", communityName);

		CommonMethod.click("Events");
		CommonMethod.sendKeys("sponsorAmount", amount);
		CommonMethod.moveToElement("startDate");
		CommonMethod.click("startDate");
		CommonMethod.sendKeys("startDate", startDate);
		CommonMethod.sendKeys("endDate", endDate);
		CommonMethod.selectdropdown("communityCountry", country);
		CommonMethod.sendKeys("CommunityAdd1", street1);
		CommonMethod.sendKeys("CommunityAdd2", street2);
		CommonMethod.sleep(2000);
		CommonMethod.sendKeys("CommunityCity", city);
		CommonMethod.selectdropdown("CommunityState", state);
		CommonMethod.sendKeys("CommunityZip",zip );
		String[] splits = CommonMethod.getText("sponsorshipAmount").split(" ");
		String Amount = splits[1];
		data.setCellData(sponsorSheet, "TotalAmount", rowNum, Amount);
		CommonMethod.click("CommunityContinue");
		CommonMethod.sleep(3000);
		CommonMethod.sendKeys("SignInEmailId", email);
		CommonMethod.sendKeys("SignInpassword", password);
		CommonMethod.click("CommunityContinue");
		CommonMethod.sleep(3000);
		
		CommonMethod.click("sponsorDetailsEdit");
		CommonMethod.moveToElement("sponsorAmount");
		CommonMethod.sleep(2000);
		System.out.println(newAmount);
		CommonMethod.sendKeys1("sponsorAmount", newAmount);
		System.out.println("Amount changed from 1000 to 300");
		CommonMethod.click("CommunityContinue");
		CommonMethod.sleep(2000);
		CommonMethod.assertEqualsMessage("VerifySponserAmount",newAmount,"Amount didn't matched");
		
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
		CommonMethod.takeScreenshot("sponsorEditverify");
		String SponAmount =  Amount + ".00";

		CommonMethod.assertEqualsmessage("VerifySponserCommName", communityName, "Sponsorship Community name is not correct");
		System.out.println(CommonMethod.getText("VerifySponserType"));
		CommonMethod.assertEqualsmessage("VerifySponserStartsOn", startDate, "Event start date is not correct");
		CommonMethod.assertEqualsmessage("VerifySponserValidUntil", endDate , "Event end date is not correct");
		CommonMethod.assertEqualsmessage("VerifySponserAmount", SponAmount , "Sponsorship amount is not correct");
	

}


}
