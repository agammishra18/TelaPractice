package telaPracticeAPIAutomation.APIFuntionalTests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import telaPracticeAPIAutomation.APIActions.GETAllProvideAPI;
import telaPracticeAPIAutomation.APIActions.POSTProviderAdminLoginAPI;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ReadJSON;
import telaPracticeAPIAutomation.Library.TestBase;
;

public class GETAllProvideAPITest {
	TestBase testBase;
	@BeforeClass
	public void initialize() throws IOException, ApplicationException
	{
		testBase= new TestBase();
		testBase.init();
		new POSTProviderAdminLoginAPI(testBase).getAccessToken();
		
	}
	
	
	@Test(priority=1)
	public void getAllProvider() throws SecurityException, Exception
	{
	
		GETAllProvideAPI getAllProvider = new GETAllProvideAPI(testBase);
		Response response = getAllProvider.getAllProvider();
		int statusCode=response.getStatusCode();
		System.out.println(response.getBody().prettyPrint());
		
	}
}
