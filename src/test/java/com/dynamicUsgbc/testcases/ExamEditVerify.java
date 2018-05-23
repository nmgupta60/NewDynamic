package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class ExamEditVerify extends BaseClass {
	
	@Test
	@Parameters({"rowNum" ,"PaymentSheet","SignInSheet","ExamRegistrationSheet"})
	public void ExamRegistrationFlow(int rowNum,String PaymentSheet,String SignInSheet,String ExamRegistrationSheet) throws Exception {
		
		String examType = data.getCellData(ExamRegistrationSheet, "ExamType", rowNum);
		String language = data.getCellData(ExamRegistrationSheet, "Language", rowNum);
		
		String email = data.getCellData(SignInSheet, "Email",rowNum);
		String password = data.getCellData(SignInSheet, "Password", rowNum);
		
    	String country   = data.getCellData(ExamRegistrationSheet, "Country", rowNum);
		String street1	 = data.getCellData(ExamRegistrationSheet, "Street1", rowNum);
		String street2 	 = data.getCellData(ExamRegistrationSheet, "Street2", rowNum);
		String city		 = data.getCellData(ExamRegistrationSheet, "City", rowNum);
		String state 	 = data.getCellData(ExamRegistrationSheet, "State", rowNum);
		String zip       = data.getCellData(ExamRegistrationSheet, "Zip", rowNum);
		String dob       = data.getCellData(ExamRegistrationSheet, "DOB", rowNum);
		String jobTitle  = data.getCellData(ExamRegistrationSheet, "JobTitle", rowNum);
		String Organization  = data.getCellData(ExamRegistrationSheet, "Organization", rowNum);
		
		String NameOnCard = data.getCellData(PaymentSheet, "Name", rowNum);
		String CardNumber = data.getCellData(PaymentSheet, "CardNumber", rowNum);
		String ExpirationMonth = data.getCellData(PaymentSheet, "ExpMonth", rowNum);
		String ExpirationYear = data.getCellData(PaymentSheet, "ExpYear", rowNum);
		String SecurityCode = data.getCellData(PaymentSheet, "SecurityCode", rowNum);
		String BillCountry = data.getCellData(PaymentSheet, "Country", rowNum);
		String BillStreetAdd1 = data.getCellData(PaymentSheet, "Street1", rowNum);
		String BillStreetAdd2 = data.getCellData(PaymentSheet, "Street2", rowNum);
		String BillCity = data.getCellData(PaymentSheet, "City", rowNum);
		String BillState = data.getCellData(PaymentSheet, "State", rowNum);
		String BillZipCode = data.getCellData(PaymentSheet, "Zip", rowNum);
		
		String newExamType = data.getCellData(ExamRegistrationSheet, "newExamType", rowNum);
				
		try {
			
			CommonMethod.setUrl(ExamRegistrationUrl);
			
			CommonMethod.selectdropdown("SelExamType",examType);
			CommonMethod.selectdropdown("SelLanguage",language);
			CommonMethod.click("SpclAccomodation");
			
			CommonMethod.click("ArmyVeteran");
			String[] splits = CommonMethod.getText("ExamRegistrationAmt").split(" ");
			String Amount= splits[1];
			data.setCellData(ExamRegistrationSheet, "Amount" , rowNum, Amount );
			CommonMethod.click("CommunityContinue");
		
			CommonMethod.sendKeys("SignInEmailId", email);
			CommonMethod.sendKeys("SignInpassword", password);
			
			CommonMethod.click("CommunityContinue");
			CommonMethod.sleep(3000);
			CommonMethod.scrolldowntoLast();
			CommonMethod.click("CommunityContinue");
			
			CommonMethod.selectdropdown("communityCountry",country);
			CommonMethod.sendKeys("CommunityAdd1", street1);
			CommonMethod.sendKeys("CommunityAdd2",street2);
			CommonMethod.sendKeys("CommunityCity",city);
			CommonMethod.selectdropdown("CommunityState", state);
			CommonMethod.sendKeys("CommunityZip", zip);
			CommonMethod.sendKeys("candidateDob", dob);
			CommonMethod.click("candidateGender");
			CommonMethod.sendKeys("candidateJobTitle", jobTitle);
			CommonMethod.sendKeys("candidateOrganization", Organization);
			CommonMethod.click("candidatecheckPDL");
			CommonMethod.click("candidateAgreement");
			CommonMethod.click("CommunityContinue");
			CommonMethod.sleep(1000);
			
			CommonMethod.takeScreenshot("ExamPaymentpageUnwantedMessage");
			CommonMethod.click("ExamDetailsEdit");
			CommonMethod.sleep(3000);
			
			CommonMethod.selectdropdown("SelExamType",newExamType);
			System.out.println("Exam type Changed from Homes Exam to BD+C Exam");
			CommonMethod.click("SpclAccomodation");
			System.out.println("Accomodation option Enabled");
			CommonMethod.click("CommunityContinue");
			CommonMethod.sleep(2000);
			CommonMethod.click("candidateAgreement");
			CommonMethod.click("CommunityContinue");
			CommonMethod.sleep(1000);
			CommonMethod.assertEqualsmessage("VerifyExamName", newExamType, "Exam Type didn't matched");	
			CommonMethod.assertEqualsmessage("VerifyExamFee", Amount, "Amount not matched");
			
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
			
			CommonMethod.takeScreenshot("ExamRegistrationEditVerify");
			String membershipAmount = Amount + ".00";
			CommonMethod.assertEqualsmessage("ReceiptExamName", newExamType, "Exam Name is not correct");
			CommonMethod.assertEqualsmessage("ReceiptExamLanguage", language, "Exam Language is not correct");
			CommonMethod.assertEqualsmessage("ReceiptExamFee", membershipAmount, "Exam Fee is not correct");
			
		} catch (Exception e) {
			//CommonMethod.takeScreenshot("ExamRegistrationEditVerifyError");
			System.out.println(e.getLocalizedMessage());
		}
		
		
		
	}


}
