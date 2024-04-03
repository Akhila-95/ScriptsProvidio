package OrderRegression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.baseClass;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.ProductDetailPage;
import pageObjects.loginPage;
import tasks.CheckOutPageTasks;
import tasks.OrderDetailPageTasks;
import tasks.PaymentPageTasks;
import tasks.ProductListingPageTasks;
import tasks.ReviewOrderPageTask;
import tasks.ShippingAddressPageTasks;
import validations.OrderDetailsPageValidation;

public class PlaceOrderWithBuyNowPopUp extends baseClass{
	
	private static final loginPage lp = new loginPage(driver);
	private static final ProductDetailPage pdpPage = new ProductDetailPage(driver);
	
	@Test
	public static void verifyingPlacingOrderWithBuyNowPopUp() throws Exception {
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.selectTheAttributesInPdp();
		 Thread.sleep(3000);
		 if(!Actionsss.elementSize(lp.clickSignList())) {
			 Actionsss.scrollWindowsByPixel(150);
			 WebElement buyNow= driver.findElement(By.xpath("//button[contains(@class,'buy-now')]"));
			 Actionsss.javascriptClick(buyNow);
			 Thread.sleep(2000);
				// Actionsss.javascriptClick(pdp.getBuyNowButton());
				 CheckOutPageTasks.GuestMailCheckOut();
				 ShippingAddressPageTasks.enterValidAddress();
				 PaymentPageTasks.creditCardWithValidDetails();
				 ReviewOrderPageTask.placeOrder();
				 OrderDetailsPageValidation.paymentInOrderConfirmationPage();
				 OrderDetailPageTasks.getOrderConfirmationPage();
		 }else {
			 Actionsss.scrollWindowsByPixel(150);
			 WebElement buyNow= driver.findElement(By.xpath("//button[contains(@class,'buy-now')]"));
			 Actionsss.javascriptClick(buyNow);
			 Thread.sleep(2000);
			 WebElement placeOrderbuyNowStripe= driver.findElement(By.xpath("(//button[contains(text(),'Place Order')])[1]"));
			 WebElement placeOrderbuyNowBrainTree= driver.findElement(By.xpath("(//button[contains(text(),'Place Order')])[1]"));
			 if(placeOrderbuyNowBrainTree.isDisplayed()) {
				 placeOrderbuyNowBrainTree.click();
			 }else {
				 placeOrderbuyNowStripe.click();
			 }
			// Actionsss.click(pdpPage.getplaceOrderInBuyNow());
		 }
		 
		
}
}
