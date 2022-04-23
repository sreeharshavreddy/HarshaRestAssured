package ResponseValidation;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class resposeTimeValidation {
	@Test
	public void ResponseTime()
	{
		//Prerequisites
		baseURI="http://localhost";
		port=8084;
		
		//Action
		  Response resp = when()
		.get("/projects");
		//validation
		resp.then()
		.assertThat().time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS)
		.log().all();
		long ti = resp.time();
		System.out.println(ti);
	}

}
