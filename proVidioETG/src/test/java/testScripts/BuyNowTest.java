package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.BuyNowTask;


public class BuyNowTest  extends baseClass{

	
	@Test
	public static void VerifyingTheEnableOfBuyNowButtonAfterSelectingTheAttributes() throws Exception {
		BuyNowTask.enableOfBuyNowButton();
	}
	
	@Test
	public static void VerifyingTheDisplayOfCreditCardInBuyNowPopAndSameInOrderConfirmationPage() throws Exception {
		BuyNowTask.displayOfCreditCardAsDefault();
	}
	
	@Test
	public static void VerifyingThePurchaseFromBuyNowPopUpByClosingIt() throws Exception {
		BuyNowTask.cancelThePurchaseInBuyNowPopUp();
	}
	
	@Test
	public static void VerifyingTheDisableOfBuyNowButtonIfTheProdutIsOutOfStock() throws Exception {
		BuyNowTask.outOfStockProductInBuyNowPopUp();
	}
	
	@Test
	public static void VerifyingTheTotalPriceInBuyNowPopUpWhetherItIsCalculatingTheTax() throws Exception {
		BuyNowTask.validatingTheTotalPriceInBuyNowPopUp();
	}
	
	@Test
	public static void ValidatingThePaymentsInBuyNowPopUp() throws Exception {
		BuyNowTask.validatingPaymentsInBuyNowPopUp();
	}
	
	
	@Test
	public static void VerifyingPlaceOrderWithBuyNowButton() throws Exception {
		BuyNowTask.pdpPagebuyNowButtonGuestUser();
	}
	
	@Test
	public static void VerifyingPlaceOrderWithBuyNowPopUp() throws Exception {
		BuyNowTask.pdpPageBuyNowPopUpRegisteredUser();
	}
}
