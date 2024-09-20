package playwrightSelector;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightReactSelector {
	static Page page;
	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			BrowserContext context = browser.newContext();
			page = context.newPage();
			page.navigate("https://demoqa.com/");
			
			//React selector
			Locator firstSection=page.locator("_react=Anonymous[displayName='Elements'] >> h5:text('Elements')");
			System.out.println(firstSection.innerText());
		
			
			//List of React selector
			Locator allElementSection=page.locator("_react=xd  >> h5");
			List<String> listOfElementText =allElementSection.allInnerTexts();
			listOfElementText.forEach(e->System.out.println(e));
			
			browser.close();
			playwright.close();
	   }
	}

}
