package Parameterized;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingFromParamter {
	@Test
	public void FromParameter()
	{
		//prerequsits
		baseURI="http://localhost";
		port=8084;
		given()
		.formParam("createdBy", "Harsha")
		.formParam("projectName", "BMTC")
		.formParam("status", "Created")
		.formParam("teamSize",10)
		.contentType(ContentType.JSON)
		
		//action
		.when()
		  .post("/addProject")
		  //validation
		  .then().log().all();
		
	}

}
