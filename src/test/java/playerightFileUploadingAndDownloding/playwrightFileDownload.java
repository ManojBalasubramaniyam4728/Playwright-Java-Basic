package playerightFileUploadingAndDownloding;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightFileDownload {
	public static void main(String[] args) throws InterruptedException {
		 Playwright playwright=Playwright.create();
		 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		 BrowserContext browsercontext=browser.newContext();
		 Page page=browsercontext.newPage();
		 page.navigate("https://demo.automationtesting.in/FileDownload.html");

		 /*see in playwright no need to right the custom method to 
		   wait until file download playwright will only take care.
		 */
		 
		 /*download a file and store the download in Download interface
		   This will wait till file is completely downloaded then 
		   only other action will be performed*/
		 Download download= page.waitForDownload(()->{
			page.click("xpath=//a[text()='Download' and (@type='button')]") ;
		 });
		 
		 //Get The Download file url
		 System.out.println(download.url());
		 
		 //cancel the The Downloading file 
		// download.cancel();
		 
		 //get the Download path
		 System.out.println(download.path().toString());
		 
		 //set the downloading path make sure you giving same .extensions of the file
		 download.saveAs(Paths.get("Manoj Downloding.pdf"));
		 
		 //Get the Actual file name of downloading
		 System.out.println(download.suggestedFilename());
		 
		 //Check any failure in the downloading
		 //if there no error it will return null
		 System.out.println(download.failure());
		 
		 
		 Thread.sleep(5000);
		 
		 page.close();
		 browser.close();
		 playwright.close();
		 
	}

}
