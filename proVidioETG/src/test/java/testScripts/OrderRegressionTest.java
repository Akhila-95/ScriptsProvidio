package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks. OrderPlacingWithDifferentPaymentsInRegisterUserTask;
import tasks.PlaceOrderWithDifferentPaymentsInGuestuser;

public class OrderRegressionTest extends baseClass {

	@Test
    public void VerifyingOrderIsPlacingWithCreditCardInRegisterUser() throws Exception {
		 OrderPlacingWithDifferentPaymentsInRegisterUserTask.orderPlacingWithCreditCard();
    }
	
	@Test
    public void VerifyingOrderIsPlacingWithGiftCardInRegisterUser() throws Exception {
		 OrderPlacingWithDifferentPaymentsInRegisterUserTask.orderPlacingWithGiftCard();
    }
	@Test
    public void VerifyingOrderIsPlacingWithCombinationOfGcAndCreditCardInRegisterUser() throws Exception {
		 OrderPlacingWithDifferentPaymentsInRegisterUserTask.orderPlacingWithCombinationOfGcAndCreditCard();
    }

	
	@Test
    public void VerifyingOrderIsPlacingWithPaypalFromCheckoutPageInRegisterUser() throws Exception {
		 OrderPlacingWithDifferentPaymentsInRegisterUserTask.orderPlacingWithPaypalFromCheckoutPage();
    }
	
	@Test
    public void VerifyingOrderIsPlacingWithCombinationOfGcAndPaypalInRegisterUser() throws Exception {
		 OrderPlacingWithDifferentPaymentsInRegisterUserTask.orderPlacingWithCombinationOfGcAndPaypal();
    }
	@Test
    public void VerifyingOrderIsPlacingWithMiniCartPaypalInRegisterUser() throws Exception {
		 OrderPlacingWithDifferentPaymentsInRegisterUserTask.orderPlacingWithMiniCartPaypal();
    }
	
	@Test
    public void VerifyingOrderIsPlacingWithCartPagePaypalInRegisterUser() throws Exception {
		 OrderPlacingWithDifferentPaymentsInRegisterUserTask.orderPlacingWithCartPagePaypal();
    }
	
	@Test
    public void VerifyingOrderIsPlacingWithPaypalBuyNowInPdpPageInRegisterUser() throws Exception {
		 OrderPlacingWithDifferentPaymentsInRegisterUserTask.orderPlacingWithPaypalInPdpPage();
    }
	
	
	//---------------------guest user ----------------------------------
	@Test
    public void verifyingOrderIsPlacingWithCreditCardInGuestUser() throws Exception {
		PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithCreditCard();
    }
	
	@Test
    public void verifyingOrderIsPlacingWithGiftCardInGuestUser() throws Exception {
		PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithGiftCard();
    }
	@Test
    public void verifyingOrderIsPlacingWithCombinationOfGcAndCreditCardInGuestUser() throws Exception {
		PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithCombinationOfGcAndCreditCard();
    }

	
	@Test
    public void verifyingOrderIsPlacingWithPaypalFromCheckoutPageInGuestUser() throws Exception {
		PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithPaypalFromCheckoutPage();
    }
	
	@Test
    public void verifyingOrderIsPlacingWithCombinationOfGcAndPaypalInGuestUser() throws Exception {
		PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithCombinationOfGcAndPaypal();
    }
	@Test
    public void verifyingOrderIsPlacingWithMiniCartPaypalInGuestUser() throws Exception {
		PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithMiniCartPaypal();
    }
	
	@Test
    public void verifyingOrderIsPlacingWithCartPagePaypalInGuestUser() throws Exception {
		PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithCartPagePaypal();
    }
	
	@Test
    public void verifyingOrderIsPlacingWithPaypalBuyNowInPdpPageInGuestUser() throws Exception {
		PlaceOrderWithDifferentPaymentsInGuestuser.orderPlacingWithPaypalInPdpPage();
    }
	
}
