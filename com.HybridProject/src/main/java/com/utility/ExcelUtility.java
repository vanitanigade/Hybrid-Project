package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class ExcelUtility extends BaseClass{
	
	public static FileInputStream fis=null;
	public static Workbook wb=null;
	public static Sheet sh=null;
	
	public static String getCellData(String FilePath, String sheetName, int rowNum, int colNum) {
			DataFormatter df = new DataFormatter();
			try {
				fis = new FileInputStream(FilePath);
				wb = WorkbookFactory.create(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
			sh = wb.getSheet(sheetName);
			Cell c = sh.getRow(rowNum).getCell(colNum);
			
		return df.formatCellValue(c);
	}
	
	@Test
	public void test() {
		String jxlPath = "C:\\Users\\61435\\Documents\\Selenium\\loginData2.xls";
		System.out.println(getCellData(jxlPath, "Sheet1", 0, 0));					//OR
		//	String jxlValue=readCell(System.getProperty("user.dir")+"/src/test/resources/Test.xls", "login", 1, 0); //same for poiValue
		//	System.out.println(jxlValue);

	}

}
