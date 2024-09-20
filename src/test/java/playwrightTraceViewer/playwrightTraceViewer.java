package playwrightTraceViewer;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

public class playwrightTraceViewer {
	public static void main(String[] args) {
		Playwright playwright = null;
		Browser browser = null;
		BrowserContext browerContext=null;
		try {
			playwright=Playwright.create();
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			
			//setting the Trace viewer
			 browerContext=browser.newContext();
			browerContext.tracing().start(new Tracing.StartOptions().setSnapshots(true).setSources(true));
			
			Page page=browerContext.newPage();
			page.navigate("https://amazon.com");
			String titel=page.title();
			System.out.println("The Title of page is : "+titel);
			String url=page.url();
			System.out.println("The url of the page is : "+url);
		} 
		catch (Exception e) {
			browerContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
			browser.close();
			playwright.close();
			
			
		}
		finally {
			browerContext.tracing().stop(new Tracing.StopOptions().setPath(Paths.get("trace.zip")));
			browser.close();
			playwright.close();
		}
	}

}
