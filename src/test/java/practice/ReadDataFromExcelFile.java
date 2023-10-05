package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Step1:Open the document in Java readable Format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2:Create a WorkBook
		Workbook wb = WorkbookFactory.create(fis);
		
		//Step3:Navigate to required Sheet
		Sheet sh = wb.getSheet("Organization");
		
	    //Step4:Navigate to required Row
		Row rw = sh.getRow(0);
		
		//Step6:Navigate to Required Cell
		Cell cl = rw.getCell(0);
		
		//Step7:Capture the value in the cell
		String value = cl.getStringCellValue();
		System.out.println(value);
	}

}
