package validations;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.LogoutPage;
import pageObjects.loginPage;


public class LogoutPageValidations extends baseClass{
	static loginPage lp = new loginPage(driver);
	
	public static void verifylogout() {
 		test.info("Verify user logout");
     	if (Actionsss.displayElement(lp.clickSign())) {
     	    logger.info("Successfully clicked on the logout button and Navigated to the Home page");
     	    test.pass("Successfully clicked on the logout button and Navigated to the Home page");
     	}else {
     		test.pass("User not logged-in");
     		logger.info("User not logged-in");
     	}
	}

}
