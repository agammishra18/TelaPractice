package telaPracticeAPIAutomation.APIActions;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTCreateProviderAPI {
	TestBase testbase;
	String apiURL;
	public POSTCreateProviderAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}

	@SuppressWarnings("unchecked")

	public Response createProvider(Map<String, Object> testdata) throws ApplicationException {
		
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Content-Type","application/json");
		request.headers("Authorization","Bearer "+testbase.getAuthorizationToken());
		
		JSONObject json = new JSONObject();
		json.put("firstName", testdata.get("firstName"));
		json.put("lastName", testdata.get("lastName"));
		json.put("email", testdata.get("email"));
		json.put("providerType", testdata.get("providerType"));
		json.put("specialities", testdata.get("specialities"));
		json.put("role", testdata.get("role"));
		json.put("userType", testdata.get("userType"));
		json.put("gender", testdata.get("gender"));
		json.put("npiNumber", testdata.get("npiNumber"));
		json.put("contactNumber", testdata.get("contactNumber"));
		json.put("faxNumber", testdata.get("faxNumber"));
		json.put("groupNpiNumber", testdata.get("groupNpiNumber"));
		json.put("licensedState", testdata.get("licensedState"));
		json.put("licenceNumber", testdata.get("licenceNumber"));
		json.put("yearOfExperience", testdata.get("yearOfExperience"));
		json.put("taxonomyNumber", testdata.get("taxonomyNumber"));
		json.put("workLocations", testdata.get("workLocations"));
		json.put("providerProfileInfo", testdata.get("providerProfileInfo"));
		json.put("insuranceAccepted", testdata.get("insuranceAccepted"));
		json.put("avatar", testdata.get("avatar"));
		
		request.body(json.toJSONString());
		apiURL = testbase.properties.getProperty("baseURL")+ResourceURI.RA_CreateProvider.getUri();
		Response response = request.post(apiURL);
		return response;
	}
	
	public Response sendCreateProviderRequest(Map<String, Object> testdata) throws ApplicationException {
		Response response = createProvider(testdata);
		if(response.getStatusCode() != 201)
		{
			throw new ApplicationException("Failure while creating enterprise using the API: "+apiURL+"."+System.lineSeparator()
			+"Actual response code : "+response.getStatusCode()+System.lineSeparator()
			+"Expected response code : 200"+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
		
	}
	
	
	public Response sendCreateProviderRequestNegativeCase(Map<String, Object> testdata) throws ApplicationException {
		Response response = createProvider(testdata);
		if(response.getStatusCode() != 400)
		{
			throw new ApplicationException("Failure to validate Negative Scenario while Creating Enterprise using the API: "+apiURL+"."+System.lineSeparator()
			+"Actual response code : "+response.getStatusCode()+System.lineSeparator()
			+"Expected response code : 200"+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
	}

}
