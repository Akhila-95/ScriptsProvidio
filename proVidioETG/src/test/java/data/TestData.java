package data;

import com.github.javafaker.Faker;

import baseClass.baseClass;

public class TestData{
	
	//-----------browser name -------------------
	public  String NameoftheBrowser="Chrome";
	//-------------url----------------------------
	public String baseURL = "https://zzqi-002.dx.commercecloud.salesforce.com/on/demandware.store/Sites-RefArch-Site/en_US"; // Base URL for the application
			
	//-----------build number----------------------
	public  String BuildNumber="PV_29_20032024";

	//---------Name of the report-------------------
	public  String smoke="Smoke Test Report";
	public  String regression="Regression Test Report";
	
	//--------- suite running type-------------------
	public  String TestSuiteType="Regression";
	
	//-----------HTML Report location--------------
	public String Report = "C:\\Users\\user\\git\\AutomationsScripts-Etg-by-upendra4\\proVidioETG\\Reports\\ProvidioTestReport.html";
	//-----------ScreenShot of Failed test case-----
	public String ScreenShot = "C:\\Users\\user\\git\\AutomationsScripts-Etg-by-upendra4\\proVidioETG\\Reports\\ReportsScreenshot.png";

	//----------login details-------------------------
	public String   userName = "akhila.m+10@etg.digital";
	public String   passworduser = "Testing@123";
	//------------Login-------------------------------
	//------------Field Names-------------------------
	public   String UserName_Login_IP_FieldName="UserName/Email text box on the Login page";
	public   String Passowrd_Login_IP_FieldName="Password  text box on the Login page";

	//-----------input test data for login--------5-----
	public  String Invalid_UserName_Login_IP_Data="akhila.@etg.digital";
	public  String Invalid_Passowrd_Login_IP_Data="Akhireddy@07";
	public  String Invalid_EmailFormat_Login_IP_Data="akhila.metg.digital";
	public  String Empty_UserName_Login_IP_Data="";
	public  String Empty_PWD_Login_IP_Data="";
	public  String Valid_UserName_Login_IP_Data = userName;
	public  String Valid_PWD_Login_IP_Data = passworduser;
	
	//--------------create account Text-----------------------------------------------
	public   String FirstName_CA_IP_FieldNameForSpecialCharacters="special character entered in first name on the Create Account Page";
	public   String LastName_CA_IP_FieldNameForSpecialCharacters="special character entered in last name on the Create Account Page";
	
	public   String FirstName_CA_IP_FieldName="First Name text box on the Create Account Page";
	public   String LastName_CA_IP_FieldName="Last Name text box on the Create Account Page";
	public   String phone_CA_IP_FieldName="Phone Number text box on the Create Account Page";
	public   String Email_CA_IP_FieldName="Email text box on the Create Account Page";
	public   String ConfirmEmail_CA_IP_FieldName="Confirm Email text box on the Create Account Page";
	public   String Password_CA_IP_FieldName="Password text box on the Create Account Page";
	public   String ConfirmPassword_CA_IP_FieldName="Confirm Password text box on the Create Account Page";
	
	private static Faker faker = new Faker();
	private static String NewnameforCreateAccount = faker.name().firstName()+"@gmail.com"; 
	private static String NewnameforCreateAccount2 = faker.name().firstName()+"@gmail.com"; 
    
    
	
	//---------------create account data--------------------------------------------------
	public   String FirstName_CA_IP_Data= baseClass.fakeFirstName;
	public   String LastName_CA_IP_Data= baseClass.fakelastName;
	public   String phone_CA_IP_Data= "6789765567";
	public   String Invalidphone_CA_IP_Data= "111111111";
	public   String InvalidEamil_CA_IP_Data= "Upendra";
	public   String AlreadyExistsEmail_CA_IP_Data= "Upendra.y@gmail.com";
	public   String DifferentEmail_CA_IP_Data= "Upendra.y123@gmail.com";
	public   String Email_CA_IP_Data= NewnameforCreateAccount;
	public   String ConfirmEmail_CA_IP_Data= NewnameforCreateAccount;
	public   String DifferentPWD_CA_IP_Data= "Providio@121";
	public   String WeakPWD_CA_IP_Data= "pov";
	public   String Password_CA_IP_Data= "Providio@1218";
	public   String ConfirmPassword_CA_IP_Data="Providio@1218";
	
