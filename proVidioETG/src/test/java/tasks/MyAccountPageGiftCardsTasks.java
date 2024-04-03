package tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;
import data.TestData;
import functionality.Actionsss;
import pageObjects.MyAccountPage;
import validations.MyAccountValidations;

public class MyAccountPageGiftCardsTasks extends baseClass{
	private static MyAccountPage MAC= new MyAccountPage(driver);
	private static TestData TD = new TestData();
	
	public static void giftCardView() throws Exception {
		MyAccountPageTasks.myAccoutView();
		Actionsss.scrollIntoCenterView(MAC.getblockHader());
		Thread.sleep(2000);
	}
	
	public static void emptyaddtoAccount() throws Exception {
		giftCardView();
		Actionsss.CombinedClick(MAC.getapplybtn());
		MyAccountValidations.verifyemptyInput(); 
	}
	
	public static void invalidaddtoAccount() throws Exception {
		giftCardView();
		Actionsss.sendKeys(MAC.getaddingInput(), TD.Invalid_Gift_Cerificate_MAP_IP_Data,TD.Gift_Card_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.getapplybtn());
		Thread.sleep(2000);
		MyAccountValidations.verifyInvalidInput(); 
	}
	public static void insufficientaddtoAccount() throws Exception{
		giftCardView();
		Actionsss.sendKeys(MAC.getaddingInput(), TD.Insuffient_Gift_Cerificate_MAP_IP_Data,TD.Gift_Card_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.getapplybtn());
		Thread.sleep(2000);
		MyAccountValidations.verifyInsfficientInput(); 
	}
	
	
	public static void differentUseraddtoAccount() throws Exception {
		giftCardView();
		Actionsss.sendKeys(MAC.getaddingInput(), TD.Different_Customer_Gift_Cerificate_IP_Data,TD.Gift_Card_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.getapplybtn());
		Thread.sleep(2000);
		MyAccountValidations.verifydifferentUserInput();
	}
	
	public static void validaddtoAccount()throws Exception {
		// Find the element containing the balance amount
        WebElement balanceElement = driver.findElement(By.xpath("//span[@class='balAmount']"));
        // Get the text of the balance element
        String balanceText = balanceElement.getText();
        // Convert balance text to integer (remove non-numeric characters)
        originalBalance = Integer.parseInt(balanceText.replaceAll("[^0-9]", ""));
        
		giftCardView();
		Actionsss.sendKeys(MAC.getaddingInput(), TD.Valid_Gift_Cerificate_MAP_IP_DataForGuestUser,TD.Gift_Card_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.getapplybtn());
		Thread.sleep(2000);
		MyAccountValidations.validcard(); 
	}
	
	
	//-------------------check balance----------------------------------------
	public static void emptycheckBalance() throws Exception {
		giftCardView();
		Actionsss.CombinedClick(MAC.getcheckbtn());
		MyAccountValidations.verifyemptyInput(); 
	}
	
	public static void invalidcheckBalance() throws Exception {
		giftCardView();
		Actionsss.sendKeys(MAC.getcheckbalanceInput(), TD.Invalid_Gift_Cerificate_MAP_IP_Data,TD.Gift_Card_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.getcheckbtn());
		Thread.sleep(2000);
		MyAccountValidations.verifyInvalidInput(); 
	}
	public static void insufficientcheckBalance() throws Exception{
		giftCardView();
		Actionsss.sendKeys(MAC.getcheckbalanceInput(), TD.Insuffient_Gift_Cerificate_MAP_IP_Data,TD.Gift_Card_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.getcheckbtn());
		Thread.sleep(2000);
		MyAccountValidations.emptybalancechecck(); 
	}
	
	public static void validcheckBalance() throws Exception{
		giftCardView();
		Actionsss.sendKeys(MAC.getcheckbalanceInput(), TD.Valid_Gift_Cerificate_MAP_IP_DataForGuestUser,TD.Gift_Card_MAP_IP_FieldName);
		Actionsss.CombinedClick(MAC.getcheckbtn());
		Thread.sleep(2000);
		MyAccountValidations.balancechecck(); 
	}

}
