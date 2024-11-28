package net.bookcart.stepDefinition;


import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
BaseClass base = new BaseClass();
	
	@Before
	public void launchBrowser() {
		base.browserLaunch();
//		final byte[] screenshot = ((TakesScreenshot) base.driver).getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenshot, "image/png", "Failed step screenshot");
	}
	
	@After
	public void closeBrowser() {
		base.browserClose();
	}
//		System.out.println("Browser Closed");
//		final byte[] screenshot = ((TakesScreenshot)base.driver).getScreenshotAs(OutputType.BYTES);
//		scenario.attach(screenshot, "image/png", "Failed step screenshot");
}
