package tasks;

import org.openqa.selenium.interactions.Actions;

import com.github.javafaker.Faker;

import CreditCardPyament.AllValidationErrorMessagesOfCreditCard;
import CreditCardPyament.CreditCardDetails;
import GiftCerificatePayment.GiftCertificateForGc;
import GiftCerificatePayment.GiftCertificateInCombination;
import PaypalPayment.CartPagePayal;
import PaypalPayment.CheckOutPaypal;
import PaypalPayment.MiniCartPaypal;
import PaypalPayment.PdpPagePaypalBuyNow;
import baseClass.baseClass;
import data.AddressSelection;
import data.TestData;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.PaymentPage;
import pageObjects.ReviewOrderPage;
import pageObjects.ShippingAddressPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.CheckOutPageValidation;
import validations.MyAccountValidations;
import validations.OrderDetailsPageValidation;
import validations.PaymentPageValidation;
import validations.ReviewOrderPageValidation;
import validations.ShippingAddressPageValidation;


public class PaymentPageTasks extends baseClass {


	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final loginPage lp = new loginPage(driver);
	private static ShippingAddressPage SAP = new ShippingAddressPage(driver);
	private static final ReviewOrderPage reviewOrder = new ReviewOrderPage(driver);
	private static final PaymentPage paymentPage = new PaymentPage(driver);
	private static final ShippingAddressPage shippingPage = new ShippingAddressPage(driver);
	private static homepage homePage = new homepage(driver);
	
	
	public static void paymentPageView() throws Exception {
		if((Actionsss.elementSize(paymentPage.getpaymentPageList()))&& (Actionsss.elementSize(paymentPage.getNextReviewOrderBtnList()) || Actionsss.elementSize(paymentPage.getSelectPlaceOrderBtnList()))) {
			if((Actionsss.displayElement(paymentPage.getpaymentPage())) ){
				logger.info("Paymnet page is loaded");
			}else {
				logger.info("coming here else block");
				Actionsss.CombinedClick(homePage.clickOnLogo());
				Thread.sleep(2000);
				ShippingAddressPageTasks.enterValidAddress();
				Thread.sleep(2000);
			}
		}else {
			Actionsss.CombinedClick(homePage.clickOnLogo());
			Thread.sleep(2000);
			ShippingAddressPageTasks.enterValidAddress();
			Thread.sleep(2000);
		}
		
		Thread.sleep(2000);
	}
	
	public static void getEtgLogo() throws Exception {
		paymentPageView();
		PaymentPageValidation.etgLogoValidationInPaymentPage();
	
	}
	
	public static void clickLogo() throws Exception {
		paymentPageView();
		Actionsss.CombinedClick(homePage.clickOnLogo());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyClickOnLogo();
	}
	
	public static void getBackToCart() throws Exception {	
		 paymentPageView();
		 Actionsss.click(paymentPage.getBackToCart());				
		 CheckOutPageValidation.verifyClickOnBacktoCart();
	
	}
	
	public static void getCutomerInfoInPaymentPage() throws Exception {	
		paymentPageView();
		PaymentPageValidation.customerInfoValidationInPaymentPage();
	}
	
	public static void getOrderSummary() throws Exception {
		paymentPageView();
		PaymentPageValidation.orderSummaryValidationInPaymentPage();		
	}
	
	public static void  getshippingInfo() throws Exception {
		paymentPageView();
		PaymentPageValidation.shippingDetailValidationInPaymentPage();		
	}
		
	public static void characterLimitInBillingAddress() throws Exception {
		paymentPageView();
		Actionsss.CombinedClick(paymentPage.getUpdateBillingAddress());
		Actionsss.sendKeys(paymentPage.getBillingAddress(),TestData.CharactersInshippingAndBillingaddress1And2 ,"entered 35 characters");		
		Actionsss.sendKeys(paymentPage.getBillingAddressTwo(),TestData.CharactersInshippingAndBillingaddress1And2 ,"entered 35 characters");
		PaymentPageValidation.verifyIngCharacterLimitInAddresss1And2();	
		Actionsss.sendKeys(paymentPage.getBillingAddress(),TestData.CharactersInshippingAndBillingaddress1And2Empty ,"");		
		AddressSelection.selectBillingAddress();
	}
	
