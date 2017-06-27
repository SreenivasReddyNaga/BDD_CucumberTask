package org.epam.stepdefinition;

import org.epam.browser.SetUpWebDriver;
import org.epam.browser.WebDriverBaseClass;
import org.epam.pages.HomePage;
import org.epam.pages.ProductDetailsPage;
import org.epam.pages.ShoppingCartPage;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddToCartStepDefs extends WebDriverBaseClass {	
	private HomePage homePage;
	private ProductDetailsPage productPage;
	private ShoppingCartPage shoppingPage;

	@Given("^I Navigate to Ebay HomePage$")
	public void i_Navigate_to_Ebay_HomePage() {		
		SetUpWebDriver.openUrl(SetUpWebDriver.initPropertiesData().getProperty("url"));
		homePage = new HomePage(SetUpWebDriver.getDriver());
		Assert.assertTrue(homePage.isHomePageDisplayed(),"Ebay Home Page is not loaded");
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String itemToSearch) {
		productPage = homePage.selectProduct(itemToSearch);
		Assert.assertTrue(productPage.isAddCartDisplayed(),"Product details page not available");
	}

	@When("^I add it to the cart$")
	public void i_add_it_to_the_cart() {
		shoppingPage = productPage.addProductToCart();
		Assert.assertTrue(shoppingPage.isCheckOutDisplayed(),"Shopping Cart page is not available");
	}

	@Then("^\"([^\"]*)\" should be available in the cart$")
	public void should_be_available_in_the_cart(String productName) {
		Assert.assertTrue(shoppingPage.isProductAddedToCart(productName),"Product added to add to cart not listed shopping cart page");
	}

}
