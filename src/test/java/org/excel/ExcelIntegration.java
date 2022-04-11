package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIntegration {
public String getData(int rowNo, int cellNo) throws IOException {
	String value=null;
	File excelLoc=new File("C:\\Users\\Admin\\Batch7\\MavenProject\\Resource\\EmpDetails.xlsx");
	FileInputStream stream=new FileInputStream(excelLoc);
	Workbook w=new XSSFWorkbook(stream);
	Sheet s=w.getSheet("Sheet1");
	Row r=s.getRow(rowNo);
	Cell c=r.getCell(cellNo);
	CellType type=c.getCellType();
	String cellType=String.valueOf(type).trim();
	
if(cellType.equalsIgnoreCase("STRING")){
	value=c.getStringCellValue();
}
else if(cellType.equalsIgnoreCase("NUMERIC")) {
	if(DateUtil.isCellDateFormatted(c)) {
		Date dateCellValue=c.getDateCellValue();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YY");
		String name=sim.format(dateCellValue);
		value=name;
	}
	else {
		double numericCellValue = c.getNumericCellValue();
		long l=(long)numericCellValue;
		String name=String.valueOf(l);
		value=name;
	}
}
	return value;
}
	public static void main(String[] args) throws IOException {
		ExcelIntegration e=new ExcelIntegration();
String name=(e.getData(2, 2));
System.out.println(name);
	}
}
