package net.bookcart.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ObjectRepository {

public ObjectRepository(WebDriver driver) {
    PageFactory.initElements(driver, this);
}

@FindBy(xpath = "//input[@type='search']")
private WebElement searchBar;

@FindBy(xpath = "//span[@class='mdc-list-item__primary-text']")
private WebElement productFromSearchResults;

@FindBy(xpath = "//span[contains(text(),' Add to Cart')]")
private WebElement addToCartButton;

@FindBy(xpath = "(//span[@class='mat-mdc-button-touch-target'])[2]")
private WebElement cartIcon;

@FindBy(xpath = "//table/tbody/tr[1]/td[2]/a")
private WebElement firstProductNameInCart;

@FindBy(xpath = "//table/tbody/tr[2]/td[2]/a")
private WebElement secondProductNameInCart;

@FindBy(xpath = "//table/tbody/tr[1]/td[4]/div/div[2]")
private WebElement firstProductQuantityInCart;

@FindBy(xpath = "//table/tbody/tr[2]/td[4]/div/div[2]")
private WebElement secondProductQuantityInCart;

@FindBy(xpath = "//table/tbody/tr[1]/td[5]")
private WebElement firstProductPriceInCart;

@FindBy(xpath = "//table/tbody/tr[2]/td[5]")
private WebElement secondProductPriceInCart;

@FindBy(xpath = "(//td[contains(@class,'mat-mdc-cell mdc-data-table__cell')]//strong)[2]")
private WebElement totalPrice;

@FindBy(xpath = "(//mat-icon[text()='delete']/following-sibling::span)[2]")
private WebElement delete1;

@FindBy(xpath = "(//mat-icon[text()='add_circle']/following-sibling::span)[2]")
private WebElement addQuantity;

public WebElement getAddQuantity() {
	return addQuantity;
}

public WebElement getDelete1() {
	return delete1;
}

public WebElement getTotalPrice() {
	return totalPrice;
}
public WebElement getFirstProductNameInCart() {
	return firstProductNameInCart;
}

public WebElement getSecondProductNameInCart() {
	return secondProductNameInCart;
}

public WebElement getFirstProductQuantityInCart() {
	return firstProductQuantityInCart;
}

public WebElement getSecondProductQuantityInCart() {
	return secondProductQuantityInCart;
}

public WebElement getFirstProductPriceInCart() {
	return firstProductPriceInCart;
}

public WebElement getSecondProductPriceInCart() {
	return secondProductPriceInCart;
}

public WebElement getSearchBar() {
    return searchBar;
}

public WebElement getProductFromSearchResults() {
    return productFromSearchResults;
}

public WebElement getAddToCartButton() {
    return addToCartButton;
}

public WebElement getCartIcon() {
    return cartIcon;
}
}