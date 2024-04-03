package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class WishlistPage extends baseClass{
	WebDriver lDriver;
    //pageFactory constructor for this page
	public WishlistPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Homepage link
	@FindBy(xpath = "//a[contains(text(), 'Home')]")
	WebElement Homelink;
	public WebElement getHomelink(){
		return Homelink;
	}
	//header wishlist
	@FindBy(xpath = "//h1[contains(text(), 'Wishlist')]")
	List<WebElement> wishlistHeader;
	public List<WebElement> getwishlistHeader(){
		return wishlistHeader;
	}
	
	//header wishlist
	@FindBy(xpath = "(//span[@class='wishlistCount'])[1]")
	WebElement wishlistCount;
	public WebElement getWishlistCount(){
		return wishlistCount;
	}
	
	//header wishlist
	@FindBy(css = "button.more-wl-items")
	WebElement moreButtonInWishlist;
	public WebElement getMoreButtonInWishlist(){
		return moreButtonInWishlist;
	}
		
	
	//remove btn
	@FindBy(xpath ="//div[@class='hidden-md-down']//button[contains(@class, 'remove-from-wishlist')]")
	List<WebElement> removeBtn; 
	public List<WebElement> getSelectremoveBtn(){
		return removeBtn;
	}
	
	//edit
	@FindBy(xpath ="//span[text()='Edit']")
	List<WebElement> editlink; 
	public List<WebElement> getSelecteditlink(){
		return editlink;
	}
	
	//edit pop modal window
	@FindBy(xpath = "//div[contains(@class, 'product-quickview')]")
	List<WebElement> editpopup;
	public List<WebElement> geteditpopup(){
		return editpopup;
	}
	
	
	
	//update btn in edit pop up
	@FindBy(xpath = "//button[contains(@class, 'update-wishlist-product')]")
	WebElement updateBtn;
	public WebElement getupdateBtn(){
		return updateBtn;
	}
	
	//close btn in edit pop up
	@FindBy(xpath = "//button[contains(@class, 'close pull-right')]")
	WebElement closeBtn;
	public WebElement getcloseBtn(){
		return closeBtn;
	}
	
	//attributes  btn
	@FindBy(xpath ="//button[contains(@class, 'select-attributes')]")
	List<WebElement> selectAttributesBtn; 
	public List<WebElement> getSelectselectAttributesBtn(){
		return selectAttributesBtn;
	}
	
	//custom input
	@FindBy(xpath ="//input[@class='quantity wishlistCustomQty']")
	List<WebElement> customInput; 
	public List<WebElement> getSelectcustomInput(){
		return customInput;
	}
	
	//Addtocart btn
	@FindBy(xpath ="//button[contains(@class, 'add-to-cart')]")
	List<WebElement> addtoCartBtn; 
	public List<WebElement> getSelectaddtoCartBtn(){
		return addtoCartBtn;
	}
	
	//create account link active
	@FindBy(xpath ="//a[@class='nav-link active']")
	List<WebElement> createAccountActive; 
	public List<WebElement> getSelectcreateAccountActive(){
		return createAccountActive;
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

}
