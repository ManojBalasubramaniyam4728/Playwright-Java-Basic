package playwrightFrameHandling;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightFrames {
	public static void main(String[] args) {
		Playwright pw=Playwright.create();
		Browser br=pw.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		Page pg=br.newPage();
	
		//navigate to frame url  
		pg.navigate("https://londonfreelance.org/courses/frames/index.html");
		
		//In playwright for handling frame there are many method so i will use frameLocator method
	   String h2text= pg.frameLocator("//frame[@name='main']").locator("h2:has-text('Title bar ')").textContent();
		System.out.println(h2text);
		
		br.close();
		pw.close();
	}

}
