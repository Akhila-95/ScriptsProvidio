package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.OrderDetailPageTasks;

public class OrderDetailsTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public void VerifyingOrderConfirmationPage() throws Exception {
		OrderDetailPageTasks.getOrderConfirmationPage();
    }

	@Test
	public static void verifyingThePaymentDetails() throws InterruptedException {
		OrderDetailPageTasks.payment();
	}
	
	@Test
	public static void VerifyingTheEmptyFieldErrorInOrderConfirmationPageForCreatingAccount() throws Exception {
		OrderDetailPageTasks.emptyFieldErrorInOrderConfirmationPage();
	}
	
	@Test
	public static void VerifyingTheMismatchErrorMessageInOrderConfirmationPageForCreatingAccount() throws Exception {
		OrderDetailPageTasks.mismatchErrorMessageInOrderConfirmationPage();
	}	
	
	@Test
	public static void VerifyingTheErrorMessageWhileCreatingAccountWithExistingEmail() throws Exception {
		OrderDetailPageTasks.creatingAccountWithexistingMailInOrderConfirmationPage();
	}
	
	@Test
	public static void VerifyingTheCreatingAccountWithNewMailFromOrderConfirmationPage() throws Exception {
		OrderDetailPageTasks.creatingAccountWithNewMailInOrderConfirmationPage();
	}
}
