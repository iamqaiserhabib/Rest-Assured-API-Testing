package RestAssuredAPI.RestAssuredAPI;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserialization {

//	@Test
	public void convertPojo2Json() throws JsonProcessingException {
		Pojo_PostRequest data = new Pojo_PostRequest();
		    	
	    	data.setName("John Doe");
			data.setAge(18);
			data.setGrade("12th");
			
			String[] subjectsArray = {"Math", "Physics", "English"};
			data.setSubjects(subjectsArray);
			
			ObjectMapper objMapper = new ObjectMapper();
			String jsonData = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
			System.out.println(jsonData);
	}
	
	@Test
	public void convertJson2Pojo() throws JsonProcessingException {
		String jsonData = "{\r\n"
				+ "  \"name\" : \"John Doe\",\r\n"
				+ "  \"age\" : 18,\r\n"
				+ "  \"grade\" : \"12th\",\r\n"
				+ "  \"subjects\" : [ \"Math\", \"Physics\", \"English\" ]\r\n"
				+ "}";
		ObjectMapper objMapper = new ObjectMapper();
		Pojo_PostRequest stuPojo = objMapper.readValue(jsonData, Pojo_PostRequest.class);
		
		System.out.println("Name: " + stuPojo.getName());
	    System.out.println("Age: " + stuPojo.getAge());
	    System.out.println("Grade: " + stuPojo.getGrade());
	    
	    for (String subject : stuPojo.getSubjects()) {
	        System.out.println("Subject: " + subject);
	    }
	}
}
