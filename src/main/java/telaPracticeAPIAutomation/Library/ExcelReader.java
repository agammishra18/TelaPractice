package telaPracticeAPIAutomation.Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader {
	
	private static final Logger log = LogManager.getLogger(ExcelReader.class.getName());

	public String path;
	public FileInputStream fis;
	public Workbook book;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	
	
	public String[][] getDataFromExcel(String excelFilePath, String sheetName) throws EncryptedDocumentException, IOException
	{
		String dataSets[][] = null;
		
		this.path=excelFilePath;
	
			fis = new FileInputStream(path);
			book = WorkbookFactory.create(fis);	
		
		try {
			log.info("===========Excel reader Starts=========");
			Sheet sheet;
			sheet = book.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum()+1;
			//System.out.println("========"+totalRow+"=============");
			Row row = sheet.getRow(0);
			int totalColumn = row.getLastCellNum();
			//System.out.println("========"+totalColumn+"=============");
			dataSets = new String[totalRow-1][totalColumn];
			for(int i=1;i<totalRow;i++)
			{
				row = sheet.getRow(i);
				for(int j=0;j<totalColumn;j++)
				{
					Cell cell = row.getCell(j);
	
					if(cell.getCellType().name().toString().equalsIgnoreCase("string"))
						dataSets[i-1][j]=cell.getStringCellValue();
					else if(cell.getCellType().name().toString().equalsIgnoreCase("numeric")){
						
						String cellText = String.valueOf(new BigDecimal(cell.getNumericCellValue()).longValue());
						dataSets[i-1][j]=cellText;
					}
					else
						dataSets[i-1][j] = String.valueOf(cell.getBooleanCellValue());
				}
			}
			//Reporter.log("==========Excel Reading Finished================", true);
			return dataSets;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Reporter.log("==========Excel Reading Finished================", true);
		return dataSets;
	}
	
}
