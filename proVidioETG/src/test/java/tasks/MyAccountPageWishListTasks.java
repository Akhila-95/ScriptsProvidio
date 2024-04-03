package tasks;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import baseClass.baseClass;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.MyAccountPage;
import pageObjects.WishlistPage;
import validations.MyAccountValidations;
import validations.WishListPageValidations;

public class MyAccountPageWishListTasks extends baseClass{
	
	private static WishlistPage WLP = new WishlistPage(driver);
	private static MyAccountPage MAC= new MyAccountPage(driver);
	private static final String CustomInputWL="Custom Input In WishList";
	
	public static void myAccountView() throws Exception {

		if(Actionsss.countofElements(MAC.getmyAccountpageHeaderlist())) {
			logger.info("My account page is already loaded");
		}else {		
			MyAccountPageTasks.myAccoutView();
			Thread.sleep(2000);
			WishlistPageTasks.wishlistValue();
			Thread.sleep(2000);
			MyAccountPageTasks.myAccoutView();
		}
	}
	
	public static void WishListviewLink() throws Exception {
		if(Actionsss.countofElements(WLP.getwishlistHeader())) {
			logger.info("wishlist page is already loaded");
		}else {			
			myAccountView();
			Thread.sleep(2000);
		    Actionsss.CombinedClick(MAC.getElementviewWishlistLink());
		    Thread.sleep(3000);
		    WishListPageValidations.verifyheader();
		}
	}
	
	public static void removebtninMyAccount() throws Exception {
		myAccountView();
		Thread.sleep(2000);
		Actionsss.randomElementFromListScrollIntoView(MAC.getremoveProductformWishList());
		MyAccountValidations.removefromWishlistbutton();
	}
	
    public static void facebooklink() throws Exception {
		myAccountView();
		Thread.sleep(2000);
		 String originalWindowHandle = driver.getWindowHandle();
		Actionsss.CombinedClick(MAC.getfacebookLink());
		MyAccountValidations.facebooklinkfromWishlistbutton();
		// Switch to the new tab
        switchToNewTab(driver, originalWindowHandle);
        driver.switchTo().window(originalWindowHandle);
    	Thread.sleep(2000);
    	
    }
    
	 public static void twitterklink() throws Exception {
			myAccountView();
			Thread.sleep(2000);
			String originalWindowHandle = driver.getWindowHandle();
			Actionsss.CombinedClick(MAC.gettwitterLink());
			MyAccountValidations.twitterlinkfromWishlistbutton();
			driver.switchTo().window(originalWindowHandle);
			Thread.sleep(2000);
	    }
	 
	 public static void pintresterlink() throws Exception {
			myAccountView();
			Thread.sleep(2000);
			String originalWindowHandle = driver.getWindowHandle();
			Actionsss.CombinedClick(MAC.getpinterestLink());
			MyAccountValidations.pintersetsfromWishlistbutton();
			driver.switchTo().window(originalWindowHandle);
			Thread.sleep(2000);
	 	
	 }
	 public static void gmaillink() throws Exception {
			myAccountView();
			Thread.sleep(2000);
			String originalWindowHandle = driver.getWindowHandle();
			Actionsss.CombinedClick(MAC.getgmailLink());
			MyAccountValidations.gmailfromWishlistbutton();
		//	driver.switchTo().window(originalWindowHandle);
			Thread.sleep(2000);	 	
	 }
	 public static void copylink() throws Exception {
			myAccountView();
			Thread.sleep(2000);
			Actionsss.CombinedClick(MAC.getcopyLink());
			MyAccountValidations.copyfromWishlistbutton();
	 	
	 }
	 
		public static void wishlisthomelink() throws Exception {
			WishListviewLink();
			Actionsss.CombinedClick(MAC.gethomeLink());
			Thread.sleep(2000);
			MyAccountValidations.verifyClickOnLogo();
		}
		
		public static void wishlistmyaccount() throws Exception {
			WishListviewLink();
			Actionsss.CombinedClick(MAC.getmyaccountlink());
			Thread.sleep(2000);
			MyAccountValidations.verifyuserClickedonMyAccount();
		}
		
