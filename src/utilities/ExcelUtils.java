package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFCell cell;

	public static void setExcelFile(String excelFilePath, String sheetName) throws IOException {

		File file = new File(excelFilePath);
		FileInputStream inputStream = new FileInputStream(file);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheet(sheetName);
	}

	public static void activateSheet(String sheetName) throws IOException {
		sheet = workbook.getSheet(sheetName);
	}

	public static String getCellData(int rowNumber, int cellNumber) {
		DataFormatter dataFormatter = new DataFormatter();
		cell = sheet.getRow(rowNumber).getCell(cellNumber);
		String value = dataFormatter.formatCellValue(cell);
		return value;
	}
	
	public static int getRowCountInSheet() {
		int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		return rowcount;
	}

	public static int getColumnCountInSheet(int i) {
		int cellcount = sheet.getRow(i).getLastCellNum();
		return cellcount;
	}

	public static void setCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {

		sheet.getRow(rowNum).getCell(cellNum).setCellValue(cellValue);
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
	}

	public static void createCellValue(int rowNum, int cellNum, String cellValue, String excelFilePath) throws IOException {

		sheet.getRow(rowNum).createCell(cellNum).setCellValue(cellValue);
		FileOutputStream outputStream = new FileOutputStream(excelFilePath);
		workbook.write(outputStream);
	}

}
