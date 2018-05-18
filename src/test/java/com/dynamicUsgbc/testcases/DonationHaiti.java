package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class DonationHaiti extends BaseClass{

	@Test
	@Parameters({"rowNum" ,"PaymentSheet","SignInSheet","donationSheet"})
	public void DonationHaitiFlow(int rowNum,String paymentSheet,String signInSheet,String donationSheet) throws IOException  {
		
		String amount      = data.getCellData(donationSheet, "Amount", rowNum);
		String donorName   = data.getCellData(donationSheet, "DonorName", rowNum);
		String dedicatedTo   = data.getCellData(donationSheet, "DedicatedTo", rowNum);
		String email     = data.getCellData(donationSheet, "Email", rowNum);
		String message   = data.getCellData(donationSheet, "Message", rowNum);
		
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
		
		CommonMethod.setUrl(DonationsHaitiUrl);
		
		CommonMethod.selectdropdown("SelDonationAmt", amount);
		CommonMethod.sendKeys("DonorName", donorName);
		CommonMethod.sendKeys("DedicatedTo", dedicatedTo);
		CommonMethod.sendKeys("DedicatedEmail", email);
		CommonMethod.sendKeys("MessageDedicationTo", message);
		CommonMethod.click("CommunityContinue");
	    CommonMethod.sleep(3000);
	    
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
		
//		CommonMethod.assertEqualsmessage("ReceiptDonationAmount", amount, "Amount is not correct");
//		CommonMethod.assertEqualsmessage("ReceiptDonationDonatedBy", donorName, "Donor Name is not correct");
		
		CommonMethod.takeScreenshot("DonationHaiti");
		
	}
}