		public static void wishlistbacktomyaccountlink() throws Exception {
			WishListviewLink();
			Actionsss.CombinedClick(MAC.geteditbacktomyaccount());
			Thread.sleep(2000);
			MyAccountValidations.verifyuserClickedonMyAccount();
		}
	

	
	//custom input
	public static void customInput() throws Exception {
		WishListviewLink();
		Thread.sleep(2000);
		Actionsss.randomElementFromListSendKeys(WLP.getSelectcustomInput(), 3, CustomInputWL);
	    Thread.sleep(3000);
	}
	
	//remove product
	public static void removeProduct() throws Exception {
		WishListviewLink();
		Thread.sleep(2000);
		test.info("Verify product reomove form the wishlist");
		Actionsss.randomElementFromListScrollIntoView(WLP.getSelectremoveBtn());
	    Thread.sleep(3000);
	    test.pass("Successfully product is reomove form the wishlist");
	    
	}
	
	//edit the product
	public static void editLink() throws Exception {
		if(Actionsss.countofElements(WLP.geteditpopup())) {
			logger.info("edit pop up is already loaded");
		}else {
			WishListviewLink();
			Thread.sleep(2000);
		    Actionsss.randomElementFromListScrollIntoView(WLP.getSelecteditlink());
		    Thread.sleep(1000);
		    WishListPageValidations.verifyeditlink();
		}
	}
	
	public static void editCloseBtn() throws Exception {
		editLink();
		Actionsss.CombinedClick(WLP.getcloseBtn());
		WishListPageValidations.verifyeditclosebtn();
	}
	
	public static void editAttributes() throws Exception {
		editLink();
		allAttributesSelection.quickshopallAttributes();
		WishListPageValidations.verifyAttributesSelection();
		Actionsss.CombinedClick(WLP.getcloseBtn());
	}
	
	public static void updatebutton() throws Exception {
		editLink();
		allAttributesSelection.selectTheAttributesInQuickShop();
		Thread.sleep(2000);
		Actionsss.CombinedClick(WLP.getupdateBtn());
		WishListPageValidations.verifyeditupdatebtn();
	}
	
	//attriubutes selection
	public static void selectAttributesLink() throws Exception {
		if(Actionsss.countofElements(WLP.geteditpopup())) {
			logger.info("attribures pop up is already loaded");
		}else {
			WishListviewLink();
			Thread.sleep(2000);
		    Actionsss.randomElementFromListScrollIntoView(WLP.getSelectselectAttributesBtn());
		    Thread.sleep(1000);
		    WishListPageValidations.verifyattribuespopuplink();
		}
	}
	
	public static void selectAttributesCloseBtn() throws Exception {
		selectAttributesLink();
		Actionsss.CombinedClick(WLP.getcloseBtn());
		WishListPageValidations.verifyeditclosebtn();
	}
	
	public static void selectAttributesAttributes() throws Exception {
		selectAttributesLink();
		allAttributesSelection.quickshopallAttributes();
		WishListPageValidations.verifyAttributesSelection();
		Thread.sleep(2000);;
		//Actionsss.CombinedClick(WLP.getcloseBtn());
	}
	
	public static void selectAttributesupdatebutton() throws Exception {
		selectAttributesLink();
		allAttributesSelection.quickshopallAttributes();
		Thread.sleep(3000);
		Actionsss.CombinedClick(WLP.getupdateBtn());
		WishListPageValidations.verifyeditupdatebtn();
	}
	
	
	//add to cart
	public static void AddtoCartbutton() throws Exception {
		WishListviewLink();
		Actionsss.randomElementFromListScrollIntoView(WLP.getSelectaddtoCartBtn());
		//Thread.sleep(2000);
		WishListPageValidations.validatingProductisAddtoCart();
	}

	
	 private static void switchToNewTab(WebDriver driver, String originalWindowHandle) {
	        // Get the handles of all open windows
	        Set<String> windowHandles = driver.getWindowHandles();

	        // Iterate through the handles to switch to the new tab
	        for (String windowHandle : windowHandles) {
	            if (!windowHandle.equals(originalWindowHandle)) {
	                // Switch to the new tab
	                driver.switchTo().window(windowHandle);
	                break;
	            }
	        }
	    }
}
