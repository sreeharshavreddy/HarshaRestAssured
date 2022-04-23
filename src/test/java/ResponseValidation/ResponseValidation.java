package ResponseValidation;

import JavaLibray.JavaLbrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class ResponseValidation {
	@Test
	public void staticResponse()
	{
		JavaLbrary jLib=new JavaLbrary();
		baseURI="http://localhost:8084";
		port=8084;
	
		//step:1 create Prerequisites
		ProjectLibrary Plib=new ProjectLibrary("Harsha", "Apple"+jLib.getRandomNumber(), "On-going", 5);
	 
		given()
		 .body(Plib)
		 .contentType(ContentType.JSON)
		 
		 .when()
		 .post("/addProjects")
		 
		 .then()
		 .assertThat().statusCode(201)
		 .log().all();
	}	
}
