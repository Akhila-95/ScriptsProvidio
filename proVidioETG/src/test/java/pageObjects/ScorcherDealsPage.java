package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class ScorcherDealsPage extends baseClass {

		WebDriver lDriver;
	    //pageFactory constructor for this page
		public ScorcherDealsPage(WebDriver rDriver){
			lDriver =rDriver;
			PageFactory.initElements(rDriver, this);	
		}
		
		@FindBy(css="div.scorcher-deals")
		List<WebElement> scorcherDealList;
		public List<WebElement> getscorcherDealList() {
			return scorcherDealList;
		}
		
		@FindBy(css="div.scorcher-deals__product-name")
		WebElement scorcherDealProductName;
		public WebElement getScorcherDealProductName() {
			return scorcherDealProductName;
		}
		
		@FindBy(css="span.scorcher-deals__standard-price")
		WebElement scorcherDealStandardPrice;
		public WebElement getscorcherDealStandardPrice() {
			return scorcherDealStandardPrice;
		}
		
		@FindBy(css="div.scorcher-deals__quantity-container")
		WebElement qunatityInscorcherDeal;
		public WebElement getQunatityInscorcherDeal() {
			return qunatityInscorcherDeal;
		}
		
		@FindBy(css="span.scorcher-deals__sale-price")
		WebElement scorcherDealSalePrice;
		public WebElement getscorcherDealSalePrice() {
			return scorcherDealSalePrice;
		}
		
		@FindBy(css="button.scorcher-deals__button")
		WebElement scorcherDealAddToCart;
		public WebElement getScorcherDealAddToCart() {
			return scorcherDealAddToCart;
		}
		
		@FindBy(css="div.scorcher-deals__timer-container")
		WebElement timeDisplayInScorcherDeal;
		public WebElement getTimeDisplayInScorcherDeal() {
			return timeDisplayInScorcherDeal;
		}
		
		@FindBy(css="div.line-item-name")
		List<WebElement> productsInCart;
		public List<WebElement> getProductsInCart() {
			return productsInCart;
		}
}
