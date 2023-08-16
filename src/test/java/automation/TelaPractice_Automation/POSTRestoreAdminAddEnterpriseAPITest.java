package automation.TelaPractice_Automation;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import telaPracticeAPIAutomation.APIActions.POSTRestoreAdminAddEnterpriseAPI;
import telaPracticeAPIAutomation.APIActions.POSTRestoreAdminLoginAPI;
import telaPracticeAPIAutomation.Exceptions.ApplicationException;
import telaPracticeAPIAutomation.Library.ReadJSON;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTRestoreAdminAddEnterpriseAPITest {
	
	TestBase testBase;
	
	@BeforeClass
	public void initialize() throws IOException, ApplicationException
	{
		testBase= new TestBase();
		testBase.init();
		new POSTRestoreAdminLoginAPI(testBase).getAccessToken();
		
	}
	
	
	@Test(priority=1)
	public void restoreAdminAddEnterpriseWithAllDeatils() throws SecurityException, Exception
	{
		
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminAddEnterpriseAPI addEnterprise = new POSTRestoreAdminAddEnterpriseAPI(testBase);
		Response response = addEnterprise.sendCreateEnterpriseRequest(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	
	@Test(priority=2)
	public void restoreAdminAddEnterpriseNameAlreadyExist() throws SecurityException, Exception {
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminAddEnterpriseAPI addEnterprise = new POSTRestoreAdminAddEnterpriseAPI(testBase);
		Response response = addEnterprise.sendCreateEnterpriseRequestNegativeCase(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	@Test(priority=3)
	public void restoreAdminAddEnterpriseEmailAlreadyExist()throws SecurityException, Exception{
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminAddEnterpriseAPI addEnterprise = new POSTRestoreAdminAddEnterpriseAPI(testBase);
		Response response = addEnterprise.sendCreateEnterpriseRequestNegativeCase(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	@Test(priority=4)
	public void restoreAdminAddEnterpriseSubdomainAlreadyExist()throws SecurityException, Exception{
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminAddEnterpriseAPI addEnterprise = new POSTRestoreAdminAddEnterpriseAPI(testBase);
		Response response = addEnterprise.sendCreateEnterpriseRequestNegativeCase(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	@Test(priority=5)
	public void restoreAdminAddEnterpriseWithoutName()throws SecurityException, Exception{
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminAddEnterpriseAPI addEnterprise = new POSTRestoreAdminAddEnterpriseAPI(testBase);
		Response response = addEnterprise.sendCreateEnterpriseRequestNegativeCase(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	@Test(priority=6)
	public void restoreAdminAddEnterpriseWithoutsubdomain()throws SecurityException, Exception{
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminAddEnterpriseAPI addEnterprise = new POSTRestoreAdminAddEnterpriseAPI(testBase);
		Response response = addEnterprise.sendCreateEnterpriseRequestNegativeCase(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	@Test(priority=7)
	public void restoreAdminAddEnterpriseWithoutemail()throws SecurityException, Exception{
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminAddEnterpriseAPI addEnterprise = new POSTRestoreAdminAddEnterpriseAPI(testBase);
		Response response = addEnterprise.sendCreateEnterpriseRequestNegativeCase(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
	@Test(priority=8)
	public void restoreAdminAddEnterpriseWithoutNPI()throws SecurityException, Exception{
		Map<String, Object> testdata = new ReadJSON().readJSONFile(this.getClass().getSimpleName()+".json",
				new Throwable().getStackTrace()[0].getMethodName());
		POSTRestoreAdminAddEnterpriseAPI addEnterprise = new POSTRestoreAdminAddEnterpriseAPI(testBase);
		Response response = addEnterprise.sendCreateEnterpriseRequestNegativeCase(testdata);
		int statusCode=response.getStatusCode();
		System.out.println("ValidStatusCode="+statusCode);
	}
}
