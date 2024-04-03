package tasks;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

import PaypalPayment.PaypalMethod;
import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.MyAccountPage;

public class MyAccountPagePaypalTasks extends baseClass {

	private static MyAccountPage MAP = new MyAccountPage(driver);
	
	public static void paypalInMyAccount() throws Exception {
		if(Actionsss.countofElements(MAP.getPaypalInMyAccountList())) {
			logger.info("My Account page is loaded");
		}else {
			LoginPageTasks.verifyThatuserLogin();
		}
	}
	
	public static void addPaypalInMyAccount() throws Exception {
		paypalInMyAccount();
		if(Actionsss.elementSize(MAP.getPaypalInMyAccountList())) {
			test.info("Brain tree payment is activated and has paypal in my account");
		
			String rahulNayak=TestData.rahulNayakPaypalUserName;
			String pushpaAccount=TestData.pushpaPaypalUserName;
			int countOfPaypalAccount=2;
			int actualPaypalCount=Actionsss.getSizeOfList(MAP.getPaypalAccountsInMyAccountList());
			if(Actionsss.elementSize(MAP.getPaypalAccountsInMyAccountList())) {
				if(!(countOfPaypalAccount==actualPaypalCount)) {
					for(WebElement each:MAP.getPaypalAccountsInMyAccountList()) {
						logger.info(each.getText());
						//String existedAccount=Actionsss.getTextOfElement(MAP.getPaypalAccountsInMyAccount());
							if(each.getText().equals(rahulNayak)) {
								test.info("Already " +TestData.rahulNayakPaypalUserName + " is added");
								Actionsss.CombinedClick(MAP.getAddNewPaypalAccountInMyAccount());
								Thread.sleep(7000);
								Actionsss.CombinedClick(MAP.getBrainTreePaypalInMyAccount());
								Thread.sleep(4000);
								PaypalMethod.paypalPopupWithPushpaAccount();
								test.pass("Succesfully paypal account is added the added account is " +TestData.pushpaPaypalUserName);
								
							}else if(each.getText().equals(pushpaAccount)) {
								test.info("Already " +TestData.pushpaPaypalUserName+ " is added");
								Actionsss.CombinedClick(MAP.getAddNewPaypalAccountInMyAccount());
								Thread.sleep(7000);
								Actionsss.CombinedClick(MAP.getBrainTreePaypalInMyAccount());
								Thread.sleep(4000);
								PaypalMethod.paypalPopupWithRahulNayakAccount();
							}
						}
					}else {
						test.pass("Already 2 paypal accounts are added in my account no other account is there to add");						
					}
			}else {
				logger.info("Earlier No paypal account is added in my account ");
				Actionsss.CombinedClick(MAP.getAddNewPaypalAccountInMyAccount());
				Thread.sleep(7000);
				Actionsss.CombinedClick(MAP.getBrainTreePaypalInMyAccount());
				Thread.sleep(4000);
				PaypalMethod.paypalPopupWithRahulNayakAccount();
			}
		}else {
			logger.info("No paypal in my account for salesforce payment, only brain tree payment contain Paypal");
		}
	}
	

	
	public static void displayOfPaypalSectionAddNewButtonInMyAccount() throws Exception {
		List<String> paypalAccountTexts = new ArrayList<>();

		paypalInMyAccount();
		test.info("Verifying the display of paypal account if it is added in my account");
		if(Actionsss.elementSize(MAP.getPaypalAccountsInMyAccountList())) {			
			for(WebElement each: MAP.getPaypalAccountsInMyAccountList()) {
				String accountText = Actionsss.getTextOfElement(each);
		        paypalAccountTexts.add(accountText);			
			}				
			for (String text : paypalAccountTexts) {
				test.pass("Paypal account is displayed ,the added account is " + text);
			}
			displayOfRemoveButton();
			displayOfMakeDefaultButton();
			
		}else {
			test.pass("No paypal account is added to display in my account");
			logger.info("No account is added");
		}
	}
	public static void displayOfRemoveButton() {
		test.info("Verifying the display of remove button in my account in paypal section ");
		if(Actionsss.displayElement(MAP.getRemoveButtonInpaypalAccountsInMyAccount())) {				
			test.pass("Remove button is displayed as paypal account is added in my account ");
		}else {				
			test.fail("Remove button is not displayed though paypal account is added in my account ");
		}
	}
	
	public static void displayOfMakeDefaultButton() throws InterruptedException {
		test.info("Verifying the display of make default button if more than 1 paypal account is added in My account");		
		int expectedPaypalAccs=Actionsss.getSizeOfList(MAP.getPaypalAccountsInMyAccountList());
		logger.info(expectedPaypalAccs);
		if(expectedPaypalAccs>1) {
			if(Actionsss.elementSize(MAP.getMakeDefaultButtonInpaypalAccountsInMyAccountList())) {
				if(Actionsss.displayElement(MAP.getMakeDefaultButtonInpaypalAccountsInMyAccount())) {				
					test.pass(" Make default button is displayed as  more than 1 paypal account is added in My account ");
				}else {				
					test.fail(" Make default button is not displayed as  more than 1 paypal account is added in My account ");
				}
			}
		}else {
			logger.info("Only one paypal account is added so no display of make default button");
			test.pass("Only one paypal account is added so no display of make default button");
		}
	}	
	
	public static void removePaypalAccountIfAdded() throws Exception {
		paypalInMyAccount();
		test.info("Verifying the removal of paypal account if already have paypal account in my account in paypal section ");
		if(Actionsss.elementSize(MAP.getPaypalAccountsInMyAccountList())) {
			Actionsss.javascriptClick(MAP.getRemoveButtonInpaypalAccountsInMyAccount());
			Thread.sleep(4000);
			Actionsss.scrollWindowsByPixel(500);
			if(Actionsss.clickVerify(MAP.getRemoveButtonInpaypalAccountsInMyAccount())) {
				logger.info("Clicked on remove");
			}else {
				logger.info("not clicked on remove");
			}
		}else {
			logger.info("No account is added");
		}
		
	}
	public static void makeDefaultPayment() throws Exception {
		paypalInMyAccount();
		int expectedPaypalAccs=Actionsss.getSizeOfList(MAP.getPaypalAccountsInMyAccountList());
		logger.info(expectedPaypalAccs);
		test.info("Verifying the Change in default account");
		if(expectedPaypalAccs>1) {
		//	if(Actionsss.displayElement(MAP.getMakeDefaultButtonInpaypalAccountsInMyAccount())) {	
				String defaultAccountBeforeClickOnMakeDefault = Actionsss.getTextOfElement(MAP.getDefaultAccountInpaypalAccountsInMyAccountByBoldForm());
				test.info("Default account  before click on make default button is " +defaultAccountBeforeClickOnMakeDefault);
				Thread.sleep(2000);
				Actionsss.scrollIntoCenterView(MAP.getMakeDefaultButtonInpaypalAccountsInMyAccount());
				Actionsss.click(MAP.getMakeDefaultButtonInpaypalAccountsInMyAccount());
				Thread.sleep(4000);
				if(!Actionsss.displayElement(MAP.getNoDisplayOfMakedefaultAccountInpaypalAccountsInMyAccount())) {
					String defaultAccountAfterClickOnMakeDefault= Actionsss.getTextOfElement(MAP.getDefaultAccountInpaypalAccountsInMyAccountByBoldForm());
					test.pass("Default account after click on make default button is " +defaultAccountAfterClickOnMakeDefault);
				}
			//}
		}else {
			logger.info("User has only one paypal account so no chance of default account");
		}
	}
	
}
