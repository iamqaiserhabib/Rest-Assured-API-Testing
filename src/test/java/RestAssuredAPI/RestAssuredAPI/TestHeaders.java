package RestAssuredAPI.RestAssuredAPI;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class TestHeaders {
	
	Response res;
	String header_value;
	
	@Test(priority=1)
	public void testHeaders() {
		
		given()
		.when()
		       .get("https://www.google.com/")
		.then()
		       .header("Content-Type", "text/html; charset=ISO-8859-1")
		       .and()
		       .header("Content-Encoding", "gzip");
	}
	
	@Test(priority=2)
	public void getHeadersInfo() {
		
		res = given()
		.when()
		       .get("https://www.google.com/");
		       header_value = res.getHeader("Content-Type");
		       
		       //Get all headers
		       Headers allHeaders = res.getHeaders();
		       for(Header hd: allHeaders) {
		    	   System.out.println(hd.getName() + ": " + hd.getValue());
		       }
	}

}
