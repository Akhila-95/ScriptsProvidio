package validations;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.PaymentPage;

public class RefreshPageValidations extends baseClass{

	private static final PaymentPage paymentPage = new PaymentPage(driver);
	public static void check_EnableOfRevieworderOrPlaceOrderButton() throws InterruptedException {
		test.info("Verifying after refreshing the page, review order button or place order button is in enabled mode");
		if(Actionsss.elementSize(paymentPage. getReviewOrderBtnList())) {
			 if(Actionsss.enabledElement(paymentPage.getReviewOrderBtn())) {
				 test.pass("After refreshing the payment page review order button is in enabled mode");
				 logger.info("After refreshing the payment page review order button is in enabled mode");
			 }
		}else if(Actionsss.elementSize(paymentPage.getSelectPlaceOrderBtnList())){
			if(Actionsss.enabledElement(paymentPage.getSelectPlaceOrderBtn()))
			 test.pass("Salesforce payment activated ,After refreshing the payment page place order button is in enabled mode");
			 logger.info("Salesforce payment activated ,After refreshing the payment page place order button is in enabled mode");
		 }else {
			 test.fail("Review order button or place order button is not enabled after refreshing the pages");
			 logger.info("Review order button or place order button is not enabled after refreshing the pages");
		 }
	}
}
