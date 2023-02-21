package rahulshettyacademy.test;

import org.openqa.selenium.WebDriver;

import PageModelObject.CartPage;
import PageModelObject.ConfirmationPage;
import PageModelObject.LandingPage;
import PageModelObject.PaymentPage;
import PageModelObject.ProductCatalogue;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WebDriverManager.chromedriver().setup();
	
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String userid = "himanshu@rahulshettyacademy.com";
		String pass = "Abc123!@#";
		//login(driver,userid,pass);
		
		String product_name1 = "ZARA COAT 3";
		//findProduct(driver,product_name1);
		//cartCheck(driver, product_name1);
		//Purchase_Details(driver);
		//Confirmation(driver);

	}
	

	private static void Confirmation(WebDriver driver) {
		ConfirmationPage p = new ConfirmationPage(driver);
		p.download_csv();
		
	}


		private static void Purchase_Details(WebDriver driver) {
		PaymentPage pd = new PaymentPage(driver);
		pd.selectCreditCard();
		pd.setCreditDetials("1234 5678 9012", "08", "26", "123", "Himanshu");
		pd.applyCoupun("rahulshettyacademy");
		pd.origin("India", "India");
		pd.buy();
	}


	private static void cartCheck(WebDriver driver, String product_name) {
		CartPage cp = new CartPage(driver);
		cp.cartCheck(product_name);
		cp.cartCheckout();
	}

	
	private static void findProduct(WebDriver driver, String product_name) {
		ProductCatalogue pc = new ProductCatalogue(driver);
		pc.getProductList();
		pc.findProduct(product_name);
		pc.addProductToCart(product_name);
		pc.goCart();
	}
	

	
	public static void login(WebDriver driver ,String userid, String pass) {
		LandingPage lp = new LandingPage(driver);
		lp.goTo();
		lp.login(userid, pass);
	}
	
}
