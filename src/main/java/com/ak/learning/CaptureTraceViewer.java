package com.ak.learning;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.SelectOption;

public class CaptureTraceViewer {

	public static void main(String[] args) throws InterruptedException {
         // Open a new page
			Playwright playwright = Playwright.create();
			ArrayList<String> arguments = new ArrayList<String>();
			arguments.add("--start-maximized");
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
			BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
			context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
			Page page = context.newPage();
			page.navigate("https://www.wikipedia.org/");
			Thread.sleep(5000);
			//Locator countryDropdown = page.locator("select[id='searchLanguage']");
			page.selectOption("select[id='searchLanguage']", new SelectOption().setLabel("Dansk"));
			Thread.sleep(2000);
			page.selectOption("select[id='searchLanguage']", new SelectOption().setValue("cy"));
			Thread.sleep(2000);
			page.selectOption("select[id='searchLanguage']", new SelectOption().setIndex(1));
			Thread.sleep(5000);
			context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(System.getProperty("user.dir")+File.separator+"tracing.zip")));
			page.close();
			context.close();
			playwright.close();

	}

}
