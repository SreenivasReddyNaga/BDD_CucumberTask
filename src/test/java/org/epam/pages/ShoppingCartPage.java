package org.epam.pages;

import org.epam.utils.HelperClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {

	@FindBy(id = "ptc_shopcart_pc_top")
	private WebElement inputCheckOut;

	private HelperClass helper;

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(getDriver(), this);
		helper = new HelperClass(getDriver());
	}

	public boolean isCheckOutDisplayed() {
		helper.waitForElementVisible(inputCheckOut, helper.MIDTIME);
		return inputCheckOut.isDisplayed();
	}

	public boolean isProductAddedToCart(String productName) {
		return getDriver().findElement(By.partialLinkText(productName)).isDisplayed();
	}

}
