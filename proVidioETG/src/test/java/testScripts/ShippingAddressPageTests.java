package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.ShippingAddressPageTasks;

public class ShippingAddressPageTests extends baseClass{
	
	@Test
    public void VerifingEnteredtheShippingAddressInShippingPage() throws Exception {
		ShippingAddressPageTasks.EnteringShippingDetails();
    }
	
	@Test
    public void VerifyingShippingAddressPageLoadingInShippingPage() throws Exception {
		ShippingAddressPageTasks.ShippingPageView();
    }
	
	@Test
    public void VerifyingGetCustomerInformationInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.getCutomerInfo();
    }
	
	@Test
    public void VerifyingHelpCenterInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.helpCenter();
    }
	
	@Test
    public void VerifyingEditCustomerEmailInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.editEmail();
    }
	
	@Test
    public void VerifyingProductClickInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.productClickInShippingAddressPage();
    }
	
	@Test
    public void VerifyingBackToCartInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.BackToCart();
    }
	
	@Test
    public void VerifyingETGLogoClickInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.EtgLogoClick();
    }
	
	@Test
    public void VerifyingShippingAddressFormInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.shippingForm();
    }
	
	@Test
    public void VerifyingOrderSummeryInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.OrderSummary();
    }

	@Test
    public void VerifyingNextPaymentButtonInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.NextPaymentButton();
    }
	@Test
    public void VerifyingEtgLogoInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.EtgLogo();
    }
	
	@Test
    public void VerifyingEmptyFormInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.emptyFormInShippingForm();
    }
	
	@Test
    public void VerifyingFirstNameFieldErrorInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.firstNameError();
    }
	
	@Test
    public void VerifyingLastNameFieldErrorInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.lastNameError();
    }
	
	@Test
    public void VerifyingAddressFieldErrorInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.addressError();
    }
	
	@Test
    public void VerifyingCharacterLimitInAddress1And2InShippingAddressPageInGuestUser() throws Exception {
		ShippingAddressPageTasks.characterCheckInAddress1And2Of35InGuestUser();
    }
	
	@Test
    public void VerifyingPhoneNumberFieldErrorInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.phoneNumberError();
    }
	
	
	@Test
    public void VerifyingValidShippingAddressInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.enterValidAddress();
    }
	
	//---------------------------Reg user -------------------------------------------
	@Test
    public void VerifyingShippingAddressRegUserInShippingAddressPage() throws Exception {
		ShippingAddressPageTasks.ShippingPageViewRegUser();
    }
	
	@Test
    public void VerifyingValidShippingAddressRegUserInShippingAddressPage() throws Exception {
		//ShippingAddressPageTasks.enterValidAddressRegUser();
    }
	
	@Test
    public void VerifyingSelectExistiongShippingAddressRegUserInShippingAddressPage() throws Exception {
		//ShippingAddressPageTasks.enterSelectExistingAddressRegUser();
    }
	
	@Test
    public void VerifyingUpdateShippingAddressRegUserInShippingAddressPage() throws Exception {
		//ShippingAddressPageTasks.updateAddressRegUser();
    }
	
	
	
	
	
}
