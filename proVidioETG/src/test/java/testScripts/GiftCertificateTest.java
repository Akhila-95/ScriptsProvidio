package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.GiftCertificatePageTasks;

public class GiftCertificateTest  extends baseClass{

	@Test//s(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void  VerifyErrorMsgsInGiftCard() throws Exception {
		
		 GiftCertificatePageTasks.getAllErrorMsgsInGiftCard();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void VerifytheErrorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		
		GiftCertificatePageTasks.gettheErrorsFromName_Recipients_confirmRecipientEMail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void VerifyTheErrorsRecipientEmailAndConfirmEmail() throws Exception {
		
		GiftCertificatePageTasks.getErrorsRecipientEmailAndConfirmEmail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void VerifyErrorsForConfirmMail() throws Exception {
		
		GiftCertificatePageTasks.getErrorOfConfirmMail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void VerifyGiftCardToCart() throws Exception {
	
		GiftCertificatePageTasks.giftCertificateForm();
	}
}
