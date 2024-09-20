package com.ak.learning;

import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingLinks {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.navigate("https://www.myperfectresume.com");
		Locator locator = page.locator("a");
		int totalLink = locator.count();
		System.out.println("total links : "+totalLink);
		
		for(int i = 0 ; i < totalLink ; i++) {
			System.out.println(String.format("inner text = %s, having href = %s",locator.nth(i).innerText(),locator.nth(i).getAttribute("href")));
		}
	}

}
