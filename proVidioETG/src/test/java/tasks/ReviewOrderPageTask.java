package tasks;

import CreditCardPyament.CreditCardDetails;
import PaypalPayment.CheckOutPaypal;
import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.PaymentPage;

import pageObjects.ReviewOrderPage;
import pageObjects.ShippingAddressPage;
import pageObjects.homepage;
import validations.OrderDetailsPageValidation;
import validations.PaymentPageValidation;
import validations.ReviewOrderPageValidation ;
import validations.ShippingAddressPageValidation;

public class ReviewOrderPageTask extends baseClass{

	private static final ReviewOrderPage reviewOrder = new ReviewOrderPage(driver);
	private static final PaymentPage paymentPage = new PaymentPage(driver);
	private static final ShippingAddressPage shippingPage = new ShippingAddressPage(driver);
	private static homepage homePage = new homepage(driver);
	private static TestData TD = new TestData();
	
	public static void reviewOrderPage() throws Exception {
		if(Actionsss.elementSize(reviewOrder.getgsummaryOfBillingAddressList()) && Actionsss.elementSize(reviewOrder.getSelectPlaceOrderBtnList())) {
			if(Actionsss.displayElement(reviewOrder.getgsummaryOfBillingAddress()) && (Actionsss.displayElement(reviewOrder.getSelectPlaceOrderBtn()))   ) {
				logger.info("Review order page is loaded");
			//	CreditCardDetails.creditCardDetails();
			}
		}else {
			PaymentPageTasks.creditCardWithValidDetails();
			//PaymentPageTasks.gcRedemption();
		}
	}
	
	public static void getBackToCart() throws Exception {	
		 reviewOrderPage();
		 ReviewOrderPageValidation.bactToCartValidationInreviewOrderPage();
		 Actionsss.click(paymentPage.getBackToCart());				
		 CheckOutPageTasks.GuestMailCheckOut();
		 ShippingAddressPageTasks.enterValidAddress();
		 PaymentPageTasks.creditCardWithValidDetails();
		 ReviewOrderPageValidation .bactToCartValidationInreviewOrderPage();
	
	}
	
	public static void getCutomerInfoInReviewOrderPage() throws Exception {	
		reviewOrderPage();
		ReviewOrderPageValidation.customerInfoValidationInreviewOrderPage();
	}
	
