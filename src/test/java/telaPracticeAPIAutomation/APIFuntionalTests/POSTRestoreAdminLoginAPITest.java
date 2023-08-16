package telaPracticeAPIAutomation.APIFuntionalTests;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import telaPracticeAPIAutomation.APIActions.POSTRestoreAdminLoginAPI;
import telaPracticeAPIAutomation.Library.ReadJSON;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTRestoreAdminLoginAPITest  {
	
TestBase testBase;
	
	@BeforeClass
	public void initialize() throws IOException
	{
	   this.testBase= new TestBase();
	   this.testBase.init();
	        testBase.getAuthorizationToken();
		
	}
	
	
	@Test(priority=1)
	public void restoreAdminLoginWithValidCreds() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	
	@Test (priority=2)
	public void restoreAdminLoginWithInValidUserName() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("InValid UserName Status Code="+statusCode);
	}

	
	@Test (priority=3)
	public void restoreAdminLoginWithInValidPassword() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("InValid Password Status Code="+statusCode);
	}
	
	@Test (priority=4)
	public void restoreAdminLoginWithInvalidCreds() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("InValid Credentials Both Status Code="+statusCode);
	}

	@Test (priority=5)
	public void restoreAdminLoginWithBlankUsername() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("Blank Username Status Code="+statusCode);
	}

	@Test (priority=6)
	public void restoreAdminLoginWithCaseSensitiveUsername() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("Case Sensitive Username Status Code="+statusCode);
	}
	
	@Test (priority=7)
	public void restoreAdminLoginWithSpaceInUsername() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("With Space Username Status Code="+statusCode);
	}
	@Test (priority=8)
	public void restoreAdminLoginWithBlankPassWord() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("With blankpassword Status Code="+statusCode);
	}
	
	@Test (priority=9)
	public void restoreAdminLoginWithStartSpaceInUserName() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("With Start SpaceIn Username Status Code="+statusCode);
	}
	@Test (priority=10)
	public void restoreAdminLoginWithEndSpaceInUserName() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("With End SpaceIn Username Status Code="+statusCode);
	}
	
	@Test (priority=11)
	public void restoreAdminLoginWithStartSpaceInPassword() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("With Start SpaceIn Password Status Code="+statusCode);
	}
	
	@Test (priority=12)
	public void restoreAdminLoginWithEndSpaceInPassword() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminLoginAPI loginRA = new POSTRestoreAdminLoginAPI(testBase);
		Response response = loginRA.sendRestoreAdminLoginRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("With End SpaceIn Password Status Code="+statusCode);
	}
	
}

