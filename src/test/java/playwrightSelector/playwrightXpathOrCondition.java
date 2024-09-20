package playwrightSelector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightXpathOrCondition {
	public static void main(String[] args) {
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://www.amazon.com/");
		      
		      //comma saprated Xpath selector or Xptha union
		      Locator singinButton= page.locator("//a[@id='nav-link-accountList'] | //a[@data-csa-c-content-id='nav_ya_signin']");
		      singinButton.hover();
		      
		      browser.close();
		      playwright.close();
		 }
		      
	}

}
