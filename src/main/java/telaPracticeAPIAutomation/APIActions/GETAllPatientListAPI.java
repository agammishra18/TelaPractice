package telaPracticeAPIAutomation.APIActions;

import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;


public class GETAllPatientListAPI {
	
	
	TestBase testbase;
	String apiURL;

	public GETAllPatientListAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}
	

	public Response createGETAllRequest(Map<String, Object> testdata)

	{
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Authorization","Bearer "+testbase.getAuthorizationToken());
		request.param("page", testdata.get("page"));
		request.param("size", testdata.get("size"));
		request.param("sortBy", testdata.get("sortBy"));
		request.param("sortDirection", testdata.get("sortDirection"));
		request.param("searchString", testdata.get("searchString"));
		request.param("status", testdata.get("status"));
		
		apiURL = testbase.properties.getProperty("baseURL")+ResourceURI.GetAll_Patient.getUri();
		Response response = request.get(apiURL);
		return response;
	}
	
	public Response sendGetAllEnterpriseUserRequest(Map<String, Object> testdata) throws ApplicationException
	{
		Response response = createGETAllRequest(testdata);
		if(response.getStatusCode() != 200)
		{
			throw new ApplicationException("Failure while getting all patient  API: "+apiURL+"."+System.lineSeparator()
			+"Actual response code : "+response.getStatusCode()+System.lineSeparator()
			+"Expected response code : 200"+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
	}
	
/*	public Response sendGetAllEnterpriseUserRequestNegativeCase(Map<String, Object> testdata) throws ApplicationException
	{
		Response response = createGETAllRequest(testdata);
		if(response.getStatusCode() != 400||response.getStatusCode() !=401)
		{
			throw new ApplicationException("Failure while getting all enterprise user API: "+apiURL+"."+System.lineSeparator()
			+"The response code was: "+response.getStatusCode()+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
	}*/
}
