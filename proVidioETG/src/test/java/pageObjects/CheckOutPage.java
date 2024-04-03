package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;

public class CheckOutPage extends baseClass{
	WebDriver lDriver;
    //pageFactory constructor for this page
	public CheckOutPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//product 
    @FindBy(xpath = "//div[@class='card order-product-summary']//div[@class='line-item-name']//a[@class='line-item-text']")
    List<WebElement>  ProductLink;
    public List<WebElement>  getProductLink() {
        return ProductLink;
    }
	
	
	//back to cart button
	@FindBy(xpath ="//a[@class='back-to-cart']")
	WebElement backtoCartLink; 
	public WebElement getSelectbacktoCartLink(){
		return backtoCartLink;
	}
	
	 // Element for email input field
    @FindBy(xpath = "//input[@id='email']")
     WebElement email;
    // Method to get the email input field
    public WebElement getEmail() {
        return email;
    }

    // Element for password input field
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    // Method to get the password input field
    public WebElement getPassword() {
        return password;
    }

    // Element for Login button
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement btnLogin;
    // Method to click on the Login button
    public WebElement getSelectclickBtnLogin() {
        return btnLogin;
    }
    
    //forgot password
    @FindBy(xpath = "//a[@id='password-reset']")
    WebElement forgotpassword;
    public WebElement getforgotPassword() {
        return forgotpassword;
    }
    
    //forgot password
    @FindBy(xpath = "(//div[@class='modal-dialog']//button[@aria-label='Close'])[1]")
    WebElement closeForgotPassword;
    public WebElement getCloseForgotPassword() {
        return closeForgotPassword;
    }
    
    //forgot password header list
    @FindBy(xpath = "//h2[text()='Forgot your Password']")
    List<WebElement>  forgotpasswordHeader;
    public List<WebElement>  getforgotPasswordHeader() {
        return forgotpasswordHeader;
    }
    
    //forgot password header
    @FindBy(xpath = "//h2[text()='Forgot your Password']")
    WebElement  forgotpasswordHeaderone;
    public WebElement  getforgotPasswordHeaderone() {
        return forgotpasswordHeaderone;
    }
    
    
    //email input field
    @FindBy(xpath = "//input[@id='reset-password-email']")
     WebElement forgotpasswordemail;
    // Method to get the email input field
    public WebElement getforgotpasswordEmail() {
        return forgotpassword;
    }
    
    @FindBy(xpath = "//input[@id='reset-password-email']")
    WebElement forgotpasswordemailHardcodeinvalid;
   // Method to get the email input field
   public void getforgotpasswordEmailhardcodeinvalid() {
        forgotpasswordemailHardcodeinvalid.sendKeys("Invalid");;
   }
   
   @FindBy(xpath = "//input[@id='reset-password-email']")
   WebElement forgotpasswordemailHardcode;
  // Method to get the email input field
  public void getforgotpasswordEmailhardcodevalid() {
	  forgotpasswordemailHardcode.clear();
      forgotpasswordemailHardcode.sendKeys("Upendra.y@gmail.com");;
  }
    
    //send button in forgot password
    @FindBy(xpath = "(//button[@id='submitEmailButton'])[1]")
    WebElement forgotpasswordSendBtn;
   // Method to get the email input field
   public WebElement getforgotpasswordSendBtn() {
       return forgotpasswordSendBtn;
   }
   
   //close btn
   @FindBy(xpath = "(//button[@id='submitEmailButton'])[1]")
   WebElement forgotpasswordCloseBtn;
  // Method to get the email input field
  public WebElement getforgotpasswordCloseBtn() {
      return forgotpasswordCloseBtn;
  }
  
  //login forgot password
  @FindBy(xpath = "//div[@class='send-email-btn']//button[text()='Login']")
  WebElement forgotpasswordLoginBtn;
 // Method to get the email input field
 public WebElement getforgotpasswordLoginBtn() {
     return forgotpasswordLoginBtn;
 }

   
   //error xpaths for the forgot password
   //empty error
   @FindBy(xpath = "//div[text()='This field is required.']")
   WebElement forgotpasswordemptyerror;
  // Method to get the email input field
  public WebElement getforgotpasswordemptyerror() {
      return forgotpasswordemptyerror;
  }
  
