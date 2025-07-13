package APIChaining;

import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	
	@Test
	public void deleteUser(ITestContext context) {
		
//		int id = (int) context.getAttribute("user_id");
		int id = (int) context.getSuite().getAttribute("user_id");
		
		given()
		       .header("x-api-key", "reqres-free-v1")
		       .pathParam("id", id)
		.when()
		       .delete("https://reqres.in/api/users/{id}")
		.then()
		       .statusCode(204)
		       .log().all();
	}
}
