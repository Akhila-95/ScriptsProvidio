package tasks;

import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.AddressSelection;
import data.TestData;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.FindAStorePage;
import pageObjects.LogoutPage;
import pageObjects.ProductDetailPage;
import pageObjects.ShippingAddressPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.FindAStoreValidation;
import validations.OrderDetailsPageValidation;
import validations.ShippingAddressPageValidation;

public class FindAStoreTasks extends baseClass {
	
	private static final FindAStorePage findStore = new FindAStorePage(driver);
	private static homepage homePage = new homepage(driver);
	private static final ShippingAddressPage shippingPage = new ShippingAddressPage(driver);
	private static final loginPage lp = new loginPage(driver);
	private static final  LogoutPage lop = new LogoutPage(driver);
	private static ProductDetailPage PDP = new ProductDetailPage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	public static String nameOfStore="";
	public static void loginCheck() throws InterruptedException, Exception {
 		Actionsss.CombinedClick(homePage.clickOnLogo());
 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
			logger.info("user logged in");
		}else if(Actionsss.displayElement(lp.clickSign())) {
			 Actionsss.click(lp.clickSign());
			 LoginPageTasks.verifyThatuserLogin();	 			    
		}
 	}
	public static void logoutCheck() throws InterruptedException, Exception {
 		Actionsss.CombinedClick(homePage.clickOnLogo());
 		if(Actionsss.elementSize(lop.getHoverMyAccountList())) {							
			logger.info("user logged in so logging out ");
			LogOutTasks.verifyLogout();
		}else {
			logger.info("user is not logged in");
		}
 	}
	
	public static  void displayOfFindAstoreAndItsComponents() throws Exception {
		test.info("Verifying find a store display on homepage and its components");		
		if(Actionsss.elementSize( findStore.getLabelForFindAStoreList())) {			
			 test.pass("Salesforce/Stripe/Adyen/Cybersource payments are activated so Bopis are available");	
			 Actionsss.javascriptClick(findStore.getLabelForFindAStore());
			 Thread.sleep(3000);
			if(Actionsss.displayElement(findStore.getLabelForFindAStore()) && Actionsss.displayElement(findStore.getZipCode())
					&& Actionsss.displayElement(findStore.getFindStoreButton()) && Actionsss.displayElement(findStore.getRadius()) && Actionsss.displayElement(findStore.getCloseStore())) {
				test.pass("Successfully find a store,zip code , radius ,find store button and X symbol displayed");
				logger.info("Successfully find a store,zip code , radius ,find store button and X symbol displayed");
			}else {
				test.fail("Find a store,zip code , radius ,find store button and X symbol are not displayed");
				logger.info("Find a store,zip code , radius ,find store button and X symbol are not displayed");
			}		 
		}else {
			test.info("Brain tree payment is activated  so bopis are disabled");
		}
	}
	
	
	
	
	public static  void getFindAtore() throws Exception {
		test.info("Verifying find a store display on homepage");
		logoutCheck();
		if(Actionsss.elementSize(findStore.getLabelForFindAStoreList())) {			
			 test.pass("Salesforce/Stripe/Adyen/Cybersource payments are activated so Bopis are available");					 
			 Actionsss.javascriptClick(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());			 
			 Thread.sleep(2000);
			 Actionsss.randomElementFromList(findStore.getAnyRandomStore());			 
			 Thread.sleep(2000);		 
			 String nameOfStore =Actionsss.getTextOfElement(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 logger.info("Selected store is "+ nameOfStore);			 
			 test.pass("Selected store is "+ nameOfStore);		 
		}else {
			test.info("Brain tree payment is activated  so bopis are disabled");
		}
	}
	
	public static void searchedProduct() throws Exception {
		 Thread.sleep(4000);
		 int size= homepage.getClickOnSearchedProduct1List().size();
		 for(int i =0; i<=size;i++) {
			 for(WebElement each: homepage.getClickOnSearchedProduct1List()) {
				 if(Actionsss.displayElement(each)) {
					 Actionsss.CombinedClick(each);
				 }
				 break;
			 }
		 }
		 
	}
	
	public static void checkIngShippingMethodAsStorePick() throws InterruptedException, Exception {
		test.info("Verifying the shipping method as store pick up in shipping address");
		// choosen the ElectronicsStore
		if(Actionsss.elementSize( findStore.getLabelForFindAStoreList())) {			
			 test.pass("Salesforce/Stripe/Adyen/Cybersource payments are activated so Bopis are available");			 	 
			 Actionsss.javascriptClick(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());			 			
			 Actionsss.javascriptClick(findStore.getSelectElectronicsStore());
			 FindAStoreValidation.findStoreValidation();
			 Thread.sleep(4000);
			 Actionsss.onlySendKeys(homePage.getSearchElement(),TestData.findStoreProduct);
			 Thread.sleep(4000);
			 Actionsss.CombinedClick(homepage.getClickOnSearchedProduct1());
			 Thread.sleep(4000);
			 allAttributesSelection.pickInStoreInPdp();	
			 ViewCartPageTasks.noShippingCostForStorePickUpProducts();
			 CheckOutPageTasks.GuestMailCheckOut();
			 AddressSelection.Address();
		}else {
			test.pass("Brain tree payment is activated  so bopis are disabled");
		}
	}
	
	public static void searchAproductAndAddStoreGuest() throws InterruptedException, Exception {
		test.info("Verifying by searching a store pick up product and placing order in guest user");
		// choosen the ElectronicsStore
		if(Actionsss.elementSize( findStore.getLabelForFindAStoreList())) {			
			 test.pass("Salesforce/Stripe/Adyen/Cybersource payments are activated so Bopis are available");			 	 
			 Actionsss.javascriptClick(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());			 			
			 Actionsss.javascriptClick(findStore.getSelectElectronicsStore());
			FindAStoreValidation.findStoreValidation();
			 Thread.sleep(4000);
			 Actionsss.onlySendKeys(homePage.getSearchElement(),TestData.findStoreProduct);
			 Thread.sleep(4000);
			 Actionsss.CombinedClick(homepage.getClickOnSearchedProduct1());
			 Thread.sleep(4000);
			 allAttributesSelection.pickInStoreInPdp();	
			 ViewCartPageTasks.noShippingCostForStorePickUpProducts();
			 CheckOutPageTasks.GuestMailCheckOut();
			 AddressSelection.Address();
			 AddressSelection.selectBillingAddress();
			 PaymentPageTasks.creditCardWithValidDetails();
			 ReviewOrderPageTask.placeOrder();				
			 OrderDetailsPageValidation.validatePlacetheOrderPage();
			 OrderDetailsPageValidation.orderNumberAndOrderDate();			
			 Actionsss.CombinedClick(homePage.clickOnLogo());
		}else {
			test.pass("Brain tree payment is activated  so bopis are disabled");
		}
	}
	
	
	public static void multiShippingAddressGuest() throws InterruptedException, Exception {
		test.info("Verifying the place order of pick up store product and delivery to address product in guest user");
		if(Actionsss.elementSize( findStore.getLabelForFindAStoreList())) {			
			 test.pass("Salesforce/Stripe/Adyen/Cybersource payments are activated so Bopis are available");			 
			 Actionsss.javascriptClick(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());			 			
			 Actionsss.javascriptClick(findStore.getSelectElectronicsStore());
			 FindAStoreValidation.findStoreValidation();
			 Thread.sleep(4000);
			 
			 Actionsss.onlySendKeys(homePage.getSearchElement(),TestData.findStoreProduct);
			 Thread.sleep(2000);
			 Actionsss.CombinedClick(homepage.getClickOnSearchedProduct1());
			 Thread.sleep(4000);
			 allAttributesSelection.pickInStoreInPdp();			 
			 ProductListingPageTasks.productclick();
			 allAttributesSelection.selectTheAttributesInPdp();			 
			 CheckOutPageTasks.GuestMailCheckOut();
			 AddressSelection.Address();
			 PaymentPageTasks.creditCardWithValidDetails();
			 ReviewOrderPageTask.placeOrder();	
			 Thread.sleep(2000);
			 OrderDetailsPageValidation.validatePlacetheOrderPage();
			 OrderDetailsPageValidation.orderNumberAndOrderDate();			
			 Actionsss.CombinedClick(homePage.clickOnLogo());

			 
		}else {
			test.pass("Brain tree payment is activated  so bopis are disabled");
		}
	}
	
	public static void multiShippingAddressInRegister() throws InterruptedException, Exception {
		test.info("Verifying the place order of pick up store product and delivery to address product in register user");
		if(Actionsss.elementSize( findStore.getLabelForFindAStoreList())) {			
			 test.pass("Salesforce/Stripe/Adyen/Cybersource payments are activated so Bopis are available");			 
			 Actionsss.javascriptClick(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());			 			
			 Actionsss.javascriptClick(findStore.getSelectElectronicsStore());
			 FindAStoreValidation.findStoreValidation();
			 Thread.sleep(4000);			 
			 Actionsss.onlySendKeys(homePage.getSearchElement(),TestData.findStoreProduct);
			 Thread.sleep(4000);
			 Actionsss.CombinedClick(homepage.getClickOnSearchedProduct1());
			 Thread.sleep(4000);
			 allAttributesSelection.pickInStoreInPdp();			 
			 ProductListingPageTasks.productclick();
			 allAttributesSelection.selectTheAttributesInPdp();		 
			 CheckOutPageTasks.GuestMailCheckOut();
			 AddressSelection.Address();
			 PaymentPageTasks.creditCardWithValidDetails();
			 ReviewOrderPageTask.placeOrder();	
			 Thread.sleep(2000);
			 OrderDetailsPageValidation.validatePlacetheOrderPage();
			 OrderDetailsPageValidation.orderNumberAndOrderDate();			
			 Actionsss.CombinedClick(homePage.clickOnLogo());

			 
		}else {
			test.pass("Brain tree payment is activated  so bopis are disabled");
		}
	}
	
	public static void searchAproductAndAddStoreRegister() throws InterruptedException, Exception {
		test.info("Verifying by searching a store pick up product and placing order in register user ");
		loginCheck();
		if(Actionsss.elementSize( findStore.getLabelForFindAStoreList())) {			
			 test.pass("Salesforce/Stripe/Adyen/Cybersource payments are activated so Bopis are available");			 
			 Actionsss.javascriptClick(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());			 
			
			 Actionsss.javascriptClick(findStore.getSelectElectronicsStore());
			 FindAStoreValidation.findStoreValidation();
			 Thread.sleep(4000);
			 Actionsss.onlySendKeys(homePage.getSearchElement(),TestData.findStoreProduct);
			 Thread.sleep(2000);
			 Actionsss.CombinedClick(homepage.getClickOnSearchedProduct1());
			 Thread.sleep(4000);
			 allAttributesSelection.pickInStoreInPdp();		
			 CheckOutPageTasks.GuestMailCheckOut();
			 AddressSelection.Address();
			 PaymentPageTasks.creditCardWithValidDetails();
			 ReviewOrderPageTask.placeOrder();	
			 Thread.sleep(2000);
			 OrderDetailsPageValidation.validatePlacetheOrderPage();
			 OrderDetailsPageValidation.orderNumberAndOrderDate();			
			 Actionsss.CombinedClick(homePage.clickOnLogo());
		}else {
			test.pass("Brain tree payment is activated  so bopis are disabled");
		}
	}

	public static  void validatingPickUpStoreAndDeliveryToaddressDisplayInPdp() throws Exception {
		ProductDetailPageTasks.PdppageVeiw();
		FindAStoreValidation.displayOfDelieveryAddressAndPickUpStore();
	}
	
	public static  void validatingPickUpStoreFromPdpPage() throws Exception {	
		if(Actionsss.elementSize(PDP.getPickUpStoreAndDeliveryToAddressList())) {
			 ProductDetailPageTasks.pickUpStoreSelectionInPdp();
			 findStoreAndChangeStoreInPdp();
			 Thread.sleep(2000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());			 
			 Thread.sleep(2000);
			 Actionsss.randomElementFromList(findStore.getAnyRandomStore());			 
			 Thread.sleep(2000);		 
			 String nameOfStore =Actionsss.getTextOfElement(findStore.getLabelForFindAStore());
			 Thread.sleep(1000);
			 logger.info("Selected store is "+ nameOfStore);			 
			 test.pass("Selected store is "+ nameOfStore);	
		} 
	}
	
	public static void findStoreAndChangeStoreInPdp() throws Exception {
		 if(Actionsss.elementSize(PDP.getFindStoreInPdpList())) {
			 logger.info("find store displayed");
			 Actionsss.CombinedClick(PDP.getFindStoreInPdp());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());	
			 Thread.sleep(2000);
		 }else if(Actionsss.elementSize(PDP.getChangeStoreInPdpList())){
			 logger.info("change store displayed");
			 Actionsss.CombinedClick(PDP.getChangeStoreInPdp());
			 Thread.sleep(1000);
			 Actionsss.javascriptClick(findStore.getFindStoreButton());	
			 
		 }
	}
	
	public static  void inventoryCheckOfPickUpStoreFromPdpPage() throws Exception {		
		Actionsss.CombinedClick(homePage.clickOnLogo());
		 Actionsss.onlySendKeys(homePage.getSearchElement(),TestData.findStoreProduct);
		 Thread.sleep(2000);
		 Actionsss.CombinedClick(homepage.getClickOnSearchedProduct1());
		 Thread.sleep(4000);
			if(Actionsss.elementSize(PDP.getPickUpStoreAndDeliveryToAddressList())) {
				 allAttributesSelection.pickInStoreInPdp();			
				 findStoreAndChangeStoreInPdp();
				 Thread.sleep(2000);
				// Actionsss.randomElementFromList(findStore.getAnyRandomStore());	
				 Actionsss.javascriptClick(findStore.getSelectElectronicsStore());
				 Thread.sleep(2000);		 
				 String nameOfStore =Actionsss.getTextOfElement(findStore.getLabelForFindAStore());
				 Thread.sleep(1000);
				 logger.info("Selected store is "+ nameOfStore);			 
				 test.pass("Selected store is "+ nameOfStore);	
				 pickUpStoreEnableVerify();
			}else {
					logger.info("Boips are Disabled so no display of  pick up store and delivery to address in PDP page ");
					test.pass("Boips are Disabled so no display of  pick up store and delivery to address in PDP page ");
				}			
			}
	
	public static void changeStoreInCart() throws Exception {
		Actionsss.CombinedClick(homePage.clickOnLogo());
		if(Actionsss.elementSize(PDP.getPickUpStoreAndDeliveryToAddressList())) {
			 ProductDetailPageTasks.pickUpStoreSelectionInPdp();
			 ViewCartPageTasks.viewCartpage();
			 test.info("Verifying the activation of Bopis in this payment");
			 if(Actionsss.elementSize(VCP.getPickUpStoreInCartList())) {
				 
				 test.pass("Bopis are activated in this payment ");
				 for(WebElement each: VCP.getfindAStoreList()) {
					 Actionsss.CombinedClick(each);
					 Thread.sleep(2000);
					 Actionsss.javascriptClick(findStore.getFindStoreButton());			 
					 Thread.sleep(2000);
					 Actionsss.randomElementFromList(findStore.getAnyRandomStore());			 
					 Thread.sleep(2000);		 
					 nameOfStore =Actionsss.getTextOfElement(findStore.getLabelForFindAStore());
					 Thread.sleep(1000);
					 logger.info("Selected store is "+ nameOfStore);			 
					 test.pass("Selected store is "+ nameOfStore);	
					 break;
				 }
				 pickUpStoreEnableVerify();
				 
			 }else {
				 test.pass("Brain tree payment is activated Bopis are not configured in it");
			 }
		}else {
			logger.info("Boips are Disabled so no display of  pick up store and delivery to address in PDP page ");
			test.pass("Boips are Disabled so no display of  pick up store and delivery to address in PDP page ");
			}
	}
	
	public static  void pickUpStoreEnableVerify() throws Exception {
		
		Thread.sleep(2000);
		 if(Actionsss.enabledElement(VCP.getPickUpStoreEnable())) {
			 String expectedText="In Stock";
			 String ActualText= Actionsss.getTextOfElement(VCP.getSelectedStoreInventory());
			 for(WebElement each :VCP.getPickUpStoreEnableList()) {
				 Actionsss.CombinedClick(each);
				 Thread.sleep(1000);
				 if(ActualText.equals(expectedText)){
					 test.pass("The Product is available in Selected a store and it showing " + ActualText);
					 logger.info("The Product is available in Selected a store and it showing " + ActualText);
				 }else {
					 test.fail("The Product is available in Selected a store and it is not showing " + ActualText);
					 logger.info("The Product is available in Selected a store and it is not showing " + ActualText);
				 }
			 }
			 logger.info("Selected the pick up store");
		 }else {
			 String expectedTextForNotAvailable="Not Available";
			 String ActualTextForNotAvailable= Actionsss.getTextOfElement(VCP.getSelectedStoreInventory());
			 if(expectedTextForNotAvailable.equals(ActualTextForNotAvailable)) {
				 test.pass("The product is displaying as "+ ActualTextForNotAvailable+ " i.e.,  not available in selected store and the selected store is " +nameOfStore);
				 logger.info("The product is displaying as "+ ActualTextForNotAvailable+ " i.e.,  not available in selected store and the selected store is " +nameOfStore);
				 test.info("Verifying the display of change store");
				 if(Actionsss.displayElement(VCP.getChangeStoreInCart())) {
					 test.pass("Change Store is displayed if the prodcut is Not Available in selected store");
					 logger.info("Change Store is displayed if the prodcut is Not Available in selected store");
				 }else {
					 test.fail("Change Store is not displayed though the prodcut is Not Available in selected store");
					 logger.info("Change Store is not displayed though the prodcut is Not Available in selected store");
				 }
				 if(Actionsss.enabledElement(VCP.getDeliveryAddresInCart())) {
					 test.pass("Succesfully Delivery Address is selected as default if no store is selected");
					 logger.info("Succesfully Delivery Address is selected as default if no store is selected");
				 }else {
					 test.fail("Delivery Address is not selected as default though no store is selected");
					 logger.info("Delivery Address is not selected as default though no store is selected");
				 }
			 }				
		 }
	}
}

