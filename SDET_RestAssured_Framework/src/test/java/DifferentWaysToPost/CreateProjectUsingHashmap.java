package DifferentWaysToPost;

import java.util.HashMap;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingHashmap 
{
	
	@Test
	public void createProject()
	{
		baseURI= "http://localhost";
		port = 8084;
		
		Random ran = new Random();
		int ranNum = ran.nextInt(500);
		
		//create pre requisites
		HashMap map = new HashMap();
		map.put("createdBy", "Harsh");
		map.put("projectName", "Amdocs"+" "+ranNum);
		map.put("status", "Created");
		map.put("teamSize", 21);
		
		//send the request
		given()
			.body(map)
			.contentType(ContentType.JSON)
			.when()
			.post("/addProject")
			.then()
		//	.assertThat().statusCode(201)
			.log().all();
	}

}
