package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfiguration {

	Workbook wb;
	Sheet sheet1;

	public ExcelDataConfiguration(String fileName) {
		try {
			File src = new File("C://EspedAutomation//DATA//testData//" + fileName);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getData(int sheet, int row, int column) {
		sheet1 = wb.getSheetAt(sheet);
		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(sheet1.getRow(row).getCell(column));
		return data;
	}

	public String getRandomData(int sheet, int column) {
		sheet1 = wb.getSheetAt(sheet);
		int totalrows = sheet1.getPhysicalNumberOfRows();

		Random random = new Random();
		int randomrow = random.nextInt(totalrows);

		String data = sheet1.getRow(randomrow).getCell(column).getStringCellValue();
		return data;
	}

}