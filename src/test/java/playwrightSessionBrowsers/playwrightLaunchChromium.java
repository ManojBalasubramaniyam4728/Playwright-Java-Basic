package playwrightSessionBrowsers;

import com.microsoft.playwright.Browser;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightLaunchChromium {
	public static void main(String[] args) {
		Playwright playwright= Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://amazon.com/");
		String titel=page.title();
		System.out.println("The Title of page is : "+titel);
		String url=page.url();
		System.out.println("The url of the page is : "+url);
		browser.close();
		playwright.close();
	}

}
