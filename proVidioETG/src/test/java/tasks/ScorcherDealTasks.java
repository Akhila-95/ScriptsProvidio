package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.ScorcherDealsPage;
import pageObjects.homepage;
import validations.OrderDetailsPageValidation;
import validations.ProductListingPageValidations;
import validations.ScorcherDealValidation;

public class ScorcherDealTasks extends baseClass {

	private static ScorcherDealsPage scorcher = new ScorcherDealsPage(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void displayOfComponentsInScorcherDeal() throws InterruptedException {
		test.info("Verifying the dispaly of all the components in scorcher deal");
		if(Actionsss.elementSize(scorcher.getscorcherDealList())) {
			if(Actionsss.displayElement(scorcher.getScorcherDealProductName()) && Actionsss.displayElement(scorcher.getscorcherDealStandardPrice()) && Actionsss.displayElement(scorcher.getscorcherDealSalePrice()) &&
				Actionsss.displayElement(scorcher.getQunatityInscorcherDeal()) && Actionsss.displayElement(scorcher.getScorcherDealAddToCart()) && Actionsss.displayElement(scorcher.getTimeDisplayInScorcherDeal())) {
				test.pass("Successfully the product name,dicount price, actual price , quantity , add to cart button and deal time are displaying");
				logger.info("Successfully the product name,dicount price, actual price , quantity , add to cart button and deal time are displaying");
			}else {
				test.fail("The product name,dicount price, actual price , quantity , add to cart button and deal time are not displaying");
				logger.info("The product name,dicount price, actual price , quantity , add to cart button and deal time are not displaying");
			}
		}else {
			test.info("No Scorcher deals on home page");
			test.pass("No Scorcher deals on home page so no scorcher deal product to place order ");
		}
	}
	
	
	public static void addscorcherDealProductToCart() throws Exception {
		if(Actionsss.elementSize(scorcher.getscorcherDealList())) {
			test.info("Veriying the place order of scorcher deal product");
			String productName=Actionsss.getTextOfElement(scorcher.getScorcherDealProductName());
			TestData.scorcherDealProduct=productName;
			logger.info(TestData.scorcherDealProduct);
			TestData.standardPrice=Actionsss.getTextOfElement(scorcher.getscorcherDealStandardPrice());
			TestData.salePrice=Actionsss.getTextOfElement(scorcher.getscorcherDealSalePrice());
			Actionsss.CombinedClick(scorcher.getScorcherDealAddToCart());
			ProductListingPageValidations.validatingProductisAddtoCart();
			ViewCartPageTasks.viewCartpage();
			ScorcherDealValidation.standardAndSalePriceValidation();
		}else {
			test.info("No Scorcher deals on home page");
			test.pass("No Scorcher deals on home page so no scorcher deal product to place order ");
		}
	}
	
	public static void scorcherDeal() throws Exception {
		Actionsss.CombinedClick(homePage.clickOnLogo());
		if(Actionsss.elementSize(scorcher.getscorcherDealList())) {
			test.info("Veriying the place order of scorcher deal product");
			String productName=Actionsss.getTextOfElement(scorcher.getScorcherDealProductName());
			TestData.scorcherDealProduct=productName;
			logger.info(TestData.scorcherDealProduct);
			TestData.standardPrice=Actionsss.getTextOfElement(scorcher.getscorcherDealStandardPrice());
			TestData.salePrice=Actionsss.getTextOfElement(scorcher.getscorcherDealSalePrice());
			Actionsss.CombinedClick(scorcher.getScorcherDealAddToCart());
			ProductListingPageValidations.validatingProductisAddtoCart();
			ViewCartPageTasks.viewCartpage();
			ScorcherDealValidation.standardAndSalePriceValidation();
		}else {
			test.info("No Scorcher deals on home page");
			test.pass("No Scorcher deals on home page so no scorcher deal product to place order ");
		}
	}
	
	public static void scorcherDealproductInHomePageAndSameProductFromPdpPage() throws InterruptedException, Exception {
		
		Actionsss.CombinedClick(homePage.clickOnLogo());
		if(Actionsss.elementSize(scorcher.getscorcherDealList())) {
			test.info("Veriying the place order of scorcher deal product");
			String productName=Actionsss.getTextOfElement(scorcher.getScorcherDealProductName());
			TestData.scorcherDealProduct=productName;
			logger.info(TestData.scorcherDealProduct);
			TestData.standardPrice=Actionsss.getTextOfElement(scorcher.getscorcherDealStandardPrice());
			TestData.salePrice=Actionsss.getTextOfElement(scorcher.getscorcherDealSalePrice());
			Actionsss.CombinedClick(scorcher.getScorcherDealAddToCart());
			ProductListingPageValidations.validatingProductisAddtoCart();			
			Actionsss.click(homePage.getSearchElement());
			Actionsss.onlySendKeys(homePage.getSearchElement(),TestData.scorcherDealProduct);
			Thread.sleep(5000);
			Actionsss.CombinedClick(homepage.getClickOnSearchedProduct1());
			ProductDetailPageTasks.onlyAddtoCartForScorcherDeals();
			ViewCartPageTasks.viewCartpage();
			ScorcherDealValidation.standardAndSalePriceValidationAddProductFromPdp();
			try {
		 		PaymentPageTasks.creditCardWithValidDetails();	
		 		ReviewOrderPageTask.placeOrder();		 		
		 		OrderDetailsPageValidation.validatePlacetheOrderPage();
		 		OrderDetailsPageValidation.orderNumberAndOrderDate();
		 		Actionsss.CombinedClick(homePage.clickOnLogo());
 			}catch(Exception e) {
 				Actionsss.CombinedClick(homePage.clickOnLogo());
 				System.out.println(e);
 			}
		}else {
			test.info("No Scorcher deals on home page");
			test.pass("No Scorcher deals on home page so no scorcher deal product to place order ");
		}
	}
}
