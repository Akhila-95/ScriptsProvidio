package validations;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.ProductDetailPage;
import pageObjects.ProductListingPage;
import pageObjects.homepage;

public class SearchFunctionalityValidation extends baseClass {
	
	private final static homepage home= new homepage(driver);
	private final static TestData TD = new TestData();
	private final static ProductDetailPage pdpPage = new ProductDetailPage(driver);
	private final static ProductListingPage  plpPage = new ProductListingPage (driver);
	
	public static void verifyClickSearchBar() throws InterruptedException {
		test.info("verifying whether the user can able to click on the search bar");
		if(Actionsss.clickVerify(home.getSearchElement())) {
			test.pass("Successfully user can click on the search bar");
			logger.info("Successfully user can click on the search bar");
		}else {
			test.fail("User cannot able to  click on the search bar");
			logger.info("User cannot able to click on the search bar");
		}
	}
	
	public static void verifyEnterData() throws InterruptedException {
		test.info("verifying whether user can able to enter the data in the search bar");
		if(Actionsss.sendKeys(home.getSearchElement(),TD.enterDataInSearchBar, TD.Search_Home_Page_IP_FieldName)){
			test.pass("Successfully user can able to enter the data in the search bar");
			logger.info("Successfully user can able to enter the data the search bar");
		}else {
			test.fail("User cannot able to enter the data the search bar");
			logger.info("User cannot able to enter the data click on the search bar");
		}
	}
	
	public static void verifyEnterThreeCharactersInSearchField() throws InterruptedException {
		test.info("verifying whether user can able to see the suggestions when entering the three characters in the search bar");
		if(Actionsss.elementSize(home.getsearchedProductsList())){
			test.pass("Successfully  user can able to see the suggestions when entering the three  characters in the search bar");
			logger.info("Successfully  user can able to see the suggestions when entering the three characters in the search bar");
		}else {
			test.fail("User cannot able to see the suggestions when entering the three characters in the search bar");
			logger.info("User cannot able to see the suggestions when entering the  three characters in the search bar");
		}
	}
	
	public static void verifySearchTipsAfterclickingOnSearchIconWithoutEnteringData() throws InterruptedException {
		test.info("verifying whether the Error message or search tips are displaying in the search bar when user clicked on search icon");
		if(Actionsss.elementSize(home.getsearchTipsList())){
			test.pass("Successfully  Error message or search tips are displaying in the search bar when user clicked on search icon");
			logger.info("Successfully Error message or search tips are displaying in the search bar when user clicked on search icon");
		}else {
			test.fail("Cannot Error message or search tips are displaying in the search bar when user clicked on search icon");
			logger.info("Cannot Error message or search tips are displaying in the search bar when user clicked on search icon");
		}
	}
	
	public static void verifyRemoveSymbolInSearchBar() throws InterruptedException {
		test.info("verifying whether character/searched data is removed after entering it and clicking on remove symbol");
		if(Actionsss.elementSize(home.getsearchedProductsList())){
			test.pass("Successfully  the character/searched data is removed after entering it and clicking on remove symbol");
			logger.info("Successfully the character/searched data is removed after entering it and clicking on remove symbol");
		}else {
			test.fail("Character/searched data is not removed after entering it and clicking on remove symbol");
			logger.info("Character/searched data is not removed after entering it and clicking on remove symbol");
		}
	}
	
	public static void verifySearchedProductRedirectedToPdp() throws InterruptedException {
		test.info("verifying whether the searched product is navigating to pdp page ");
		if(Actionsss.displayElement(pdpPage.getPdpPage())){
			test.pass("Successfully the searched product is navigated to pdp page");
			logger.info("Successfully the searched product is navigated to pdp page");
		}else {
			test.fail("The searched product is not navigated to pdp page");
			logger.info("The searched product is not navigated to pdp page");
		}
	}
	
	public static void verifySearchedProductRedirectedToCategoryPage() throws InterruptedException {
		test.info("verifying whether the searched product is navigating to category or PLP page ");
		if(Actionsss.displayElement(plpPage.getPlpPage())){
			test.pass("Successfully the searched product is navigated to category or PLP page");
			logger.info("Successfully the searched product is navigated to category or PLP page");
		}else {
			test.fail("The searched product is not navigated to category or PLP page");
			logger.info("The searched product is not navigated to category or PLP page");
		}
	}
}
