package playerightFileUploadingAndDownloding;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class playwrightFileUploading {
	public static void main(String[] args) throws InterruptedException {
		 Playwright playwright=Playwright.create();
		 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		 BrowserContext browsercontext=browser.newContext();
		 Page page=browsercontext.newPage();
		 page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		 
		 /*see in playwright you need to upload file means you
		   have to have "input tag and type=file than only it will
		   work or else ask you developer to fix this
		  */
		 
		 //selecting one file
		 page.setInputFiles("//input[@type='file']", Paths.get("appLogin.json"));
		 
		 Thread.sleep(3000);
		 
		 //de-selecting the uploaded file
		 page.setInputFiles("//input[@type='file']", new Path[0]);
		 
		 Thread.sleep(3000);
		 
		 //selecting Multiple file
		 page.setInputFiles("//input[@type='file']", new Path[] {
				 Paths.get("appLogin.json"),
				 Paths.get("trace.zip")});
		 
		 Thread.sleep(3000);
		 
		 //selecting file by crating in run time
		 page.setInputFiles("//input[@type='file']",
				 new FilePayload("Data.text", "text/plane", "This is The Manoj"
						 .getBytes(StandardCharsets.UTF_8)));
		 
		 Thread.sleep(3000);
		 
		 page.close();
		 browser.close();
		 playwright.close();
	}

}
