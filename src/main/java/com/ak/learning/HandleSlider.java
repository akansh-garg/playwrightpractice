package com.ak.learning;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleSlider {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.setDefaultNavigationTimeout(180000);
		page.navigate("https://jqueryui.com/resources/demos/slider/default.html");
		
		Locator locator = page.locator("div[id='slider'] > span");
		page.mouse().move(locator.boundingBox().x + locator.boundingBox().width/2, locator.boundingBox().y + locator.boundingBox().height/2);
		page.mouse().down();
		page.mouse().move(locator.boundingBox().x + 400, locator.boundingBox().y+locator.boundingBox().height/2);
		page.mouse().up();
		Thread.sleep(10000);
		browserContext.close();
		playwright.close();

	}

}
