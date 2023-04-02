package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	String fileLocation="./src/test/resources/testdata/CandidateTestData.xlsx";
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	
	public ExcelUtility()
	{
		
	}
	
	private void readFile() throws IOException
	{
		file = new FileInputStream(new File(fileLocation));
		workbook = new XSSFWorkbook(file);
		
	}
	
	private void readSheetCol(String name)
	{
		sheet = workbook.getSheet(name);
		
	}
	public String readTheDataFromFileByColumn(String col)
	{
		int rowInt = sheet.getFirstRowNum();
		for(int i=1;i<rowInt-1;i++)
		{
			//row.getCell(0).
		}
		return null;
	}
	
}
