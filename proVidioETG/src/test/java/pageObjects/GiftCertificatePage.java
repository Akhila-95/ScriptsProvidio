package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCertificatePage {

	WebDriver lDriver;
    //pageFactory constructor for this page
	public GiftCertificatePage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="(//div[contains(text(),'Gift Certificates')][1]")
	List<WebElement> giftCertificatePage;
	public List<WebElement> getGiftCertificatePageList() {
		return giftCertificatePage;
	}
	
//gift registry link
	@FindBy(xpath  = "//a[contains(text(),'Gift Registry')]")
	WebElement giftCardElement;
	public WebElement getGiftRegistry() {
		return giftCardElement;
	}
	
	//amount
	@FindBy(xpath = "//div[@class='amountdropdown-list']")
	WebElement giftCertificateAmount;	
	public WebElement getGiftCertificateAmount() {
		return giftCertificateAmount;
	}
	
	//amount
	@FindBy(xpath = "//div[@class='amountdropdown-list']//li")
	List<WebElement> giftCertificateAmountDropDown;		
	public List<WebElement> getgiftCertificateAmountDropDown() {
		return giftCertificateAmountDropDown;
	}
	
	//friends name
	@FindBy(xpath = "//input[@id='giftcert_purchase_recipient']")
	WebElement giftCardfriendsNameElement;		
	public WebElement getGiftCardFriendsNameElement() {
		return giftCardfriendsNameElement;
	}
	
	//yoursname
	@FindBy(xpath = "//input[@id='giftcert_purchase_from']")
	WebElement giftCardfromName;		
	public WebElement getGiftCardFromName() {
		return giftCardfromName;
	}
	
	//Friend Name
	@FindBy(xpath = "//input[@id='giftcert_purchase_recipientEmail']")
	WebElement giftCardfriendsMail;		
	public WebElement getGiftCardfriendsMail() {
		return giftCardfriendsMail;
	}
	
	//confirm friend mail
	@FindBy(xpath = "//input[@id='giftcert_purchase_confirmRecipientEmail']")
	WebElement giftCardConfirmFriendsMail;		
	public WebElement getgiftCardConfirmFriendsMail() {
		return giftCardConfirmFriendsMail;
	}
	
	@FindBy(css = "button.addto-cartbtn")
	WebElement addToCart;		
	public WebElement getAddToCart() {
	return addToCart;
	}

	// error messages
	
	@FindBy(id="form-recipient-error")
	WebElement RecipientNameError;	
	public WebElement getErrorForRecipientName() {
		return RecipientNameError;
	}
	
	@FindBy(id = "form-from-error")
	WebElement fromNameError;	
	public WebElement  getFromNameError() {
		return fromNameError;
	}
	
	@FindBy(xpath = "//div[@id='form-recipientEmail-error']")
	WebElement recipientEmailError;	
	public WebElement  getRecipientEmailError() {
		return recipientEmailError;
	}
	
	@FindBy(xpath = "//div[@id='form-email-confirm-error']")
	WebElement recipientConfirmEmailError;	
	public WebElement  getRecipientConfirmEmailError() {
		return recipientConfirmEmailError;
	}
			

	@FindBy(xpath = "//div[@class='alert alert-success add-to-basket-alert text-center']")
	WebElement addToCartSuccessMsg;	
	public WebElement getAddToCartSuccessMsg() {
	return addToCartSuccessMsg;
	}
}
