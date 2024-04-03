package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;
import functionality.Actionsss;



public class homepage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public homepage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	Actionsss action = new Actionsss();
    
   //to get back to homepage 
	@FindBy(xpath = "//img[@class='logo']")
	WebElement for_HomePage_logo;
	public WebElement clickOnLogo() throws InterruptedException {
		return for_HomePage_logo;
	}
	
	@FindBy(xpath = "//img[@class='logo']")
	List<WebElement>  for_HomePage_logoList;
	public List<WebElement>  clickOnLogoList() throws InterruptedException {
		return for_HomePage_logoList;
	}

	//search
	//search bar
	@FindBy(xpath = "//input[@name='q']")
	WebElement searchBarElement;
	public WebElement getSearchElement() {
		return searchBarElement;
	}
	
	//clicked on searched product
	@FindBy(xpath = "//div[contains(@class,'order-md-1 px-2 pt-3 product-container')]//span[@class='name']")
	List<WebElement> searchProduct;
	public List<WebElement> getClickOnSearchedProduct() {
		return searchProduct;
	}
	
	@FindBy(xpath = "//span[@class='name']")
	static List<WebElement>  searchProduct1List;	
	public static List<WebElement> getClickOnSearchedProduct1List() {
		return searchProduct1List;
	}
	
	@FindBy(xpath = "(//span[@class='name'])[2]")
	static WebElement  searchProduct1;	
	public static WebElement getClickOnSearchedProduct1() {
		return searchProduct1;
	}
	@FindBy(xpath= "(//h1[contains(@class,'product-name')])[2]")
	WebElement productNameInPdp;
	
	public WebElement getProductName() {
		return productNameInPdp;
	}
	

	
	//My Fav link
	@FindBy(xpath = "(//i[@class='fa fa-heart fa-lg'])[1]")
	WebElement wishListLink;
	public WebElement getWishListLink() throws InterruptedException {
		return wishListLink;
	}
		
	//My mini link
	@FindBy(xpath = "//span[contains(@class, 'minicart-quantity')]")
	WebElement miniCartLink;
	public WebElement getMiniCartLink() throws InterruptedException {
		return miniCartLink;
	}
		
	 //hower
	@FindBy(xpath="(//a[@id='myaccount' and @aria-label ='My Account'])[1]")
	WebElement myaccount;
	public WebElement getElementhoweraccount(){
	   return myaccount;
	}
	
	@FindBy(xpath = "(//a[contains(text(), 'Logout')])[1]")
    WebElement logout;
    // Method to click on the Logout link using JavaScript
    public WebElement getSelectClicklogout() {
		return logout;
      
    }
	
	
	
	//singInlink
	@FindBy(xpath = "//div[@class='user mr-3 d-none d-lg-block']//span[@class='user-message']")
	WebElement signInLink;
	public WebElement getsignInLinkLink() throws InterruptedException {
		return signInLink;
	}
	

	@FindBy(xpath = "//input[@name='q']")
	List<WebElement> searchBarElementList;	
	public List<WebElement> getSearchElementList() {
		return searchBarElementList;
	}
	@FindBy(css= "div.single-product-container")
	List<WebElement> searchedProductsList;	
	public List<WebElement> getsearchedProductsList() {
		return searchedProductsList;
	}
	@FindBy(xpath= "//button[@name='search-button']")
	WebElement searchIcon;	
	public WebElement getSearchIcon() {
		return searchIcon;
	}
	@FindBy(css= "div.search-tips")
	List<WebElement> searchTipsList;	
	public List<WebElement> getsearchTipsList() {
		return searchTipsList;
	}
	@FindBy(xpath= "//button[@name='reset-button']")
	WebElement resetButton;	
	public WebElement getResetButton() {
		return  resetButton;
	}

	//clicked on clp 
	@FindBy(xpath = "//div[contains(@class,'category-container')]//span[@class='name']")
	List<WebElement> searchProductCategory;
	public List<WebElement> getsearchProductCategory() {
		return searchProductCategory;
	}
	
	@FindBy(xpath = "//ul[contains(@class, 'nav navbar-nav')]//li[contains(@class, 'nav-item') and @role='presentation']")
	List<WebElement> CLPpage;
	public List<WebElement> getCLPpage() {
		return CLPpage;
	}
	
	@FindBy(xpath = "//div[contains(@id, 'cat-landing-')]")
	List<WebElement> CLPpageValidation;
	public List<WebElement> getCLPpageValidation() {
		return CLPpageValidation;
	}
	
	
	@FindBy(xpath = "//i[@class='fa fa-arrow-up fa-stack-1x']")
	List<WebElement> backtoTopButtonlist;
	public List<WebElement> getbacktoTopButtonlist() {
		return backtoTopButtonlist;
	}
	
	
	@FindBy(xpath= "//i[@class='fa fa-arrow-up fa-stack-1x']")
	WebElement backtoTopButton;	
	public WebElement getbacktoTopButton() {
		return  backtoTopButton;
	}
	
	
	@FindBy(xpath= "//div[@class='experience-component experience-commerce_assets-slickCarousel']")
	WebElement slickCarousal;	
	public WebElement getslickCarousal() {
		return  slickCarousal;
	}
	
	@FindBy(xpath= "//div[@class='experience-component experience-commerce_assets-videoWithTextBanner']")
	WebElement Videowithtextbanner;	
	public WebElement getVideowithtextbanner() {
		return  Videowithtextbanner;
	}

	@FindBy(css = "div.product-detail")

		WebElement pdpPage;

		public WebElement getPdpPage() {

			return pdpPage;

		}

	@FindBy(css ="div.product")

		WebElement plpPage; 

		public WebElement getPlpPage(){

			return plpPage;

		}
	
	
	public void selectGpsNavigation() throws InterruptedException {
		 
        int randomNumbermenu = 4;
        if(randomNumbermenu==4) {
        int randomNumberitem = 4;
        WebElement navigatingElectronics = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]"));
       // Thread.sleep(5000L);
        Actions action = new Actions(driver);
        action.moveToElement(navigatingElectronics).perform();
      //  Thread.sleep(5000L);
        WebElement navigatingToGPS = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", new Object[]{ navigatingToGPS});
       // Thread.sleep(10000L);
        List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
        if(newArrivalplp.size()>0) {
        	String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that NewArrivals of  " + pageTitleText + " ");
        	if(pageTitleText.equals(newArrivalsCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the NewArrivals of  " + pageTitleText + " ");
                logger.info("click Success NewArrivals of  " + pageTitleText + "");
             }
        	}else {
        	String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Electronics of  " + pageTitleText + " ");
        	if (pageTitleText.equals(electronicsCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
                logger.info("click Success Electronics of  " + pageTitleText + "");
        	}
        }
      }
        
	}


	//Mega menu
	
	public void selectRandomMegaMenu() throws InterruptedException {
		
        List<WebElement> elements = driver.findElements(By.xpath("//ul[contains(@class, 'nav navbar-nav')]//li[contains(@class, 'nav-item') and @role='presentation']"));
        int count = elements.size();
        logger.info(count);
        //int randomNumbermenu = random.nextInt(count) + 1;
        int randomNumbermenu = 2;
        if(randomNumbermenu==5 && randomNumbermenu==6) {
        	 WebElement Topsellers = driver.findElement(By.xpath("(//ul[contains(@class, 'nav navbar-nav')]//li[contains(@class, 'nav-item') and @role='presentation'])[" + randomNumbermenu + "]"));
        	 Topsellers.click();
        }else {
        List<WebElement> elementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + randomNumbermenu + "]//a[@class='dropdown-link']"));
        int countdropdown = elementsofdrop.size();
        countdropdown = countdropdown-3;
      //  int randomNumberitem = random.nextInt(countdropdown) + 1;
        //int randomNumberitem = 3;
        int randomNumberitem = 3;
        WebElement NavigationRandomMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]"));
        Thread.sleep(2000);
        Actions action = new Actions(driver);
        action.moveToElement(NavigationRandomMenu).perform();
        Thread.sleep(2000);
       
        WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Actionsss.highlightElement(NavigationMenuitem);
        js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
        Thread.sleep(5000);
        /*
        List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
        List<WebElement> womensplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Women')]"));
        List<WebElement> menplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Men')]"));
        if(newArrivalplp.size()>0) {
        	String[] newArrivalsCategory= {"WOMENS", "MENS", "ELECTRONICS"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("Verify the navigation of NewArrivals Category");
        	if (pageTitleText.equals(newArrivalsCategory[randomNumberitem-1])) {
        		test.pass("Successfully Hovered on the NewArrivals Category  And clicked on " + pageTitleText + " and Navigated to "+  pageTitleText+" PLP page");
                logger.info("click Success NewArrivals of  " + pageTitleText + "");
            }
        }else if(womensplp.size()>0) {        	
        	String[] womensCategory= {"OUTFITS", "TOPS", "DRESSES","BOTTOMS","JACKETS & COATS","FEELING RED","EARRINGS","BRACELETS","NECKLACES","SCARVES","SHOES"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("Verify the navigation of Womens Category");
        	if (pageTitleText.equals(womensCategory[randomNumberitem-1])) {
        		test.pass("Successfully Hovered on the Womens Category  And clicked on " + pageTitleText + " and Navigated to "+  pageTitleText+" PLP page");
                logger.info("click Success Womens of  " + pageTitleText + "");
            }
        }else if(menplp.size()>0) {
        	String[] mensCategory= {"SUITS","JACKETS & COATS","DRESS SHIRTS","SHORTS","PANTS","TIES","GLOVES","LUGGAGE"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("Verify the navigation of Mens Category");
        	if (pageTitleText.equals(mensCategory[randomNumberitem-1])) {
        		test.pass("Successfully Hovered on the Mens Category  And clicked on " + pageTitleText + " and Navigated to "+  pageTitleText+" PLP page");
                logger.info("click Success Mens of  " + pageTitleText + "");
        	}
        }else {
        	String[] electronicsCategory= {"TELEVISIONS","DIGITAL CAMERAS","IPOD & MP3 PLAYERS","GPS NAVIGATION","GAMING"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("Verify the navigation of Electronics Category");
        	if (pageTitleText.equals(electronicsCategory[randomNumberitem-1])) {
        		test.pass("Successfully Hovered on the Electronics Category  And clicked on " + pageTitleText + " and Navigated to "+  pageTitleText+" PLP page");
                logger.info("click Success Electronics of  " + pageTitleText + "");
        	}
        }*/
      }
    }

	public static void selectSimpleProducts() throws InterruptedException {
		 
        int randomNumbermenu = 3;
        if(randomNumbermenu==3) {
        int randomNumberitem = 6;
        WebElement navigatingGloves = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]"));     
        Actions action = new Actions(driver);
        action.moveToElement(navigatingGloves).perform();     
        WebElement navigatingToGloves = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        Actionsss.highlightElement(navigatingToGloves);
        js.executeScript("arguments[0].click();", new Object[]{ navigatingToGloves});          
        List<WebElement> menplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Men')]"));
        if(menplp.size()>0) {
        	String[] mensCategory= {"SUITS","JACKETS & COATS","DRESS SHIRTS","SHORTS","PANTS","TIES","GLOVES","LUGGAGE"};
        	WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
        	String pageTitleText = pageTitle.getText();
        	test.info("verify that Mens of  " + pageTitleText + " ");
        	if (pageTitleText.equals(mensCategory[randomNumberitem-1])) {
        		test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
                logger.info("click Success Mens of  " + pageTitleText + "");
        	}
        }
      }
    }	

	
}
