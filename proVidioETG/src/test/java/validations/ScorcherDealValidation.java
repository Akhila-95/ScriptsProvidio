package validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.TestData;


public class ScorcherDealValidation extends baseClass {

	private static String text="";
	
	public static void standardAndSalePriceValidation() {
		List<WebElement> productName = driver.findElements(By.cssSelector("div.line-item-name"));
		 for (WebElement element : productName	) {
	            text = element.getText();
	            System.out.println("Element Text: " + text);
	        }
		 logger.info(TestData.scorcherDealProduct);
		 logger.info(text);
		 WebElement productPrice = driver.findElement(By.xpath("//div[contains(@class,'card product-info  ')]//div[contains(@class,'line-item-total-price-amount')]"));
		 logger.info(productPrice.getText());
		 
		// Remove the "$" and convert to double for comparison
	        double priceInHomePage = Double.parseDouble(TestData.salePrice.replace("$", ""));
	        double priceInCartPage = Double.parseDouble(productPrice.getText().replace("$", ""));
	    
	        logger.info(priceInHomePage);
	        logger.info( priceInCartPage);
		if((TestData.scorcherDealProduct.contains(text)) && (priceInHomePage==priceInCartPage)) {
			logger.info("As scorcher deal is applied for this product standard price " + TestData.standardPrice +"is decreased to  " +"sale price " +TestData.salePrice + " and price in scorcher deal is "+ TestData.salePrice + " and  in cart page is " + priceInCartPage );
			test.pass("As scorcher deal is applied for this product standard price " + TestData.standardPrice +"is decreased to  " +"sale price " +TestData.salePrice + " and price in scorcher deal is "+ TestData.salePrice + " and  in cart page is " + priceInCartPage );
		}else {
			logger.info("As scorcher deal is applied for this product standard price " + TestData.standardPrice +"is notdecreased in  " +"sale price " +TestData.salePrice);
			test.fail("As scorcher deal is applied for this product standard price " + TestData.standardPrice +"is not decreased in  " +"sale price " +TestData.salePrice);
		}
		
	}
	

	public static void standardAndSalePriceValidationAddProductFromPdp() {
		WebElement productName = driver.findElement(By.xpath("//div[contains(@class,'card product-info  ')]//div[@class='line-item-name']"));
//		 for(WebElement element : productName	) {
//	            text = element.getText();
//	            System.out.println("Element Text: " + text);
//	        }
		 logger.info(TestData.scorcherDealProduct);
		 logger.info(productName.getText());
		 WebElement productPrice = driver.findElement(By.xpath("//div[contains(@class,'card product-info  ')]//span[@class='sales']"));
		 logger.info(productPrice.getText());
		 
		// Remove the "$" and convert to double for comparison
	        double priceInHomePage = Double.parseDouble(TestData.salePrice.replace("$", ""));
	        double priceInCartPage = Double.parseDouble(productPrice.getText().replace("$", ""));
	    
	        logger.info(priceInHomePage);
	        logger.info( priceInCartPage);
		if((TestData.scorcherDealProduct.equals(productName.getText())) && (priceInHomePage==priceInCartPage)) {
			logger.info("As scorcher deal is applied for this product standard price " + TestData.standardPrice +"is decreased to  " +"sale price " +TestData.salePrice);
			test.pass("As scorcher deal is applied for this product standard price " + TestData.standardPrice +"is decreased to  " +"sale price " +TestData.salePrice);
		}else {
			logger.info("As scorcher deal is applied for this product standard price " + TestData.standardPrice +"is notdecreased in  " +"sale price " +TestData.salePrice);
			test.fail("As scorcher deal is applied for this product standard price " + TestData.standardPrice +"is not decreased in  " +"sale price " +TestData.salePrice);
		}
		
	}
}
