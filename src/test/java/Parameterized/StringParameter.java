package Parameterized;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class StringParameter {
	@Test
	public void StringParametr()
	{
		baseURI="https://reqres.in";
		
		//precondition
		given()
		.queryParam("page",3)
		
		//action
		.when()
		.get("/api/users")
		
		//validation
		.then().log().all();
	}

}
