  package data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.PaymentPage;
import pageObjects.ShippingAddressPage;
import validations.ShippingAddressPageValidation;

public class AddressSelection extends baseClass{
	
	
	private static ShippingAddressPage shippingPage = new ShippingAddressPage(driver);
	private static final PaymentPage paymentPage = new PaymentPage(driver);
	
	private static  TestData TD = new TestData();

	
	public static void Address() throws Exception {
		 if(Actionsss.elementSize(shippingPage.getGuestCheckoutList()) &&Actionsss.elementSize(shippingPage.getshippingFormList()) && !Actionsss.elementSize(shippingPage.getonlyStorePickUp())) {
			 test.info("Verifing the shipping address is Entered in Guest user");
			 logger.info("guest");
			 Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), TD.FirstName_CA_IP_Data, TD.FirstName_Shipping_Address_IP_FieldName);
			 Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), TD.LastName_CA_IP_Data, TD.LastName_Shipping_Address_IP_FieldName);
			 Actionsss.addressFromDropDown(shippingPage.getShippingAddress());	
			 Thread.sleep(2000);
			 Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), TD.phone_CA_IP_Data, TD.phone_Shipping_Address_IP_FieldName);
			 nextPaymentButton();
		 }else if(!(Actionsss.elementSize(shippingPage.getGuestCheckoutList())) && Actionsss.elementSize(shippingPage.getshippingFormList()) ){
			 logger.info("register");
			 test.info("Verify the shipping address entered in Registered user");
				//if(Actionsss.displayElement(shippingPage.getShippingToDisplay()) && Actionsss.displayElement(shippingPage.getSaveShippingAddress()) && Actionsss.elementSize(shippingPage.getsavedShippingAddressList())) {
					if(Actionsss.elementSize(shippingPage.getsavedShippingAddress())) {
						if(Actionsss.displayElement(shippingPage.getsavedBillingAddress())) {
						test.info("User logged-in and having  saved  address");
							//randomizing the saved address
							//selectingRandomSavedShippingAddress();
							//if user want to add new address though having saved address
							//addNewAddress();
								//}
						}
				}
				//else if(Actionsss.elementSize(shippingPage.getonlyStorePickUp())) {
		 			//}
				else {
					test.info("User logged-in and have no saved  address");
					 //Enters name and address	
					shippingAddressDetailsWithName();					
					saveTheShippingAddress();
					
				}
					if(Actionsss.elementSize(shippingPage.getEditMultiShipping())){
						logger.info(" multi shipping");
					}
					 nextPaymentButton();
					
		 }else if(Actionsss.elementSize(shippingPage.getonlyStorePickUp())) {
			 if(Actionsss.elementSize(shippingPage.getonlyStorePickUp())) {
				 test.pass("Store pick is displayed in shipping method");
				 logger.info("Store pick is displayed in shipping method");
			 }else {
				 test.fail("Store pick is not displayed in shipping method");
				 logger.info("Store pick is not  displayed in shipping method");
			 }
			 logger.info("pick up store product is in cart");
			
			 if(Actionsss.elementSize(shippingPage.getonlyStorePickUp()) && Actionsss.elementSize(shippingPage.getshippingFormList())) {
				 logger.info("enter aaddress");
				 multipleShippingAddressWithName();
				 
			 }else {
				 logger.info("sdsfsdf");
				 test.info("dssdf");
			 }	
			 nextPaymentButton();
		 }	
		 
		 else if(Actionsss.elementSize(shippingPage.getBillingAddressList())) {			 
			 test.pass("Only Gift certificate in cart so no display of shipping address");
			 selectBillingAddress();
		 }
		 	
	}
	
		public static void nextPaymentButton() throws Exception {
			Thread.sleep(2000);
		 	test.info("Verifying whether Next:Payment button is enabled or not");
		 	if(Actionsss.enabledElement(shippingPage.getSelectNextPaymentBtn())) {
		 		test.pass("Next :payment button is enabled in shipping page");
		 		Actionsss.CombinedClick(shippingPage.getSelectNextPaymentBtn());
				Thread.sleep(2000);
				ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
		 	}else {
		 		test.fail("Next :payment button is not enabled in shipping page");
		 		logger.info("Next :payment button is not enabled in shipping page");
		 	}	
		}
	public static void multipleShippingAddressWithName() throws Exception {
		List<WebElement> enterAddrssList= driver.findElements(By.xpath("((//div[contains(@class,'multi-shipping')])[1]//form[@id='dwfrm_shipping'])"));
		logger.info(enterAddrssList.size());
		for(int i=1; i<=enterAddrssList.size();i++) {
			WebElement enterAddrss= driver.findElement(By.xpath("(((//div[contains(@class,'multi-shipping')])[1]//form[@id='dwfrm_shipping']))  ["+i+"]"));
			Actionsss.CombinedClick(enterAddrss);
		  //this method send the shipping first name,last name and address details , phonenumber by checking the display of firstname
		  Thread.sleep(1000);
		  if(Actionsss.displayElement(shippingPage.getmultiShippingFirstName())) {
			  for(int j=2;j<=i+1;j++) {
				  WebElement firstName= driver.findElement(By.xpath("(//input[contains(@class,'shippingFirstName')])[" +j + "]"));				  
				  Actionsss.sendKeys(firstName, fname, "first name");
				  WebElement secondName= driver.findElement(By.xpath("(//input[contains(@class,'shippingLastName')])[" +j + "]"));		
				  Actionsss.sendKeys(secondName, lname, "last name");
				  WebElement address= driver.findElement(By.xpath("(//input[contains(@class,'shippingAddressOne')])[" +j + "]"));		
				  Actionsss.addNewShippinggAddress(address);	
				  Thread.sleep(2000);	
				  WebElement phoneNum= driver.findElement(By.xpath("(//input[contains(@class,'shippingPhoneNumber')])[" +j + "]"));	
				  Actionsss.sendKeys(phoneNum, "9876567893", "phone number");
				  WebElement saveButton= driver.findElement(By.xpath("(//button[contains(@class,'save-shipment')])[" +j + "]"));	
				  Thread.sleep(2000);	
				  Actionsss.CombinedClick(saveButton);
			  }	 
			}
		  }
		}
	
	
	public static void editShippingAddress() throws Exception {
		 List<WebElement> guestCheckOut = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
		 if(guestCheckOut.size()>0) {
			 test.info("Verifed that shipping address is Entered in Guest user");
			 addressEdit();
			 
		 }else {
			 
			test.info("Verify the shipping address entered in Registered user");
				if(Actionsss.displayElement(shippingPage.getShippingToDisplay()) && Actionsss.displayElement(shippingPage.getSaveShippingAddress()) && Actionsss.elementSize(shippingPage.getsavedShippingAddressList())) {
					//if(Actionsss.elementSize(shippingPage.getSavedAddress())) {
						//test.info("User logged-in and having  saved  address");
				          //randomizing the saved address
						//selectingRandomSavedShippingAddress();
						
						//if user want to add new address though having saved address
						//addNewAddress();
						
						// UPDATE ADDRE
						//Actionsss.CombinedClick(shippingPage.getUpdateAddress());
						 addressEdit();
						
					//}else {
						//test.info("User logged-in and have no saved  address");
						 //Enters name and address	
						// addressEdit();
						
						//saveTheShippingAddress();
				//	}
				}
		 }
		 
	}
	
	public static void updateShippingAddress() throws Exception {
		  Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), TD.FirstName_CA_IP_Data, TD.FirstName_Shipping_Address_IP_FieldName);			  
		  Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), TD.LastName_CA_IP_Data, TD.LastName_Shipping_Address_IP_FieldName);
		  Actionsss.updateShippingAddress(shippingPage.getShippingAddress());		
		  Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), TD.phone_CA_IP_Data, TD.phone_Shipping_Address_IP_FieldName);
	}
	
	public static void editBillingAddress() throws Exception {
		Actionsss.sendKeys(paymentPage.getBillingFName(), TD.FirstName_CA_IP_Data, "Billing address first name");
		Actionsss.sendKeys(paymentPage.getBillingLName(), TD.LastName_CA_IP_Data, "Billing address last name");
		Actionsss.editAddress(shippingPage.getBillingAddress());			
		Actionsss.sendKeys(paymentPage.getBillingPhoneNumber(), TD.phone_CA_IP_Data, "Billing phone number");
	}
	
	public static void addressEdit() throws Exception {
		Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), TD.FirstName_CA_IP_Data, "edited first name");
		 Actionsss.sendKeys(shippingPage.getSelectLastNameInput(),TD.LastName_CA_IP_Data, "edited last name");
		 Actionsss.editAddress(shippingPage.getShippingAddress());			
		 Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), TD.phone_CA_IP_Data, TD.phone_Shipping_Address_IP_FieldName);
	}
	

	public static void addNewShippingAddressWithName() throws Exception {
				
			  //this method send the shipping first name,last name and address details , phonenumber by checking the display of firstname
			  Thread.sleep(1000);
			  if(Actionsss.displayElement(shippingPage.getFirstName())) {
				  Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), TD.FirstName_CA_IP_Data, TD.FirstName_Shipping_Address_IP_FieldName);			  
				  Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), TD.LastName_CA_IP_Data, TD.LastName_Shipping_Address_IP_FieldName);
				  Actionsss.addNewShippinggAddress(shippingPage.getShippingAddress());	
				  Thread.sleep(1000);		  
				  Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), TD.phone_CA_IP_Data, TD.phone_Shipping_Address_IP_FieldName);
	 
			  }
		  }
	
	public static void selectingRandomSavedShippingAddress() throws Exception {
		  if(Actionsss.displayElement(shippingPage.getAddressDropDownSelect())) {
			  Thread.sleep(4000);
			  Actionsss.randomElementFromListforSortBy(shippingPage.getsavedShippingAddressList());	
			//int savedAddressCount=Actionsss.getSizeOfList(shippingPage.getsavedShippingAddressList());
//			if(savedAddressCount>1) {
//				Actionsss.selectByOptions(shippingPage.getsavedShippingAddressList());
//				test.pass("Randomly selected the saved address");
//			}
		  }
	}	
	
	 public void addNewAddress() throws Exception {
			
		  if(Actionsss.displayElement(shippingPage.getAddNewAddress())) {
			  Actionsss.javascriptClick(shippingPage.getAddNewAddress());
		  }
	  }
	  public static void shippingAddressDetailsWithName() throws Exception {
		
		  //this method send the shipping first name,last name and address details , phonenumber by checking the display of firstname 
		  Thread.sleep(1000);
		  if(Actionsss.displayElement(shippingPage.getFirstName())) {
			  Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), TD.FirstName_CA_IP_Data, TD.FirstName_Shipping_Address_IP_FieldName);			  
			  Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), TD.LastName_CA_IP_Data, TD.LastName_Shipping_Address_IP_FieldName);
			  Actionsss.addressFromDropDown(shippingPage.getShippingAddress());		
			  Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), TD.phone_CA_IP_Data, TD.phone_Shipping_Address_IP_FieldName);
 
		  }
	  }
	  
	  public static void saveTheShippingAddress() throws Exception {
		 
		  if(Actionsss.elementSize(shippingPage.getSaveShippingAddressList())) {
			  if(Actionsss.displayElement(shippingPage.getSaveShippingAddress())) {
				  Actionsss.javascriptClick(shippingPage.getSaveShippingAddress());
			  }
		  }
	  }
	  public void selectPaymentMethod() throws Exception {
		 
		  if(Actionsss.elementSize(shippingPage.getPaymentButtonList())) {
			  Thread.sleep(2000);	 
			  if(Actionsss.displayElement(shippingPage.getPaymentButton())) {
				  Actionsss.javascriptClick(shippingPage.getPaymentButton());
			  }
		  }
	  }
	  
		public static void selectBillingAddress() throws InterruptedException {

			  if(Actionsss.displayElement(shippingPage.getBillingAddressDisplay())) {
				  if(Actionsss.displayElement(shippingPage.getBillingFName())) {
					  Thread.sleep(1000);		
					  Actionsss.sendKeys(shippingPage.getBillingFName(), TD.FirstName_CA_IP_Data,TD.FirstName_Shipping_Address_IP_FieldName);
					  logger.info("Entered fname");
					  Actionsss.sendKeys(shippingPage.getBillingLName(),TD.LastName_CA_IP_Data,TD.LastName_Shipping_Address_IP_FieldName);
					  logger.info("Entered lname");	
					  Actionsss.addressFromDropDown(shippingPage.getBillingAddress());
					  Actionsss.sendKeys(shippingPage.getBillingPhoneNumber(), TD.phone_CA_IP_Data, TD.phone_Shipping_Address_IP_FieldName);
					  logger.info("Entered phone number");
					  Thread.sleep(2000);
				  }
			  }
		  }	
		
	

}
