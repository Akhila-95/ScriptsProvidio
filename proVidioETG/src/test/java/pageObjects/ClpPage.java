package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class ClpPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public ClpPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath = "//div[contains(@id, 'cat-landing-')]")
	List<WebElement> CLPpageValidation;
	public List<WebElement> getCLPpageValidation() {
		return CLPpageValidation;
	}
	
	//add to wishList
	@FindBy(xpath ="//i[contains(@class, 'fa-heart-o')]")
	List<WebElement> AddtoWishList; 
	public List<WebElement> getSelectAddtoWishListButton(){
		return AddtoWishList;
	}
	
	//remove from wishList
	@FindBy(xpath ="//i[@class='fa fa-circle fa-inverse fa-stack-2x fa-heart']")
	List<WebElement> RemoveWishList; 
	public List<WebElement> getSelectRemoveWishListButton(){
		return RemoveWishList;
	}
	
	//product click
	@FindBy(xpath ="//a[@class ='tile-img-contain']")
	List<WebElement> ProductClick; 
	public List<WebElement> getSelectProductClick(){
		return ProductClick;
	}
	
	//QuickShopBtn click
	@FindBy(xpath ="//a[contains(text(), 'Quick Shop')]")
	List<WebElement> QuickShopBtn; 
	public List<WebElement> getSelectQuickShopBtn(){
		return QuickShopBtn;
	}
	
	

}
