package RestAssuredAPI.RestAssuredAPI;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import java.io.FileOutputStream;
import java.io.IOException;

public class DownloadFile {

    @Test
    public void downloadFile() throws IOException {

        String fileURL = "https://reqres.in/api/users?page=2";

        Response res = given()
        	.header("x-api-key", "reqres-free-v1")
            .when()
            .get(fileURL)
            .then()
            .statusCode(200)
            .extract().response();

        byte[] fileContent = res.asByteArray();

        String destinationPath = "C:\\Users\\admin\\Downloads\\userList1.json";

        try (FileOutputStream out = new FileOutputStream(destinationPath)) {
            out.write(fileContent);
            System.out.println("File downloaded to: " + destinationPath);
        }
    }
}
