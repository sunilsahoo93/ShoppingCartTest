package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;



public class HomePage {


	WebDriver driver;

	@FindBy(xpath = "//a[normalize-space()='Cart']")
	WebElement lnk_Cart;

	@FindBys(@FindBy(xpath = "//a[contains(text(), 'Add to cart')]"))
	List<WebElement> lnk_AddtoCarts;


	List<Integer> itemIndices = new ArrayList<Integer>();

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public void addToCartRandomItems(int count) throws InterruptedException {

		int items = 0;
		int item = 0;

		items = lnk_AddtoCarts.size();

		getRandomUniqueNumbers(0, items-1, 4);
		Thread.sleep(2000); 

		for(int i=0; i < itemIndices.size(); i++) {	
			item = itemIndices.get(i);
			System.out.println("Item added:"+ item);
			lnk_AddtoCarts.get(item).click();
			Thread.sleep(8000);  
		}



		System.out.println(count + " items added to the cart");
	}


	public void viewCart() {
		lnk_Cart.click();
		System.out.println("Clicked on view cart link");
	}


	public void getUniqueItemNumber(int item) {
		if (!itemIndices.contains(item)) {
			itemIndices.add(item);
		}else {

		}
	}

	public void getRandomUniqueNumbers(int lowerBoundary, int UpparBoundary, int count) {

		int retVal=0;

		retVal = (int)((Math.random()*(UpparBoundary - lowerBoundary)) + lowerBoundary);

		while (itemIndices.size() < count) {
			if(!itemIndices.contains(retVal)){
				itemIndices.add(retVal);
			}else {
				retVal = (int)((Math.random()*(UpparBoundary - lowerBoundary)) + lowerBoundary);
			}
		}		
	}

}
