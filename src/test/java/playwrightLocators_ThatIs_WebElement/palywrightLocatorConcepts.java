package playwrightLocators_ThatIs_WebElement;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class palywrightLocatorConcepts {
	public static void main(String[] args) {
		 Playwright playwright=Playwright.create();
		 Browser browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
		 BrowserContext browsercontext=browser.newContext();
		 Page page=browsercontext.newPage();
		 page.navigate("https://www.orangehrm.com/");
		 
		 //single element
		Locator contactSales=page.locator("(//a/button[text()='Contact Sales'])[2]");
		contactSales.hover();
		contactSales.click();
		
		//going back to the previous page
		page.goBack();
		
		//Multiple elements(Web elements)
	    Locator submiteButton=page.locator("#Form_submitForm");
	    int count=submiteButton.count();
	    System.out.println(count);
	    /*
	       Only first and last locator method is available in 
	       playwright if it is web elements i.e locators.
	    */
	    submiteButton.first().click();
	    submiteButton.last().click();
	    
	    //Multiple elements(Web elements) to get one by one
	    
	    //Going to 	contact Sales page
		contactSales.click();
		
	    Locator countryOptions=page.locator("select#Form_getForm_Country option");
	    System.out.println(countryOptions.count());
	    
	    //one way of getting all the country name
	    for (int i = 0; i <countryOptions.count(); i++) {
	    	String countrynames=countryOptions.nth(i).textContent();
	    	System.out.println(countrynames);
		}
	    
	    System.out.println("********************************************************************************");
	    
	    //second way of getting all the country
	    List<String>  countryList= countryOptions.allTextContents();
	    for(String s:countryList) {
		   System.out.println(s);
	    }
	    
	    System.out.println("*********************************************************************************");
	    
	    //third way of getting all the country
	    countryList.forEach(list->System.out.println(list));
	    
	    System.out.println("*********************************************************************************");
	    
	    browser.close();
	    playwright.close();
	    
	}

}
