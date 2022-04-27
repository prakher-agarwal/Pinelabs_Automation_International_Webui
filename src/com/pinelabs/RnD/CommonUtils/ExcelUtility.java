package com.pinelabs.RnD.CommonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.pinelabs.RnD.WebUI.Constants.FilePaths;


public class ExcelUtility {
	static Workbook workbook;
	static Sheet sheet;
	 static Properties config  = CommonUtils.readPropertyfile(FilePaths.webUIUserConfig);

	public static String testDataPath = config.getProperty("TestDataExcelLocation");
	
	public static Object[][] readTestData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = null;
		file = new FileInputStream(testDataPath);
		workbook = WorkbookFactory.create(file);
		sheet = workbook.getSheet(sheetName);
		Object[][] Testdata = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i =0;i<sheet.getLastRowNum();i++){
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
			Testdata[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
		}
		return Testdata;
		}
		
	}