	//-------------create account data for special characters--------------
	public   String Email_CA_IP_Data_SpecialChar= NewnameforCreateAccount2;
	public   String ConfirmEmail_CA_IP_Data_SpecialChar= NewnameforCreateAccount2;
	
	//-------------------Check Order with valid details------------------------------------
	public static String orderNumberForCheckOrder="80045016";
	public String orderEmailForCheckOrder="akhila.m@etg.digital";
	public String orderBillingZipForCheckOrder="33130";
	
	//-----------------check order with invalid email details-------------------
	public String invalidOrderEmailForCheckOrder="akhila";
	
	//------------------check order with incomplete email-------------
	public String inCompleteOrderEmailForCheckOrder="akhila@";
	
	//-------------incorrect billing zip code-----------------
	public String inCorrectBillingZipCodeInCheckOrder="7847385438953459";
	
	//-------------------search product ----------------------------
	
	public   String Search_Home_Page_IP_FieldName="Search box on the Home Page";
	
	//------------------------data -------------------------------------------------------
	public   String Search_Home_Page_IP_Data="Mens";
	public   String Search_Home_Page_IP_Data_Reviews="82936941M";
	
	//----------------- search prodcut set -----------------------------
	public static   String Search_OutfitForProductSet="OUTFITS";
	
	//-------------------------------search bar -----------------------------
	
	public  String enterDataInSearchBar = "Rings";
	public  String enterThreeCharactersInSearchBar = "dhd";	
	public static String[] searchProducts = {"Slim Pants","Floral Ruffly Seam Party Dress"};
	
	//--------------minicart----------------------------------------------
	public  static double  expectedTotalCostInMinicart = 0.00;
	public  static double estimatedTotalInMiniCart = 0.00;
	
	//------------cart page--------------------
	public  static double sumOfAllProductsTotalInCart = 0.00;
	public  static double subTotalInCart = 0.00;
	public  static double shippingCostInCart = 0.00;
	public  static double salesTaxInCart = 0.00;
	public  static double expectedEstimatedTotalInCart = 0.00;
	public  static String salesTaxValueBeforeQuantityIncrease="";
	public  static String salesTaxValueAfterQuantityIncrease="";
	
	//--------------email in contact us----------------
	public  static  String webEmailInContactUs= "akhila.m@etg.digital";
	public  static  String invalidEmailInContactUs= "akhila";
	
	//-------------Find a store ----------------
	public static String findStoreProduct="Cotton Stretch Pant";
	
	//--------------selected clp page --------------------------------	
	public static String Selcted_Clp_Name ="";
	
	
	static String AddressTitle = faker.name().firstName() + "HOME";
	//--------------Adding Addres from my account page field names----------------------
	public   String AddressTitle_MAP_IP_FieldName="Address Title text box on the adding new address Page";
	public   String FirstName_MAP_IP_FieldName="First Name text box on the adding new address Page";
	public   String LastName_MAP_IP_FieldName="Last Name text box on the adding new address Page";
	public   String Address1_MAP_IP_FieldName="Address1 text box on the adding new address Page";
	public   String phone_CA_MAP_FieldName="Phone Number text box on the adding new address Pagee";
	
	//---------------adding address form my account page input data--------------------------------
	public   String AddressTitle_MAP_IP_Data= AddressTitle;
	public   String Already_AddressTitle_MAP_IP_Data= "office";
	public   String FirstName_MAP_IP_Data= faker.name().firstName();
	public   String LastName_MAP_IP_Data= faker.name().firstName();
	public   String Phone_MAP_IP_Data= "6789765567";
	
	//--------------change password-----------------------------------------------
	
	public   String CurrentPWD_MAP_IP_FieldName="Current PWD text box on the Change Pwd Form";
	public   String NewCurrentPWD_MAP_IP_FieldName="Address1 text box on the adding new address Page";
	public   String ConformCurrentPWD_MAP_IP_FieldName="Phone Number text box on the adding new address Pagee";
	
	//-------------- change password data----------------------------------------------

