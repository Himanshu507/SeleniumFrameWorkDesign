package rahulshettyacademy.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest {

	@Test(dataProvider = "getData", groups = { "purchase" })
	public void submitOrder(HashMap<String, String> values) throws IOException {

		String userid = values.get("email");
		String pass = values.get("pass");
		String product_name = values.get("product");
		lp.login(userid, pass);

		// String product_name = "ZARA COAT 3";
		productcatalogue.getProductList();
		productcatalogue.findProduct(product_name);
		productcatalogue.addProductToCart(product_name);
		productcatalogue.goCart();

		Boolean find = cartpage.cartCheck(product_name);
		Assert.assertTrue(find);
		cartpage.cartCheckout();

		paymentpage.selectCreditCard();
		paymentpage.setCreditDetials("1234 5678 9012", "08", "26", "123", "Himanshu");
		paymentpage.applyCoupun("rahulshettyacademy");
		paymentpage.origin("India", "India");
		paymentpage.buy();

		conf_page.download_csv();
		getScreenshot("Confirm", driver);

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		String path = "//src/test//java/Data//PurchaseOrder.json";

		List<HashMap<String, String>> data = getJsonDataToMap(path);

		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
