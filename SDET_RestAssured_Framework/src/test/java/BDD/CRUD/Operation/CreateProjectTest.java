package BDD.CRUD.Operation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.Random;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProject() {
		
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
		baseURI="http://localhost";
		port= 8084;
		
		//srep 1: create the pre requisities neccessary
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Advait");
		obj.put("projectName", "flipkart-bdd"+" "+ranNum);
		obj.put("status", "On Going");
		obj.put("teamSize", 12);
		
		//step 2: send the request

		given()
			.body(obj)
			.contentType(ContentType.JSON)
		.when()
			.post("/addProject")
		.then()
			.assertThat().statusCode(201)
			.log().all();
		
		//step 3: validate the response	
	}
}
