package playwrightBrowserContext;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightBrowerContext {
	
	public static void main(String[] args) {
		
	  Playwright playwright=Playwright.create();
	  Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
	  
	  //Creating The BrowserContext by interface and setting the 1 activity
	  BrowserContext browsercontext1=browser.newContext();
	  Page page1=browsercontext1.newPage();
	  page1.navigate("https://amazon.com/");
	  page1.fill("#twotabsearchtextbox", "Java Selenium Books");
	  System.out.println(page1.title());
	  
	  //Creating the browserContext by interface and setting the 2 activity
	  BrowserContext browsercontext2=browser.newContext();
	  Page page2=browsercontext2.newPage();
	  page2.navigate("https://www.flipkart.com/");
	  page2.getByPlaceholder("Search for products, brands and more").fill("Java Playwright books");
	  System.out.println(page2.title());
	  
	  page1.close();
	  browsercontext1.close();
	  
	  page2.close();
	  browsercontext2.close();
	  
	  browser.close();
	  playwright.close();
	}

}
