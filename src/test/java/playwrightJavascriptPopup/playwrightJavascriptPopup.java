package playwrightJavascriptPopup;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightJavascriptPopup {
	public static void main(String[] args) {
		Playwright playwright=Playwright.create();
		 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		 BrowserContext browsercontext=browser.newContext();
		 Page page=browsercontext.newPage();
		 
		 //creating dialog handler to enter data into js pop up it explicitly if not it will enter null
		 page.onDialog(dialog->{
			String textMessage= dialog.message();
			System.out.println(textMessage);
     		dialog.accept("Hi This Manoj");
			//dialog.dismiss();
			//dialog.accept();
			
		 });
		 
		 //js alerts, prompt, Confirmation pop ups
		 page.navigate("https://the-internet.herokuapp.com/javascript_alerts");
		 
		 //js pop up Alert
		 page.click("//button[text()='Click for JS Alert']");
		 String result=page.textContent("#result");
		 System.out.println(result);
		 
		 //js pop up Confirm
		 page.click("//button[text()='Click for JS Confirm']");
		 result=page.textContent("#result");
		 System.out.println(result);
		 
		 //js pop up prompt
		 //See if i comment the dialog then here null will be placed or dialog text.
		 page.click("//button[text()='Click for JS Prompt']");
		 result=page.textContent("#result");
		 System.out.println(result);
		 
		 page.close();
		 browser.close();
		 playwright.close();
	}

}
