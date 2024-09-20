package playwrightAutoLogin;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightFirstAutoLoginSetup {
public static void main(String[] args) {
	 Playwright playwright=Playwright.create();
	 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
	 
	 //For This Browser context should be created
	 BrowserContext browsercontext=browser.newContext();
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
    
    //storing above data in json by using below code
    browsercontext.storageState(new BrowserContext.StorageStateOptions().setPath(Paths.get("appLogin.json")));
    
    browsercontext.close();
    browser.close();
    playwright.close();
	 
}
}
