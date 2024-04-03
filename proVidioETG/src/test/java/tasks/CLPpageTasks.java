package tasks;

import baseClass.baseClass;
import functionality.Actionsss;
import pageObjects.ClpPage;
import validations.CLPpageValidation;
import validations.ProductListingPageValidations;
import validations.QuickShopValidations;

public class CLPpageTasks extends baseClass{
	private static ClpPage clp = new ClpPage(driver);

	
	public static void clpPageView() throws Exception {
		if(Actionsss.countofElements(clp.getCLPpageValidation()))  {
			logger.info("Clp page is already loaded");
		}else {
			HomePageTasks.clpPageLoading();
		}
	}
	
	public static void addtoWishList() throws Exception {
		clpPageView();
		Actionsss.randomElementFromListScrollIntoViewandDisplayedelements(clp.getSelectAddtoWishListButton());
		ProductListingPageValidations.popUpProductisAddtoWishList();
	}
	
	public static void RemoveWishlist() throws Exception {
		clpPageView();
		Actionsss.randomElementFromListScrollIntoViewandDisplayedelements(clp.getSelectAddtoWishListButton());
		Thread.sleep(6000);
		Actionsss.randomElementFromListScrollIntoViewandDisplayedelements(clp.getSelectRemoveWishListButton());
		ProductListingPageValidations.popUpProductisRemoveWishList();
	}
	
	public static void quickShopplp() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		clpPageView();
		Thread.sleep(2000);
		Actionsss.randomElementFromListScrollIntoViewandDisplayedelements(clp.getSelectQuickShopBtn());
		Thread.sleep(1000);
		QuickShopValidations.VerifiyQuickShopPOpUp();
		Thread.sleep(1000);
	}
	
	public static void quickShop() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		clpPageView();
		Thread.sleep(4000);
		Actionsss.randomElementFromListScrollIntoViewandDisplayedelements(clp.getSelectQuickShopBtn());
		Thread.sleep(1000);
		QuickShopValidations.VerifiyQuickShopPOpUp();
		Thread.sleep(1000);
		QuickShopPageTasks.popUpClose();
	}
	
	public static void productclick() throws Exception {
		clpPageView();
		Actionsss.randomElementFromListScrollIntoViewandDisplayedelements(clp.getSelectProductClick());
		CLPpageValidation.verifyPLPProductClick();
	}

}
