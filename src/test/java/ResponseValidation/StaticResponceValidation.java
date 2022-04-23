package ResponseValidation;

import org.testng.annotations.Test;

import com.sun.tools.xjc.generator.util.WhitespaceNormalizer;

import JavaLibray.JavaLbrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import junit.framework.Assert;

import  static io.restassured.RestAssured.*;

public class StaticResponceValidation {
	@Test
	public void staticresponcecreate()
	{
	
		baseURI="http://localhost";
		port=8084;
		String expData="TY_PROJ_1028";
		
		Response resp = when()
				.get("./projects");
		String actData = resp.jsonPath().get("projectId");
		Assert.assertEquals(actData, expData);
		System.out.println("data verrifind");
		resp.then().log().all();
		
				
	}


}
