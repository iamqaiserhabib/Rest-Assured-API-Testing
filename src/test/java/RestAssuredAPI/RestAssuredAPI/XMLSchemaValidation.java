package RestAssuredAPI.RestAssuredAPI;

import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {

	@Test
	public void xmlSchemaValidation() {
		given()
		
		.when()
		      .get("https://httpbin.org/xml")
		.then()
		      .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("slides.xsd"));
	}
}
