package telaPracticeAPIAutomation.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import jxl.read.biff.BiffException;



public class TestBase {
	
	public Properties properties;
	private String authorizationToken;
	private String refreshToken;

	public void init() throws IOException
	{
		properties = new Properties();
		loadData("config.properties");
		
	}
	
	
	public void loadData(String PropertiesFileName) throws IOException
	{
		File file = new File(System.getProperty("user.dir")+"/"+PropertiesFileName);
		FileInputStream propertyFile = new FileInputStream(file);
		properties.load(propertyFile);
	}
	
	
	public String[][] getData(String excelFilePath, String sheetNo) throws BiffException, IOException
	{
		ExcelReader read  = new ExcelReader();
		String[][] data = read.getDataFromExcel(excelFilePath, sheetNo);
		System.out.println(data.length);
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
	
}
