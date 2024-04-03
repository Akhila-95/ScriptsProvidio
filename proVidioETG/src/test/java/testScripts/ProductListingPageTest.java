package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.ProductListingPageTasks;
import tasks.QuickShopPageTasks;

public class ProductListingPageTest extends baseClass{
	
	// Test method to verify sortby
    @Test
    public void VerifingSortByFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.selectSortBy();
    }
    
    @Test
    public void VerifingFiltersFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.selectFilters();
    } 
//    
    @Test
    public void VerifingResetFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.clickOnReSetBtn();
    }
//    
    @Test
    public void VerifingaddToWishListFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.addToWishList();
    }
    
    @Test
    public void VerifingQuickshopBtnFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.quickShop();
    }
    
    @Test
    public void VerifingViewFullDetailsInQuickshopModalInPLP() throws Exception {
       
    	QuickShopPageTasks.loadPDP();
    }
    
    @Test
    public void VerifingCloseBtnInQuickshopModalInPLP() throws Exception {
       
    	QuickShopPageTasks.popUpClose();
    }
    
    @Test
    public void VerifingAttributesInQuickshopModalInPLP() throws Exception {
       
    	QuickShopPageTasks.selectAttributesQuickshop();
    }
    
    @Test
    public void VerifingCustomInputQuantityInQuickshopModalInPLP() throws Exception {
       
    	QuickShopPageTasks.CustomInputQuickshop();
    }
    
    @Test
    public void VerifingAddtoCartInQuickshopModalInPLP() throws Exception {
       
    	QuickShopPageTasks.addtoCart();
    }
    
    @Test
    public void VerifyingCarouselsInQuickShop() throws Exception {
       
    	QuickShopPageTasks.carouselsInQuickShop();
    }
    
    @Test
    public void VerifingProductLinkFunctionalityInPLP() throws Exception {
    	ProductListingPageTasks.productclick();
    }
    
    @Test
    public void VerifingBreadCrumbsFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.breadCrumbs();
    }
    @Test
    public void VerifingAddtoBagFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.productaddtoBag();
    }

    
    @Test
    public void VerifingRemoveFromWishListFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.removeWishList();
    }

    
    @Test
    public void VerifingHideFiltersFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.hideFilters();
    }
    
    
    @Test
    public void VerifingShowFiltersFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.showFilters();
    }

    
    @Test
    public void VerifingExpandFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.expandInFiltersInPlp();
    }
    
    @Test
    public void VerifingCollapseFunctionalityInPLP() throws Exception {
       
    	ProductListingPageTasks.collapseInFiltersInPlp();
    }
    
    @Test
    public void VerifingRefreshInPLP_AfterApplyingTheFilters() throws Exception {      
    	ProductListingPageTasks.refreshInPLP_AfterApplyingFilters();
    }
    
    @Test
    public void VerifingDefaultAsBestMatchesInPLP() throws Exception {
       
    	ProductListingPageTasks.defaultAsBestMatchesInPLP();
    }
    

}
