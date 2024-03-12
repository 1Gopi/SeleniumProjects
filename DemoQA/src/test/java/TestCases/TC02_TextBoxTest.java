package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import ObjectRepository.TextBoxObj;
import io.qameta.allure.Step;

public class TC02_TextBoxTest extends BaseClassDemoQA{
	String excelFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\Resources\\testdata.xlsx";
	
	@Step("TextBox Test Case")
  @Test(dependsOnMethods = "Elements()")
  public void testBox() throws Exception {
		TextBoxObj txtobj = new TextBoxObj(driver);
		log.info("clicking on Text Box");
		txtobj.textBoxClick();
		
		 // Open the Excel file
        log.info("Accessing the File through FileInputStream class");
		FileInputStream inputStream = new FileInputStream(excelFilePath);
		log.info("Accessing workbook");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        log.info("Accessing the work sheet");
        XSSFSheet sheet = workbook.getSheet("TextBox");
        log.info("Row count");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        
        for(int i=1;i<=rowCount;i++) {
        	log.info("name value getting from Excel");
        	String nm = sheet.getRow(i).getCell(0).getStringCellValue();
        	Thread.sleep(4000);
        	txtobj.name(nm);
        	log.info("Email value getting from Excel");
        	txtobj.email(sheet.getRow(i).getCell(1).getStringCellValue());
        	log.info("Current Address value getting from Excel");
        	txtobj.currentAdd(sheet.getRow(i).getCell(2).getStringCellValue());
        	log.info("Permanent Address value getting from Excel");
        	txtobj.PermanentAdd(sheet.getRow(i).getCell(3).getStringCellValue());
        	log.info("submit");
        	txtobj.SubmitForm();
        }
		
  }
}
