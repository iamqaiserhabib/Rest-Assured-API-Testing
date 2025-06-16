package RestAssuredAPI.RestAssuredAPI;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingTest {
	
	@Test(priority=1)
	public void testLogs() {
		
		given()
		.when()
		       .get("https://reqres.in/api/users?page=2")
		.then()
//		       .log().headers();
//		       .log().body();
//		       .log().cookies();
		       .log().all();
	}

}
