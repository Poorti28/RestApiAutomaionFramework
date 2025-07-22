package api.testcases;

import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userendpoints;
import api.payload.user;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestDD {
	user UserPayload;
    public static Logger Logger;
	@Test(priority=1,dataProvider = "AllData",dataProviderClass = DataProviders.class)
	public void testcreateuser(String userId, String UserName, String Fname, String Lname, String email, String Password, String Phone)
	{Logger.info("create test cases");
		UserPayload = new user();
		UserPayload.setId(Integer.parseInt(userId));
		UserPayload.setUsername(UserName);
		UserPayload.setFirstName(Fname);
		UserPayload.setLastName(Lname);
		UserPayload.setEmail(email);
		UserPayload.setPassword(Password);
		UserPayload.setPhone(Phone);
		Response response = userendpoints.createUser(UserPayload);
		// log response
		response.then().log().all();
		// validation
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test(priority=2,dataProvider = "usernamedata",dataProviderClass = DataProviders.class)
	public void testgetUserData(String username)
	{
		Response response = userendpoints.GetUser(username);
		// log response
		response.then().log().all();
		// validation
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority=3,dataProvider = "usernamedata",dataProviderClass = DataProviders.class)
	public void testdeleteUserData(String username)
	{
		Response response = userendpoints.deleteUser(username);
		// log response
		response.then().log().all();
		// validation
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
	
	
	

}