	public void  getshippingInfo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.shippingDetailInfoValidationInreviewOrderPage();		
	}
	
	public static void getOrderSummary() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.orderSummaryValidationInreviewOrderPage();		
	}
	
	public static void getPaymentInfo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.billingFormInreviewOrderPage();		
	}
	
	
	public static void paginationOfProductsInReviewOrderPage() throws InterruptedException, Exception {
		reviewOrderPage();
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			Actionsss.randomElementFromList(paymentPage.getproductsInCheckoutPage2());
			ReviewOrderPageValidation.pdpPageValidation();
			ViewCartPageTasks.viewCartpage();
			CheckOutPageTasks.GuestMailCheckOut();
			ShippingAddressPageTasks.enterValidAddress();
			PaymentPageTasks.creditCardWithValidDetails();
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}

	public static void getEtgLogo() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.etgLogoValidationInreviewOrderPage();
	
	}
	public static void getPlaceOrder() throws Exception {
		reviewOrderPage();
		ReviewOrderPageValidation.placeOrderButtonInPaymentPage();	
	}
	
	public static void clickPlaceOrderButton() throws Exception {
		reviewOrderPage();			
		placeOrder();
	}
	
	
	public static void placeOrder() throws Exception {
		//reviewOrderPage();
		Actionsss.scrollWindowsByPixel(500);
		if(Actionsss.elementSize(paymentPage.getSalesforcePaypalList())) {	
			logger.info("Salesforce payment activated");	
			Thread.sleep(1000);
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
			Thread.sleep(8000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		}else {
			logger.info("Other paymnet activated");
			logger.info("Place order page is loaded");
			Thread.sleep(2000);
			Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
			Thread.sleep(5000);
			PaymentPageValidation.VerifiedThatPlaceOrderClick();
		}
	}
	
	
	public static void editShippingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			previousShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getShippingAddressInRop());
			Actionsss.click(reviewOrder.getEditShippingAddressInRop());
			Actionsss.editShippingAddressFromRop(shippingPage.getShippingAddress());
			Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
			Thread.sleep(1000);
			ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
			PaymentPageTasks.creditCardWithValidDetails();				
			Thread.sleep(1000);
			editedShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getShippingAddressInRop());
			ReviewOrderPageValidation.editShippingAddressValidation();
			PaymentPageTasks.clickReviewOrderButton();
			placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();		 			
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	public static void editPhoneNumInShippingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			 previousPhoneNumInShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getPhoneNumInshippingAddressInRop());
			 Actionsss.click(reviewOrder.getEditShippingAddressInRop());
			 Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), "8765987653","shipping phone number");
			 Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
			 Thread.sleep(1000);
			 ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
			 PaymentPageTasks.creditCardWithValidDetails();					
			 Thread.sleep(5000);
			 editedPhoneNumInShippingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getPhoneNumInshippingAddressInRop());
			 ReviewOrderPageValidation.editPhoneNumShippingAddressValidation();
			 Thread.sleep(1000);
			 placeOrder();
			 OrderDetailsPageValidation.validatePlacetheOrderPage();
			 OrderDetailsPageValidation.orderNumberAndOrderDate();
			 
			
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	
	public static void editBillingAddressFromReviewOrderPage() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			 previousBillingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());			 
			 Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderBtnPage());
			 Actionsss.click(paymentPage.getUpdateBillingAddress());
			 Thread.sleep(1000);
			 Actionsss.scrollWindowsByPixel(200);
			 Actionsss.editBillingAddressFromRop(paymentPage.getBillingAddress());
			 PaymentPageTasks.creditCardWithValidDetails();					
			 Thread.sleep(5000);
			 editedBillingAddressInRop=Actionsss.getTextOfElement(reviewOrder.getBillingAddress());
			 ReviewOrderPageValidation.editedBillingAddressValidation();
			 OrderDetailsPageValidation.validatePlacetheOrderPage();
			 OrderDetailsPageValidation.orderNumberAndOrderDate();
			 
			
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
	}
	
	
	public static void editPhoneNumberInBillingAddress() throws Exception {
		reviewOrderPage();	
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			Thread.sleep(2000);				
			prevoiusBillingPhoneNumber =Actionsss.getTextOfElement(reviewOrder.getPhoneNumberInBillingAddress());	
			Thread.sleep(1000);
			Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderBtnPage());		
			Actionsss.sendKeys(paymentPage.getBillingPhoneNumber(), "7658490271", "edited phone number  in billing address");				
			PaymentPageTasks.creditCardWithValidDetails();			
			editedBillingPhoneNumber=Actionsss.getTextOfElement(reviewOrder.getPhoneNumberInBillingAddress());				
			PaymentPageValidation.phoneNumberInBillingAddressValidation();	
			placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.javascriptClick(homePage.clickOnLogo());
		}else {
			test.info("Salesforce payment is activated");
			test.info("No review order page in salesforce payment");
		}
		Actionsss.click(homePage.clickOnLogo());
	}
