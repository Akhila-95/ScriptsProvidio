package pageObjects;

import baseClass.baseClass;
import functionality.Actionsss;
import tasks.PaymentPageTasks;
import tasks.ProductDetailPageTasks;
import tasks.ReviewOrderPageTask;
import tasks.SearchFunctionalityTasks;
import validations.OrderDetailsPageValidation;

public class ProductSet extends baseClass {

	private final static ProductListingPage  plpPage = new ProductListingPage (driver);
	private static homepage homePage = new homepage(driver);
	
	public static void productSet() throws Exception {
		SearchFunctionalityTasks.searchingProductSet_NavigatingToCategory();
		Actionsss.randomElementFromList(plpPage.getPlpPageList());
		ProductDetailPageTasks.attributesSelection();
		PaymentPageTasks.creditCardwithValidDetailsforOrderPlacing();
		ReviewOrderPageTask.placeOrder();
		OrderDetailsPageValidation.validatePlacetheOrderPage();
		OrderDetailsPageValidation.orderNumberAndOrderDate();
		Actionsss.click(homePage.clickOnLogo());
	}
}
