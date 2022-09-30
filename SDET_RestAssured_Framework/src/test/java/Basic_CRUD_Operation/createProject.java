package Basic_CRUD_Operation;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class createProject 
{
	@Test
	public void createProjectTest()
	{
		
		Random ran=new Random();
		int ranNum = ran.nextInt(1000);
		
		//srep 1: create the pre requisities neccessary
		JSONObject obj = new JSONObject();
		obj.put("createdBy", "Advait");
		obj.put("projectName", "flipkart"+" "+ranNum);
		obj.put("status", "On Going");
		obj.put("teamSize", 12);
		
		//step 2: send the request
		RequestSpecification request = RestAssured.given();
		
		request.body(obj);
		request.contentType(ContentType.JSON);
		
		Response resp = request.post("http://localhost:8084/addProject");
		
		//step 3: validate the response
		System.out.println(resp.getContentType());
		System.out.println(resp.getStatusCode());
		System.out.println(resp.getStatusLine());
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		
		ValidatableResponse validate = resp.then();
		System.out.println(validate.log().all());
		
	}

}
