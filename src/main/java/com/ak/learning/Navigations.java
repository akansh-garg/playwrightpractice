package com.ak.learning;

import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Response;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		List<String> argument = Arrays.asList("--start-maximized");
		// Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		 Browser browser = playwright.chromium().launch(new LaunchOptions().setArgs(argument).setChannel("chrome").setHeadless(false));
		 BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
         // Open a new page
         Page page = context.newPage();

         page.navigate("https://www.myperfectresume.com");
         System.out.println("Page 1 Title: " + page.title());


         page.navigate("https://playwright.dev");
         System.out.println("Page 2 Title: " + page.title());

        
         Response goBackPage = page.goBack();
         if (goBackPage != null) {
             System.out.println("After goBack() - Page Title: " + page.title());
         } else {
             System.out.println("No page in history to go back to.");
         }


         Response goForwardPage = page.goForward();
         if (goForwardPage != null) {
             System.out.println("After goForward() - Page Title: " + page.title());
         } else {
             System.out.println("No page in history to go forward to.");
         }

         browser.close();
         playwright.close();
		
	}

}