	public   String Different_CurrentPWD_MAP_IP_Data="AxpY7JeLW4tbLK";
	public   String Valid_CurrentPWD_MAP_IP_Data=passworduser;
	public   String Valid_NewCurrentPWD_MAP_IP_Data=passworduser;
	public   String Valid_ConformCurrentPWD_MAP_IP_Data=passworduser;
	
	
	//----------------Edit profile my account page -------------------------------------
	
	public   String FirstName_MAP_EditProfile_IP_FieldName="First Name text box on the MY Account Edit Profile Page";
	public   String LastName_MAP_EditProfile_IP_FieldName="Last Name text box on the MY Account Edit Profile Page";
	public   String phone_MAP_EditProfile_IP_FieldName="Phone Number text box on the MY Account Edit Profile Page";
	public   String Email_MAP_EditProfile_IP_FieldName="Email text box on the MY Account Edit Profile Page";
	public   String ConfirmEmail_MAP_EditProfile_IP_FieldName="Confirm Email text box on the MY Account Edit Profile Page";
	public   String Password_MAP_EditProfile_IP_FieldName="Password text box on the MY Account Edit Profile Page";
	
	//----------------Edit profile my account page data-------------------------------------
	public   String FirstName_MAP_EditProfile_IP_Data=faker.name().firstName();
	public   String LastName_MAP_EditProfile_IP_Data= faker.name().firstName();
	public   String phone_MAP_EditProfile_IP_Data= "6789765567";
	public   String Invalid_phone_MAP_EditProfile_IP_Data= "111111111";
	public   String Invalid_Email_MAP_EditProfile_IP_Data= "Upendra";
	public   String Different_Email_MAP_EditProfile_IP_Data= "Upendra.y123@gmail.com";
	public  String Valid_Email_MAP_EditProfile_Data = userName;
	public  String Different_PWD_MAP_EditProfile_Data = "AxpY7JeLW4tbL@";
	public  String Valid_PWD_MAP_EditProfile_Data = passworduser;
	
	
	//----------------stripe -----------------------------------------
	
	public static  String InputFieldName="Stripe Card Name";
	
	//-----------------data------------------------------------------ 
	public static String InputFieldData="Upendra";
    
	//------------gift card input---------------------------------
	public   String Gift_Card_MAP_IP_FieldName="Gift Card text box on the MY Account Page";
	//------------data--------------------------------------------
	public String Valid_Gift_Cerificate_MAP_IP_DataForRegUser="YKRLFGHTAFKZWGJW";
	public String Valid_Gift_Cerificate_MAP_IP_DataForGuestUser="ITLTTWWSGDTWPRCR";
	public String Invalid_Gift_Cerificate_MAP_IP_Data="FOJKHJKRQVLQMCHAqqqq";
	public String AlreadyAdded_Gift_Cerificate_MAP_IP_Data="FOJKHJKRQVLQMCHA";
	public String Insuffient_Gift_Cerificate_MAP_IP_Data="FOJKHJKRQVLQMCHA";
	public String Different_Customer_Gift_Cerificate_IP_Data="FWKMZQVMLQVWPDRT";
	
	//-------------checkbalance input ---------------------------
	public   String CheckBalance_Gift_Card_MAP_IP_FieldName="Check Balance Gift Card text box on the MY Account Page";
	
	
	//----------------------selected filters in plp -----------------
	public static String filterBeforeRefresh="";
	public static String filterAFterRefresh="";
	
	
	//--------------PDP page----------------------------------------
	public String Input_PDP_IP_FieldName="Input text box on the Product Deatial page";
	
	//-------------power reviews text boxes-----------------------
	public String HeadLine_RP_IP_FieldName="HeadLine text box on the Product Reivew page";
	public String Comment_RP_IP_FieldName="Comment text box on the Product Reivew page";
	public String Nickname_RP_IP_FieldName="Nickname text box on the Product Reivew page";
	public String Location_RP_IP_FieldName="Location text box on the Product Reivew page";
	
	//-------------power reviews data ----------------------------
	public String HeadLine_RP_IP_Data="I would buy from this merchant again and again";
	public String Comment_RP_IP_Data="How was your experience with this seller? What were some great or not-so-great things about this shopping experience";
	public String Nickname_RP_IP_Data="Upendra";
	public String Location_RP_IP_Data="Hyderabad";
	
