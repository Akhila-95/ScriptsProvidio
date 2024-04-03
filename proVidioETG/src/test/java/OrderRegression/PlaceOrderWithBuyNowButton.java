package OrderRegression;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import baseClass.baseClass;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.ProductDetailPage;
import tasks.CheckOutPageTasks;
import tasks.OrderDetailPageTasks;
import tasks.PaymentPageTasks;
import tasks.ProductListingPageTasks;
import tasks.ReviewOrderPageTask;
import tasks.ShippingAddressPageTasks;
import validations.OrderDetailsPageValidation;


public class PlaceOrderWithBuyNowButton extends baseClass {
	private static final ProductDetailPage pdp = new ProductDetailPage(driver);
	
	public static void pdpPagebuyNowButton() throws Exception {

			if(Actionsss.elementSize(pdp.getPdpPagination())) {
				logger.info("Pdp page is loaded");
			}else {
				ProductListingPageTasks.productclick();
			}
		}
	@Test
		public static void verifyingPlacingOrderWithBuyNowButtonWithCreditCard() throws Exception {
			 ProductListingPageTasks.gpsProducts();
			 allAttributesSelection.selectTheAttributesInPdp();
			 Actionsss.scrollWindowsByPixel(150);
			 Thread.sleep(3000);
			 WebElement buyNow= driver.findElement(By.xpath("//button[contains(@class,'buy-now')]"));
			 buyNow.click();
			 Thread.sleep(2000);
			// Actionsss.javascriptClick(pdp.getBuyNowButton());
			 CheckOutPageTasks.GuestMailCheckOut();
			 ShippingAddressPageTasks.enterValidAddress();
			 PaymentPageTasks.creditCardWithValidDetails();
			 ReviewOrderPageTask.placeOrder();
			 OrderDetailsPageValidation.paymentInOrderConfirmationPage();
			 OrderDetailPageTasks.getOrderConfirmationPage();
	}
}
