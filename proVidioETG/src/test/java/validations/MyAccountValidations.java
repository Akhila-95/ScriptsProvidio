package validations;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import baseClass.baseClass;
import functionality.Actionsss;
import functionality.Waits;
import pageObjects.MyAccountPage;
import pageObjects.PaymentPage;
import pageObjects.ShippingAddressPage;

public class MyAccountValidations extends baseClass{
	
	// Initializing MyAccountPage instance
	private static MyAccountPage MAC = new MyAccountPage(driver);

	private static PaymentPage pp = new PaymentPage(driver);
	
	// Method to verify user clicked on My Account link
	public static void verifyuserClickedonMyAccount() {
		test.info("Verify weather the user is able to click My Account link");
	    
	    // Use FluentWait to wait for the visibility of the "Dashboard" element
	    Wait<WebDriver> wait = Waits.createFluentWait(driver);
	    WebElement loginTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //h1[@class ='account-page-title']")));
	    
	    // Get the actual title from the "Dashboard" element
	    String expectedTitle = "Dashboard";
	    String actualTitle = loginTitle.getText();
	    
	    // Check if the actual title matches the expected title
	    if (actualTitle.equals(expectedTitle)) {
	    	// Log a pass message if the user is logged in successfully
	    	test.pass("Successfully User Loged In (or)Clicked on the My Account Link (or) backtoMyAccount link and Navigated to the myaccountpage");
	        logger.info("Successfully User Loged In (or)Clicked on the My Account Link (or) backtoMyAccount link and Navigated to the myaccountpage");
	    } else {
	    	// Log a fail message if the page title does not match the expected title
	    	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
	        logger.info("Click failed");
	    }
	}
	
	// Method to verify user clicked on My Order link
	public static void verifyuserClickedonMyOrder() {
		test.info("Verify weather the user is able to click My Order link");
	    
	    // Use FluentWait to wait for the visibility of the "Order History" element
	    Wait<WebDriver> wait = Waits.createFluentWait(driver);
	    WebElement loginTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //h2[text()='Order History']")));
	    
	    // Get the actual title from the "Order History" element
	    String expectedTitle = "Order History";
	    String actualTitle = loginTitle.getText();
	    
	    // Check if the actual title matches the expected title
	    if (actualTitle.equals(expectedTitle)) {
	    	// Log a pass message if the user is logged in successfully
	    	test.pass("Successfully Clicked on the My Order Link and Navigated to the myOrderpage");
	        logger.info("Successfully Clicked on the My Order Link and Navigated to the myOrderpage");
	    } else {
	    	// Log a fail message if the page title does not match the expected title
	    	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
	        logger.info("Click failed");
	    }
	}
	
