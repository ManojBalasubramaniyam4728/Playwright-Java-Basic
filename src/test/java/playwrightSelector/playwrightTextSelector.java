package playwrightSelector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightTextSelector {
	public static void main(String[] args) {
		  try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://www.amazon.com/");
		      
		      //1. using text keyword in locator String
		      String text1=page.locator("text=Hello, sign in").textContent();
		      System.out.println(text1);
		      
		      //2. using has-text keyword
		      String text2=page.locator("span:has-text('Account & Lists')").textContent();
		      System.out.println(text2);
		      
		      //3. parent child has-text keyword
		      String text3=page.locator("a#nav-orders span:has-text('Returns')").textContent();
		      System.out.println(text3);
		      
		      //4. only text content
		      String text4=page.locator("'& Orders'").textContent();
		      System.out.println(text4);
		      
		      /*
		       * Note While performing 1 and 4 Many element present in dom mean playwright through exception
		       * saying many element present
		       * So Better use 2 and 3 approach when it is text selector
		       */
		      
		      browser.close();
		      playwright.close();
		    }
	
	}

}
