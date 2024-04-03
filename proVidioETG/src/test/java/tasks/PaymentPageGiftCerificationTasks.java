package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import validations.MyAccountValidations;
import validations.PaymentPageValidation;

public class PaymentPageGiftCerificationTasks extends baseClass{
	
	private static final PaymentPage paymentPage = new PaymentPage(driver);
	private static TestData TD = new TestData();
	
	public static void emptyGiftCardApply() throws InterruptedException, Exception {
		PaymentPageTasks.paymentPageView();
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.CombinedClick(paymentPage.getApplyGiftCardButton());			
			 PaymentPageValidation.enterGiftCodeErrorMsgValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }
	}
	
	public static void InvalidGcCode() throws Exception {
		PaymentPageTasks.paymentPageView();
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),TD.Invalid_Gift_Cerificate_MAP_IP_Data, TD.Gift_Card_PP_IP_FieldName);					         
             Actionsss.CombinedClick(paymentPage.getApplyGiftCardButton());
             Thread.sleep(1000);
             PaymentPageValidation.invalidGiftCodeErrorMsgValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }		
	}
	
	public static void insufficientGcCode() throws Exception {
		PaymentPageTasks.paymentPageView();
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"GLOIWCSCSCTVGYIF", TD.Gift_Card_PP_IP_FieldName);					         
             Actionsss.CombinedClick(paymentPage.getApplyGiftCardButton());
             Thread.sleep(1000);
             PaymentPageValidation.insufficientGiftCodeErrorMsgValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }		
	}
	
	public static void gcBelongsToDifferentCustomer() throws Exception {
		PaymentPageTasks.paymentPageView();
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),TD.Different_Customer_Gift_Cerificate_IP_Data, TD.Gift_Card_PP_IP_FieldName);					         
            Actionsss.CombinedClick(paymentPage.getApplyGiftCardButton());
            Thread.sleep(1000);
            PaymentPageValidation.gcBelongsToDifferentCutomerErrorValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }	
	}
	
	public static void removeAppliedGc() throws Exception {
		PaymentPageTasks.paymentPageView();
		Actionsss.scrollWindowsByPixel(300);
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),"CHVCLPRPVYSJICGW", "CHVCLPRPVYSJICGW gift code");					         
             Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
             Thread.sleep(1000);
             for(int i=1;i<=paymentPage.getRemoveGcList().size();i++) {
	             Actionsss.CombinedClick(paymentPage.getRemoveGc());
	             Thread.sleep(1000);            
             }
             PaymentPageValidation.gcRemoveValidation();
		 }else 	if(Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
			 
		 } else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }
	}
	
	public static void applyValidGc() throws Exception {
		LoginPageTasks.verifyThatuserLogin();
		 PaymentPageTasks.paymentPageView();	
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 if(Actionsss.elementSize(paymentPage.getCustomerInfoFromCop3List())) {
				 logger.info("guest user");
				 Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),TD.Valid_Gift_Cerificate_MAP_IP_DataForGuestUser, TD.Gift_Card_PP_IP_FieldName);	
			 }else {
				logger.info("reg");
				Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),TD.Valid_Gift_Cerificate_MAP_IP_DataForRegUser, TD.Gift_Card_PP_IP_FieldName);	
			 }
             Actionsss.CombinedClick(paymentPage.getApplyGiftCardButton());
             Thread.sleep(3000);
             PaymentPageValidation.succesMsgForValidGcAppliedValidation();
		 }else {
		    	test.info("Gift certificate is in cart");
		    	test.pass("No Gift certificate div");
		    }		
	}
	
	
	public static void emptycheckBalance() throws Exception {
		PaymentPageTasks.paymentPageView();
		if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
		Actionsss.clearText(paymentPage.getGiftcertificateInput());	
		Actionsss.CombinedClick(paymentPage.getCheckBalanceButton());
		MyAccountValidations.verifyemptyInput(); 
		}else {
	    	test.info("Gift certificate is in cart");
	    	test.pass("No Gift certificate div");
	    }
	}
	
	public static void invalidcheckBalance() throws Exception {
		PaymentPageTasks.paymentPageView();
		if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
		Actionsss.sendKeys(paymentPage.getGiftcertificateInput(), TD.Invalid_Gift_Cerificate_MAP_IP_Data,TD.Gift_Card_PP_IP_FieldName);
		Actionsss.CombinedClick(paymentPage.getCheckBalanceButton());
		Thread.sleep(2000);
		MyAccountValidations.verifyInvalidInput(); 
		}else {
	    	test.info("Gift certificate is in cart");
	    	test.pass("No Gift certificate div");
	    }
	}
	public static void insufficientcheckBalance() throws Exception{
		PaymentPageTasks.paymentPageView();
		if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
		Actionsss.sendKeys(paymentPage.getGiftcertificateInput(), TD.Insuffient_Gift_Cerificate_MAP_IP_Data,TD.Gift_Card_PP_IP_FieldName);
		Actionsss.CombinedClick(paymentPage.getCheckBalanceButton());
		Thread.sleep(2000);
		MyAccountValidations.emptybalancechecck(); 
		}else {
	    	test.info("Gift certificate is in cart");
	    	test.pass("No Gift certificate div");
	    }
	}
	
	public static void validcheckBalance() throws Exception{
		PaymentPageTasks.paymentPageView();
		if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
		Actionsss.sendKeys(paymentPage.getGiftcertificateInput(), TD.Valid_Gift_Cerificate_MAP_IP_DataForGuestUser,TD.Gift_Card_PP_IP_FieldName);
		Actionsss.CombinedClick(paymentPage.getCheckBalanceButton());
		Thread.sleep(2000);
		MyAccountValidations.balancechecck(); 
		}else {
	    	test.info("Gift certificate is in cart");
	    	test.pass("No Gift certificate div");
	    }
	}
	public static void gcRemoved() throws Exception {
		PaymentPageTasks.paymentPageView();
		Actionsss.scrollWindowsByPixel(300);
		if(Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
			logger.info("Gc is applied");
			 Actionsss.javascriptClick(paymentPage.getRemoveGc());
             Thread.sleep(1000);
             PaymentPageValidation.gcRemoveValidation();
		 } else {
		    	logger.info("Gc is not applied");;
		    }
	}
}
