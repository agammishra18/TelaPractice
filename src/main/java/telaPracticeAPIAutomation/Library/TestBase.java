package telaPracticeAPIAutomation.Library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;

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

	public String getFormattedCurrentTimeStamp(){
		return LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	public String getUnFormattedCurrentTimeStamp(){
		return LocalDateTime.now(ZoneId.of("UTC")).format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
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
	
	public String generateRandomNumberEin(int length) {
		return RandomStringUtils.randomNumeric(length);
    }

}
