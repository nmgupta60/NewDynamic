package com.arc.testScripts.ProjectRegister.MyCities;

import org.testng.annotations.Test;
import com.arc.pageLibrary.landingPage.*;
import com.arc.pageLibrary.paymentPage.CityCommunity.PaymetCheckPage;
import com.arc.pageLibrary.registrationPage.MyCities.IndProjectRegisterPage;
import com.arc.testBase.TestBase;

public class IndProjRegCheck {
	public class IndProjectCheck extends TestBase{
		@Test
		public void projectRegisterCC() throws Exception{
		LoginToArc login= new LoginToArc();
		IndProjectRegisterPage pr=new IndProjectRegisterPage();
		PaymetCheckPage paycc=new PaymetCheckPage();
		login.loginToApplication();
		pr.indprojectRegistration();
		paycc.PayemtCheck();
		
		
		}
		


	}
	}
