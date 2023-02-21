package PageModelObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	
	
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//div[@class='cart']/ul")
	List<WebElement> cart_items;
	
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkout;
	
	

	public Boolean cartCheck(String product_name) {		
		
		Boolean find = cart_items.stream().anyMatch(
				s->s.findElement(By.xpath("//div[@class='cartSection']/h3"))
				.getText()
				.equalsIgnoreCase(product_name));
				
		return find;
		
	}
	
	
	public void cartCheckout() {
		checkout.click();
	}

	
	
	
	

}
