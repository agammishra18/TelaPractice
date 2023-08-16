package telaPracticeAPIAutomation.APIActions;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;


public class GETAllProvideAPI {
	TestBase testbase;
	String apiURL;
	public GETAllProvideAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}
   
	@SuppressWarnings("unchecked")
	public Response getAllProvider()throws ApplicationException{
	
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Content-Type","application/json");
		request.headers("Authorization","Bearer "+testbase.getAuthorizationToken());
		apiURL = testbase.properties.getProperty("baseURL")+ResourceURI.RA_GetAllProvide.getUri();
		Response response = request.get(apiURL);
		return response;
	}
	
	
	public Response sendGetEnterpriseDetailsRequest() throws ApplicationException {
		Response response = getAllProvider();
		if(response.getStatusCode() != 200)
		{
			throw new ApplicationException("Failure while fetching perticular enterprise details using the API: "+apiURL+"."+System.lineSeparator()
			+"Actual response code : "+response.getStatusCode()+System.lineSeparator()
			+"Expected response code : 200"+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
		
	}
}
