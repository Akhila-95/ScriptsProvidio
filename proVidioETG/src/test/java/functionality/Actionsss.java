package functionality;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import baseClass.baseClass;
import data.TestData;



public class Actionsss extends baseClass{
	private static TestData TD = new TestData();
	static int addtoBagRandomIndex = 0;
	static int number =0;
	static int size = 0;
	private static final  JavascriptExecutor js = (JavascriptExecutor) driver;
		 //to hower the action
		 public static void hover(WebElement element) {
		        Actions actions = new Actions(driver);
		        actions.moveToElement(element).perform();
		 }
		 
		 public static void randomlyHover(List<WebElement> element) {
			   	Random random = new Random();
		        int randomIndex = random.nextInt(element.size());
		        WebElement randomElement= element.get(randomIndex);		        
		        Actions actions = new Actions(driver);
		        actions.moveToElement(randomElement).perform();
		 }

		 // To click any button 
		 public static void waitAndClick(WebElement element){		   
			 Waits.WaitForClickableElement(element);
			 element.click();  
			    	   
		   }
		 
		// To select value from select drop down
				 public static void selectValue(WebElement element, String value){
					 Select select = new Select(element);
					 select.selectByValue(value);
				 }

		 
		 // To select value from select drop down
		 public static void selectValue(WebElement element){	
		        // Creating a Select object
		        Select dropdown = new Select(element);
		        // Get the list of options
		        int numberOfOptions = dropdown.getOptions().size();
		        // Generate a random index within the range of available options
		        int randomIndex = new Random().nextInt(numberOfOptions);
		        if(randomIndex==1) {
		        	randomIndex= randomIndex+1;
		        }
		        // Select the option at the random index
		        dropdown.selectByIndex(randomIndex);
		        // Get the value of the randomly selected option
		        String selectedOptionValue = dropdown.getFirstSelectedOption().getAttribute("value");
		        logger.info("Value of the randomly selected option: " + selectedOptionValue);
		       test.pass(" The randomly selected option: " + selectedOptionValue);
		 }

		// Enter a random address from a dropdown
		    public static void editAddress(WebElement locatorName) throws InterruptedException {
		    	locatorName.clear();
		        Random random = new Random();
		        int randomNumber = 231; // Generates a random number between 100 and 999
		    //    random.nextInt(900) + 100;
		        addresses = String.valueOf(randomNumber);
		        Thread.sleep(1000);
		        locatorName.sendKeys(addresses);
 
		        // to perform the keyboard activities
		        WebElement shipping = driver.switchTo().activeElement();
 
		        Thread.sleep(1000);
		        shipping.sendKeys(Keys.ARROW_DOWN);
 
		       // shipping.sendKeys(Keys.ENTER);
 
		        String shippingaddress = locatorName.getAttribute("value");
		       // editedAddress=shippingaddress;
		        System.out.println("The address entered is " + shippingaddress);
		        logger.info("The address entered is " + shippingaddress);
		        test.info("The address entered is " + shippingaddress);
		    }
		    
		    public static void selectByOptions(List<WebElement> e) throws InterruptedException {    	
			     // Generate a random index to click on a link
			        Random random = new Random();
			        int randomIndex = random.nextInt(e.size());
			        // Get the text of the randomly selected link
			         selectedLinkText = e.get(randomIndex).getText();
			         JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();",e.get(randomIndex));
			        // Click on the randomly selected link
			       // e.get(randomIndex).click();   
			        logger.info(selectedLinkText);
			    }
		 
		 // for force click 
		 public static void javascriptClick(WebElement element) throws Exception{				
			 Thread.sleep(1000);			
			 js.executeScript("arguments[0].click();",element);
			
		}
		 
		// Clear text from an input field
		    public static void clearText(WebElement element) throws Exception {
		        element.clear();
		    }

		    // Scroll to the bottom of the page
		    public static void scrollBottom() {		       
		        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		    }

		    // Scroll an element into view with its center aligned
		    public static void scrollIntoViewCenter(WebElement ele) throws Exception {
		        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
		        Thread.sleep(2000);
		    }

		    // Scroll the window by a specified pixel value
		    public static void scrollWindowsByPixel(int value) {
		       
		        js.executeScript("window.scrollBy(0, arguments[0])", value);
		    }

		    protected static String locatorNameText = "";

		    // Scroll an element into view
		    public static void scrollByVisibillity(WebDriver driver, WebElement ele) {		       
		        js.executeScript("arguments[0].scrollIntoView();", ele);
		    }

