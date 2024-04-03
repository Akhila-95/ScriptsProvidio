package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.GiftCertificateInCartScenariosTasks;

public class GiftCertificateScenariosInCartTest extends baseClass{

	@Test
	public static void VerifyingPlaceOrderWithCreditCardWhenOnlyGcInCartInRegisterUser() throws Exception {
		GiftCertificateInCartScenariosTasks.OnlyGcInCartWithCreditCardInRegisterUser();
	}
	
	@Test
	public static void VerifyingPlaceOrderWithCreditCardWhenOnlyGcInCartInGuestUser() throws Exception {
		GiftCertificateInCartScenariosTasks.OnlyGcInCartWithCreditCardInGuestUser();
	}
	
	@Test
	public static void VerifyingPlaceOrderWithPaypalWhenOnlyGcInCartInRegisterUser() throws Exception {
		GiftCertificateInCartScenariosTasks.OnlyGcInCartWithPaypalInRegisterUser();
	}
	
	
	@Test
	public static void VerifyingPlaceOrderWithPaypalWhenOnlyGcInCartInGuestUser() throws Exception {
		GiftCertificateInCartScenariosTasks.OnlyGcInCartWithPaypalInGuestUser();
	}
	
	@Test
	public static void VerifyingNoVisibilityOfGiftCertificateSectionWhenGcInCartInRegisterUser() throws Exception {
		GiftCertificateInCartScenariosTasks.gcInCartNoGcSectionVisibleInRegisterUser();
	}
	
	
	@Test
	public static void VerifyingNoVisibilityOfGiftCertificateSectionWhenGcInCartInGuestUser() throws Exception {
		GiftCertificateInCartScenariosTasks.gcInCartNoGcSectionVisibleInGuestUser();
	}
	
	@Test
	public static void VerifyingPlaceOrderOfGiftCertificateAndSimpleProductInCartWithCreditCardInRegisterUser() throws Exception {		
		GiftCertificateInCartScenariosTasks.placeOrderOfcombinationOfGcAndSimpleProductWithCreditCardInRegisterUser();
	}
	
	@Test
	public static void VerifyingPlaceOrderOfGiftCertificateAndSimpleProductInCartWithCreditCardInGuestUser() throws Exception {	
		GiftCertificateInCartScenariosTasks.placeOrderOfcombinationOfGcAndSimpleProductWithCreditCardInGuestUser();
	}
	
	@Test
	public static void VerifyingPlaceOrderOfGiftCertificateAndSimpleProductInCartWithPaypalInRegisterUser() throws Exception {
		GiftCertificateInCartScenariosTasks.placeOrderOfcombinationOfGcAndSimpleProductWithPaypalInRegisterUser();
	}
	
	@Test
	public static void VerifyingPlaceOrderOfGiftCertificateAndSimpleProductInCartWithPaypalInGuestUser() throws Exception {
		GiftCertificateInCartScenariosTasks.placeOrderOfcombinationOfGcAndSimpleProductWithPaypalInGuestUser();
	}

	@Test
	public static void VerifyingTheRemoveOfGiftCertificateFromCartInGuestUser() throws Exception {
		GiftCertificateInCartScenariosTasks.removeGiftCertificateFromCart();
	}

}


