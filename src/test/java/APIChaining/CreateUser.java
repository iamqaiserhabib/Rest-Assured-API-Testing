package APIChaining;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class CreateUser {
	
	int id;

	@Test
	public void createUserWithApiKey(ITestContext context) {
	    HashMap<String, String> data = new HashMap<>();
	    data.put("name", "qaiser");
	    data.put("job", "qa");

	    id = given()
	        .contentType("application/json")
	        .header("x-api-key", "reqres-free-v1")
	        .body(data)
	    .when()
	        .post("https://reqres.in/api/users")
	        .jsonPath().getInt("id");
	    System.out.println("Generated Id "+ id);
	    
//	    context.setAttribute("user_id", id);
	    context.getSuite().setAttribute("user_id", id);
	}
}
