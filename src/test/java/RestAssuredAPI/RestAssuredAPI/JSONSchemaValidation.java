package RestAssuredAPI.RestAssuredAPI;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.module.jsv.JsonSchemaValidator;


public class JSONSchemaValidation {

	@Test
	public void jsonSchemaValidation() {
		given()
        .contentType("application/json")
        .body("{\"name\": \"Qaiser\", \"job\": \"QA Engineer\"}")
        .header("x-api-key", "reqres-free-v1")
	    .when()
	        .post("https://reqres.in/api/users")
	    .then()
	        .assertThat()
	        .statusCode(201)  // Make sure response is valid
	        .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("usersjsonschema.json"));
	}
}
