package com.ak.learning;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstProgram {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwriteConnection = Playwright.create();
		Browser browser = playwriteConnection.chromium().launch(new LaunchOptions().setChannel("chrome").setHeadless(false));
		Page page = browser.newPage();
		page.navigate("https://www.myperfectresume.com");
		System.out.println(page.title());
		Thread.sleep(2000);
		page.close();
		browser.close();
		playwriteConnection.close();
		
		

	}

}
