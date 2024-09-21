package com.ak.learning;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingMultipleWindow {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page newPage = browserContext.newPage();
		newPage.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");
		
		Page childPage = browserContext.waitForPage(() ->  {
			newPage.locator("a[aria-label=\"Way2Automation's Terms of Use\"]").click();
		});
		
		
		System.out.println(childPage.title());
		childPage.close();
		System.out.println(newPage.title());
		
		newPage.close();
		browserContext.close();
		playwright.close();
	}

}
