package APIChaining;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	public void getUsers(ITestContext context) {
		
//		int id = (int) context.getAttribute("user_id")
		int id = 2;
		
		given()
		       .pathParam("id", id)
		.when()
		       .get("https://reqres.in/api/users/{id}")
		.then()
		       .statusCode(200)
		       .log().all();
	}
}
