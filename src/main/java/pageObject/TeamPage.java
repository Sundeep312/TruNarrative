package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TeamPage {
	
public WebDriver driver;
	
	public TeamPage(WebDriver driver) 
	{
		
		this.driver= driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	
	@FindBy(xpath="//h1[contains(text(),'TruNarrative Team')]")
	WebElement teamText;
	
	@FindBy(css=".stack-img-content")
	WebElement teamCount;
	
	
	@FindBy(xpath="//h2[contains(text(),'John Lord')]")
	WebElement teamPlayer1;
	
	@FindBy(xpath="//p[contains(text(),'Founder & CEO')]")
	WebElement teamRole1;
	
	@FindBy(xpath="//h2[contains(text(),'David Eastaugh')]")
	WebElement teamPlayer2;
	
	@FindBy(xpath="//p[contains(text(),'Chief Technology Officer')]")
	WebElement teamRole2;
	
	@FindBy(xpath="//h2[contains(text(),'Nicola Janney')]")
	WebElement teamPlayer3;
	
	@FindBy(xpath="//p[contains(text(),'Human Resources Manager')]")
	WebElement teamRole3;
	
	
	
	public WebElement teamText() {
		
		return teamText;
	}
	
public WebElement teamCount() {
		
		return teamCount;
	}
	
	
public WebElement teamPlayer1() {
		
		return teamPlayer1;
	}

public WebElement teamRole1() {
	
	return teamRole1;
}

public WebElement teamPlayer2() {
	
	return teamPlayer2;
}

public WebElement teamRole2() {

return teamRole2;
}
	
public WebElement teamPlayer3() {
	
	return teamPlayer3;
}

public WebElement teamRole3() {

return teamRole3;
}

}
