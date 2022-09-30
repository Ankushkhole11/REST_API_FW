package DifferentWaysToPost;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import POJOLiabraries.ProjectLiabrary;
import io.restassured.http.ContentType;

public class CreateProjectUsingPOJOClass {
	
	@Test
	public void createProject()
	{
		baseURI= "http://localhost";
		port = 8084;
		
		Random ran = new Random();
		int ranNum = ran.nextInt(500);
		
		//create pre requisites
		ProjectLiabrary pLib = new ProjectLiabrary("Pojo", "Xylem"+" "+ranNum, "Created", 14);
		
		//send the request
		given()
			.body(pLib)
			.contentType(ContentType.JSON)
			.when()
			.post("/addProject")
			.then().log().all();
	}

}