public static void editPaymentFromCreditCardToGiftCerticficate() throws Exception {
		
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from credit card to gift certificate from review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree activated");				
			//	if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
					logger.info("credit card details entered");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					
			//	}			
			}else if (Actionsss.elementSize(paymentPage.getCyberSourcePayment())) {
				 logger.info("Cybersource payment activated");
				 	if(Actionsss.elementSize(reviewOrder.getcybersourceCardDetailsInReviewOrderPageList())) {
				 	logger.info("credit card details entered");
				 	Actionsss.scrollWindowsByPixel(100);
				 	previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
				 	Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
				 	PaymentPageTasks.gcRedemption();
				 	paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
				 	}				 
			}else if(Actionsss.elementSize(reviewOrder.getstripeDatailsInReviewOrderPageList())){
					logger.info("stripe payment activated");				
					Actionsss.scrollWindowsByPixel(100);
			 		previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getStripeCreditCardInReviewOrderPage());
			 		Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			 		PaymentPageTasks.gcRedemption();
			 		paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getstripeGcDetailsInReviewOrderPageList());				
			}else if(Actionsss.elementSize(paymentPage.getAdyenPayment())) {	
					logger.info("adyen payment");
					Actionsss.scrollWindowsByPixel(100);
			 		previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenCreditCardInReviewOrderPage());
			 		Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
			 		PaymentPageTasks.gcRedemption();
			 		paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenGcDetailsInReviewOrderPage());	
			}
			ReviewOrderPageValidation.editPaymentInReviewOrderPage();
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.javascriptClick(homePage.clickOnLogo());		
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
	}catch(Exception e) {
		  Actionsss.javascriptClick(homePage.clickOnLogo());
		  System.out.println(e);
	  }
	}
	
	public static void creditCardToPaypal() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from Credit card to Paypal from review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree activated");				
				if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())){
					logger.info("credit card details entered");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					if( Actionsss.elementSize(paymentPage.getBrainPaypalAcc()) ) {
						CheckOutPaypal.paypalFromCheckout();
					}
					Thread.sleep(1000);
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
				}
			   }else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
			  }
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			 Actionsss.javascriptClick(homePage.clickOnLogo());
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
	}	catch(Exception e) {
			  Actionsss.javascriptClick(homePage.clickOnLogo());
			  System.out.println(e);
		  }
	}
		
	public static void editPaymentFromGiftCertificateToCreditCard() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from Gift certificate to Credit card from review order page");
			
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("brain tree");
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList())){
					logger.info("gc entered");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();			
					Thread.sleep(2000);
					PaymentPageTasks.creditCardWithValidDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
				}
				
			}else if(Actionsss.elementSize(reviewOrder.getcybersourceGcDetailsInReviewOrderPageList())) {				
					logger.info("cybersource activated");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
					Actionsss.javascriptClick(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();		
					Thread.sleep(2000);
					PaymentPageTasks.creditCardWithValidDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
			}else if(Actionsss.elementSize(reviewOrder.getstripeDatailsInReviewOrderPageList())){
					logger.info("Stirpe payment");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getstripeGcDetailsInReviewOrderPageList());
					Actionsss.javascriptClick(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();				
					Thread.sleep(2000);
					PaymentPageTasks.creditCardWithValidDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getStripeCreditCardInReviewOrderPage());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
			}else if(Actionsss.elementSize(paymentPage.getAdyenPayment())) {	
					logger.info("Adyen payment");
					Actionsss.scrollWindowsByPixel(100);
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenGcDetailsInReviewOrderPage());
					Actionsss.javascriptClick(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();					
					Thread.sleep(2000);
					PaymentPageTasks.creditCardWithValidDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenCreditCardInReviewOrderPage());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
			}
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.javascriptClick(homePage.clickOnLogo());
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
	}catch(Exception e) {
		  Actionsss.javascriptClick(homePage.clickOnLogo());
		  System.out.println(e);
	  }
	}
	
	public static void editPaymentFromGiftCertificateToPaypal() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {			
			test.info("Verifying the payment change from Gift certificate to Paypal from review order page");
			
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList())){
					logger.info("gc entered");
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();	
					Thread.sleep(2000);
					if( Actionsss.elementSize(paymentPage.getBrainPaypalAcc()) ) {
						CheckOutPaypal.paypalFromCheckout();
					}
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
				  }
				}else {
					test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
					logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
				}
				ReviewOrderPageTask.placeOrder();
				OrderDetailsPageValidation.validatePlacetheOrderPage();
				OrderDetailsPageValidation.orderNumberAndOrderDate();
				Actionsss.javascriptClick(homePage.clickOnLogo());		
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
	}catch(Exception e) {
		  Actionsss.javascriptClick(homePage.clickOnLogo());
		  System.out.println(e);
	  }
	}
	
	public static void editPaymentFromPaypalToGiftCertificate() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Paypal to Gift certificate from review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				Actionsss.scrollWindowsByPixel(100);
				logger.info("brain tree");
				if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())) {					
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());	
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();	
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
			}						
			Thread.sleep(2000);
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.javascriptClick(homePage.clickOnLogo());		
		}
		else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
		}catch(Exception e) {
			  Actionsss.javascriptClick(homePage.clickOnLogo());
			  System.out.println(e);
		  }
	}
	
	public static void editPaymentFromPaypalToCreditCard() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Paypal to Credit Card from review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())) {	
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					Actionsss.javascriptClick(paymentPage.getBrainTreeCreditCardTab());
					CreditCardDetails.creditCardDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());	
					ReviewOrderPageValidation.editPaymentInReviewOrderPage();
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment " );
			}
				
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.javascriptClick(homePage.clickOnLogo());;
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
		}catch(Exception e) {
			  Actionsss.javascriptClick(homePage.clickOnLogo());
			  System.out.println(e);
		  }
	}
	
	public static void editPaymentFromCombinationOfGiftCertificateAndCreditCardToGiftCertificate() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from Combination Of GiftCertificate And CreditCard To Gift Certificate in review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList()) && Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
					TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
					TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();	
					Thread.sleep(2000);
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
				}				
			}else if(Actionsss.elementSize(reviewOrder.getcybersourceVisaInReviewOrderPageList())&& Actionsss.elementSize(reviewOrder.getcybersourceGiftCertificateInReviewOrderPageList())){
					logger.info("cybersource activated");
					TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
					TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();
					Thread.sleep(2000);
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
					ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			}else if(Actionsss.elementSize(reviewOrder.getstripeDatailsInReviewOrderPageList())){
					logger.info("stripe payment");
					TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getStripeCreditCardInReviewOrderPage());
					TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getstripeGcDetailsInReviewOrderPageList());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();
					Thread.sleep(2000);
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getstripeGcDetailsInReviewOrderPageList());
					ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			}else if(Actionsss.elementSize(paymentPage.getAdyenPayment())) {	
					logger.info("adyen payment");
					TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenCreditCardInReviewOrderPage());
					TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenGcDetailsInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();
					Thread.sleep(2000);
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenGcDetailsInReviewOrderPage());
					ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			}
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.javascriptClick(homePage.clickOnLogo());	
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}	
	}catch(Exception e) {
		  Actionsss.javascriptClick(homePage.clickOnLogo());
		  System.out.println(e);
	  }
	}
	
	public static void editPaymentFromCombinationOfGiftCertificateAndCreditCardToCreditCard() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Combination Of GiftCertificate And CreditCard To CreditCard in review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				Actionsss.scrollWindowsByPixel(100);
				logger.info("Brain tree");
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList()) && Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())) {
					TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
					TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();	
					Thread.sleep(2000);
					PaymentPageTasks.creditCardWithValidDetails();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
					ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
				}
			}else if(Actionsss.elementSize(reviewOrder.getcybersourceVisaInReviewOrderPageList())&& Actionsss.elementSize(reviewOrder.getcybersourceGiftCertificateInReviewOrderPageList())){				
				   logger.info("cybersource payment");
				   TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
				   TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
				   Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
				   PaymentPageGiftCerificationTasks.gcRemoved();
				   Thread.sleep(2000);
				   PaymentPageTasks.creditCardWithValidDetails();
				   Thread.sleep(2000);
				   paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
				   ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
				   
			}else if(Actionsss.elementSize(reviewOrder.getstripeDatailsInReviewOrderPageList())){
				   logger.info("stripe payment");
				   TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getStripeCreditCardInReviewOrderPage());
				   TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getstripeGcDetailsInReviewOrderPageList());
				   Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
				   PaymentPageGiftCerificationTasks.gcRemoved();
				   Thread.sleep(2000);
				   PaymentPageTasks.creditCardWithValidDetails();
				   Thread.sleep(2000);
				   paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getStripeCreditCardInReviewOrderPage());
				   ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			}else {
				  logger.info("adyen payment");
				   TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenGcDetailsInReviewOrderPage());
				   TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenCreditCardInReviewOrderPage());
				   Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
				   PaymentPageGiftCerificationTasks.gcRemoved();
				   Thread.sleep(2000);
				   PaymentPageTasks.creditCardWithValidDetails();
				   Thread.sleep(2000);
				   paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenCreditCardInReviewOrderPage());
				   ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
			}
			
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			 Actionsss.javascriptClick(homePage.clickOnLogo());
		}
	}catch(Exception e) {
			  Actionsss.javascriptClick(homePage.clickOnLogo());
			  System.out.println(e);
		  }
		
	}
	
	public static void editPaymentFromCombinationOfGiftCertificateAndPaypalToPaypal() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Combination Of GiftCertificate And Paypal To Paypal in review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				Actionsss.scrollWindowsByPixel(100);
				logger.info("Brain tree");
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList()) && Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())){
					TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();
					Thread.sleep(2000);
					CheckOutPaypal.paypalFromCheckout();
					PaymentPageTasks.clickReviewOrderButton();
					Thread.sleep(1000);
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment " );
			}
			
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.javascriptClick(homePage.clickOnLogo());			
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
	}catch(Exception e) {
		  Actionsss.javascriptClick(homePage.clickOnLogo());
		  System.out.println(e);
	  }
	 }
	
	public static void editPaymentFromCombinationOfGiftCertificateAndPaypalToGiftCertificate() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Combination Of GiftCertificate And Paypal To GiftCertificate in review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getGcPaymentInROPList()) && Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())){
					TestData.previousFirstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());	
					TestData.previousSecondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageGiftCerificationTasks.gcRemoved();
					Thread.sleep(2000);
					PaymentPageTasks.gcRedemption();
					paymentafterEditInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					ReviewOrderPageValidation.editCombinationOfPaymentToSinglePaymentInReviewOrderPage();
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment ");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment " );
			}
			
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			Actionsss.javascriptClick(homePage.clickOnLogo());			
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
	}catch(Exception e) {
		  Actionsss.javascriptClick(homePage.clickOnLogo());
		  System.out.println(e);
	  }
	  }
	
	

	public static void editPaymentFromPaypalToCombinationOfGiftCertificateAndPaypal() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Paypal To Combination Of GiftCertificate And Paypal in review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())){
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
					Thread.sleep(2000);
					TestData.firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					TestData.secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
					ReviewOrderPageValidation.editSinglePaymentToCombinationOfPaymentsInReviewOrderPage();
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment and changing the payment to credit card ");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment and changing the payment to credit card" );				
			}		
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			 Actionsss.javascriptClick(homePage.clickOnLogo());
		
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}}catch(Exception e) {
			  Actionsss.javascriptClick(homePage.clickOnLogo());
			  System.out.println(e);
		  }
	  }
	
	
	public static void editPaymentFromPaypalToCombinationOfGiftCertificateAndCreditCard() throws Exception {
		reviewOrderPage();
		try {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			test.info("Verifying the payment change from  Paypal To Combination Of GiftCertificate And CreditCard in review order page");
			if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
				logger.info("Brain tree");
				Actionsss.scrollWindowsByPixel(100);
				if(Actionsss.elementSize(reviewOrder.getBrainPaypalPaymentInReviewOrderPageList())){
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());						
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					Actionsss.javascriptClick(paymentPage.getBrainTreeCreditCardTab());
					PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
					TestData.firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
					TestData.secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
					ReviewOrderPageValidation.editSinglePaymentToCombinationOfPaymentsInReviewOrderPage();
				}
			}else {
				test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment and changing the payment to credit card ");
				logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment and changing the payment to credit card" );				
			}			
			ReviewOrderPageTask.placeOrder();
			OrderDetailsPageValidation.validatePlacetheOrderPage();
			OrderDetailsPageValidation.orderNumberAndOrderDate();
			 Actionsss.javascriptClick(homePage.clickOnLogo());		
		}else {
			test.info("Salesforce payment activated");
			test.pass("No review order page for salesforce payment");
		}
	}catch(Exception e) {
			  Actionsss.javascriptClick(homePage.clickOnLogo());
			  System.out.println(e);
		  }
	  }
	
	
	public static void editPaymentFromCreditCardToCombinationOfGiftCertificateAndCreditCard() throws Exception {
		reviewOrderPage();
		try {
			if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
				test.info("Verifying the payment change CreditCard To Combination Of GiftCertificate And CreditCard in review order page");
				if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
					logger.info("Brain tree");
					Actionsss.scrollWindowsByPixel(100);
					if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())){
						previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
						Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
						PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
						TestData.firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
						TestData.secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());
					}
				}else if (Actionsss.elementSize(reviewOrder.getcybersourceCardDetailsInReviewOrderPageList())){
					logger.info("Cybersource payment");
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();
					TestData.firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceGcDetailsInReviewOrderPage());
					TestData.secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getcybersourceCardDetailsInReviewOrderPage());
				}else if(Actionsss.elementSize(reviewOrder.getstripeDatailsInReviewOrderPageList())){
					logger.info("stripe");
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getStripeCreditCardInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();
					TestData.firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getStripeCreditCardInReviewOrderPage());
					TestData.secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getstripeGcDetailsInReviewOrderPageList());
				}else {
					logger.info("adyen payment");
					previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenCreditCardInReviewOrderPage());
					Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
					PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();
					TestData.firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenCreditCardInReviewOrderPage());
					TestData.secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getAdyenGcDetailsInReviewOrderPage());
				}
				ReviewOrderPageValidation.editSinglePaymentToCombinationOfPaymentsInReviewOrderPage();
				ReviewOrderPageTask.placeOrder();
				OrderDetailsPageValidation.validatePlacetheOrderPage();
				OrderDetailsPageValidation.orderNumberAndOrderDate();
				 Actionsss.javascriptClick(homePage.clickOnLogo());			
			}else {
				test.info("Salesforce payment activated");
				test.pass("No review order page for salesforce payment");
			}
		}catch(Exception e) {
			  Actionsss.javascriptClick(homePage.clickOnLogo());
			  System.out.println(e);
		  }
	  }
	
	public static void editPaymentFromCreditCardToCombinationOfGiftCertificateAndPaypal() throws Exception {
		reviewOrderPage();
		try {
			if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
				test.info("Verifying the payment change from  CreditCard To Combination Of GiftCertificate And Paypal in review order page");
				if(Actionsss.elementSize(reviewOrder.getBrainTreeDisplayList())) {
					logger.info("Brain tree");
					Actionsss.scrollWindowsByPixel(100);
					if(Actionsss.elementSize(reviewOrder.getCreditCardPaymentBrainTreeBeforeEditList())){
						previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());						
						Actionsss.click(reviewOrder.getEditPaymentInPlaceOrderPage());
						PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
						TestData.firstcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getGcPaymentInROP());
						TestData.secondcombinationOfPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getBrainPaypalPaymentInReviewOrderPage());
						ReviewOrderPageValidation.editSinglePaymentToCombinationOfPaymentsInReviewOrderPage();
					}
				}else {
					test.pass("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment and changing the payment to credit card ");
					logger.info("No paypal configuration for Stripe,Cybersource and Adyen payments so no change in payment and changing the payment to credit card" );				
				}			
				ReviewOrderPageTask.placeOrder();
				OrderDetailsPageValidation.validatePlacetheOrderPage();
				OrderDetailsPageValidation.orderNumberAndOrderDate();
				Actionsss.javascriptClick(homePage.clickOnLogo());		
			}else {
				test.info("Salesforce payment activated");
				test.pass("No review order page for salesforce payment");
			}
	  }catch(Exception e) {
		  Actionsss.javascriptClick(homePage.clickOnLogo());
		  System.out.println(e);
	  }
	}
	

}
