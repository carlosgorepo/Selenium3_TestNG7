package datadriven.excelfunctionalities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtility_SingleDataSet {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;

	/*
	 * Set the File path, open Excel file
	 * @params - Excel Path and Sheet Name
	 */
	public static void setExcelFile(String Path, String SheetName)
			throws Exception {
		try {
			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the Excel data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	/*
	 * Read the test data from the Excel cell
	 * @params - Row num and Col num
	 */
	public static String getCellData(int RowNum, int ColNum) {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			return Cell.getStringCellValue();
		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * Read the test data of date type from the Excel cell
	 * @params - Row num and Col num
	 */
	public static String getDateCellData(int RowNum, int ColNum) {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

			Date dateValue = Cell.getDateCellValue();
			String dateStringFormat = df.format(dateValue);

			return dateStringFormat;
		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * Write in the Excel cell, String Result
	 * @params - Row num and Col num
	 */
	public static void setCellData(String Result, int RowNum, int ColNum)
			throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			// This should handle null pointer exception if Row does not exist
			if (Row == null) {
				Row = ExcelWSheet.createRow(RowNum);
			}
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}

			// Open the file to write the results
			FileOutputStream fileOut = new FileOutputStream(
					Constants.File_Path + Constants.File_Name);

			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}

	/*
	 * Write in the Excel cell, double Result
	 * @params - Row num and Col num
	 */
	public static void setCellData(double Result, int RowNum, int ColNum)
			throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}

			// Open the file to write the results
			FileOutputStream fileOut = new FileOutputStream(Constants.File_Path + Constants.File_Name);

			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);
		}
	}
}
