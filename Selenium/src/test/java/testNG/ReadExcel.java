package testNG;

import java.io.FileInputStream;
import java.io.IOException;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	public String[][] getCellData(String path, String sheetName) throws IOException {
		FileInputStream stream = new FileInputStream(path);
		Workbook workbook = WorkbookFactory.create(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();
		String data[][] = new String[rowcount][cellcount];

		for (int i = 1; i <= rowcount; i++) {
			Row r = sheet.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				Cell c = r.getCell(j);
				try {
					if (c.getCellType() == CellType.STRING) {
						data[i - 1][j] = c.getStringCellValue();
					} else {
						data[i - 1][j] = String.valueOf(c.getNumericCellValue());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
}