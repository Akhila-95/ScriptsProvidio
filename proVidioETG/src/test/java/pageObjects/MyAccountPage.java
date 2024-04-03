package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class MyAccountPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public MyAccountPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//MyAccount
	@FindBy(xpath="(//a[contains(text(), 'My Account') and @role='menuitem'])[1]")
	WebElement myAccountLink;
	public WebElement getElementMyAccountLink(){
	   return myAccountLink;
	}
	
	//list of my accountlink
	@FindBy(xpath="(//a[contains(text(), 'My Account') and @role='menuitem'])[1]")
	List<WebElement> myAccountLinklist;
	public List<WebElement> getElementMyAccountLinklist(){
	   return myAccountLinklist;
	}
	
	//my account page headerlist
	@FindBy(xpath="//h1[@class='account-page-title']")
	List<WebElement> myAccountpageHeaderlist;
	public List<WebElement> getmyAccountpageHeaderlist(){
	   return myAccountpageHeaderlist;
	}
	
	 //MyOrders
	@FindBy(xpath="(//a[contains(text(), 'My Orders') and @role='menuitem'])[1]")
	WebElement myOrdersLink;
	public WebElement getElementMyOrdersLink(){
	   return myOrdersLink;
	}
	
	//edit profile 
	@FindBy(xpath="//a[@aria-label='Edit Profile']")
	WebElement editProfileLink;
	public WebElement getElementeditProfileLink(){
	   return editProfileLink;
	}
	
	//edit profile header
	@FindBy(xpath="//h2[text()='Edit Profile']")
	List<WebElement> editProfileHeader;
	public List<WebElement> geteditProfileHeader(){
	   return editProfileHeader;
	}
	
	//first name
	@FindBy(xpath="//input[@id='firstName']")
	WebElement editfirstName;
	public WebElement geteditfirstName(){
	   return editfirstName;
	}
	
	//last name
	@FindBy(xpath="//input[@id='lastName']")
	WebElement editlastName;
	public WebElement geteditlastName(){
	   return editlastName;
	}
	
	//phone
	@FindBy(xpath="//input[@id='phone']")
	WebElement editphone;
	public WebElement geteditphone(){
	   return editphone;
	}
	
	//email
	@FindBy(xpath="//input[@id='email']")
	WebElement editemail;
	public WebElement geteditemail(){
	   return editemail;
	}
	
	//conform email
	@FindBy(xpath="//input[@id='confirmEmail']")
	WebElement editconformemail;
	public WebElement geteditconformemail(){
	   return editconformemail;
	}
	
	//password
	@FindBy(xpath="//input[@id='password']")
	WebElement editpassword;
	public WebElement geteditpassword(){
	   return editpassword;
	}

	//home link
	@FindBy(xpath="//a[contains(text(), 'Home')]")
	WebElement homeLink;
	public WebElement gethomeLink(){
	   return homeLink;
	}
	
	//my account link
	@FindBy(xpath="//li[@class='breadcrumb-item']//a[contains(text(), 'My Account')]")
	WebElement myaccountlink;
	public WebElement getmyaccountlink(){
	   return myaccountlink;
	}
	
	
	//error xpaths of edit profle
	@FindBy(xpath="//div[text()='Please fill out this field.']")
	List<WebElement> editProfileemptyErrors;
	public List<WebElement> geteditProfileemptyErrors(){
	   return editProfileemptyErrors;
	}
	
	//invalid phone
	@FindBy(xpath="//div[text()='Please match the requested format.']")
	WebElement invalidPhone;
	public WebElement getinvalidPhone(){
	   return invalidPhone;
	}
	
	//invalid email
	@FindBy(xpath = "//div[contains(text(), 'Please include an')]")
	WebElement emailFormatError;
	public WebElement getemailFormatError() {
		return emailFormatError;
	}
	
	//miss match email
	
	@FindBy(xpath = "//div[contains(text(),'Please enter the same value again.')]")
	WebElement sameMailError;
	public WebElement getSameMailError() {
		return sameMailError;
	}

	//password dos not match
	@FindBy(xpath = "//div[contains(text(),'Does not match the current password')]")
	WebElement passwordMismatchError;
	public WebElement getPasswordMismatchError() {
		return passwordMismatchError;
	}
	

	
	//change password 
	@FindBy(xpath="//a[@aria-label='Change Password']")
	WebElement changePasswordLink;
	public WebElement getElementchangePasswordLink(){
	   return changePasswordLink;
	}
	
	//header of change password page
	@FindBy(xpath="//h2[text()='Change Password']")
	List<WebElement> changePWDHeader;
	public List<WebElement> getchangePWDHeader(){
	   return changePWDHeader;
	}
	
	//currentPassword
	@FindBy(xpath="//input[@id='currentPassword']")
	WebElement currentPassword;
	public WebElement setcurrentPassword(){
		return currentPassword;
	}
	//newpw
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement newPassword;
	public WebElement setnewPassword(){
		return newPassword;
	}
	//conformNewPassword
	@FindBy(xpath="//input[@id='newPasswordConfirm']")
	WebElement newPasswordConfirm;
	public WebElement setnewPasswordConfirm(){
		return newPasswordConfirm;
	}
	
	
	//errors messages
	@FindBy(xpath="//div[contains(text(),'This field is required.')]")
	List<WebElement> changePWDError;
	public List<WebElement> getchangePWDError(){
	   return changePWDError;
	}
	
	//miss match email
	@FindBy(xpath = "//div[contains(text(),'Passwords do not match')]")
	WebElement samepwdError;
	public WebElement getsamepwdError() {
		return samepwdError;
	}
	
	
	
	
	//view address book
	@FindBy(xpath="//a[@aria-label='View Address Book']")
	WebElement viewAddressBookLink;
	public WebElement getElementviewAddressBookLink(){
	   return viewAddressBookLink;
	}
	
	
	//address book header
	@FindBy(xpath="//h1[text()='Address Book']")
	List<WebElement> addressbookHeader;
	public List<WebElement> getaddressbookHeader(){
	   return addressbookHeader;
	}
	
	//edit 
	@FindBy(xpath="//a[text()='Edit']")
	List<WebElement> editAddressBookLink;
	public List<WebElement> geteditAddressBookLink(){
	   return editAddressBookLink;
	}
	
	//remove button
	@FindBy(xpath="//button[contains(@class, 'remove-btn')]")
	List<WebElement> removebutton;
	public List<WebElement> getremovebutton(){
	   return removebutton;
	}
	
	//cancel button
	@FindBy(xpath ="//button[contains(text(), 'Cancel')]")
	WebElement removebuttoncancelButton; 
	public WebElement getremovebuttoncancelButton(){
		return removebuttoncancelButton;
	}
	
	//pop up header
	@FindBy(xpath="//h2[text()='Delete Address?']")
	List<WebElement> removeBtnHeader;
	public List<WebElement> getremoveBtnHeader(){
	   return removeBtnHeader;
	}
	
	//ok button
	@FindBy(xpath ="//button[contains(@class, 'delete-confirmation')]")
	WebElement okbuttoncancelButton; 
	public WebElement getokbuttoncancelButton(){
		return okbuttoncancelButton;
	}
	//popup close button
	@FindBy(xpath ="//button[contains(@class, 'close') and @aria-label='Close dialog']")
	WebElement popupCloseButton; 
	public WebElement getpopupCloseButton(){
		return popupCloseButton;
	}
	//make as default
	@FindBy(xpath="//a[contains(text(), 'Make Default')]")
	List<WebElement> makeAsDefault;
	public List<WebElement> getmakeAsDefaultLink(){
	   return makeAsDefault;
	}
	
	//add new address
	@FindBy(xpath ="//a[contains(text(), 'Add New')]")
	WebElement addNewAddress; 
	public WebElement getaddNewAddressLink(){
		return addNewAddress;
	}
	
	//add new address header
	@FindBy(xpath="//h2[contains(text(), 'Add New Address')]")
	List<WebElement> addnewAddressHeader;
	public List<WebElement> getaddnewAddressHeader(){
	   return addnewAddressHeader;
	}
	
	//AddressTitle
    @FindBy(xpath="//input[@id='addressId']")
	WebElement AddressTitle;
	public WebElement setAddressTitle(){
		return AddressTitle;
		
	}
	
	//address book
	@FindBy(xpath ="//a[contains(text(), 'Address Book')]")
	WebElement addressBook; 
	public WebElement getaddressBookLink(){
		return addressBook;
	}
	
	
	
	
	//edit address header
	@FindBy(xpath="//h3[text()='Edit Address']")
	List<WebElement> editAddressHeader;
	public List<WebElement> geteditAddressHeader(){
	   return editAddressHeader;
	}
	
	//Fname
	@FindBy(xpath ="//input[@id='firstName']")
	WebElement firstNameInput; 
	public WebElement getSelectfirstNameInput(){
		return firstNameInput;
	}
	
	//LName
	@FindBy(xpath ="//input[@id='lastName']")
	WebElement lastNameInput; 
	public WebElement getSelectLastNameInput(){
		return lastNameInput;
	}
	
	@FindBy(xpath = "//input[@id='address1']")
	 WebElement shippingAddress;
	public  WebElement getShippingAddress() {
	    return shippingAddress;
	}

	//Phone
	@FindBy(xpath ="//input[@id='phone']")
	WebElement PhoneInput; 
	public WebElement getSelectPhoneInput(){
		return PhoneInput;
	}
	
	//-------------brain tree saved card----------
	@FindBy(xpath ="//div[@class='creditCard-accounts']//div[contains(@class,'js_stored_card')]")
	List<WebElement> savedBrainTreeCardList; 
	public List<WebElement> getSavedBrainTreeCardList(){
		return savedBrainTreeCardList;
	}
	
	// ---------------stripe saved card-----------------
	@FindBy(xpath ="//div[@class='savedPayment']")
	List<WebElement> savedStripeCardList; 
	public List<WebElement> getSavedStripeCardList(){
		return savedStripeCardList;
	}
	//errors
	
 @FindBy(xpath="//div[contains(text(), 'An address already exists with this ID')]")
    WebElement addressTitleAlreadyExists;
    public WebElement getaddressTitleAlreadyExistsErrorMsg() {
        return addressTitleAlreadyExists;
    }
	    
    @FindBy(xpath="//div[contains(text(), 'An address already exists with this ID')]")
    List<WebElement> addressTitleAlreadyExistsList;
    public  List<WebElement> getaddressTitleAlreadyExistsErrorMsgList() {
        return addressTitleAlreadyExistsList;
    }
	    
	 @FindBy(xpath="//div[contains(text(), 'Please enter a Address title.')]")
    WebElement addressTitle;
    public WebElement getaddressTitleErrorMsg() {
        return addressTitle;
    }
	 @FindBy(xpath="//div[contains(text(), 'Please enter a First name')]")
    WebElement firstNameError;
    public WebElement getFirstNameErrorMsg() {
        return firstNameError;
    }
    
    @FindBy(xpath="//div[contains(text(), 'Please enter a Last name')]")
    WebElement lastNameError;
    public WebElement getlastNameErrorMsg() {
        return lastNameError;
    }
    
    @FindBy(xpath="//div[contains(text(), 'Please enter Address information')]")
    WebElement address1Error;
    public WebElement getAddress1ErrorMsg() {
        return address1Error;
    }
	
    @FindBy(xpath="//div[contains(text(), 'Please enter a valid Phone Number.')]")
    WebElement phoneNumberError;
    public WebElement getphoneNumberErrorMsg() {
        return  phoneNumberError;
    }

	
	//add new address
	@FindBy(xpath="//a[@aria-label='Add New Address']")
	WebElement addNewAddressLink;
	public WebElement getElementaddNewAddressLink(){
	   return addNewAddressLink;
	}
	
	//------------------------Brain tree ----------------------------
	
	//BrainTreee
    @FindBy(xpath = "//div[@class ='braintree-account-add-credit-card-content']//form")
    private List<WebElement> brainTree;
    public List<WebElement> getBrainTree() {
        return brainTree;
    }
    
	//add to new cards
	@FindBy(xpath="//button[text()='Add New']")
	WebElement addNewCard;
	public  WebElement  getaddNewCard(){
	   return addNewCard;
	}
	
	//add to new cards
	@FindBy(xpath="//button[text()='Add New']")
	List<WebElement> addNewCardList;
	public List<WebElement> getaddNewCardList(){
	   return addNewCardList;
	}
	//close button
	@FindBy(xpath="//a[text()='close']")
	WebElement closebutton;
	public WebElement getclosebutton(){
	   return closebutton;
	}
	//erromessage
	@FindBy(xpath="//div[text()='Please enter valid credit card details.']")
	WebElement Errormessage;
	public WebElement getErrormessage(){
	   return Errormessage;
	}
	
	//already exists
    @FindBy(xpath = "//div[text()='Entered card is already added to the payments list.']")
    List<WebElement>  alreadyExistsError;
    public List<WebElement>  getalreadyExistsError() {
        return alreadyExistsError;
    }
	
    
    //remove 
    @FindBy(xpath = "//div[contains(@class,'js_stored_card')]//button[contains(@class, 'remove-bt')]")
    List<WebElement>  remove;
    public List<WebElement>  getremove() {
        return remove;
    }
    
    //remove 
    @FindBy(xpath = "//div[contains(@class,'js_stored_card')]//button[contains(@class, 'remove-bt')]")
    WebElement  removeCard;
    public WebElement  getremoveCard() {
        return removeCard;
    }
    
    //error while removing the card
    @FindBy(css = "div.valid-cart-error")
    WebElement  errorWhileCardRemove;
    public WebElement  getErrorWhileCardRemove() {
        return errorWhileCardRemove;
    }
    
    @FindBy(css = "div.valid-cart-error")
    List<WebElement>  errorWhileCardRemoveList;
    public List<WebElement>  getErrorWhileCardRemoveList() {
        return errorWhileCardRemoveList;
    }
    
    @FindBy(xpath = "//button[@aria-label='Close']")
    WebElement  closeTheCardRemoveError;
    public WebElement  getCloseTheCardRemoveError() {
        return closeTheCardRemoveError;
    }
    
    //makead a default
    @FindBy(xpath = "//button[contains(@class, 'make-default-card')]")
    List<WebElement>  makeAsaDefault;
    public List<WebElement>  getmakeAsaDefault() {
        return makeAsaDefault;
    }
    
  //makead a default
    @FindBy(xpath = "//div[contains(@class,'js_stored_card')]//span[@style='font-weight:bold']")
    WebElement  defaultCreditCard;
    public WebElement  getDefaultCreditCard() {
        return defaultCreditCard;
    }
    
    @FindBy(xpath = "//div[contains(@class,'paypal-accounts')]//span[@style='font-weight:bold']")
    WebElement  defaultPayPal;
    public WebElement  getDefaultPayPal() {
        return defaultPayPal;
    }
    

    
    //-------------------------------stripe------------------------------------------------------
    
    @FindBy(xpath = "//form[@form-type ='stripePaymentForm']")
    List<WebElement> stripeformlist;
    public List<WebElement> getstripeformlist() {
        return stripeformlist;
    }
  
    
    @FindBy(xpath = "//a[@aria-label='Add New Payment']")
    List<WebElement> stripelist;
    public List<WebElement> getstripelist() {
        return stripelist;
    }
    
	@FindBy(xpath="//a[@aria-label='Add New Payment']")
	WebElement stripe;
	public WebElement getstripe(){
	   return stripe;
	}
	
	@FindBy(xpath="//input[@id='cardOwner']")
	WebElement stripeName;
	public WebElement getstripeName(){
	   return stripeName;
	}
	
	//payment link
	@FindBy(xpath="//li[@class='breadcrumb-item']//a[contains(text(), 'Payments')]")
	WebElement paymentlink;
	public WebElement getpaymentlink(){
	   return paymentlink;
	}
	
	//payment page
    @FindBy(xpath = "//div[@class='paymentInstruments mt-5']")
    private List<WebElement> paymentsPage;
    public List<WebElement> getpaymentsPage() {
        return paymentsPage;
    }
    
     //view
	@FindBy(xpath="//a[@aria-label='View saved payment methods']")
	WebElement viewlink;
	public WebElement getviewlink(){
	   return viewlink;
	}

	@FindBy(xpath="//a[@aria-label='View saved payment methods']")
	List<WebElement> viewlinklist;
	public List<WebElement> getviewlinklist(){
	   return viewlinklist;
	}
	
	//page header
    @FindBy(xpath = "//h2[text()='Add New Payment']")
    private List<WebElement> paymentPageHeader;
    public List<WebElement> getpaymentPageHeader() {
        return paymentPageHeader;
    }
	
    
    //-------------------------------Cybersource------------------------------------------------------

    @FindBy(xpath = "//form[@form-type ='cybersourcePaymentForm']")
    private List<WebElement> Cybersource;
    public List<WebElement> getCybersource() {
        return Cybersource;
    }
    
    
	@FindBy(xpath="//a[@aria-label='Add New Payment']")
	WebElement cybersource;
	public WebElement getcybersource(){
	   return cybersource;
	}
	

	@FindBy(css ="form.payment-form")
	List<WebElement> cybersourceForm;
    public List<WebElement> getCybersourceForm() {
        return cybersourceForm;
    }
	
	@FindBy(xpath ="//select[@id ='month']/option")
	List<WebElement> newExpmonth;
    public List<WebElement> getCyberSourceExpmonth() {
        return newExpmonth;
    }
    
    @FindBy(xpath = "//select[@id ='year']/option")
    List<WebElement> newExpYear;
    public List<WebElement> getCyberSourceExpYear() {
        return newExpYear;
    }
	
	@FindBy(xpath="//input[@id='cardOwner']")
	WebElement cybersourceName;
	public WebElement getcybersourceName(){
	   return cybersourceName;
	}
	
	//error messages
    @FindBy(xpath = "//div[text()='Please fill out this field.']")
    private List<WebElement> emptyerror;
    public List<WebElement> getemptyerror() {
        return emptyerror;
    }
    
    @FindBy(xpath = "//div[text()='Please fill out this field.']")
    WebElement emptyerrorsingle;
    public WebElement getemptyerrorsingle() {
        return emptyerrorsingle;
    }
    
    @FindBy(xpath = "//div[text()='Please select an item in the list.']")
    private List<WebElement> dropemptyerror;
    public List<WebElement> getdropemptyerror() {
        return dropemptyerror;
    }
    
    @FindBy(xpath = "//div[text()='Please select an item in the list.']")
    WebElement dropemptyerrorsingle;
    public WebElement getdropemptyerrorsingle() {
        return dropemptyerrorsingle;
    }
    
	@FindBy(xpath="//div[text()='Credit card number invalid.']")
	WebElement cybersourcenumberInvalid;
	public WebElement getcybersourcenumberInvalid(){
	   return cybersourcenumberInvalid;
	}
	
	
    
    //---------------------------------giftCards details----------------------------------------------------

    
    //header
	@FindBy(xpath="//h2[contains(text(), 'Gift Cards')]")
	WebElement blockHader;
	public WebElement getblockHader(){
	   return blockHader;
	}

    //checkbalance input
	@FindBy(xpath="//input[@id ='giftCert']")
	WebElement checkbalanceInput;
	public WebElement getcheckbalanceInput(){
	   return checkbalanceInput;
	}
	
	//adding input
	@FindBy(xpath=" //input[@id ='giftCard']")
	WebElement addingInput;
	public WebElement getaddingInput(){
	   return addingInput;
	}
	
    //apply btn
	@FindBy(xpath="//button[@name ='submitGift']")
	WebElement applybtn;
	public WebElement getapplybtn(){
	   return applybtn;
	}
    //check btn
	@FindBy(xpath="//button[@name ='checkBalance']")
	WebElement checkbtn;
	public WebElement getcheckbtn(){
	   return checkbtn;
	}
	
    
    
    //errormessages
    
	@FindBy(xpath="//div[text()='Please enter a gift certificate code.']")
	WebElement emptyError;
	public WebElement getemptyError(){
	   return emptyError;
	}
	
	@FindBy(xpath="//div[text()='Invalid Gift Certificate Code.']")
	WebElement invalidError;
	public WebElement getinvalidError(){
	   return invalidError;
	}
	
	@FindBy(xpath="//div[text()='Insufficient Gift Certificate balance']")
	WebElement insufficientError;
	public WebElement getinsufficientError(){
	   return insufficientError;
	}
	
	@FindBy(xpath="//div[text()='Gift card belongs to a different customer']")
	WebElement differentUserError;
	public WebElement getdifferentUserError(){
	   return differentUserError;
	}
	
  
  
  
  
    
    //-------------------------------------------------------------------------------------
	
	//view whislist
	@FindBy(xpath="//a[text()='View All']")
	WebElement viewWishlistLink;
	public WebElement getElementviewWishlistLink(){
	   return viewWishlistLink;
	}
	
	//remove form wishlist
    @FindBy(xpath = "//button[@title='Remove']")
    List<WebElement>  removeProductformWishList;
    public List<WebElement>  getremoveProductformWishList() {
        return removeProductformWishList;
    }
    
    //facebook
    @FindBy(xpath="//span[contains(text(), 'Facebook')]")
	WebElement facebookLink;
	public WebElement getfacebookLink(){
	   return facebookLink;
	}
    //pictreter
	@FindBy(xpath="//span[contains(text(), 'Pinterest')]")
	WebElement pinterestLink;
	public WebElement getpinterestLink(){
	   return pinterestLink;
	}
	
    //gmail
	@FindBy(xpath="//span[contains(text(), 'Email')]")
	WebElement gmailLink;
	public WebElement getgmailLink(){
	   return gmailLink;
	}
    //twitter
	@FindBy(xpath="//span[contains(text(), 'Twitter')]")
	WebElement twitterLink;
	public WebElement gettwitterLink(){
	   return twitterLink;
	}
    //copylink
	@FindBy(xpath="//button[contains(@aria-label, 'Copy link')]")
	WebElement copyLink;
	public WebElement getcopyLink(){
	   return copyLink;
	}
    
	//-------------------------------------------------------------------------------------
    
    //view orders
	@FindBy(xpath="//a[text()='View' and @aria-label='View Order History']")
	WebElement viewOrderHistoryLink;
	public WebElement getviewOrderHistoryLink(){
	   return viewOrderHistoryLink;
	}
	 //continue shopping
	@FindBy(css="a.continue-shopping")
	WebElement continueShopping;
	public WebElement getcontinueShoppingButton(){
	   return continueShopping;
	}
	
	 //continue shopping
	@FindBy(css="a.continue-shopping")
	List<WebElement>  continueShoppingList;
	public List<WebElement>  getcontinueShoppingButtonList(){
	   return continueShoppingList;
	}

	//line items container
    @FindBy(xpath = "//div[@class='container order-list-container']")
    List<WebElement>  orderDetails;
    public List<WebElement>  getorderDetails() {
        return orderDetails;
    }
    
    @FindBy(xpath = "//div[@class='alert alert-warning']")
    List<WebElement>  orderDetailsnotContains;
    public List<WebElement>  getorderDetailsnotContains() {
        return orderDetailsnotContains;
    }
	
	
	//order history Header
    @FindBy(xpath = "//h2[text()='Order History']")
    List<WebElement>  viewOrderHistoryHeader;
    public List<WebElement>  getviewOrderHistoryHeader() {
        return viewOrderHistoryHeader;
    }
    
    //filter the order history
	@FindBy(xpath ="//select[@aria-label= 'Filter order history']//option")
	List<WebElement> filterOrderHistroy;
	public List<WebElement> getfilterOrderHistroy(){
		return filterOrderHistroy;	
	}
	//view order 
	@FindBy(xpath="//a[text()='View']")
	List<WebElement> viewOrderLink;
	public List<WebElement> getviewOrderLink(){
	   return viewOrderLink;
	}
	
	@FindBy(xpath="a[contains(text(), 'Back to Order History')]")
	WebElement myorderPage;
	public WebElement getmyorderPage(){
	   return myorderPage;
	}
	
	//orderHeader
    @FindBy(xpath = "//h2[text()='Receipt']")
    List<WebElement>  vieworderHeader;
    public List<WebElement>  getvieworderHeader() {
        return vieworderHeader;
    }
    
    //order History BreadCrumb
    @FindBy(xpath="//li[@class='breadcrumb-item']//a[contains(text(), 'Order History')]")
	WebElement orderHistoryBreadCrumb;
	public WebElement getorderHistoryBreadCrumb(){
	   return orderHistoryBreadCrumb;
	}
	
	//backtoOrder history
    @FindBy(xpath="//a[contains(text(), 'Back to Order History')]")
	WebElement backorderHistory;
	public WebElement getbackorderHistory(){
	   return backorderHistory;
	}
	
	//product line item
	@FindBy(xpath ="//a[@class='line-item-text']")
	List<WebElement> productLineItem;
	public List<WebElement> getproductLineItem(){
		return productLineItem;	
	}
	
    
	//-------------------------------------------------------------------------------------
    
    //common buttons
	//cancel button
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement editcancelbutton;
	public WebElement geteditcancelbutton(){
	   return editcancelbutton;
	}
	
	//save button
	@FindBy(xpath="//button[text()='Save']")
	WebElement editsavebutton;
	public WebElement geteditsavebutton(){
	   return editsavebutton;
	}
	
	//back to my account
	@FindBy(xpath="//a[contains(text(), 'Back to My Account')]")
	WebElement editbacktomyaccount;
	public WebElement geteditbacktomyaccount(){
	   return editbacktomyaccount;
	}
	
	@FindBy(xpath="//a[contains(@title, 'Back to My Account')]")
	WebElement editbacktomyaccountO;
	public WebElement geteditbacktomyaccountO(){
	   return editbacktomyaccountO;
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

	//----------paypal--------------------
	@FindBy(id ="paypalAccountBtLoader")
	List<WebElement> paypalInMyAccountList; 
	public List<WebElement> getPaypalInMyAccountList(){
		return paypalInMyAccountList;
	}
	
	@FindBy(css ="div.add-paypal-account")
	WebElement addNewPaypalAccountInMyAccount; 
	public WebElement getAddNewPaypalAccountInMyAccount(){
		return addNewPaypalAccountInMyAccount;
	}
	
	@FindBy(xpath ="//div[@class='js_braintree_accountPaypalButton']")
	WebElement brainTreePaypalInMyAccount; 
	public WebElement getBrainTreePaypalInMyAccount(){
		return brainTreePaypalInMyAccount;
	}
	
	@FindBy(xpath ="//div[@class='paypal-accounts']//div[contains(@class,'card-info-group')]")
	List<WebElement> paypalAccountsInMyAccountList; 
	public List<WebElement> getPaypalAccountsInMyAccountList(){
		return paypalAccountsInMyAccountList;
	}
	
	@FindBy(xpath ="//div[@class='paypal-accounts']//button[@style='display:inline-block']")
	WebElement MakeDefaultButtonInpaypalAccounts; 
	public WebElement getMakeDefaultButtonInpaypalAccountsInMyAccount(){
		return MakeDefaultButtonInpaypalAccounts;
	}
	
	@FindBy(xpath ="//div[@class='paypal-accounts']//button[@style='display:inline-block']")
	List<WebElement> MakeDefaultButtonInpaypalAccountsList; 
	public List<WebElement> getMakeDefaultButtonInpaypalAccountsInMyAccountList(){
		return MakeDefaultButtonInpaypalAccountsList;
	}
	
	@FindBy(xpath ="//div[@class='paypal-accounts']//div[contains(@class,'card-info-group')]")
	WebElement paypalAccountsInMyAccount; 
	public WebElement getPaypalAccountsInMyAccount(){
		return paypalAccountsInMyAccount;
	}
	
	@FindBy(css="button.remove-bt-payment ")
	WebElement removeButtonInpaypalAccountsInMyAccount; 
	public WebElement getRemoveButtonInpaypalAccountsInMyAccount(){
		return paypalAccountsInMyAccount;
	}
	
	@FindBy(xpath ="//div[@class='paypal-accounts']//span[@style='font-weight:bold']")
	WebElement defaultAccountInpaypalAccountsInMyAccountByBoldForm; 
	public WebElement getDefaultAccountInpaypalAccountsInMyAccountByBoldForm(){
		return defaultAccountInpaypalAccountsInMyAccountByBoldForm;
	}
	
	@FindBy(xpath ="//div[@class='paypal-accounts']//button[@style='display:none']")
	WebElement NoDisplayOfMakedefaultAccountInpaypalAccounts; 
	public WebElement getNoDisplayOfMakedefaultAccountInpaypalAccountsInMyAccount(){
		return NoDisplayOfMakedefaultAccountInpaypalAccounts;
	}
	
	
}
