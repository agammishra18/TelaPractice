package telaPracticeAPIAutomation.APIFuntionalTests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import telaPracticeAPIAutomation.APIActions.POSTRestoreAdminLoginAPI;
import telaPracticeAPIAutomation.APIActions.POSTRestoreAdminLogoutAPI;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ReadJSON;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTRestoreAdminLogoutAPITest  {
	
	TestBase testBase;
	
	@BeforeClass
	public void initialize() throws IOException, ApplicationException
	{
	   testBase= new TestBase();
	   testBase.init();
	   new POSTRestoreAdminLoginAPI(testBase).getAccessToken();
		
	}
	
	@Test
	public void restoreAdminLogOut() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		
		
		
		POSTRestoreAdminLogoutAPI logOutRA = new POSTRestoreAdminLogoutAPI(this.testBase);
		Response response = logOutRA.sendRestoreAdminLogoutRequest(testdata);
		
		int statusCode=response.getStatusCode();
		System.out.println("StatusCode="+statusCode);
		
		System.out.println(response.prettyPrint());
	} 

}
