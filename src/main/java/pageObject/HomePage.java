package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver) 
	{
		
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(css="h4[class='bigger']")
	WebElement homaPagetext;
	
	@FindBy(css=".iUh30")
	WebElement linksList;
	
	@FindBy(xpath="//a[contains(text(),'More')]")
	WebElement dropDown;
	
	@FindBy(xpath="//a[contains(text(),'TruNarrative Team')]")
	WebElement teamPage;
	
	
	
	
	public WebElement homaPagetext() {
		
		return homaPagetext;
	}
	
public WebElement linksList() {
		
		return linksList;
	}

public WebElement dropDown() {
	
	return dropDown;
}

public WebElement teamPage() {
	
	return teamPage;
}
	

}
