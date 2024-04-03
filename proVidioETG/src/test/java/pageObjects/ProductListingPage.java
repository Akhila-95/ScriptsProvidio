package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;


public class ProductListingPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public ProductListingPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//bread crumbs
	@FindBy(xpath ="(//li[@class='breadcrumb-item'])[1]")
	WebElement breadCrumbs; 
	public WebElement getSelectbreadCrumbLink(){
		return breadCrumbs;
	}
	
	//add to button in quick shop
	@FindBy(xpath ="//button[contains(@class, 'add-to-cart')]")
	WebElement addToCartBtn; 
	public WebElement getSelectaddToCartBtn(){
		return addToCartBtn;
	}
	
		
	//FilterResetButton
	@FindBy(xpath ="//button[@class = 'reset btn p-0']")
	WebElement ResetButton; 
	public WebElement getSelecttheResetButton(){
		return ResetButton;
	}
	
	//add to wishList
	@FindBy(xpath ="//i[contains(@class, 'fa-heart-o')]")
	List<WebElement> AddtoWishList; 
	public List<WebElement> getSelectAddtoWishListButton(){
		return AddtoWishList;
	}
	
	//------------- wishList-------------
	@FindBy(xpath ="//i[contains(@class, 'fa-heart-o')]")
	WebElement addtoWishList; 
	public WebElement getSelectaddtoWishListButton(){
		return addtoWishList;
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

	//FilterResetButton
	@FindBy(xpath ="//button[@class = 'reset btn p-0']")
	WebElement resetButton;
	public void selecttheResetButton() throws InterruptedException{
		resetButton.click();
    	Thread.sleep(3000);
	}
	
	
	//filters
	@FindBy(xpath ="//select[@name = 'sort-order']//option")
	List<WebElement> SortBy;
	public List<WebElement> getSelecttheSortBy(){
		return SortBy;	
		
	}
	
	//add to bag
	@FindBy(xpath ="//span[text()='Add to Bag']")
	List<WebElement> AddtoBag;
	public List<WebElement> getSelectAddtoBag() throws InterruptedException{
		return AddtoBag;	
	}
	
	@FindBy(xpath ="//span[text()='Add to Bag']")
	WebElement AddtoBagelement;
	public WebElement getSelectAddtoBagelement() throws InterruptedException{
		return AddtoBagelement;	
	}
	
	//size
	@FindBy(xpath ="//li[contains(@class, 'content-center') and not (contains(@class, 'unselectable'))]")
	List<WebElement> sizeInAddtoBag;
	public List<WebElement> getSelectsizeInAddtoBag() throws InterruptedException{
		return sizeInAddtoBag;	
	}
	
	@FindBy(xpath ="//li[contains(@class, 'content-center') and not (contains(@class, 'unselectable'))]")
	WebElement sizeDisplayInAddtoBag;
	public WebElement getSizeDisplayInAddtoBag() throws InterruptedException{
		return sizeDisplayInAddtoBag;	
	}

	@FindBy(xpath="//span[@class='button-content' and text()='Add to Bag']")
	List<WebElement> addToBagList; 
	public List<WebElement> getAddToBagList(){
		return addToBagList;
	}
	
	@FindBy(xpath="//span[@class='button-content' and text()='Add to Bag']")
	WebElement addToBag; 
	public WebElement getAddToBag(){
		return addToBag;
	}
		
	
	@FindBy(css ="div.product")
	WebElement plpPage; 
	public WebElement getPlpPage(){
		return plpPage;
	}
	
	@FindBy(css ="div.product")
	List<WebElement> plpPageList; 
	public List<WebElement> getPlpPageList(){
		return plpPageList;
	}
	
	
	@FindBy(xpath ="//div[contains(@class, 'result-count hide-toggle-bar')]")
	WebElement hideFiltersORShowFilter;
	public WebElement getSelecthideFiltersORShowFilter(){
		return hideFiltersORShowFilter;	
	}
	
	
	@FindBy(xpath ="//div[contains(@class, 'refinement refinement-')]")
	static List<WebElement> totalFilter;
	public static List<WebElement> gettotalFilterlist(){
		return totalFilter;	
	}
	
	@FindBy(xpath ="//div[@class='refinements']//span[@class='toggle']")
	WebElement expandAndCollapseInFilters;
	public WebElement getexpandAndCollapse(){
		return expandAndCollapseInFilters;	
	}
	
	@FindBy(css="select.custom-select")     
	WebElement bestMatchesFilters;                                   
	public WebElement getBestMatchesFilters(){                                
		return bestMatchesFilters;	  
	}
	
	//-----bread crumb div---------
	@FindBy(css="li.breadcrumb-item")     
	List<WebElement> breadCrumbsInPlp;                                   
	public List<WebElement> getBreadCrumbsInPlp(){                                
		return breadCrumbsInPlp;	  
	}
	
	//---------price filter---------------

	
	@FindBy(css="div.refinement-price")     
	static List<WebElement> priceFiltersList;                                   
	public static List<WebElement> getPriceFiltersList(){                                
		return priceFiltersList;	  
	}
	
	@FindBy(xpath="//input[contains(@id,'priceRefinement-')]")     
	static List<WebElement> totalpriceFiltersList;                                   
	public static List<WebElement> getTotalpriceFiltersList(){                                
		return totalpriceFiltersList;	  
	}
	
	//----------color filter--------------------
	@FindBy(css="div.refinement-color")     
	static List<WebElement> colorFiltersList;                                   
	public static List<WebElement> getColorFiltersList(){                                
		return colorFiltersList;	  
	}
	
	@FindBy(css="li.color-attribute ")     
	static List<WebElement> totalColorFiltersList;                                   
	public static List<WebElement> getTotalColorFiltersList(){                                
		return totalColorFiltersList;	  
	}
	
	//----------size filters---------------
	@FindBy(css="div.refinement-size")     
	static List<WebElement> sizeFiltersList;                                   
	public static List<WebElement> getSizeFiltersList(){                                
		return sizeFiltersList;	  
	}
	
	@FindBy(css="li.d-inline")     
	static List<WebElement> totalSizeFiltersList;                                   
	public static List<WebElement> getTotalSizeFiltersList(){                                
		return totalSizeFiltersList;	  
	}
	
	//-----------brand filters------------------
	@FindBy(css="div.refinement-brand")     
	static List<WebElement> brandList;                                   
	public static List<WebElement> getBrandList(){                                
		return brandList;	  
	}
	
	@FindBy(xpath="//div[@id='refinement-brand']//li")     
	static List<WebElement> totalBrandFiltersList;                                   
	public static List<WebElement> getTotalBrandFiltersList(){                                
		return totalBrandFiltersList;	  
	}
	
	//-----------type filters------------------
		@FindBy(css="div.refinement-type")     
	static List<WebElement> typeList;                                   
	public static List<WebElement> getTypeList(){                                
		return typeList;	  
	}
	
	@FindBy(xpath="//div[@id='refinement-type']//li")     
	static List<WebElement> totalTypeFiltersList;                                   
	public static List<WebElement> getTotalTypeFiltersList(){                                
		return totalTypeFiltersList;	  
	}
	//------------ pixel filter----------------
	@FindBy(css="div.refinement-pixels")     
	static List<WebElement> pixelsList;                                   
	public static List<WebElement> getPixelsList(){                                
		return pixelsList;	  
	}
	
	@FindBy(xpath="//div[@id='refinement-pixels']//li")     
	static List<WebElement> totalPixelFiltersList;                                   
	public static List<WebElement> getTotalPixelFiltersList(){                                
		return totalPixelFiltersList;	  
	}
	
	
	
	//--------------selected filter-------------------------
	@FindBy(xpath="//div[contains(@class,'selected-filters-bar ')]//span[@class='filter-value-element']")     
	static List<WebElement> selectedFiltersList;                                   
	public static List<WebElement> getSelectedFiltersList(){                                
		return selectedFiltersList;	  
	}
	
	
	
	
	
	public static void selectingFiltersInPlp() throws Exception {
			int totalCountOfFilters=Actionsss.getSizeOfList(gettotalFilterlist());
			int actualCountOfFilters= totalCountOfFilters-1;
			boolean filterSelected = false;
			
			test.info("Verifying  of apply multiple filters");
				//------------price filter--------------------
				if (Actionsss.elementSize(getPriceFiltersList())) {
		            logger.info("price filters are displayed");
		            Actionsss.randomElementFromListForInFilters(getTotalpriceFiltersList());
		            Thread.sleep(3000);       
		            filterSelected = true; 
		        } 
				//------------color filter -------------------
		        if (Actionsss.elementSize(getColorFiltersList())) {
		            logger.info("Color filters are displayed");
		            Actionsss.randomElementFromList(getTotalColorFiltersList());
		            Thread.sleep(3000);		            
		            test.pass("Color filter is selected");
		            filterSelected = true; 
		        }
		        //-----------size filter---------------------
		        if (Actionsss.elementSize(getSizeFiltersList())) {
		            logger.info("Size filters are displayed");
		            Actionsss.randomElementFromListForInFilters(getTotalSizeFiltersList());
		            Thread.sleep(3000);
		            filterSelected = true; 
		        }
		        //-------------brand filter---------------------
		        if(Actionsss.elementSize(getBrandList())) {
		        	 logger.info("brand filters are displayed");
		             Actionsss.randomElementFromListForInFilters(getTotalBrandFiltersList());
		             Thread.sleep(3000);
		             filterSelected = true;
			            
		        }
		        //------------type filter--------------
		        if(Actionsss.elementSize(getTypeList())) {
		        	 logger.info("Type filters are displayed");
		             Actionsss.randomElementFromListForInFilters(getTotalTypeFiltersList());
		             Thread.sleep(3000);
		             filterSelected = true;
			            
		        }
		        //-----------pixel filter-----------------
		        if(Actionsss.elementSize(getPixelsList())) {
		        	 logger.info("pixel filters are displayed");
		             Actionsss.randomElementFromListForInFilters(getTotalPixelFiltersList());
		             Thread.sleep(3000);
		             filterSelected = true;
			            
		        }
		        
		        logger.info(getSelectedFiltersList().size());
		        for(WebElement each:getSelectedFiltersList() ) {
		        	String textWithQuestionMarks = Actionsss.getTextOfElement(each);		           
		            TestData.filterBeforeRefresh = textWithQuestionMarks.replace("RESET", "");
		            test.pass("Selected filters are " + TestData.filterBeforeRefresh );	        	
		        }
		}
        /*                                                           
	public void selectaFilterFormPLP() throws InterruptedException {
		test.info("Verify that filters in the PLP");
		// Find the element using the dynamic XPath with a wildcard
        List<WebElement> TotalNumberofFilters =  driver.findElements(By.xpath("//div[contains(@class, 'refinement refinement-')]"));
        // Get the total count of top-level menu elements.
        int Filterscount = TotalNumberofFilters.size();
        logger.info("Total filters count is " + Filterscount);
        // Generate a random index to select a top-level menu item.
        int randomNumberFilter = random.nextInt(Filterscount) + 1;
        logger.info("Randomly selected filters number " + randomNumberFilter);
        
        if(randomNumberFilter==1) {
        	randomNumberFilter = randomNumberFilter+1;
        }
        
        // get the name of the Main filter 
        WebElement mainFilterName = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//h6)["+randomNumberFilter+"]"));
        // Get and print the text of the found element
        TestData.NameofFilterText = mainFilterName.getText();
        logger.info(TestData.NameofFilterText);
        String expectedResultcolor = "Color";
        String expectedResultsize = "Size";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(5000);
        if(TestData.NameofFilterText.equals(expectedResultcolor)) {
        	
        	 //number of sub filtes associate with the main filter
            List<WebElement> numberofFiltersinInColor =  driver.findElements(By.xpath("//li[@class='color-attribute ']"));
            // Get the total count of top-level menu elements.
            int countofeachFilterbtns = numberofFiltersinInColor.size();
            logger.info("Total filters countofeachFilterbtns is " + countofeachFilterbtns);
         // Generate a random index to select a top-level menu item.
            int randomNumbercountofColorFilterbtns = random.nextInt(countofeachFilterbtns) + 1;
            logger.info("Randomly selected subfilter number " + randomNumbercountofColorFilterbtns);
            
            WebElement colorBtn = driver.findElement(By.xpath("(//li[@class='color-attribute '])["+randomNumbercountofColorFilterbtns+"]"));
            //colorBtn.click();
            js.executeScript("arguments[0].click();", colorBtn);
            test.pass("Successfully clicked the " +TestData.NameofFilterText+ " filter");
        	
        }else if(TestData.NameofFilterText.equals(expectedResultsize)) {
       	 //number of sub filtes associate with the main filter
            List<WebElement> numberofFiltersinInSize =  driver.findElements(By.xpath("//span[@class='size-btn']"));
            // Get the total count of top-level menu elements.
            int countofeachFilterbtns = numberofFiltersinInSize.size();
            logger.info("Total filters countofeachFilterbtns is " + countofeachFilterbtns);
         // Generate a random index to select a top-level menu item.
            int randomNumbercountofSizeFilterbtns = random.nextInt(countofeachFilterbtns) + 1;
            logger.info("Randomly selected subfilter number " + randomNumbercountofSizeFilterbtns);
            WebElement SizeBtn = driver.findElement(By.xpath("(//span[@class='size-btn'])["+randomNumbercountofSizeFilterbtns+"]"));
            //SizeBtn.click();
            js.executeScript("arguments[0].click();", SizeBtn);
            test.pass("Successfully clicked the " +TestData.NameofFilterText+ " filter");
        }else {
        	logger.info("not color and size");
        	//Radio icon of the filter
            WebElement selectRadioIcon = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//button"));
            //selectRadioIcon.click();
           
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectRadioIcon);
            js.executeScript("arguments[0].click();", selectRadioIcon);
            Thread.sleep(4000);
            test.pass("Successfully clicked the " +TestData.NameofFilterText+ " filter");
        }   
        selectaFilterFormPLP();
	}*/
}
	
	
	
