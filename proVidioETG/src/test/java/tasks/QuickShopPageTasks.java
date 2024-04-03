package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.QuickShopPage;
import validations.ProductDetailPageValidation;
import validations.ProductListingPageValidations;
import validations.QuickShopValidations;

public class QuickShopPageTasks extends baseClass{
	
	private static QuickShopPage QSP = new QuickShopPage(driver);
	private static TestData TD = new TestData();
	
	public static void modalPopUPQuickShop() throws Exception {
     	List<WebElement> viewCartPageproducts = driver.findElements(By.xpath("//div[contains(@class, 'product-quickview')]"));
     
     	if (viewCartPageproducts.size()>0) {
     	    logger.info("Quick shop pop up modal is already loaded");
     	}else {
     		ProductListingPageTasks.quickShopplp();
     	}
	}
	
	public static void loadPDP() throws Exception {
		modalPopUPQuickShop();
		Actionsss.CombinedClick(QSP.getSelectPDPLink());
		QuickShopValidations.verifyQuickshopFullDetailsLinkClick();
	}
	
	public static void carouselsInQuickShop() throws Exception {
		modalPopUPQuickShop();			
		QuickShopValidations.verifyCarouselsClickInQuickShop();
	}
	public static void popUpClose() throws Exception {
		modalPopUPQuickShop();
		Actionsss.CombinedClick(QSP.getSelectQuickShopCloseBtn());
		QuickShopValidations.VerifiyQuickShopPOpUpClosed();
	}
	
	public static void selectAttributesQuickshop() throws Exception {
		modalPopUPQuickShop();
		allAttributesSelection.selectTheAttributesInQuickShop();
		QuickShopValidations.verifyAttributesSelection();
	}
	
	public static void CustomInputQuickshop() throws Exception {
		modalPopUPQuickShop();
		if(Actionsss.countofElements(QSP.getselectInputlist())) {
			Actionsss.CombinedClick(QSP.getSelectdropdownInput());
			Thread.sleep(3000);
			Actionsss.randomElementFromListfordropdown(QSP.getSelectCustomInputlist());
			ProductDetailPageValidation.verifyselectedInput();
		}else{
			Actionsss.clearText(QSP.getSelectCustomInput());
			Thread.sleep(2000);
			Actionsss.SendKeys(QSP.getSelectCustomInput(), 5, TD.Input_PDP_IP_FieldName);
		}

	}
	
	public static void addtoCart() throws Exception {
		modalPopUPQuickShop();
		Thread.sleep(2000);
		allAttributesSelection.selectTheAttributesInQuickShop();
		Thread.sleep(1000);
		Actionsss.CombinedClick(QSP.getSelectaddToCartBtn());
		ProductListingPageValidations.validatingProductisAddtoCart();
//		if((QSP.getSelectaddToCartBtn()).isEnabled()) {
//			Actionsss.CombinedClick(QSP.getSelectaddToCartBtn());
//			ProductListingPageValidations.validatingProductisAddtoCart();
//		}else {
//			allAttributesSelection.selectTheAttributesInQuickShop();
//			Thread.sleep(1000);
//			Actionsss.CombinedClick(QSP.getSelectaddToCartBtn());
//			ProductListingPageValidations.validatingProductisAddtoCart();
//		}

	}


	

}
