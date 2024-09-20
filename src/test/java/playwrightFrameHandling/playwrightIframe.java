package playwrightFrameHandling;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightIframe {
	public static void main(String[] args) throws InterruptedException {
         
		Playwright pw=Playwright.create();
		Browser br=pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page pg=br.newPage();
	
		//navigate to frame url  
		pg.navigate("https://demoqa.com/frames");
		
		//In playwright for handling Iframe there are many method so i will use frameLocator method
	    String h1text= pg.frameLocator("//iframe[@id='frame1']").locator("body h1:has-text('This is a sample page')").textContent();
		System.out.println(h1text);
		
		//sample where without switching to main frame it is working;
		pg.locator("//div[text()='Elements']").click();
		Thread.sleep(5000);
		
		br.close();
     	pw.close();
	}
}
