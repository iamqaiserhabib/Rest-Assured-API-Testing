package RestAssuredAPI.RestAssuredAPI;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponseData {

//    @Test(priority = 1)
    public void testJSONResponse() {
        
        Response response = 
            given()
                .contentType(ContentType.JSON)
            .when()
                .get("http://localhost:3000/book")
            .then()
                .statusCode(200)
                .header("Content-Type", "application/json")
                .extract().response();
        String actualTitle = response.jsonPath().getString("[2].title");

        System.out.println("Extracted title: " + actualTitle);

        assertEquals(actualTitle, "The Lord of the Rings");
    }
    
//    @Test(priority = 1)
    public void testJSONResponse2() {
        
        Response response = 
            given()
                .contentType(ContentType.JSON)
            .when()
                .get("http://localhost:3000/book");
        
            Assert.assertEquals(response.getStatusCode(), 200);
            Assert.assertEquals(response.header("Content-Type"), "application/json");
            String bookName = response.jsonPath().get("[2].title").toString();
            
            Assert.assertEquals(bookName, "The Lord of the Rings");
    }
    
    @Test(priority = 1)
    public void testJSONResponse3() {

        Response response =
            given()
                .contentType("application/json")
            .when()
                .get("http://localhost:3000/book");

        // Convert response body to string and then to JSON Array
        JSONArray booksArray = new JSONArray(response.getBody().asString());

//        boolean status = false;
//        
//        for (int i = 0; i < booksArray.length(); i++) {
//            JSONObject bookObj = booksArray.getJSONObject(i);
//            String bookTitle = bookObj.getString("title");
//            
//            if(bookTitle.equals("The Lord of the Rings")) {
//            	status = true;
//            	break;
//            }
//        }
//        
//        Assert.assertEquals(status, true);
        
        double totalPrice = 0;
        
        for (int i = 0; i < booksArray.length(); i++) {
            JSONObject bookObj = booksArray.getJSONObject(i);
            double price = bookObj.getDouble("price");
            
            totalPrice = totalPrice+price;
        }
        
        System.out.println(totalPrice);
        Assert.assertEquals(totalPrice, 340.4);
    }
}