	// Method to verify edit profile link in My Account page
	public static void verifyeditprofile() {
		test.info("Verifying edit profile link in my account page");
		if(Actionsss.countofElements(MAC.geteditProfileHeader())) {
			test.pass("Successfully Clicked on the Edit link and Navigated to the edit profile page");
	        logger.info("Successfully Clicked on the Edit link and Navigated to the edit profile page");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
	
	// Method to verify edit profile with empty fields
	public static void verifyeditprofileemptyfields() {
		test.info("Verifying edit profile empty form");
		if(Actionsss.getSizeOfList(MAC.geteditProfileemptyErrors()) == 5) {
			test.pass("Successfully Clicked on the save button and Errors are displayed.");
	        logger.info("Successfully Clicked on the save button and Errors are displayed.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
	
	// Method to verify edit profile with invalid phone
	public static void verifyeditprofileInvalidPhone() {
		test.info("Verifying edit profile Invalid phone");
		if(Actionsss.displayElement(MAC.getinvalidPhone())) {
			test.pass("Successfully Clicked on the save button with invalid phone and Error is displayed.");
	        logger.info("Successfully Clicked on the save button with invalid phone and Error is displayed.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
	
	// Method to verify edit profile with invalid email
	public static void verifyeditprofileInvalidEmail() {
		test.info("Verifying edit profile Invalid email");
		if(Actionsss.displayElement(MAC.getemailFormatError())) {
			test.pass("Successfully Clicked on the save button with invalid email and Error is displayed.");
	        logger.info("Successfully Clicked on the save button with invalid email and Error is displayed.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
	
	// Method to verify email mismatch
	public static void MissmatchMail() {
		test.info("Verify Email mismatch");
	    // Check if the already exists email error is displayed
	    if (Actionsss.displayElement(MAC.getSameMailError())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(MAC.getSameMailError()));
	        logger.info("Successfully Error message is displayed");
	    } else {
	        logger.info("Test case failed");
	    }
	}
	
	// Method to verify password and email mismatch
	public static void MissPWDEMail() {
		test.info("Verify Password and Email mismatch");
	    // Check if the password and email mismatch error is displayed
	    if (Actionsss.displayElement(MAC.getPasswordMismatchError())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(MAC.getPasswordMismatchError()));
	        logger.info("Successfully Error message is displayed");
	    } else {
	        logger.info("Test case failed");
	    }
	}
	
 	// Method to verify click on the Home logo
 	public static void verifyClickOnLogo() {
 		test.info("Verify Home click on the my account page");
 		List<WebElement> Herobanners = driver.findElements(By.xpath("//div[@class='hero-banner-overlay-wrapper']"));
 		if (Herobanners.size() > 0 ) {
 			logger.info("Successfully Clicked on the Home Link or Logo and Navigated to the Home page");
     	    test.pass("Successfully Clicked on the Home Link or Logo and Navigated to the Home page");
     	} else {
     		test.fail("Click failed");
     	}
 	}
 	
 	// Method to verify change password page
 	public static void verifychangepasswordpage() {
		test.info("Verifying change password page");
		if(Actionsss.countofElements(MAC.getchangePWDHeader())) {
			test.pass("Successfully Clicked on the change password and Navigated to the change password page.");
	        logger.info("Successfully Clicked on the change password and Navigated to the change password page.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
 	
 	// Method to verify change password error page with empty fields
	public static void verifychagepasswordemptyfields() {
		test.info("Verifying change password empty form");
		if(Actionsss.getSizeOfList(MAC.getchangePWDError()) == 3) {
			test.pass("Successfully Clicked on the save button and Errors are displayed.");
	        logger.info("Successfully Clicked on the save button and Errors are displayed.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
	
	// Method to verify current password mismatch error
	public static void MissPWDeMailchange() {
		test.info("Verify Password and Email mismatch in change password");
	    // Check if the password and email mismatch error is displayed
	    if (Actionsss.displayElement(MAC.getPasswordMismatchError())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(MAC.getPasswordMismatchError()));
	        logger.info("Successfully Error message is displayed");
	    } else {
	        logger.info("Test case failed");
	    }
	}
	
	// Method to verify mismatched passwords error
	public static void missmatchpwd() {
		test.info("Verify Mismatched passwords");
	    // Check if the mismatched passwords error is displayed
	    if (Actionsss.displayElement(MAC.getsamepwdError())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(MAC.getsamepwdError()));
	        logger.info("Successfully Error message is displayed");
	    } else {
	        logger.info("Test case failed");
	    }
	}
	
	
	//address book
 	public static void verifyAddressbookpage() throws InterruptedException {
		test.info("Verifying view address book page");
		Thread.sleep(2000);
		if(Actionsss.countofElements(MAC.getaddressbookHeader())) {
			test.pass("Successfully Clicked on the View Address and Navigated to the View Address book page.");
	        logger.info("Successfully Clicked on the View Address and Navigated to the View Address book page.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
 	
 	//delete button
 	public static void addressDeletebutton() {
 		test.info("Verifying Delete address in the  address book page");
 		if(Actionsss.countofElements(MAC.getremoveBtnHeader())) {
 			test.pass("Successfully clicked on the cancel button in the  address book page");
 			logger.info("Successfully clicked on the cancel button in the  address book page");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
 		
 	}
 	
	//delete button
 	public static void addresscancelbutton() {
 		test.info("Verifying Delete address in the  address book page");
 		if(!Actionsss.countofElements(MAC.getremoveBtnHeader())) {
 			test.pass("Successfully clicked on the cancel button in the  address book page");
 			logger.info("Successfully clicked on the cancel button in the  address book page");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
 		
 	}
	//delete button
 	public static void addresspopupclosebutton() {
 		test.info("Verifying Delete address in the  address book page");
 		test.pass("Successfully clicked on the popup cancel button in the  address book page");
 	}
 	//make as default
 	public static void makeasDefault() {
 		test.info("Verifying Make one address as a default address in the  address book page");
 		test.pass("Successfully clicked on the Make one address as a default address in the  address book page");
 	}
 	
 	public static void verifyeditAddressbookpage() {
		test.info("Verifying edit address page");
		if(Actionsss.countofElements(MAC.getaddressbookHeader())) {
			test.pass("Successfully Clicked on the edit Address and Navigated to the edit Address  page.");
	        logger.info("Successfully Clicked on the edit Address and Navigated to the edit Address  page.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
 	
 	public static void verifyeditAddressemptyformpage() {
		test.info("Verifying edit address empty form");
		if(Actionsss.displayElement(MAC.getFirstNameErrorMsg()) && Actionsss.displayElement(MAC.getlastNameErrorMsg()) && Actionsss.displayElement(MAC.getAddress1ErrorMsg()) && Actionsss.displayElement(MAC.getphoneNumberErrorMsg())) {
			test.pass("Successfully Clicked on the Save button and Error messages are displayed");
	        logger.info("Successfully Clicked on the Save button and Error messages are displayed");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
 	
 	public static void firstNameError() throws Exception {
		test.info("Verify first name field error in edit Address Page");
		if(Actionsss.displayElement(MAC.getFirstNameErrorMsg())) {
			test.pass("Successfully the error message is displayed for first name.");
			logger.info("Successfully the error message is displayed for first name.");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
	
	public static void lastNameError() throws Exception {
	
		test.info("Verify Last name field error in in edit Address Page");
		Thread.sleep(1000);
		if(Actionsss.displayElement(MAC.getlastNameErrorMsg())) {
			test.pass("Successfully  the error messages are displayed for last name.");
			logger.info("Successfully the error messages are displayed for last name.");
		}else {
			test.fail("No error messages are displayed for last name.");
			logger.info("No error messages are displayed for last name.");
		}
	}
	
	public static void addressMessageError() throws Exception {
		
		test.info("Verify Address field error in in edit Address Page");
		Thread.sleep(1000);
		if(Actionsss.displayElement(MAC.getAddress1ErrorMsg())){
			test.pass("Successfully the error messages are displayed for shipping address");
			logger.info("Successfully the error messages are displayed for shipping address");
		}else {
			test.fail("No error messages are displayed for shipping address");
			logger.info("No the error messages are displayed for shipping address");
		}
		
	}
	
	public static void phoneNumberError() throws Exception {
		test.info("Verify Phone number field error in in edit Address Page");
		if(Actionsss.displayElement(MAC.getphoneNumberErrorMsg())) {
			test.pass("Successfully the error messages is displayed for  phone number");
			logger.info("Successfully the error messages is displayed for  phone number");
		}else {
			test.fail("No error messages are displayed for  phone number");
			logger.info("No the error messages are displayed for  phone number");
		}
	}
	
	
	//add new address page
	public static void addnewAddressPage() {
		test.info("Verifying add address page");
		if(Actionsss.countofElements(MAC.getaddnewAddressHeader())) {
			test.pass("Successfully Clicked on the add new Address and Navigated to the add new Address page.");
	        logger.info("Successfully Clicked on the add new Address and Navigated to the add new Address page.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
	
	//empty form
 	public static void verifyAddNewAddressemptyformpage() {
		test.info("Verifying edit address empty form");
		if(Actionsss.displayElement(MAC.getaddressTitleErrorMsg())&&Actionsss.displayElement(MAC.getFirstNameErrorMsg()) && Actionsss.displayElement(MAC.getlastNameErrorMsg()) && Actionsss.displayElement(MAC.getAddress1ErrorMsg()) && Actionsss.displayElement(MAC.getphoneNumberErrorMsg())) {
			test.pass("Successfully Clicked on the Save button and Error messages are displayed");
	        logger.info("Successfully Clicked on the Save button and Error messages are displayed");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
 	
 	public static void addressTitleError() throws Exception {
		test.info("Verify Address title in Add New address page");
		if(Actionsss.displayElement(MAC.getaddressTitleErrorMsg())) {
			test.pass("Successfully the error message is displayed for Address Title.");
			logger.info("Successfully the error message is displayed for Address Title.");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
 	
 	public static void addressTitleAlreadyExitsError() throws Exception {
		test.info("Verify Address title error Already exits in Add New address page");
		if(Actionsss.elementSize(MAC.getaddressTitleAlreadyExistsErrorMsgList())) {
			if(Actionsss.displayElement(MAC.getaddressTitleAlreadyExistsErrorMsg())) {
				test.pass("Successfully the error message is displayed for Address Title Already Exists.");
				logger.info("Successfully the error message is displayed for Address Title Already Exists.");
			}else {
				test.fail("No error messages are displayed for first name.");
				logger.info("No error messages are displayed for first name.");
			}	
		}
	}
 	
 	public static void addNewAddressfirstNameError() throws Exception {
		test.info("Verify first name field error in edit Address Page");
		if(Actionsss.displayElement(MAC.getFirstNameErrorMsg())) {
			test.pass("Successfully the error message is displayed for first name.");
			logger.info("Successfully the error message is displayed for first name.");
		}else {
			test.fail("No error messages are displayed for first name.");
			logger.info("No error messages are displayed for first name.");
		}	
	}
	
	public static void addNewAddresslastNameError() throws Exception {
	
		test.info("Verify Last name field error in in edit Address Page");
		Thread.sleep(1000);
		if(Actionsss.displayElement(MAC.getlastNameErrorMsg())) {
			test.pass("Successfully  the error messages are displayed for last name.");
			logger.info("Successfully the error messages are displayed for last name.");
		}else {
			test.fail("No error messages are displayed for last name.");
			logger.info("No error messages are displayed for last name.");
		}
	}
	
	public static void addNewAddressaddressMessageError() throws Exception {
		
		test.info("Verify Address field error in in edit Address Page");
		Thread.sleep(1000);
		if(Actionsss.displayElement(MAC.getAddress1ErrorMsg())){
			test.pass("Successfully the error messages are displayed for shipping address");
			logger.info("Successfully the error messages are displayed for shipping address");
		}else {
			test.fail("No error messages are displayed for shipping address");
			logger.info("No the error messages are displayed for shipping address");
		}
		
	}
	
	public static void addNewAddressphoneNumberError() throws Exception {
		test.info("Verify Phone number field error in in edit Address Page");
		if(Actionsss.displayElement(MAC.getphoneNumberErrorMsg())) {
			test.pass("Successfully the error messages is displayed for  phone number");
			logger.info("Successfully the error messages is displayed for  phone number");
		}else {
			test.fail("No error messages are displayed for  phone number");
			logger.info("No the error messages are displayed for  phone number");
		}
	}
 	
	//oder history page
	public static void orderHistoryPage() {
		test.info("Verifying Order History page");
		if(Actionsss.countofElements(MAC.getviewOrderHistoryHeader())) {
			test.pass("Successfully Clicked on the View Order history link and Navigated to the Order history page.");
	        logger.info("Successfully Clicked on the View Order history link and Navigated to the Order history page.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
	
	//order details page
	public static void orderdetailsPage() {
		test.info("Verifying Order History page");
		if(Actionsss.countofElements(MAC.getvieworderHeader())) {
			test.pass("Successfully Clicked on the View Order link and Navigated to the Order detail page.");
	        logger.info("Successfully Clicked on the View Order link and Navigated to the Order detail page.");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
	
	public static void verifyPLPProductClick() {
 		test.info("verify product link");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
     	
     	if (pdpPage.isDisplayed()) {
     	    logger.info("Successfully clicked on the Product link and Navigated to the Product detail page");
     	    test.pass("Successfully clicked on the Product link and Navigated to the Product detail page");
     	}else {
     		test.fail("Click failed");
     	}
     	
	}
	
	//delete button
 	public static void removefromWishlistbutton() {
 		test.info("Verifying Remove a Prodcut form the MyAccount page wishlist");
 		test.pass("Successfully clicked on the removed button  and Prodcut is from the MyAccount page wishlit");
 	}
 	
 	public static void facebooklinkfromWishlistbutton() {
 		test.info("Verifying facebook link in WishList Page In MyAccount Page");
 		test.pass("Successfully clicked on the facebook link and Navigated to the Facebook page");
 	}
 	public static void twitterlinkfromWishlistbutton() {
 		test.info("Verifying twitter link in WishList Page In MyAccount Page");
 		test.pass("Successfully clicked on the twitter link and Navigated to the twitter page");
 	}
 	public static void pintersetsfromWishlistbutton() {
 		test.info("Verifying pintersets link in WishList Page In MyAccount Page");
 		test.pass("Successfully clicked on the pintersets link and Navigated to the pintersets page");
 	}
 	public static void gmailfromWishlistbutton() {
 		test.info("Verifying gmail link in WishList Page In MyAccount Page");
 		test.pass("Successfully clicked on the gmail link and Navigated to the gmail page");
 	}
 	
 	public static void copyfromWishlistbutton() {
 		test.info("Verifying copy link in WishList Page In MyAccount Page");
 		test.pass("Successfully clicked on the copy link and copied message is displayed");
 	}
	
 	////////////////////////////////////////////////////////////////////////////////////////////
 	
	public static void verifyaddNewlinkClick() {
 		test.info("verify add new link of BrainTree Credit Card");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
 		WebElement form = driver.findElement(By.xpath("//div[@class ='braintree-account-add-credit-card-content']//form"));
     	if (form.isDisplayed()) {
     	    logger.info("Successfully clicked on the Add New link and Credit card form is Opened");
     	    test.pass("Successfully clicked on the Add New link and Credit card form is Opened");
     	}else {
     		test.fail("Click failed");
     	}
	}
	
	public static void verifyerrormessage() {
 		test.info("verify Empty form BrainTree Credit Card");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
 		WebElement form = driver.findElement(By.xpath("//div[text()='Please enter valid credit card details.']"));
     	if (form.isDisplayed()) {
     	    logger.info("Successfully clicked on the Save button and Error message is displayed");
     	    test.pass("Successfully clicked on the Save button and Error message is displayed");
     	}else {
     		test.fail("Click failed");
     	}
	}
	
	public static void verifyalreadyerrormessage() {
 		test.info("verify already card exists error BrainTree Credit Card");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
 		WebElement alredyerror = driver.findElement(By.xpath("//div[text()='Entered card is already added to the payments list.']"));
     	if (alredyerror.isDisplayed()) {
     	    logger.info("Successfully clicked on the Save button with already exists credit card and Error message is displayed");
     	    test.pass("Successfully clicked on the Save button with already exists credit card and Error message is displayed");
     	}else {
     		test.fail("Click failed");
     	}
	}
	
 	public static void remove() {
 		test.info("Verifying Remove card In MyAccount Page");
 		test.pass("Successfully clicked on the remove link and Card Removed successfully");
 	}
 	
 	public static void makeasaDefult() {
 		test.info("Verifying makeasaDefult In MyAccount Page");
 		test.pass("Successfully clicked on the makeasaDefult link and Card makeasaDefult successfully");
 	}
 	
 	
 	
 	//-----------------------------------------------------------------------------------------------------
	public static void stripePage() {
		test.info("Verifying stripe form and payment page");
		if(Actionsss.countofElements(MAC.getstripeformlist())) {
			test.pass("Successfully Clicked on the Add new link and Navigated to the Credit Card page.");
	        logger.info("Successfully Clicked on the Add new link and Navigated to the Credit Card page.");
		} else {
			test.pass("Stripe payment Method is currently Not in Activate Mode");
			logger.info("Failed");
		}
	}
	
	public static void cybersourcePage() {
		test.info("Verifying stripe form and payment page");
		if(Actionsss.countofElements(MAC.getCybersource())) {
			test.pass("Successfully Clicked on the Add new link and Navigated to the Credit Card page.");
	        logger.info("Successfully Clicked on the Add new link and Navigated to the Credit Card page.");
		} else {
			test.pass("Cybersurce payment Method is currently Not in Activate Mode");
			logger.info("Failed");
		}
	}
	
	public static void stripeEmptyForm() throws InterruptedException {
		test.info("Verifying stripe Empty form and payment page");
		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert
		String alertMessage = alert.getText();
		String actualValue = alertMessage;
		String expectedValue = "Your card number is incomplete.";
		logger.info(actualValue);
		if(actualValue.equals(expectedValue)) {
			test.pass("Successfully Clicked on the save card without entering details and pop up error message is displayed");
	        logger.info("Successfully Clicked on the save card without entering details and pop up error message is displayed");
		}else {
			logger.info("failed");
		}
		// Click OK button
		Thread.sleep(2000);
		alert.accept();	
	}
	
	public static void invalidCardForm() throws InterruptedException {
		test.info("Verifying stripe Empty form and payment page");
		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert
		String alertMessage = alert.getText();
		String actualValue = alertMessage;
		String expectedValue = "Your card number is invalid.";
		logger.info(actualValue);
		if(actualValue.equals(expectedValue)) {
			test.pass("Successfully Clicked on the save card with entering Invalid Card number and pop up error message is displayed");
	        logger.info("Successfully Clicked on the save card with entering Invalid Card number and pop up error message is displayed");
		}else {
			logger.info("failed");
		}
		// Click OK button
		Thread.sleep(2000);
		alert.accept();	
	}
	public static void emptyexpDate() throws InterruptedException {
		test.info("Verifying stripe Empty form and payment page");
		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert
		String alertMessage = alert.getText();
		String actualValue = alertMessage;
		String expectedValue = "Your card's expiration date is incomplete.";
		logger.info(actualValue);
		if(actualValue.equals(expectedValue)) {
			test.pass("Successfully Clicked on the save card without entering details and pop up error message is displayed");
	        logger.info("Successfully Clicked on the save card without entering details and pop up error message is displayed");
		}else {
			logger.info("failed");
		}
		// Click OK button
		Thread.sleep(2000);
		alert.accept();	
	}
	
	public static void EemptyCVV() throws InterruptedException {
		test.info("Verifying stripe Empty form and payment page");
		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert
		String alertMessage = alert.getText();
		String actualValue = alertMessage;
		String expectedValue = "Your card's security code is incomplete.";
		logger.info(actualValue);
		if(actualValue.equals(expectedValue)) {
			test.pass("Successfully Clicked on the save card without entering details and pop up error message is displayed");
	        logger.info("Successfully Clicked on the save card without entering details and pop up error message is displayed");
		}else {
			logger.info("failed");
		}
		// Click OK button
		Thread.sleep(2000);
		alert.accept();	
	}
	
	public static void EmptyZip() throws InterruptedException {
		test.info("Verifying stripe Empty form and payment page");
		// Switch to the alert
		Alert alert = driver.switchTo().alert();
		// Get the text of the alert
		String alertMessage = alert.getText();
		String actualValue = alertMessage;
		String expectedValue = "Your postal code is incomplete.";
		logger.info(actualValue);
		if(actualValue.equals(expectedValue)) {
			test.pass("Successfully Clicked on the save card without entering details and pop up error message is displayed");
	        logger.info("Successfully Clicked on the save card without entering details and pop up error message is displayed");
		}else {
			logger.info("failed");
		}
		// Click OK button
		Thread.sleep(2000);
		alert.accept();	
	}
	
	//valid submit
	public static void verifyvalidsubmit() {
 		test.info("verify valid details and save stripe Credit Card");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
 		WebElement paymentpage = driver.findElement(By.xpath("//div[@class='paymentInstruments mt-5']"));
     	if (paymentpage.isDisplayed()) {
     	    logger.info("Successfully clicked on the Save button with valid credit card detals and Navigated to the payment page in my account");
     	    test.pass("Successfully clicked on the Save button with valid credit card detals and Navigated to the payment page in my account");
     	}else {
     		test.fail("Click failed");
     	}
	}
	
 	public static void removecancel() {
 		test.info("Verifying Remove card pop up cancel button In MyAccount Page");
 		test.pass("Successfully clicked on the remove link, popup is displayed and cancel button is clicked and  popup closed");
 	}
 	
 	public static void removeok() {
 		test.info("Verifying Remove card pop up ok button In MyAccount Page");
 		test.pass("Successfully clicked on the remove link, popup is displayed and ok button is clicked and  deleted the card");
 	}
 	
 	//----------------------------------------------------------------------------------
 	
 	public static void verifyemptyInput() {
		test.info("Verifying empty input of giftcard");
		if(Actionsss.displayElement(MAC.getemptyError())) {
			test.pass("Successfully Clicked on the apply button with empty giftcard input and Error messaage is displayed as "+Actionsss.getTextOfElement(MAC.getemptyError()));
	        logger.info("Successfully Clicked on the apply button with empty giftcard input and Error messaage is displayed as "+Actionsss.getTextOfElement(MAC.getemptyError()));
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
 	}
 	
 	public static void verifyInvalidInput() {
		test.info("Verifying Invalid input of giftcard");
		if(Actionsss.displayElement(MAC.getinvalidError())) {
			test.pass("Successfully Clicked on the apply button with invalid giftcard input and Error messaage is displayed as "+Actionsss.getTextOfElement(MAC.getinvalidError()));
	        logger.info("Successfully Clicked on the apply button with invalid giftcard input and Error messaage is displayed as "+Actionsss.getTextOfElement(MAC.getinvalidError()));
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
 	}
 	
 	public static void verifydifferentUserInput() {
		test.info("Verifying different user input of giftcard");
		if(Actionsss.displayElement(MAC.getdifferentUserError())) {
			test.pass("Successfully Clicked on the apply button with different user giftcard input and Error messaage is displayed as "+Actionsss.getTextOfElement(MAC.getdifferentUserError()));
	        logger.info("Successfully Clicked on the apply button with different user giftcard input and Error messaage is displayed as "+Actionsss.getTextOfElement(MAC.getdifferentUserError()));
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
 	}
 	
 	public static void verifyInsfficientInput() {
		test.info("Verifying insufficient funds  input of giftcard");
		if(Actionsss.displayElement(MAC.getinsufficientError())) {
			test.pass("Successfully Clicked on the apply button with Insufficinet giftcard input and Error messaage is displayed as "+Actionsss.getTextOfElement(MAC.getinsufficientError()));
	        logger.info("Successfully Clicked on the apply button with Insufficinet giftcard input and Error messaage is displayed as "+Actionsss.getTextOfElement(MAC.getinsufficientError()));
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
 	}
 	
 	public static void validcard() {
 	// Find the balance element again (after adding new card)
        WebElement updatedBalanceElement = driver.findElement(By.xpath("//span[@class='balAmount']"));
        // Get the updated text of the balance element
        String updatedBalanceText = updatedBalanceElement.getText();
        // Convert updated balance text to integer (remove non-numeric characters)
        
        int updatedBalance = parseBalance(updatedBalanceText);
        logger.info(updatedBalance);
        // Compare the original balance with the updated balance
        if (updatedBalance > originalBalance) {
            test.pass("New card added successfully. Balance increased.");
            logger.info("New card added successfully. Balance increased.");
        } else {
            System.out.println("Balance remains the same after adding new card.");
        }
 	}
 	
 // Method to parse balance text and extract integer value
    private static int parseBalance(String balanceText) {
        try {
            // Remove non-numeric characters and parse to integer
            return Integer.parseInt(balanceText.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            System.err.println("Error parsing balance text: " + e.getMessage());
            return 0; // Return 0 if unable to parse
        }
    }
    
    //------------------------------balance check ----------------------------------
    public static void emptybalancechecck() {
        WebElement balanceElement = driver.findElement(By.xpath("//div[@class='balance success']"));
        // Get the text of the balance element
        String balanceText = balanceElement.getText();
        // Convert balance text to integer (remove non-numeric characters)
        int amount = Integer.parseInt(balanceText.replaceAll("[^0-9]", ""));
        logger.info(amount);
        if(amount==0) {
        	test.pass("Successfully Clicked on the Check balance button with zero balance gift card and balance zero is displayed");
	        logger.info("Successfully Clicked on the Check balance button with zero balance gift card and balance zero is displayed");
        }else {
			test.fail("Failed");
			logger.info("Failed");
        }
    }
    
    public static void balancechecck() {
        WebElement balanceElement = driver.findElement(By.xpath("//div[@class='balance success']"));
        // Get the text of the balance element
        String balanceText = balanceElement.getText();
        // Convert balance text to integer (remove non-numeric characters)
        int amount = Integer.parseInt(balanceText.replaceAll("[^0-9]", ""));
        if(amount > 0) {
        	test.pass("Successfully Clicked on the Check balance button with  balance gift card and balance  is displayed");
	        logger.info("Successfully Clicked on the Check balance button with  balance gift card and balance  is displayed");
        }else {
			test.fail("Failed");
			logger.info("Failed");
        }
    }

    
    //------------------------------Cyber soure----------------------------------------
    
    public static void verifyemptyCybersourceform() {
		test.info("Verifying empty form of cybersource credit card");
		if(Actionsss.getSizeOfList(MAC.getemptyerror()) == 2 && Actionsss.getSizeOfList(MAC.getdropemptyerror()) == 2) {
			test.pass("Successfully Clicked on the Save button and Error messages are displayed");
	        logger.info("Successfully Clicked on the Save button and Error messages are displayed");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
    
    public static void verifynameCybersourceform() {
		test.info("Verifying name of cybersource credit card");
		if(Actionsss.countofElements(MAC.getemptyerror())) {
			test.pass("Successfully Clicked on the Save button and Error messages are displayed");
	        logger.info("Successfully Clicked on the Save button and Error messages are displayed");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
    
    public static void verifynumberCybersourceform() {
		test.info("Verifying number of cybersource credit card");
		if(Actionsss.getSizeOfList(MAC.getdropemptyerror()) == 2) {
			test.pass("Successfully Clicked on the Save button and Error messages are displayed");
	        logger.info("Successfully Clicked on the Save button and Error messages are displayed");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
    
    public static void verifyExpCybersourceform() {
		test.info("Verifying EXP of cybersource credit card");
		if(Actionsss.countofElements(MAC.getdropemptyerror())) {
			test.pass("Successfully Clicked on the Save button and Error messages are displayed");
	        logger.info("Successfully Clicked on the Save button and Error messages are displayed");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
	}
    
 	public static void verifyinvalidnumnerInput() {
		test.info("Verifying invalid card number of cybersource credit card");
		if(Actionsss.displayElement(MAC.getcybersourcenumberInvalid())) {
			test.pass("Successfully Clicked on the Save button and Error messages are displayed");
	        logger.info("Successfully Clicked on the Save button and Error messages are displayed");
		} else {
			test.fail("Failed");
			logger.info("Failed");
		}
 	}
 	
}
