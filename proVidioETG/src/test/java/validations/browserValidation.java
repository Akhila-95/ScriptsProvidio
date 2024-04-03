package validations;

import org.openqa.selenium.NoSuchWindowException;

import baseClass.baseClass;


public class browserValidation extends baseClass{
	
	public static void validateBroweserlaunches() {
		test.info("Verify Home page launching");
		//Browser crashes
		if (isBrowserRunning()) {
			logger.info("Succesfully launched Browser and Loaded the HomePage"); 
			test.pass("Succesfully launched Browser and Loaded the HomePage");
			isBrowserLaunched = true;
        }else {
			logger.info("Browser launched Failed"); 
			test.fail("Browser launched Failed");
        }
	}
	
	//validate the browser is running or not
	   private static boolean isBrowserRunning() {
		   try {
		        driver.getTitle();

		        // Clear all cookies
		       // driver.manage().deleteAllCookies();
		        return true;
		    } catch (NoSuchWindowException e) {
		        return false;
		    } catch (Exception e) {
		        // Handle any other exceptions
		        return false;
		    }
	    }

}
