package RequestChaining;

import JavaLibray.JavaLbrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;


public class RequestChanning1 {
	
	@Test
	public void requestChaining(){
	//step 1: create project using POJO
	JavaLbrary jLib=new JavaLbrary();
	ProjectLibrary pLib=new ProjectLibrary("Harsha", "Firefox"+jLib.getRandomNumber(), "complited",20);
    baseURI="http://localhost";
	port= 8084;
	
	Response resp = given()
			          .body(pLib)
			            .contentType(ContentType.JSON)
			            .when()
			            .post("/addProject");
	// capture the data project id
	   String proId = resp.jsonPath().get("projectId");
	   System.out.println(proId);
	   resp.then().log().all();
	   
	   //create get requst and pass project id as path parameter
	   given()
	   .param("pid", proId)
	   .when()
	   .get("/projects/{pid}")
	   .then()
	   .assertThat().statusCode(200).log().all();
	
   
	

}}
