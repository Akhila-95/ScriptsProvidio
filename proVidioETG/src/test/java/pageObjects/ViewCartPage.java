package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class ViewCartPage extends baseClass{

	WebDriver lDriver;
    //pageFactory constructor for this page
	public ViewCartPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	// ---------quantity in expand and collapse form-------
	@FindBy(xpath ="//input[contains(@class,'cartCustomQty')]")
	List<WebElement> quantityInCart; 
	public List<WebElement> getquantityInCart(){
		return quantityInCart;
	}
	
	// ---------quantity in drop down-------
	@FindBy(css ="div.customqty-stepper")
	List<WebElement> quantityInDropDownInCart; 
	public List<WebElement> getQuantityInDropDownInCart(){
		return quantityInDropDownInCart;
	}
	
	@FindBy(xpath ="//select[contains(@class,'quantity')]//option")
	List<WebElement> countOfQuantityInDropDownInCart; 
	public List<WebElement> getCountOfQuantityInDropDownInCart(){
		return countOfQuantityInDropDownInCart;
	}
	
	//----------pick up store----------
	@FindBy(xpath ="//div[contains(@class,'instore-delivery')]")
	List<WebElement> pickUpStoreInCartList; 
	public List<WebElement> getPickUpStoreInCartList(){
		return pickUpStoreInCartList;
	}
	
	@FindBy(css ="a.btn-find-in-store")
	List<WebElement> findAStoreList; 
	public List<WebElement> getfindAStoreList(){
		return findAStoreList;
	}
	
	@FindBy(css ="a.btn-find-in-store")
	WebElement findAStore; 
	public WebElement getfindAStore(){
		return findAStore;
	}
	
	@FindBy(id ="delivery-options-store")
	WebElement pickUpStoreEnable; 
	public WebElement getPickUpStoreEnable(){
		return pickUpStoreEnable;
	}
	
	@FindBy(id ="delivery-options-store")
	List<WebElement> pickUpStoreEnableList; 
	public List<WebElement> getPickUpStoreEnableList(){
		return pickUpStoreEnableList;
	}
	
	@FindBy(css ="div.selected-store-availability ")
	WebElement selectedStoreInventory; 
	public WebElement getSelectedStoreInventory(){
		return selectedStoreInventory;
	}
	
	@FindBy(xpath ="//a[contains(text(),'Change Store')]")
	WebElement changeStoreInCart; 
	public WebElement getChangeStoreInCart(){
		return changeStoreInCart;
	}
	@FindBy(id ="delivery-options-home")
	WebElement deliveryAddresInCart; 
	public WebElement getDeliveryAddresInCart(){
		return deliveryAddresInCart;
	}
	
	@FindBy(css ="div.valid-cart-error")
	WebElement maximiumQuantityError; 
	public WebElement getMaximiumQuantityError(){
		return maximiumQuantityError;
	}
	
	@FindBy(xpath ="//h4[contains(text(),'Order Summary')]")
	WebElement orderSummary; 
	public WebElement getOrderSummary(){
		return orderSummary;
	}
	
	@FindBy(xpath ="//form[@name='promo-code-form']")
	WebElement promoCodeForm; 
	public WebElement getPromoCodeForm(){
		return promoCodeForm;
	}
	
	@FindBy(css ="div.removeShipMethod")
	WebElement shippingMethodForm; 
	public WebElement getShippingMethodForm(){
		return shippingMethodForm;
	}
	
	@FindBy(css ="div.removeShipMethod")
	List<WebElement> shippingMethodFormList; 
	public List<WebElement> getShippingMethodFormList(){
		return shippingMethodFormList;
	}
		
	@FindBy(css ="div.subtotal-item")
	WebElement subTotalLabelInCart; 
	public WebElement getSubTotalLabelInCart(){
		return subTotalLabelInCart;
	}
	
	@FindBy(css ="span.sub-total")
	WebElement subTotalInCart; 
	public WebElement getSubTotalInCart(){
		return subTotalInCart;
	}
		
	@FindBy(xpath ="//p[contains(text(),'Shipping cost')]")
	WebElement shippingCostLabelInCart; 
	public WebElement getShippingCostLabelInCart(){
		return shippingCostLabelInCart;
	}
	
	@FindBy(css ="p.shipping-cost")
	WebElement shippingCostInCart; 
	public WebElement getShippingCostInCart(){
		return shippingCostInCart;
	}
	
	@FindBy(id ="shippingMethods")
	WebElement shippingMethodAsStorePickUp; 
	public WebElement getShippingMethodAsStorePickUp(){
		return shippingMethodAsStorePickUp;
	}
	
	@FindBy(xpath ="//p[contains(text(),'Sales Tax')]")
	WebElement salesTaxLabelInCart; 
	public WebElement getsalesTaxLabelInCart(){
		return salesTaxLabelInCart;
	}
	
	@FindBy(css ="p.tax-total")
	WebElement salesTaxInCart; 
	public WebElement getsalesTaxInCart(){
		return salesTaxInCart;
	}
	
	@FindBy(xpath ="//Strong[contains(text(),'Estimated Total')]")
	WebElement estimatedTotalLabelInCart; 
	public WebElement getEstimatedTotalLabelInCartInCart(){
		return estimatedTotalLabelInCart;
	}
	
	@FindBy(css ="p.grand-total")
	WebElement estimatedTotalInCart; 
	public WebElement getEstimatedTotalInCartInCart(){
		return estimatedTotalInCart;
	}
	
	//mini cart check out btn
	@FindBy(xpath ="//a[contains(text(), 'Checkout')]")
	WebElement checkOutBtn; 
	public WebElement getSelectcheckOutBtn(){
		return checkOutBtn;
	}
	
	//continue shopping 
	@FindBy(xpath ="//a[contains(text(), 'Continue Shopping')]")
	WebElement continueShopping; 
	public WebElement getSelectcontinueShoppingLink(){
		return continueShopping;
	}
	
	//edit button
	@FindBy(xpath ="//a[contains(text(), 'Edit')]")
	List<WebElement> editBtn; 
	public List<WebElement> getSelecteditBtn(){
		return editBtn;
	}
	
	//EditPop up custom input
	@FindBy(xpath ="//input[contains(@class, 'quantity-select')]")
	WebElement editPOPCustomInput; 
	public WebElement getSelecteditPOPCustomInput(){
		return editPOPCustomInput;
	}
	
	//EditPop up update btn
	@FindBy(xpath ="//button[contains(@class, 'update-cart')]")
	WebElement editPOPUpdateBtn; 
	public WebElement editPOPUpdateBtn(){
		return editPOPUpdateBtn;
	}
	
	//EditPop up close btn
	@FindBy(xpath ="//button[@class='close pull-right']")
	WebElement editPOPCloseBtn; 
	public WebElement editPOPCloseBtn(){
		return editPOPCloseBtn;
	}
	
	//moveToWishList
	@FindBy(xpath ="//a[contains(text(), 'Move to Wishlist')]")
	List<WebElement> moveToWishList; 
	public List<WebElement> getSelectMoveToWishList(){
		return moveToWishList;
	}
	
	//custom input
	@FindBy(xpath ="(//input[@class='quantity cartCustomQty'])[1]")
	WebElement CustomInput; 
	public WebElement getSelectCustomInput(){
		return CustomInput;
	}
	
	//View cart remove btn
	@FindBy(xpath ="//div[contains(@class, 'custom-delete')]//button[contains(@class, 'remove-btn')]")
	List<WebElement> removeBtn; 
	public List<WebElement> getSelectRemoveBtn(){
		return removeBtn;
	}
	
	//promo code input
	@FindBy(xpath ="//input[contains(@id, 'couponCode')]")
	WebElement CouponCode; 
	public WebElement getSelectCouponCode(){
		return CouponCode;
	}
	
	//promo-code-btn
	@FindBy(xpath ="//button[contains(@class, 'promo-code-btn')]")
	WebElement promoCodeBtn; 
	public WebElement getSelectpromoCodeBtn(){
		return promoCodeBtn;
	}
	
	
	//select shipping method
	@FindBy(xpath ="//select[@name = 'shippingMethods']//option[not(@disabled)]")
	List<WebElement> ShippingMethod; 
	public List<WebElement> getSelectShippingMethod(){
		return ShippingMethod;
	}
	
	
	@FindBy(xpath ="(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]")
	List<WebElement> salesforcePaypalInCartPageList; 
	public List<WebElement> getSalesforcePaypalInCartPageList() {
		return  salesforcePaypalInCartPageList;
	}
	//mini cart check out btn
	@FindBy(xpath ="(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]")
	WebElement salesforcePaypalInCartPage; 
	public WebElement getSalesforcePaypalInCartPage() {
		return  salesforcePaypalInCartPage;
	}
	@FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
	List<WebElement> brainTreePaypalInCartPageList;
	public List<WebElement> getBrainTreePaypalInCartList() {
		return brainTreePaypalInCartPageList;
	}
	@FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
	WebElement brainTreePaypalInCartPage;
	public WebElement getBrainTreePaypalInCartPage() {
		return brainTreePaypalInCartPage;
	}
	
	@FindBy(css = "div#content")
	List<WebElement> paypalPopUp;
	public List<WebElement> getPaypalPopUp() {
		return paypalPopUp;
	}
	
	@FindBy(id = "hermione-container")
	List<WebElement> secondPaypalPopUp;
	public List<WebElement> getSecondPaypalPopUp() {
		return secondPaypalPopUp;
	}
	
	@FindBy(xpath = "//a[@aria-label='close']")
	WebElement closePaypal;
	public WebElement getClosePaypal() {
		return closePaypal;
	}
	
	@FindBy(xpath = "//div[contains(@class,'card product-info gift-certificate uuid')]//button[contains(@class,'remove-btn-lg')]")
	WebElement removeGiftCertificateFromCart;
	public WebElement getRemoveGiftCertificateFromCart() {
		return removeGiftCertificateFromCart;
	}
	
	@FindBy(xpath = "//div[contains(@class,'card product-info gift-certificate uuid')]//button[contains(@class,'remove-btn-lg')]//span")
	List<WebElement> removeGiftCertificateFromCartList;
	public List<WebElement> getRemoveGiftCertificateFromCartList() {
		return removeGiftCertificateFromCartList;
	}
	
	
	@FindBy(xpath = "//div[contains(@class,'card product-info  uuid-')]")
	WebElement normalProductsInCart;
	public WebElement getNormalProductsInCart() {
		return normalProductsInCart;
	}
	
	@FindBy(xpath = "//div[contains(@class,'card product-info  uuid-')]")
	List<WebElement> normalProductsInCartList;
	public List<WebElement> getNormalProductsInCartList() {
		return normalProductsInCartList;
	}
	
	@FindBy(xpath = "//div[contains(@class,'card product-info  uuid-')]//div[contains(@class,'remove-line-item-lg')]")
	WebElement removeNormalProductsInCart;
	public WebElement getRemoveNormalProductsInCart() {
		return removeNormalProductsInCart;
	}
	
	@FindBy(xpath = "//div[contains(@class,'card product-info  uuid-')]//div[contains(@class,'remove-line-item-lg')]")
	List<WebElement> removeNormalProductsInCartList;
	public List<WebElement> getRemoveNormalProductsInCartList() {
		return removeNormalProductsInCartList;
	}
	
	@FindBy(xpath = "//div[contains(@class,'card product-info gift-certificate uuid-')]")
	List<WebElement> giftCertificateInCartList;
	public List<WebElement> getGiftCertificateInCartList() {
		return giftCertificateInCartList;
	}
	
	@FindBy(xpath = "//div[contains(@class,'card product-info gift-certificate uuid-')]")
	WebElement giftCertificateInCart;
	public WebElement getGiftCertificateInCart() {
		return giftCertificateInCart;
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Your Shopping Cart is Empty')]")
	WebElement cartEmptyText;
	public WebElement getCartEmptyText() {
		return cartEmptyText;
	}
	
	@FindBy(xpath ="//select[@class='quantity-select custom-select form-control']")
	List<WebElement> selectInputlist; 
	public List<WebElement> getselectInputlist(){
		return selectInputlist;
	}
	
	@FindBy(xpath ="//select[@class='quantity-select custom-select form-control']")
	WebElement dropdownInput; 
	public WebElement getSelectdropdownInput(){
		return dropdownInput;
	}
	
	
	@FindBy(xpath ="//select[@class='quantity-select custom-select form-control']/option")
	List<WebElement> CustomInputlist; 
	public List<WebElement> getSelectCustomInputlist(){
		return CustomInputlist;
	}
		
	
	@FindBy(xpath ="//select[@class='form-control quantity custom-select']")
	List<WebElement> selectInputlistPage; 
	public List<WebElement> getselectInputlistPage(){
		return selectInputlistPage;
	}
	
	@FindBy(xpath ="//select[@class='form-control quantity custom-select']")
	WebElement dropdownInputPage; 
	public WebElement getSelectdropdownInputPage(){
		return dropdownInputPage;
	}
	
	
	@FindBy(xpath ="//select[@class='form-control quantity custom-select']/option")
	List<WebElement> CustomInputlistPage; 
	public List<WebElement> getSelectCustomInputlistPage(){
		return CustomInputlistPage;
	}
		

	
	
}
