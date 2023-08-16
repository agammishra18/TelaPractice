package telaPracticeAPIAutomation.APIActions;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;

//API Actions class for Demo API
//Here we have to write the logic related to sending API request using Rest Assured
public class POSTCreateUserAPI extends TestBase{
	
	@SuppressWarnings("unchecked")
	public Response sendCreateUserRequest(Map<String, Object> testdata)
	{
		RequestSpecification request = RestAssured.given().log().all();
		Map<String, Object> userData = new HashMap<String, Object>();//Map for capturing body params
		userData.put("name", testdata.get("name"));
		userData.put("job", testdata.get("job"));
		
		JSONObject json = new JSONObject();
		json.putAll(userData);//converting Map to JSON object
		
		request.body(json.toJSONString());//passing JSON string to request body
		//Sending POST request to server
		Response response = request.post(properties.getProperty("baseURL")+ResourceURI.CREATE_USER.getUri());
		return response;//returning response that we received from server
	}

}
