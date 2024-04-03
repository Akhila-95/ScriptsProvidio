package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class QuickShopPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public QuickShopPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//pdp link
	@FindBy(xpath ="//a[@class='full-pdp-link']")
	WebElement PDPLink; 
	public WebElement getSelectPDPLink(){
		return PDPLink;
	}
	
	//close button
	@FindBy(xpath ="//button[@class='close pull-right']")
	WebElement QuickShopCloseBtn; 
	public WebElement getSelectQuickShopCloseBtn(){
		return QuickShopCloseBtn;
	}
	
	@FindBy(xpath ="//button[contains(@class, 'add-to-cart')]")
	WebElement addToCartBtn; 
	public WebElement getSelectaddToCartBtn(){
		return addToCartBtn;
	}
	
	@FindBy(xpath ="//button[@aria-label='Previous']")
	WebElement prevoiusButtonInCarouselQuickShop; 
	public WebElement getPrevoiusButtonInCarouselQuickShop(){
		return prevoiusButtonInCarouselQuickShop;
	}
	
	@FindBy(xpath ="//button[@aria-label='Next']")
	WebElement nextButtonInCarouselQuickShop; 
	public WebElement getNextButtonInCarouselQuickShop(){
		return nextButtonInCarouselQuickShop;
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
	
	
	
	

}
