package validations;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.OrderPageDetails;

public class OrderDetailsPageValidation extends baseClass{
	
	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	static String lastFourDigits="";
	static String paymentText="";
	static String lastFourDigitsInGc="";
	static String gcPaymentText ="";
	public static void paymentInOrderConfirmationPage() throws InterruptedException {
		
		if(Actionsss.elementSize(orderPage.getPaymentInOrderConfirmationPageList())) {
			if(Actionsss.displayElement(orderPage.getPaymentInOrderConfirmationPage())){
				 paymentText = Actionsss.getTextOfElement(orderPage.getPaymentInOrderConfirmationPage());
				logger.info("Paypal " +paymentText);
				lastFourDigits =paymentText.substring(paymentText.length() - 4);
				logger.info("credit card "+lastFourDigits);
			}
		}
		if(Actionsss.elementSize(orderPage.getGiftCodeInOrderConfirmationPageList())) {
			gcPaymentText = Actionsss.getTextOfElement(orderPage.getGiftCodeInOrderConfirmationPage());
			logger.info(gcPaymentText);
			lastFourDigitsInGc =gcPaymentText.substring(gcPaymentText .length() - 4);
			logger.info("Gc last 4 digits "+lastFourDigitsInGc);
		}
		logger.info(creditCardNumber +"and" +lastFourDigits);
		logger.info(gcCodeRedeemed + "and " +lastFourDigitsInGc);
		logger.info(getTextOfPaypalInPaymentPage + "and " + paymentText);
		
		

		 if (!getTextOfPaypalInPaymentPage.isEmpty() && !gcCodeRedeemed.isEmpty() && getTextOfPaypalInPaymentPage.equals(paymentText) && gcCodeRedeemed.equals(lastFourDigitsInGc)) {
	        logger.info("gc and paypal");
	        test.info("Verifying the provided paypal and Gc payment display in order confirmation page ");
	        test.pass("Successfully order is placed with provided paypal and gc code, the provided paypal and gc code is " + getTextOfPaypalInPaymentPage + " and " + gcCodeRedeemed + " and displayed card number is " + paymentText + " and " + lastFourDigitsInGc);
	     }else if (!creditCardNumber.isEmpty() && !lastFourDigits.isEmpty() && creditCardNumber.equals(lastFourDigits) && !gcCodeRedeemed.isEmpty() && gcCodeRedeemed.equals(lastFourDigitsInGc)) {
	        logger.info("gc and credit");
	        test.info("Verifying the provided credit card and Gc payment display in order confirmation page ");
	        test.pass("Successfully order is placed with provided card number and gc code, the provided card number and gc code is " + creditCardNumber + " and " + gcCodeRedeemed + " and displayed card number is " + lastFourDigits + " and " + lastFourDigits);
	     }else if (!creditCardNumber.isEmpty() && !lastFourDigits.isEmpty() && creditCardNumber.equals(lastFourDigits)) {
	        logger.info("cc");
	        test.info("Verifying the provided card number display in order confirmation page ");
	        test.pass("Successfully order is placed with provided card number, the provided card number is " + creditCardNumber + " and displayed card number is " + paymentText);
	    } else if (!gcCodeRedeemed.isEmpty() && gcCodeRedeemed.equals(lastFourDigitsInGc)) {
	        logger.info("gc");
	        test.info("Verifying the provided Gc code display in order confirmation page");
	        test.pass("Successfully order is placed with gift certificate, the provided gift certificate is " + gcCodeRedeemed + " and displayed gift certificate is " + lastFourDigitsInGc);
	    } else if (!getTextOfPaypalInPaymentPage.isEmpty() && getTextOfPaypalInPaymentPage.equals(paymentText)) {
	        logger.info("paypal");
	        test.info("Verifying the provided paypal payment display in order confirmation page  ");
	        test.pass("Successfully order is placed with provided PayPal, the PayPal is " + getTextOfPaypalInPaymentPage + " and displayed PayPal is " + getTextOfPaypalInPaymentPage);
	    }
		 
		 logger.info("After order confirmation page");
		 logger.info(getTextOfPaypalInPaymentPage="");
		 logger.info(gcCodeRedeemed="");
		 logger.info(creditCardNumber="");
		 
		 
	}
	
