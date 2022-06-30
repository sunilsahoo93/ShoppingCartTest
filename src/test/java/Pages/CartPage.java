package Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	WebDriver driver;


	@FindBy(xpath = "//a[normalize-space()='Cart']")
	WebElement lnk_Cart;



	@FindBy(xpath = "//a[@aria-label ='Remove this item']")
	List<WebElement> lnk_RemoveItems;

	@FindBys(@FindBy(xpath = "//td[@class ='product-price']/span[1]"))
	List<WebElement> txt_prices;

	@FindBys(@FindBy(xpath = "//td[@class='product-name']"))
	List<WebElement> txt_products;




	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void validateItemsCountInCart(int expectedCount) {		
		int actualCount = 0;

		actualCount = lnk_RemoveItems.size();

		Assert.assertEquals(expectedCount, actualCount);

	}

	public int getLowestPriceItem() {

		int pricesCount = txt_prices.size();

		int itemIdex = 0;
		String itemName = null;

		ArrayList<Float> priceList = new ArrayList<Float>();


		for(int i = 0; i < pricesCount; i++) {			
			String price = txt_prices.get(i).getText().replace("$", "");
			priceList.add(Float.parseFloat(price));
		}

		itemIdex = priceList.indexOf(Collections.min(priceList));
		itemName = txt_products.get(itemIdex).getText();
		System.out.println("Lowest price item name is: '" + itemName + "' and index is:"+ itemIdex);
		return itemIdex;
	}

	public void closeWebSite() {

		try {			
			driver.close();			
			System.out.println("Website closed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			Assert.fail();
		}

	}


	public void removeItem(int itemIndex) {

		try {
			lnk_RemoveItems.get(itemIndex).click();
			Thread.sleep(2000);
			System.out.println("Item with lowest price removed successfully");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
			Assert.fail();
		}

	}

}
