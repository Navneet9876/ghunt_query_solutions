package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.UserActions;

public class CartScreen {
	
	UserActions action = new UserActions();
	

	public void deleteProduct (WebDriver driver, String productToBeDeleted, String productNotToBeDeleted)
	{
		By deleteXpath = By.xpath("//td[contains(text(),'"+ productToBeDeleted + "')]/parent::tr/td[4]/a[contains(text(),'Delete')]");	
		action.waitforElement(driver, deleteXpath);
		WebElement delete = driver.findElement(deleteXpath);
		delete.click();
		By existingProductXpath = By.xpath("//td[contains(text(),'"+ productNotToBeDeleted + "')]");
		action.waitForElementToBePresent(driver, existingProductXpath);
	}
	

	public String getTotalPrice (WebDriver driver)
	{
		By getTotalPriceXpath = By.xpath("//h3[@id='totalp']");
		WebElement getTotalPriceElement = driver.findElement(getTotalPriceXpath);
		String totalCartPrice = getTotalPriceElement.getText();
		System.out.println(totalCartPrice);
		return totalCartPrice;
	}
	
	public void placeOrder(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(3000);
		By placeOrderButtonXpath = By.xpath("//button[contains(text(),'Place Order')]");
		action.waitforElement(driver, placeOrderButtonXpath);
		WebElement placeOrderButton = driver.findElement(placeOrderButtonXpath);
		placeOrderButton.click();
	}
}
