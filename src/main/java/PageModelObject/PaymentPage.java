package PageModelObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponent;

public class PaymentPage extends AbstractComponent{

	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[text()='Credit Card']")
	WebElement cc_btn;
	
	@FindBy(xpath="//input[@value='4542 9931 9292 2293']")
	WebElement card_no;
	
	
	@FindBy(xpath="(//select[@class='input ddl'])[1]")
	WebElement exp;
	
	@FindBy(xpath="(//select[@class='input ddl'])[2]")
	WebElement exp_year;
	
	
	@FindBy(xpath="//div[contains(text(),'CVV')]/parent::div/input")
	WebElement cvv;
	
	
	@FindBy(xpath="//div[contains(text(),'Apply Coupon ')]/parent::div/input")
	WebElement applyCoupun;
	
	
	@FindBy(xpath="//div[contains(text(),'Name on ')]/parent::div/input")
	WebElement name;
	
	
	@FindBy(xpath="//button[contains(text(),'Apply Coupon')]")
	WebElement coupn_btn;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="//span[@class='ng-star-inserted']")
	List<WebElement> city;
	
	
	@FindBy(xpath="//div[@class='actions']/a")
	WebElement buy;
	
	
	By spinner = By.className("ngx-spinner-overlay");
	Duration sec = Duration.ofSeconds(5);

	
	
	
	public void selectCreditCard() {
		cc_btn.click();
	}
	
	
	public void setCreditDetials(String credit_no, String mon, String yr, String cv, String nam) {
		
		card_no.clear();
		card_no.sendKeys(credit_no);//
		Select month = new Select(exp);
		month.selectByVisibleText(mon);
		Select year = new Select(exp_year);
		year.selectByVisibleText(yr);
		cvv.sendKeys(cv);
		name.sendKeys(nam);
		
	}
	
	
	public void applyCoupun(String c_code ) {
	
		applyCoupun.sendKeys(c_code);//
		Actions action = new Actions(driver);
		action.moveToElement(coupn_btn).click().perform();		
		waitForInvisibilityOfElement(spinner, sec);
		//elementClickable();
	
	}
	
	public void origin(String coun, String match) {
		country.sendKeys(coun);//"India"
		city.stream().filter(s->s.getText().equalsIgnoreCase(match)).findFirst().orElse(null).click();//"India"
		
	}
	
	
	public void buy() {		
		buy.click();
	}

	
}
