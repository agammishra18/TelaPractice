package telaPracticeAPIAutomation.APIActions;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTRestoreAdminSetPassWordAPI extends TestBase{

	 TestBase testbase;
		
		public POSTRestoreAdminSetPassWordAPI(TestBase testbase)
		{
			this.testbase = testbase;
		}
	
	
	@SuppressWarnings("unchecked")
		
		public Response sendRestoreAdminResetPassWordRequest(Map<String, Object> testdata) 
		
		{
			RequestSpecification request = RestAssured.given().log().all();
			request.headers("Content-Type","application/json");
			
			JSONObject json = new JSONObject();
			
			json.put("newPassword", testdata.get("newPassword"));
			json.put("linkId", testdata.get("linkId"));
			json.put("uuid", testdata.get("uuid"));
			json.put("enterpriseId", testdata.get("enterpriseId"));
			
			request.body(json.toJSONString());
			
			Response response = request.post(testbase.properties.getProperty("baseURL")+ResourceURI.RA_SetPass.getUri());
			return response;
		}
}
