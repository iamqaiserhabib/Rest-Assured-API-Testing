package RestAssuredAPI.RestAssuredAPI;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameters {

	@Test
	public void pathAndQueryParamteters() {
		
		given()
		       .pathParam("myPath", "users")
		       .queryParam("page", 2)
		       .queryParam("id", 5)
		       .header("x-api-key", "reqres-free-v1")
		.when()
		       .get("https://reqres.in/api/{myPath}")
		.then()
		       .statusCode(200)
		       .log().all();
	}
}
