package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.OrderPageDetails;
import pageObjects.homepage;
import validations.CheckOutPageValidation;
import validations.CreateAccountValidation;
import validations.OrderDetailsPageValidation;



public class OrderDetailPageTasks extends baseClass{
	

	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	
	
	public static void OrderConfimrationPage() throws Exception {
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList()) && Actionsss.displayElement(orderPage.getOrderThankMessage())){
			logger.info("Order confirmation page is loaded");
		}else {			
			ReviewOrderPageTask.clickPlaceOrderButton();
		}
	}


	public static void emptyFieldErrorInOrderConfirmationPage() throws Exception {		
		OrderConfimrationPage();
		Actionsss.scrollWindowsByPixel(400);
		Actionsss.sendKeys(orderPage.getNewPasswordInOrderDetailPage(),"", "empty field");
		Actionsss.sendKeys(orderPage.getNewPasswordConfirmInOrderDetailPage(),"", "empty field");
		Actionsss.click(orderPage.getCreateAccountInOrderDetailPage());
		OrderDetailsPageValidation.emptyFieldErrorToCreateAccount();		
		}
	

	public static void mismatchErrorMessageInOrderConfirmationPage() throws Exception {
		OrderConfimrationPage();
		Actionsss.scrollWindowsByPixel(400);
		Actionsss.sendKeys(orderPage.getNewPasswordInOrderDetailPage(),TestData.newPasswordInSaveMyInformation, "entered new password");
		Actionsss.sendKeys(orderPage.getNewPasswordConfirmInOrderDetailPage(),TestData.newPasswordForMismatchInSaveMyInformation, "entered mismatch password");
		Actionsss.click(orderPage.getCreateAccountInOrderDetailPage());
		OrderDetailsPageValidation.passwordMismatchErrorToCreateAccount();		
		}
	
	
	public static void creatingAccountWithexistingMailInOrderConfirmationPage() throws Exception {
		CheckOutPageTasks.guestCheckoutbtn();
		Actionsss.sendKeys(CP.getSelectGuestEmailInput(), TestData.existingEmailToCreateAccountForErrorMessage, "existing email");
		Thread.sleep(1000);
		Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
		CheckOutPageValidation.VerifiedThatGuestLogin();
		ShippingAddressPageTasks.EnteringShippingDetails();
		Thread.sleep(2000);
		PaymentPageTasks.creditCardWithValidDetails();	
 		ReviewOrderPageTask.placeOrder();	
 		Thread.sleep(2000);
 		getOrderConfirmationPage();
		Actionsss.sendKeys(orderPage.getNewPasswordInOrderDetailPage(),TestData.newPasswordInSaveMyInformation, "entered new password");
		Actionsss.sendKeys(orderPage.getNewPasswordConfirmInOrderDetailPage(),TestData.newPasswordInSaveMyInformation, "entered password to confirm");
		Actionsss.click(orderPage.getCreateAccountInOrderDetailPage());
		OrderDetailsPageValidation.alreadyExistingEmailErrorToCreateAccount();			
		}
	
	public static void creatingAccountWithNewMailInOrderConfirmationPage() throws Exception {
		OrderConfimrationPage();
		Actionsss.sendKeys(orderPage.getNewPasswordInOrderDetailPage(),TestData.newPasswordInSaveMyInformation, "entered new password");
		Actionsss.sendKeys(orderPage.getNewPasswordConfirmInOrderDetailPage(),TestData.newPasswordInSaveMyInformation, "entered password to confirm");
		Actionsss.click(orderPage.getCreateAccountInOrderDetailPage());
		Thread.sleep(5000);
	    CreateAccountValidation.accountPageTitle();			
		}
	
	
	public static void getOrderConfirmationPage() throws Exception {
		OrderConfimrationPage();
		Actionsss.scrollWindowsByPixel(400);
		OrderDetailsPageValidation.validatePlacetheOrderPage();
		OrderDetailsPageValidation.orderNumberAndOrderDate();		
	}
	public static void payment() throws InterruptedException {
		OrderDetailsPageValidation.paymentInOrderConfirmationPage();
	}
}
