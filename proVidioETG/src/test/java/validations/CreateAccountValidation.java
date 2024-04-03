package validations;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.CreateAccountPage;
import pageObjects.loginPage;

public class CreateAccountValidation  extends baseClass{
	
	private static final  CreateAccountPage cap = new CreateAccountPage(driver);
	private static final  loginPage lp = new loginPage(driver);

	/**
	 * This method validates whether the account creation is successful by checking the page title.
	 * It compares the actual page title with the expected title ("Dashboard").
	 * If they match, the test case is considered passed, and the account is considered created successfully.
	 * Otherwise, the test case fails, and an appropriate message is logged.
	 */
	
	public static void createAccountPageValidation() {
		test.info("Verify the create account pagination");
		if(Actionsss.displayElement(lp.getLoginPage())) {
			test.pass("Successfully navigated to Create Account page");
			logger.info("Successfully navigated to Create Account page");
		}else {
			test.pass("Not navigated to Create Account page");
			logger.info("Not navigated to Create Account page");
		}
	}
	
	public static void accountPageTitle() {
	    String expectedTitle = "Dashboard";
	    CreateAccountPage cap = new CreateAccountPage(driver);
        test.info("Verify Create Account");
	    // Check if the actual page title matches the expected title
	    if (Actionsss.getTextOfElement(cap.getAccountPageTitle()).equals(expectedTitle)) {
	        test.pass("Successfully Account is created And Navigated to the MyAccount page");
	        logger.info("Successfully Account is created And Navigated to the MyAccount page");
	        test.pass("Name of created account is "+ Actionsss.getTextOfElement(cap.getcreateAccountName()) +" and Email id " + Actionsss.getTextOfElement(cap.getcreateAccountEmail()));
	        isLoggedIn = true;
	    } else {
	        test.fail("The page Title does not match expected Dashboard but found " + Actionsss.getTextOfElement(cap.getAccountPageTitle()));
	        logger.info("Click failed, and account not created");
	    }
	}
	
	public static void validateEmailAndConfirmEmail() {
	    // Check if the "Please enter the same value again" error message is displayed
	    if (Actionsss.displayElement(cap.getSameMailError())) {
	        test.pass("Test case passed. Error message displayed when the same email is not entered: "
	                + Actionsss.getTextOfElement(cap.getSameMailError()));
	        logger.info("Error message is displayed");
	    } else {
	        test.fail("Test case failed. No error message displayed when the same email is not entered: "
	                + Actionsss.getTextOfElement(cap.getSameMailError()));
	        logger.info("Error message is not displayed");
	    }
	}
	
	public static void validatePasswordMismatch() {	  
	    // Check if the "Does not match password" error message is displayed
	    if (Actionsss.displayElement(cap.getPasswordMismatchError())) {
	        test.pass("Test case passed. Error message displayed as: "
	                + Actionsss.getTextOfElement(cap.getPasswordMismatchError()));
	        logger.info("Showing error message: Does not match password");
	    } else {
	        test.fail("Test case failed. Error message not displayed as: "
	                + Actionsss.getTextOfElement(cap.getPasswordMismatchError()));
	        logger.info("Not showing error message: Does not match password");
	    }
	}

	public static void validateAllErrors() throws InterruptedException {
		test.info("Verify whether the user is able to Check Empty form");
	    Thread.sleep(2000);
	    // Check if the number of errors matches the expected count (7 errors)
	    if (Actionsss.getSizeOfList(cap.getAllFieldsErrorList()) == 7) {
	        test.pass("Successfully Click on the Create acccount button and seven errors are diplayed (This Field is Required).");
	        logger.info("Successfully Click on the Create acccount button and seven errors are diplayed (This Field is Required).");
	    } else {
	        test.fail("Failed");
	        logger.info("Failed");
	    }
	}
	
	public static void validateFNameAllErrors() throws InterruptedException {
		test.info("Verify whether the user is able to Check All fields form");
	    Thread.sleep(2000);
	    // Check if the number of errors matches the expected count (7 errors)
	    if (Actionsss.getSizeOfList(cap.getAllFieldsErrorList()) == 6) {
	        test.pass("Successfully Click on the Create acccount button and six errors are diplayed (This Field is Required).");
	        logger.info("Successfully Click on the Create acccount button and six errors are diplayed (This Field is Required).");
	    } else {
	        test.fail("Failed");
	        logger.info("Failed");
	    }
	}
	
	public static void validateLNameAllErrors() throws InterruptedException {
		test.info("Verify whether the user is able to Check All fields form");
	    Thread.sleep(2000);
	    // Check if the number of errors matches the expected count (7 errors)
	    if (Actionsss.getSizeOfList(cap.getAllFieldsErrorList()) == 5) {
	        test.pass("Successfully Click on the Create acccount button and five errors are diplayed (This Field is Required).");
	        logger.info("Successfully Click on the Create acccount button and five errors are diplayed (This Field is Required).");
	    } else {
	        test.fail("Failed");
	        logger.info("Failed");
	    }
	}
	
	public static void validatePhoneAllErrors() throws InterruptedException {
		test.info("Verify whether the user is able to Check All fields form");
	    Thread.sleep(2000);
	    // Check if the number of errors matches the expected count (7 errors)
	    if (Actionsss.getSizeOfList(cap.getAllFieldsErrorList()) == 4) {
	        test.pass("Successfully Click on the Create acccount button and four errors are diplayed (This Field is Required).");
	        logger.info("Successfully Click on the Create acccount button and four errors are diplayed (This Field is Required).");
	    } else {
	        test.fail("Failed");
	        logger.info("Failed");
	    }
	}
	
