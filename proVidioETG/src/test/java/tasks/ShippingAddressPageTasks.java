package tasks;

import java.util.Set;

import org.openqa.selenium.Alert;

import com.github.javafaker.Faker;

import baseClass.baseClass;
import data.AddressSelection;
import data.TestData;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.ShippingAddressPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.CheckOutPageValidation;
import validations.OrderDetailsPageValidation;
import validations.ShippingAddressPageValidation;

public class ShippingAddressPageTasks extends baseClass{
private static ShippingAddressPage SAP = new ShippingAddressPage(driver);
private static CheckOutPage CP = new CheckOutPage(driver);
private static homepage homePage = new homepage(driver);
private static final loginPage lp = new loginPage(driver);

static AddressSelection addresSelect = new AddressSelection();
private static Faker faker = new Faker();


    public static void ShippingPageView() throws Exception, Exception {
    	
    	if(Actionsss.elementSize(SAP.getshippingPageList()) && Actionsss.elementSize(SAP.getNextPaymentButtonList())) {
			if(Actionsss.displayElement(SAP.getshippingPage()) && Actionsss.displayElement(SAP.getNextPaymentButton())) {
				logger.info("Shipping page alreday loaded");
			}
		}else {
			CheckOutPageTasks.GuestMailCheckOut();
		}
	}	
    	
//    	if(Actionsss.elementSize(SAP.getshippingPageList()) && Actionsss.elementSize(SAP.getguestusercheck())) {
//			logger.info("Shipping page alreday loaded");
//		}else {
//			logger.info("loding shipping page");
//			CheckOutPageTasks.GuestMailCheckOut();
//		}
//    }
    
    public static void ShippingPageViewRegUser() throws Exception, Exception {
    	
    	if(Actionsss.elementSize(SAP.getshippingPageList())&& Actionsss.elementSize(SAP.getshippingPageRegUserList()) ) {
			logger.info("Shipping page of Reg user alreday loaded");
		}else {
			if(Actionsss.elementSize(SAP.getguestusercheck())) {
				logger.info("guest loding shipping page");
				Actionsss.CombinedClick(homePage.clickOnLogo());
			}
			if(Actionsss.countofElements(lp.clickSignList())) {
				logger.info("User not logged in");
				 CheckOutPageValidation.verifyClickOnLogo();
				 HomePageTasks.verifyThatuserLogin();
				 MiniCartPageTasks.checkOutBtnClickRegUser();
			}else {
				logger.info("user logged in");
				 MiniCartPageTasks.checkOutBtnClickRegUser();
		}
     }
   }
    
	public static void getCutomerInfo() throws Exception {	
		ShippingPageView();
		ShippingAddressPageValidation.customerInfoValidationInCOP2_Page();
	}
	
