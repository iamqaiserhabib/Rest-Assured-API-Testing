package RestAssuredAPI.RestAssuredAPI;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParsingXMLResponse {

//	@Test(priority=1)
	public void testXMLResponse() {
		
		given()
		
		.when()
		       .get("https://httpbin.org/xml")
		.then()
		       .statusCode(200)
		       .header("Content-Type", "application/xml")
		       .body("slideshow.slide.title[0]", equalTo("Wake up to WonderWidgets!"));
	}
	
//	@Test(priority=1)
	public void testXMLResponse1() {
		
		Response res = given()
		
		.when()
		       .get("https://httpbin.org/xml");
		
		       Assert.assertEquals(res.getStatusCode(), 200);
		       Assert.assertEquals(res.header("Content-Type"), "application/xml");
		       String firstTitle = res.xmlPath().get("slideshow.slide.title[0]").toString();
		       Assert.assertEquals(firstTitle, "Wake up to WonderWidgets!");
		       
	}
	
	@Test(priority=1)
	public void testXMLResponse2() {
		
		Response res = given()
		
		.when()
		       .get("https://httpbin.org/xml");
		
		       XmlPath xmlobject = new XmlPath(res.asString());
		       List<String> titles = xmlobject.getList("slideshow.slide.title");
		       
		       Assert.assertEquals(titles.size(), 2);
		       
		       boolean status = false;
		       
		       for(String title: titles) {
		    	   if(title.equals("Wake up to WonderWidgets!")) {
		    		   status = true;
		    		   break;
		    	   }
		       }
		       
		       Assert.assertEquals(status, true);       
	}
}
