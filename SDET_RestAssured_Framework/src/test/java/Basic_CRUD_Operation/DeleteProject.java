package Basic_CRUD_Operation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject 
{
	
	@Test
	public void deleteProject()
	{
		//step1: Create pre requisites
		
		//step 2: send the request
		Response resp = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_604");
		
		//step 3: validate the response
				System.out.println(resp.getStatusCode());
	}

}