	public static void creditCardInfoInBuyNowAndOrderConfirmationPage() {
		logger.info(TestData.creditCardInBuyNowPopUp);
		String creditCardInOrderConfirmationPage1=Actionsss.getTextOfElement(orderPage.getCreditCardInOrderConfirmationPage());
		String creditCardInOrderConfirmationPage =creditCardInOrderConfirmationPage1.substring(creditCardInOrderConfirmationPage1 .length() - 4);
		logger.info(creditCardInOrderConfirmationPage);
		if(TestData.creditCardInBuyNowPopUp.equals(creditCardInOrderConfirmationPage)) {
			test.pass("Credit card in buy now pop up is " + TestData.creditCardInBuyNowPopUp + "and payment done with " + creditCardInOrderConfirmationPage + " are same") ;
			logger.info("Credit card in buy now pop up is " + TestData.creditCardInBuyNowPopUp + "and payment done with " + creditCardInOrderConfirmationPage + " are same");
		}else {
			test.fail("Credit card in buy now pop up is " + TestData.creditCardInBuyNowPopUp + "and payment done with " + creditCardInOrderConfirmationPage + " are not same") ;
			logger.info("Credit card in buy now pop up is " + TestData.creditCardInBuyNowPopUp + "and payment done with " + creditCardInOrderConfirmationPage + " are not same");
		}
	}
	
	public static void validatePlacetheOrderPage() throws InterruptedException {
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {
	    	 String ActualTitleofPlacetheOrder = Actionsss.getTextOfElement(orderPage.getOrderThankMessage());
	    	 logger.info(ActualTitleofPlacetheOrder);
		     String ExpectedTitlePlacetheOrder = "Thank you for your order.";
	    	 test.info("verifying  the order is placed");
	
		    if (ActualTitleofPlacetheOrder.equals(ExpectedTitlePlacetheOrder)) {
		        test.pass("Successfully Order is Placed and Thank you for your order message is displayed");
		        logger.info("Successfully Order is Placed and Thank you for your order message is displayed");
		    } else {
		        test.fail( "The page Title does not match expected " + ExpectedTitlePlacetheOrder + " " + "  but found" + " " + ActualTitleofPlacetheOrder + " ");
		        logger.info("Click failed");
		    }		    
		}
	}    
	
	//validate the order number and date of order
		public static void orderNumberAndOrderDate() throws InterruptedException {
			if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {
			   String orderNumber = Actionsss.getTextOfElement(orderPage.getOrderNumber());
			  
		        test.pass("The Order number is "+ orderNumber);
		        logger.info("The Order number is "+ orderNumber);
			    
			    //order date
			    String OrderDate = Actionsss.getTextOfElement(orderPage.getOrderDate());
		        test.pass("The Ordered date is "+  OrderDate);
		        
		        //paymnet details
			    String paymentDetails = Actionsss.getTextOfElement(orderPage.getPaymentDetailsInOrderConfirmationPage());
		      
		        test.pass("Payment is done with "+ paymentDetails);
		        logger.info("Payment is done with"+ paymentDetails);
			}
					
		}
		
		//--------------empty field error---------------
		public static void emptyFieldErrorToCreateAccount() {
			if(Actionsss.getSizeOfList(orderPage.getEmptyFieldErrorInOrderDetailPage())==2) {
				test.pass("Error message is dispalyed while submitting the empty fields to create account");
				logger.info("Error message is dispalyed while submitting the empty fields to create account");
			}else {
				test.fail("Error message is not dispalyed while submitting the empty fields to create account");
				logger.info("Error message is not dispalyed while submitting the empty fields to create account");
			}
		}
		
		//-----------Password mismatch error----------------
		public static void passwordMismatchErrorToCreateAccount() {
			if(Actionsss.displayElement(orderPage.getPasswordMismatchErrorInOrderDetailPage())) {
				test.pass("Error message is dispalyed while submitting the incorrect password to create account");
				logger.info("Error message is dispalyed while submitting the incorrect password to create account");
			}else {
				test.fail("Error message is not dispalyed while submitting the incorrect password to create account");
				logger.info("Error message is not dispalyed while submitting the incorrect password to create account");
			}
		}
		
		public static void alreadyExistingEmailErrorToCreateAccount() {
			if(Actionsss.displayElement(orderPage.getAlreadyExistEmailErrorInOrderDetailPage())) {
				test.pass("Error message is dispalyed while creating account with existing email the email id is " +TestData.existingEmailToCreateAccountForErrorMessage );
				logger.info("Error message is dispalyed while creating account with existing email " + TestData.existingEmailToCreateAccountForErrorMessage);
			}else {
				test.fail("Error message is not dispalyed while creating account with existing email");
				logger.info("Error message is not dispalyed while creating account with existing email");
			}
		}
		
}
