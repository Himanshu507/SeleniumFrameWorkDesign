package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver2) {
		this.driver = driver2;
	}

	
	public void waitForInvisibilityOfElement( By by, Duration d) {
	WebDriverWait wait= new WebDriverWait(driver,d);
	wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void invisibilityOfAnimation(WebElement element, Duration d) {
		WebDriverWait wait= new WebDriverWait(driver,d);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void waitForWebElementToAppear( WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void elementClickable() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//WebDriverWait wait= new WebDriverWait(driver,d);
		//wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
}
