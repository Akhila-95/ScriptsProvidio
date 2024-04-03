package browser;

import org.testng.annotations.Test;

import baseClass.baseClass;
import data.TestData;
import data.User;
import validations.browserValidation;


public class launchBrowsering extends baseClass{
	private static TestData TD = new TestData();
	@Test
	public void VerifingHomePageLaunching() throws InterruptedException {
		DifferentBrowsers.initializeDriver();
		//launching the browser and passing the url into it
		 driver.get(TD.baseURL);
		 browserValidation.validateBroweserlaunches(); 
		 User user = new User();
		 user.allFakeData();
	}
	
	
	
}
