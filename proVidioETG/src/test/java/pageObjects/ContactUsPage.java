package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class ContactUsPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public ContactUsPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//contact us link
	@FindBy(xpath ="//div[@class='helpButton']")
	WebElement contactusLink; 
	public WebElement getSelectcontactusLink(){
		return contactusLink;
	}
	
	//Validation xpaths 
	@FindBy(xpath ="//h2[text()='Contact Us']")
	WebElement headerContactus; 
	public WebElement getSelectheaderContactus(){
		return headerContactus;
	}
	
	@FindBy(id ="Subject")
	WebElement subjectInContactus; 
	public WebElement getsubjectInContactus(){
		return subjectInContactus;
	}
	@FindBy(id ="SuppliedEmail")
	WebElement emailInContactus; 
	public WebElement getemailInContactus(){
		return emailInContactus;
	}

	@FindBy(id = "SuppliedName")
    WebElement nameInputInContactUs;
	public WebElement getNameInputInContactUs(){
		return nameInputInContactUs;
	}
	
	@FindBy(xpath = "//select//option")
    List<WebElement> typeDropdownInContactUs;
	public List<WebElement> getTypeDropdownInContactUsList(){
		return typeDropdownInContactUs;
	}
	
	@FindBy(css="button.submitButton")
    WebElement submitButtonInContactUs;
	public WebElement getSubmitButtonInContactUs(){
		return submitButtonInContactUs;
	}
	
	@FindBy(xpath="//h3[contains(text(),'Case submitted')]")
    WebElement caseSubmittedInContactUs;
	public WebElement getcaseSubmittedInContactUs(){
		return caseSubmittedInContactUs;
	}
	
	@FindBy(xpath="//span[contains(text(),'Done')]")
    WebElement doneInContactUs;
	public WebElement getDoneInContactUs(){
		return doneInContactUs;
	}
	
	@FindBy(css="div.embeddedServiceSidebarState")
    List<WebElement> mainDivInContactUs;
	public List<WebElement> getmainDivInContactUs(){
		return mainDivInContactUs;
	}
	
	@FindBy(xpath="//button[@title='Close dialog']")
    WebElement closeButtonInContactUs;
	public WebElement getcloseButtonInContactUs(){
		return closeButtonInContactUs;
	}
	
	//-------------------errors ------------------
	
	@FindBy(xpath="//li[contains(text(),'This field is required.')]")
    List<WebElement> errorMessagesInContactUsList;
	public List<WebElement> getErrorMessagesInContactUsList(){
		return errorMessagesInContactUsList;
	}
	
	@FindBy(xpath="//li[contains(text(),'This field is required.')]")
    WebElement errorMessagesInContactUs;
	public WebElement getErrorMessagesInContactUs(){
		return errorMessagesInContactUs;
	}
	
	@FindBy(xpath="//li[contains(text(),'Invalid Email Address')]")
    WebElement invalidErrorMessageInContactUs;
	public WebElement getInvalidErrorMessageInContactUs(){
		return invalidErrorMessageInContactUs;
	}
}
