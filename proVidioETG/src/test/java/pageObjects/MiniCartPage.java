package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class MiniCartPage extends baseClass{
	WebDriver lDriver;
    //pageFactory constructor for this page
	public MiniCartPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//mini cart view cart btn
	@FindBy(xpath ="//a[contains(text(), 'View Cart')]")
	WebElement viewCartBtn; 
	public WebElement getSelectviewCartBtn(){
		return viewCartBtn;
	}
	
	//mini cart check out btn
	@FindBy(xpath ="//a[contains(text(), 'Checkout')]")
	WebElement checkOutBtn; 
	public WebElement getSelectcheckOutBtn(){
		return checkOutBtn;
	}
	
	//custom input
	@FindBy(xpath ="(//input[@class='quantity cartCustomQty'])[1]")
	WebElement CustomInput; 
	public WebElement getSelectCustomInput(){
		return CustomInput;
	}
	
	//mini cart remove btn
	@FindBy(xpath ="//button[contains(@class, 'remove-btn')]")
	List<WebElement> removeBtn; 
	public List<WebElement> getSelectRemoveBtn(){
		return removeBtn;
	}
	
	//close the mini cart
	@FindBy(xpath ="//button[contains(@class, 'minicart-close-btn')]")
	WebElement closeMiniCart; 
	public WebElement getSelectcloseMiniCart(){
		return closeMiniCart;
	}
	//mini cart count
	@FindBy(xpath ="//span[contains(@class,'minicart-quantity')]")
	WebElement miniCartCount; 
	public WebElement getMiniCartCount(){
		return miniCartCount;
	}
	
	@FindBy(css ="button.cart-delete-confirmation-btn")
	WebElement removeProductFromMiniCart; 
	public WebElement getRemoveProductFromMiniCart(){
		return removeProductFromMiniCart;
	}
	
	//total cost
	@FindBy(css="div.line-item-total-price-amount")
	List<WebElement> totalInMiniCart; 
	public List<WebElement> getTotalInMiniCart(){
		return totalInMiniCart;
	}
	
	//total cost
	@FindBy(css="p.sub-total")
	WebElement estimatedTotal; 
	public WebElement getEstimatedTotal(){
		return estimatedTotal;
	}
	
	
	@FindBy(xpath = "//div[contains(@class,'salesforce')]")
	List<WebElement> salesforcePaypalInMiniCartList;
	public List<WebElement> getSalesforcePaypalInMiniCartList() {
		return salesforcePaypalInMiniCartList;
	}
	
	@FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
	List<WebElement> brainTreePaypalInMiniCartList;
	public List<WebElement> getBrainTreePaypalInMiniCartList() {
		return brainTreePaypalInMiniCartList;
	}
	
	@FindBy(xpath = "//div[contains(@class,'salesforce')]")
	WebElement salesforcePaypalInMiniCart;
	public WebElement getSalesforcePaypalInMiniCart() {
		return salesforcePaypalInMiniCart;
	}
	
	@FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
	WebElement brainTreePaypalInMiniCart;
	public WebElement getBrainTreePaypalInMiniCart() {
		return brainTreePaypalInMiniCart;
	}
	
	@FindBy(xpath = "//a[@aria-label='close']")
	WebElement closePaypalButton;
	public WebElement getClosePaypalButton() {
		return closePaypalButton;
	}
	
	
	@FindBy(xpath ="//select[@class='form-control quantity custom-select']")
	List<WebElement> selectInputlist; 
	public List<WebElement> getselectInputlist(){
		return selectInputlist;
	}
	
	@FindBy(xpath ="//select[@class='form-control quantity custom-select']")
	WebElement dropdownInput; 
	public WebElement getSelectdropdownInput(){
		return dropdownInput;
	}
	
	
	@FindBy(xpath ="//select[@class='form-control quantity custom-select']/option")
	List<WebElement> CustomInputlist; 
	public List<WebElement> getSelectCustomInputlist(){
		return CustomInputlist;
	}

}
