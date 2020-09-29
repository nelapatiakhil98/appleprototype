package com.tririga.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider()
	{
		File src=new File("./Testdata/data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel File "+e.getMessage());
		}
	}
	public String getStringData(String name,int row,int col)
	{
		return wb.getSheet(name).getRow(row).getCell(col).getStringCellValue();
	}
	public String getStringData(int sheet,int row,int col)
	{
		return wb.getSheetAt(sheet).getRow(row).getCell(col).getStringCellValue();
	}
	public double getNumericData(String name,int row,int col)
	{
		return wb.getSheet(name).getRow(row).getCell(col).getNumericCellValue();
	}

}
