package datadriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelReadBasic {

	public static void main(String[] args) {
		XSSFWorkbook excelWBook;  // Archivo de Excel
		XSSFSheet excelWSheet;    // Hoja de Excel
		XSSFCell cell;            // Celda de Excel

		String path = System.getProperty("user.dir") + File.separator + "src/test/java/datadriven/ExcelRead.xlsx"; // Path para leer el archivo de Excel

		String sheetName = "Sheet1"; // Nombre de la hoja igual al archivo
		int row = 1;
		int column = 0;

		try {
			FileInputStream excelFile = new FileInputStream(path); // Leer el archivo
			excelWBook = new XSSFWorkbook(excelFile);  // Asignamos el archivo al workbook
			excelWSheet = excelWBook.getSheet(sheetName); // Lea la hoja con el nombre tal "sheetName"

			cell = excelWSheet.getRow(row).getCell(column);
			String cellData = cell.getStringCellValue();
			System.out.println("Cell Data: " + cellData);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}