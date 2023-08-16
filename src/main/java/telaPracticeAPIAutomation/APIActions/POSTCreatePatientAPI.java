package telaPracticeAPIAutomation.APIActions;

import java.util.Map;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ResourceURI;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTCreatePatientAPI {
	
	
	TestBase testbase;
	String apiURL;
	public POSTCreatePatientAPI(TestBase testbase)
	{
		this.testbase = testbase;
	}
	
	
	@SuppressWarnings("unchecked")

	public Response createPatient(Map<String, Object> testdata) throws ApplicationException {
		
		RequestSpecification request = RestAssured.given().log().all();
		request.headers("Content-Type","application/json");
		request.headers("Authorization","Bearer "+testbase.getAuthorizationToken());
		
		
		JSONObject json = new JSONObject();
		json.put("location",testdata.get("location"));
		json.put("registrationDate", testdata.get("registrationDate"));
		json.put("legalLastName", testdata.get("legalLastName"));
		json.put("legalFirstName", testdata.get("legalFirstName"));
		json.put("firstName", testdata.get("firstName"));
		json.put("middleName", testdata.get("middleName"));
		json.put("birthDate", testdata.get("birthDate"));
		json.put("ssn", testdata.get("ssn"));
		json.put("motherName", testdata.get("motherName"));
		json.put("language", testdata.get("language"));
		json.put("race", testdata.get("race"));
		json.put("ethnicity", testdata.get("ethnicity"));
		json.put("maritalStatus", testdata.get("maritalStatus"));
		json.put("genderIdentity", testdata.get("genderIdentity"));
		json.put("address", testdata.get("address"));
		json.put("contactNumber", testdata.get("contactNumber"));
		json.put("email", testdata.get("email"));
		json.put("fax", testdata.get("fax"));
		json.put("emergContactLastName", testdata.get("emergContactLastName"));
		json.put("emergContactFirstName", testdata.get("emergContactFirstName"));
		json.put("emergContactRelation", testdata.get("emergContactRelation"));
		json.put("emergContactNumber", testdata.get("emergContactNumber"));
		json.put("emergContactEmail", testdata.get("emergContactEmail"));
		json.put("consentToEmail", testdata.get("consentToEmail"));
		json.put("consentToCall", testdata.get("consentToCall"));
		json.put("consentToMessage", testdata.get("consentToMessage"));
		json.put("notes", testdata.get("notes"));
		json.put("insurances", testdata.get("insurances"));
		
		request.body(json.toJSONString());
		apiURL = testbase.properties.getProperty("baseURL")+ResourceURI.CreatePatient.getUri();
		Response response = request.post(apiURL);
		return response;
	}
	
	public Response sendCreatePatientRequest(Map<String, Object> testdata) throws ApplicationException {
		Response response = createPatient(testdata);
		if(response.getStatusCode() != 201)
		{
			throw new ApplicationException("Failure while creating patient using the API: "+apiURL+"."+System.lineSeparator()
			+"Actual response code : "+response.getStatusCode()+System.lineSeparator()
			+"Expected response code : 200"+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
		
	}
	
	
	public Response sendCreatePatientRequestNegativeCase(Map<String, Object> testdata) throws ApplicationException {
		Response response = createPatient(testdata);
		if(response.getStatusCode() != 400)
		{
			throw new ApplicationException("Failure to validate Negative Scenario while Creating Patient using the API: "+apiURL+"."+System.lineSeparator()
			+"Actual response code was: "+response.getStatusCode()+System.lineSeparator()
			+"Expected response code is: 400"+System.lineSeparator()
			+"And the response body received is: "+response.getBody().asString());
		}
		return response;
	}
	
}

	


