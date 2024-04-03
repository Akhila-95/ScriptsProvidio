package tasks;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.ProductListingPage;
import pageObjects.WishlistPage;
import pageObjects.homepage;
import validations.ProductListingPageValidations;
import validations.QuickShopValidations;


public class ProductListingPageTasks extends baseClass{
	
	private static homepage homePage = new homepage(driver);
	private static ProductListingPage PLP = new ProductListingPage(driver);
	private static WishlistPage WLP = new WishlistPage(driver);
	private static String  breacrumbsBeforeRefresh="";
	private static String  breacrumbsAfterRefresh="";
	public static void PlpLoaded() throws Exception {
     	List<WebElement> PlpLoadedproducts = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]//div[contains(@class, 'product-grid')]"));
     
     	if (PlpLoadedproducts.size()>0) {
     	    logger.info("PLP is already loaded");
     	}else {
     		homePage.selectRandomMegaMenu();
     	}
	}
	
	//bread crumbs
	public static void breadCrumbs() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		PlpLoaded();
		Actionsss.CombinedClick(PLP.getSelectbreadCrumbLink());
		Thread.sleep(2000);
		ProductListingPageValidations.verifyBreadCrumbs();
	}  
	
	
	//sort by
	public static void selectSortBy() throws Exception{		
		PlpLoaded();
		Actionsss.randomElementFromListforSortBy(PLP.getSelecttheSortBy());
		ProductListingPageValidations.verifySortby();
	}  
	
	//filters
	public static void selectFilters() throws Exception{				
		PlpLoaded();
		ProductListingPage.selectingFiltersInPlp();
	}
	
	//filters
	public static void clickOnReSetBtn() throws Exception{		
		PlpLoaded();
		ProductListingPage.selectingFiltersInPlp();
		Thread.sleep(4000);
		Actionsss.scrollUp();
		Thread.sleep(2000);
		Actionsss.click(PLP.getSelecttheResetButton());
		ProductListingPageValidations.verifyPLPResetBtn();
	}
	
	//addToMyFav of 15 products
	public static void addToWishListOf15MoreProducts() throws Exception{			
		PlpLoaded();
		Thread.sleep(2000);
		List<WebElement> allProducts= driver.findElements(By.xpath("//i[contains(@class, 'fa-heart-o')]"));
		
		for(WebElement each :allProducts) {
			Actionsss.scrollIntoViewCenter(each);
			Actionsss.CombinedClick(each);
			//ProductListingPageValidations.popUpProductisAddtoWishList();		
		}	
		Thread.sleep(2000);	
		String countOfwishlist = Actionsss.getTextOfElement(WLP.getWishlistCount());
        Thread.sleep(2000);
        int minicartProductCountValue = Integer.parseInt(countOfwishlist);
        if(!(minicartProductCountValue>15)) {
        	homePage.selectGpsNavigation();
        	 Thread.sleep(2000);	
        	 List<WebElement> allProducts1= driver.findElements(By.xpath("//i[contains(@class, 'fa-heart-o')]"));
     		for(WebElement each :allProducts1) {
     			Actionsss.scrollIntoViewCenter(each);
     			Actionsss.CombinedClick(each);
     			//ProductListingPageValidations.popUpProductisAddtoWishList();		
     		}	
        }else {
        	logger.info("Already wishlist have 15 products in it");
        }
	}
	
	//addToMyFav
	public static void addToWishList() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		PlpLoaded();
		Thread.sleep(2000);
		Actionsss.randomElementFromListScrollIntoView(PLP.getSelectAddtoWishListButton());
		ProductListingPageValidations.popUpProductisAddtoWishList();
	}
	
	//removeWishList
	public static void removeWishList() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		PlpLoaded();
		Thread.sleep(4000);
		Actionsss.randomElementFromListScrollIntoView(PLP.getSelectAddtoWishListButton());
		Thread.sleep(6000);
		Actionsss.randomElementFromListScrollIntoView(PLP.getSelectRemoveWishListButton());		
		ProductListingPageValidations.popUpProductisRemoveWishList();
	}

	//addTocartsBtns
	public static void addTocart() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		PlpLoaded();
		Thread.sleep(8000);
		//PLP.addToCartBtn();
		ProductListingPageValidations.popUpProductisAddtoCart();
		Thread.sleep(2000);
	}
	
	//quick shop
	public static void quickShopplp() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		PlpLoaded();
		Thread.sleep(4000);
		Actionsss.randomElementFromListScrollIntoView(PLP.getSelectQuickShopBtn());
		Thread.sleep(1000);
		QuickShopValidations.VerifiyQuickShopPOpUp();
		Thread.sleep(1000);
	}
	
	public static void quickShop() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		PlpLoaded();
		Thread.sleep(4000);
		Actionsss.randomElementFromListScrollIntoView(PLP.getSelectQuickShopBtn());
		Thread.sleep(1000);
		QuickShopValidations.VerifiyQuickShopPOpUp();
		Thread.sleep(1000);
		QuickShopPageTasks.popUpClose();
	}
		
	//product
	public static void productclick() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		PlpLoaded();
		Thread.sleep(4000);
		Actionsss.randomElementFromList(PLP.getSelectProductClick());
		ProductListingPageValidations.verifyPLPProductClick();
	}
	
	//addTocartsBtns
	public static void gpsProducts() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		homePage.selectGpsNavigation();
		Thread.sleep(4000);
		productclick();
	}
	
	public static void simpleProductsGloves() throws Exception{					
		homepage.selectSimpleProducts();			
		Actionsss.randomElementFromList(PLP.getSelectProductClick());
		ProductListingPageValidations.verifyPLPProductClick();
	}
	
	
	
	public static void hideFilters() throws Exception {
		PlpLoaded();
		Actionsss.CombinedClick(PLP.getSelecthideFiltersORShowFilter());
		ProductListingPageValidations.verifyHidefilters();
	}
		
		
	public static void showFilters() throws Exception {
		
		 if (Actionsss.getSizeOfList(ProductListingPage.gettotalFilterlist())==0) {
			 Actionsss.CombinedClick(PLP.getSelecthideFiltersORShowFilter());
				ProductListingPageValidations.verifyShowfilters();
		 }else {
			 hideFilters();
			Actionsss.CombinedClick(PLP.getSelecthideFiltersORShowFilter());
			ProductListingPageValidations.verifyShowfilters();
		 }

	}

	//product add to bag
	public static void productaddtoBag() throws Exception{		
		//Actionsss.click(homePage.getCookies_Yes_Btn());
		PlpLoaded();
		//driver.get("https://zzqi-002.dx.commercecloud.salesforce.com/s/RefArch/women/jewelry/bracelets/?lang=en_US");
		Thread.sleep(2000);
		test.info("Verifying the add product by add to bag");
		for(WebElement each: PLP.getSelectProductClick()) {
			//Actionsss.scrollIntoViewCenter(each);
			Actionsss.hover(each);
			if(Actionsss.displayElement(PLP.getSelectAddtoBagelement())) {
				Actionsss.CombinedClick(PLP.getSelectAddtoBagelement());
				Thread.sleep(2000);
			}
			if(Actionsss.elementSize(PLP.getSelectsizeInAddtoBag())){
				if(Actionsss.displayElement(PLP.getSizeDisplayInAddtoBag())) {
				Actionsss.randomElementFromList(PLP.getSelectsizeInAddtoBag());
				Thread.sleep(2000);
				}
			}if(Actionsss.displayElement(PLP.getAddToBag())) {
				Actionsss.CombinedClick(PLP.getAddToBag());
				Thread.sleep(2000);
				test.pass("successfully product added to cart");
			}
			// ProductListingPageValidations.validatingProductisAddtoCart();   
			
		}
	/*	
		
		Actionsss.randomElementFromListHover(PLP.getSelectProductClick());
		Thread.sleep(3000);
		if(Actionsss.countofElements(PLP.getSelectAddtoBag())) {
        	logger.info("only one element is disolyed");
        	Thread.sleep(3000);
        	Actionsss.CombinedClick(PLP.getSelectAddtoBagelement());
        }else {
        	productaddtoBag();
        	logger.info("not there is disolyed");
        }
		Thread.sleep(1000);
		*/
		//ProductListingPageValidations.verifyPLPProductClick();
	}
	
	//--------------- expand and collapse--------------
	
	public static void collapseInFiltersInPlp() throws Exception {
		PlpLoaded();
		Actionsss.click(PLP.getexpandAndCollapse());
		ProductListingPageValidations.verifyCollapseInPLP();
	}
	
	public static void expandInFiltersInPlp() throws Exception {
		PlpLoaded();
		Actionsss.click(PLP.getexpandAndCollapse());
		ProductListingPageValidations.verifyExpandInPLP();
	}
	
	//------------- refresh in plp for filters----------------
	public static void refreshInPLP_AfterApplyingFilters() throws Exception {
		PlpLoaded();
		ProductListingPage.selectingFiltersInPlp();
		for(WebElement each: PLP.getBreadCrumbsInPlp()) {
			breacrumbsBeforeRefresh=Actionsss.getTextOfElement(each);
		}
		logger.info(breacrumbsBeforeRefresh);
		driver.navigate().refresh();
		Thread.sleep(2000);
		for(WebElement each: PLP.getBreadCrumbsInPlp()) {
			breacrumbsAfterRefresh=Actionsss.getTextOfElement(each);
		}
		logger.info(breacrumbsAfterRefresh);
		for(WebElement each:ProductListingPage.getSelectedFiltersList() ) {
        	String textWithQuestionMarks = Actionsss.getTextOfElement(each);		           
            TestData.filterAFterRefresh = textWithQuestionMarks.replace("RESET", "");
            test.pass("Selected filters are " + TestData.filterAFterRefresh );	        	
        }
		test.info("Verifying the remain of same breadcrumbs after refreshing the page with applied filters");
		if(breacrumbsBeforeRefresh.equals(breacrumbsAfterRefresh)) {
			test.pass("Succesfully Verified that the breadcrumbs remains same and accurately reflects the current page's position in the site with applied filters after refreshing the plp page ");
			logger.info("Succesfully Verified that the breadcrumb  remains and accurately reflects the current page's position in the site with applied filters after refreshing the plp page ");
		}else {
			test.fail("Succesfully Verified that the breadcrumb  remains same remains and accurately reflects the current page's position in the site with applied filters after refreshing the plp page");
			logger.info("Succesfully Verified that the breadcrumb  remains same and accurately reflects the current page's position in the site with applied filters after refreshing the plp page");
		}
	}
	
	public static void defaultAsBestMatchesInPLP() throws Exception {
		PlpLoaded();
		ProductListingPageValidations.verifyDefaultAsBestMatchesInPLP();		
	}
}
