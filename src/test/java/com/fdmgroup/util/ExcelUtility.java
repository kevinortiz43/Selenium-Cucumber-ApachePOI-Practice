package com.fdmgroup.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fileInput;
	public FileOutputStream fileOutput;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;

	public ExcelUtility() {

	}

	public ExcelUtility(String path) {
		this.path = path;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File excelFile = new File(path);
		if (!excelFile.exists()) {
			workbook = new XSSFWorkbook();
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
		}

		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);

		if (workbook.getSheetIndex(sheetName) == -1)
			workbook.createSheet(sheetName);

		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rownum) == null)
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);

		cell = row.createCell(colnum);
		cell.setCellValue(data);

		fileOutput = new FileOutputStream(path);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();
	}

	public List<Map<String, String>> getData(String excelFilePath, String sheetName)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByName(excelFilePath, sheetName);
		return readSheet(sheet);
	}

	public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
			throws InvalidFormatException, IOException {
		Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
		return readSheet(sheet);
	}

	private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
		return sheet;
	}

	private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
		Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
		return sheet;
	}

	private Workbook getWorkBook(String excelFilePath) throws IOException, InvalidFormatException {
		return WorkbookFactory.create(new File(excelFilePath));
	}

	public void customHeaders(String sheetName, int rownum, int colnum, String data, String color) throws IOException {
		File excelFile = new File(path);
		if (!excelFile.exists()) {
			workbook = new XSSFWorkbook();
			fileOutput = new FileOutputStream(path);
			workbook.write(fileOutput);
		}

		fileInput = new FileInputStream(path);
		workbook = new XSSFWorkbook(fileInput);

		if (workbook.getSheetIndex(sheetName) == -1)
			workbook.createSheet(sheetName);

		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rownum) == null)
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);

		XSSFSheet sheet = workbook.getSheet(sheetName);
		XSSFRow row = sheet.getRow(rownum);
		XSSFCell cell = row.getCell(colnum);

		XSSFCellStyle style = workbook.createCellStyle();
		style.setFillForegroundColor(getColorByName(color).getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);

		try (FileOutputStream fo = new FileOutputStream(path)) {
			workbook.write(fo);
		}
	}

	private IndexedColors getColorByName(String colorName) {
		switch (colorName.toUpperCase()) {
		case "AQUA":
			return IndexedColors.AQUA;
		case "BLACK":
			return IndexedColors.BLACK;
		case "BLUE":
			return IndexedColors.BLUE;
		case "BLUE_GREY":
			return IndexedColors.BLUE_GREY;
		case "BRIGHT_GREEN":
			return IndexedColors.BRIGHT_GREEN;
		case "BROWN":
			return IndexedColors.BROWN;
		case "CORAL":
			return IndexedColors.CORAL;
		case "CORNFLOWER_BLUE":
			return IndexedColors.CORNFLOWER_BLUE;
		case "DARK_BLUE":
			return IndexedColors.DARK_BLUE;
		case "DARK_GREEN":
			return IndexedColors.DARK_GREEN;
		case "DARK_RED":
			return IndexedColors.DARK_RED;
		case "DARK_TEAL":
			return IndexedColors.DARK_TEAL;
		case "DARK_YELLOW":
			return IndexedColors.DARK_YELLOW;
		case "GOLD":
			return IndexedColors.GOLD;
		case "GREEN":
			return IndexedColors.GREEN;
		case "GREY":
			return IndexedColors.GREY_50_PERCENT;
		case "INDIGO":
			return IndexedColors.INDIGO;
		case "LAVENDER":
			return IndexedColors.LAVENDER;
		case "LEMON_CHIFFON":
			return IndexedColors.LEMON_CHIFFON;
		case "LIGHT_BLUE":
			return IndexedColors.LIGHT_BLUE;
		case "LIGHT_CORNFLOWER_BLUE":
			return IndexedColors.LIGHT_CORNFLOWER_BLUE;
		case "LIGHT_GREEN":
			return IndexedColors.LIGHT_GREEN;
		case "LIGHT_ORANGE":
			return IndexedColors.LIGHT_ORANGE;
		case "LIGHT_TURQUOISE":
			return IndexedColors.LIGHT_TURQUOISE;
		case "LIGHT_YELLOW":
			return IndexedColors.LIGHT_YELLOW;
		case "LIME":
			return IndexedColors.LIME;
		case "MAROON":
			return IndexedColors.MAROON;
		case "OLIVE_GREEN":
			return IndexedColors.OLIVE_GREEN;
		case "ORANGE":
			return IndexedColors.ORANGE;
		case "ORCHID":
			return IndexedColors.ORCHID;
		case "PALE_BLUE":
			return IndexedColors.PALE_BLUE;
		case "PINK":
			return IndexedColors.PINK;
		case "PLUM":
			return IndexedColors.PLUM;
		case "RED":
			return IndexedColors.RED;
		case "ROSE":
			return IndexedColors.ROSE;
		case "ROYAL_BLUE":
			return IndexedColors.ROYAL_BLUE;
		case "SEA_GREEN":
			return IndexedColors.SEA_GREEN;
		case "SKY_BLUE":
			return IndexedColors.SKY_BLUE;
		case "TAN":
			return IndexedColors.TAN;
		case "TEAL":
			return IndexedColors.TEAL;
		case "TURQUOISE":
			return IndexedColors.TURQUOISE;
		case "VIOLET":
			return IndexedColors.VIOLET;
		case "WHITE":
			return IndexedColors.WHITE;
		case "YELLOW":
			return IndexedColors.YELLOW;
		default:
			return null;
		}
	}

	private List<Map<String, String>> readSheet(Sheet sheet) {
		List<Map<String, String>> excelRows = new ArrayList<>();
		int headerRowNumber = getHeaderRowNumber(sheet);

		if (headerRowNumber != -1) {
			int totalColumn = sheet.getRow(headerRowNumber).getPhysicalNumberOfCells();

			for (int rowIndex = headerRowNumber + 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row != null) {
					Map<String, String> columnMapData = new LinkedHashMap<>();
					for (int columnIndex = 0; columnIndex < totalColumn; columnIndex++) {
						columnMapData.putAll(getCellValue(sheet, row, columnIndex));
					}
					excelRows.add(columnMapData);
				}
			}
		}
		return excelRows;
	}

	private int getHeaderRowNumber(Sheet sheet) {
		for (Row row : sheet) {
			for (Cell cell : row) {
				// Check cell type
				switch (cell.getCellType()) {
				case STRING:
				case NUMERIC:
				case BOOLEAN:
				case ERROR:
					return row.getRowNum();
				default:
					break;
				}
			}
		}
		return -1;
	}

	private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
		LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<>();
		Cell cell;

		String columnHeaderName = sheet.getRow(sheet.getFirstRowNum())
				.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();

		if (row != null) {
			cell = row.getCell(currentColumn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
			switch (cell.getCellType()) {
			case STRING:
				columnMapdata.put(columnHeaderName, cell.getStringCellValue());
				break;
			case NUMERIC:
				columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
				break;
			case BOOLEAN:
				columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
				break;
			case ERROR:
				columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
				break;
			default:
				columnMapdata.put(columnHeaderName, "");
				break;
			}
		} else {
			columnMapdata.put(columnHeaderName, "");
		}

		return columnMapdata;
	}
}
