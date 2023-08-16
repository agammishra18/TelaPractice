package telaPracticeAPIAutomation.APIFuntionalTests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import telaPracticeAPIAutomation.APIActions.GETAllProvideAPI;
import telaPracticeAPIAutomation.APIActions.GETProviderDetailAPI;
import telaPracticeAPIAutomation.APIActions.POSTProviderAdminLoginAPI;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.TestBase;

public class GETProvideDetailAPITest {
	TestBase testBase;
	@BeforeClass
	public void initialize() throws IOException, ApplicationException
	{
		testBase= new TestBase();
		testBase.init();
		new POSTProviderAdminLoginAPI(testBase).getAccessToken();
		
	}
	
	
	@Test(priority=1)
	public void getProviderDetails() throws SecurityException, Exception
	{
	
		GETProviderDetailAPI getProviderDetails = new GETProviderDetailAPI(testBase);
		Response response = getProviderDetails.getProviderByID();
		int statusCode=response.getStatusCode();
		System.out.println(response.getBody().prettyPrint());
		
	}
}
