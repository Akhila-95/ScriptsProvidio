package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import pageObjects.homepage;
import validations.MyAccountValidations;
import validations.ProductListingPageValidations;

public class MyAccountPageOrderHistoryTasks extends baseClass{
	
	private static MyAccountPage MAC= new MyAccountPage(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void orderHistoryPageView() throws Exception {
		if(Actionsss.countofElements(MAC.getviewOrderHistoryHeader())&& Actionsss.countofElements(MAC.getorderDetails())) {
			logger.info("Order History page is already loaded");
		}else {

			MyAccountPageTasks.myAccoutView();
			Actionsss.CombinedClick(MAC.getviewOrderHistoryLink());
			if(Actionsss.elementSize(MAC.getcontinueShoppingButtonList()) && !Actionsss.elementSize(homePage.clickOnLogoList()) ) {
				test.info("Error page is found as length undefined so clicking on continue shopping");
				logger.info("sdfdsf");
				Actionsss.CombinedClick(MAC.getcontinueShoppingButton());
				Thread.sleep(4000);	
				orderHistoryPageView();
			}else {
				Thread.sleep(2000);
				MyAccountValidations.verifyuserClickedonMyOrder();
			}
			
		}
	}
	
	public static void homelink() throws Exception {
		orderHistoryPageView();
		Actionsss.CombinedClick(MAC.gethomeLink());
		MyAccountValidations.verifyClickOnLogo();
	}
	
	public static void myAccountedit() throws Exception {
		orderHistoryPageView();
		Actionsss.CombinedClick(MAC.getmyaccountlink());
		MyAccountValidations.verifyuserClickedonMyAccount();
	}
	
	public static void backtomyaccountlink() throws Exception {
		orderHistoryPageView();
		Actionsss.scrollBottom();
		Thread.sleep(3000);
		
		Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
		if(Actionsss.elementSize(MAC.getcontinueShoppingButtonList()) && !Actionsss.elementSize(homePage.clickOnLogoList()) ) {
			test.info("Error page is found as length undefined so clicking on continue shopping");
			logger.info("sdfdsf");
			Actionsss.CombinedClick(MAC.getcontinueShoppingButton());
			MyAccountValidations.verifyuserClickedonMyAccount();
		}
		
	}
	
	public static void filterOrderHistory() throws Exception {
		orderHistoryPageView();
		if(!Actionsss.countofElements(MAC.getorderDetailsnotContains())) {
			Actionsss.randomElementFromListforSortBy(MAC.getfilterOrderHistroy());
			ProductListingPageValidations.verifySortby();
		}else {
			test.pass("Salesforce payment Only we have order Details Tracking and Remaing Payments Does not Have OMS");
		}
	}
	
	
	//////////need to change the logic
	
	public static void orderDetailsView() throws Exception {
		if(Actionsss.countofElements(MAC.getvieworderHeader())) {
			logger.info("Order details page is already loaded");
		}else {
		orderHistoryPageView();
		if(!Actionsss.countofElements(MAC.getorderDetailsnotContains())) {
			Actionsss.randomElementFromListScrollIntoView(MAC.getviewOrderLink());
			MyAccountValidations.orderdetailsPage();
		}else {
			test.pass("Salesforce payment Only we have order Details Tracking and Remaing Payments Does not Have OMS");
		}
	   }
	}
	
	public static void orderDetailHomeLink() throws Exception {
		orderDetailsView();
		if(Actionsss.countofElements(MAC.getvieworderHeader())) {
			Actionsss.CombinedClick(MAC.gethomeLink());
			MyAccountValidations.verifyClickOnLogo();
		}else {
			test.pass("Salesforce payment Only we have order Details Tracking and Remaing Payments Does not Have OMS");
		}

	}
	
	public static void orderDetailmyAccountedit() throws Exception {
		orderDetailsView();
		if(Actionsss.countofElements(MAC.getvieworderHeader())) {
			Actionsss.CombinedClick(MAC.getmyaccountlink());
			MyAccountValidations.verifyuserClickedonMyAccount();
		}else {
			test.pass("Salesforce payment Only we have order Details Tracking and Remaing Payments Does not Have OMS");
		}

	}
	
	public static void orderDetailOrderHistorylink() throws Exception {
		orderDetailsView();
		if(Actionsss.countofElements(MAC.getvieworderHeader())) {
			Actionsss.CombinedClick(MAC.getorderHistoryBreadCrumb());
			MyAccountValidations.verifyuserClickedonMyOrder();
		}else {
			test.pass("Salesforce payment Only we have order Details Tracking and Remaing Payments Does not Have OMS");
		}

	}
	
	public static void orderDetailProductlink() throws Exception {
		orderDetailsView();
		if(Actionsss.countofElements(MAC.getvieworderHeader())) {
			Actionsss.randomElementFromListScrollIntoView(MAC.getproductLineItem());
			MyAccountValidations.verifyPLPProductClick();
		}else {
			test.pass("Salesforce payment Only we have order Details Tracking and Remaing Payments Does not Have OMS");
		}

	}
	
	public static void orderDetailbacktoMyOrderHistorylink() throws Exception {
		orderDetailsView();
		if(Actionsss.countofElements(MAC.getvieworderHeader())) {
			Actionsss.CombinedClick(MAC.getbackorderHistory());
			MyAccountValidations.verifyuserClickedonMyOrder();
		}else {
			test.pass("Salesforce payment Only we have order Details Tracking and Remaing Payments Does not Have OMS");
		}

	}
	
	

}
