package com.ak.learning;

import java.nio.file.Paths;
import java.util.ArrayList;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class UploadScenario {

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		ArrayList<String> arguments = new ArrayList<String>();
		arguments.add("--start-maximized");
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
		BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
		Page page = browserContext.newPage();
		page.setDefaultNavigationTimeout(180000);
		
		page.navigate("https://www.livecareer.com/build-resume/select-resume?uploadresume=1");
		
		page.locator("//span[contains(@class,'icon-resume-existing')]").nth(0).click();
		page.locator("//button[contains(@class,'btn-next')]").click();
		Thread.sleep(2000);
		page.locator("//input[@type='file']").setInputFiles(Paths.get("D:\\automationprojects\\bolduiautomationframework\\uiautomationtestscripts\\testdata\\Barbie_CV.pdf"));

		
		Thread.sleep(10000);
		browserContext.close();
		playwright.close();

	}

	//Note: we can use mouse.move mouse.up and mouse.down operation to perform drag and drag operation.
}
