 package tasks;


import PaypalPayment.CartPagePayal;
import PaypalPayment.MiniCartPaypal;
import PaypalPayment.PdpPagePaypalBuyNow;
import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import pageObjects.homepage;
import validations.OrderDetailsPageValidation;


public class PlaceOrderWithDifferentPaymentsInGuestuser  extends baseClass{
	

	private static homepage homePage = new homepage(driver);
	private static final  LogoutPage lop = new LogoutPage(driver);
	private static MyAccountPage MAC= new MyAccountPage(driver);
	
	public static void logoutCheck() throws InterruptedException, Exception {
 		Actionsss.CombinedClick(homePage.clickOnLogo());
 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
			logger.info("user logged in so logging out ");
			LogOutTasks.verifyLogout();
		}else if(Actionsss.elementSize(MAC.getcontinueShoppingButtonList()) && !Actionsss.elementSize(homePage.clickOnLogoList()) ) {
			test.info("Error page is displayed, so clicking on continue shopping");			
			Actionsss.CombinedClick(MAC.getcontinueShoppingButton());
			Thread.sleep(4000);				
		}else {
			logger.info("user is not logged in");
		}
 	}
	
	public static void orderPlacingWithCreditCard() throws Exception {
		test.info("Verifying the place order in guest user with credit card payment ");
		logoutCheck();
		PaymentPageTasks.creditCardwithValidDetailsforOrderPlacing();
		ReviewOrderPageTask.placeOrder();
		OrderDetailsPageValidation.validatePlacetheOrderPage();
		OrderDetailsPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithGiftCard() throws Exception {
		test.info("Verifying the place order in guest user with gift card ");
		logoutCheck();
		PaymentPageTasks.gcRedemption();
		ReviewOrderPageTask.placeOrder();
		OrderDetailsPageValidation.paymentInOrderConfirmationPage();
		OrderDetailsPageValidation.validatePlacetheOrderPage();
		OrderDetailsPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithCombinationOfGcAndCreditCard() throws Exception {	
		test.info("Verifying the place order in guest user with the combination of Gift card and credit card payment ");
		logoutCheck();
		PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();		
		ReviewOrderPageTask.placeOrder();
		OrderDetailsPageValidation.paymentInOrderConfirmationPage();
		OrderDetailsPageValidation.validatePlacetheOrderPage();
		OrderDetailsPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	}
	
	public static void orderPlacingWithPaypalFromCheckoutPage() throws Exception {
		test.info("Verifying the place order in guest user with paypal in checkout page");
		logoutCheck();
		PaymentPageTasks.paypal();
		}
	
	public static void orderPlacingWithCombinationOfGcAndPaypal() throws Exception {
		test.info("Verifying the place order in guest user with combination of gift card and paypal ");
		logoutCheck();
		PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
	
	}
	
	public static void orderPlacingWithMiniCartPaypal() throws InterruptedException, Exception {	
		test.info("Verifying the place order in guest user with mincart paypal ");
		logoutCheck();
		MiniCartPaypal.miniCartPaypal();
				
	}
	
	public static void orderPlacingWithCartPagePaypal() throws InterruptedException, Exception {
		test.info("Verifying the place order in guest user with paypal in cart page");
		logoutCheck();
		Thread.sleep(1000);
		CartPagePayal.cartPagePaypal();
	
	}
	
	public static void orderPlacingWithPaypalInPdpPage() throws InterruptedException, Exception {
		test.info("Verifying the place order in guest user with paypal in PDP page ");
		logoutCheck();		
		PdpPagePaypalBuyNow.pdpPagePaypal();
			
	}
}
