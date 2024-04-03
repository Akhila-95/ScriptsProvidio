package tasks;

import PaypalPayment.CartPagePayal;
import PaypalPayment.MiniCartPaypal;
import PaypalPayment.PdpPagePaypalBuyNow;
import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import pageObjects.OrderPageDetails;
import pageObjects.PaymentPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.OrderDetailsPageValidation;
import validations.PaymentPageValidation;

public class OrderPlacingWithDifferentPaymentsInRegisterUserTask extends baseClass {

		private static final loginPage lp = new loginPage(driver);
		private static final  LogoutPage lop = new LogoutPage(driver);
	 	private static homepage homePage = new homepage(driver);
	 	private static final PaymentPage paymentPage = new PaymentPage(driver);
	 	private static final OrderPageDetails orderPage = new OrderPageDetails(driver);
	 	private static MyAccountPage MAC= new MyAccountPage(driver);
	 	
	 	public static void loginCheck() throws InterruptedException, Exception {
	 		Actionsss.CombinedClick(homePage.clickOnLogo());
	 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
				logger.info("user logged in");
			}else if(Actionsss.displayElement(lp.clickSign())) {
				 Actionsss.click(lp.clickSign());
				 LoginPageTasks.verifyThatuserLogin();	 			    
			}else if(Actionsss.elementSize(MAC.getcontinueShoppingButtonList()) && !Actionsss.elementSize(homePage.clickOnLogoList()) ) {
				test.info("Error page is displayed, so clicking on continue shopping");			
				Actionsss.CombinedClick(MAC.getcontinueShoppingButton());
				Thread.sleep(4000);				
			}
	 	}
	 	
	 	public static void orderPlacingWithCreditCard() throws Exception {
 			test.info("Verifying the place order in registered user with credit card payment ");
 			loginCheck();
 			try {
		 			
 				PaymentPageTasks.creditCardInRegUser();	
		 		ReviewOrderPageTask.placeOrder();		 		
		 		OrderDetailsPageValidation.validatePlacetheOrderPage();
		 		OrderDetailsPageValidation.orderNumberAndOrderDate();
		 		Actionsss.CombinedClick(homePage.clickOnLogo());
 			}catch(Exception e) {
 				Actionsss.CombinedClick(homePage.clickOnLogo());
 				System.out.println(e);
 			}
	 	}
	 	
	 	public static void orderPlacingWithGiftCard() throws Exception {
	 		test.info("Verifying the place order in registered user with credit card payment ");
	 		loginCheck();
	 		try {
		 		PaymentPageTasks.gcRedemptionForRegisterUser();
		 		ReviewOrderPageTask.placeOrder();		 	
		 		OrderDetailsPageValidation.validatePlacetheOrderPage();
		 		OrderDetailsPageValidation.orderNumberAndOrderDate();
		 		Actionsss.CombinedClick(homePage.clickOnLogo());
	 		}catch(Exception e) {
 				Actionsss.CombinedClick(homePage.clickOnLogo());
 				System.out.println(e);
 			}
	 	}
	 	
	 	public static void orderPlacingWithCombinationOfGcAndCreditCard() throws Exception {
	 		test.info("Verifying the place order in registered user with combination of credit card ans gift certifcate code payment ");
	 		loginCheck();	 	
	 		try {
		 		PaymentPageTasks.gcRedemptionInCombinationWithCreditCardForRegisterUser();		
		 		ReviewOrderPageTask.placeOrder();
		 		OrderDetailsPageValidation.paymentInOrderConfirmationPage();
		 		OrderDetailsPageValidation.validatePlacetheOrderPage();
		 		OrderDetailsPageValidation.orderNumberAndOrderDate();
		 		Actionsss.CombinedClick(homePage.clickOnLogo());
	 		}catch(Exception e) {
 				Actionsss.CombinedClick(homePage.clickOnLogo());
 				System.out.println(e);
 			}
	 	}
	 	
	 	public static void orderPlacingWithPaypalFromCheckoutPage() throws Exception {
	 		test.info("Verifying the place order in registered user with paypal  payment in checkout");
	 		loginCheck();	 
	 		try {
	 			PaymentPageTasks.paypalForRegisterUser();
	 			
	 		}catch(Exception e) {
 				Actionsss.CombinedClick(homePage.clickOnLogo());
 				System.out.println(e);
 			}	 			
	 	}
	 	
	 	public static void orderPlacingWithCombinationOfGcAndPaypal() throws Exception {
	 		test.info("Verifying the place order in registered user with combination of paypal and gift certifcate code payment ");
	 		loginCheck();	
	 		try {
		 		PaymentPageTasks.gcRedemptionInCombinationWithPaypalForRegisterUser();
		 		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
		 			if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
		 			logger.info("Salesforce payment activated");			
		 			Thread.sleep(8000);				 			
		 			OrderDetailsPageValidation.validatePlacetheOrderPage();
		 			OrderDetailsPageValidation.orderNumberAndOrderDate();
		 			Actionsss.CombinedClick(homePage.clickOnLogo());
		 			}
		 		}
		 		else if(Actionsss.elementSize(paymentPage.getBrainPaypalAcc())) {	
		 			logger.info("Other paymnet activated");
		 			logger.info("Place order page is loaded");
		 			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
		 			Thread.sleep(8000);
		 			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		 			Thread.sleep(1000);					
		 			OrderDetailsPageValidation.validatePlacetheOrderPage();
		 			OrderDetailsPageValidation.orderNumberAndOrderDate();
		 			Actionsss.CombinedClick(homePage.clickOnLogo());
		 		}else {
		 			logger.info("cybersource or stripe or adyen payments are activated.");
		 			Actionsss.CombinedClick(homePage.clickOnLogo());
		 		}
	 		}
	 		catch(Exception e) {
 				Actionsss.CombinedClick(homePage.clickOnLogo());
 				System.out.println(e);
 			}
	 	}
	 	
	 	public static void orderPlacingWithMiniCartPaypal() throws InterruptedException, Exception {
	 		test.info("Verifying the place order in registered user with paypal payment in minicart ");
	 		loginCheck();
	 		Actionsss.javascriptClick(homePage.clickOnLogo());
			MiniCartPaypal.miniCartPaypal();
	 				
	 	}
	 	
	 	public static void orderPlacingWithCartPagePaypal() throws InterruptedException, Exception {
	 		test.info("Verifying the place order in registered user with paypal payment in cart page ");
	 		loginCheck();
	 		Actionsss.click(homePage.clickOnLogo());
			Actionsss.scrollUp();
			CartPagePayal.cartPagePaypal();
	 	
	 	}
	 	
	 	public static void orderPlacingWithPaypalInPdpPage() throws InterruptedException, Exception {
	 		test.info("Verifying the place order in registered user with paypal payment in PDP page ");
	 		loginCheck();
	 		Actionsss.click(homePage.clickOnLogo());
			PdpPagePaypalBuyNow.pdpPagePaypal();
	 	}
	 		
	 }

