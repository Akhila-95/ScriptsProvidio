package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import pageObjects.ReviewOrderPage;
import validations.RefreshPageValidations;


public class RefreshPageTasks extends baseClass{

	private static final PaymentPage paymentPage = new PaymentPage(driver);
	private static final ReviewOrderPage reviewOrder = new ReviewOrderPage(driver);
	
	public static void refreshPaymentPageAndCheckTheReviewButtonEnable() throws Exception {
		ShippingAddressPageTasks.enterValidAddress();
		driver.navigate().refresh();
		Actionsss.scrollWindowsByPixel(700);
		RefreshPageValidations.check_EnableOfRevieworderOrPlaceOrderButton();
	}
	
	public static void refreshTheReviewOrderPageAndCheckThePaymentDetails() throws Exception {
		if (!Actionsss.elementSize(paymentPage.getCreditcardsSalesForce())) {
			PaymentPageTasks.creditCardWithValidDetails();
			previousPaymentInPlaceorderPage=Actionsss.getTextOfElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit());		
			driver.navigate().refresh();
			Thread.sleep(2000);
			//paymentAfterRefreshInReviewOrderPage
			Actionsss.scrollWindowsByPixel(200);
			if(Actionsss.displayElement(reviewOrder.getCreditCardPaymentBrainTreeBeforeEdit())) {
				test.pass("Same payment is displayed after refreshing the page");
				logger.info("Same payment is displayed after refreshing the page");
				
			}else {
				test.fail("Payment is changed after refreshing the page");
				logger.info("Payment is changed after refreshing the page");
			}
			
		}else {
			test.info("Salesforce payment is activated");
			test.pass("No review order page in salesforce payment");
		}
		
	}
}
