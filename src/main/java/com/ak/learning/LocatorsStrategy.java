package com.ak.learning;

import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorsStrategy {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		List<String> argument = Arrays.asList("--start-maximized");
		Browser browser = playwright.chromium().launch(new LaunchOptions().setArgs(argument).setHeadless(false).setChannel("chrome"));
		BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = context.newPage();
		page.navigate("https://www.way2automation.com/way2auto_jquery/index.php");
		page.locator("[name=name]").fill("akansh garg");
		page.locator("//input[@name='phone']").fill("8821787877");
		page.locator("//div[@id='load_box']//input[@value='Submit']").click();
		Thread.sleep(10000);
		page.close();
		playwright.close();
	}

}
