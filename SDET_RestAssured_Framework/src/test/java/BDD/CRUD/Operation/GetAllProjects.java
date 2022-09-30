package BDD.CRUD.Operation;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;


public class GetAllProjects 
{
	@Test
	public void getAllProject()
	{
		baseURI= "http://localhost";
		port= 8084;
		
		//create pre requisites
		
		//send the request
		when()
			.get("/projects")
		.then()
			.assertThat().statusCode(200).log().all();
		
		//validate the response
	}
	
}
