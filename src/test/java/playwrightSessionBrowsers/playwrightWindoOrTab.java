package playwrightSessionBrowsers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightWindoOrTab {
	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page=browser.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//1.Open a new tab.window/pop up after clicking on link on the parent page:
		Page window1= page.waitForPopup(()->{
			 page.click("//div[@class='orangehrm-login-footer-sm']/..//a[3]");
		 });
		
		window1.waitForLoadState();
		
		System.out.println("Geting the window1 Title : "+ window1.title());
		Thread.sleep(3000);
		window1.close();
		System.out.println("Getting the parent window Title : "+ page.title());
		
		//2.Open a new tab/window pop up and enter the url:
		Page window2=page.waitForPopup(()->{
			//This commend to open new tab
			page.click("a[target='_blank']");
		});
		
		window2.waitForLoadState();
		window2.navigate("https://amazon.com/");
		System.out.println("Geting the window2 Title : "+ window2.title());
		window1.close();
		System.out.println("Getting the parent window Title : "+ page.title());
		
		Thread.sleep(3000);
		page.close();
		browser.close();
		playwright.close();

	}
}