		 // Click on an element and log the result
		    public static void CombinedClick(WebElement locatorName) throws Exception {
		    	scrollIntoViewCenter(locatorName);
		    	highlightElement(locatorName);
		    	
		        try {
		            locatorName.click();
//		            test.pass("Successfully clicked on " + locatorName.getText());
		            Thread.sleep(3000);
		        } catch (Exception e) {		        	
		        	js.executeScript("arguments[0].click();", locatorName);
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		        }
		    }
		    
		    public static void addToCartClickVerify(WebElement locatorName) throws Exception {
		    	scrollIntoViewCenter(locatorName);
		    	highlightElement(locatorName);
		    	
		        try {
		            locatorName.click();
		            test.pass("Product added to cart and Successfully displayed the Pop up message");
		            Thread.sleep(3000);
		        } catch (Exception e) {		        	
		        	js.executeScript("arguments[0].click();", locatorName);
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		        }
		    }
		    // Click on an element and log the result
		    public static void click(WebElement locatorName) throws InterruptedException {
		        try {
		            locatorName.click();
		            Thread.sleep(1000);
//		            test.pass("Successfully clicked on " + locatorName.getText());
		            Thread.sleep(4000);
		        } catch (Exception e) {
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		        }
		    }
		    
		    public static boolean validateClick(WebElement locatorName) throws InterruptedException {
		        try {
		        	locatorName.click();
		            Thread.sleep(1000);
//		            test.pass("Successfully clicked on " + locatorName.getText());
		            Thread.sleep(4000);
		        } catch (Exception e) {
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		        }
				return true;
		    }
		    
		    public static void doubleClick(WebElement locatorName) throws InterruptedException {
		        try {
		            locatorName.click();
		            Thread.sleep(500);
		            locatorName.click();		            
		        } catch (Exception e) {
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		        }
		    }
		    

		    // Check if a list of elements has a size greater than 0
		    public static boolean elementSize(List<WebElement> ele) throws InterruptedException {
		        int size = 0;
		        try {
		            size = ele.size();
		            logger.info("The count of the element is " + size);
		        } catch (Exception e) {
;
		        }
				return size>0;
		    }
		    
		    
		    public static int listofElementSize(List<WebElement> list)  {
		            int size = 0;
		            size = list.size();
		            logger.info("The count of the element is " + list.size());
                    return size;
		    }
		    

