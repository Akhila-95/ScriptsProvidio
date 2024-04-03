package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class ProductDetailPage extends baseClass{

	WebDriver lDriver;
    //pageFactory constructor for this page
	public ProductDetailPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//wishList on Pdp page
	@FindBy(xpath ="//button[contains(@class, 'add-to-wish-list')]")
	WebElement wishListBtn; 
	public WebElement getSelectWishListBtn(){
		return wishListBtn;
	}
	
	//-----------------remove from wishlist------------------
	@FindBy(xpath ="//i[@class='fa fa-heart fa-stack-5x']")
	List<WebElement> alreadyInWishListList; 
	public List<WebElement> getalreadyInWishListList(){
		return alreadyInWishListList;
	}
	
	@FindBy(xpath ="//i[@class='fa fa-heart fa-stack-5x']")
	WebElement alreadyInWishList; 
	public WebElement getalreadyInWishList(){
		return alreadyInWishList;
	}
	
	//----------------add to wishlist---------------------------
	@FindBy(xpath ="//i[@class='fa fa-heart-o fa-stack-5x']")
	List<WebElement> addToWishListList; 
	public List<WebElement> getAddToWishListList(){
		return addToWishListList;
	}
	
	@FindBy(xpath ="//i[@class='fa fa-heart-o fa-stack-5x']")
	WebElement addToWishList; 
	public WebElement getAddToWishList(){
		return addToWishList;
	}
	//size attribute
	@FindBy(xpath ="//div[contains(@class, 'select-size')]//span[contains(@class, 'text-center') and not(contains(@disabled, 'disabled'))]")
	List<WebElement> Size; 
	public List<WebElement> getSelectSize(){
		return Size;
	}
	
	//addtoCart on Pdp page
	@FindBy(xpath ="//button[contains(@class, 'add-to-cart')]")
	WebElement addtoCartBtn; 
	public WebElement getSelectAddtoCartBtn(){
		return addtoCartBtn;
	}
	
	//addtoCart on Pdp page
	@FindBy(xpath ="//div[contains(text(),'Pre-Order')]")
	List<WebElement> preOrderList; 
	public List<WebElement> getPreOrderList(){
		return preOrderList;
	}
	
	//addtoCart on Pdp page
	@FindBy(xpath ="//div[contains(text(),'Back Order')]")
	List<WebElement> backOrderList; 
	public List<WebElement> getBackOrderList(){
		return backOrderList;
	}
	
	//addtoCart on Pdp page
	@FindBy(xpath ="//div[contains(text(), 'In Stock')]")
	List<WebElement> inStockList; 
	public List<WebElement> getInStockList(){
		return inStockList; 
	}
	
	//pick up store on Pdp page
	@FindBy(css="input#delivery-options-store")
	WebElement pickUpStore; 
	public WebElement getPickUpStore(){
		return pickUpStore;
	}
	//pick up store on Pdp page
	@FindBy(xpath="//span[contains(text(),'Find a Store')]")
	WebElement findStoreInPdp; 
	public WebElement getFindStoreInPdp(){
		return findStoreInPdp;
	}
	
	//pick up store on Pdp page
	@FindBy(xpath="//span[contains(text(),'Find a Store')]")
	List<WebElement> findStoreInPdpList; 
	public List<WebElement> getFindStoreInPdpList(){
		return findStoreInPdpList;
	}
	
	//pick up store on Pdp page
	@FindBy(css="div.change-storelink")
	List<WebElement> changeStoreInPdpList; 
	public List<WebElement> getChangeStoreInPdpList(){
		return changeStoreInPdpList;
	}
	
	//pick up store on Pdp page
	@FindBy(css="a.btn-find-in-store")
	WebElement changeStoreInPdp; 
	public WebElement getChangeStoreInPdp(){
		return changeStoreInPdp;
	}
	
	//delivery to address on Pdp page
	@FindBy(css="input#delivery-options-home")
	List<WebElement> deliveryToAddressList; 
	public List<WebElement> getDeliveryToAddressList(){
		return deliveryToAddressList;
	}
	
	@FindBy(css="input#delivery-options-home")
	WebElement deliveryToAddress; 
	public WebElement getDeliveryToAddress(){
		return deliveryToAddress;
	}
	
	@FindBy(css="div.pickupInStore-deliveryOptions")
	List<WebElement> pickUpStoreAndDeliveryToAddressList; 
	public List<WebElement> getPickUpStoreAndDeliveryToAddressList(){
		return pickUpStoreAndDeliveryToAddressList;
	}
	
	//breadcrumbs in Pdp page
	@FindBy(xpath ="(//a[@aria-current='page'])[2]")
	WebElement lastBreadcrumb; 
	public WebElement getLastBreadcrumb(){
		return lastBreadcrumb;
	}
		
	
	//bread crumbs
	@FindBy(xpath ="(//li[@class='breadcrumb-item'])[1]//a")
	WebElement breadCrumbs; 
	public WebElement getSelectbreadCrumbLink(){
		return breadCrumbs;
	}
	
	//Carasol Right
	@FindBy(xpath ="(//button[@class='slick-next slick-arrow'])[1]")
	WebElement CarasolRight; 
	public WebElement getSelectCarasolRight(){
		return CarasolRight;
	}
	
	//Carasol lift
	@FindBy(xpath ="(//button[@class='slick-prev slick-arrow'])[1]")
	WebElement CarasolLift; 
	public WebElement getSelectCarasolLift(){
		return CarasolLift;
	}
	
	//custom input
	@FindBy(xpath ="//input[@class='quantity-select']")
	WebElement CustomInput; 
	public WebElement getSelectCustomInput(){
		return CustomInput;
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
	
	
	//--------------------power reviews-----------------------
	
	@FindBy(css ="h3#war__label")
	WebElement powerReviewPage; 
	public WebElement getpowerReviewPage(){
		return powerReviewPage;
	}
	
	@FindBy(xpath ="(//a[contains(text(),'Write')])[1]")
	WebElement WriteaReview; 
	public WebElement getSelectWriteaReviewLink(){
		return WriteaReview;
	}
	//rating
	@FindBy(xpath ="//span[contains(@class, 'pr-accessible-text')]")
	List<WebElement> rating; 
	public List<WebElement> getSelectrating(){
		return rating;
	}
	//heading
	@FindBy(xpath ="//input[@name='Review Headline']")
	WebElement heading; 
	public WebElement getSelectheading(){
		return heading;
	}
	//comments
	@FindBy(xpath ="//textarea[@id='pr-comments-input']")
	WebElement comments; 
	public WebElement getSelectcomments(){
		return comments;
	}
    // WebElement for "Yes" option
    @FindBy(xpath = "//label[text()='Yes, I would recommend this to a friend']")
    WebElement forYes;
	public WebElement getSelectforYes(){
		return forYes;
	}
    // WebElement for "No" option
    @FindBy(xpath = "//input[@id='pr-plF1ZjMbk-PpfQ1jg06AR1']")
    WebElement forNo;
	public WebElement getSelectforNo(){
		return forNo;
	}
    // WebElement for nickname
    @FindBy(xpath = "//input[@id='pr-name-input']")
    WebElement nickName;
	public WebElement getSelectnickName(){
		return nickName;
	}
    // WebElement for location
    @FindBy(xpath = "//input[@id='pr-location-input']")
    WebElement location;
	public WebElement getSelectlocation(){
		return location;
	}
    // WebElement for submit review button
    @FindBy(xpath = "//button[@type='submit' and text()='Submit Review']")
    WebElement submitReview;
	public WebElement getSelectsubmitReview(){
		return submitReview;
	}
	
	//---------------buy now----------------------------
	// WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "//div[contains(@class,'salesforce-buynow-element ')]")
    WebElement salesforcePaypalBuyNow;
    public WebElement getSalesforcePaypalBuyNow() {
    	return salesforcePaypalBuyNow;
    }
// WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "//div[contains(@class,'salesforce-buynow-element ')]")
    List<WebElement> salesforcePaypalBuyNowList;
    public  List<WebElement> getSalesforcePaypalBuyNowList() {
    	return salesforcePaypalBuyNowList;
    }
    // WebElement for the "Paypal Buy Now" button
    @FindBy(css = "div.product-detail")
    List<WebElement> pdpPagination;
    public  List<WebElement> getPdpPagination() {
    	return pdpPagination;
    }
 
    // WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "//button[contains(@class,'buy-now')]")
    WebElement buyNowButton;
    public  WebElement getBuyNowButton() {
    	return buyNowButton;
    }
    // WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "(//button[contains(text(),'Place Order')])[1]")
    WebElement placeOrderInBuyNow;
    public  WebElement getplaceOrderInBuyNow() {
    	return placeOrderInBuyNow;
    }
    
    @FindBy(xpath = "(//div[@class='paywithblock'])[1]")
    WebElement defaultCreditCardInBuyNowPopUp;
    public  WebElement getDefaultCreditCardInBuyNowPopUp() {
    	return defaultCreditCardInBuyNowPopUp;
    }
    
    
    @FindBy(xpath = "(//span[@class='btn-close'])[1]")
    WebElement closeButtonInBuyNowPopUp;
    public  WebElement getCloseButtonInBuyNowPopUp() {
    	return closeButtonInBuyNowPopUp;
    }
    
    @FindBy(xpath = "(//span[@class='sales'])[1]")
    WebElement priceOfProductInPdp;
    public  WebElement getPriceOfProductInPdp() {
    	return priceOfProductInPdp;
    }
    
    @FindBy(xpath = "(//div[@class='paywithblock'])[2]")
    WebElement priceOfProductInBuyNowPopUp;
    public  WebElement getPriceOfProductInBuyNowPopUp() {
    	return priceOfProductInBuyNowPopUp;
    }
    
    
    //power reviews form
    @FindBy(xpath = "//div[@class='pr-custom-write-review-form']")
    List<WebElement> powerReviewformlist;
    public  List<WebElement> getpowerReviewformlist() {
    	return powerReviewformlist;
    }
    
    //--------------------yopo reviews ---------------
    
  //Reviewyeptoreview
	@FindBy(xpath = "//button[contains(@class,'write-review-button')]")
	WebElement ReviewButton;
	public WebElement clickOnReviewButton(){
		return ReviewButton;
	}
	//yotpo reviews list
    @FindBy(xpath = "//button[contains(@aria-label,'Click the button to write a review')]")
    List<WebElement> ReviewButtonlist;
    public  List<WebElement> getReviewButtonlist() {
    	return ReviewButtonlist;
    }
    
    @FindBy(xpath = "//div[@class='write-review-wrapper write-form visible']")
    List<WebElement> Reviewyoptoform;
    public  List<WebElement> getReviewyoptoform() {
    	return Reviewyoptoform;
    }
  
    //yopto form
	@FindBy(xpath = "//div[@class='write-review-wrapper write-form visible']")
	WebElement yoptoform;
	public WebElement getyoptoform(){
		return yoptoform;
	}
    
	//click on star
	@FindBy(xpath = "//span[@role='radio']")
	List<WebElement> ReviewStar;
	public List<WebElement> getclickOnReviewStar()  {
		return ReviewStar;
		
	}
	
	//Review title
	@FindBy(xpath = "//input[contains(@id, 'yotpo_input_review_title')]")
	WebElement Reviewtitle;
	public WebElement getsendReviewtitle()  {
		return Reviewtitle;
		
	}
	
	//Reviewdescription
	@FindBy(xpath = "//textarea[contains(@id, 'yotpo_input_review_content')]")
	WebElement Reviewdescription;
	public WebElement getsendReviewdescription()  {

		return Reviewdescription;
	}
	
	//Reviewemail
	@FindBy(xpath = "//input[contains(@id, 'yotpo_input_review_username')]")
	WebElement ReviewUserName;
	public WebElement getsendReviewUserName() {
		return ReviewUserName;
	}
	
	//Reviewdescription
	@FindBy(xpath = "//input[contains(@id, 'yotpo_input_review_email')]")
	WebElement ReviewEmail;
	public WebElement getsendReviewEmail()  {
		return ReviewEmail;
	}
	
	//Reviewpost
	@FindBy(xpath = "(//input[@class=\"yotpo-default-button primary-color-btn yotpo-submit\" and @data-button-type=\"submit\"])[1]")
	WebElement Reviewpost;
	public WebElement clickOnReviewpost()  {
		return Reviewpost;

	}
	
	//error messages
	
	@FindBy(xpath = "//span[ @class='form-input-error' and text()='Please enter a star rating for this review']")
	WebElement starerror;
	public WebElement getstarerror()  {
		return starerror;
	}
	
	@FindBy(xpath = "//span[contains(@id, 'yotpo_input_review_title_error')]")
	WebElement titleerror;
	public WebElement gettitleerror()  {
		return titleerror;
	}
	
	@FindBy(xpath = "//span[contains(@id, 'yotpo_input_review_content_error')]")
	WebElement contenterror;
	public WebElement getcontenterror()  {
		return contenterror;
	}
	
	@FindBy(xpath = "//span[contains(@id, 'yotpo_input_review_username_error')]")
	WebElement userNameerror;
	public WebElement getuserNameerror()  {
		return userNameerror;
	}
	
	@FindBy(xpath = "//span[contains(@id, 'yotpo_input_review_email_error')]")
	WebElement invalidEmailerror;
	public WebElement getinvalidEmailerror()  {
		return invalidEmailerror;
	}

	
	@FindBy(xpath = "//div[@class='yotpo-thank-you']")
	WebElement thankyoumsg;
	public WebElement getthankyoumsg()  {
		return thankyoumsg;
	}
	
	//filters search
	@FindBy(xpath = "//input[contains(@id, 'yotpo_input_free_text_search')]")
	WebElement filtersSearch;
	public WebElement getfiltersSearch()  {
		return filtersSearch;
	}
	
	
	@FindBy(xpath = "//div[@aria-label='Rating Filter']")
	WebElement RatingFilter;
	public WebElement getRatingFilter()  {
		return RatingFilter;
	}
	
	
	
	@FindBy(xpath = "//div[@aria-label='Images & Videos Filter']")
	WebElement ImageFilter;
	public WebElement getImageFilter()  {
		return ImageFilter;
	}
	
	
    @FindBy(xpath = "//ul[@class='yotpo-dropdown list-categories']//li[@data-type='scores']")
    List<WebElement> RatingFilterValue;
    public  List<WebElement> getRatingFilterValue() {
    	return RatingFilterValue;
    }
	
	
    @FindBy(xpath = "//ul[@class='yotpo-dropdown list-categories']//li[@data-type='images']")
    List<WebElement> ImageFilterValue;
    public  List<WebElement> getImageFilterValue() {
    	return ImageFilterValue;
    }
	
	//----------------social media----------------------------------
    
    @FindBy(xpath = "//span[@class='y-label' and text()='share']")
    List<WebElement> Sharelink;
    public  List<WebElement> getSharelink() {
    	return Sharelink;
    }
	
	
    
    @FindBy(xpath = "//i[@class='facebook share']")
    List<WebElement> facebookshare;
    public  List<WebElement> getfacebookshare() {
    	return facebookshare;
    }
	
	
    @FindBy(xpath = "//i[@class='twitter share']")
    List<WebElement> twittershare;
    public  List<WebElement> gettwittershare() {
    	return twittershare;
    }
	
	
    
    @FindBy(xpath = "//i[@class='LinkedIn share']")
    List<WebElement> LinkedInshare;
    public  List<WebElement> getLinkedInshare() {
    	return LinkedInshare;
    }
    
    @FindBy(css= "a#fa-link")
    WebElement shareLink;
    public  WebElement getShareLink() {
    	return shareLink;
    }
    
    
	@FindBy(xpath = "//span[@class='reviews-amount']")
	WebElement numberofReviews;
	public WebElement getnumberofReviews()  {
		return numberofReviews;
	}
	
	@FindBy(xpath = "//span[@aria-label='clear search text']")
	WebElement clearFilter;
	public WebElement getclearFilter()  {
		return clearFilter;
	}
	
	@FindBy(xpath = "//div[@class='yotpo-footer '] ")
	List<WebElement> footerFilter;
	public List<WebElement> getfooterFilter()  {
		return footerFilter;
	}
	
	@FindBy(xpath = "//span[text()='Ask A Question']")
	WebElement AskaQuestion;
	public WebElement getAskaQuestion()  {
		return AskaQuestion;
	}
	
	@FindBy(xpath = "//span[text()='Ask A Question']")
	List<WebElement> AskaQuestionbtnlist;
	public List<WebElement> getAskaQuestionbtnlist()  {
		return AskaQuestionbtnlist;
	}
	
	@FindBy(xpath = "//textarea[contains(@id,'yotpo_input_question_content')]")
	WebElement AskaQuestioninput;
	public WebElement getAskaQuestioninput()  {
		return AskaQuestioninput;
	}
	
	@FindBy(xpath = "//input[contains(@id,'yotpo_input_question_username')]")
	WebElement AskaQuestionUsername;
	public WebElement getAskaQuestionUsername()  {
		return AskaQuestionUsername;
	}
	
	@FindBy(xpath = "//input[contains(@id,'yotpo_input_question_email')]")
	WebElement AskaQuestionEmail;
	public WebElement getAskaQuestionEmail()  {
		return AskaQuestionEmail;
	}
	
	@FindBy(xpath = "(//input[@value='Post'])[2]")
	WebElement AskaQuestionpost;
	public WebElement getAskaQuestionpost()  {
		return AskaQuestionpost;
	}
	

	@FindBy(xpath = "//div[@class='write-question-wrapper write-form visible']")
	List<WebElement> AskaQuestionFormlist;
	public List<WebElement> getAskaQuestionFormlist()  {
		return AskaQuestionFormlist;
	}
	
	@FindBy(xpath = "//div[@class='write-question-wrapper write-form visible']")
	WebElement AskaQuestionForm;
	public WebElement getAskaQuestionForm()  {
		return AskaQuestionForm;
	}
	
	@FindBy(xpath = "//textarea[contains(@class,'y-input yotpo-text-box error')]")
	WebElement qusetionerror;
	public WebElement getqusetionerror()  {
		return qusetionerror;
	}
	
	@FindBy(xpath = "//input[contains(@class, 'y-input error') and @id='yotpo_input_question_username']")
	WebElement userNameerrorAskaQuestion;
	public WebElement getuserNameerrorAskaQuestion()  {
		return userNameerrorAskaQuestion;
	}
	
	@FindBy(xpath = "//input[contains(@class, 'y-input error') and @id='yotpo_input_question_email']")
	WebElement invalidEmailerrorAskaQuestion;
	public WebElement getinvalidEmailerrorAskaQuestion()  {
		return invalidEmailerrorAskaQuestion;
	}
	
	@FindBy(xpath = "//span[text() ='Thank you for posting a question!']")
	WebElement thanksmsgAskaQuestion;
	public WebElement getthanksmsgAskaQuestion()  {
		return thanksmsgAskaQuestion;
	}
	
	
	@FindBy(css = "div.product-detail")
	WebElement pdpPage;
	public WebElement getPdpPage() {
		return pdpPage;
	}	

	    // WebElement for the " Buy Now" button

	    @FindBy(xpath = "(//a[contains(@class,'buynow-placeorder')])[1]")

	    WebElement brainTreePlaceOrderBuyNow;

	    public  WebElement getBrainTreePlaceOrderBuyNow() {

	    	return brainTreePlaceOrderBuyNow;

	    }

	// WebElement for the " Buy Now" button

	    @FindBy(xpath = "(//a[contains(@class,'buynow-placeorder')])[1]")

	    List<WebElement> brainTreePlaceOrderBuyNowList;

	    public  List<WebElement> getBrainTreePlaceOrderBuyNowList() {

	    	return brainTreePlaceOrderBuyNowList;

	    }

	    // WebElement for the " Buy Now" button

	    @FindBy(xpath = "(//button[contains(@class,'buynow-placeorder-stripePayment')])[1]")

	    List<WebElement> stripePlaceOrderBuyNowList;

	    public  List<WebElement> getstripePlaceOrderBuyNowList() {

	    	return stripePlaceOrderBuyNowList;

	    }

	    @FindBy(xpath = "(//button[contains(@class,'buynow-placeorder-stripePayment')])[1]")

	    WebElement stripePlaceOrderBuyNow;

	    public  WebElement getstripePlaceOrderBuyNow() {

	    	return stripePlaceOrderBuyNow;

	    }

	    @FindBy(xpath = "(//div[@class='ship-to-block'])[1]")

	    WebElement shippingAddressinBuyNowPopUp;

	    public  WebElement getshippingAddressinBuyNowPopUp() {

	    	return shippingAddressinBuyNowPopUp;

	    }

	    @FindBy(xpath = "(//div[@class='paywithblock'])[1]")

	    WebElement paymentinBuyNowPopUp;

	    public  WebElement getPaymentinBuyNowPopUp() {

	    	return paymentinBuyNowPopUp;

	    }
	
	
		@FindBy(xpath ="//select[@class='custom-select form-control select-size']")
		WebElement selectsizelist; 
		public WebElement getselectsizelist(){
			return selectsizelist;
		}
		
		@FindBy(xpath ="//select[contains(@class,'select-color-swatch')]")
		WebElement dropdownColor; 
		public WebElement getSelectdropdownColor(){
			return dropdownColor;
		}
		
		
		@FindBy(xpath ="//select[contains(@class,'select-width')]")
		WebElement widthlist; 
		public WebElement getSelectCustomwidthlist(){
			return widthlist;
		}
		
		//-------------------recommendation -----------------------
		@FindBy(xpath ="//div[@class='recommendations']")
		List<WebElement> recommendations; 
		public List<WebElement> getRecommendations(){
			return recommendations;
		}
		
		
		@FindBy(xpath ="//a[@title='Wishlist']")
		List<WebElement> wishListInRecommendations; 
		public List<WebElement> getwishListInRecommendations(){
			return wishListInRecommendations;
		}
		
		@FindBy(xpath ="//div[@class='recommendations']//button[@aria-label='Previous']")
		WebElement previousCarouselInRecommendations; 
		public WebElement getpreviousCarouselInRecommendations(){
			return  previousCarouselInRecommendations;
		}
		
		@FindBy(xpath ="//div[@class='recommendations']//button[@aria-label='Next']")
		WebElement nextButtonCarouselInRecommendations;
		public WebElement getNextButtonCarouselInRecommendations(){
			return nextButtonCarouselInRecommendations;
		}
		
		@FindBy(css="div.pdp-link")
		List<WebElement> productNameInRecommendations;
		public List<WebElement> getProductNameInRecommendations(){
			return productNameInRecommendations;
		}
		
		@FindBy(xpath="//a[@data-addtocart='Add to Bag']")
		List<WebElement> addToCartInRecommendations;
		public List<WebElement> getAddToCartInRecommendations(){
			return addToCartInRecommendations;
		}
		
		@FindBy(css="div.color-swatches")
		List<WebElement> swatchesInRecommendations;
		public List<WebElement> getSwatchesInRecommendations(){
			return swatchesInRecommendations;
		}
		
		@FindBy(xpath="//div[@class='recommendations']//div[@class='price']")
		List<WebElement> priceInRecommendations;
		public List<WebElement> getPriceInRecommendations(){
			return priceInRecommendations;
		}
		
		@FindBy(css="div.product")
		List<WebElement> productsInRecommendations;
		public List<WebElement> getproductsInRecommendationsList(){
			return productsInRecommendations;
		}

		
		
}
