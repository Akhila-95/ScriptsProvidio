package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.RefreshPageTasks;

public class RefreshPageTest extends baseClass {

	@Test
	public static void VerifyingRefreshingOfPaymentPageAndCheckingTheReviewOrderButtonEnable() throws Exception {
		RefreshPageTasks.refreshPaymentPageAndCheckTheReviewButtonEnable();
	}
	
	@Test
	public static void VerifyingRefreshingOgReviewOrderPageAndCheckThePaymentDetails() throws Exception {
		RefreshPageTasks.refreshTheReviewOrderPageAndCheckThePaymentDetails();
	}
}
