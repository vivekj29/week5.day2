package week5.day2assignments;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public String[][] readData(String filename) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./data/" + filename + ".xlsx");
		XSSFSheet ws = wb.getSheet("Sheet1");
		int rowCt = ws.getLastRowNum();
		int cellCt = ws.getRow(0).getLastCellNum();

		String[][] data = new String[rowCt][cellCt];

		for (int i = 1; i <= rowCt; i++) {
			for (int j = 0; j < cellCt; j++) {
				String text = ws.getRow(i).getCell(j).getStringCellValue();
				System.out.println(text);
				data[i-1][j] = text;

			}
		}

		wb.close();
		return data;
	}

}
