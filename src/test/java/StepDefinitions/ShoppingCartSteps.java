package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.CartPage;
import Pages.HomePage;
import io.cucumber.java.en.*;

public class ShoppingCartSteps {

	WebDriver driver = InitializationHooks.driver;
	HomePage homepage;
	CartPage cartpage;
	public int lowestPriceItemIndex;



	@Given("^I add four random items to my cart$")
	public void i_add_four_random_items_to_my_cart() throws Throwable {

		driver.navigate().to("https://cms.demo.katalon.com/");
		homepage = new HomePage(driver);
		cartpage = new CartPage(driver);

		homepage.addToCartRandomItems(4);


	}

	@When("^I view my cart$")
	public void i_view_my_cart() throws Throwable {
		homepage.viewCart();

	}

	@When("^I search for lowest price item$")
	public void i_search_for_lowest_price_item() throws Throwable {
		lowestPriceItemIndex = cartpage.getLowestPriceItem();
	}

	@Then("^I find total four items listed in my cart$")
	public void i_find_total_four_items_listed_in_my_cart() throws Throwable {
		cartpage.validateItemsCountInCart(4);
	}

	@Then("^I am able to verify three items in my cart$")
	public void i_am_able_to_verify_three_items_in_my_cart() throws Throwable {
		cartpage.validateItemsCountInCart(3);

	}

	@And("^I am able to remove the lowest price item from my cart$")
	public void i_am_able_to_remove_the_lowest_price_item_from_my_cart() throws Throwable {

		cartpage.removeItem(lowestPriceItemIndex);
		
	}


}
