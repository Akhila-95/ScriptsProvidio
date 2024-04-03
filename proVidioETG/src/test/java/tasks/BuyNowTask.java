package tasks;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebElement;

import PaypalPayment.PaypalMethod;
import baseClass.baseClass;
import data.AddressSelection;
import data.TestData;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.CheckOutPage;
import pageObjects.LogoutPage;
import pageObjects.MyAccountPage;
import pageObjects.ProductDetailPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.CheckOutPageValidation;
import validations.OrderDetailsPageValidation;

public class BuyNowTask extends baseClass {

	private static final ProductDetailPage pdp = new  ProductDetailPage(driver);	
	private static homepage homePage = new homepage(driver);
	private static final String Email = "GuestEmail";	
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final  LogoutPage lop = new LogoutPage(driver);
	private static MyAccountPage MAC= new MyAccountPage(driver);
	private static final loginPage lp = new loginPage(driver);
	
	public static void loginCheck() throws InterruptedException, Exception {
 		Actionsss.CombinedClick(homePage.clickOnLogo());
 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
			logger.info("user logged in");
			LogOutTasks.verifyLogout();
		}else {
			logger.info("No user is logged");
			 Actionsss.CombinedClick(lp.clickSign());
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
	
	public static void enableOfBuyNowButton() throws InterruptedException, Exception {
		
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.allAttributes();
		 test.info("Verifying the enable of buy now");
		 if(Actionsss.enabledElement(pdp.getBuyNowButton())) {
			 test.pass("Buy now button is enabled after selecting the attributes");
			 logger.info("Buy now button is enabled after selecting the attributes");
			 
		 }else {
			 test.fail("Buy now button is not enabled after selecting the attributes");
			 logger.info("Buy now button is not enabled after selecting the attributes");
		 }
	}
	
	public static void displayOfCreditCardAsDefault() throws InterruptedException, Exception {
		 loginCheck();
		if(Actionsss.elementSize(MAC.getSavedBrainTreeCardList()) || Actionsss.elementSize(MAC.getSavedStripeCardList())) {
			 logger.info("Have saved cards");
			 Thread.sleep(3000);		
			 ProductListingPageTasks.gpsProducts();
			 allAttributesSelection.selectTheAttributesInPdpForBuyNow();		
			 Thread.sleep(3000);
			 test.info("Verifying the display of same credit card in buy pop up and in order confirmation page");
			 creditCardInBuyNowPopUp();
		     placeOrderInBuyNow();
		        
		 }else {
			 logger.info("Don't have saved cards");
			 test.info("Don't have saved cards so adding new card");
			 if(Actionsss.elementSize(MAC.getaddNewCardList()) ) {
				 logger.info("Brain tree activated");
				 Actionsss.CombinedClick(MAC.getaddNewCard());
				 MyAccountPageCreditCardTasks.validCreditCardDetails();
			 }else if(Actionsss.elementSize(MAC.getstripelist())) {
				logger.info("Stripe activated"); 
				Actionsss.CombinedClick(MAC.getstripe());
				Thread.sleep(2000);
				MyAccountPageCreditCardTasks.validDetails();
			 }
		 } 
	}
	
	public static void cancelThePurchaseInBuyNowPopUp() throws InterruptedException, Exception {
		 loginCheck();
		if(Actionsss.elementSize(MAC.getSavedBrainTreeCardList()) && Actionsss.elementSize(MAC.getSavedStripeCardList())) {
			 logger.info("Have saved cards");
			 Thread.sleep(3000);		
			 ProductListingPageTasks.gpsProducts();
			 allAttributesSelection.selectTheAttributesInPdpForBuyNow();		
			 Thread.sleep(3000);
			 test.info("Verifying the close of buy now pop up");
			 if(Actionsss.validateClick(pdp.getCloseButtonInBuyNowPopUp())) {
				 test.pass("Buy now pop is closed");
				 logger.info("Buy now pop up is closed");
			 }else {
				 test.fail("Buy now pop is not closed");
				 logger.info("Buy now pop up is not closed");
			 }
		        
		 }else {
			 logger.info("Don't have saved cards");
		 } 
	}
	
	public static void outOfStockProductInBuyNowPopUp() throws InterruptedException, Exception {
		
		 Actionsss.onlySendKeys(homePage.getSearchElement(),TestData.outOfStockProductInBuyNow);
		 Thread.sleep(4000);
		 int size= homepage.getClickOnSearchedProduct1List().size();
		 for(int i =0; i<=size;i++) {
			 for(WebElement each: homepage.getClickOnSearchedProduct1List()) {
				 if(Actionsss.displayElement(each)) {
					 Actionsss.CombinedClick(each);
				 }
				 break;
			 }
		 }
		 
		 Thread.sleep(4000);
		 allAttributesSelection.allAttributes();
		 test.info("Verifying the disable of buy now button if the product is out of stock");
		 if(!Actionsss.enabledElement(pdp.getBuyNowButton())) {
			 test.pass("Buy now button is disabled as the product is out of stock ");
			 logger.info("Buy now button is disabled as the product is out of stock ");
			 
		 }else {
			 test.fail("Buy now button is not disabled though the product is out of stock ");
			 logger.info("Buy now button is not disabled though the product is out of stock ");
		 }
	}

	public static void validatingTheTotalPriceInBuyNowPopUp() throws InterruptedException, Exception {
		 loginCheck();
		if(Actionsss.elementSize(MAC.getSavedBrainTreeCardList()) && Actionsss.elementSize(MAC.getSavedStripeCardList())) {
			 logger.info("Have saved cards");
			 Thread.sleep(3000);		
			 ProductListingPageTasks.gpsProducts();
			 allAttributesSelection.selectTheAttributesInPdpForBuyNow();		
		/*	 Thread.sleep(3000);
			 String priceInPdp=Actionsss.getTextOfElement(pdp.getPriceOfProductInPdp());
			 logger.info(priceInPdp);
			 String textWithoutDollar1 = priceInPdp.replace("$", "");
			 double price1= Double.parseDouble(textWithoutDollar1);
			 logger.info(price1);
			 Actionsss.click(pdp.getBrainTreePlaceOrderBuyNow());
			 Thread.sleep(3000);
			
			 String textWithoutDollar2 = priceInBuyNowPopUp.replace("$", "");
			 double price2= Double.parseDouble(textWithoutDollar2);
		     logger.info(price2);*/
			 String priceInBuyNowPopUp= Actionsss.getTextOfElement(pdp.getPriceOfProductInBuyNowPopUp());
		     test.info("Validating the total price in buy now pop up ");
		     if(Actionsss.displayElement(pdp.getPriceOfProductInBuyNowPopUp())) {
		    	 test.pass("Total price is displayed in buy now pop up and the total price is " +priceInBuyNowPopUp);
		    	 logger.info("Total price is displayed in buy now pop up and the total price is " +priceInBuyNowPopUp);
		     }else {
		    	 test.fail("Total price is not displayed in buy now pop up and the total price is " +priceInBuyNowPopUp);
		    	 logger.info("Total price is not displayed in buy now pop up and the total price is " +priceInBuyNowPopUp);
		     }
		      
		 }else {
			 logger.info("Don't have saved cards");
		 } 
	}
		
	
	public static void creditCardInBuyNowPopUp() {
		String paymentInBuyNowPopUp= Actionsss.getTextOfElement(pdp.getDefaultCreditCardInBuyNowPopUp());
		
		 // Define a regex pattern for matching credit card numbers
	        Pattern pattern = Pattern.compile("\\*{11}(\\d{4})");

	        // Create a Matcher object
	        Matcher matcher = pattern.matcher(paymentInBuyNowPopUp);

	        // Check if the pattern is found
	        if (matcher.find()) {
	            // Extract the credit card number
	           TestData.creditCardInBuyNowPopUp = matcher.group(0);
	           TestData.creditCardInBuyNowPopUp=TestData.creditCardInBuyNowPopUp.substring(TestData.creditCardInBuyNowPopUp .length() - 4);
				logger.info("Gc last 4 digits "+TestData.creditCardInBuyNowPopUp);
	           logger.info(TestData.creditCardInBuyNowPopUp );
	        }
	        
		if(TestData.defaultCreditCardInMyAccount== paymentInBuyNowPopUp  || TestData.defaultPaypalInMyAccount == paymentInBuyNowPopUp ) {
			
		}
	}
	
	public static void validatingPaymentsInBuyNowPopUp() throws Exception {
		 loginCheck();
		 if(Actionsss.elementSize(MAC.getSavedBrainTreeCardList()) && Actionsss.elementSize(MAC.getSavedStripeCardList())) {
			 logger.info("Have saved cards");
			 TestData.defaultCreditCardInMyAccount=Actionsss.getTextOfElement(MAC.getDefaultCreditCard());
			 logger.info(TestData.defaultCreditCardInMyAccount);
		 }else {
			logger.info("have to add the card");
			TestData.defaultPaypalInMyAccount= Actionsss.getTextOfElement(MAC.getDefaultPayPal());
			logger.info(TestData.defaultPaypalInMyAccount);
		 }
		 if(Actionsss.elementSize(MAC.getPaypalInMyAccountList())) {
			test.info("Brain tree payment is activated and has paypal in my account");
			if(Actionsss.elementSize(MAC.getPaypalAccountsInMyAccountList())) {
				test.info("Have saved paypal account");
			}else {
				logger.info("Earlier No paypal account is added in my account ");
				Actionsss.CombinedClick(MAC.getAddNewPaypalAccountInMyAccount());
				Thread.sleep(7000);
				Actionsss.CombinedClick(MAC.getBrainTreePaypalInMyAccount());
				Thread.sleep(4000);
				PaypalMethod.paypalPopupWithRahulNayakAccount();
			}
		}
		 
		 Thread.sleep(3000);		
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.selectTheAttributesInPdpForBuyNow();			
		 test.info("Verifying the close of buy now pop up");
		 Actionsss.click(pdp.getCloseButtonInBuyNowPopUp()) ;
		 MyAccountPagePaypalTasks.paypalInMyAccount();
		 if(Actionsss.elementSize(MAC.getremove())) {
			 Actionsss.CombinedClick(MAC.getremoveCard());
		 }else {
			 logger.info("User don't have save credit card");
		 }
		 
		 if(Actionsss.elementSize(MAC.getErrorWhileCardRemoveList())) {
				 if(Actionsss.displayElement(MAC.getErrorWhileCardRemove())) {
					 test.fail("known error in my account while removing card it is  Sorry, but you can not delete this payment method, since there are created transactions which are waiting for capturing. When all the transactions will be captured, then you will be able to remove this payment method");
					 Actionsss.CombinedClick(MAC.getCloseTheCardRemoveError());
				 }
			 }else {
	
			 }
		 
		 
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.selectTheAttributesInPdpForBuyNow();
		 String paymentInBuyNowPopUp= Actionsss.getTextOfElement(pdp.getDefaultCreditCardInBuyNowPopUp());
		 if(!(paymentInBuyNowPopUp== "NULL")) {
			 Actionsss.click(pdp.getBrainTreePlaceOrderBuyNow());
				test.info("Verifying order placing through buy now button");	
				OrderDetailsPageValidation.creditCardInfoInBuyNowAndOrderConfirmationPage();
				OrderDetailPageTasks.getOrderConfirmationPage();
		 }
	}
	
	public static void pdpPagebuyNowButtonGuestUser() throws Exception {		
		 logoutCheck();
		 Thread.sleep(3000);		
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.selectTheAttributesInPdpForBuyNow();		
		 Thread.sleep(3000);
		 try{
		 if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {	
				test.info("User logged in as guest and clicked on buy now button");
				Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());		
				Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, Email);		
				Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
				CheckOutPageValidation.VerifiedThatGuestLogin();
				AddressSelection.Address();	
				PaymentPageTasks.creditCardWithValidDetails();
				ReviewOrderPageTask.placeOrder();
				OrderDetailPageTasks.getOrderConfirmationPage();
				Actionsss.javascriptClick(homePage.clickOnLogo());
			}
		}catch(Exception e) {
			Actionsss.javascriptClick(homePage.clickOnLogo());
			System.out.println(e);
		}
	}
	
	public static void pdpPageBuyNowPopUpRegisteredUser() throws Exception {
		 loginCheck();
		 Thread.sleep(3000);
		 test.info("Verifying order place with buy now in registered user by creating new  account and adding address and payment");
		// CreateAccountPageTasks.enterValidDetails();
		 if(Actionsss.countofElements(MAC.getBrainTree()) || Actionsss.countofElements(MAC.getstripeformlist())) {
			 MyAccountPageAddNewAddressTasks.validDetals();
			 MyAccountPageCreditCardTasks.buyNowPayments();
			 Thread.sleep(4000);
		 }else {
			 test.pass("Brain tree payment or stripe is not activated so.. No buy now pop up placing the order with buy now button");
		 }
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.selectTheAttributesInPdpForBuyNow();		
		 Thread.sleep(3000);
		 placeOrderInBuyNow();
		
	}
	
	public static void placeOrderInBuyNow() throws InterruptedException, Exception {
		 try{	
				test.info("User logged in as registered and clicked on buy now button");
				Thread.sleep(2000);			
				if(Actionsss.elementSize(pdp.getBrainTreePlaceOrderBuyNowList())) {
					logger.info("brain tree activated");					
					Actionsss.CombinedClick(pdp.getBrainTreePlaceOrderBuyNow());
					ContinueShoppingInquotaLimitIssue();
				}else if(Actionsss.elementSize(pdp.getstripePlaceOrderBuyNowList())) {
					logger.info("Stripe activated and clicked on buy now button");					
					Actionsss.CombinedClick(pdp. getstripePlaceOrderBuyNow());
					ContinueShoppingInquotaLimitIssue();
				}else {
					logger.info("Other payment methods are activated and clicked on buy now button ");										
					ShippingAddressPageTasks.enterValidAddress();
					PaymentPageTasks.creditCardWithValidDetails();
					ReviewOrderPageTask.placeOrder();					
					OrderDetailPageTasks.getOrderConfirmationPage();
					Actionsss.javascriptClick(homePage.clickOnLogo());
				}			
		 }catch(Exception e) {
			 	Actionsss.javascriptClick(homePage.clickOnLogo());
			 	System.out.println(e);
		 }
	}
	
	public static void ContinueShoppingInquotaLimitIssue() throws InterruptedException, Exception {
		if(Actionsss.elementSize(MAC.getcontinueShoppingButtonList()) && !Actionsss.elementSize(homePage.clickOnLogoList()) ) {
			test.info("Quota limit issue in buy now popup , so clicking on continue shopping");			
			Actionsss.CombinedClick(MAC.getcontinueShoppingButton());
			Thread.sleep(4000);				
		}
		test.info("Verifying order placing through buy now button");	
		OrderDetailsPageValidation.creditCardInfoInBuyNowAndOrderConfirmationPage();
		OrderDetailPageTasks.getOrderConfirmationPage();
		
	}
}
