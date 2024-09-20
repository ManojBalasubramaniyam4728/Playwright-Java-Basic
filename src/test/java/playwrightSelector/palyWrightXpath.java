package playwrightSelector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class palyWrightXpath {
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://selectorshub.com/xpath-practice-page/");
		      
		      //Xpath playwright way
		      page.locator("xpath=//a[text()='Jasmine.Morgan']/../..//td/input").click();
		      
		      //Xpath normal way
		      page.locator("//a[text()='Joe.Root']/../..//td/input").click();
		      
		      //Xpath Preceding
		      page.locator("//a[text()='John.Smith']/preceding::td/input");
		      
		      //Remaining all the technique you know that is 
		      //Following sibling, preceding sibling, ancestor, descendants indexing all 
		      
		      browser.close();
		      playwright.close();
		 }
	}

}
