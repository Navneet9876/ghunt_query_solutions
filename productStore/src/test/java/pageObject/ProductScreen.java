package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Constant;
import utilities.UserActions;

public class ProductScreen {
	
	UserActions action = new UserActions();
	By addToCartXpath = By.xpath("//a[contains(text(),'Add to cart')]");
	
	public void addToCart(WebDriver driver)
	{
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(addToCartXpath));
		WebElement addToCart = driver.findElement(addToCartXpath);
		addToCart.click();
		
	}
	
	public void popUpConfirmation(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
	}
	
	public void navigateToHomeScreen (WebDriver driver, String homeScreen )
	{
		action.navigateTo(driver, homeScreen);
	}

}
