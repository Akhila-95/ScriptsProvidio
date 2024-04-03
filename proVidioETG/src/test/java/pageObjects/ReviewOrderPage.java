package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewOrderPage {

	WebDriver lDriver;
    //pageFactory constructor for this page
	public ReviewOrderPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//div[@class='summary-details billing']")
	WebElement  summaryOfBillingAddress;
	public WebElement getgsummaryOfBillingAddress() {
		return summaryOfBillingAddress;
	}
	
	@FindBy(xpath="//div[@class='summary-details billing']")
	List<WebElement>  summaryOfBillingAddressList;
	public List<WebElement> getgsummaryOfBillingAddressList() {
		return summaryOfBillingAddressList;
	}
	
	@FindBy(xpath="//button[@aria-label='Edit Payment']")
	WebElement  editPaymentInPlaceOrderPage;
	public WebElement getEditPaymentInPlaceOrderPage() {
		return editPaymentInPlaceOrderPage;
	}
	
	@FindBy(xpath="//div[@class='credit-card-number']")
	List<WebElement>  creditCardPaymentBeforeEditList;
	public List<WebElement> getCreditCardPaymentBrainTreeBeforeEditList() {
		return  creditCardPaymentBeforeEditList;
	}
	
	@FindBy(xpath="//div[@class='credit-card-number']")
	WebElement  creditCardPaymentBeforeEdit;
	public WebElement getCreditCardPaymentBrainTreeBeforeEdit() {
		return  creditCardPaymentBeforeEdit;
	}
	
	@FindBy(css="div.paypal-email")
	List<WebElement>  paypalPaymentBeforeEditList;
	public List<WebElement> getpaypalPaymentBeforeEditList() {
		return  paypalPaymentBeforeEditList;
	}
	
	@FindBy(css="div.bt-credit-paypal")
	WebElement  brainPaypalPaymentBeforeEdit;
	public WebElement getBrainPaypalPaymentInReviewOrderPage() {
		return  brainPaypalPaymentBeforeEdit;
	}
	
	@FindBy(css="div.bt-credit-paypal")
	List<WebElement>  brainPaypalPaymentBeforeEditList;
	public List<WebElement> getBrainPaypalPaymentInReviewOrderPageList() {
		return  brainPaypalPaymentBeforeEditList;
	}
//	
//	@FindBy(xpath="//span[@class='gift-certificate']")
//	List<WebElement>  gcPaymentBeforeEditList;
//	public List<WebElement> getGcPaymentInROPList() {
//		return  gcPaymentBeforeEditList;
//	}
//	
	@FindBy(xpath="(//span[@class='gift-certificate']//div)[1]")
	WebElement  gcPaymentBeforeEdit;
	public WebElement getGcPaymentInROP() {
		return  gcPaymentBeforeEdit;
	}
	
	@FindBy(xpath="(//span[@class='gift-certificate']//div)[1]")
	List<WebElement>  gcPaymentBeforeEditList;
	public List<WebElement>  getGcPaymentInROPList() {
		return  gcPaymentBeforeEditList;
	}
	
	@FindBy(css="div.braintree-payment-details")
	List<WebElement>  brainTreeDisplay;
	public List<WebElement> getBrainTreeDisplayList() {
		return  brainTreeDisplay;
	}
	
	@FindBy(xpath="//option[@id='braintreePaypalAccount']")
	WebElement  paypalAccText;
	public WebElement getPaypalAccText() {
		return  paypalAccText;
	}

	////////////////////////////////////////////////////////////
	
	//cybersource
	
	@FindBy(xpath="(//div[@class='payment-details']//div)[1]")
	List<WebElement>  cybersourceCardDetailsInReviewOrderPageList;
	public List<WebElement> getcybersourceCardDetailsInReviewOrderPageList() {
		return  cybersourceCardDetailsInReviewOrderPageList;
	}
	
	@FindBy(xpath="(//div[@class='payment-details']//div)[1]")
	WebElement  cybersourceCardDetailsInReviewOrderPage;
	public WebElement getcybersourceCardDetailsInReviewOrderPage() {
		return  cybersourceCardDetailsInReviewOrderPage;
	}
	
	@FindBy(xpath="(//span[@class='gift-certificate']//div)[1]")
	WebElement  cybersourceGcDetailsInReviewOrderPage;
	public WebElement getcybersourceGcDetailsInReviewOrderPage() {
		return  cybersourceGcDetailsInReviewOrderPage;
	}
	
	@FindBy(xpath="(//span[@class='gift-certificate']//div)[1]")
	List<WebElement>   cybersourceGcDetailsInReviewOrderPageList;
	public List<WebElement>  getcybersourceGcDetailsInReviewOrderPageList() {
		return  cybersourceGcDetailsInReviewOrderPageList;
	}
	
	@FindBy(xpath="//span[contains(text(),'Credit Visa')]")
	List<WebElement>   cybersourceVisaInReviewOrderPageList;
	public List<WebElement>  getcybersourceVisaInReviewOrderPageList() {
		return  cybersourceVisaInReviewOrderPageList;
	}
	
	@FindBy(xpath="//span[contains(text(),' Gift Certificate')]")
	List<WebElement>   cybersourceGiftCertificateInReviewOrderPageList;
	public List<WebElement>  getcybersourceGiftCertificateInReviewOrderPageList() {
		return   cybersourceGiftCertificateInReviewOrderPageList;
	}
	
	/////////////////////////////////////////////////////////////////////
	
	
	//stripe
	@FindBy(css="div.payment-details-stripe")
	List<WebElement>   stripeDatailsInReviewOrderPageList;
	public List<WebElement>  getstripeDatailsInReviewOrderPageList() {
		return   stripeDatailsInReviewOrderPageList;
	}
	
	
	@FindBy(css="(//div[@class='payment-details-stripe']//div)[1]")
	WebElement   stripeCreditCardInReviewOrderPage;
	public WebElement  getStripeCreditCardInReviewOrderPage() {
		return   stripeCreditCardInReviewOrderPage;
	}
	
	@FindBy(xpath="(//span[@class='gift-certificate']//div)[1]")
	WebElement   stripeGcDetailsInReviewOrderPageList;
	public WebElement  getstripeGcDetailsInReviewOrderPageList() {
		return  stripeGcDetailsInReviewOrderPageList;
	}

	
	/////////////////////////////////////////////////////////////
	
	//adyen
	@FindBy(xpath="(//div[@class='payment-details']//div)[1]")
	WebElement  adyenCreditCardInReviewOrderPage;
	public WebElement getAdyenCreditCardInReviewOrderPage() {
		return  adyenCreditCardInReviewOrderPage;
	}
	
	
	@FindBy(css="div.gift-cert-code")
	WebElement   adyenGcDetailsInReviewOrderPage;
	public WebElement  getAdyenGcDetailsInReviewOrderPage() {
		return  adyenGcDetailsInReviewOrderPage;
	}
	
	
	/////////////////////////////////////////////////////////////
	
	@FindBy(xpath="(//div[@class='address1'])[2]")
	WebElement  billingAddress;
	public WebElement getBillingAddress() {
		return billingAddress;
	}
	
	@FindBy(xpath="(//div[@class='address1'])[1]")
	WebElement  shippingAddressInRop;
	public WebElement getShippingAddressInRop() {
		return shippingAddressInRop;
	}
	
	@FindBy(css="div.shipping-phone")
	WebElement  phoneNumInshippingAddressInRop;
	public WebElement getPhoneNumInshippingAddressInRop() {
		return phoneNumInshippingAddressInRop;
	}
	@FindBy(css="button[aria-label='Edit Shipping']")
	WebElement  editShippingAddressInRop;
	public WebElement getEditShippingAddressInRop() {
		return editShippingAddressInRop;
	}
	
	
	@FindBy(css="span.order-summary-phone")
	WebElement  phoneNumberInBillingAddress;
	public WebElement getPhoneNumberInBillingAddress() {
		return  phoneNumberInBillingAddress;
	}
	
	@FindBy(xpath="//button[@aria-label='Edit Payment']")
	List<WebElement>  editPaymentInPlaceOrderBtnPageList;
	public List<WebElement> getEditPaymentInPlaceOrderBtnPageList() {
		return  editPaymentInPlaceOrderBtnPageList;
	}
	@FindBy(xpath="//button[@aria-label='Edit Payment']")
	WebElement  editPaymentInPlaceOrderBtnPage;
	public WebElement getEditPaymentInPlaceOrderBtnPage() {
		return  editPaymentInPlaceOrderBtnPage;
	}
	
	@FindBy(css="a.back-to-cart")
	WebElement backToCart;
	public WebElement getBackToCart() {
		return backToCart;
	}
	
	@FindBy(xpath="//h2[contains(text(),'Order Summary')]")
	WebElement orderSummaryDiv;
	public WebElement getOrderSummaryDiv() {
		return orderSummaryDiv;
	}
	
	@FindBy(xpath="//div[@class='card shipping-summary']")
	WebElement shippingPageList;
	public WebElement getshippingInfo() {
		return shippingPageList;
	}
	
	@FindBy(css="div.customer-summary")
	WebElement customerInfo;
	public WebElement getCustomerInfo() {
		return customerInfo;
	}
	
	@FindBy(css = "div.product-detail")
	WebElement pdpPage;
	public WebElement getPdpPage() {
		return pdpPage;
	}
	
	@FindBy(xpath= "//img[@title='logo']")
	WebElement etgLogo;
	public WebElement getEtgLogo() {
		return etgLogo;
	}
	
    @FindBy(xpath ="//button[contains(text(),'Place Order')]")
  	List<WebElement> PlaceOrderBtnList;    
  	public List<WebElement> getSelectPlaceOrderBtnList(){
  		return PlaceOrderBtnList;
  	}
  	
  	 @FindBy(xpath ="//button[contains(text(),'Place Order')]")
   	WebElement PlaceOrderBtn;    
   	public WebElement getSelectPlaceOrderBtn(){
   		return PlaceOrderBtn;
   	}
}
