package com.dynamicUsgbc.testcases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class MembershipEditVerify extends BaseClass{
	
	
	@Test
	@Parameters({"rowNum" ,"memberSheet","PaymentSheet","SignInSheet"})
	public void MembershipRegistrationFlow(int rowNum, String memberSheet, String paymentSheet, String SignInSheet) throws Exception {
		
		String email = data.getCellData(SignInSheet, "Email",rowNum);
		String password = data.getCellData(SignInSheet, "Password", rowNum);
		
		String attentionTo= data.getCellData(memberSheet, "AttentionTo", rowNum);
		String company    = data.getCellData(memberSheet, "Company", rowNum);
		String country    = data.getCellData(memberSheet, "Country", rowNum);
		String street1    = data.getCellData(memberSheet, "Street1", rowNum);
		String street2    = data.getCellData(memberSheet, "Street2", rowNum);
		String city 	  = data.getCellData(memberSheet, "City", rowNum);
		String state      = data.getCellData(memberSheet, "State", rowNum);
		String zip        = data.getCellData(memberSheet, "Zip", rowNum);
		
		String term       = data.getCellData(memberSheet, "Term", rowNum); 
		String website    = data.getCellData(memberSheet, "Website", rowNum);
		String email1      = data.getCellData(memberSheet, "Email", rowNum);
		String indCategory = data.getCellData(memberSheet, "IndustryCategory", rowNum);
		String subCategory        = data.getCellData(memberSheet, "SubCategory", rowNum);
		String revenue        = data.getCellData(memberSheet, "Revenue", rowNum);
		
		String editTerm = data.getCellData(memberSheet,  "EditTerm",rowNum);
		
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
		
		try {
			CommonMethod.ExtentReportConfig();
			CommonMethod.setUrl(MembershipUrl);
			CommonMethod.sleep(2000);
			CommonMethod.click("MemberShipClickSignIn");
			CommonMethod.sendKeys("SignInEmailId", email);
			CommonMethod.sendKeys("SignInpassword", password);
			CommonMethod.click("CommunityContinue");
		
		
		CommonMethod.sendKeys("MemberShipAttentionTo", attentionTo);
		CommonMethod.sendKeys("MemberShipCompany", company);
		CommonMethod.selectdropdown("communityCountry", country);
		CommonMethod.moveToElement("CommunityAdd1");
		Thread.sleep(2000);
		CommonMethod.sendKeys("CommunityAdd1", street1);
		CommonMethod.sendKeys("CommunityAdd2", street2);
		CommonMethod.sendKeys("CommunityCity", city);
		CommonMethod.selectdropdown("CommunityState", state);
		CommonMethod.moveToElement("CommunityZip");
		CommonMethod.sendKeys("CommunityZip", zip);
		CommonMethod.click("tickAgree");
		CommonMethod.click("CommunityContinue");

		CommonMethod.selectdropdown("MemberShipTerm",term );
		String selectedLevel = CommonMethod.clickRandomWebElement("MembershipSelectLevel");
	    data.setCellData(memberSheet, "MembershipLevel", rowNum, selectedLevel);
	    String random = CommonMethod.randomNumber();
	    CommonMethod.sendKeys("MemberShipOrganizationName", "Test Organization " + random);
		data.setCellData(memberSheet, "OrganizationName", rowNum, "Test Organization " + random);
		CommonMethod.selectdropdown("MemberShipCountryIncorporate",country );
		CommonMethod.assertEqualsMessage(CommonMethod.getFirstSelectedOptionDropdown("communityCountry"), country,"Country name didn't matched");
		CommonMethod.assertEqualsMessage(CommonMethod.getattributeValue("CommunityAdd1"), street1, "Street Adrress 1 didn't matched");
		CommonMethod.assertEqualsMessage(CommonMethod.getattributeValue("CommunityAdd2"),street2,"Street Address 2 didn't matched");
		CommonMethod.assertEqualsMessage(CommonMethod.getattributeValue("CommunityCity"), city, "City name didn't matched");
		CommonMethod.assertEqualsMessage(CommonMethod.getFirstSelectedOptionDropdown("CommunityState"), state, "State name didn't matched");
		CommonMethod.assertEqualsMessage(CommonMethod.getattributeValue("CommunityZip"), zip, "Zip code didn't matched");
		CommonMethod.sendKeys("MemberShipWebsite", website);
		CommonMethod.sendKeys("MemberShipEmailId", email1);
		CommonMethod.selectdropdown("MemberShipIndustryCategory", indCategory);
		CommonMethod.selectdropdown("MemberShipIndustrySubCategory", subCategory);
		CommonMethod.selectdropdown("MemberShipRevenueRange", revenue);
		String[] splits = CommonMethod.getText("MembershipFee").split(" ");
		String Amount = splits[1];
		data.setCellData(memberSheet, "TotalAmount", rowNum, Amount);
		CommonMethod.click("CommunityContinue");
		CommonMethod.assertcontainsmessage("VerifyTextOnPayment", "Confirmation", "Didn't Redirected to paymnet page");
		
		CommonMethod.click("MembershipOrganizationDetailsEdit");
		CommonMethod.sleep(1000);
		CommonMethod.selectdropdown("MemberShipTerm",editTerm );
		System.out.println("Term Changed from 2 years to 1 year");
		CommonMethod.click("CommunityContinue");
		CommonMethod.sleep(3000);
		CommonMethod.takeScreenshot("MembershipTermNotUpdating");
		CommonMethod.assertEqualsmessage("VerifyMembershipPaymentTerm",editTerm, "Does not matching the Term");
	    
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
		CommonMethod.takeScreenshot("MembershipRegistrationFlow");
		String membershipAmount = Amount + ".00";
		String membershipLevel   = data.getCellData(memberSheet, "MembershipLevel", rowNum);
		CommonMethod.assertEqualsmessage("VerifyMembershipReceiptAmount", membershipAmount, "Amount is not correct");
		CommonMethod.assertEqualsmessage("VerifyMembershipReceiptLevel",membershipLevel.toLowerCase() , "Membership Level is not correct");
		
		
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
		}
	}

}