	public static void getPaymentForm() throws Exception {
		paymentPageView();
		PaymentPageValidation.paymentFormInPaymentPage();		
	}
	public static void paginationOfProductsInPaymentPage() throws InterruptedException, Exception {
		paymentPageView();
		Actionsss.randomElementFromList(paymentPage.getproductsInCheckoutPage2());
		PaymentPageValidation.pdpPageValidation();
	}


	
	public static void getReviewOrder() throws Exception {
		paymentPageView();
		PaymentPageValidation.reviewOrderButtonInPaymentPage();
	
	}
	
	public static void editShippindAddressFromPaymentPage() throws Exception {
		paymentPageView();
		Thread.sleep(2000);
		previousAddresses=Actionsss.getTextOfElement(paymentPage.getShippingAddressInPaymentPage());		
		Actionsss.click(paymentPage.getEditShipping());
		if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {			
			AddressSelection.editShippingAddress();
		}else {
			//AddressSelection.selectingRandomSavedShippingAddress();
			Actionsss.javascriptClick(shippingPage.getUpdateAddressBtn());
			AddressSelection.editShippingAddress();
		}
		Thread.sleep(2000);
		Actionsss.CombinedClick(shippingPage.getNextPaymentButton());				
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(4000);
		editedAddress=Actionsss.getTextOfElement(paymentPage.getShippingAddressInPaymentPage());
		PaymentPageValidation.editShippingValidationInCOP3();
		Thread.sleep(1000);
		//PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithCreditCard();
	}

	public static void editGiftMessageInCop2() throws Exception {
		paymentPageView();
		Thread.sleep(1000);
		Actionsss.CombinedClick(paymentPage.getEditShipping());
		Actionsss.CombinedClick(shippingPage.getGiftMessageCheckButton());
		String giftMessage ="Birthday gift";			
		Actionsss.sendKeys(shippingPage.getGiftMessagegiftMessageTextArea(), giftMessage,"gift message");
		Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
		Thread.sleep(2000);
		PaymentPageValidation.displayOfGiftMessageInCheckoutPage3();
	}
	
