package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.homepage;
import validations.SearchFunctionalityValidation;

public class SearchFunctionalityTasks extends baseClass{

	private final static homepage home= new homepage(driver);
	private final static TestData TD = new TestData();
	
	public static void searchFieldVisible() throws Exception {
		if(Actionsss.elementSize(home.getSearchElementList())) {
			logger.info("search field is visible");
		}else {
			Actionsss.CombinedClick(home.clickOnLogo());
		}
	}
	
	public static void clickOnSearchBar() throws Exception {
		searchFieldVisible();
		Thread.sleep(2000);
		Actionsss.click(home.getSearchElement());
		SearchFunctionalityValidation.verifyClickSearchBar();
	}
	
	public static void enterAnyDataInSearchBar() throws Exception {
		searchFieldVisible();
		Actionsss.click(home.getSearchElement());		
		Actionsss.sendKeys(home.getSearchElement(),TD.enterDataInSearchBar, TD.Search_Home_Page_IP_FieldName);
		SearchFunctionalityValidation.verifyEnterData();
	}
	
	public static void enterThreeCharactersInSearchField() throws Exception {
		searchFieldVisible();
		Actionsss.click(home.getSearchElement());
		Actionsss.sendKeys(home.getSearchElement(),TD.enterThreeCharactersInSearchBar, TD.Search_Home_Page_IP_FieldName);
		Thread.sleep(3000);
		SearchFunctionalityValidation.verifyEnterThreeCharactersInSearchField();
	}
	
	public static void clickOnSearchIconWithoutEnteringData() throws Exception {
		searchFieldVisible();
		Actionsss.click(home.getSearchIcon());
		SearchFunctionalityValidation.verifySearchTipsAfterclickingOnSearchIconWithoutEnteringData();
	}
	
	public static void clickOnRemoveSymbol() throws Exception {
		searchFieldVisible();
		Actionsss.click(home.getSearchElement());
		Actionsss.sendKeys(home.getSearchElement(),TD.enterThreeCharactersInSearchBar, TD.Search_Home_Page_IP_FieldName);
		Actionsss.click(home.getResetButton());
		Thread.sleep(2000);
		SearchFunctionalityValidation.verifyRemoveSymbolInSearchBar();
	}
	
	
	public static void searchingAproduct() throws Exception {
		Thread.sleep(3000);
		searchFieldVisible();
		Actionsss.click(home.getSearchElement());
		 String[] data = TestData.searchProducts;

         // Iterate over the array and redeem each Gift Certificate
         for (String searchedProducts : data) {
        	 Actionsss.sendKeys(home.getSearchElement(), searchedProducts, TD.Search_Home_Page_IP_FieldName);
        	 Thread.sleep(3000);
        	 Actionsss.randomElementFromList(home.getClickOnSearchedProduct());
        	 break;
         }
         SearchFunctionalityValidation.verifySearchedProductRedirectedToPdp(); 
         
         	           	
	}
	
	public static void searchingAproductNavigatingToCategory() throws Exception {
		Thread.sleep(3000);
		searchFieldVisible();
		Actionsss.click(home.getSearchElement());
		 String[] data = TestData.searchProducts;

         // Iterate over the array and redeem each Gift Certificate
         for (String searchedProducts : data) {
        	 Actionsss.sendKeys(home.getSearchElement(), searchedProducts, TD.Search_Home_Page_IP_FieldName);
        	 Thread.sleep(3000);
        	 Actionsss.randomElementFromList(home.getsearchProductCategory());
        	 break;
         }
         SearchFunctionalityValidation.verifySearchedProductRedirectedToCategoryPage();  	           	
	}
	
	public static void searchingProductSet_NavigatingToCategory() throws Exception {
		Thread.sleep(3000);
		searchFieldVisible();
		Actionsss.click(home.getSearchElement());
		Actionsss.sendKeys(home.getSearchElement(), TestData.Search_OutfitForProductSet, TD.Search_Home_Page_IP_FieldName);
		Thread.sleep(3000);
		Actionsss.randomElementFromList(home.getsearchProductCategory());        
        SearchFunctionalityValidation.verifySearchedProductRedirectedToCategoryPage();  	           	
	}
}
