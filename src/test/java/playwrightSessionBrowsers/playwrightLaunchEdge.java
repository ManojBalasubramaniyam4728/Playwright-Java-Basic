package playwrightSessionBrowsers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.BrowserType.LaunchOptions;

public class playwrightLaunchEdge {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		LaunchOptions lop=new LaunchOptions();
		lop.setChannel("msedge");
		lop.setHeadless(false);
		Browser browser=playwright.chromium().launch(lop);
		Page page=browser.newPage();
		page.navigate("https://amazon.com");
		String titel=page.title();
		System.out.println("The Title of page is : "+titel);
		String url=page.url();
		System.out.println("The url of the page is : "+url);
		browser.close();
		playwright.close();
	}
}
