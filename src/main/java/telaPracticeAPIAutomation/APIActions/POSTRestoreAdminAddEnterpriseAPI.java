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


public class POSTRestoreAdminAddEnterpriseAPI {
	TestBase testbase;
	String apiURL;
	public POSTRestoreAdminAddEnterpriseAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}

	@SuppressWarnings("unchecked")

	public Response createEnterprise(Map<String, Object> testdata) throws ApplicationException {
		
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Content-Type","application/json");
		request.headers("Authorization","Bearer "+testbase.getAuthorizationToken());
		
		JSONObject json = new JSONObject();
		json.put("name", testdata.get("name"));
		json.put("contactNumber", testdata.get("contactNumber"));
		json.put("npiNumber", testdata.get("npiNumber"));
		json.put("email", testdata.get("email"));
		json.put("website", testdata.get("website"));
		json.put("fax", testdata.get("fax"));
		json.put("subdomain", testdata.get("subdomain"));
		json.put("description", testdata.get("description"));
		json.put("physicalAddress", testdata.get("physicalAddress"));
		json.put("billingAddress", testdata.get("billingAddress"));
		json.put("active", testdata.get("active"));
		json.put("archive", testdata.get("archive"));
		
		request.body(json.toJSONString());
		apiURL = testbase.properties.getProperty("baseURL") + ResourceURI.RA_CreateEnterprise.getUri();
		Response response = request.post(apiURL);
		return response;
	}
	
	public Response sendCreateEnterpriseRequest(Map<String, Object> testdata) throws ApplicationException {
		Response response = createEnterprise(testdata);
		if(response.getStatusCode() != 201)
		{
			throw new ApplicationException("Failure while creating enterprise using the API: "+apiURL+"."+System.lineSeparator()
			+"The response code was: "+response.getStatusCode()+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
		
	}
	
	
	public Response sendCreateEnterpriseRequestNegativeCase(Map<String, Object> testdata) throws ApplicationException {
		Response response = createEnterprise(testdata);
		if(response.getStatusCode() != 400)
		{
			throw new ApplicationException("Failure to validate Negative Scenario while Creating Enterprise using the API: "+apiURL+"."+System.lineSeparator()
			+"The response code was: "+response.getStatusCode()+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
	}
	
}
