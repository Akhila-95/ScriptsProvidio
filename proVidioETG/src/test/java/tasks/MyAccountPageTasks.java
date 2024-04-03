package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import pageObjects.homepage;
import validations.MyAccountValidations;

public class MyAccountPageTasks extends baseClass{
	
	private static homepage homePage = new homepage(driver);
	private static MyAccountPage MAC= new MyAccountPage(driver);
	
	public static void myAccoutView() throws Exception {
		if(Actionsss.countofElements(MAC.getmyAccountpageHeaderlist())) {
			logger.info("My account page is already loaded");
			 MyAccountValidations.verifyuserClickedonMyAccount(); 
		}else {
			 Actionsss.CombinedClick(homePage.clickOnLogo());
			 if(Actionsss.countofElements(MAC.getElementMyAccountLinklist())) {
				 Actionsss.hover(homePage.getElementhoweraccount());
				 Actionsss.click(MAC.getElementMyAccountLink());
				 MyAccountValidations.verifyuserClickedonMyAccount(); 
			 }else {
				 HomePageTasks.verifyThatuserLogin();
			 }
		}
	}
	

	public static void myOrderLink() throws Exception {
		
		if(isLoggedIn) {
			 Actionsss.click(homePage.clickOnLogo());
			 Thread.sleep(2000);
		}else {
			 HomePageTasks.verifyThatuserLogin();
			 Actionsss.click(homePage.clickOnLogo());
			 Thread.sleep(2000);
		}
		Actionsss.hover(homePage.getElementhoweraccount());
		Actionsss.click(MAC.getElementMyOrdersLink());
		MyAccountValidations.verifyuserClickedonMyOrder();
		 
	}

}
