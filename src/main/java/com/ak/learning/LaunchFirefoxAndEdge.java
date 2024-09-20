package com.ak.learning;

import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class LaunchFirefoxAndEdge {

	public static void main(String[] args) throws InterruptedException {
		//launchEdge();
		launchFirefox();
	}
	
	public static void launchFirefox() throws InterruptedException {

		Playwright playwriteConnection = Playwright.create();
		List<String> arguments = Arrays.asList("--start-maximized");
		Browser browser = playwriteConnection.firefox()
				.launch(new LaunchOptions().setChannel("firefox").setArgs(arguments).setHeadless(false));
		BrowserContext contexts = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = contexts.newPage();
		page.navigate("https://www.myperfectresume.com");
		System.out.println(page.title());
		Thread.sleep(2000);
		page.close();
		browser.close();
		playwriteConnection.close();
	}
	
	public static void launchEdge() throws InterruptedException {

		Playwright playwriteConnection = Playwright.create();
		List<String> arguments = Arrays.asList("--start-maximized");
		Browser browser = playwriteConnection.chromium()
				.launch(new LaunchOptions().setChannel("msedge").setArgs(arguments).setHeadless(false));
		BrowserContext contexts = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = contexts.newPage();
		page.navigate("https://www.myperfectresume.com");
		System.out.println(page.title());
		Thread.sleep(2000);
		page.close();
		browser.close();
		playwriteConnection.close();
	}

}