  //invalid error
  @FindBy(xpath = "//div[contains(text(), 'Please include an')]")
  WebElement forgotpasswordInvaliderror;
 // Method to get the email input field
   public WebElement getforgotpasswordInvaliderror() {
     return forgotpasswordInvaliderror;
   }
   
   @FindBy(xpath = "//div[contains(text(), 'Please include an')]")
   List<WebElement> forgotpasswordInvaliderrorlist;
  // Method to get the email input field
    public List<WebElement> getforgotpasswordInvaliderrorlist() {
      return forgotpasswordInvaliderrorlist;
    }
    
    
    
    //singUp
    
    @FindBy(xpath = "//form[@id='registered-customer']//a[contains(text(),'Sign Up')]")
	WebElement singUPLink;
	// Method to click on the Create Account link
	public  WebElement getCreatesingUPLinktLink() {
	    return singUPLink;
	}

	//help center	
	@FindBy(xpath = "//span[contains(text(),'Need Help? Call ')]//a")
	List<WebElement> needHelpList;
	public  List<WebElement> getNeedHelpList() {	 
	    return needHelpList;
	}
	
	@FindBy(xpath = "//span[contains(text(),'Need Help? Call ')]//a")
	WebElement needHelp;
	public  WebElement getNeedHelp() {	 
	    return needHelp;
	}
	// Element for First Name input field
	@FindBy(id = "registration-form-fname")
	WebElement firstNameInput;
	// Method to enter first name
	public  WebElement getFirstName() {	 
	    return firstNameInput;
	}

	// Element for Last Name input field
	@FindBy(id = "registration-form-lname")		
	WebElement lastNameInput;
	// Method to enter last name
	public  WebElement getLastName() {	   
	    return lastNameInput;
	}

	// Element for Phone Number input field
	@FindBy(id = "registration-form-phone")
	WebElement phoneInput;
	// Method to enter phone number
	public  WebElement getPhone() {
	    return phoneInput;
	}

	// Element for Email input field
	@FindBy(id = "registration-form-email")
	WebElement emailInput;
	// Method to enter email
	public  WebElement getCreateEmail() {	  
	    return emailInput;
	}

	// Element for Confirm Email input field
	@FindBy(id = "registration-form-email-confirm")
	WebElement confirmEmailInput;
	// Method to enter confirm email
	public  WebElement getConfirmEmail() {
	    return confirmEmailInput;
	}

	// Element for Password input field
	@FindBy(id = "registration-form-password")
	WebElement passwordInput;
	// Method to enter password
	public  WebElement getCreatePassword() {	   
	    return passwordInput;
	}

	// Element for Confirm Password input field
	@FindBy(id = "registration-form-password-confirm")
	WebElement confirmPasswordInput;
	// Method to enter confirm password
	public  WebElement getConfirmPassword() {    
	    return confirmPasswordInput;
	}

	// Element for Create Account button
	@FindBy(xpath = "//button[contains(text(), 'Create Account')]")
	WebElement createAccountButton;
	// Method to click on the Create Account button
	public  WebElement getCreateAccountButton() {
	    return createAccountButton;
	}
	
	//signUp page
	@FindBy(xpath = "//h1[text()='Login']")
	List<WebElement> signUpHeaders;
	public List<WebElement> getsignUpHeaders() {
		return signUpHeaders;
	}
	
	//list
	@FindBy(xpath = "//h1[text()='Login']")
	WebElement signUpHeader;
	public WebElement getsignUpHeader() {
		return signUpHeader;
	}
	
	
	//erro xpaths
	
	//all the empty error
	@FindBy(xpath = "(//div[contains(text(),'This field is required.')])")
	List<WebElement> allFieldsErrorList;
	public List<WebElement> getAllFieldsErrorList() {
		return allFieldsErrorList;
	}
	
