package telaPracticeAPIAutomation.APIFuntionalTests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import telaPracticeAPIAutomation.APIActions.GETAllPatientListAPI;
import telaPracticeAPIAutomation.APIActions.POSTCreatePatientAPI;
import telaPracticeAPIAutomation.APIActions.POSTProviderAdminLoginAPI;
import telaPracticeAPIAutomation.APIActions.PUTUpdatePatientAPI;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ReadJSON;
import telaPracticeAPIAutomation.Library.TestBase;

public class GETAllPatientAPITest {
	
TestBase testBase;
	
	@BeforeClass
	public void initialize() throws IOException, ApplicationException
	{
		testBase= new TestBase();
		testBase.init();
		new POSTProviderAdminLoginAPI(testBase).getAccessToken();
		
	}
	
	@Test(priority=1)
	public void getAllPatientWithValidDeatils() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		testdata.put("email","Auto_"+testBase.getUnFormattedCurrentTimeStamp()+"@test.com");
		
		POSTCreatePatientAPI createPatient = new POSTCreatePatientAPI(testBase);
		Response response = createPatient.sendCreatePatientRequest(testdata);
		
		GETAllPatientListAPI getPatientList = new GETAllPatientListAPI(testBase);
		response = getPatientList.sendGetAllEnterpriseUserRequest(testdata);
		String email = response.getBody().jsonPath().getString("data.content[0].email");
		Assert.assertEquals(email, testdata.get("email"));
	}

}
