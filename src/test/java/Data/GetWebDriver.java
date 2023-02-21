package Data;

import org.openqa.selenium.WebDriver;

public class GetWebDriver {

	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driverr) {
		driver = driverr;
	}

	static WebDriver driver;
	
	
	
}
