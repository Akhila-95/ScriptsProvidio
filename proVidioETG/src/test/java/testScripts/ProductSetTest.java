package testScripts;

import org.testng.annotations.Test;

import baseClass.baseClass;
import pageObjects.ProductSet;

public class ProductSetTest extends baseClass{

	@Test
	public static void verifyingThePlaceOrderOfProductSet() throws Exception {
		ProductSet.productSet();
	}
}
