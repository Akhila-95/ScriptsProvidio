package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import tasks.FindAStoreTasks;


public class FindAStoreTest extends baseClass {

	@Test
	public static void VerifyingTheDisplayOfFindAstoreAndItsComponents() throws Exception {
		FindAStoreTasks.displayOfFindAstoreAndItsComponents();
	}	
	
	@Test
	public static void VerifyingShippingMethodAsStorePickInShippingAddress() throws Exception {
		FindAStoreTasks.checkIngShippingMethodAsStorePick();
	}
	
	@Test
	public static void VerifyingChangeInStoreInCartPage() throws Exception {
		FindAStoreTasks.changeStoreInCart();
	}
	
	@Test
	public static void VerifyingTheInventoryCheckInPdpPage() throws Exception {
		FindAStoreTasks.inventoryCheckOfPickUpStoreFromPdpPage();
	}
	
	@Test
	public static void VerifyingSearchingOfPickUpStoreAndPlaceOrderAsGuestUser() throws Exception {
		FindAStoreTasks.searchAproductAndAddStoreGuest();
	}
	
	@Test
	public static void VerifyingPlaceOrderOfPickUpStoreAndDeliveryToAddressProductAsGuestUser() throws Exception {
		FindAStoreTasks.multiShippingAddressGuest();
	}
	
	@Test
	public static void VerifyingPlaceOrderOfPickUpStoreAndDeliveryToAddressProductAsRegisterUser() throws Exception {
		FindAStoreTasks.searchAproductAndAddStoreRegister();
	}
}
