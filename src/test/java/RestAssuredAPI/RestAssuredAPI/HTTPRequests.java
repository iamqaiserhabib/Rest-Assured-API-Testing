package RestAssuredAPI.RestAssuredAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {
	
	int id;
	
//	@Test(priority=1)
	public void getUsers() {
		given()
		.when()
		       .get("https://reqres.in/api/users?page=2")
		.then()
		       .statusCode(200)
		       .body("page",equalTo(2))
		       .log().all();
	}
	
	@Test(priority=2)
	public void createUserWithApiKey() {
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
//	    .then()
//	        .statusCode(201)
//	        .log().all();
	}
	
	@Test(priority=3, dependsOnMethods= {"createUserWithApiKey"})
	public void updateUser() {
		HashMap<String, String> data = new HashMap<>();
	    data.put("name", "qaiser");
	    data.put("job", "teacher");

	    given()
	        .contentType("application/json")
	        .header("x-api-key", "reqres-free-v1")
	        .body(data)
	    .when()
	        .put("https://reqres.in/api/users/"+id)
	    .then()
	        .statusCode(200)
	        .log().all();
	}
	
	@Test(priority=4)
	public void deleteUser() {
		given()
		       .header("x-api-key", "reqres-free-v1")
		.when()
		       .delete("https://reqres.in/api/users/"+id)
		.then()
		       .statusCode(204)
		       .log().all();
	}

}