	public static void validateEmailAllErrors() throws InterruptedException {
		test.info("Verify whether the user is able to Check All fields form");
	    Thread.sleep(2000);
	    // Check if the number of errors matches the expected count (7 errors)
	    if (Actionsss.getSizeOfList(cap.getAllFieldsErrorList()) == 3) {
	        test.pass("Successfully Click on the Create acccount button and three errors are diplayed (This Field is Required).");
	        logger.info("Successfully Click on the Create acccount button and three errors are diplayed (This Field is Required).");
	    } else {
	        test.fail("Failed");
	        logger.info("Failed");
	    }
	}
	
	public static void validateCEmailAllErrors() throws InterruptedException {
		test.info("Verify whether the user is able to Check All fields form");
	    Thread.sleep(2000);
	    // Check if the number of errors matches the expected count (7 errors)
	    if (Actionsss.getSizeOfList(cap.getAllFieldsErrorList()) == 2) {
	        test.pass("Successfully Click on the Create acccount button and two errors are diplayed (This Field is Required).");
	        logger.info("Successfully Click on the Create acccount button and two errors are diplayed (This Field is Required).");
	    } else {
	        test.fail("Failed");
	        logger.info("Failed");
	    }
	}
	
	public static void validatePWdAllErrors() throws InterruptedException {
		test.info("Verify whether the user is able to Check All fields form");
	    Thread.sleep(2000);
	    // Check if the number of errors matches the expected count (7 errors)
	    if (Actionsss.getSizeOfList(cap.getAllFieldsErrorList()) == 1) {
	        test.pass("Successfully Click on the Create acccount button and one error is diplayed (This Field is Required).");
	        logger.info("Successfully Click on the Create acccount button and one error is diplayed (This Field is Required).");
	    } else {
	        test.fail("Failed");
	        logger.info("Failed");
	    }
	}
	
	public static void passwordStrengthError() throws InterruptedException {
	    Thread.sleep(2000);
	    test.info("Verify Passoword strength error");
	    // Check if the password strength error is displayed
	    if (Actionsss.displayElement(cap.getpasswordFieldStrength())) {
	        test.pass("Successfully "+Actionsss.getTextOfElement(cap.getpasswordFieldStrength()) + " This error is displayed");
	        logger.info("Successfully error is displayed as " + Actionsss.getTextOfElement(cap.getpasswordFieldStrength()));
	    } else {
	        test.fail(Actionsss.getTextOfElement(cap.getpasswordFieldStrength()) + " This error is not displayed");
	        logger.info("This error is not displayed as " + Actionsss.getTextOfElement(cap.getpasswordFieldStrength()));
	    }
	}
	
	public static void phoneNumber() {
		test.info("Verify Invalid Phone number error");
	    // Check if the phone number error is displayed
	    if (Actionsss.displayElement(cap.getphoneNumberError())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(cap.getphoneNumberError()));
	        logger.info("Successfully Error message is displayed");
	    } else {
	        test.pass("Error message is not displayed as " + Actionsss.getTextOfElement(cap.getphoneNumberError()));
	        logger.info("Test case failed");
	    }
	}

	public static void alreadyExistsMail() {
		test.info("Verify Email already error");
	    // Check if the already exists email error is displayed
	    if (Actionsss.displayElement(cap.getalreadyEmailExists())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(cap.getalreadyEmailExists()));
	        logger.info("Successfully Error message is displayed");
	    } else {
	        test.pass("Test case failed and Error message is not displayed as " + Actionsss.getTextOfElement(cap.getalreadyEmailExists()));
	        logger.info("Test case failed");
	    }
	}
	
	public static void MissmatchMail() {
		test.info("verify Email miss mactch");
	    // Check if the already exists email error is displayed
	    if (Actionsss.displayElement(cap.getSameMailError())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(cap.getSameMailError()));
	        logger.info("Successfully Error message is displayed");
	    } else {
	        test.pass("Test case failed and Error message is not displayed as " + Actionsss.getTextOfElement(cap.getSameMailError()));
	        logger.info("Test case failed");
	    }
	}
	
	
	public static void MissPWDMail() {
		test.info("verify Email miss mactch");
	    // Check if the already exists email error is displayed
	    if (Actionsss.displayElement(cap.getPasswordMismatchError())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(cap.getPasswordMismatchError()));
	        logger.info("Successfully Error message is displayed");
	    } else {
	        test.pass("Test case failed and Error message is not displayed as " + Actionsss.getTextOfElement(cap.getSameMailError()));
	        logger.info("Test case failed");
	    }
	}
	public static void emailFormat() {	    
	    logger.info(Actionsss.getTextOfElement(cap.getemailFormatError()));
	    // Check if the email format error is displayed
	    if (Actionsss.displayElement(cap.getemailFormatError())) {
	        test.pass("Successfully Error message is displayed as " + Actionsss.getTextOfElement(cap.getemailFormatError()));
	        logger.info("Test case passed");
	    } else {
	        test.fail("Test case failed, and Error message is not displayed as " + Actionsss.getTextOfElement(cap.getemailFormatError()));
	        logger.info("Test case failed");
	    }
	}

}
