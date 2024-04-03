package validations;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.loginPage;

public class LoginValidation extends baseClass{

	private static final  loginPage lp = new loginPage(driver);
	
	public void loginPageValidation() {
		if(Actionsss.displayElement(lp.getLoginPage())) {
			test.pass("Successfully navigated to login page");
			logger.info("Successfully navigated to login page");
		}else {
			test.pass("Not navigated to login page");
			logger.info("Not navigated to login page");
		}
	}
	
	/**
	 * Validate successful login and user details display.
	 */
	public void positiveValidation() {
	  

	    // Get the actual title from the "Dashboard" element
	    String expectedTitle = "Dashboard";

	    if (Actionsss.waitAndVisibleGetText(lp.getLoginTitle()).equals(expectedTitle)) {
	        // Log a pass message if the user is logged in successfully
	        test.pass("User logged in successfully");
	        logger.info("User logged in successfully");
	        isLoggedIn = true;

	        test.info("Name of User name is " + Actionsss.getTextOfElement(lp.getUserName()));
	        logger.info("Name of User name is " + Actionsss.getTextOfElement(lp.getUserName()));

	        test.info("Email is " + Actionsss.getTextOfElement(lp.getUserEmail()));
	        logger.info("Email is " + Actionsss.getTextOfElement(lp.getUserEmail()));
	    } else {
	        // Log a fail message if the page title does not match the expected title
	        test.fail("The page Title does not match expected " + expectedTitle + " but found " + Actionsss.getTextOfElement(lp.getUserName()));
	        logger.info("Click failed");
	    }
	}

	/**
	 * Validate error display for invalid login credentials.
	 * @throws InterruptedException 
	 */
	public void invalidLoginError() throws InterruptedException {
	 
	    Thread.sleep(2000);
	    if (Actionsss.displayElement(lp.getinvalidLoginError())) {
	        test.pass("Invalid login error displayed successfully");
	        logger.info("Invalid login error displayed successfully");
	    } else {
	        test.fail("Invalid login error not displayed");
	        logger.info("Invalid login error not displayed");
	    }
	}

	/**
	 * Validate error display for empty email and password submission.
	 */
	public void emptyMailAndPwd() {
	  
	    if (Actionsss.displayElement(lp.getMailError()) && (Actionsss.displayElement(lp.getPasswordError()))) {
	        test.pass("Error displayed for empty email and password submission");
	        logger.info("Error displayed for empty email and password submission");
	    } else {
	        test.fail("Error not displayed for empty email and password submission");
	        logger.info("Error not displayed for empty email and password submission");
	    }
	}

	
	/**
	 * Validate error display for invalid email format.
	 */
	public void invalidEmailFormat() {
	  
	    if (Actionsss.displayElement(lp.getInvalidEmailFormatError())) {
	        test.pass("Invalid email format error displayed successfully");
	        logger.info("Invalid email format error displayed successfully");
	    } else {
	        test.fail("Invalid email format error not displayed");
	        logger.info("Invalid email format error not displayed");
	    }
	}

	/**
	 * Validate error display for login failure with empty email.
	 */
	public void loginFailureWithEmptyEmail() {
	 
	    if (Actionsss.displayElement(lp.getMailError())) {
	        test.pass("Error displayed for login failure with empty email");
	        logger.info("Error displayed for login failure with empty email");
	    } else {
	        test.fail("Error not displayed for login failure with empty email");
	        logger.info("Error not displayed for login failure with empty email");
	    }
	}

	
	/**
	 * Validate error display for login failure with an empty password.
	 */
	public void loginFailureWithEmptyPassword()  {
	  
	    if(Actionsss.displayElement(lp.getPasswordError())) {
	        test.pass("Error displayed for login failure with an empty password");
	        logger.info("Error displayed for login failure with an empty password");
	    } else {
	        test.fail("Error not displayed for login failure with an empty password");
	        logger.info("Error not displayed for login failure with an empty password");
	    }
	}
//----------------check order-------------------------------------------------	
	//check order empty error validation
	public void checkOrderEmptyFieldError() throws InterruptedException  {
		  int expectedcountOfError=Actionsss.listofElementSize(lp.getEmptyFieldError());
		  int actualCountOfError= 3;
		  test.info("Verifying the errors in empty fields in check order");
	    if(expectedcountOfError==actualCountOfError) {
	        test.pass("Errors are  displayed for check order with an empty fields");
	        logger.info("Errors are  displayed for check order with an empty fields");
	    } else {
	        test.fail("Errors are not displayed for check order with an empty fields");
	        logger.info("Errors are not displayed for check order with an empty fields");
	    }
	}
	
	public void paginationOfCheckOrder() throws InterruptedException  {		
		test.info("Verifying the pagination of  check order");
	    if(Actionsss.displayElement(lp.getorderHistory()) && Actionsss.getTextOfElement(lp.getOrderID()).equals(TestData.orderNumberForCheckOrder)) {
	        test.pass("Navigated to Order history is page and  "+Actionsss.displayElement(lp.getorderHistory()) + " and order number is " +Actionsss.getTextOfElement(lp.getOrderID()));
	        logger.info("Navigated to Order history is page and  "+Actionsss.displayElement(lp.getorderHistory())+ " and order number is " +Actionsss.getTextOfElement(lp.getOrderID()));
	        
	    } else {
	        test.fail("Not Navigated to Order history is page and  "+Actionsss.displayElement(lp.getorderHistory()));
	        logger.info("Not Navigated to Order history is page and  "+Actionsss.displayElement(lp.getorderHistory()));
	    }
	}
	
	public void invalidErrorMessageInCheckOrder() throws InterruptedException  {
		
		  test.info("Verifying the error for invalid email in check order");
	    if(Actionsss.displayElement(lp.getInvalidEmailError())) {
	        test.pass("Errors are displayed in check order for invalid email the error is " +Actionsss.getTextOfElement(lp.getInvalidEmailError()));
	        logger.info("Errors are displayed in check order for invalid email");
	    } else {
	        test.fail("Errors are not displayed in check order for invalid email");
	        logger.info("Errors are not displayed in check order for invalid email");
	    }
	}
	
	public void inCompleteErrorMessageInCheckOrder() throws InterruptedException  {
		
		  test.info("Verifying the error for in complete email in check order");
	    if(Actionsss.displayElement(lp.getInvalidEmailError())) {
	        test.pass("Errors are displayed in check order for inCompelete email the error is " +Actionsss.getTextOfElement(lp.getInvalidEmailError()));
	        logger.info("Errors are displayed in check order for inCompelete email");
	    } else {
	        test.fail("Errors are not displayed in check order for inCompelete email");
	        logger.info("Errors are not displayed in check order for inCompelete email");
	    }
	}
	public void inCorrectBillingZipCodeErrorMessageInCheckOrder() throws InterruptedException  {
		
		  test.info("Verifying the error message for incorrect billing zip code in check order");
	    if(Actionsss.displayElement(lp.getInvalidBillingZipCodeError())) {
	        test.pass("Errors are displayed in check order for incorrect billing zip code error is " +Actionsss.getTextOfElement(lp.getInvalidBillingZipCodeError()));
	        logger.info("Errors are displayed in check order for incorrect billing zip code error");
	    } else {
	        test.fail("Errors are not displayed in check order for incorrect billing zip code error");
	        logger.info("Errors are not displayed in check order for incorrect billing zip code error");
	    }
	}

}
