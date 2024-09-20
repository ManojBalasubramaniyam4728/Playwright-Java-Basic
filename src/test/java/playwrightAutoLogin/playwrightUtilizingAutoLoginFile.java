package playwrightAutoLogin;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightUtilizingAutoLoginFile {
	public static void main(String[] args) throws InterruptedException {
		 Playwright playwright=Playwright.create();
		 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		 BrowserContext browsercontext=browser.newContext(new Browser.NewContextOptions().setStorageStatePath(Paths.get("appLogin.json")));
		 Page page=browsercontext.newPage();
		 page.navigate("https://www.fireflink.com/signin");
		 
		 Thread.sleep(5000);
		 browser.close();
		 playwright.close();
	}

}
