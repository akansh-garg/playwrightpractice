package com.ak.learning;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class CaptureVideoRecording {

	public static void main(String[] args) throws InterruptedException {
         // Open a new page
			Playwright playwright = Playwright.create();
			ArrayList<String> arguments = new ArrayList<String>();
			arguments.add("--start-maximized");
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null).setRecordVideoDir(Paths.get(System.getProperty("user.dir") + File.separator + "videos")));
			Page page = context.newPage();
			page.navigate("https://www.wikipedia.org/");
			//Locator countryDropdown = page.locator("select[id='searchLanguage']");
			page.selectOption("select[id='searchLanguage']", new SelectOption().setLabel("Dansk"));
			Thread.sleep(2000);
			page.selectOption("select[id='searchLanguage']", new SelectOption().setValue("cy"));
			Thread.sleep(2000);
			page.selectOption("select[id='searchLanguage']", new SelectOption().setIndex(1));
			Thread.sleep(5000);
			page.close();
			context.close();
			playwright.close();

	}

}
