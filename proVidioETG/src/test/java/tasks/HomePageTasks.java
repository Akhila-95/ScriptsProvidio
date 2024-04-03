package tasks;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.CLPpageValidation;
import validations.HomePageValidations;
import validations.MiniCartValidation;

public class HomePageTasks extends baseClass{

	private static homepage homePage = new homepage(driver);
	private static loginPage lp = new loginPage(driver);
	private static TestData TD = new TestData();
	
	//Home page mega menu
    public static void randomMegaMenu() throws InterruptedException {
  	homePage.selectRandomMegaMenu();
    }
    
    public static void clpPageLoading() throws Exception {
    	Thread.sleep(3000);
    	Actionsss.randomElementFromListforMainMenu(homePage.getCLPpage());
    	Thread.sleep(3000);
    	CLPpageValidation.verifyClpLink();
    }
    
    //wishlist
    public static void verifyThatWishlist() throws Exception {
	    // Click on the "My Favorites" link
	    Actionsss.CombinedClick(homePage.getWishListLink());
	    // Wait for 3 seconds to allow the action to complete
	    Thread.sleep(3000);
	    // Verify the result of clicking on the "My Favorites" link
	    HomePageValidations.verifyHomePageWishlistLink();
	}
    
  //gift card
    public static void verifyThatSignInLink() throws Exception {
	    // Click on the "Gift Card" link
	    Actionsss.CombinedClick(homePage.getsignInLinkLink());
	    // Wait for 3 seconds to allow the action to complete
	    Thread.sleep(3000);
	    // Verify the result of clicking on the "Gift Card" link
	    HomePageValidations.verifyHomePagesingInLink();
	}
    
  //login
    public static void verifyThatuserLogin() throws Exception {
	    // Click on the "Gift Card" link
	    Actionsss.CombinedClick(homePage.getsignInLinkLink());
	    // Wait for 3 seconds to allow the action to complete
        Thread.sleep(2000);
     // Enter valid email and password
        Actionsss.sendKeys(lp.getEmail(), TD.Valid_UserName_Login_IP_Data,TD.UserName_Login_IP_FieldName);      
        Actionsss.sendKeys(lp.getPassword(), TD.Valid_PWD_Login_IP_Data,TD.Passowrd_Login_IP_FieldName);   
        Actionsss.CombinedClick(lp.clickBtnLogin());
        logger.info("click on the submit button");
        Thread.sleep(2000);
	    // Verify the result of clicking on the "Gift Card" link
	    HomePageValidations.verifyThatuserLogin();
	}
    
  //login
    public static void verifyThatuserLogOut() throws Exception {
    	if(isLoggedIn) {
    		Actionsss.CombinedClick(homePage.clickOnLogo());
			Thread.sleep(2000);
    	}else {
    		HomePageTasks.verifyThatuserLogin();
			Actionsss.CombinedClick(homePage.clickOnLogo());
			Thread.sleep(2000);
    	}
	    // Click on the "Gift Card" link
	    Actionsss.hover(homePage.getElementhoweraccount());
	    // Wait for 3 seconds to allow the action to complete
        Thread.sleep(2000);
	    Actionsss.CombinedClick(homePage.getSelectClicklogout());
	    HomePageValidations.verifyThatUserLogOut();
        
	}
    
    //search fuctionality
    public static void searchAProduct() throws Exception {
    	
		Actionsss.sendKeys(homePage.getSearchElement(),TD.Search_Home_Page_IP_Data, TD.Search_Home_Page_IP_FieldName );
		test.info("Verify Search Input of " + searchBar);
		Thread.sleep(3000);
		Actionsss.randomElementFromList(homePage.getClickOnSearchedProduct());
		HomePageValidations.verifyPLPProductClick();
		
	}
    
   //mini cart btn check
    public static void miniCartBtnClick() throws Exception {
    	MiniCartPageTasks.miniCartValue();
    	Thread.sleep(3000);
    	Actionsss.CombinedClick(homePage.getMiniCartLink());
    	Thread.sleep(2000);
    	MiniCartValidation.VerifiedThatMinicartBtnClick();
        Thread.sleep(3000);
    }
    
    public static void slickCarousal() throws Exception {
    	Thread.sleep(3000);
    	Actionsss.scrollIntoCenterView(homePage.getslickCarousal());
    	Thread.sleep(2000);
    	HomePageValidations.verifyslickCarousal();
    }
    
    public static void Videowithtextbanner() throws Exception {
    	Thread.sleep(3000);
    	Actionsss.scrollIntoCenterView(homePage.getVideowithtextbanner());
    	Thread.sleep(2000);
    	HomePageValidations.verifyVideowithtextbanner();
    }
    
    
    public static void backtoTopBtn() throws Exception {
    	Thread.sleep(2000);
    	Actionsss.scrollBottom();
    	Thread.sleep(2000);
    	Actionsss.CombinedClick(homePage.getbacktoTopButton());
    	HomePageValidations.verifyBacktoTopbutton();
    }
    
}
