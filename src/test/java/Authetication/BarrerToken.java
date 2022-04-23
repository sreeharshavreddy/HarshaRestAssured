package Authetication;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import io.restassured.http.ContentType;

public class BarrerToken {
	public void barrerToken()
	{
		baseURI="https://api.github.com";
		 JSONObject jObj = new JSONObject();
		 jObj.put("name", "sedet-30Restassured");
		 
		 given()
		 .auth()
		 .oauth2("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")
		 .body(jObj)
		 .contentType(ContentType.JSON)
		 
		 .when()
		 .post("/user/repos")
		 
		 .then().log().all();
	}
}

