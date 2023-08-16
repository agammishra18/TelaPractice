package telaPracticeAPIAutomation.APIFuntionalTests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import telaPracticeAPIAutomation.APIActions.POSTCreateProviderAPI;
import telaPracticeAPIAutomation.APIActions.POSTProviderAdminLoginAPI;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ReadJSON;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTCreateProviderAPITest {
	TestBase testBase;
	@BeforeClass
	public void initialize() throws IOException, ApplicationException
	{
		testBase= new TestBase();
		testBase.init();
		new POSTProviderAdminLoginAPI(testBase).getAccessToken();
		
	}
	
	
	@Test(priority=1)
	public void createProviderTest() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		testdata.put("email","Auto_"+testBase.getUnFormattedCurrentTimeStamp()+"@test.com");
		testdata.put("npiNumber", testBase.getUnFormattedCurrentTimeStamp());
		POSTCreateProviderAPI createProvider = new POSTCreateProviderAPI(testBase);
		Response response = createProvider.sendCreateProviderRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	
	@Test(priority=2)
	public void providerNpiAlreadyInUse()throws SecurityException, Exception{
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		testdata.put("email","Auto_"+testBase.getUnFormattedCurrentTimeStamp()+"@test.com");
		testdata.put("npiNumber", testBase.getUnFormattedCurrentTimeStamp());
		POSTCreateProviderAPI createProvider = new POSTCreateProviderAPI(testBase);
		Response response = createProvider.sendCreateProviderRequestNegativeCase(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
}
