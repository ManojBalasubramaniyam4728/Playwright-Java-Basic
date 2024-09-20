package playwrightSelector;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class playwrightRelativeLocators{
	static Page page;

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			BrowserContext context = browser.newContext();
			page = context.newPage();
			page.navigate("https://selectorshub.com/xpath-practice-page/");

			// Left of
			page.locator("input[type='checkbox']:left-of(:text('Joe.Root'))").first().click();

			// Using custom method to select the user
			selectUser("Jasmine.Morgan");
			selectUser("John.Smith");

			// right of
			String roleOfUser = page.locator("td:right-of(:text('Joe.Root'))").first().innerText();
			System.out.println(roleOfUser);

			// Using custom method to get all the user role
			System.out.println(getTheUserRole("Jasmine.Morgan"));
			System.out.println(getTheUserRole("John.Smith"));

			// above
			String aboveUserName = page.locator("a:above(:text('Joe.Root'))").first().innerText();
			System.out.println(aboveUserName);

			// custom method to get the above user name
			System.out.println(getTheAboveUserName("Jasmine.Morgan"));
			System.out.println(getTheAboveUserName("John.Smith"));

			// below
			String belowUserName = page.locator("a:below(:text('Joe.Root'))").first().innerText();
			System.out.println(belowUserName);

			// custom method to get the above user name
			System.out.println(getTheBelowUserName("Jasmine.Morgan"));
			System.out.println(getTheBelowUserName("John.Smith"));

			// near
			String nearUserName = page.locator("a:near(:text('Joe.Root'))").first().innerText();
			System.out.println(nearUserName);

			// custom method to get the near user name
			System.out.println(getTheNeareUserName("Joe.Root"));
			System.out.println(getTheNeareUserName("John.Smith"));

			// near pixel
			List<String> nearPixelUserNames = page.locator("a:near(:text('Joe.Root'),200)").allInnerTexts();
			for (String neareUserNamesOneByOne : nearPixelUserNames) {
				System.out.println(neareUserNamesOneByOne);
			}

			// custom method to get the near user name by pixel
			for (String neareUserNamesOneByOne : getTheNearePixelUserName("Joe.Root", 400)) {
				System.out.println(neareUserNamesOneByOne);
			}
			for (String neareUserNamesOneByOne : getTheNearePixelUserName("John.Smith", 400)) {
				System.out.println(neareUserNamesOneByOne);
			}


			browser.close();
			playwright.close();

		}
	}

	// Custom method to select the user
	public static void selectUser(String userName) {
		page.locator("input[type='checkbox']:left-of(:text('" + userName + "'))").first().click();
	}

	// Custom method to get the user role
	public static String getTheUserRole(String userName) {
		String userRoles = page.locator("td:right-of(:text('" + userName + "'))").first().innerText();
		return userRoles;
	}

	// Custom method to get the above user name
	public static String getTheAboveUserName(String userName) {
		String aboveUserName = page.locator("a:above(:text('" + userName + "'))").first().innerText();
		return aboveUserName;
	}

	// Custom method to get the above user name
	public static String getTheBelowUserName(String userName) {
		String belowUserName = page.locator("a:below(:text('" + userName + "'))").first().innerText();
		return belowUserName;
	}

	// Custom method to get the near user name
	public static String getTheNeareUserName(String userName) {
		String neareUserName = page.locator("a:near(:text('" + userName + "'))").first().innerText();
		return neareUserName;
	}

	// Custom method to get the near user name by pixel
	public static List<String> getTheNearePixelUserName(String userName, int pixelNumber) {
		List<String> neareUserName = page.locator("a:near(:text('" + userName + "')," + pixelNumber + ")")
				.allInnerTexts();
		return neareUserName;
	}

}
