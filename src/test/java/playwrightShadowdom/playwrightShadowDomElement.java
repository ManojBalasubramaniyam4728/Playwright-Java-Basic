package playwrightShadowdom;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightShadowDomElement {
	public static void main(String[] args) {
		Playwright pw = Playwright.create();
		Browser br = pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		// context one
		// Page -- DOM --> Shadow DOM --> Elements
		BrowserContext bc1 = br.newContext();
		Page pg1 = bc1.newPage();
		pg1.navigate("https://books-pwakit.appspot.com/");

		// If you want to perform any auction you need to come from parent dom
		pg1.locator("book-app[apptitle='BOOKS'] #input").fill("The Automation Book");

		// still you want to perform any action you need to come from parent dom
		String books = pg1.locator("book-app[apptitle='BOOKS'] div.books-desc").textContent();
		System.out.println(books);

		pg1.close();
		bc1.close();

		//Commenting below code because Dom Got changed.
		
		// context two
		// Page -- DOM --> iFrame --> Shadow DOM --> Elements
		
//		BrowserContext bc2 = br.newContext();
//		Page pg2 = bc2.newPage();
//		pg2.navigate("https://selectorshub.com/xpath-practice-page/");
//
//		// If you want to perform any auction you need to come from parent dom
//		pg2.frameLocator("#pact").locator("div#snacktime #tea").fill("Ginger Masala Tea");
//
//		pg2.close();
//		bc2.close();
		
		br.close();
		pw.close();

	}

}