	//-------------yopto reviews text boxes-----------------------
	
	public String Title_Yopto_RP_IP_FieldName="Title Yopto text box on the Product Reivew page";
	public String Review_Yopto_RP_IP_FieldName="Review content Yopto text box on the Product Reivew page";
	public String UserName_Yopto_RP_IP_FieldName="UserName Yopto text box on the Product Reivew page";
	public String UserEmail_Yopto_RP_IP_FieldName="UserEmail Yopto text box on the Product Reivew page";
	public String Search_Yopto_RP_IP_FieldName="Search box on the Product Reivew page";
	public String Question_Yopto_RP_IP_FieldName="Question Yopto text box on the Product Reivew page";
	
	static String ReviewTitle = faker.name().firstName() + "Test";
	//-------------yopto reviews data ----------------------------
	public String Title_Yopto_RP_IP_Data=ReviewTitle;
	public String Review_Yopto_RP_IP_Data="The Product is very nice";
	public String UserName_Yopto_RP_IP_Data=faker.name().firstName();
	public String UserEmail_Yopto_RP_IP_Data="upendra123@gmail.com";
	
	//----------------bread crumbs in pdp ------------------------
	public static String breadcrumbInPdpBeforeRefresh="";
	public static String breadcrumbInPdpAfterRefresh="";
	
	//-----------search review ----------------
	public String Search_Review_Yopto_RP_IP_Data="Amazing";
	public String InValid_Search_Review_Yopto_RP_IP_Data="123";
	
	
	//------------CheckOut-signin-------------------------------
	//------------Field Names-------------------------
	public   String UserName_Checkout_Login_IP_FieldName="UserName/Email text box on the Checkout page";
	public   String Passowrd_Checkout_Login_IP_FieldName="Password  text box on the Checkout page";
	
	public  String Invalid_Email_Login_IP_Data="invalid";
	
	//--------------Guest checkout -------------------------
	public   String Guest_Email_Checkout_Login_IP_FieldName="Guest_Email text box on the Checkout page";
	
	public   String Guest_Email_Checkout_Login_IP_Data= faker.name().firstName() + "@gmail.com";
	
	
	//------------CheckOut-CreateAccount-------------------------------
	public   String FirstName_Checkout_CA_IP_FieldName="First Name text box on the Checkout Create Account Page";
	public   String LastName_Checkout_CA_IP_FieldName="Last Name text box on the Checkout Create Account Page";
	public   String phone_Checkout_CA_IP_FieldName="Phone Number text box on the Checkout Create Account Page";
	public   String Email_Checkout_CA_IP_FieldName="Email text box on the Checkout Create Account Page";
	public   String ConfirmEmail_Checkout_CA_IP_FieldName="Confirm Email text box on the Checkout Create Account Page";
	public   String Password_Checkout_CA_IP_FieldName="Password text box on the Checkout Create Account Page";
	public   String ConfirmPassword_Checkout_CA_IP_FieldName="Confirm Password text box on the Checkout Create Account Page";
	
	//---------------------data--------------------------------------------
	private static String NewnameforCreateAccountCp = faker.name().firstName()+"@gmail.com"; 
	public   String Email_CP_CA_IP_Data= NewnameforCreateAccountCp;
	public   String ConfirmEmail_CP_CA_IP_Data= NewnameforCreateAccountCp;
	
	//------------WishList-signin-------------------------------
	//------------Field Names-------------------------
	public   String UserName_WishList_Login_IP_FieldName="UserName/Email text box on the WishList page";
	public   String Passowrd_WishList_Login_IP_FieldName="Password  text box on the WishList page";
	
	//------------WishListPage-CreateAccount-------------------------------
	public   String FirstName_WishList_CA_IP_FieldName="First Name text box on the WishList Create Account Page";
	public   String LastName_WishList_CA_IP_FieldName="Last Name text box on the WishList Create Account Page";
	public   String phone_WishList_CA_IP_FieldName="Phone Number text box on the WishList Create Account Page";
	public   String Email_WishList_CA_IP_FieldName="Email text box on the WishList Create Account Page";
	public   String ConfirmEmail_WishList_CA_IP_FieldName="Confirm Email text box on the WishList Create Account Page";
	public   String Password_WishList_CA_IP_FieldName="Password text box on the WishList Create Account Page";
	public   String ConfirmPassword_WishList_CA_IP_FieldName="Confirm Password text box on the WishList Create Account Page";
	
