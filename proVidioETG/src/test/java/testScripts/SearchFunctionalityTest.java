package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.SearchFunctionalityTasks;

public class SearchFunctionalityTest extends baseClass{

	@Test
	public static void VerifyingTheClickOnSearchBar() throws Exception {
		SearchFunctionalityTasks.clickOnSearchBar();
	}
	
	@Test
	public static void VerifyingWhetherAbleToEnterTheDataInSearchBar() throws Exception {
		SearchFunctionalityTasks.enterAnyDataInSearchBar();
	}
	
	@Test
	public static void VerifyingWhetherUserAbleToSeeTheSuggestionsWhenThreeCharactersEnterInTheSearchBar() throws Exception {
		SearchFunctionalityTasks.enterThreeCharactersInSearchField();
	}
	
	@Test
	public static void VerifyingWhetherTheErrorMessageOrSearchTipsAreDisplayingWhenUserClicksOnSearchIcon() throws Exception {
		SearchFunctionalityTasks.clickOnSearchIconWithoutEnteringData();
	}
	
	@Test
	public static void VerifyingWhetherTheCharactersOrDataAreRemovedAfterClickingOnRemoveSymbol() throws Exception {
		SearchFunctionalityTasks.clickOnRemoveSymbol();
	}
	

	@Test
	public static void VerifyingWhetherSearchedProductIsRedirectingToPDP_Page() throws Exception {
		SearchFunctionalityTasks.searchingAproduct();
	}
	
	@Test
	public static void VerifyingWhetherSearchedProductIsRedirectingToCategory_Page() throws Exception {
		SearchFunctionalityTasks.searchingAproductNavigatingToCategory();
	}
}
