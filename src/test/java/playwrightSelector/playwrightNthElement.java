package playwrightSelector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightNthElement {
	static Page page;

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			BrowserContext context = browser.newContext();
			page = context.newPage();
			page.navigate("https://www.bigbasket.com/");

			// nth element and get text on 0th element
			Locator firstElement = page.locator("//h4[text()='Bigbasket']/..//li/a >> nth=0");
			String firstName = firstElement.innerText();
			System.out.println(firstName);

			// nth element and get text on last element
			Locator lastElement = page.locator("//h4[text()='Bigbasket']/..//li/a >> nth=-1");
			String lastName = lastElement.innerText();
			System.out.println(lastName);

			// nth element and get text of all the element using custom method
			Locator listofLink = page.locator("//h4[text()='Bigbasket']/..//li/a");
			int count = listofLink.count();
			for (int i = 0; i < count; i++) {
				String text = getTextFromListOfElementUsingNthSElector(i);
				System.out.println(text);
			}
			
			
			browser.close();
			playwright.close();

		}
	}

	// custom method to get the text from element using nth selector
	public static String getTextFromListOfElementUsingNthSElector(int NthNumber) {
		String text = page.locator("//h4[text()='Bigbasket']/..//li/a >> nth=" + NthNumber + "").innerText();
		return text;
	}

}
