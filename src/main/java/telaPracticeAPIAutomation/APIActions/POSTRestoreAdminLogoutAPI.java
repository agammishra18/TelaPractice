package telaPracticeAPIAutomation.APIActions;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;


public class POSTRestoreAdminLogoutAPI {
	
	TestBase testbase;
	
	public POSTRestoreAdminLogoutAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}
	
	
	@SuppressWarnings("unchecked")
	
	public Response sendRestoreAdminLogoutRequest(Map<String, Object> testdata) 
	
	{
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Content-Type","application/json");
		request.headers("Authorization","Bearer "+testbase.getAuthorizationToken());
		
		JSONObject json = new JSONObject();
		
		json.put("refreshToken", testbase.getRefreshToken());
	
		
		request.body(json.toJSONString());
		
		Response response = request.post(testbase.properties.getProperty("baseURL")+ResourceURI.RA_Logout.getUri());
		return response;
		
	} 

}
