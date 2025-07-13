package RestAssuredAPI.RestAssuredAPI;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.response.Response;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UploadFile {
	
	@Test
	public void uploadImageFile() {
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

        Response res = given()
                .multiPart("file", new File("C:\\Users\\admin\\3D Objects\\istockphoto-1439820420-612x612.jpg"), "image/jpeg")
                .header("Content-Type", "multipart/form-data")
                .formParam("additionalMetadata", "test1")
        .when()
                .post("/pet/9223372036854775000/uploadImage")
        .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Response: " + res.asString());
    }
}
