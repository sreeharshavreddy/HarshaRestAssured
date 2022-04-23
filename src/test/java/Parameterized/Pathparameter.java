package Parameterized;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Pathparameter {
	@Test
	public void getSigleproject()
	{
		//pre condition
		baseURI="http://localhost";
		port= 8084;
		given()
		.pathParam("pid", "TY_PROJ_1027")
		
		//actions
		.when()
		.get("/projects/{pid}")
		
		//validation
		.then().log().all();
		
	}

}
