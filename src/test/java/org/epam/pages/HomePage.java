package org.epam.pages;

import org.epam.utils.HelperClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

	private static final String HOMEPAGETTITLE = "Electronics, Cars, Fashion, Collectibles, Coupons and More Online Shopping | eBay";	

	@FindBy(id = "gh-ac")
	private WebElement inputSearchBox;

	@FindBy(id = "gh-btn")
	private WebElement buttonSearch;

	@FindBy(xpath = "//ul[@id='ListViewInner']/li//a")
	private WebElement linkFirstItem;

	private HelperClass helper;

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(getDriver(), this);
		helper = new HelperClass(getDriver());
	}

	public boolean isHomePageDisplayed() {
		return HOMEPAGETTITLE.equalsIgnoreCase(driver.getTitle().trim());
	}

	public HomePage enterSearchdata(String textToSearch) {
		helper.waitForElementVisible(inputSearchBox, helper.MIDTIME);
		inputSearchBox.clear();
		inputSearchBox.sendKeys(textToSearch);
		buttonSearch.click();
		return this;
	}
	
	public HomePage searchProduct(String textToSearch) {
		enterSearchdata(textToSearch);
		helper.waitForElementVisible(buttonSearch, helper.MIDTIME);
		buttonSearch.click();
		return this;
	}

	public ProductDetailsPage selectProduct(String textToSearch) {
		searchProduct(textToSearch);
		helper.waitForElementVisible(linkFirstItem, helper.MIDTIME);
		linkFirstItem.click();
		return new ProductDetailsPage(getDriver());
	}
}