	public static void editEmail() throws Exception {
		ShippingPageView();
		if(Actionsss.countofElements(SAP.getshippingPageList())) {						
			Actionsss.CombinedClick(SAP.getEditCustomerInfo());			
			String randomFirstName = faker.name().firstName(); 
		    String editedEmailInCop2 = randomFirstName + "EditedFromCOP2@etg.digital"; 
		    emailEditedInCop2 =editedEmailInCop2;
		    logger.info(emailEditedInCop2);
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(),  emailEditedInCop2, "Edited email");			
			Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
			ShippingAddressPageValidation.editEmailValidationInCOP2();			
		}else {			
			logger.info("User is checked in as registered");
		}		
	}
	
	public static void productClickInShippingAddressPage() throws InterruptedException, Exception {
		ShippingPageView();
		Actionsss.randomElementFromList(SAP.getproductsInCheckoutPage2());
		ShippingAddressPageValidation.pdpPageValidation();
	}
	
	public static void BackToCart() throws Exception {	
		ShippingPageView();
		Actionsss.CombinedClick(SAP.getBackToCart());				
		Thread.sleep(2000);
		CheckOutPageValidation.verifyClickOnBacktoCart();
	}
	
	public static void  shippingForm() throws Exception {
		ShippingPageView();
		ShippingAddressPageValidation.shippingDetailValidationInCop2_Page();		
	}
	
	
	public static void OrderSummary() throws Exception {
		ShippingPageView();
		ShippingAddressPageValidation.orderSummaryValidationInCop2_Page();		
	}
	
	public static void NextPaymentButton() throws Exception {	
		ShippingPageView();
		ShippingAddressPageValidation.nextPaymentButtonValidationInCop2_Page();		
	}
	
	public static void EtgLogo() throws Exception {
		ShippingPageView();
		ShippingAddressPageValidation.etgLogoValidationInCop2_Page();
	}
	
	public static void EtgLogoClick() throws Exception {
		ShippingPageView();
		Actionsss.CombinedClick(homePage.clickOnLogo());
		Thread.sleep(2000);
		CheckOutPageValidation.verifyClickOnLogo();
	}
	
	public static void helpCenter() throws Exception {
		ShippingPageView();
		if(Actionsss.elementSize(CP.getNeedHelpList())) {
			//if(Actionsss.validateClick(CP.getNeedHelp())) {
				test.pass("Need help call is displayed shipping address page");
				logger.info("Need help call is displayed in shipping address page");
			}else {
				test.fail("Need help call is not displayed shipping address page");
				logger.info("Need help call is not displayed in shipping address page");
			}			
		//}
	}
	public static void characterCheckInAddress1And2Of35InGuestUser() throws Exception {
		ShippingPageView();						
		Actionsss.sendKeys(SAP.getShippingAddress(),TestData.CharactersInshippingAndBillingaddress1And2 ,"entered 35 characters");		
		Actionsss.sendKeys(SAP.getShippingAddress2(),TestData.CharactersInshippingAndBillingaddress1And2 ,"entered 35 characters");
		ShippingAddressPageValidation.verifyIngCharacterLimitInAddresss1And2();
		Actionsss.sendKeys(SAP.getShippingAddress(),TestData.CharactersInshippingAndBillingaddress1And2Empty ," ");		
		Actionsss.sendKeys(SAP.getShippingAddress2(),TestData.CharactersInshippingAndBillingaddress1And2Empty ," ");
	}
		
	
	
	public static void emptyFormInShippingForm() throws  Exception {
		ShippingPageView();
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		ShippingAddressPageValidation.negativeValidationForShippingAddress();
	}
	
	public static void firstNameError() throws Exception	{	
		ShippingPageView();
		Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, "last name");
		Actionsss.addressFromDropDown(SAP.getShippingAddress());			
		Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, "phone number");
		Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.firstNameError();		
	}
	
	public static void lastNameError() throws Exception {
		ShippingPageView();
		Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, "first name");
		Actionsss.clearText(SAP.getSelectLastNameInput());
		Actionsss.addressFromDropDown(SAP.getShippingAddress());			
		Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, "phone number");
		Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.lastNameError();		
	}
	public static void addressError() throws Exception {
		ShippingPageView();
		Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, "first name");
		Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, "last name");
		Actionsss.clearText(SAP.getShippingAddress());	
		Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber,"phone number");
		Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.addressMessageError();
	}
	
	public static void phoneNumberError() throws Exception {
		ShippingPageView();
		Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, "first name");
		Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, "last name");
		Actionsss.addressFromDropDown(SAP.getShippingAddress());
		Actionsss.clearText(SAP.getSelectPhoneInput());
		Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.phoneNumberError();	
	}
	
	public static void enterValidAddress() throws Exception {
		ShippingPageView();
		AddressSelection.Address();	
	/*	Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(2000);*/
//		Actionsss.click(homePage.clickOnLogo());
//		Thread.sleep(2000);
	}
	


	
	public static void EnteringShippingDetails() throws Exception {
		ShippingPageView();
		Thread.sleep(2000);
		AddressSelection.Address();
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
//		Thread.sleep(2000);
//		Actionsss.click(homePage.clickOnLogo());
//		Thread.sleep(2000);
	}
	
	//-------------------------Reg user-------------------------------
	
	public static void enterValidAddressRegUser() throws Exception {
		ShippingPageViewRegUser();
		//Actionsss.CombinedClick(SAP.getregAddnewAddress());
		AddressSelection.Address();	
	/*	AddressSelection.addNewShippingAddressWithName();	
		Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();*/
		Thread.sleep(2000);
		PaymentPageTasks.creditCardWithValidDetails();	
 		ReviewOrderPageTask.placeOrder();	
 		Thread.sleep(2000);
 		OrderDetailsPageValidation.validatePlacetheOrderPage();
 		OrderDetailsPageValidation.orderNumberAndOrderDate();
 		Actionsss.CombinedClick(homePage.clickOnLogo());
//		Actionsss.click(homePage.clickOnLogo());
//		Thread.sleep(2000);
	}
	
	
	public static void enterSelectExistingAddressRegUser() throws Exception {
		ShippingPageViewRegUser();
		//Actionsss.CombinedClick(SAP.getregAddnewAddress());
		AddressSelection.selectingRandomSavedShippingAddress();	
		Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(2000);
		PaymentPageTasks.creditCardWithValidDetails();	
 		ReviewOrderPageTask.placeOrder();		
 		Thread.sleep(2000);
 		OrderDetailsPageValidation.validatePlacetheOrderPage();
 		OrderDetailsPageValidation.orderNumberAndOrderDate();
 		Actionsss.CombinedClick(homePage.clickOnLogo());
//		Actionsss.click(homePage.clickOnLogo());
//		Thread.sleep(2000);
	}
	
	public static void updateAddressRegUser() throws Exception {
		ShippingPageViewRegUser();
		Actionsss.CombinedClick(SAP.getregUpdateAddress());
		AddressSelection.updateShippingAddress();	
		Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(2000);
//		Actionsss.click(homePage.clickOnLogo());
//		Thread.sleep(2000);
		PaymentPageTasks.creditCardWithValidDetails();	
 		ReviewOrderPageTask.placeOrder();	
 		Thread.sleep(2000);
 		OrderDetailsPageValidation.validatePlacetheOrderPage();
 		OrderDetailsPageValidation.orderNumberAndOrderDate();
 		Actionsss.CombinedClick(homePage.clickOnLogo());
	}
	
	
    public static void ShippingPageViewReg() throws Exception, Exception {
    	
    	if(Actionsss.elementSize(SAP.getshippingPageList()) && Actionsss.elementSize(SAP.getNextPaymentButtonList())) {
			if(Actionsss.displayElement(SAP.getshippingPage()) && Actionsss.displayElement(SAP.getNextPaymentButton())) {
				logger.info("Shipping page alreday loaded");
			}
		}else {
			CheckOutPageTasks.GuestMailCheckOutReg();
		}
	}	

    public static void enterValidAddressReg() throws Exception {
    	ShippingPageViewReg();
		AddressSelection.Address();	
		Thread.sleep(2000);
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(2000);
	}
	
	
	
}
