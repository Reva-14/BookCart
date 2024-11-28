package trail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Trail {
public static void main(String[] args) {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://bookcart.azurewebsites.net/");
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    WebElement search = driver.findElement(By.xpath("//input[@type='search']"));
    search.sendKeys("The Chosen");
    WebElement select = driver.findElement(By.xpath("//span[text()=' The Chosen ']"));
    select.click();
    WebElement addToCart = driver.findElement(By.xpath("//span[contains(text(),' Add to Cart')]"));
    addToCart.click();
    WebElement cart = driver.findElement(By.xpath("(//span[@class='mat-mdc-button-touch-target'])[2]"));
    cart.click();
        
    WebElement productInCart = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]/a"));
    String text = productInCart.getText();
    System.out.println(text);
    
//    WebDriverWait wait = new WebDriverWait(driver, 10);
//    WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mat-mdc-table")));
//    WebElement cell = table.findElement(By.cssSelector(".cdk-column-title a")); // CSS selector for the <a> tag
//    String bookName = cell.getText();
//    System.out.println(bookName); // Output: The Chosen

    
//    base.waitForVisibility(locator.getTable());
//	base.getText(locator.getBookName());
}
}
