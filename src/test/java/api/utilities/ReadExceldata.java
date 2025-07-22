package api.utilities;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExceldata {
   public static FileInputStream inputStream;
   public static XSSFWorkbook workBook;
   public static XSSFSheet excelSheet;
   public static XSSFRow row;
   public static XSSFCell cell;
   
   public static String getCellValue(String filename, String sheetname, int rowno,int cellno) {
	   try {
		   inputStream = new FileInputStream(filename);
		   workBook = new XSSFWorkbook(inputStream);
		   excelSheet = workBook.getSheet(sheetname);
		   cell = workBook.getSheet(sheetname).getRow(rowno).getCell(cellno);
		   workBook.close();
		   return cell.getStringCellValue();
		   
	   }
	   catch(Exception e) {
		   return "" ;
	   }
   }
   
   public static int getRowCount(String fileName, String sheetName) {
	   try {
		   inputStream = new FileInputStream(fileName);
		   workBook = new XSSFWorkbook(inputStream);
		   excelSheet = workBook.getSheet(sheetName);
		   // get total no. of
		   int ttlrows = excelSheet.getLastRowNum()+1;
		   workBook.close();
		   return ttlrows;	   
	   }
	   catch(Exception e) {
		   return 0;
	   }
   }
   public static int getCellCount(String fileName, String sheetName) {
	   try {
		   inputStream = new FileInputStream(fileName);
		   workBook = new XSSFWorkbook(inputStream);
		   excelSheet = workBook.getSheet(sheetName);
		   int ttlcells = excelSheet.getRow(0).getLastCellNum();
		   workBook.close();
		   return ttlcells;
		   
	   }
	   catch(Exception e)
	   {
		   return 0;
	   }
   }
   
   

   
}
