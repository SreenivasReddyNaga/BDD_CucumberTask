package org.epam.pages;

import org.epam.utils.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage{

	@FindBy(id = "isCartBtn_btn")
	private WebElement linkAddToCart;   
	
	private HelperClass helper;

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(getDriver(), this);
		helper = new HelperClass(getDriver());
	}

	public boolean isAddCartDisplayed() {
		helper.waitForElementVisible(linkAddToCart, helper.MIDTIME);
		return linkAddToCart.isDisplayed();
	}
	
	public ShoppingCartPage addProductToCart(){
		linkAddToCart.click();
		return new ShoppingCartPage(getDriver());		
	}
}
