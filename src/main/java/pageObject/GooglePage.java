package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

	public WebDriver driver;

	public GooglePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[class='gLFyf gsfi']")
	WebElement textField;

	@FindBy(css = ".iUh30")
	WebElement linksList;

	public WebElement textFiled() {

		return textField;

	}

	public WebElement linkList() {

		return linksList;

	}

}
