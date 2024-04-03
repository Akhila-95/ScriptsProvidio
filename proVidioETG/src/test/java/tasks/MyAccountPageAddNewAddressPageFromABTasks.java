package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import validations.MyAccountValidations;

public class MyAccountPageAddNewAddressPageFromABTasks extends baseClass{
	
	private static MyAccountPage MAC= new MyAccountPage(driver);
	private static TestData TD= new TestData();
	
	//add new addrss 
	public static void addNewAddressPageView() throws Exception {
		if(Actionsss.countofElements(MAC.getaddnewAddressHeader())) {
			logger.info("Add new address page is already loaded");
		}else {
			MyAccountPageAddressBookTasks.addressBookView();
			Actionsss.CombinedClick(MAC.getaddNewAddressLink());
			Thread.sleep(2000);
			MyAccountValidations.addnewAddressPage();
		}
	}
		
	public static void addNewAddressAddressBooklink() throws Exception {
		addNewAddressPageView();
		Actionsss.CombinedClick(MAC.getaddressBookLink());
		Thread.sleep(2000);
		MyAccountValidations.verifyAddressbookpage();
	}
	
	
	public static void addNewAddresshomelink() throws Exception {
		addNewAddressPageView();
		Actionsss.CombinedClick(MAC.gethomeLink());
		Thread.sleep(2000);
		MyAccountValidations.verifyClickOnLogo();
	}
	
	public static void addNewAddressmyaccount() throws Exception {
		addNewAddressPageView();
		Actionsss.CombinedClick(MAC.getmyaccountlink());
		Thread.sleep(2000);
		MyAccountValidations.verifyuserClickedonMyAccount();
	}
	
	public static void addNewAddresscancellink() throws Exception {
		addNewAddressPageView();
		Actionsss.CombinedClick(MAC.geteditcancelbutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyAddressbookpage();
	}
	
	public static void addNewAddressbacktomyaccountlink() throws Exception {
		addNewAddressPageView();
		Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
		Thread.sleep(2000);
		MyAccountValidations.verifyuserClickedonMyAccount();
	}
	
	public static void emptyform() throws Exception {
		addNewAddressPageView();
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyAddNewAddressemptyformpage();
	}
	
	public static void addresstitle() throws Exception {
		addNewAddressPageView();
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), TD.FirstName_MAP_IP_Data, TD.FirstName_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), TD.LastName_MAP_IP_Data, TD.LastName_CA_IP_Data);
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());			
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), TD.Phone_MAP_IP_Data, TD.phone_CA_MAP_FieldName);
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.addressTitleError();
	}
	
	public static void firstNameError() throws Exception	{	
		addNewAddressPageView();
		Actionsss.sendKeys(MAC.setAddressTitle(), TD.AddressTitle_MAP_IP_Data, TD.AddressTitle_MAP_IP_FieldName);
		Actionsss.clearText(MAC.getSelectfirstNameInput());
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), TD.LastName_MAP_IP_Data, TD.LastName_CA_IP_Data);
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());			
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), TD.Phone_MAP_IP_Data, TD.phone_CA_MAP_FieldName);
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.addNewAddressfirstNameError();		
	}
	
	public static void lastNameError() throws Exception {
		addNewAddressPageView();
		Actionsss.sendKeys(MAC.setAddressTitle(), TD.AddressTitle_MAP_IP_Data, TD.AddressTitle_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), TD.FirstName_MAP_IP_Data, TD.FirstName_MAP_IP_FieldName);
		Actionsss.clearText(MAC.getSelectLastNameInput());
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());			
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), TD.Phone_MAP_IP_Data, TD.phone_CA_MAP_FieldName);
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.addNewAddresslastNameError();		
	}
	public static void addressError() throws Exception {
		addNewAddressPageView();
		Actionsss.sendKeys(MAC.setAddressTitle(), TD.AddressTitle_MAP_IP_Data, TD.AddressTitle_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), TD.FirstName_MAP_IP_Data, TD.FirstName_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), TD.LastName_MAP_IP_Data, TD.LastName_CA_IP_Data);
		Actionsss.clearText(MAC.getShippingAddress());	
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), TD.Phone_MAP_IP_Data,TD.phone_CA_MAP_FieldName);
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.addNewAddressaddressMessageError();
	}
	
	public static void phoneNumberError() throws Exception {
		addNewAddressPageView();
		Actionsss.sendKeys(MAC.setAddressTitle(), TD.AddressTitle_MAP_IP_Data, TD.AddressTitle_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), TD.FirstName_MAP_IP_Data,TD.FirstName_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), TD.LastName_MAP_IP_Data, TD.LastName_CA_IP_Data);
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());
		Actionsss.clearText(MAC.getSelectPhoneInput());
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.addNewAddressphoneNumberError();	
	}
	
	public static void addressTitleAlreadyExits() throws Exception {
		addNewAddressPageView();
		Actionsss.sendKeys(MAC.setAddressTitle(), TD.Already_AddressTitle_MAP_IP_Data, TD.AddressTitle_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), TD.FirstName_MAP_IP_Data, TD.FirstName_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), TD.LastName_MAP_IP_Data, TD.LastName_CA_IP_Data);
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());
		Thread.sleep(2000);
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), TD.Phone_MAP_IP_Data,TD.phone_CA_MAP_FieldName);
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.addressTitleAlreadyExitsError();
	}
	
	
	
	public static void validDetals() throws Exception {
		addNewAddressPageView();
		Actionsss.sendKeys(MAC.setAddressTitle(), TD.AddressTitle_MAP_IP_Data, TD.AddressTitle_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectfirstNameInput(), TD.FirstName_MAP_IP_Data, TD.FirstName_MAP_IP_FieldName);
		Actionsss.sendKeys(MAC.getSelectLastNameInput(), TD.LastName_MAP_IP_Data, TD.LastName_CA_IP_Data);
		Actionsss.addressFromAddNewAddress(MAC.getShippingAddress());
		Thread.sleep(2000);
		Actionsss.sendKeys(MAC.getSelectPhoneInput(), TD.Phone_MAP_IP_Data,TD.phone_CA_MAP_FieldName);
		Thread.sleep(2000);
		Actionsss.CombinedClick(MAC.geteditsavebutton());
		Thread.sleep(2000);
		MyAccountValidations.verifyAddressbookpage();
	}

}
