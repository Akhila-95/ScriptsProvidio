package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class loginPage extends baseClass{

    WebDriver lDriver;

    // Constructor for the loginPage class
    public loginPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }


    @FindBy(xpath = "//h1[contains(text(),'Login')]")
    WebElement loginPage;
    public WebElement getLoginPage() {
    	return loginPage;
    }
    // Element for Sign In button
    @FindBy(xpath = "//span[contains(text(), 'Sign In')]")
    WebElement signIn;
    // Method to click on the Sign In button
    public WebElement clickSign() {
       return signIn;
    }
    
    // Element for Sign In button
    @FindBy(xpath = "//span[contains(text(), 'Sign In')]")
    List<WebElement> signInList;
    // Method to click on the Sign In button
    public List<WebElement> clickSignList() {
       return signInList;
    }
 // Element for email input field
    @FindBy(name = "loginEmail")
      WebElement email;
    // Method to get the email input field
    public WebElement getEmail() {
        return email;
    }

    // Element for password input field
    @FindBy(name = "loginPassword")
      WebElement password;

    // Method to get the password input field
    public WebElement getPassword() {
        return password;
    }

    // Element for Login button
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
	public WebElement btnLogin;

    // Method to click on the Login button
    public WebElement clickBtnLogin() {
        return btnLogin;
    }

    // Element for Login button (JavaScript click)
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
      WebElement btnLoginjs;

    // Method to perform JavaScript click on the Login button
    public WebElement clickBtnLoginJs() {
        return btnLoginjs;
    }

    // Element for Home page logo
    @FindBy(xpath = "//img[@class='logo']")
      WebElement forHomePage;

    // Method to get the Home page logo
    public WebElement getForHomePage() {
        return forHomePage;
    }
	
    @FindBy(xpath = " //h1[@class ='account-page-title']")
      WebElement loginTitle;
    
    public WebElement getLoginTitle() {
    	return loginTitle;
    }
    
    @FindBy(xpath = "(//dd)[1]")
      WebElement userName;
    
    public WebElement getUserName() {
    	return  userName;
    }
    
    @FindBy(xpath = "(//dd)[2]")
      WebElement userEmail ;
    
    public WebElement getUserEmail() {
    	return  userEmail;
    }
    
    
    @FindBy(xpath = "//div[contains(@class, 'alert') and contains(@class, 'alert-danger')]")
    WebElement invalidLoginError;
    public WebElement getinvalidLoginError() {
    	return invalidLoginError;
    }
    
    @FindBy(xpath = "(//div[@id= 'form-email-error'])[1]")
      WebElement mailError;
    public WebElement getMailError() {
    	return mailError;
    }
    
    @FindBy(xpath = "(//div[@id= 'form-password-error'])[1]")
      WebElement passwordError;
    public WebElement getPasswordError() {
    	return  passwordError;
    }
    
    @FindBy(xpath = "(//div[@class='invalid-feedback' and @id='form-email-error'])[1]")
    WebElement invalidEmail;
    public WebElement getInvalidEmailFormatError() {
    	return invalidEmail;
    }
    
    
    @FindBy(xpath = "//h1[contains(text(),'Login')]")
    List<WebElement> loginPageList;
    public List<WebElement> getLoginPageList() {
    	logger.info(loginPageList.size());
    	return loginPageList;
    }
    
 //----------------check order------------------
  
    @FindBy(css = "input#trackorder-form-number")
    WebElement orderNumber;
    public WebElement getOrderNumber() {    	
    	return orderNumber;
    }
    
    @FindBy(css = "input#trackorder-form-email")
    WebElement orderEmail;
    public WebElement getOrderEmail() {    	
    	return orderEmail;
    }
    
    @FindBy(css = "input#trackorder-form-zip")
    WebElement billingZipCodeOfOrder;
    public WebElement getBillingZipCodeOfOrder() {    	
    	return billingZipCodeOfOrder;
    }
    
    @FindBy(xpath = "//button[contains(text(),'Check status')]")
    WebElement checkStatusBtn;
    public WebElement getCheckStatusBtn() {    	
    	return checkStatusBtn;
    }
    
    @FindBy(css = "div.confirm-details")
    WebElement orderHistory;
    public WebElement getorderHistory() {    	
    	return orderHistory;
    }
    
    @FindBy(css = "span.order-number")
    WebElement orderID;
    public WebElement getOrderID() {    	
    	return orderID;
    }
    
    @FindBy(xpath = "//div[contains(text(),'This field is required.')]")
    List<WebElement> emptyFieldError;
    public List<WebElement> getEmptyFieldError() {    	
    	return emptyFieldError;
    }
    
    @FindBy(xpath = "//div[@class='card-body']//div[@id='form-email-error']")
    WebElement invalidEmailError;
    public WebElement getInvalidEmailError() {    	
    	return invalidEmailError;
    }
    
    @FindBy(css = "div#form-zipcode-error")
    WebElement invalidBillingZipCodeError;
    public WebElement getInvalidBillingZipCodeError() {    	
    	return invalidBillingZipCodeError;
    }
    
    
    
}
