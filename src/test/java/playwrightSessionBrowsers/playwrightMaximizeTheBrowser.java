package playwrightSessionBrowsers;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightMaximizeTheBrowser {
	public static void main(String[] args) {
		// By Using Dimension in java and toolkit getting height and width of the screen
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) dimension.getWidth();
		int height = (int) dimension.getHeight();
		System.out.println(width + " : " + height);

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium()
				.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

		// setting the with and height by setViewPort Method
		BrowserContext browsercontext = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = browsercontext.newPage();
		page.navigate("https://demo.automationtesting.in/FileDownload.html");
	}

}
