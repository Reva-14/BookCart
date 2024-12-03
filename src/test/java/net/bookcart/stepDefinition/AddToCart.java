package net.bookcart.stepDefinition;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.bookcart.objectRepository.ObjectRepository;

public class AddToCart {

	private ObjectRepository locator;
	private BaseClass base;
	private WebDriver driver;

	public AddToCart() {
		base = new BaseClass();
		driver = BaseClass.driver; 
		locator = new ObjectRepository(driver);
	}

	@Given("User Launches Bookcart Application {string}")
	public void user_launches_bookcart_application(String url) {

		try {
			base.launchApplication(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Searches {string} Book In The Search Bar")
	public void user_searches_book_in_the_search_bar(String bookName) {
		
		try {
			base.enterText(locator.getSearchBar(), bookName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Clicks On The Product From Search Results")
	public void user_clicks_on_the_product_from_search_results() {
		
		try {
			base.button(locator.getProductFromSearchResults());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Clicks On Add To Cart")
	public void user_clicks_on_add_to_cart() {

		try {
			base.button(locator.getAddToCartButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The Product Should Be Added To The Cart and Should Display Correct Product {string}")
	public void the_product_should_be_added_to_the_cart_and_should_display_correct_product(String bookName) {

		try {
			base.button(locator.getCartIcon());
			String productInCart1 = base.getText(locator.getFirstProductNameInCart());
//			assert productInCart1.contains(bookName) : "Product not found in cart!";
			Assert.assertEquals(bookName, productInCart1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Adds {string} Book To The Cart")
	public void user_adds_book_to_the_cart(String bookName) {

		try {
			base.enterText(locator.getSearchBar(), bookName);
			base.button(locator.getProductFromSearchResults());
			base.button(locator.getAddToCartButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Views The Cart")
	public void user_views_the_cart() throws InterruptedException {

		try {
			Thread.sleep(3000);
			base.waitForVisibility(locator.getCartIcon());
			base.button(locator.getCartIcon());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The Cart Should Contain Both The Books {string} {string}")
	public void the_cart_should_contain_both_the_books(String book1, String book2) {

		try {
			String productInCart1 = base.getText(locator.getFirstProductNameInCart());
			String productInCart2 = base.getText(locator.getSecondProductNameInCart());
//			assert productInCart1.contains(book1) : "First product not found in cart!";
//			assert productInCart2.contains(book2) : "Second product not found in cart!";
			System.out.println(book1);
			System.out.println(productInCart1);
			System.out.println(book2);
			System.out.println(productInCart2);
			Assert.assertEquals(book1, productInCart1);
			Assert.assertEquals(book2, productInCart2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The Quantity Of The Books are Verified")
	public void theQuantityOfTheBooksAreVerified() {

		try {
			String productInCart1 = base.getText(locator.getFirstProductQuantityInCart());
			String productInCart2 = base.getText(locator.getSecondProductQuantityInCart());
//			assert productInCart1.contains("1") : "First Product not found in cart!";
//			assert productInCart2.contains("1") : "Second Product not found in cart!";
			
			Assert.assertEquals("1", productInCart1);
			Assert.assertEquals("1", productInCart2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The Total Price Should Be The Sum Of Individual Prices Of The Books")
	public void the_total_price_should_be_the_sum_of_individual_prices_of_the_books() {

		try {
			String productInCart1 = base.getText(locator.getFirstProductPriceInCart());
			String productInCart2 = base.getText(locator.getSecondProductPriceInCart());
			
			Thread.sleep(5000);
			productInCart1 = productInCart1.replace("₹", "").replace(",", "");
			Thread.sleep(5000);
			productInCart2 = productInCart2.replace("₹", "").replace(",", "");
//			double price1 = Double.parseDouble(productInCart1);
//			double price2 = Double.parseDouble(productInCart2);
			
			int price1 = (int)Double.parseDouble(productInCart1);
			int price2 = (int)Double.parseDouble(productInCart2);
			
			int sum = price1+price2;

			String totalPrice = base.getText(locator.getTotalPrice());
			totalPrice = totalPrice.replace("₹", "").replace(",", "");
//			double total = Double.parseDouble(totalPrice);

			int total = (int)Double.parseDouble(totalPrice);
			
//			assert sum == total : "The Sum of Individual Prices of the books doesn't equals Total Amount";
			Assert.assertEquals(sum, total);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Refreshes The Application")
	public void user_refreshes_the_application() {

		try {
			base.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The Cart Should Still Contain The Book In The Cart {string}")
	public void the_cart_should_still_contain_the_book_in_the_cart(String bookName) {

		try {
			String productInCart1 = base.getText(locator.getFirstProductNameInCart());
//			assert productInCart1.contains(bookName) : "Product not found in cart!";
			
			Assert.assertEquals(bookName, productInCart1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User removes {string} Book From The Cart")
	public void user_removes_book_from_the_cart(String string) {

		try {
			base.button(locator.getDelete1());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The Cart Should Contain Only {string} Book")
	public void the_cart_should_contain_only_book(String bookName) {

		try {
			String productInCart1 = base.getText(locator.getFirstProductNameInCart());
//			assert productInCart1.contains(bookName) : "Product not found in cart!";
			
			Assert.assertEquals(bookName, productInCart1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Adds {string} Book To The Cart With Quantity {int}")
	public void user_adds_book_to_the_cart_with_quantity(String bookName, Integer int1) {

		try {
			base.enterText(locator.getSearchBar(), bookName);
			base.button(locator.getProductFromSearchResults());
			base.button(locator.getAddToCartButton());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@When("User Changes The Quantity Of The Book To {int} In The Cart")
	public void user_changes_the_quantity_of_the_book_to_in_the_cart(Integer int1) {

		try {
			base.waitForVisibility(locator.getAddQuantity());
			base.button(locator.getAddQuantity());	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The Cart Should Update To Show {int} Quantity Of The Book")
	public void the_cart_should_update_to_show_quantity_of_the_book(Integer int1) {

		try {
			String productInCart1 = base.getText(locator.getFirstProductQuantityInCart());
//			assert productInCart1.contains("2") : "Quantity of the book is not Updated";
			
			Assert.assertEquals("2", productInCart1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("The Total Price Should Reflect The Updated Quantity")
	public void the_total_price_should_reflect_the_updated_quantity() {

		try {
			String productInCart1 = base.getText(locator.getFirstProductPriceInCart());
			System.out.println(productInCart1);
			Thread.sleep(3000);
			String newProd = "";
			for(int i=1; i<productInCart1.length(); i++) {
				newProd = newProd + productInCart1.charAt(i); 
				System.out.println(newProd);
			}
			newProd = newProd.replace(",", "");
			System.out.println(newProd);
//			double price = Double.parseDouble(productInCart1);
			
			int price = (int)Double.parseDouble(newProd);
			
//			Integer price = Integer.parseInt(productInCart1);
			System.out.println(price);
			Thread.sleep(3000);
			String totalPrice = base.getText(locator.getTotalPrice());
			String newTotal = totalPrice.replace("₹", "").replace(",", "");
			Thread.sleep(3000);
//			double total = Double.parseDouble(totalPrice);
//			int total = Integer.parseInt(totalPrice);
			int total = (int)Double.parseDouble(newTotal);
			
//			Integer total = Integer.parseInt(totalPrice);
			System.out.println(total);

//			assert price == total : "Total Price doesn't Reflect The Updated Quantity";
			Assert.assertEquals(price, total);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
