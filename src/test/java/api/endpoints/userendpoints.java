package api.endpoints;
import api.payload.user;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class userendpoints {

	public static Response createUser(user payload){
		System.out.println("Create Data");
		Response response = given()
		.accept(ContentType.JSON).contentType(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		
		return response;
	}
	public static Response GetUser(String userName){
		System.out.println("Get Data jenkins testing");
		Response response = given()
		.accept(ContentType.JSON)		
		.pathParam("username", userName)
		.when()
		.get(Routes.get_url);
		
		return response;
	}
	public static Response PutUser(String userName, user payload){
		System.out.println("Update Data testing jenkins");
		Response response = given()
		.accept(ContentType.JSON).contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(payload)
		
		.when()
		.put(Routes.put_url);
		
		return response;
	}
	public static Response deleteUser(String userName){
		System.out.println("Delete Data");
		Response response = given()
		.accept(ContentType.JSON)
		.pathParam("username", userName)
		
		
		.when()
		.delete(Routes.delete_url);
		
		return response;
	}
}
