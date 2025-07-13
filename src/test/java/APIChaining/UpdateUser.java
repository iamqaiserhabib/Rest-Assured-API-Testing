package APIChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class UpdateUser {
	
	@Test
	public void updateUser(ITestContext context) {
		
//		int id = (int) context.getAttribute("user_id");
		int id = (int) context.getSuite().getAttribute("user_id");
		
		HashMap<String, String> data = new HashMap<>();
	    data.put("name", "qaiser");
	    data.put("job", "teacher");

	    given()
	        .contentType("application/json")
	        .header("x-api-key", "reqres-free-v1")
	        .pathParam("id", id)
	        .body(data)
	    .when()
	        .put("https://reqres.in/api/users/{id}")
	    .then()
	        .statusCode(200)
	        .log().all();
	}
}
