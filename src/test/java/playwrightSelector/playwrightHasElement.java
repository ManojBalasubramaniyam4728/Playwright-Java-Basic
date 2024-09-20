package playwrightSelector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightHasElement {
	public static void main(String[] args) {
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://www.amazon.com/");
		      
		      //By keeping one element getting all the text using has elemnts
		      Locator lo=   page.locator("div.navFooterLinkCol:has(a[href='https://www.amazon.jobs'])");
		      lo.allInnerTexts().forEach(e->System.out.println(e));
		      
		      browser.close();
		      playwright.close();
		      
		     
		 }
		
	}

}
