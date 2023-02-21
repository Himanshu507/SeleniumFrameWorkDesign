package rahulshettyacademy.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest{

	@Test(retryAnalyzer=rahulshettyacademy.TestComponents.Retry.class)
	public void errorValidation() {
		
		String userid = "himanshu@rahulshettyacademy.com";
		String pass = "Abc123!7#";
		lp.login(userid,pass);
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());
		
	}
	
}
