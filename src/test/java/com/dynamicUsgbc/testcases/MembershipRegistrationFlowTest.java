package com.dynamicUsgbc.testcases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.dynamicUsgbc.ReusableMethods.ReusableMethodExamRegistration;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodMembership;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodPayment;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsCommunity;
import com.dynamicUsgbc.ReusableMethods.ReusableMethodsSignIn;
import com.dynamicUsgbc.driver.BaseClass;
import com.dynamicUsgbc.driver.CommonMethod;

public class MembershipRegistrationFlowTest extends BaseClass{

	
	@Test
	@Parameters({"rowNum" ,"memberSheet","PaymentSheet","SignInSheet","ExamRegistrationSheet"})
	public void MembershipRegistration(int rowNum, String memberSheet, String paymentSheet, String signinSheet, String examRegistrationSheet) throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		CommonMethod.ExtentReportConfig();
		CommonMethod.test = CommonMethod.extent.startTest("Membership Registration Flow", "Verifies Membership Registration Functionality").assignCategory("MembershipRegistration");
		CommonMethod.setUrl(MembershipUrl);
		
		ReusableMethodMembership reuse = new ReusableMethodMembership();
		ReusableMethodExamRegistration reuseExam = new ReusableMethodExamRegistration();
		ReusableMethodsSignIn reuseSign = new ReusableMethodsSignIn();
		try {
			
			reuse.clickSignInMembershipPage();
			reuseSign.SignIn(rowNum, signinSheet);
			reuse.membershipContact(memberSheet, rowNum);
			reuse.membershipDetails(memberSheet, rowNum);
		
			CommonMethod.sleep(2000);
			CommonMethod.newWindow();
		//	CommonMethod.windowShifting();
			CommonMethod.setUrl(ExamRegistrationUrl);
			reuseExam.ExamRegistration(rowNum, examRegistrationSheet);
			reuseExam.CandidateInformation(rowNum, examRegistrationSheet);
			CommonMethod.otherWindow();
			reuse.clickBackPage();
			reuse.VerifyContactDetails(rowNum, memberSheet);

			
			
            } 
		
		catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			CommonMethod.testlogError( "<pre>" + e1.toString() + "</pre>");
			CommonMethod.takeScreenshot("MembershipRegistrationFlow");
			throw e1;
		}
	}

	
}
