package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {


public static String getCellValue(String xlPath, String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
	String value = "";
	try {
	FileInputStream fis=new FileInputStream(xlPath);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	value=wb.getSheet(sheet).getRow(row).getCell(cell).toString();
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return value;
}

public static int getRowCount(String xlPath, String sheet) {
	
	int rc=0;
	try {
		FileInputStream fis=new FileInputStream(xlPath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		rc = wb.getSheet(sheet).getLastRowNum();
		
	}catch(Exception e) {e.printStackTrace();}
	return rc;
}
}