package baseClass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.providio.utilities.readConfig;
import com.providio.utilities.reportToMail;

import data.TestData;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;



public class baseClass {
	SoftAssert soft = new SoftAssert();
	
	private static TestData TD = new TestData();
	protected static int originalBalance =0;
	protected static String creditCardNumber = "";

	// Create a random number generator.
	protected static Random random = new Random();
	// Create a SoftAssert instance
    protected static SoftAssert softAssert = new SoftAssert();


	// email
        public static String   fakeEmail = "";
		public static String   fakeFirstName = "";
		public static String   fakelastName = "";
		public static String   fakePhoneNum= "";
		public static String   fakeFullName= "";
		
		
		protected static String   previousAddresses  = "";
		protected static String   editedFirstName = "";
		protected static String   editedlastName = "";
		protected static String   editedFullName= "";
		protected static String   editedAddress  = "";
		protected static String   previousMail  = "";
		protected  static String  editedEmailFromCop3= "";
		protected static String   previousBillingAddress  = "";
		protected  static String  editedBillingAddress= "";
		protected  static String  prevoiusBillingPhoneNumber= "";
		protected  static String  editedBillingPhoneNumber= "";



 
		protected static String previousShippingAddressInUpdate = ""; // Edited email in cop2
		protected static String updateShippingAddress = "";
		protected static String previousShippingAddress = ""; // Edited email in cop2
		protected static String newlyAddedShippingAddress = "";
		protected static String previousPaymentInPlaceorderPage = "";
		protected static String paymentafterEditInPlaceorderPage = "";
		protected static String getTextOfPaypalInPaymentPage = "";

		protected static String gcCodeRedeemed= "";

		protected static String previousShippingAddressInRop="";
		protected static String editedShippingAddressInRop="";
		protected static String previousPhoneNumInShippingAddressInRop="";
		protected static String editedPhoneNumInShippingAddressInRop="";
		protected static String previousBillingAddressInRop="";
		protected static String editedBillingAddressInRop="";
		// count of gc applied
		protected  static int   countOfGcApplied= 0;
		protected  static int   countOfGcAppliedAfterItsRemoval= 0;
		// GC amount detected
		protected static Float totalGcDetechedAmount=(float) 0;
		
		// Create an instance of the readConfig class to read configuration data
		static readConfig readconfig = new readConfig();
	
		public  static String GiftCerificateCodeCombination = readconfig.GiftCerificateCodeCombination();
	
		protected static String  addresses  = "";
	


	// Login details
	public static String name = readconfig.getUsername(); // User name for login
	public static String password = readconfig.getPassword(); // Password for login
	
	
	public static String gift = readconfig.giftCardReedem(); // First name for shipping
	// Shipping details
	public static String fname = readconfig.getFName(); // First name for shipping
	public static String lname = readconfig.getLName(); // Last name for shipping
	public String address = readconfig.getAddress(); // Address for shipping
	public String cityname = readconfig.getCity(); // City for shipping
	public String zipcode = readconfig.getzipcode(); // Zip code for shipping
	public static String phonenumber = readconfig.getphone(); // Phone number for shipping



	// In Find a Store
	public String zipcodeStore = readconfig.getZipcodeInStore(); // Zip code for finding a store

	// Search bar
	public static String searchBar = readconfig.searchSomething(); // Search term for the search bar

	// Footer mail
	public String footerMail = readconfig.getFooterMail(); // Email for the footer

	// Guest login details
	public static String guestmail = readconfig.getGuestMail(); // Guest user's email
	public String guestPassword = readconfig.getGuestPassword(); // Guest user's password
	public String reEnterMail = readconfig.getReEnterMail(); // Re-enter email for guest login

	// WebDriver and logger instances
	public static WebDriver driver; // WebDriver instance
	public static Logger logger; // Logger instance

	// Flags for tracking test state
	protected static boolean isLoggedIn = false; // Flag indicating whether the user is logged in
	protected static boolean CheckoutProcessClick = false; // Flag indicating whether the checkout process was clicked
	protected static boolean isBrowserLaunched = false; // Flag indicating whether the browser is launched

	// Menu related variable
	protected static int menu5 = 0; // Menu-related variable (initially set to 0)

	// Total cost at cart page
	protected static Float totalCost = (float) 0; // Total cost at the cart page
	// Subtotal cost at hovered cart
	protected static Float subTotalCost = (float) 0; // Subtotal cost at the hovered cart

