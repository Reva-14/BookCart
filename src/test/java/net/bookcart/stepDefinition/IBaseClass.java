package net.bookcart.stepDefinition;

import org.openqa.selenium.WebElement;

public interface IBaseClass {
	public void browserLaunch();
	public void browserClose();
	public void launchApplication(String url);
	public String currentUrl();
	public void button(WebElement ele);
	public String getText(WebElement ele);
	public void enterText(WebElement ele, String text);
	public void waitForVisibility(WebElement ele);
	public  void refresh();
	public void wait(WebElement ele);
}
