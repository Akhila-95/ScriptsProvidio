package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.LogoutPage;
import pageObjects.homepage;
import validations.LogoutPageValidations;

public class LogOutTasks extends baseClass {
	private static final  LogoutPage lop = new LogoutPage(driver);
	private static homepage homePage = new homepage(driver);


	public static void verifyLogout() throws InterruptedException, Exception {
 		Actionsss.CombinedClick(homePage.clickOnLogo());
 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
			logger.info("user logged in so logging out ");
			LogOutTasks.logoutCheck();
		}else {
			logger.info("user is not logged in");
			LogoutPageValidations.verifylogout();  	
		}
 	}
	
	public static void  logoutCheck() throws InterruptedException {
		Actionsss.click(homePage.clickOnLogo());
		Thread.sleep(2000);
		Actionsss.hover(lop.getHoverMyAccount());
    	Actionsss.click(lop.getLogOut());
    	Thread.sleep(2000);
    	LogoutPageValidations.verifylogout();  	
	}
}
