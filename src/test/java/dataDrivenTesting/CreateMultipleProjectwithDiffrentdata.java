package dataDrivenTesting;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import JavaLibray.JavaLbrary;
import ProjectLibrary.ProjectLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateMultipleProjectwithDiffrentdata {
   @Test(dataProvider="getdata")
   public void createProject(String createdBy,String projectName,String status,int teamSize)
   {
	   //Prereuisties
	   JavaLbrary jLib=new JavaLbrary();
	   ProjectLibrary pLib=new ProjectLibrary(createdBy, projectName, status, teamSize);
	   baseURI="http://localhost:8084";
		port=8084;
	 
		given()
		.body(pLib)
		.contentType(ContentType.JSON);
		
	   //Action
		when()
		.post("/addProject")
	   
	   //Validation
		.then().log().all();
   }
    @DataProvider(name="getdata")
    public Object[][] data()
    {
    	Object[][] data=new Object[3][4];
    	data[0][0]="Chaithra";
    	data[0][1]="Dell";
    	data[0][2]="Complited";
    	data[0][3]=12;
    	
    	data[1][0]="harsha";
    	data[1][1]="HP";
    	data[1][2]="OnGoing";
    	data[1][3]=10;
    	
    	data[2][0]="Vijay";
    	data[2][1]="Zolo";
    	data[2][2]="Created";
    	data[2][3]=20;
    	
    	return data;
    }
}
