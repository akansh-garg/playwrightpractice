package com.ak.learning;

import java.util.ArrayList;
import java.util.Random;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class HandlingCheckbox {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.navigate("https://demoqa.com/checkbox");
		page.locator(".rct-text > button").click();
		Locator checkboxes = page.locator(".rct-node-collapsed span[class='rct-checkbox']");
		Random random = new Random();
		int i = random.nextInt(0, 3);
		System.out.println(i);

		checkboxes.nth(i).check();
		System.out.println(checkboxes.nth(i).isChecked());
		Thread.sleep(2000);
		// this method always perform check operation only so to toggle the state of
		// checkbox we need to use setCheck method with true or false value.
		// checkboxes.nth(i).check();
		checkboxes.nth(i).setChecked(false);
		System.out.println(checkboxes.nth(i).isChecked());
		Thread.sleep(5000);
		page.close();
		playwright.close();

	}

}
