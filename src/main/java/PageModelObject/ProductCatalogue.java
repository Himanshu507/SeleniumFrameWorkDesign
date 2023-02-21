package PageModelObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}


	
	
	@FindBy(xpath="//div[@class='card-body']")
	List<WebElement> products;
	
	@FindBy(xpath="//button[contains(@routerlink,'/dashboard/cart')]")
	WebElement cartButton;

	
	By toast_container = By.cssSelector("#toast-container");
	Duration sec = Duration.ofSeconds(4);
	
	By spinner = By.className("ngx-spinner-overlay");
	
	@FindBy(css="By.className(\'ngx-spinner-overlay\')")
	WebElement spinner_ele;
	
	public List<WebElement> getProductList() {
		waitForInvisibilityOfElement(toast_container,Duration.ofSeconds(3));
		return products;
	}
	
	
	public WebElement findProduct(String product_name) {
		
		WebElement product = products.stream().filter(s -> s.findElement(By.tagName("b")).getText().equals(product_name)).findFirst().orElse(null);
		return product;
			
	}
	
	
	public void addProductToCart(String product_name) {
	
		List<WebElement> add_to = findProduct(product_name).findElements(By.tagName("button"));
		WebElement ad = add_to.stream().filter(b -> b.getText().equals("Add To Cart")).findFirst().orElse(null);
		ad.click();
		elementClickable();
		//waitForInvisibilityOfElement(driver,spinner, sec);
		//waitForInvisibilityOfElement(driver,toast_container, sec);
		
	}
	
	
	public void goCart() {	
		//elementClickable(driver,cartButton,sec);
		cartButton.click();
	}
	
	
}
