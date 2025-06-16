package RestAssuredAPI.RestAssuredAPI;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
	
	Response res;
	String cookie_value;
	
	@Test(priority=2, dependsOnMethods = {"getCookiesInfo"})
	public void testCookies() {
		
		given()
		.when()
		       .get("https://www.google.com/")
		.then()
		       .cookie("AEC")
		       .log().all();
	}
	
	@Test(priority=1)
	public void getCookiesInfo() {
		
		res = given()
		.when()
		       .get("https://www.google.com/");
		       cookie_value = res.getCookie("AEC");
		       
		       //Get all cookies
//		       Map<String, String> cookie_values = res.getCookies();
//		       for(String k: cookie_values.keySet()) {
//		    	   String single_cookie_value = res.getCookie(k);
//		       }
	}

}
