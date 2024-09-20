package playwrightSelector;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightWebTable {
	static Page page;
	public static void main(String[] args) {
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		      BrowserContext context = browser.newContext();
		      page = context.newPage();
		      page.navigate("https://selectorshub.com/xpath-practice-page/");
		      
		      //table
		      //first row finding
		     Locator row=page.locator("table#resultTable td a");
		     //Using scope click on the disared check box
		      row.locator(":Scope",new Locator.LocatorOptions().setHasText("Jordan.Mathews")).locator("//input[@type='checkbox']").click();
		      
		      //using custom method to click on the check box in web table
		      clickOnTheWebTableCheckBoxUsingUserName(row, "Joe.Root");
		      
		      //get all the table data from web table and print in console
		      row.locator(":Scope").allInnerTexts().forEach(e->System.out.println(e));
		      
		      //using custom method to get all the content from the web table
		      getAllTheWebTableContent(row);
		      
		      browser.close();
		      playwright.close();
		 }
	}
	
	//custom method to click on the check box in web table
	public static void clickOnTheWebTableCheckBoxUsingUserName(Locator row, String userName) {
		row.locator(":Scope:", new Locator.LocatorOptions().setHasText(userName)).locator("xpath=//input[@type='checkbox']").click();
	}
	
	//custom method to get all the content from web table
	public static void getAllTheWebTableContent(Locator row) {
		row.locator(":scope").allInnerTexts().forEach(e->System.out.println(e));
	}

}
