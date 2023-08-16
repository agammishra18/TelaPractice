package telaPracticeAPIAutomation.APIFuntionalTests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import telaPracticeAPIAutomation.APIActions.POSTRestoreAdminForgetPassWordAPI;
import telaPracticeAPIAutomation.Library.ReadJSON;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTRestoreAdminForgetPassWordAPITest {
	
  TestBase testBase;
	
	@BeforeClass
	public void initialize() throws IOException
	{
	   this.testBase= new TestBase();
	   this.testBase.init();
	        
		
	}
	
	
	@Test
	public void restoreAdminForgetPassWord() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminForgetPassWordAPI forgetRA = new POSTRestoreAdminForgetPassWordAPI(testBase);
		Response response = forgetRA.sendRestoreAdminForgetPassWordRequest(testdata);
		
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
		
		
		
	}

}

	
 
