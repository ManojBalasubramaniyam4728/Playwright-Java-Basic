package playwrightSessionBrowsers;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightTakeScreenshootPageAndElement {
	public static void main(String[] args) {
		 Playwright playwright=Playwright.create();
		 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		 BrowserContext browsercontext=browser.newContext();
		 Page page=browsercontext.newPage();
		 page.navigate("https://naveenautomationlabs.com/opencart");
		 
		 //taking the screenshot of the enter page
		 page.screenshot(new Page.ScreenshotOptions()
				 .setPath(Paths.get("screenshotOfThePage.png"))
				 .setFullPage(true));
		 
		 //taking the screenshot of the only viewable page
		 page.screenshot(new Page.ScreenshotOptions()
				 .setPath(Paths.get("screenshotOfTheViable.png"))
				 .setFullPage(false));
		 
		 //taking the screenshot of the element
		 page.locator("(//div[@class='row'])[3]") 
		  .screenshot(new Locator.ScreenshotOptions()
		 		 .setPath(Paths.get("screenshot.png")));
		 
		 page.close();
		 browser.close();
		 playwright.close();
		 
	}

}
