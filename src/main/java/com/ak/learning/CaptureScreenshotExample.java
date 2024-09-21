package com.ak.learning;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Playwright;

public class CaptureScreenshotExample {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.setDefaultNavigationTimeout(180000);
		page.navigate("https://www.myperfectresume.com");
		byte[] screenshotArray=page.screenshot(new ScreenshotOptions().setFullPage(true).setPath(Paths.get(System.getProperty("user.dir")+File.separator+"homepage.png")));
		
		Thread.sleep(10000);
		browserContext.close();
		playwright.close();

	}

}
