package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObject.GooglePage;
import pageObject.HomePage;
import pageObject.TeamPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@RunWith(Cucumber.class)
public class stepDefinition {

	WebDriver driver;

	@Before
	public void intialisebrowser() {

		System.setProperty("webdriver.chrome.driver", "/Users/sundeeppamulapati/Documents/Eclipse-Auto/chromedriver");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@Given("^user navigate to \"([^\"]*)\" site$")
	public void user_navigate_to_something_site(String url) throws Throwable {

		driver.get(url);

	}

	@When("^user enters \"([^\"]*)\" and click search$")
	public void user_enters_something_and_click_search(String name) throws Throwable {

		GooglePage gp = new GooglePage(driver);

		gp.textFiled().sendKeys(name);
		gp.textFiled().sendKeys(Keys.ENTER);

	}

	@Then("^user shall find \"([^\"]*)\" link on topsearch$")
	public void user_shall_find_something_link_on_topsearch(String link) throws Throwable {

		List<WebElement> linkList = driver.findElements(By.cssSelector(".iUh30"));

		String linkText = linkList.get(0).getText();
		String realLink = link.toString();

		Assert.assertTrue(linkText.equalsIgnoreCase(realLink));

		System.out.println("Given link appeared at first index of Link List");

		linkList.get(0).click();

		String url = driver.getCurrentUrl();

		System.out.println(url);

		if (url.contains(link)) {
			System.out.println("Navigated to correct website");
		}

	}

	@And("^Verify \"([^\"]*)\" is found on webpage$")
	public void verify_something_is_found_on_webpage(String requiredText) throws Throwable {

		HomePage hp = new HomePage(driver);
		String actualText = hp.homaPagetext().getText();

		Assert.assertFalse(actualText.contains(requiredText));
		System.out.println("Required textfound did not match text on webpage");

	}

	@Given("^user navigate to \"([^\"]*)\" site again$")
    public void user_navigate_to_something_site_again(String url) throws Throwable { 

		driver.get(url);
	}

	@When("^user click on  \"([^\"]*)\" link$")
    public void user_click_on_something_link(String requiredText) throws Throwable {

		Actions a = new Actions(driver);

		HomePage hp = new HomePage(driver);

		WebElement more = hp.dropDown();

		a.moveToElement(more).click().build().perform();

		WebElement trunarrativeTeam = hp.teamPage();

		trunarrativeTeam.click();

		TeamPage tp = new TeamPage(driver);

		String actualText = tp.teamText().getText();

		if (actualText.contentEquals(requiredText)) {

			System.out.println("Navigated to TruNarrative team page");
		} else

			System.out.println("Failed to Navigated to TruNarrative team page");
	}

	@Then("^User shall find \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_shall_find_and_and_and_and_and(String name1, String role1, String name2, String role2, String name3, String role3) throws Throwable {

		TeamPage tp = new TeamPage(driver);

		int teamcount = driver.findElements(By.cssSelector(".stack-img-content")).size();

		System.out.println("Team count described on webpage is : " + teamcount);

		String actualName1 = tp.teamPlayer1().getText();
		String actualRole1 = tp.teamRole1().getText();
		String actualName2 = tp.teamPlayer2().getText();
		String actualRole2 = tp.teamRole2().getText();
		String actualName3 = tp.teamPlayer3().getText();
		String actualRole3 = tp.teamRole3().getText();

		if (actualName1.equalsIgnoreCase(name1)) {

			System.out.println(actualName1 + " is matched with " + name1);
		}

		else

			System.out.println(actualName1 + " is not matched with " + name1);

		if (actualRole1.equalsIgnoreCase(role1)) {

			System.out.println(actualRole1 + "is matched with " + role1);

		}

		else

			System.out.println(actualRole1 + "is not macth with " + role1);

		if (actualName2.equalsIgnoreCase(name2)) {

			System.out.println(actualName2 + "is matched with " + name2);
		}

		else

			System.out.println(actualName2 + " is not matched with " + name2);

		if (actualRole2.equalsIgnoreCase(role2)) {

			System.out.println(actualRole2 + " is matched with " + role2);
		}

		else

			System.out.println(actualRole2 + " is not matched with " + role2);

		if (actualName3.equalsIgnoreCase(name3)) {

			System.out.println(actualName3 + " is matched with " + name3);
		}

		else

			System.out.println(actualName3 + " is not matched with " + name3);

		if (actualRole3.equalsIgnoreCase(role3)) {

			System.out.println(actualRole3 + " is matched with " + role3);
		}

		else

			System.out.println(actualRole3 + " is not matched with " + role3);

	}

	@After
	public void teardown() {
		driver.quit();
	}

}
