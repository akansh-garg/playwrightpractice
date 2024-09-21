package com.ak.learning;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class KeyboardOperation {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.setDefaultNavigationTimeout(180000);
		page.navigate("https://login.yahoo.com/");
		page.locator("input[id=login-username]").fill("akansh_garg");
		page.keyboard().press("Enter");
		Thread.sleep(2000);
		page.goBack();
		Thread.sleep(2000);
		page.keyboard().press("Control+A");
		Thread.sleep(2000);
		page.keyboard().press("Control+X");
		Thread.sleep(2000);
		page.keyboard().press("Control+V");
		Thread.sleep(2000);
		page.keyboard().down("Shift");
		
		for(int i = 0 ; i < 3 ; i++) {
			page.keyboard().press("ArrowLeft");
			Thread.sleep(2000);
		}
		
		Thread.sleep(10000);
		browserContext.close();
		playwright.close();

	}

	//Note: we can use mouse.move mouse.up and mouse.down operation to perform drag and drag operation.
}
