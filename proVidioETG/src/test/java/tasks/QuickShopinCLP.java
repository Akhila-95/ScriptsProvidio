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

public class QuickShopinCLP extends baseClass{
	
	private static QuickShopPage QSP = new QuickShopPage(driver);
	private static TestData TD = new TestData();
	
	public static void modalPopUPQuickShop() throws Exception {
     	List<WebElement> viewCartPageproducts = driver.findElements(By.xpath("//div[contains(@class, 'product-quickview')]"));
     	if (viewCartPageproducts.size()>0) {
     	    logger.info("Quick shop pop up modal is already loaded");
     	}else {
     		Thread.sleep(2000);
     		CLPpageTasks.quickShopplp();
     	}
	}
	
	public static void loadPDP() throws Exception {
		CLPpageTasks.quickShopplp();
		Thread.sleep(2000);
		Actionsss.CombinedClick(QSP.getSelectPDPLink());
		Thread.sleep(2000);
		QuickShopValidations.verifyQuickshopFullDetailsLinkClick();
	}
	
	public static void popUpClose() throws Exception {
		CLPpageTasks.quickShopplp();
		Thread.sleep(2000);
		Actionsss.CombinedClick(QSP.getSelectQuickShopCloseBtn());
		QuickShopValidations.VerifiyQuickShopPOpUpClosed();
	}
	
	public static void selectAttributesQuickshop() throws Exception {
		CLPpageTasks.quickShopplp();
		Thread.sleep(2000);
		allAttributesSelection.selectTheAttributesInQuickShop_POP_UP();
		QuickShopValidations.verifyAttributesSelection();
		Thread.sleep(1000);
		Actionsss.CombinedClick(QSP.getSelectQuickShopCloseBtn());
	}
	
	public static void CustomInputQuickshop() throws Exception {
		CLPpageTasks.quickShopplp();
		Thread.sleep(2000);
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
		
		Thread.sleep(1000);
		Actionsss.CombinedClick(QSP.getSelectQuickShopCloseBtn());

	}
	
	public static void addtoCart() throws Exception {
		CLPpageTasks.quickShopplp();
		Thread.sleep(2000);
		allAttributesSelection.selectTheAttributesInQuickShop_POP_UP();
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