		    // Scroll into view and click an element using JavaScriptExecutor
		    public static void scrollIntoCenterView(WebElement element) {
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);

		    }

		    // Check if an element is displayed
		    public static boolean displayElement(WebElement ele) {
		        try {
		            return ele.isDisplayed();
		        } catch (NoSuchElementException e) {
		            return false;
		        }
		    }

		    // Check if an element is enabled
		    public static boolean enabledElement(WebElement ele) {
		        try {
		            return ele.isEnabled();
		        } catch (NoSuchElementException e) {
		            return false;
		        }
		    }

		   
		   

		    // Perform a mouse hover action on an element
		    public static void mouseOverElement(WebElement element) {
		        try {
		            new Actions(driver).moveToElement(element).build().perform();
		            Thread.sleep(1000);
		            logger.info("Hovered on element ");

		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    

		    
		    

		    // Send keys to an element after clearing its existing content

		    
		    public  static void randomselectionofmakeAsadefault(List<WebElement> e) throws Exception {
				// Use the Random class to generate a random index
		        Random random = new Random();
		        int randomIndex = random.nextInt(e.size());
		        if(randomIndex==1) {
		        	randomIndex=randomIndex+1;
		        }
		        WebElement randomElement= e.get(randomIndex);
		        Thread.sleep(2000);
		        CombinedClick(randomElement);
		       	
			}
		    
		    
		    public  static void randomElementFromListSendKeys(List<WebElement> e, int input, String elementName) throws InterruptedException {
				// Use the Random class to generate a random index
		        Random random = new Random();
		        if(e.size()>0) {
			        int randomIndex = random.nextInt(e.size());
			        WebElement randomElement= e.get(randomIndex);
			        Thread.sleep(2000);
			        try {
			        	test.info("Verify " + elementName +" of sendKeys");
			            e.clear();
			            Thread.sleep(1000);
			            randomElement.sendKeys(Integer.toString(input));
			            randomElement.sendKeys(Keys.ENTER);
			            logger.info("Successfully send keys of " + elementName);
			            test.pass("Successfully send keys of " + elementName);
	
			        } catch (Exception ew) {
			            logger.info("Keys not sent to " + elementName);
			        }		        	
		        }
			}
		    
		 // Send keys to an element after clearing its existing content
		    public static void SendKeys(WebElement ele, int input, String elementName) throws Exception {

		        scrollIntoViewCenter(ele);
		        try {
		        	test.info("Verify " + elementName +" of sendKeys");
		            ele.clear();
		            ele.sendKeys(Integer.toString(input));
		            ele.sendKeys(Keys.ENTER);
		            logger.info("Successfully send keys of " + elementName);
		            test.pass("Successfully send keys of " + elementName);

		        } catch (Exception e) {
		            logger.info("Keys not sent to " + elementName);
		        }
		    }
		    // Switch to a frame by its ID
		    public static boolean switchToFrameById(WebElement ele) {
		        boolean flag = false;
		        try {
		            driver.switchTo().frame(ele);
		            logger.info("frame with id ");
		            flag = true;
		            return true;
		        } catch (Exception e) {
		            return false;
		        }
		    }

		    // Switch back to the default content
		    public static boolean switchToDefault() {
		        boolean flag = false;
		        try {
		            driver.switchTo().defaultContent();
		            logger.info("switched to default ");
		            flag = true;
		            return true;
		        } catch (Exception e) {
		            return false;
		        }
		    }

		    // Enter a random address from a dropdown
		    public static void addressFromDropDown(WebElement locatorName) throws InterruptedException {
		    	locatorName.clear();
		    	Thread.sleep(1000);
		    	highlightElement(locatorName);
		        int randomNumber = 123; // Generates a random number between 100 and 999
		    //    random.nextInt(900) + 100;
		        addresses = String.valueOf(randomNumber);
		        Thread.sleep(1000);
		        locatorName.sendKeys(addresses);
		        // to perform the keyboard activities
		        WebElement shipping = driver.switchTo().activeElement();

		        Thread.sleep(1000);
		        shipping.sendKeys(Keys.ARROW_DOWN);

		        shipping.sendKeys(Keys.ENTER);
		        Thread.sleep(2000);

		        String shippingaddress = locatorName.getAttribute("value");
		        System.out.println("The address entered is " + shippingaddress);
		        logger.info("The address entered is " + shippingaddress);
		        test.info("The address entered is " + shippingaddress);
		    }
		    
		    // Enter a random address from a dropdown
		    public static void addressFromAddNewAddress(WebElement locatorName) throws InterruptedException {
		    	locatorName.clear();
		    	Thread.sleep(1000);
		    	highlightElement(locatorName);
		        int randomNumber = 123; // Generates a random number between 100 and 999
		    //    random.nextInt(900) + 100;
		        addresses = String.valueOf(randomNumber);
		        Thread.sleep(1000);
		        locatorName.sendKeys(addresses);
		        // to perform the keyboard activities
		        WebElement shipping = driver.switchTo().activeElement();

		        Thread.sleep(1000);
		        shipping.sendKeys(Keys.ARROW_DOWN);

		        //shipping.sendKeys(Keys.ENTER);
		        Thread.sleep(2000);

		        String shippingaddress = locatorName.getAttribute("value");
		        System.out.println("The address entered is " + shippingaddress);
		        logger.info("The address entered is " + shippingaddress);
		        test.info("The address entered is " + shippingaddress);
		    }
		    
		    public static void scrollUp() {      
		        js.executeScript("window.scrollTo(0, 0);");
		    }
		    
		    public static void scrollDown() {		      
		        js.executeScript("window.scrollBy(0,500)");
		    }
		    
		    public static void scrollMedium() {		     
		        js.executeScript("window.scrollTo(0, 0);");
		    }
		    
		    
		    public static boolean countofElements(List<WebElement> ele) {
		    	;
		        int size = 0;
		        try {
		            size = ele.size();
		            logger.info("The count of the element is " + ele.size());
		        } catch (Exception e) {
		        }
		        return size > 0;
		    }
		    public static boolean sendKeys(WebElement ele, String value, String elementName) throws InterruptedException {
		    	scrollIntoCenterView(ele);
		    	try {
		            test.info("Verify whether the user is able to Enter the Input details in " + elementName );    
		            // Clear and send keys
		            highlightElement(ele);
		            ele.clear();
		            Thread.sleep(1000);
		            ele.sendKeys(value);
		            logger.info("Successfully send keys of " + elementName);
		            test.pass("Successfully the user is Entered the Input in " + elementName);
		            return true;
		        } catch (Exception e) {
		            logger.info("Keys not sent to " + elementName);
		            return false;
		        }
		    }
		    
		    //Function to highlight the element using JavaScript
		    public static void highlightElement(WebElement element) {
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        // Execute JavaScript to highlight the element
		        js.executeScript("arguments[0].style.border='1px solid yellow'", element);
		    }

		    public static boolean DisplyedandClick(List<WebElement> ele) {
				return ele.size()>0;
		    }
		    
		    public  static void randomElementFromListScrollIntoView(List<WebElement> e) throws Exception {
				// Use the Random class to generate a random index
		    	if(e.size()>0) {
			        Random random = new Random();
			        int randomIndex = random.nextInt(e.size());
			        WebElement randomElement= e.get(randomIndex);
			        scrollIntoCenterView(randomElement);
			        Thread.sleep(2000);
			        CombinedClick(randomElement);		
		    	}
			}
		
		    
		    public  static void randomElementFromList(List<WebElement> e) throws Exception {
				// Use the Random class to generate a random index
		    	logger.info(e.size());
		    	if(e.size()>0) {
			        int randomIndex = random.nextInt(e.size());
			        logger.info(randomIndex);
			        WebElement randomElement= e.get(randomIndex);
			        Thread.sleep(2000);
			        highlightElement(randomElement);			        
			        CombinedClick(randomElement);
			    //    nameofSelectedSortby = randomElement.getText(); 
		    	}
			}
		    
		    public  static void randomElementFromListAndClearTheTextAndSendValue(List<WebElement> e) throws Exception {
				// Use the Random class to generate a random index
		    	logger.info(e.size());
		    	if(e.size()>0) {
			        int randomIndex = random.nextInt(e.size());
			        logger.info(randomIndex);
			        WebElement randomElement= e.get(randomIndex);
			        Thread.sleep(2000);
			        highlightElement(randomElement);				       
			        CombinedClick(randomElement);			       
			    	//int randomNumber = random.nextInt(1000) + 1;
			        //	logger.info(randomNumber);
			        Thread.sleep(2000);
			        Actionsss.onlySendKeys(randomElement,String.valueOf(100));			    			    				    	
			    	Thread.sleep(3000);
			    	Actionsss.scrollUp();
		    	}
			}
		    
		    
		    public  static void randomElementFromListHover(List<WebElement> e) throws InterruptedException {
				// Use the Random class to generate a random index
		        int randomIndex = random.nextInt(e.size());
		        WebElement randomElement= e.get(randomIndex);
		        scrollIntoCenterView(randomElement);
		        Thread.sleep(2000);
		        hover(randomElement);
		        
			}
		    
		   
		    public  static void randomElementFromListforSortBy(List<WebElement> e ) throws Exception {
				// Use the Random class to generate a random index
		        Random random = new Random();
		        if(e.size()>0) {
			        int randomIndex = random.nextInt(e.size());
			        if(randomIndex==1) {
			        	randomIndex = randomIndex+1;
			        	logger.info(randomIndex);
			        }
			        		
			        WebElement randomElement= e.get(randomIndex);
			        CombinedClick(randomElement);	
			        Thread.sleep(3000);			         
		        }
			}
		    
		    public  static void randomElementFromListForShippingMethod(List<WebElement> e) throws Exception {
				// Use the Random class to generate a random index
		    	logger.info(e.size());
		    	if(e.size()>0) {
			        int randomIndex = random.nextInt(e.size());
			        logger.info(randomIndex);
			        WebElement randomElement= e.get(randomIndex);
			        Thread.sleep(2000);
			        highlightElement(randomElement);			        
			        CombinedClick(randomElement);
			        nameofSelectedSortby = randomElement.getText(); 
			        test.info(nameofSelectedSortby + " randomly selected from drop down");
		    	}
			}
		    
		    public  static void randomElementFromListForInFilters(List<WebElement> e) throws Exception {
				// Use the Random class to generate a random index
		    	logger.info(e.size());
		    	if(e.size()>0) {
			        int randomIndex = random.nextInt(e.size());
			        logger.info(randomIndex);
			        WebElement randomElement= e.get(randomIndex);
			        Thread.sleep(2000);
			        highlightElement(randomElement);			        
			        CombinedClick(randomElement);
			       // TestData.NameofFilterText = randomElement.getText(); 
			      //  test.info(TestData.NameofFilterText + " is selected");
		    	}
			}
		    
		    public  static void randomElementFromListfordropdown(List<WebElement> e ) throws Exception {
				// Use the Random class to generate a random index
		    	logger.info(e.size());
		    	if(e.size()>0) {
			        int randomIndex = random.nextInt(10);
	//		        if(randomIndex > 10) {
	//		        	randomIndex = 5;
	//		        	logger.info(randomIndex);
	//		        }
			        		
			        logger.info(randomIndex);
			        WebElement randomElement= e.get(randomIndex);
			        Thread.sleep(1000);
			        CombinedClick(randomElement);	
			        //Thread.sleep(3000);
			        nameofSelectedSortby = randomElement.getText();
		    	}
			}
		    
		    
		    public static String waitAndVisibleGetText(WebElement locatorName) {
		        Waits.waitAndVisibility(locatorName);
		        String locatorNameText = "";
		        locatorNameText = locatorName.getText();
	            return locatorNameText;
	    }
		    
		    public static void addNewShippinggAddress(WebElement locatorName) throws InterruptedException {
		    	locatorName.clear();
		    	Thread.sleep(1000);
		        String randomNumber = "7868"; // Generates a random number between 100 and 999
		       //random.nextInt(900) + 100;
		       // addresses = String.valueOf(randomNumber);	  
		        highlightElement(locatorName);
		        locatorName.sendKeys(randomNumber);
		        Thread.sleep(2000);		       
		        WebElement shipping = driver.switchTo().activeElement();
		        Thread.sleep(2000);
		        shipping.sendKeys(Keys.ARROW_DOWN);
		        shipping.sendKeys(Keys.ENTER);
		        Thread.sleep(3000);
		        String shippingaddress = locatorName.getAttribute("value");	
		        logger.info("The address entered is " + shippingaddress);
		        test.info("The address entered is " + shippingaddress);
		    }
		      
		    public static void editShippingAddressFromRop(WebElement locatorName) throws InterruptedException {
		    	locatorName.clear();
		    	Thread.sleep(1000);
		        Random random = new Random();
		        String randomNumber = "768"; // Generates a random number between 100 and 999
		       //random.nextInt(900) + 100;
		       // addresses = String.valueOf(randomNumber);	        
		        locatorName.sendKeys(randomNumber);
		        Thread.sleep(2000);		       
		        WebElement shipping = driver.switchTo().activeElement();
		        Thread.sleep(1000);
		        shipping.sendKeys(Keys.ARROW_DOWN);
		        String shippingaddress = locatorName.getAttribute("value");	
		        logger.info("The address entered is " + shippingaddress);
		        test.info("The address entered is " + shippingaddress);
		    }

 
		    public static void editBillingAddressFromRop(WebElement locatorName) throws InterruptedException {
		    	locatorName.clear();
		    	Thread.sleep(1000);
		        Random random = new Random();
		        String randomNumber = "43"; // Generates a random number between 100 and 999
		       //random.nextInt(900) + 100;
		       // addresses = String.valueOf(randomNumber);	        
		        locatorName.sendKeys(randomNumber);
		        Thread.sleep(2000);		       
		        WebElement shipping = driver.switchTo().activeElement();
		        Thread.sleep(2000);
		        shipping.sendKeys(Keys.ARROW_DOWN);
		        shipping.sendKeys(Keys.ENTER);
		        Thread.sleep(3000);
		        String shippingaddress = locatorName.getAttribute("value");	
		        logger.info("The address entered is " + shippingaddress);
		        test.info("The address entered is " + shippingaddress);
		    }
		    
		    public static void updateShippingAddress(WebElement locatorName) throws InterruptedException {
		    	locatorName.clear();
		    	Thread.sleep(1000);
		        Random random = new Random();
		        String randomNumber = "456"; // Generates a random number between 100 and 999
		    //    random.nextInt(900) + 100;
		       // addresses = String.valueOf(randomNumber);
		        locatorName.sendKeys(randomNumber);
		        Thread.sleep(2000);
		        // to perform the keyboard activities
		        WebElement shipping = driver.switchTo().activeElement();
 
		        Thread.sleep(1000);
		        shipping.sendKeys(Keys.ARROW_DOWN);
		        shipping.sendKeys(Keys.ENTER);
		        Thread.sleep(3000);
		        String shippingaddress = locatorName.getAttribute("value");
		        logger.info("The address entered is " + shippingaddress);
		        test.info("The address entered is " + shippingaddress);
		    }

		    public static boolean onlySendKeys(WebElement ele,String value) {
		    	scrollIntoCenterView(ele);
		    	try {
		            test.info("Verify whether the user is able to Enter the Input details in " + ele.getText() );    
		            // Clear and send keys
		            highlightElement(ele);
		            ele.clear();
		            ele.sendKeys(value);
		            logger.info("Successfully send keys of " + value);
		            test.pass("Successfully the user is Entered the Input in " + value);
		            return true;
		        } catch (Exception e) {
		            logger.info("Keys not sent to " +value);
		            return false;
		        }
		    }
		    
		    
     //------------------------------sendKeys and enter----------------------------------
	
	    public static boolean sendKeysandEnter(WebElement ele, String value, String elementName) throws InterruptedException {
	    	scrollIntoCenterView(ele);
	    	try {
	            test.info("Verify whether the user is able to Enter the Input details in " + elementName );    
	            // Clear and send keys
	            highlightElement(ele);
	            Thread.sleep(1000);
	            ele.clear();
	            Thread.sleep(1000);
	            ele.sendKeys(value);
	            ele.sendKeys(Keys.ENTER);
	            logger.info("Successfully send keys of " + elementName);
	            test.pass("Successfully the user is Entered the Input in " + elementName);
	            return true;
	        } catch (Exception e) {
	            logger.info("Keys not sent to " + elementName);
	            return false;
	        }
	    }
		    

	    public static void getNumber(WebElement ele) {
	    	// Get the text from the element
	    	String text = ele.getText();
	    	// Extract the number from the text
	    	String numberOnly = text.replaceAll("[^0-9]", ""); // Remove all non-numeric characters
	    	// Convert the extracted string to an integer
	    	reviewsNumner = Integer.parseInt(numberOnly);
	    	System.out.println("Number: " + reviewsNumner);
	    }
	    
	 // Click on an element and return true if successful, false otherwise
	    public static boolean clickVerify(WebElement locatorName) throws InterruptedException {
	        try {
	            locatorName.click();
	            Thread.sleep(1000);
	            // Optionally, you can add more validation here if needed

	            Thread.sleep(4000);
	            return true; // Return true if the click was successful
	        } catch (Exception e) {
	            System.err.println("Exception while clicking the element: " + e.getMessage());
	            return false; // Return false if an exception occurred (click unsuccessful)
	        }
	    }
	    
	    //clp page 
	    public  static void randomElementFromListforMainMenu(List<WebElement> e) throws Exception {
			// Use the Random class to generate a random index
	    	Thread.sleep(3000);
	    	logger.info(e.size());
	        int randomIndex = random.nextInt(e.size());
	        logger.info(randomIndex);
	        if(randomIndex<=0) {
	        	logger.info("lessthan zero");
	        	randomIndex = randomIndex+2;
	        }else if(randomIndex > 3) {
	        	 randomIndex = randomIndex-2;
	        	 logger.info(randomIndex);
	        }
	        WebElement randomElement= e.get(randomIndex);
	        Thread.sleep(2000);
	        getTextOfElement(randomElement);
	        highlightElement(randomElement);
	        Thread.sleep(3000);
	        CombinedClick(randomElement);			
		}
	    
	    // Get the text of an element
	    public static String getTextOfElement(WebElement locatorName) {
	        String locatorNameText = "";
	        try {
	            locatorNameText = locatorName.getText();
	            //Thread.sleep(1000);
	        } catch (Exception e) {
	            //e.printStackTrace();
	        }
	        TestData.Selcted_Clp_Name = locatorNameText;
	        logger.info(TestData.Selcted_Clp_Name);
	      //  test.pass(TestData.Selcted_Clp_Name);
	        return locatorNameText;
	    }
	    
	    
	    // Get the size of a list of elements
	    public static int getSizeOfList(List<WebElement> ele) {
	       
	        try {
	       	 int displayedElementsPesent = 0;
	 	    for (WebElement item : ele) {
	 	        if (item.isDisplayed()) {
	 	        	displayedElementsPesent++;
	 	        }
	 	    }
	 	    // Get the count of matched elements and log it.
	 	      size = displayedElementsPesent;
	          //logger.info(size);
	        } catch (Exception e) {

	        }
	        return size;
	    }

	    public  static void randomElementFromListScrollIntoViewandDisplayedelements(List<WebElement> e) throws Exception {
			// Use the Random class to generate a random index
	    	getSizeOfList(e);
	        int randomIndex = size;
	        logger.info(randomIndex);
	        WebElement randomElement= e.get(randomIndex);
	        scrollIntoCenterView(randomElement);
	        Thread.sleep(2000);
	        CombinedClick(randomElement);			
		}

}
