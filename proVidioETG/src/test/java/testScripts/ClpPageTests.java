package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.CLPpageTasks;
import tasks.QuickShopinCLP;

public class ClpPageTests extends baseClass{
	
	@Test
    public void VerifingClpPageLinkInHomepageforCLPpageView() throws Exception {
		CLPpageTasks.clpPageView();
    }
	
	@Test
    public void VerifingClpPageAddToWishListINCLP() throws Exception {
		CLPpageTasks.addtoWishList();
    }
	
	@Test
    public void VerifingClpPageRemoveFromWishListINCLP() throws Exception {
		CLPpageTasks.RemoveWishlist();
    }
	
	@Test
    public void VerifingClpPageQuickShopPOP_UP_INCLP() throws Exception {
		CLPpageTasks.quickShop();
    }
	
	
	    @Test
	    public void VerifingViewFullDetailsInQuickshopModal_CLP_InPLP() throws Exception {
	        // Call the verifythatButtonClick method from homePageTasks class
		 QuickShopinCLP.loadPDP();
	    }
	    
	    @Test
	    public void VerifingCloseBtnInQuickshopModal_CLP_InPLP() throws Exception {
	        // Call the verifythatButtonClick method from homePageTasks class
	    	QuickShopinCLP.popUpClose();
	    }
	    
	    @Test
	    public void VerifingAttributesInQuickshopModal_CLP_InPLP() throws Exception {
	        // Call the verifythatButtonClick method from homePageTasks class
	    	QuickShopinCLP.selectAttributesQuickshop();
	    }
	    
	    @Test
	    public void VerifingCustomInputQuantityInQuickshopModal_CLP_InPLP() throws Exception {
	        // Call the verifythatButtonClick method from homePageTasks class
	    	QuickShopinCLP.CustomInputQuickshop();
	    }
	    
	    @Test
	    public void VerifingAddtoCartInQuickshopModal_CLP_InPLP() throws Exception {
	        // Call the verifythatButtonClick method from homePageTasks class
	    	QuickShopinCLP.addtoCart();
	    }
	
	@Test
    public void VerifingClpPageProductLinkINCLP() throws Exception {
		CLPpageTasks.productclick();
    }

}
