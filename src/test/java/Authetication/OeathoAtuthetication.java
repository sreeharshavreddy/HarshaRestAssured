package Authetication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;



public class OeathoAtuthetication {
	@Test
	public void oeathoAuthetication()
	{
	  //create a request to private acess token
		Response resp = given()
	   .formParam("client_id", "sreeharsha")
	   .formParam("client_secret", "cc52faf64ca111906b66e359670f5b20")
	   .formParam("grant_type", "client_credentials")
	   .formParam("redirect_uri", "http://sreeharsha.com")
	   .formParam("code", "authorization_code")
	   
	   .when()
	   .post("http://coop.apps.symfonycasts.com/token");
		System.out.println(resp);
		resp.then().log().all();
	   
	  /* //capture the acess token from the request response of theabove request
	   String  token = resp.jsonPath().get("access_token");
	   System.out.println(token);
	   // create anothre request and use the token to acess the api's
	   given()
	   .auth().oauth2(token)
	   .pathParam("USER_ID", 3125)
	   
	   .when()
	   .post("http://coop.apps.symfonycasts.com/api/USER_ID/chickens-feed")
	   
	   .then().log().all();*/
	}
}
