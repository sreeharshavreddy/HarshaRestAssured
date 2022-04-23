package CommonLibrary;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import JavaLibray.JavaLbrary;

public class BaseClassAPI {
	
	public DatabaseLibrary dLib = new DatabaseLibrary();
	public JavaLbrary jLib = new JavaLbrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable
	{
		//Establish databse connection
		dLib.connectToDB();
		System.out.println("=============db connection established============");
		
		//set base Uri and port
	    baseURI = "http://localhost";
	    port = 8084;
	    
	    
	}
	
	
	@AfterSuite
	public void asConfig() throws Throwable
	{
		dLib.closeDB();
	}

}