	//---------------------data--------------------------------------------
	private static String NewnameforCreateAccountWL = faker.name().firstName()+"@gmail.com"; 
	public   String Email_WL_CA_IP_Data= NewnameforCreateAccountWL;
	public   String ConfirmEmail_WL_CA_IP_Data= NewnameforCreateAccountWL;
	
	
	//-------------payment page -----------------------------

	public   String Gift_Card_PP_IP_FieldName="Gift Card text box on the Payment Page";

	
	public static String previousPaymentInPlaceorderPage = "";
	public static String paymentafterEditInPlaceorderPage = "";
	public static String firstcombinationOfPaymentInPlaceorderPage = "";
	public static String secondcombinationOfPaymentInPlaceorderPage = "";
	public static String previousFirstcombinationOfPaymentInPlaceorderPage = "";
	public static String previousSecondcombinationOfPaymentInPlaceorderPage = "";
	
	//----------- address  and payment in buy now pop up ----------------------
	public static  String  creditCardInBuyNowPopUp="";
	public static  String  paymentInBuyNowPopUp="";
	public static  String  outOfStockProductInBuyNow="GARMIN--GPSMAP-496M";
	
	//------------Gift certificate codes for full redemption---------
	public static String[] GiftCerificateCodeforGc = {"DKCPFGJTSYVGCSVH","MDTYMPYOFTOSQRAW","QFGRMQHAVKMRQSDW"} ;
	//-------------Gift certifcate codes for partially redemption-------	
	//-------------Gift certifcate codes for partially redemption-------	
	public static String[] GiftCerificateCodeCombination = { "ZWFGIKAJIDVCIJDD","PLZKTFLHCAQPVPKR","RYATTLQTKGCZOZYM","SIGJOFZHZLVGDGZY","ISVCZZMLYJSITSOV","TOIMZZAYAAYGCZAR","YYGYOFCSWHWZGMJF","ZARPZIWSSYQDSZKS",
			"RVZGKIGYLZMWGSGSx","AGQPOHLQLFQMQZKM","OTGFCRMPARLCRCQT","THWSDJJSHQMZCHPY"};

	//-------------Scorcher deal ----------------
	public static String standardPrice ="";
	public static String salePrice="";
	public static String scorcherDealProduct="";
	
	//------------------- shipping address page ------------------------
	
	public   String FirstName_Shipping_Address_IP_FieldName="First Name text box on the Shipping Address page";
	public   String LastName_Shipping_Address_IP_FieldName="Last Name text box on the Shipping Address page";
	public   String address1_Shipping_Address_IP_FieldName="Phone Number text box on the Shipping Address page";
	public   String phone_Shipping_Address_IP_FieldName="Phone Number text box on the Shipping Address page";
	
	//-------------------------character limit in address 1 and address 2
	public static String CharactersInshippingAndBillingaddress1And2="ThisIsA35CharacterString12345678912454";
	public static String CharactersInshippingAndBillingaddress1And2Empty="";
	

	//--------------------order confirmation page to create account-----------
	public static String newPasswordInSaveMyInformation = "Testing@12";
	public static String newPasswordForMismatchInSaveMyInformation = "Testing@1245";
	public static String existingEmailToCreateAccountForErrorMessage = "akhila.m@etg.digital";
	
	//--------------paypal credientails-----------
	public static String rahulNayakPaypalUserName = "rahulnaik@etisbew.com";
	public static String rahulNayakPaypalPassword  = "Etgsfcc245@";
	
	public static String pushpaPaypalUserName = "pushpa.s@etg.digital";
	public static String pushpaPaypalPassword  = "Test@2122";
	
	//---------default credit card and paypal---------
	public static String defaultCreditCardInMyAccount = " ";
	public static String defaultPaypalInMyAccount  = " ";
}
