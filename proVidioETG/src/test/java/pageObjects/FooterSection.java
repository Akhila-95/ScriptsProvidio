package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class FooterSection extends baseClass{
	WebDriver lDriver;
    //pageFactory constructor for this page
	public FooterSection(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Giftcard link
	@FindBy(xpath = "//a[text()='Gift Registry']")
	WebElement giftCardLink;
	public WebElement getGiftCardLink() throws InterruptedException {
		return giftCardLink;
	}

}
