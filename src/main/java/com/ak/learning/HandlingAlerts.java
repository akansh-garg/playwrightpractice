package com.ak.learning;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingAlerts {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.setDefaultNavigationTimeout(180000);
		page.navigate("https://demoqa.com/alerts");
		
		final String dialogMessage[] = new String[1];
		page.onDialog(dialog -> {
		
		dialogMessage[0] = dialog.message();
		dialog.accept();
		});
		page.locator("#alertButton").click();
		System.out.println("alert message "+dialogMessage[0]);
		
	}

}
