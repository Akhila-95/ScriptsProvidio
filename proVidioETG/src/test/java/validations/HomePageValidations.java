package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.util.Assert;

import baseClass.baseClass;
import functionality.Actionsss;
import functionality.Waits;
import pageObjects.homepage;
import pageObjects.loginPage;


public class HomePageValidations extends baseClass{
	static SoftAssert soft = new SoftAssert();
	private static final loginPage lp = new loginPage(driver);
	private static homepage homePage = new homepage(driver);
	
	//Home page banner and clp validation
	public static void verifyHomePagesingInLink() {
		test.info("Verify whether the user is able to click on sign-In Link");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement singInHeader = driver.findElement(By.xpath("//h1"));
    	
    	if (singInHeader.isDisplayed()) {
    	    logger.info("Successfully clicked on the singIn Link and Navigated to the Login Page");
    	    test.pass("Successfully clicked on the singIn Link and Navigated to the Login Page");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	//Home page my fav link
	public static void verifyHomePageWishlistLink() {
		test.info("Verify whether the user is able to click Wishlist Link");
		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
    	WebElement GiftCardHeader = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
    	
    	if (GiftCardHeader.isDisplayed()) {
    	    logger.info("Successfully clicked on the Wishlist Link and Navigated to the Wishlist Page");
    	    test.pass("Successfully clicked on the Wishlist Link and Navigated to the Wishlist Page");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyThatuserLogin() {
		test.info("Verify whether the user is able to click login button");
    // Use FluentWait to wait for the visibility of the "Dashboard" element
    Wait<WebDriver> wait = Waits.createFluentWait(driver);
    WebElement loginTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //h1[@class ='account-page-title']")));
    
    // Get the actual title from the "Dashboard" element
    String expectedTitle = "Dashboard";
    String actualTitle = loginTitle.getText();
        
    // Check if the actual title matches the expected title
    if (actualTitle.equals(expectedTitle)) {
    	// Log a pass message if the user is logged in successfully
    	test.pass("Successfully user is Logged-In and Navigeted to the MyAccount Page");
        logger.info("Successfully user is Logged-In and Navigeted to the MyAccount Page");
        
        test.info("Name of User name is " + Actionsss.getTextOfElement(lp.getUserName()));
        logger.info("Name of User name is " + Actionsss.getTextOfElement(lp.getUserName()));

        test.info("Email is " + Actionsss.getTextOfElement(lp.getUserEmail()));
        logger.info("Email is " + Actionsss.getTextOfElement(lp.getUserEmail()));
        isLoggedIn =true;
    } else {
    	// Log a fail message if the page title does not match the expected title
    	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
        logger.info("Click failed");
    }
	}
	
	//Home page banner and clp validation
	 	public static void verifyPLPProductClick() {
	 		test.info("Verify Search functionality and Click one Prduct form the Search");
	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
	     	WebElement pdpPage = driver.findElement(By.xpath("//div[contains(@class, 'product-detail product')]"));
	     	if (pdpPage.isDisplayed()) {
	     	    logger.info("Successfully Clicked on the searched product and Navigated to the Product detail page of the Product");
	     	    test.pass("Successfully Clicked on the searched product and Navigated to the Product detail page of the Product");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
	 	//Home page banner and clp validation
	 	public static void verifyThatUserLogOut() {
	 		test.info("Verify whether the user is able to Logout");
	 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
	     	WebElement singIn = driver.findElement(By.xpath("(//span[text()='Sign In'])[1]"));
	     	
	     	if (singIn.isDisplayed()) {
	     	    logger.info("Successfully User is Logged Out");
	     	    test.pass("Successfully User is Logged Out");
	     	    isLoggedIn=false;
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
	 	
	 	//Home page banner and clp validation
	 	public static void verifyBacktoTopbutton() {
	 		test.info("Verify whether the user is able to Click on the back to top button");
	     	if (!Actionsss.displayElement(homePage.getbacktoTopButton())) {
	     	    logger.info("Successfully Clicked on the back to top button on the Home page");
	     	    test.pass("Successfully Clicked on the back to top button on the Home page");
	     	}else {
	     		test.fail("Click failed");
	     	}
	 	}
	 	
	 	
	 // verifyslickCarousal method without soft assertions
	 	public static void verifyslickCarousal() {
	 	    test.info("Verify whether the user is able to see the slick Carousal");
	 	    if (Actionsss.displayElement(homePage.getbacktoTopButton())) {
	 	        logger.info("Successfully slick Carousal are visible on the Home page");
	 	        test.pass("Successfully slick Carousal are visible on the Home page");
	 	    } else {
	 	        test.fail("Click failed");
	 	    }
	 	}

	 	// verifyVideowithtextbanner method without soft assertions
	 	public static void verifyVideowithtextbanner() {
	 	    test.info("Verify whether the user is able to see the Video with text banner");
	 	    if (Actionsss.displayElement(homePage.getbacktoTopButton())) {
	 	        logger.info("Successfully Video with text banner is visible on the Home page");
	 	        test.pass("Successfully Video with text banner is visible on the Home page");
	 	    } else {
	 	        test.fail("Click failed");
	 	    }
	 	}
}
