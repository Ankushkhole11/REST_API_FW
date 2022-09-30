package Basic_CRUD_Operation;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject 
{
	
	@Test
	public void updateProject()
	{
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
		//srep 1: create the pre requisities neccessary
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Advait");
		obj.put("projectName", "flipkart"+" "+ranNum);
		obj.put("status", "Completed");
		obj.put("teamSize", 12);
		
		//step 2: send the request
		RequestSpecification request = RestAssured.given();
		
		request.body(obj);
		request.contentType(ContentType.JSON);
		
		Response resp = request.put("http://localhost:8084/projects/TY_PROJ_604");
		
		//step 3: validate the response
		System.out.println(resp.getStatusCode());
	}
	

}
