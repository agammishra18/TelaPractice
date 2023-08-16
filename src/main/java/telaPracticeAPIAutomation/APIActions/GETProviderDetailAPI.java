package telaPracticeAPIAutomation.APIActions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;

public class GETProviderDetailAPI {
	
	TestBase testbase;
	String apiURL;
	public GETProviderDetailAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}

	@SuppressWarnings("unchecked")
	public Response getProviderByID()throws ApplicationException{
	
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Content-Type","application/json");
		request.headers("Authorization","Bearer "+testbase.getAuthorizationToken());
		request.pathParam("provideId", "f5fc961e-839c-4394-a2a3-abaa4c53e686");
		apiURL = testbase.properties.getProperty("baseURL")+ResourceURI.RA_GetProvideByID.getUri();
		Response response = request.get(apiURL);
		return response;
	}
	
	
	public Response sendGetEnterpriseDetailsRequest() throws ApplicationException {
		Response response = getProviderByID();
		if(response.getStatusCode() != 200)
		{
			throw new ApplicationException("Failure while fetching perticular enterprise details using the API: "+apiURL+"."+System.lineSeparator()
			+"The response code was: "+response.getStatusCode()+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
	}
}
