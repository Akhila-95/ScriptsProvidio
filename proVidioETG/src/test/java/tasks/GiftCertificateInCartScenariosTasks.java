package tasks;

import CreditCardPyament.CreditCardDetails;
import baseClass.baseClass;
import data.AddressSelection;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.LogoutPage;
import pageObjects.ShippingAddressPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.OrderDetailsPageValidation;
import validations.PaymentPageValidation;
import validations.ShippingAddressPageValidation;

public class GiftCertificateInCartScenariosTasks extends baseClass{
	
	private static homepage homePage = new homepage(driver);
	private static final loginPage lp = new loginPage(driver);
	private static final  LogoutPage lop = new LogoutPage(driver);
	private static final ShippingAddressPage shippingPage = new ShippingAddressPage(driver);
	
	public static void loginCheck() throws InterruptedException, Exception {
 		Actionsss.CombinedClick(homePage.clickOnLogo());
 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
			logger.info("user logged in");
		}else if(Actionsss.displayElement(lp.clickSign())) {
			 Actionsss.click(lp.clickSign());
			 LoginPageTasks.verifyThatuserLogin();	 			    
		}
 	}
	public static void logoutCheck() throws InterruptedException, Exception {
 		Actionsss.CombinedClick(homePage.clickOnLogo());
 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
			logger.info("user logged in so logging out ");
			LogOutTasks.verifyLogout();
		}else {
			logger.info("user is not logged in");
		}
 	}
	
	
	public static void OnlyGcInCartWithCreditCardInRegisterUser() throws Exception {	
		test.info("Verifying the place order of only gift certificate in cart using credit card payment in register user");
		loginCheck();
		GiftCertificatePageTasks.giftCertificateForm();			
		try {
			CheckOutPageTasks.CheckOutPageLoadedRegisterUser();
			AddressSelection.Address();								
			CreditCardDetails.creditCardDetails();
			ReviewOrderPageTask.placeOrder();			
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();			
			Actionsss.CombinedClick(homePage.clickOnLogo());
			test.pass("Successfully order is placed when only gift certificate in cart using credit card payment in register user");
		}
		catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}


	public static void OnlyGcInCartWithPaypalInRegisterUser() throws Exception {
		test.info("Verifying the place order of only gift certificate in cart using paypal payment in register user");
		loginCheck();
		try {
			GiftCertificatePageTasks.giftCertificateForm();	
			AddressSelection.Address();
			Thread.sleep(2000);			
			CheckOutPageTasks.CheckOutPageLoadedRegisterUser();
			PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithPaypalFromCheckoutPage(); 			
			Actionsss.CombinedClick(homePage.clickOnLogo());
			test.pass("Succesfully order is placed when only gift certificate in cart using paypal payment in register user");
		}catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}
	

	public static void gcInCartNoGcSectionVisibleInRegisterUser() throws Exception {
		test.info("Verifying no gift certificate section is visible when gift certificate in cart");
		loginCheck();
		GiftCertificatePageTasks.giftCertificateForm();	
		CheckOutPageTasks.CheckOutPageLoadedRegisterUser();
		AddressSelection.Address();
		Thread.sleep(2000);	
		PaymentPageValidation.gcInCartNoGcSectionVisibleValidation();		
		Actionsss.CombinedClick(homePage.clickOnLogo());	
	}
	
	
	public static void placeOrderOfcombinationOfGcAndSimpleProductWithPaypalInRegisterUser() throws Exception {
		test.info("Verifying the place order of gift certificate and simple product in cart using paypal payment in register user");
		loginCheck();
		try {
			GiftCertificatePageTasks.giftCertificateForm();	
			CheckOutPageTasks.CheckOutPageLoadedRegisterUser();
			AddressSelection.Address();
		/*	Thread.sleep(2000);
			Actionsss.CombinedClick(shippingPage.getSelectNextPaymentBtn());
			Thread.sleep(2000);
			ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
			Thread.sleep(2000);*/
			PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithPaypalFromCheckoutPage(); 			
			Actionsss.CombinedClick(homePage.clickOnLogo());
			test.pass("Succesfully verified the place order of gift certificate and simple product in cart using paypal payment in register user");
		}catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}
	
	public static void placeOrderOfcombinationOfGcAndSimpleProductWithCreditCardInRegisterUser() throws Exception {
		test.info("Verifying the place order of gift certificate and simple product in cart using credit card payment in register user");
		loginCheck();
		try {
			GiftCertificatePageTasks.giftCertificateForm();	
			CheckOutPageTasks.CheckOutPageLoadedRegisterUser();			
			AddressSelection.Address();
		/*	Thread.sleep(2000);
			Actionsss.CombinedClick(shippingPage.getSelectNextPaymentBtn());
			Thread.sleep(2000);
			ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
			Thread.sleep(2000);*/
			CreditCardDetails.creditCardDetails();
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.CombinedClick(homePage.clickOnLogo());			
			test.pass("Succesfully verified the place order of gift certificate and simple product in cart using credit card payment in register user");
		}catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}
	
	
	public static void OnlyGcInCartWithCreditCardInGuestUser() throws Exception {	
		test.info("Verifying the place order of only gift certificate in cart using credit card payment in guest user");
		logoutCheck();
		GiftCertificatePageTasks.giftCertificateForm();	
		
		try {
			CheckOutPageTasks.GuestMailCheckOut();
			AddressSelection.Address();
			Thread.sleep(2000);			
			CreditCardDetails.creditCardDetails();
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();	
			Actionsss.CombinedClick(homePage.clickOnLogo());
			test.pass("Succesfully verified the place order of only gift certificate in cart using credit card payment in guest user");	
		}
		catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
		}
	
	
	public static void OnlyGcInCartWithPaypalInGuestUser() throws Exception {
		test.info("Verifying the place order of only gift certificate in cart using paypal payment in guest user");		
		logoutCheck();
		try {
			GiftCertificatePageTasks.giftCertificateForm();	
			CheckOutPageTasks.GuestMailCheckOut();
			AddressSelection.Address();
			Thread.sleep(2000);			
			PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithPaypalFromCheckoutPage(); 			
			Actionsss.CombinedClick(homePage.clickOnLogo());
			test.pass("Succesfully verified the place order of only gift certificate in cart using paypal payment in guest user");	
		}catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}
	
	public static void gcInCartNoGcSectionVisibleInGuestUser() throws Exception {
		test.info("Verifying no gift certificate section is visible when gift certificate in cart");
		logoutCheck();
		GiftCertificatePageTasks.giftCertificateForm();	
		CheckOutPageTasks.GuestMailCheckOut();
		AddressSelection.Address();		
		PaymentPageValidation.gcInCartNoGcSectionVisibleValidation();
		Actionsss.CombinedClick(homePage.clickOnLogo());
	}
	
	public static void placeOrderOfcombinationOfGcAndSimpleProductWithPaypalInGuestUser() throws Exception {
		test.info("Verifying the place order of gift certificate and simple product in cart using paypal payment in guest user");
		try {
			logoutCheck();
			GiftCertificatePageTasks.giftCertificateForm();	
			CheckOutPageTasks.GuestMailCheckOut();
			AddressSelection.Address();
	/*		Thread.sleep(2000);
			Actionsss.CombinedClick(shippingPage.getSelectNextPaymentBtn());
			Thread.sleep(2000);
			ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
			Thread.sleep(2000);*/
			PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithPaypalFromCheckoutPage(); 
			Actionsss.CombinedClick(homePage.clickOnLogo());
			test.pass("Succesfully verified the place order of gift certificate and simple product in cart using paypal payment in guest user");
		}catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}
	
	
	public static void placeOrderOfcombinationOfGcAndSimpleProductWithCreditCardInGuestUser() throws Exception {
		test.info("Verifying the place order of gift certificate and simple product in cart using credit card payment in guest user");
		try {
			logoutCheck();
			ProductListingPageTasks.simpleProductsGloves();
			allAttributesSelection.selectTheAttributesInPdp();
			GiftCertificatePageTasks.giftCertificateForm();	
			CheckOutPageTasks.GuestMailCheckOut();
			AddressSelection.Address();
		/*	Thread.sleep(2000);
			Actionsss.CombinedClick(shippingPage.getSelectNextPaymentBtn());
			Thread.sleep(2000);
			ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
			Thread.sleep(2000);*/
			CreditCardDetails.creditCardDetails();
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();	
			Actionsss.CombinedClick(homePage.clickOnLogo());
			test.pass("Succesfully verified the place order of gift certificate and simple product in cart using credit card payment in guest user");
		}catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}
	
	public static void removeGiftCertificateFromCart() throws InterruptedException, Exception {
		test.info("Verifying the removal of gift certificate from cart ");
		try {
			logoutCheck();
			//ProductListingPageTasks.simpleProductsGloves();
			//allAttributesSelection.selectTheAttributesInPdp();
			GiftCertificatePageTasks.giftCertificateForm();
			ViewCartPageTasks.removeGiftCertificateFromCart();		
		}catch(Exception e) {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}
}
