package com.ak.learning;

import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class MaximizeBrowser {

	public static void main(String[] args) throws InterruptedException {
		usingArguments();
		//usingViewPort();
	}

	
	// this argument is not supported in firefox. It is applicable only for chromium based browser.
	public static void usingArguments() throws InterruptedException {

		Playwright playwriteConnection = Playwright.create();
		List<String> arguments = Arrays.asList("--start-maximized");
		Browser browser = playwriteConnection.chromium()
				.launch(new LaunchOptions().setChannel("chrome").setArgs(arguments).setHeadless(false));
		BrowserContext contexts = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = contexts.newPage();
		page.navigate("https://www.myperfectresume.com");
		System.out.println(page.title());
		Thread.sleep(2000);
		page.close();
		browser.close();
		playwriteConnection.close();
	}

	/**
	 * this is not recommended as to fetch the current view port we have to write
	 * extra also there might be the chance browser will not behave in appropriate
	 * manner.
	 * 
	 * @throws InterruptedException
	 */
	public static void usingViewPort() throws InterruptedException {

		Playwright playwriteConnection = Playwright.create();
		Browser browser = playwriteConnection.chromium()
				.launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		BrowserContext contexts = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
		Page page = contexts.newPage();
		page.navigate("https://www.myperfectresume.com");
		System.out.println(page.title());
		Thread.sleep(2000);
		page.close();
		browser.close();
		playwriteConnection.close();

	}

}
