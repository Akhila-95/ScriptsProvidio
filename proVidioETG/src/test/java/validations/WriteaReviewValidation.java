package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseClass.baseClass;

public class WriteaReviewValidation extends baseClass{
	
	static WebElement ratings = driver.findElement(By.xpath("//li[text()='Your Rating is required']"));
	static WebElement heading = driver.findElement(By.xpath("//li[text()='Review Headline is required']"));
	static WebElement comments = driver.findElement(By.xpath("//li[text()='Comments is required']"));
	static WebElement nickName = driver.findElement(By.xpath("//li[text()='Nickname is required']"));
	static WebElement loaction = driver.findElement(By.xpath("//li[text()='Location is required']"));
	
	
	public static void verifywithOutEnteringDetails() {
		test.info("Verify all errors displayed");
    	if (ratings.isDisplayed()&&heading.isDisplayed()&&comments.isDisplayed()&&nickName.isDisplayed()&&loaction.isDisplayed()) {
    	    logger.info("Successfully Displayed ratings, heading, comments, nickName, loaction errors");
    	    test.pass("Successfully Displayed ratings, heading, comments, nickName, loaction errors");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyRatingFieldfilledRemainingEmpty() {
		test.info("Verify Rating field filled and Remaining fileds are empty, and validate error messages");
    	if (heading.isDisplayed()&&comments.isDisplayed()&&nickName.isDisplayed()&&loaction.isDisplayed()) {
    	    logger.info("Successfully Displayed heading, comments, nickName, loaction errors");
    	    test.pass("Successfully Displayed heading, comments, nickName, loaction errors");
    	}else {
    		test.fail("Click failed");
    	}
	}
	public static void verifyRatingandHeadingFieldsfilledRemainingEmpty() {
		test.info("Verify Rating and Heading fields are filled and Remaining fileds are empty, and validate error messages");
    	if (comments.isDisplayed()&&nickName.isDisplayed()&&loaction.isDisplayed()) {
    	    logger.info("Successfully Displayed comments, nickName, loaction errors");
    	    test.pass("Successfully Displayed comments, nickName, loaction errors");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyRatingHeadingandcommentsFieldsfilledRemainingEmpty() {
		test.info("Verify Rating, Heading and Comments fields are filled and Remaining fileds are empty, and validate error messages");
    	if (nickName.isDisplayed()&&loaction.isDisplayed()) {
    	    logger.info("Successfully Displayed nickName, loaction errors");
    	    test.pass("Successfully Displayed nickName, loaction errors");
    	}else {
    		test.fail("Click failed");
    	}
	}
	
	public static void verifyRatingHeadingcommentsandNickNameFieldsfilledRemainingEmpty() {
		test.info("Verify Rating, Heading, Comments and nickName are filled and Remaining fileds are empty, and validate error messages");
    	if (loaction.isDisplayed()) {
    	    logger.info("Successfully Displayed loaction error");
    	    test.pass("Successfully Displayed loaction error");
    	}else {
    		test.fail("Click failed");
    	}
	}
}
