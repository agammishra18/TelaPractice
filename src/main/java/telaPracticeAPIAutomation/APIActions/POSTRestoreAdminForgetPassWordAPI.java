package telaPracticeAPIAutomation.APIActions;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTRestoreAdminForgetPassWordAPI extends TestBase   {
	
   TestBase testbase;
	
	public POSTRestoreAdminForgetPassWordAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}
	

	@SuppressWarnings("unchecked")
	
	public Response sendRestoreAdminForgetPassWordRequest(Map<String, Object> testdata) 
	
	{
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Content-Type","application/json");
		
		JSONObject json = new JSONObject();
		json.put("email", testdata.get("email"));
		
		request.body(json.toJSONString());
		
		Response response = request.post(testbase.properties.getProperty("baseURL")+ResourceURI.RA_Forget.getUri());
		return response;
		
	}
	
	
	
	
	

}


