package com.ak.learning;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadOperation {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.setDefaultNavigationTimeout(180000);
		page.navigate("https://www.selenium.dev/downloads/");
		Download file = page.waitForDownload(() -> {
			page.locator(
					"div[class='row justify-content-center px-5 pb-5'] div:nth-child(3) div:nth-child(1) div:nth-child(2) p:nth-child(2) a:nth-child(1)")
					.click();
		});

		file.saveAs(Paths.get(System.getProperty("user.dir") + File.separator + "myfirstdownload.zip"));
		Thread.sleep(10000);
		browserContext.close();
		playwright.close();

	}

}
