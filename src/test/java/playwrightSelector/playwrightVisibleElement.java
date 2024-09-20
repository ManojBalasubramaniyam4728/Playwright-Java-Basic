package playwrightSelector;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightVisibleElement {
	public static void main(String[] args) {
		  try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://www.amazon.com/");
		      
		      //First way of find visible
		      List<String>  allVisibleLinks=page.locator("a:visible").allInnerTexts();
		      for (String string : allVisibleLinks) {
				if (!string.isEmpty()) {
					System.out.println(string);
				}
			  }
		      
		     //See there are 3867 links in web page but visible are 326
		      System.out.println("The size of all Visible Links list is : "+allVisibleLinks.size());
		      
		     //Second way of finding
		     int visibleImageCount= page.locator("xpath=//img >> visible=true").count();
		     System.out.println(visibleImageCount);
		     
		     //second way in another selector type
		     String accountList= page.locator("text=Account & Lists >> visible=true").textContent();
		     System.out.println(accountList);
		  }
	}

}
