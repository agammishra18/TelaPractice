package telaPracticeAPIAutomation.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jxl.read.biff.BiffException;

public class TestBase {

	public Properties properties;
	private String authorizationToken;
	private String refreshToken;

	public void init() throws IOException {
		properties = new Properties();
		loadData("config.properties");

	}

	public void loadData(String PropertiesFileName) throws IOException {
		File file = new File(System.getProperty("user.dir") + "/" + PropertiesFileName);
		FileInputStream propertyFile = new FileInputStream(file);
		properties.load(propertyFile);
	}

//	public String[][] getData(String excelFilePath, String sheetNo) throws BiffException, IOException {
//		ExcelReader read = new ExcelReader();
//		String[][] data = read.getDataFromExcel(excelFilePath, sheetNo);
//		System.out.println(data.length);
//		return data;
//	}

	public String[][] getData(String excelFilePath, int sheetNo) throws BiffException, IOException {
		ExcelReader read = new ExcelReader();
		String[][] data = read.readExcel(excelFilePath, sheetNo);
		return data;
	}

	public String getAuthorizationToken() {
		return authorizationToken;
	}

	public void setAuthorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Response makeAPICall(String method, String body, String url, int expectedStatusCode,
			String expectedResponseMessage) {
		Response response = null;

		RequestSpecification request = RestAssured.given().log().all(true);
//		request.headers(headers);

		switch (method.toUpperCase()) {
		case "GET":
			response = request.when().get(url);
			break;
		case "POST":
			response = request.contentType(ContentType.JSON).body(body).when().post(url);
			break;
		case "PUT":
			response = request.contentType(ContentType.JSON).body(body).when().put(url);
			break;
		case "DELETE":
			response = request.when().delete(url);
			break;
		default:
			System.out.println("Unsupported HTTP method: " + method);
			break;
		}

// Verify the expected response code
		response.then().statusCode(expectedStatusCode);
		response.prettyPrint();

// Verify the expected response message (assuming your response has a "message" field)
		String actualResponseMessage = response.jsonPath().getString("message");
		Assert.assertEquals(actualResponseMessage, expectedResponseMessage,
				"Expected response message does not match actual response message.");

		return response;
	}

}
