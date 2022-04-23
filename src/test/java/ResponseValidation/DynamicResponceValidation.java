
package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.port;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.tools.xjc.generator.util.WhitespaceNormalizer;

import JavaLibray.JavaLbrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DynamicResponceValidation {
	@Test
	public void DynamicResponseValidation()
	{
		JavaLbrary jLib=new JavaLbrary();
		baseURI="http://localhost:8084";
		port=8084;
		String expData="TY_PROJ_001";

		//step:1 Action
		Response resp = when()

				.get("/project");

		//Validation
		boolean flag = false;
		List<String> pIDs = resp.jsonPath().get("projectId");
		for(String projectID : pIDs)
		{
			if(projectID.equalsIgnoreCase(expData))
			{
				flag = true;
			}
		}

		Assert.assertTrue(flag);
		System.out.println("data verfied");

		resp.then().log().all();
	}

}




