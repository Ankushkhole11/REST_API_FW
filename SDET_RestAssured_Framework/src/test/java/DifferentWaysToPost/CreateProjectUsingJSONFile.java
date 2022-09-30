package DifferentWaysToPost;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.File;
import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingJSONFile 
{
	@Test
	public void createProject()
	{
		baseURI= "http://localhost";
		port = 8084;
		
		//create pre requisites
		File file = new File(".\\data.json");
		
		
		//send the request
		given()
			.body(file)
			.contentType(ContentType.JSON)
			.when()
			.post("/addProject")
			.then()
		//	.assertThat().statusCode(201)
			.log().all();
	}

}
