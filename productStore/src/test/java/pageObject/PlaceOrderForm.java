package pageObject;


import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.UserActions;

public class PlaceOrderForm {
	
	UserActions action = new UserActions();
	CartScreen cart = new CartScreen();
	
	public void fillFormField (WebDriver driver, String formField, String fieldValue)
	{
		By formFieldXpath = By.xpath("//input[@id='"+formField + "']");
		action.waitforElement(driver, formFieldXpath);
		WebElement formFieldElement  = driver.findElement(formFieldXpath);
		formFieldElement.clear();
		formFieldElement.sendKeys(fieldValue);
	}
	
	public void clickPurchaseButton (WebDriver driver)
	{
		By purchaseButtonXpath = By.xpath("//button[contains(text(),'Purchase')]");
		WebElement purchaseButton = driver.findElement(purchaseButtonXpath);
		purchaseButton.click();
	}
	
	public String getConfirmationText (WebDriver driver)
	{
		By confirmationText= By.xpath("//p[contains(text(),'Id')]");
		action.waitForElementToBePresent(driver, confirmationText);
		String confirmationMessage = driver.findElement(confirmationText).getText();
		String id = confirmationMessage.substring(confirmationMessage.indexOf(":")+2, confirmationMessage.indexOf(":")+9);
		System.out.println(id);
		String amount = confirmationMessage.substring(confirmationMessage.indexOf("Amount")+8, confirmationMessage.indexOf("Amount")+11);
		System.out.println(amount);
		return amount;
		
		
	}
	
	public void acceptConfirmationPopup(WebDriver driver)
	{
		By okButtonXpath = By.xpath("//button[contains(text(),'OK')]");
		WebElement okButton = driver.findElement(okButtonXpath);
		okButton.click();
	}
	
	public void assertOrderAmount(WebDriver driver)
	{
		try
		{
		assertEquals(cart.getTotalPrice(driver),this.getConfirmationText(driver));
		System.out.println("Test Passed");
		}catch (Throwable e)
		{
			System.out.println("Test Failed");
		}
	}

}
