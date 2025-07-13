package RestAssuredAPI.RestAssuredAPI;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerator {

	@Test
	public void generateDummyData() {
		Faker faker = new Faker();
		String fullName = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String userName = faker.name().username();
		String password = faker.internet().password();
		String phoneNumber = faker.phoneNumber().cellPhone();
		String email = faker.internet().emailAddress();
		
		System.out.println("Full Name: "+ fullName);
		System.out.println("First Name: "+ firstName);
		System.out.println("Last Name: "+ lastName);
		System.out.println("User Name: "+ userName);
		System.out.println("Password: "+ password);
		System.out.println("Phone Number: "+ phoneNumber);
		System.out.println("Email: "+ email);
	}
}
