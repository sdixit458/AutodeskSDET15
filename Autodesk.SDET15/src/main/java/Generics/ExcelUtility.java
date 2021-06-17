package Generics;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains methods to read and write data with respect to excel sheet
 * @author Saurabh
 *
 */
public class ExcelUtility {
	
	/**
	 * read the excel data with row and column number
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, int rownum, int cellnum) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstants.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		return value;
		
	}
	
	/**
	 * read the excel data with testcase id and header
	 * @param sheetName
	 * @param tcId
	 * @param headerName
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheetName, String tcId, String headerName) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstants.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		int expectedRow = 0;
		for (int i = 0;i<=lastRowNum;i++)
		{
			String testcaseID = sheet.getRow(i).getCell(0).getStringCellValue();
			System.out.println(testcaseID);
			if(testcaseID.equalsIgnoreCase(tcId))
			{
				expectedRow = i;
				break;
			}
		}
		System.out.println(expectedRow);
		expectedRow--;
		
		int expectedCellNum = 0;
		int lastCellNum = sheet.getRow(expectedRow).getLastCellNum();
		for(int j=0;j<lastCellNum;j++)
		{
			String value = sheet.getRow(expectedRow).getCell(j).getStringCellValue();
			if(value.equalsIgnoreCase(headerName))
			{
				expectedCellNum = j;
				break;
			}
		}
		
		String data = sheet.getRow(expectedRow+1).getCell(expectedCellNum).getStringCellValue();
		return data;
	}
	
	/**
	 * read the data from excel sheet using the sheet name
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getExcelData(String sheetName) throws Throwable
	{
		FileInputStream file = new FileInputStream(IPathConstants.EXCELPATH);
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet(sheetName);
		int lastrow = sheet.getLastRowNum();
		int lastcell = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
				
			}
		}
		return data;
	}

}
