package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public static int totalRow;

	public List<Map<String, String>> getData(String Excelpath, String Sheetname)
			throws IOException, InvalidFormatException {
		FileInputStream inputstream = new FileInputStream(Excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);		
		XSSFSheet sheet = workbook.getSheet(Sheetname);
		workbook.close();
		return readSheet(sheet);
	}	

	private List<Map<String, String>> readSheet(XSSFSheet sheet){
		XSSFRow row;
		XSSFCell cell;
		totalRow = sheet.getLastRowNum();
		List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
		for (int currentRow = 0; currentRow <= totalRow; currentRow++) {
			row = sheet.getRow(currentRow);			
			int totalColumn = row.getLastCellNum();			
			LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
			for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
				cell = row.getCell(currentColumn);	
				String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn).getStringCellValue();				
				columnMapdata.put(columnHeaderName, cell.getStringCellValue());
			}
			excelRows.add(columnMapdata);			
		}
		return excelRows;	}

	public int countRow() {
		return totalRow;
	}
}
