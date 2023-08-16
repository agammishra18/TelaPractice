package automation.TelaPractice_Automation;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import telaPracticeAPIAutomation.APIActions.POSTCreateUserAPI;
import telaPracticeAPIAutomation.Library.ReadJSON;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTCreateUserAPITest extends TestBase{
	
	@BeforeClass
	public void initialize() throws IOException
	{
		init();
	}
	
	@Test
	public void demoTestMethod() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTCreateUserAPI createUser = new POSTCreateUserAPI();
		createUser.sendCreateUserRequest(testdata);
	}

}
