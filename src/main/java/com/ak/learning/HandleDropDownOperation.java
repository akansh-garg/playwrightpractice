package com.ak.learning;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandleDropDownOperation {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.setDefaultNavigationTimeout(180000);
		page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");
		page.dragAndDrop("#draggable", "#droppable");
		/*
		 * Locator draggable = page.locator("#draggable");
		 * page.mouse().move(locator.boundingBox().x + locator.boundingBox().width/2,
		 * locator.boundingBox().y + locator.boundingBox().height/2);
		 * page.mouse().down(); page.mouse().move(locator.boundingBox().x + 400,
		 * locator.boundingBox().y+locator.boundingBox().height/2); page.mouse().up();
		 */
		
		
		Thread.sleep(10000);
		browserContext.close();
		playwright.close();

	}

	//Note: we can use mouse.move mouse.up and mouse.down operation to perform drag and drag operation.
}
