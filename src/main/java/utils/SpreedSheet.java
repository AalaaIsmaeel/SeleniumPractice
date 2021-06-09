package utils;
import java.io.File;

import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;


import io.qameta.allure.Step;

public class SpreedSheet {
	/*private File file;
    private static XSSFSheet sheet;
    
    public SpreedSheet(String fileName,String sheetName) throws IOException {
         file = new File(fileName);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook WB = new XSSFWorkbook(inputStream);
        sheet = WB.getSheet(sheetName);
    }
    @Step("Get data from excel sheet with the row number :{RN} and cell number:{CN}")
    public static String getData(int RN, int CN) {
        DataFormatter formatter = new DataFormatter();
        String field = formatter.formatCellValue(sheet.getRow(RN).getCell(CN));
        return field;
    }
}*/
	
	
	private File spreedSheet;
	private Sheet currentSheet;
	private Map<String, Integer> columns;

	// create constractor that takes a file which is defines as spreedsheet
	// define my excel sheet = file that supposed to be passed for the constractor

	public SpreedSheet(File file) {
		spreedSheet = file;
		columns = new HashMap<String, Integer>();
	    }
    // Define columns title and ge columns cell value
	 public void switchToSheet(String name) {
			try (var workbooks = WorkbookFactory.create(spreedSheet)) {
			    currentSheet = workbooks.getSheet(name);
			    currentSheet.getRow(0).forEach(cell -> {
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			    });
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    }

		    public String getCellData(String column, int row) {
			var dataRow = currentSheet.getRow(row - 1);
			return getCellDataAsString(dataRow.getCell(columns.get(column)));
		    }

		    private String getCellDataAsString(Cell cell) {
			return switch (cell.getCellType()) {
			case STRING -> cell.getStringCellValue();
			case NUMERIC -> String.valueOf((int) cell.getNumericCellValue());
			default -> "";
			};
		    }

}
