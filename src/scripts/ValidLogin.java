package scripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import generic.Excel;
import pom.*;

public class ValidLogin extends BaseTest {
	
	@Test
	public void testValidLogin() throws EncryptedDocumentException, IOException {
		String xlPath="./TestData/Login.xlsx";
		String sheet="ValidLogin";
		int rc=Excel.getRowCount(xlPath, sheet);
		
		for(int i=1;i<=rc;i++) {
			String un=Excel.getCellValue(xlPath, sheet, i, 0);
			String pw=Excel.getCellValue(xlPath, sheet, i, 1);
			
			//Enter Valid User name and Password
			LoginPage l=new LoginPage(driver);
			l.login(un, pw);
			
			//Click on logout
			HomePage h=new HomePage(driver);
			h.logout();
		}
		
		
		
	}

}
