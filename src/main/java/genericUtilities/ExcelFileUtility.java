package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consists of generic methods related to excel File
 * @author Debu Rupa
 */

public class ExcelFileUtility {
	/**
	 * This method will read data from excel file based on sheet name,row no and 
	 * cell no and return the value to caller
	 * @param sheetname
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public  String  readDataFromExcel(String sheetname,int rowNo,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(cellNo).getStringCellValue();
		return value;
		
	}
	public Object[][] readMultipleDataFromExcel(String sheetname) throws IOException
	{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetname);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][]data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