	// Guest user and registration flags
	protected static boolean guestuser = false; // Flag indicating whether the user is a guest user

	// Gift card flag
	protected static boolean giftCard = false; // Flag indicating whether a gift card is used

	
	
	//selected sort name String nameofSelectedSortby
	protected static String  nameofSelectedSortby = "";
	protected static int  reviewsNumner = 0;
	
	
	protected static String emailEditedInCop2 = ""; // Edited email in cop2
	protected static String emailEditedInCop3 = ""; // Edited email in cop2
	protected static boolean giftMessageInCop2= false;
	protected static String selectedLinkText=null;

	// ExtentReports and ExtentTest instances for reporting
	protected static ExtentReports report = new ExtentReports();
	private ExtentSparkReporter reporter = new ExtentSparkReporter(TD.Report);

	// Reporting
	// static ExtentReports report;
	protected static ExtentTest test;

	@BeforeSuite
	public void setUpforReport() throws InterruptedException {
		// Create a new ExtentReports instance
	    report = new ExtentReports();
	    // Attach the ExtentSparkReporter to the ExtentReports
	    report.attachReporter(reporter);
	    // Initialize the WebDriver (assuming the method initializeDriver() is available)
	    //initializeDriver();
	}
	
	@BeforeClass()
	public void setUp() throws InterruptedException {
   	    // Initialize the logger with the name "FMG"
        logger = Logger.getLogger("Providio");
	    // Configure the logger using the "log4j.properties" file
	    PropertyConfigurator.configure("log4j.properties");
	}
	
	@BeforeMethod
	public void afterClass(Method method) {
		// Create a new ExtentTest with the name of the current test method
		test = report.createTest(method.getName());
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException {
	   
	    
	    // Taking a screenshot when an error occurs
	    if (result.getStatus() == ITestResult.FAILURE) {
	        // Log the name of the error
	        test.fail(result.getThrowable().getClass().getSimpleName());
	        
	        // Log the full error with code lines
	        test.fail(result.getThrowable());

	        // Taking a screenshot with the method name and storing it in a file
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String fileName = result.getMethod().getMethodName() + "_" + ".jpg";

	        try {
	            // Print a message indicating that a screenshot is taken
	            System.out.println("Screenshot taken for test case: " + result.getMethod().getMethodName());
	            
	            // Set the destination file for the screenshot
	            File destination = new File("./Screenshots/" + fileName);
	            
	            // Copy the screenshot from source to destination
	            FileUtils.copyFile(source, destination);
	            
	            // Get the absolute path of the screenshot
	            String screenshotPath = destination.getAbsolutePath();

	            // Attach the screenshot to the test report
	            test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	        } catch (IOException e) {
	            // Log an exception message if there's an issue with taking the screenshot
	            System.out.println("Exception while taking screenshot: " + e.getMessage());
	        }
	    }
	}

	
	@AfterSuite
	public void tearDown() throws IOException, EmailException, InterruptedException {
	    // Change the view of the report to include DASHBOARD and TEST views
	    reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST}).apply();

		if(TD.TestSuiteType=="Regression") {
	     reporter.config().setReportName("<span style='text-align:center; color:white; margin: 0 auto; display:inline-block;margin: 0 10px;'>" + TD.regression + "</span>" +
	     "<span style='text-align:center; color:white; margin: 0 auto;display: inline-block;'>" + TD.BuildNumber + "</span>");
	     }else {
	    	reporter.config().setReportName("<span style='text-align:center; color:white; margin: 0 auto;'> " + TD.smoke + "&nbsp;&nbsp;&nbsp;" + TD.BuildNumber + "</span>");
	    }
	    
	    // Flush the ExtentReports to write the test information to the report
	    report.flush();
	    
	    // Navigate to the report URL in the WebDriver
	    driver.get(TD.Report);
	    
	    // Maximize the browser window
	    driver.manage().window().maximize();
	    
	    // Pause execution for 5000 milliseconds (5 seconds)
	    Thread.sleep(5000);
	    
	    // Take a screenshot of the entire browser window
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    // Define the destination path for the screenshot
	    String screenshotPath = TD.ScreenShot;
	    
	    // Save the screenshot to the specified path
	    FileUtils.copyFile(screenshot, new File(screenshotPath));

	 // Collect all the assertions and report the results
        softAssert.assertAll();
	    // Close the WebDriver instance 
	    // driver.quit();
	    
	    // Send the report via email
	    reportToMail.Reporttomail();
	}
	
	   
	
}