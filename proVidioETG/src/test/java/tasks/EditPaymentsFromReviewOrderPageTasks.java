package tasks;

import baseClass.baseClass;

public class EditPaymentsFromReviewOrderPageTasks extends baseClass {
	
	
	public static void editCreditToGiftCertificate() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		ReviewOrderPageTask.editPaymentFromCreditCardToGiftCerticficate();		
	}

	public static void editCreditCardToPaypal() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		ReviewOrderPageTask.creditCardToPaypal();		
	}
	
	public static void editGiftCertificateToCredit() throws Exception {
		PaymentPageTasks.gcRedemption();
		ReviewOrderPageTask.editPaymentFromGiftCertificateToCreditCard();		
	}

	public static void editGiftCertificateToPaypal() throws Exception {
		PaymentPageTasks.gcRedemption();
		ReviewOrderPageTask.editPaymentFromGiftCertificateToPaypal();		
	}
	
	public static void editPaypalToGiftCertificate() throws Exception {
		PaymentPageTasks.paypal();
		ReviewOrderPageTask.editPaymentFromPaypalToGiftCertificate();		
	}
	
	public static void editPaypalToCreditCard() throws Exception {
		PaymentPageTasks.paypal();
		ReviewOrderPageTask.editPaymentFromPaypalToCreditCard();		
	}
	
	public static void editCombinationOfGiftCertificateAndCreditCardToGiftCertificate() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
		ReviewOrderPageTask.editPaymentFromCombinationOfGiftCertificateAndCreditCardToGiftCertificate();
		
	}
	
	public static void editCombinationOfGiftCertificateAndCreditCardToCreditCard() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithCreditCard();	
		ReviewOrderPageTask.editPaymentFromCombinationOfGiftCertificateAndCreditCardToCreditCard();
		
	}
	
	public static void editCombinationOfGiftCertificateAndPaypalToPaypal() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
		ReviewOrderPageTask.editPaymentFromCombinationOfGiftCertificateAndPaypalToPaypal();		
	}
	
	public static void editCombinationOfGiftCertificateAndPaypalToGiftCertificate() throws Exception {
		PaymentPageTasks.gcRedemptionInCombinationWithPaypal();
		ReviewOrderPageTask.editPaymentFromCombinationOfGiftCertificateAndPaypalToGiftCertificate();		
	}
	
	public static void editPaypalToCombinationOfGiftCertificateAndPaypal() throws Exception {
		PaymentPageTasks.paypal();
		ReviewOrderPageTask.editPaymentFromPaypalToCombinationOfGiftCertificateAndPaypal();				
	}
	
	public static void editPaypalToCombinationOfGiftCertificateAndCreditCard() throws Exception {
		PaymentPageTasks.paypal();
		ReviewOrderPageTask.editPaymentFromPaypalToCombinationOfGiftCertificateAndCreditCard();		
	}

	public static void editCreditCardToCombinationOfGiftCertificateAndCreditCard() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		ReviewOrderPageTask.editPaymentFromCreditCardToCombinationOfGiftCertificateAndCreditCard();		
	}
	
	public static void editCreditCardToCombinationOfGiftCertificateAndPaypal() throws Exception {
		PaymentPageTasks.creditCardWithValidDetails();
		ReviewOrderPageTask.editPaymentFromCreditCardToCombinationOfGiftCertificateAndPaypal();			
	}
}

