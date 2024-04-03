package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks. ReviewOrderPageTask;


public class ReviewOrderTest extends baseClass{

	
	@Test
	public  void VerifyingPlaceOrderButtonClickInReviewOrderPage() throws InterruptedException, Exception {
		 ReviewOrderPageTask.clickPlaceOrderButton();
	}
	
	@Test
	public static void  VerifyingPlaceOrderButtonDisplayInReviewOrderPage() throws Exception {
		ReviewOrderPageTask.getPlaceOrder() ;
	}
	
	@Test
	public  void VerifyingTheDisplayOfCustomerInfoInReviewOrderPage() throws InterruptedException, Exception {
		 ReviewOrderPageTask.getCutomerInfoInReviewOrderPage();
	}
	
	@Test
	public void VerifyingPaginationOfProductsInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.paginationOfProductsInReviewOrderPage();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void VerifyingOrderSummaryDisplayInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.getOrderSummary();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void VerifyingPaymentInfoDisplayInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.getPaymentInfo();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void VerifyingEtgLogoDisplayInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.getEtgLogo();
	}
	
	
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void VerifyingBackToCartInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.getBackToCart();
	}
	

	
	@Test
	public  void VerifyingTheEditShippingAddressFromReviewOrderPageAndPlaceOrder() throws InterruptedException, Exception {
		 ReviewOrderPageTask.editShippingAddressFromReviewOrderPage();
	}
	
	@Test
	public  void VerifyingTheEditPhoneNumInShippingAddressFromReviewOrderPageAndPlaceOrder() throws InterruptedException, Exception {
		 ReviewOrderPageTask.editPhoneNumInShippingAddressFromReviewOrderPage();
	}
	

	@Test
	public  void VerifyingTheEditBillingAddressFromReviewOrderPageAndPlaceOrder() throws InterruptedException, Exception {
		 ReviewOrderPageTask.editBillingAddressFromReviewOrderPage();
	}
	
	@Test
	public static void VerifyingEditPhoneNumberInBillingAddressFromReviewOrderPageAndPlaceOrder() throws Exception {
		ReviewOrderPageTask.editPhoneNumberInBillingAddress();
	}
	
}
