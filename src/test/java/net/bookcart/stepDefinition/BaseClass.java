package net.bookcart.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass implements IBaseClass {

	 protected static WebDriver driver;
	 protected static WebDriverWait wait;
	 
	@Override
	public void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		System.out.println("Browser Launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
	}

	@Override
	public void browserClose() {
		driver.close();
	}

	@Override
	public void launchApplication(String url) {
		driver.get(url);
	}

	@Override
	public String currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	@Override
	public void button(WebElement ele) {
		ele.click();
	}

	@Override
	public String getText(WebElement ele) {
		String text = ele.getText();
		return text;
	}

	@Override
	public void enterText(WebElement ele, String text) {
		ele.clear();
	    ele.sendKeys(text);
	}

	@Override
	public void waitForVisibility(WebElement ele) {
//        wait.until(ExpectedConditions.visibilityOf(ele));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));

    }
	
	@Override
	public void wait(WebElement ele) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
    }

	@Override
	public void refresh() {
		driver.navigate().refresh();
		}
}
