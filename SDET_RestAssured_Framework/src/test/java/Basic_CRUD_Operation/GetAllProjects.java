package Basic_CRUD_Operation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects 
{
	@Test
	public void getAllProjects()
	{
		//step 1: create pre requisites
		
		//step 2: send the request
		Response resp = RestAssured.get("http://localhost:8084/projects");
		
		//step 3: validate the response
		int expStatus = 200;
		int actStatus = resp.getStatusCode();
		
		System.out.println(actStatus);
		System.out.println(resp);
		
		Assert.assertEquals(actStatus, expStatus);
	}

}
