package stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

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

@RunWith(Cucumber.class)
public class stepDefinition{
	
	WebDriver driver;

    @Given("^intialise driver with chrome browser$")
    public void intialise_driver_with_chrome_browser() throws Throwable {
        
System.setProperty("webdriver.chrome.driver", "/Users/sundeeppamulapati/Documents/Eclipse-Auto/chromedriver");
driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.manage().window().maximize();

    }
    
    @And("^navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String url) throws Throwable {
    	driver.get(url);
    }

    @When("^user enters \"([^\"]*)\" and click search$")
    public void user_enters_something_and_click_search(String name) throws Throwable {
       WebElement text=driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
       text.sendKeys(name);
       text.sendKeys(Keys.ENTER);
    }

    @Then("^Verify first search shall be \"([^\"]*)\" and click on first link displayed verify the step1 link navigate to TrunNarrative website$")
    public void verify_first_search_shall_be_something_and_click_on_first_link_displayed_verify_the_step1_link_navigate_to_trunnarrative_website(String link) throws Throwable {
        
    	List<WebElement> linkList=driver.findElements(By.cssSelector(".iUh30"));
        
       
      String linkText=  linkList.get(0).getText();
      String reallink=link.toString();
      
   Assert.assertTrue(linkText.equalsIgnoreCase(reallink));
   
   System.out.println("Given link appeared at first index of Link List");
   
   linkList.get(0).click();
  
   String url=driver.getCurrentUrl();
   
   System.out.println(url);
   
   if(url.contains(link))
   {
	   System.out.println("Navigated to correct website");
   }	   
    	   
    }
    
    @And("^Verify \"([^\"]*)\" is found on webpage$")
    public void verify_something_is_found_on_webpage(String requiredtext) throws Throwable {
        
    	
       String actualtext=driver.findElement(By.xpath("//h4[@class='bigger']")).getText();
       
       System.out.println(actualtext);
       
       Assert.assertFalse(actualtext.contains(requiredtext));
       System.out.println("Required textfound did not match text on webpage");
       
       
   
    }
    
    
    @And("^close all open browsers$")
    public void close_all_open_browsers() throws Throwable {
        
    	driver.quit();
    }

    
    @Given("^intialise driver with chrome browser again$")
    public void intialise_driver_with_chrome_browser_again() throws Throwable {
        
    	System.setProperty("webdriver.chrome.driver", "/Users/sundeeppamulapati/Documents/Eclipse-Auto/chromedriver");
    	driver=new ChromeDriver();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    }
    
    @And("^navigate to \"([^\"]*)\" site again$")
    public void navigate_to_something_site_again(String url) throws Throwable {
    	driver.get(url);
    }
    
    @When("^user do mouseover on more and user shall able to navigate to Trunarrative team page and match with \"([^\"]*)\"$")
    public void user_do_mouseover_on_more_and_user_shall_able_to_navigate_to_trunarrative_team_page_and_match_with_something(String Requiredtext) throws Throwable {
    	Actions a=new Actions(driver);
    	WebElement more=driver.findElement(By.xpath("//a[contains(text(),'More')]"));
    	
    	a.moveToElement(more).click().build().perform();
    	WebElement TrunarrativeTeam=driver.findElement(By.xpath("//a[contains(text(),'TruNarrative Team')]"));
    	
    	TrunarrativeTeam.click();
    	
    	String Actualtext=driver.findElement(By.xpath("//h1[contains(text(),'TruNarrative Team')]")).getText();
    	
    	if (Actualtext.contentEquals(Requiredtext)){
    		
    		System.out.println("Navigated to TruNarrative team page");
    	}
    	else
    		
    		System.out.println("Failed to Navigated to TruNarrative team page"); 
    }

    @Then("^following \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" shall displayed on webpage$")
    public void following_and_and_and_and_and_shall_displayed_on_webpage(String name1, String role1, String name2, String role2, String name3, String role3) throws Throwable {
    	
    	
    	int teamcount=driver.findElements(By.cssSelector(".stack-img-content")).size();
    
    	
    	System.out.println("Team count described on webpage is : " + teamcount);
    	
    	/*for(int i=0; i<=teamcount; i++) {
    		
    		String text=driver.findElements(By.cssSelector(".stack-img-content")).get(i).getText();
    		
    		if (text.contains(name1)) {
    			
    			System.out.println(name1 + "is correctly displayed on webpage");
    			
    		}
    		
    		else 
    		
    	}*/
    	
   
    	String actualname1=driver.findElement(By.xpath("//h2[contains(text(),'John Lord')]")).getText();
    	String actualrole1=driver.findElement(By.xpath("//p[contains(text(),'Founder & CEO')]")).getText();
    	String actualname2=driver.findElement(By.xpath("//h2[contains(text(),'David Eastaugh')]")).getText();
    	String actualrole2=driver.findElement(By.xpath("//p[contains(text(),'Chief Technology Officer')]")).getText();
    	String actualname3=driver.findElement(By.xpath("//h2[contains(text(),'Nicola Janney')]")).getText();
    	String actualrole3=driver.findElement(By.xpath("//p[contains(text(),'Human Resources Manager')]")).getText();
    	
    	
    	
    	if(actualname1.equalsIgnoreCase(name1)) {
    		
    		System.out.println(actualname1 + " is matched with " + name1);
    	}
    	
    	else
    		
    		System.out.println(actualname1 + " is not matched with " + name1);
    		
    	
    	 if(actualrole1.equalsIgnoreCase(role1)) {
    		
    		System.out.println(actualrole1 + "is matched with " + role1);
    		
    	}
    	 
    	 else
     		
     		System.out.println(actualrole1 + "is not macth with " + role1);
    	 
    	
    if(actualname2.equalsIgnoreCase(name2)) {
    		
    		System.out.println(actualname2 + "is matched with " + name2);
    	}
    
    
    else
		
		System.out.println(actualname2 + " is not matched with " + name2);
		
    	
      if(actualrole2.equalsIgnoreCase(role2)) {
    		
    		System.out.println(actualrole2 + " is matched with " + role2);
    	}
      
      else
   		
   		System.out.println(actualrole2 + " is not matched with " + role2);
  	 
      
      
     if(actualname3.equalsIgnoreCase(name3)) {
    		
    		System.out.println(actualname3 + " is matched with " + name3);
    	}
    	
     else
 		
 		System.out.println(actualname3 + " is not matched with " + name3);
     
     
    if(actualrole3.equalsIgnoreCase(role3)) {
  		
  		System.out.println(actualrole3 + " is matched with " + role3);
  	}
    
   else
   		
   		System.out.println(actualrole3 + " is not matched with " + role3);
  	 
      
    	
    	
    	/*Assert.assertTrue(actualname1.equalsIgnoreCase(name1));
    	Assert.assertFalse(actualrole1.equalsIgnoreCase(role1));
    	System.out.println(actualname1 + "and his role" + actualrole1 + "is displayed on webpage");
    	Assert.assertTrue(actualname2.equalsIgnoreCase(name2));
    	Assert.assertFalse(actualrole2.equalsIgnoreCase(role2));
    	System.out.println(actualname2 + "and his role" + actualrole2 + "is displayed on webpage");
    	Assert.assertTrue(actualname3.equalsIgnoreCase(name3));
    	Assert.assertTrue(actualrole3.equalsIgnoreCase(role3));
    	System.out.println(actualname3 + "and his role" + actualrole3 + "is displayed on webpage");*/
    	
  
   


}
    
   
@And("^close agian all browsers$")
public void close_agian_all_browsers() throws Throwable {
    
	driver.quit();
    
}

}

    

