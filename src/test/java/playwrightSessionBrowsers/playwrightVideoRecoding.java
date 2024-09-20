package playwrightSessionBrowsers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightVideoRecoding {
	public static void main(String[] args) throws InterruptedException {
		//By Using Dimension in java and toolkit getting height and width of the screen
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		int width=(int)screenSize.getWidth();
		int height=(int)screenSize.getHeight();
		System.out.println(width+" : "+height);
		
		 Playwright playwright=Playwright.create();
		 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		 
		 //By video recoding using browser context.
		 BrowserContext browsercontext=browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myVideoRecoding/")).setViewportSize(width,height));
		 Page page=browsercontext.newPage();
		 page.navigate("https://www.fireflink.com/signin");
		 
		 //Login Action
		 Locator userNameTextfield=page.locator("input#emailId");
		 userNameTextfield.hover();
		 userNameTextfield.click();
		 userNameTextfield.fill("manoj.b@fireflink.com");
		 Locator passwordTextfield=page.locator("//input[@name='password']");
		 passwordTextfield.hover();
		 passwordTextfield.click();
		 passwordTextfield.fill("Password@123");
		 Locator submitButton=page.locator("button:has-text('Sign in')");
		 submitButton.hover();
		 submitButton.click();
		 
		 Thread.sleep(5000);
		 
		 page.close();
		 //make sure your closing the browser context then only video will close
		 browsercontext.close();
		 browser.close();
		 playwright.close();
	}

}
