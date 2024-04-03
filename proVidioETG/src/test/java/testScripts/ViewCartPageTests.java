package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.ViewCartPageTasks;

public class ViewCartPageTests extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
    public void VerifingCheckOutBtnClickInViewCart() throws Exception {
		ViewCartPageTasks.checkOutBtnClickinViewCart();
    }
	
	@Test(groups = {"regression"})
    public void VerifingContinueShoppingLinkInViewCart() throws Exception {
		ViewCartPageTasks.continueShopping();
    }
	
	@Test(groups = {"regression"})
    public void VerifingEditBtnInViewCart() throws Exception {
		ViewCartPageTasks.editBtn();
    }
	
	@Test(groups = {"regression"})
    public void VerifingAttributesinEditPOPUpInViewCart() throws Exception {
		ViewCartPageTasks.attributesSelection();
    }
	
	@Test(groups = {"regression"})
    public void VerifingCustomInputInEditPOPUPInViewCart() throws Exception {
		ViewCartPageTasks.customInputinEditPage();
    }
	
	@Test(groups = {"regression"})
    public void VerifingEditPOPUPCloseBtnInViewCart() throws Exception {
		ViewCartPageTasks.closeBtnInEditPOPUP();
    }
	
	@Test(groups = {"regression"})
    public void VerifingEditPOPUPUpdateBtnInViewCart() throws Exception {
		ViewCartPageTasks.editUpdateBtn();
    }
	
	@Test(groups = {"regression"})
    public void VerifingMoveToWishlistLinkInViewCart() throws Exception {
		ViewCartPageTasks.movetoWishList();
    }
	
	@Test(groups = {"regression"})
    public void VerifingCustomInputInViewCart() throws Exception {
		ViewCartPageTasks.customInput();
    }
	
	@Test(groups = {"regression"})
    public void VerifingRemoveInViewCart() throws Exception {
		ViewCartPageTasks.removefromcart();
    }
	
	@Test(groups = {"regression"})
    public void VerifingEmptyPromoCodeInViewCart() throws Exception {
		ViewCartPageTasks.emptyandClickApplyBtn();
    }
	
	@Test(groups = {"regression"})
    public void VerifingInvalidPromoCodeInViewCart() throws Exception {
		ViewCartPageTasks.InvalidInputandClickApplyBtn();
    }
	
	@Test(groups = {"regression"})
    public void VerifingSelectShippingMethodInViewCart() throws Exception {
		ViewCartPageTasks.selectShipping();
    }
	
	@Test(groups = {"regression"})
    public void VerifingErrorInViewCartByExceedingTheLimit() throws Exception {   
		ViewCartPageTasks.addingItemsInExceedingLimit();
    }

	@Test(groups = {"regression"})
    public void VerifingTheDisplayOfOrderSummaryInCartPage() throws Exception {   
		ViewCartPageTasks.orderSummaryDisplayInCartPage();
    }
	
	@Test(groups = {"regression"})
    public void VerifingTheDisplayOfPromoCodeInCartPage() throws Exception {
		ViewCartPageTasks.promoCodeFormDisplayInCartPage();
    }
	
	@Test(groups = {"regression"})
    public void VerifingTheCallToActionOfPaymentInCartPage() throws Exception {        
		ViewCartPageTasks.callToActionOfPaymentInCartPage();
    }
	
	@Test(groups = {"regression"})
    public void VerifingTheDisplayOfshippingCost_SalesTax_SubTotal_EstimatedTotalInCartPage() throws Exception {       
		ViewCartPageTasks.shippingCost_SalesTax_SubTotal_EstimatedTotalDisplayInCartPage();
    }
	
	@Test(groups = {"regression"})
    public void VerifingTheDisplayOfCheckOutButtonInCartPage() throws Exception {
		ViewCartPageTasks.checkoutButtonDisplayInCartPage();
    }
	
	@Test(groups = {"regression"})
    public void VerifingTheDisplayOfPaypalButtonInCartPage() throws Exception {
		ViewCartPageTasks.displayOfPaypalInCartPage();
    }
	
	@Test(groups = {"regression"})
    public void VerifingTheSubTotalWithAllTheProductsCostlInCartPage() throws Exception {
		ViewCartPageTasks.sumOfAllProductsInCart();
    }
	
	@Test(groups = {"regression"})
    public void VerifingTheEstimatedTotalInCartPage() throws Exception {
		ViewCartPageTasks.estimatedTotalInCartPage();
    }
	
	@Test(groups = {"regression"})
    public void VerifingTheSalesTaxVaryWithQuantityIncreasInCartPage() throws Exception {
		ViewCartPageTasks.salesTaxVaryWithQuantityIncrease();
    }

}
