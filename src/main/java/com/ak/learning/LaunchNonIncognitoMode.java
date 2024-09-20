package com.ak.learning;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LaunchNonIncognitoMode {

		public static void main(String[] args) throws InterruptedException {
			Playwright playwright = Playwright.create();
			List<String> arguments = Arrays.asList("--start-maximized");
			Browser browser = playwright.chromium()
					.launch(new LaunchOptions().setChannel("chrome").setArgs(arguments).setHeadless(false));
			// instead of blank string we can specify the profile as well which we want to
			// launch
			BrowserContext persistentContext = playwright.chromium().launchPersistentContext(Paths.get(""),
					new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setViewportSize(null)
							.setArgs(arguments));
			Page page = persistentContext.newPage();
			page.navigate("https://www.myperfectresume.com");
			System.out.println(page.title());
			Thread.sleep(5000);
			page.close();
			browser.close();
			playwright.close();
		}

}
