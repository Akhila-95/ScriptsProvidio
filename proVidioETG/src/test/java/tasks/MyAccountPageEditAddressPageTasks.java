package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import validations.MyAccountValidations;

public class MyAccountPageEditAddressPageTasks extends baseClass{
	
	private static MyAccountPage MAC= new MyAccountPage(driver);

	//edit
	public static void addressBookEdit() throws Exception {
		if(Actionsss.countofElements(MAC.geteditAddressHeader())) {
			logger.info("edit address page is already loaded");
		}else {
			MyAccountPageAddressBookTasks.addressBookView();
			Actionsss.randomElementFromListScrollIntoView(MAC.geteditAddressBookLink());
			MyAccountValidations.verifyeditAddressbookpage();
		}
	}
	
	public static void editAddressAddressBooklink() throws Exception {
		addressBookEdit();
		Actionsss.CombinedClick(MAC.getaddressBookLink());
		Thread.sleep(2000);
		MyAccountValidations.verifyAddressbookpage();
	}
	
	
	public static void editAddresshomelink() throws Exception {
		addressBookEdit();
		Actionsss.CombinedClick(MAC.gethomeLink());
		Thread.sleep(2000);
		MyAccountValidations.verifyClickOnLogo();
	}
	
	public static void editAddressedit() throws Exception {
		addressBookEdit();
		Actionsss.CombinedClick(MAC.getmyaccountlink());
		Thread.sleep(2000);
		MyAccountValidations.verifyuserClickedonMyAccount();
	}
	
	public static void editAddresscancellink() throws Exception {
		addressBookEdit();
		Actionsss.CombinedClick(MAC.geteditcancelbutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyAddressbookpage();
	}
	
	public static void editAddressbacktomyaccountlink() throws Exception {
		addressBookEdit();
		Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
		Thread.sleep(2000);
		MyAccountValidations.verifyuserClickedonMyAccount();
	}
	
	public static void emptyform() throws Exception {
		addressBookEdit();
		Actionsss.clearText(MAC.getSelectfirstNameInput());
		Actionsss.clearText(MAC.getSelectLastNameInput());
		Actionsss.clearText(MAC.getShippingAddress());			
		Actionsss.clearText(MAC.getSelectPhoneInput());
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyeditAddressemptyformpage();
	}
	
	public static void firstNameError() throws Exception	{	
		addressBookEdit();
		Actionsss.clearText(MAC.getSelectfirstNameInput());
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), lname, "last name");
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());			
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), phonenumber, "phone number");
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.firstNameError();		
	}
	
	public static void lastNameError() throws Exception {
		addressBookEdit();
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), fname, "first name");
		Actionsss.clearText(MAC.getSelectLastNameInput());
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());			
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), phonenumber, "phone number");
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.lastNameError();		
	}
	public static void addressError() throws Exception {
		addressBookEdit();
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), fname, "first name");
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), lname, "last name");
		Actionsss.clearText(MAC.getShippingAddress());	
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), phonenumber,"phone number");
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.addressMessageError();
	}
	
	public static void phoneNumberError() throws Exception {
		addressBookEdit();
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), fname, "first name");
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), lname, "last name");
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());
		Actionsss.clearText(MAC.getSelectPhoneInput());
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.phoneNumberError();	
	}
	
	public static void validDetals() throws Exception {
		addressBookEdit();
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), fname, "first name");
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), lname, "last name");
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());
		Thread.sleep(2000);
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), phonenumber,"phone number");
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyAddressbookpage();
	}

}
