package testcases;

import utilities.DriverFunction;
import utilities.UserActions;
import pageObject.CartScreen;
import pageObject.HomeScreen;
import pageObject.PlaceOrderForm;
import pageObject.ProductScreen;
import utilities.Constant;
import org.testng.annotations.*;

public class Purchase_laptop {
	

	DriverFunction web = new DriverFunction();
	HomeScreen home = new HomeScreen();
	ProductScreen product = new ProductScreen();
	CartScreen cart = new CartScreen();
	PlaceOrderForm order = new PlaceOrderForm();

	@BeforeTest
	public void openBrowser()
	{
		web.openBrowser();
		home.launchWebsite(web.driver, Constant.URL);
	}
	
	@Test(priority=1)
	public void purchaseLaptop() throws InterruptedException
	{
		home.navigateToCategory(web.driver, Constant.CATEGORY);
		home.selectProduct(web.driver, Constant.PRODUCT1_NAME);
		product.addToCart(web.driver);
		product.popUpConfirmation(web.driver);
		product.navigateToHomeScreen(web.driver, Constant.HOME_SCREEN);
		home.navigateToCategory(web.driver, Constant.CATEGORY);
		home.selectProduct(web.driver, Constant.PRODUCT2_NAME);
		product.addToCart(web.driver);
		product.popUpConfirmation(web.driver);
		home.navigateToCart(web.driver, Constant.CART_SCREEN);
		cart.deleteProduct(web.driver, Constant.PRODUCT2_NAME, Constant.PRODUCT1_NAME);
		cart.placeOrder(web.driver);
		cart.getTotalPrice(web.driver);
		order.fillFormField(web.driver, Constant.NAME_FIELD, Constant.NAME_FIELD_VALUE);
		order.fillFormField(web.driver, Constant.COUNTRY_FIELD, Constant.COUNTRY_FIELD_VALUE);
		order.fillFormField(web.driver, Constant.CITY_FIELD, Constant.CITY_FIELD_VALUE);
		order.fillFormField(web.driver, Constant.CREDIT_CARD_FIELD, Constant.CREDIT_CARD_VALUE);
		order.fillFormField(web.driver, Constant.MONTH_FIELD, Constant.MONTH_FIELD_VALLUE);
		order.fillFormField(web.driver, Constant.YEAR_FIELD, Constant.YEAR_FIELD_VALUE);
		order.clickPurchaseButton(web.driver);
		order.getConfirmationText(web.driver);
		
	}
	
	@Test(priority=2)
	public void assertAmount()
	{
		order.assertOrderAmount(web.driver);
		order.acceptConfirmationPopup(web.driver);
	}
	
	@AfterTest
	public void closeBrowser()
	{
		web.closeBrowser();
	}
	
}
