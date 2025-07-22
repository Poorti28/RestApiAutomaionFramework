package api.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payload.user;
import io.restassured.response.Response;

public class UserTest {
	Faker faker;
	user UserPayload;
	@BeforeClass
	public void generateTestData() {
		faker = new Faker();
		UserPayload = new user();
		UserPayload.setId(faker.idNumber().hashCode());
		UserPayload.setUsername(faker.name().username());
		UserPayload.setFirstName(faker.name().firstName());
		UserPayload.setLastName(faker.name().lastName());
		UserPayload.setEmail(faker.internet().safeEmailAddress());
		UserPayload.setPassword((faker.internet().password(5, 10)));
		UserPayload.setPhone(faker.phoneNumber().cellPhone());
	}
		@Test(priority=1)
		public void testcreateuser()
		{
			Response response = userendpoints.createUser(UserPayload);
			// log response
			response.then().log().all();
			// validation
			AssertJUnit.assertEquals(response.getStatusCode(), 200);
		}
		@Test(priority=2)
		public void testgetUserData()
		{
			Response response = userendpoints.GetUser(this.UserPayload.getUsername());
			// log response
			response.then().log().all();
			// validation
			AssertJUnit.assertEquals(response.getStatusCode(), 200);
		}
		@Test(priority=3)
		public void testputUserData()
		
		{
			UserPayload.setFirstName(faker.name().firstName());
			Response response = userendpoints.PutUser(this.UserPayload.getUsername(),UserPayload);
			// log response
			response.then().log().all();
			// validation
			AssertJUnit.assertEquals(response.getStatusCode(), 200);
			System.out.println("After update post");
			Response responsetest = userendpoints.GetUser(this.UserPayload.getUsername());
			// log response
			responsetest.then().log().all();
			// validation
			AssertJUnit.assertEquals(responsetest.getStatusCode(), 200);
		}
		@Test(priority=4)
		public void testdeleteUserData()
		{
			Response response = userendpoints.deleteUser(this.UserPayload.getUsername());
			// log response
			response.then().log().all();
			// validation
			AssertJUnit.assertEquals(response.getStatusCode(), 200);
		}
		
		
		
		
		
	

}
