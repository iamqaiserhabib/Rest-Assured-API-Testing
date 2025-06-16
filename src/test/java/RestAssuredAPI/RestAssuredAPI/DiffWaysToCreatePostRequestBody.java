package RestAssuredAPI.RestAssuredAPI;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DiffWaysToCreatePostRequestBody {

    String studentId;

//    @Test(priority = 1)
    public void postRequestWithHashMap() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("name", "John Doe");
        data.put("age", 18);
        data.put("grade", "12th");

        String[] subjectsArray = {"Math", "Physics", "English"};
        data.put("subjects", subjectsArray);

        studentId = 
            given()
                .contentType("application/json")
                .body(data)
            .when()
                .post("http://localhost:3000/students")
            .then()
                .statusCode(201)
                .body("name", equalTo("John Doe"))
                .body("age", equalTo(18))
                .body("grade", equalTo("12th"))
                .body("subjects[0]", equalTo("Math"))
                .body("subjects[1]", equalTo("Physics"))
                .body("subjects[2]", equalTo("English"))
                .header("Content-Type", containsString("application/json"))
                .log().all()
                .extract()
                .path("id");
    }
    
//    @Test(priority=1)
    public void postRequestWithJsonLibrary() {
        JSONObject data = new JSONObject();
        
        data.put("name", "John Doe");
        data.put("age", 18);
        data.put("grade", "12th");

        String[] subjectsArray = {"Math", "Physics", "English"};
        data.put("subjects", subjectsArray);

        studentId = 
            given()
                .contentType("application/json")
                .body(data.toString())
            .when()
                .post("http://localhost:3000/students")
            .then()
                .statusCode(201)
                .body("name", equalTo("John Doe"))
                .body("age", equalTo(18))
                .body("grade", equalTo("12th"))
                .body("subjects[0]", equalTo("Math"))
                .body("subjects[1]", equalTo("Physics"))
                .body("subjects[2]", equalTo("English"))
                .header("Content-Type", containsString("application/json"))
                .log().all()
                .extract()
                .path("id");
    }
    
//    @Test(priority=1)
    public void postRequestWithPOJO() {
    	Pojo_PostRequest data = new Pojo_PostRequest();
    	
    	data.setName("John Doe");
    	data.setAge(18);
    	data.setGrade("12th");
    	
    	String[] subjectsArray = {"Math", "Physics", "English"};
    	data.setSubjects(subjectsArray);

        studentId = 
            given()
                .contentType("application/json")
                .body(data)
            .when()
                .post("http://localhost:3000/students")
            .then()
                .statusCode(201)
                .body("name", equalTo("John Doe"))
                .body("age", equalTo(18))
                .body("grade", equalTo("12th"))
                .body("subjects[0]", equalTo("Math"))
                .body("subjects[1]", equalTo("Physics"))
                .body("subjects[2]", equalTo("English"))
                .header("Content-Type", containsString("application/json"))
                .log().all()
                .extract()
                .path("id");
    }
    
    @Test(priority=1)
    public void postRequestUsingExternalJsonFile() throws FileNotFoundException {
    	File f = new File(".\\body.json");
    	
    	FileReader fr = new FileReader(f);
    	JSONTokener jt = new JSONTokener(fr);
    	JSONObject data = new JSONObject(jt);

        studentId = 
            given()
                .contentType("application/json")
                .body(data.toString())
            .when()
                .post("http://localhost:3000/students")
            .then()
                .statusCode(201)
                .body("name", equalTo("John Doe"))
                .body("age", equalTo(18))
                .body("grade", equalTo("12th"))
                .body("subjects[0]", equalTo("Math"))
                .body("subjects[1]", equalTo("Physics"))
                .body("subjects[2]", equalTo("English"))
                .header("Content-Type", containsString("application/json"))
                .log().all()
                .extract()
                .path("id");
    }

    @Test(priority = 2, dependsOnMethods = {"postRequestUsingExternalJsonFile"})
    public void deleteStudent() {
        given()
        .when()
            .delete("http://localhost:3000/students/" + studentId)
        .then()
            .statusCode(200)
            .log().all();
    }

}
