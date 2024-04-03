package validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.PaymentPage;
import pageObjects.ShippingAddressPage;
import tasks.ViewCartPageTasks;

public class CheckOutPageValidation extends baseClass{
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static ShippingAddressPage SDP = new ShippingAddressPage(driver);
	private static PaymentPage pp = new PaymentPage(driver);
	
	
	
	public static void verifyCheckoutProductClick() {
 		test.info("Verify whether the user is able to click product link");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
     	
     	if (pdpPage.isDisplayed()) {
     	    logger.info("Successfully clicked in the Product link and Navigated to the Product detail page");
     	    test.pass("Successfully clicked in the Product link and Navigated to the Product detail page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
	
	public static void VerifiedThatGuestLogin() throws InterruptedException {
 		test.info("Verified That GuestLogin click");
 	
     	if (Actionsss.elementSize(SDP.getshippingFormList()) ){
     		if(Actionsss.displayElement(SDP.getshippingForm())) {
     			logger.info("Successfully Clicked on the GuestLogin");
     			test.pass("Successfully Clicked on the GuestLogin");
     		}
     	}else if(Actionsss.elementSize(SDP.getBillingFormList())){
     		if(Actionsss.displayElement(SDP.getBillingForm())) {
	     		logger.info("Successfully Clicked on the GuestLogin and cart contains only Gift certificate");
	     	    test.pass("Successfully Clicked on the GuestLogin and cart contains only Gift certificate");
     			}
     	}else {
     		logger.info("clicked failed");
     	}
 	}
 	public static void verifyClickOnLogo() {
 		test.info("Verify whether the user is able to click logo ");
 		List<WebElement> Herobanners = driver.findElements(By.xpath("//div[contains(@class,'hero-banner-overlay')]"));
 		if (Herobanners.size()>0 ) {
 			logger.info("Successfully Clicked Logo  and Navigated to the Home page");
     	    test.pass("Successfully Clicked Logo on  and Navigated to the Home page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	

 	public static void verifyClickOnBacktoCart() {
 		test.info("Verify whether the user is able to click BacktoCart link on the checkout page");
 		List<WebElement> viewCartPage = driver.findElements(By.xpath("//div[contains(@class, 'cart-page')]"));
     	List<WebElement> viewCartPageproducts = driver.findElements(By.xpath("//div[contains(@class, 'card product-info')]"));
 		if (viewCartPage.size()>0 && viewCartPageproducts.size()>0 ) {
 			logger.info("Successfully Clicked back to cart on the checkout page and Navigated to the View Cart page");
     	    test.pass("Successfully Clicked back to cart on the checkout page and Navigated to the View Cart page");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	public static void verifyClickOnGuestCheckoutBtn() {
 		test.info("Verify whether the user is able to click Guest Checkout button on the checkout page");
 		WebElement Emailinput = driver.findElement(By.xpath("//input[@id='email-guest']"));
 		if (Emailinput.isDisplayed()) {
 			logger.info("Successfully Clicked Guest Checkout button on the checkout page and Guest email input field is avalibale for input");
     	    test.pass("Successfully Clicked Guest Checkout button on the checkout page and Guest email input field is avalibale for input");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	public static void verifyemptyEmail() {
 		test.info("Verify Empty Email input on the checkout page");
 		WebElement emptyError = driver.findElement(By.xpath("//div[text()='This field is required.']"));
 		if (emptyError.isDisplayed()) {
 			logger.info("Successfully Clicked on Continue as a guest button on the checkout page and This field is required Error message is displayed");
     	    test.pass("Successfully Clicked on Continue as a guest button on the checkout page and This field is required Error message is displayed");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	public static void verifyInvaidEmail() {
 		test.info("Verify Invaid Email input on the checkout page");
 		WebElement emptyError = driver.findElement(By.xpath("//div[text()='Please enter a valid email address.']"));
 		if (emptyError.isDisplayed()) {
 			logger.info("Successfully entered the Invaid mail and, Clicked on Continue as a guest button on the checkout page and Please enter a valid email address. Error message is displayed");
     	    test.pass("Successfully entered the Invaid mail and, Clicked on Continue as a guest button on the checkout page and Please enter a valid email address. Error message is displayed");
     	}else {
     		test.fail("Click failed");
     	}
 	}
 	
 	public static void verifyEmptyEmailandEmptyPassword() {
 		test.info("Verify empty Email and password input on the checkout page");
 		if(Actionsss.displayElement(CP.getemptyLoginError())&& Actionsss.displayElement(CP.getemptyPasswordError())) {
			test.pass("Successfully Clicked on Login button without entering email and password on the checkout page and This field is required address error messages are displayed");
			logger.info("Successfully Clicked on Login button without entering email and password on the checkout page and This field is required messages are displayed");
		}else {
			test.pass("Not navigated to login page");
			logger.info("Not navigated to login page");
		}
 		
 	}
 	
 	public static void verifyInvalidEmailandEmptyPassword() {
 		test.info("Verify Invalid Email and empty password input on the checkout page");
 		if(Actionsss.displayElement(CP.getinvalidEmailError())&& Actionsss.displayElement(CP.getemptyPasswordError1())) {
			test.pass("Successfully Clicked on Login button with entering Invalid email and empty passwordon the checkout page and This field is required error messages are displayed");
			logger.info("Successfully Clicked on Login button with entering Invalid email and empty passwordon the checkout page and This field is required error messages are displayed");
		}else {
			test.pass("Not navigated to login page");
			logger.info("Not navigated to login page");
		}
 	}
 	
 	public static void verifyInvalidEmailandInvalidPassword() {
 		test.info("Verify Invalid Email and Invalid password input on the checkout page");
 		if(Actionsss.displayElement(CP.getinvalidEmailError())) {
			test.pass("Successfully Clicked on Login button with entering Invalid email and Invalid password on the checkout page and Please enter a valid email address. error messages are displayed");
			logger.info("Successfully Clicked on Login button with entering Invalid email and Invalid password on the checkout page and Please enter a valid email address. error messages are displayed");
		}else {
			test.pass("Not navigated to login page");
			logger.info("Not navigated to login page");
		}
 	}
 	
 	public static void verifyemptyEmailandInvalidPassword() {
 		test.info("Verify empty Email and Invalid password input on the checkout page");
 		if(Actionsss.displayElement(CP.getemptyLoginError())) {
			test.pass("Successfully Clicked on Login button with entering Invalid email and Invalid password on the checkout page and This field is required error messages are displayed");
			logger.info("Successfully Clicked on Login button with entering Invalid email and Invalid password on the checkout page and This field is required error messages are displayed");
		}else {
			test.pass("Not navigated to login page");
			logger.info("Not navigated to login page");
		}
 	}
 	
 	//View cart btn in mini cart
 	 	public static void VerifyValidEmailandPasswordInput() {
 	 		test.info("Verify login with valid Inputs");
 	     	if (Actionsss.countofElements(SDP.getshippingPageList())) {
 	     	    logger.info("Successfully entered the valid inputs and clicked on the Login button and Navigated to the Shipping page");
 	     	    test.pass("Successfully entered the valid inputs and clicked on the Login button and Navigated to the Shipping page");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
 	 	
 	 	//View cart btn in mini cart
 	 	public static void VerifySingUpLink() {
 	 		test.info("Verify Sign Up link");
 	     	if (Actionsss.displayElement(CP.getsignUpHeader())) {
 	     	    logger.info("Successfully clicked on the SignUp button and Navigated to the Create Account page");
 	     	    test.pass("Successfully clicked on the SignUp button and Navigated to the Create Account page");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
 	 	
 	 	//forgot password validation
 	 	public static void VerifyforgotpasswordPOPUP() throws InterruptedException {
 	 		test.info("Verify forgot password link");
 	 		Thread.sleep(3000);
 	     	if (Actionsss.displayElement(CP.getforgotPasswordHeaderone())) {
 	     	    logger.info("Successfully clicked on the forgot password link and POPUP window is displayed");
 	     	    test.pass("Successfully clicked on the forgot password link and POPUP window is displayed");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
 	 	
 	 	public static void VerifyemptyEmailforgotpasswordPOPUP() {
 	 		test.info("Verify empty email input of forgot password");
 	     	if (Actionsss.displayElement(CP.getforgotpasswordemptyerror())) {
 	     	    logger.info("Successfully clicked on the send button without entering details and This field is required error is diplayed");
 	     	    test.pass("Successfully clicked on the send button without entering details and This field is required error is diplayed");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
 	 	
	 	public static void VerifyinvalidEmailforgotpasswordPOPUP() throws InterruptedException {
 	 		test.info("Verify invalid email input of forgot password");
 	 		Thread.sleep(3000);
 	     	if (Actionsss.displayElement(CP.getinvalidEmailError())) {
 	     	    logger.info("Successfully clicked on the send button with invalid email entering and Please enter a valid email error is diplayed");
 	     	    test.pass("Successfully clicked on the send button with invalid email entering and Please enter a valid email error is diplayed");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
	 	
	 	public static void VerifyinvalidEmailforgotpasswordPOPUPWL() {
 	 		test.info("Verify invalid email input of forgot password");
 	     	if (Actionsss.displayElement(CP.getforgotpasswordInvaliderror())) {
 	     	    logger.info("Successfully clicked on the send button with invalid email entering and Please enter a valid email error is diplayed");
 	     	    test.pass("Successfully clicked on the send button with invalid email entering and Please enter a valid email error is diplayed");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
	 	
	 	public static void VerifyforgotpasswordPOPUPLogin() {
 	 		test.info("Verify forgot password Login btn");
 	     	if (!Actionsss.displayElement(CP.getforgotPasswordHeaderone())) {
 	     	    logger.info("Successfully clicked on the forgot password Login button and POPUP window is closed");
 	     	    test.pass("Successfully clicked on the forgot password Login button and POPUP window is closed");
 	     	}else {
 	     		test.fail("Click failed");
 	     	}
 	 	}
	 	
 	 	
 	
 	
 	
}
