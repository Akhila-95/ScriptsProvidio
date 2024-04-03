package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.ScorcherDealTasks;

public class ScorcherDealTest extends baseClass{

	@Test
	public static void VerifyingDisplayOfComponentsInScorcherDeal() throws Exception {
		ScorcherDealTasks.displayOfComponentsInScorcherDeal();
	}
	
	@Test
	public static void VerifyingScorcherProductAddToCart() throws Exception {
		ScorcherDealTasks.addscorcherDealProductToCart();
	}
	
	@Test
	public static void VerifyingAddingTheScorcherDealproductFromHomePageAndSameProductFromPdpPageVerifyingThePrice() throws Exception {
		ScorcherDealTasks.scorcherDealproductInHomePageAndSameProductFromPdpPage();
	}
}
