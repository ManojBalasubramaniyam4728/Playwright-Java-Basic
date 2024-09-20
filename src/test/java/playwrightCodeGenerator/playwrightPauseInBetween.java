package playwrightCodeGenerator;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;

public class playwrightPauseInBetween {
	 public static void main(String[] args) {
		    try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
		        .setHeadless(false));
		      BrowserContext context = browser.newContext();
		      Page page = context.newPage();
		      page.navigate("https://www.amazon.com/");
		      page.locator("#glow-toaster-body").click();
		      
		      //Pause
		      page.pause();
		      
		      page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Submit")).first().click();
		      page.getByPlaceholder("Search Amazon").click();
		      page.getByPlaceholder("Search Amazon").fill("English Books");
		      page.getByPlaceholder("Search Amazon").press("Enter");
		    }
		  }
}
