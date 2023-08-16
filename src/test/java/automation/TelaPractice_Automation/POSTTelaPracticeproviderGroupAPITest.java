package automation.TelaPractice_Automation;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import telaPracticeAPIAutomation.Library.TestBase;

public class POSTTelaPracticeproviderGroupAPITest {

	TestBase testBase;

	@DataProvider(name = "signIn")
	public String[][] getData() throws BiffException, IOException {
		String filePath = "res" + File.separator + "TP_SignInData.xls";
		String[][] userData = testBase.getData(filePath, 1);

		return userData;
	}

	@BeforeClass
	public void initialize() throws IOException {
		this.testBase = new TestBase();
		this.testBase.init();

	}

	@Test(dataProvider = "signIn")
	public void telaPractiseLoginTest(String method, String url, String body, String ScenarioName,
			String expected_status_code, String expected_message, String exe) throws SecurityException, Exception {
		int statusCode = Integer.parseInt(expected_status_code);

		testBase.makeAPICall(method, body, url, statusCode, expected_message);
	}

}
