package telaPracticeAPIAutomation.APIActions;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTRestoreAdminLoginAPI  {

	TestBase testbase;
	String apiURL;

	public POSTRestoreAdminLoginAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}



	
	@SuppressWarnings("unchecked")

	public Response createRequest(Map<String, Object> testdata)

	{
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Content-Type","application/json");
		JSONObject json = new JSONObject();
		json.put("username", testdata.get("username"));
		json.put("password", testdata.get("password"));

		request.body(json.toJSONString());
		apiURL = testbase.properties.getProperty("baseURL")+ResourceURI.RA_Login.getUri();
		Response response = request.post(apiURL);
		return response;
	}
	
	public Response sendRestoreAdminLoginRequest(Map<String, Object> testdata) throws ApplicationException
	{
		Response response = createRequest(testdata);
		if(response.getStatusCode() != 200)
		{
			throw new ApplicationException("Failure while logging using the API: "+apiURL+"."+System.lineSeparator()
			+"The response code was: "+response.getStatusCode()+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
	}
	
	public Response sendRestoreAdminLoginRequestNegativeCase(Map<String, Object> testdata) throws ApplicationException
	{
		Response response = createRequest(testdata);
		if(response.getStatusCode() != 400)
		{
			throw new ApplicationException("Failure while logging using the API: "+apiURL+"."+System.lineSeparator()
			+"The response code was: "+response.getStatusCode()+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
	}


	public void getAccessToken() throws ApplicationException 
	{
		Map<String, Object> testdata = new HashMap<>();
		testdata.put("username", testbase.properties.getProperty("providerAdminUserName"));
		testdata.put("password", testbase.properties.getProperty("providerAdminPass"));
		Response response = sendRestoreAdminLoginRequest(testdata);
		testbase.setAuthorizationToken(response.getBody().jsonPath().getString("data.accessToken"));
		testbase.setRefreshToken(response.getBody().jsonPath().getString("data.refreshToken"));
		
	}



}
