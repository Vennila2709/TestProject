package org.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWrite {
	public static void main(String[] args) throws IOException {
		//excel location
		File excelLoc=new File("C:\\Users\\Admin\\Batch7\\MavenProject\\Resource\\Sample.xlsx");
		FileInputStream stream=new FileInputStream(excelLoc);
		Workbook w=new XSSFWorkbook(stream);
		Sheet s=w.getSheet("Data");
		Row r=s.getRow(0);
	   Cell c=r.getCell(0);
	   String text=c.getStringCellValue();
	   if(text.equals("Vennila")) {
	   c.setCellValue("Nila");
	   }
	   else {
		   c.setCellValue("Abi");
	   }
	  FileOutputStream st=new FileOutputStream(excelLoc);
	  w.write(st);
	  w.close();
	  System.out.println("Wrote successfully");

}
}
