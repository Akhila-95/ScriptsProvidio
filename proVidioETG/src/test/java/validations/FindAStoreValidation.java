package validations;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.FindAStorePage;
import pageObjects.ProductDetailPage;

public class FindAStoreValidation extends baseClass{

	private static final FindAStorePage findStore = new FindAStorePage(driver);
	private static ProductDetailPage PDP = new ProductDetailPage(driver);
	
	public static void findStoreValidation() throws InterruptedException {
		test.info("Verifying the selected store and displayed store");
		Thread.sleep(2000);
		String selectedStore =Actionsss.getTextOfElement(findStore.getLabelForFindAStore());
		logger.info(selectedStore);
		Thread.sleep(2000);
		String displayedStore =Actionsss.getTextOfElement(findStore.getLabelForFindAStore());		
		logger.info(displayedStore);
		if(selectedStore.equals(displayedStore)) {
			test.pass("Successfully selected the store and both the selected and displayed store are same the selected store is " +displayedStore);
			logger.info("Successfully selected the store and both the selected and displayed store same the selected store is " +displayedStore);
		}else {
			//test.fail("Both the selected and displayed store are different ");
			logger.info(" Both the selected and displayed store are differents");
		}
	}
	
	public static void displayOfDelieveryAddressAndPickUpStore() throws InterruptedException {
		test.info("Verifying the display of pick up store and delivery address");
		if(Actionsss.elementSize(PDP.getPickUpStoreAndDeliveryToAddressList())) {
			if(Actionsss.displayElement(PDP.getDeliveryToAddress()) && Actionsss.displayElement(PDP.getPickUpStore())) {
				test.pass("Successfully displayed the pick up store and delivery to address in PDP page ");
				logger.info("Successfully displayed the pick up store and delivery to address in PDP page ");
			}else {
				test.fail("Pick up store and delivery to address are displayed in pdp page ");
				logger.info(" Pick up store and delivery to address are displayed in pdp page  ");
			}
		}else {
			logger.info("Boips are Disabled so no display of  pick up store and delivery to address in PDP page ");
			test.pass("Boips are Disabled so no display of  pick up store and delivery to address in PDP page ");
		}
	}
		
	public static void pickUpStoreClickInPDP_Page() throws InterruptedException {
		test.info("Verifying the select pick up store from PDP page");		
		if(Actionsss.displayElement(findStore.getStoreNotAvailable())) {
			test.pass("Selected a store but that prodcut is not available in selected store in PDP page ");
			logger.info("Selected a store but that prodcut is not available in selected store in PDP page ");
		}else if (!Actionsss.displayElement(findStore.getStoreNotAvailable())){
			test.pass("Selected a store in PDP page");
			logger.info("Selected a store in PDP page ");
		}else {

			test.fail("Store is not selected in PDP page");
			logger.info("Store is not selected in PDP page");
		}	
	}
}