	public static void editCustomerInfoFromCop3() throws Exception {
		paymentPageView();
		Thread.sleep(2000);
		if(Actionsss.elementSize(CP.getGuestCheckout())) {			
			Thread.sleep(1000);
			previousMail=Actionsss.getTextOfElement(paymentPage.getEditCustomerInfo());		
			Actionsss.CombinedClick(paymentPage.getCustomerInfoFromCop3());		
			Faker faker = new Faker();
			String randomFirstName = faker.name().firstName(); 
		    String editedEmailInCop3 = randomFirstName + "EditedFromPaymentPage@etg.digital"; 
		    emailEditedInCop3 =editedEmailInCop3;		
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(),  emailEditedInCop3, "Edited email form check out page 3");			
			Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
			//CheckOutPage2Tasks.enterValidAddress();
			Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
			editedEmailFromCop3= Actionsss.getTextOfElement(paymentPage.getEditCustomerInfo());
			PaymentPageValidation.editEmailValidationInCOP3();
		}else {			
			logger.info("User is checked in as registered so edit button");
			test.info("User is checked in as registered so edit button");
			test.pass("No edit button to edit cutomer info for registered user");
		}	
		
	}
	
	public static void updateBillingAddress() throws Exception {
		paymentPageView();
		previousBillingAddress=Actionsss.getTextOfElement(paymentPage.getUpdateAddressBtnForBillingAddress());		
		Thread.sleep(3000);
		Actionsss.CombinedClick(shippingPage.getUpdateAddressBtn());
		Thread.sleep(1000);
		AddressSelection.editBillingAddress();
		Thread.sleep(2000);
		PaymentPageTasks.creditCardWithValidDetails();				
		editedBillingAddress=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());		
		PaymentPageValidation.updateBillingAddressValidation();
	}
	public static void addNewBillingAddress() throws Exception {
		paymentPageView();
		previousBillingAddress=Actionsss.getTextOfElement(paymentPage.getUpdateAddressBtnForBillingAddress());
		Thread.sleep(2000);
		Actionsss.CombinedClick(shippingPage.getUpdateAddressBtn());	
		Thread.sleep(1000);
		AddressSelection.addNewShippingAddressWithName();	
		Thread.sleep(1000);
		PaymentPageTasks.creditCardWithValidDetails();				
		editedBillingAddress=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());		
		PaymentPageValidation.updateBillingAddressValidation();
	}
	
	public static void paginationOfProductsFromPaymentPage() throws InterruptedException, Exception {
		paymentPageView();
		Actionsss.randomElementFromList(shippingPage.getproductsInCheckoutPage2());
		ShippingAddressPageValidation.pdpPageValidation();	
	}
	
	public static void billingPhoneNumber() throws Exception {
		paymentPageView();
		Actionsss.clearText(paymentPage.getBillingPhoneNumber());
		CreditCardDetails.creditCardDetails();
		if(Actionsss.elementSize(paymentPage.getSalesforcePaypalList())) {	
			logger.info("Salesforce payment activated");	
			Thread.sleep(1000);
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
		}
		PaymentPageValidation.billingPhoneNumberErrorValidation();
	}
	
	public static void allErrorsInCreditCard() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.allErrorsInCreditCard();
	
	}
	
	public static void CreditCardCvvAndExpErrorMessage() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardCvvAndExpError();
		
	}

	public static void CreditCardCvvErrorMessage() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCvvError();
		
	}
	public static void creditcardNumberInValidError() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditcardNumberInValidError();
		
	}
	
	public static void creditCardExpDateInValid() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardExpMonthInValid();
		
	}
	
	public static void creditCardNumberInCompleteError() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardNumberInCompleteError();
		
	}
	public static void creditCardInCompleteExpYearError() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardNumberInCompleteExpYearError();
		
	}
	public static void creditCardInCompleteCvvError() throws Exception {
			paymentPageView();
			AllValidationErrorMessagesOfCreditCard.creditCardInCompleteCvvError();
		
	}
	

	
	public static void  creditCardWithValidDetails() throws Exception {
			paymentPageView();
			CreditCardDetails.creditCardDetails();
			Thread.sleep(2000);
//			Actionsss.CombinedClick(homePage.clickOnLogo());
//			Thread.sleep(2000);
		
	}


	//gift card
		public static void gcRedemption() throws Exception {
			paymentPageView();
			GiftCertificateForGc.giftCodeForGc();
		//	PaymentPageValidation.redemptionOfGcValidation();	
		}
	
	//gift card
		public static void gcRedemptionInCombinationWithCreditCard() throws Exception {
			paymentPageView();
			GiftCertificateInCombination.giftCodesForCombination();
			//PaymentPageValidation.partialRedemptionOfGcValidation();
			PaymentPageTasks.creditCardWithValidDetails();
		}
		
		public static void paypal() throws Exception {
			paymentPageView();
			CheckOutPaypal.paypalFromCheckout();
		}
		
		public static void gcRedemptionInCombinationWithPaypal() throws Exception {
			paymentPageView();		
			GiftCertificateInCombination.giftCodesForCombination();
			//PaymentPageValidation.partialRedemptionOfGcValidation();
			CheckOutPaypal.paypalFromCheckout();
		}
	
		public static void clickReviewOrderButton() throws Exception {
		   if(Actionsss.elementSize(paymentPage.getBrainTree())) {
			   
				 if(Actionsss.displayElement(paymentPage.getReviewOrderBtn())) {
			    		Actionsss.scrollWindowsByPixel(100);	
			    		Thread.sleep(5000);
			    		Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
			    		Thread.sleep(3000);
			    		ReviewOrderPageValidation.VerifyingReviewOrderBtn();
			    	}
	    	}else {
	    		Actionsss.scrollWindowsByPixel(200);
	    		Thread.sleep(1000);
	    		if(Actionsss.elementSize(paymentPage.getReviewOrderBtnList())) {
					if(Actionsss.displayElement(paymentPage.getReviewOrderBtn())) {
						Thread.sleep(1000);
						Actionsss.CombinedClick(paymentPage.getReviewOrderBtn());
						Thread.sleep(3000);							
					}
				}
	    	}
		}
		
		public static void creditCardwithValidDetailsforOrderPlacing() throws Exception {
			paymentPageView();	
			PaymentPageGiftCerificationTasks.gcRemoved();
			CreditCardDetails.creditCardDetails();
			Thread.sleep(2000);
		}
		
		
		
		public static void paymentPageViewRegUser() throws Exception {
			if(Actionsss.countofElements(lp.clickSignList())) {
				logger.info("User not logged in");
				 HomePageTasks.verifyThatuserLogin();
				 Thread.sleep(7000);
				 MiniCartPageTasks.checkOutBtnClickRegUser();
				 Thread.sleep(2000);
				 AddressSelection.Address();
				 //Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
				 
				 //ShippingAddressPageTasks.enterValidAddressRegUser();
					Thread.sleep(2000);
			}else {
				logger.info("user logged in");
				Actionsss.CombinedClick(homePage.clickOnLogo());
				Thread.sleep(2000);
				MiniCartPageTasks.checkOutBtnClickRegUser();
				Thread.sleep(2000);
				//Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
				//ShippingAddressPageTasks.enterValidAddressRegUser();
				 AddressSelection.Address();
				Thread.sleep(2000);
		  }
		}
			
		
		
		public static void ShippingUpdateforReg() throws Exception {
			paymentPageViewRegUser();
			Actionsss.CombinedClick(paymentPage.getEditShipping());
			Thread.sleep(2000);
			ShippingAddressPageTasks.updateAddressRegUser();
		}
		
		public static void ShippingAddNewAddressforReg() throws Exception {
			paymentPageViewRegUser();
			Actionsss.CombinedClick(paymentPage.getEditShipping());
			Thread.sleep(2000);
			ShippingAddressPageTasks.enterValidAddressRegUser();
		}
		
		public static void ShippingSelectaAddressforReg() throws Exception {
			paymentPageViewRegUser();
			Actionsss.CombinedClick(paymentPage.getEditShipping());
			Thread.sleep(2000);
			ShippingAddressPageTasks.enterSelectExistingAddressRegUser();
		}
		
		public static void BillingSelectaAddressforReg() throws Exception {
			paymentPageViewRegUser();
			previousBillingAddress=Actionsss.getTextOfElement(paymentPage.getBillingAddressDetails());
			Actionsss.CombinedClick(paymentPage.getUpdateAddressBtnForBillingAddress());
			Actionsss.randomElementFromListfordropdown(paymentPage.getBillingAddressOptions());
			int xCoord = 100;
	        int yCoord = 200;
			Actions actions = new Actions(driver);
	        // Perform a click anywhere on the page
			actions.moveByOffset(xCoord, yCoord).click().perform();
			Thread.sleep(2000);
			clickReviewOrderButton();
			Thread.sleep(2000);
			editedBillingAddress=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());		
			PaymentPageValidation.updateBillingAddressValidation();
		}
		
		// -------------------reg user -------------------------
		
		public static void  creditCardInRegUser() throws Exception {
			paymentPageViewRegUser();
			PaymentPageGiftCerificationTasks.gcRemoved();
			CreditCardDetails.creditCardDetails();
			clickReviewOrderButton();
	}
		
		public static void gcRedemptionForRegisterUser() throws Exception {
			paymentPageViewRegUser();
			GiftCertificateForGc.giftCodeForGc();
		//	PaymentPageValidation.redemptionOfGcValidation();	
		}
		
		public static void gcRedemptionInCombinationWithCreditCardForRegisterUser() throws Exception {
			paymentPageViewRegUser();
			GiftCertificateInCombination.giftCodesForCombination();
			//PaymentPageValidation.partialRedemptionOfGcValidation();
			PaymentPageTasks.creditCardWithValidDetails();	
		}
		
		public static void paypalForRegisterUser() throws Exception {
			paymentPageViewRegUser();
			CheckOutPaypal.paypalFromCheckout();
		}
		
		public static void gcRedemptionInCombinationWithPaypalForRegisterUser() throws Exception {
			paymentPageViewRegUser();				
			GiftCertificateInCombination.giftCodesForCombination();
			//PaymentPageValidation.partialRedemptionOfGcValidation();
			CheckOutPaypal.paypalFromCheckout();
		}
		
		public static void miniCartPaypalForRegisterUser() throws Exception {
			paymentPageViewRegUser();				
			MiniCartPaypal.miniCartPaypal();
		}
		
		public static void cartPagePaypalForRegisterUser() throws Exception {
			paymentPageViewRegUser();				
			CartPagePayal.cartPagePaypal();
		}
		
		public static void pdpPagePaypalForRegisterUser() throws Exception {
			paymentPageViewRegUser();				
			PdpPagePaypalBuyNow.pdpPagePaypalRegister();
		}
		
	
		
		
}