	//single error empty
	@FindBy(xpath = "(//div[contains(text(),'This field is required.')])")
	WebElement allFieldsError;
	public WebElement getAllFieldsError() {
		return allFieldsError;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Please enter the same value again.')]")
	WebElement sameMailError;
	public WebElement getSameMailError() {
		return sameMailError;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Does not match password')]")
	WebElement passwordMismatchError;
	public WebElement getPasswordMismatchError() {
		return passwordMismatchError;
	}
	
	
	@FindBy(xpath = "//div[contains(text(),'This field needs at least 8 characters, 1 number, 1 lowercase letter, 1 uppercase letter, & 1 special character.')]")
	WebElement passwordFieldStrength;
	public WebElement getpasswordFieldStrength() {
		return passwordFieldStrength;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Already exists, Please enter another value.')]")
	WebElement alreadyEmailExists;
	public WebElement getalreadyEmailExists() {
		return alreadyEmailExists;
	}
	
	@FindBy(xpath = "//div[contains(text(),'Please enter a valid phone number')]")
	WebElement phoneNumberError;
	public WebElement getphoneNumberError() {
		return phoneNumberError;
	}		

	@FindBy(xpath = "(//div[@id='form-email-error'])[2]")
	WebElement emailFormatError;
	public WebElement getemailFormatError() {
		return emailFormatError;
	}
	
	@FindBy(xpath = "//h1[@class='account-page-title']")
	WebElement accountPageTitle;
	public WebElement getAccountPageTitle() {
		return accountPageTitle;
	}
	
	

    
    //guest loing
    
	//Guest login btn
	@FindBy(xpath ="//button[contains(text(), 'Guest Checkout')]")
	WebElement GuestCheckoutBtn; 
	public WebElement getSelectGuestCheckoutBtn(){
		return GuestCheckoutBtn;
	}
	
	//Guest login email input
	@FindBy(xpath ="//input[@id='email-guest']")
	WebElement GuestEmailInput; 
	public WebElement getSelectGuestEmailInput(){
		return GuestEmailInput;
	}
	
	//continue Guest login btn
	@FindBy(xpath ="//button[contains(text(), 'Continue as guest')]")
	WebElement ContinueasGuesttBtn; 
	public WebElement getSelectContinueasGuesttBtn(){
		return ContinueasGuesttBtn;
	}
	
	
	//Error xpaths here
	
	//login
	//mail
	@FindBy(xpath = "(//div[text()='This field is required.'])[1]")
    WebElement emptyEmail;
    public WebElement getemptyLoginError() {
    	return emptyEmail;
    }
    
    //password
    @FindBy(xpath = "(//div[text()='This field is required.'])[2]")
      WebElement emptyPassword;
    public WebElement getemptyPasswordError() {
    	return emptyPassword;
    }
    
    //invalid mail
    @FindBy(xpath = "(//div[@id='emailHelp'])[1]")
    WebElement invalidEmail;
	public WebElement getinvalidEmailError() {
	  	return invalidEmail;
    }
	
	//password
    @FindBy(xpath = "//div[text()='This field is required.']")
      WebElement emptyPassword1;
    public WebElement getemptyPasswordError1() {
    	return emptyPassword1;
    }
	
    @FindBy(xpath = "(//div[@id= 'form-password-error'])[1]")
      WebElement passwordError;
    public WebElement getPasswordError() {
    	return  passwordError;
    }
    
  //Guest login btn
  	@FindBy(xpath ="//button[contains(text(), 'Guest Checkout')]")
  	List<WebElement> GuestCheckoutBtnList; 
  	public List<WebElement> getSelectGuestCheckoutBtnList(){
  		return GuestCheckoutBtnList;
  	}
  	@FindBy(xpath ="//div[@data-customer-type='guest']")
  	List<WebElement> guestCheckout; 
  	public List<WebElement> getGuestCheckout(){
  		return guestCheckout;
  	}


	
	

}
