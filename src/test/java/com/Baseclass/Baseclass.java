package com.Baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Baseclass {

	WebDriver driver;

	public void browserLaunchSetup(String Url) {

		driver = new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();

	}

	public void  findelementsbytagname(String tagname) {

		List<WebElement> findElements = driver.findElements(By.tagName(tagname));
	}

	public WebElement findbyid(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;

	}

	public WebElement findbyname(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;

	}

	public WebElement findbyclass(String className) {

		WebElement findElement = driver.findElement(By.className(className));
		return findElement;

	}

	public WebElement findbyxpath(String xpath) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		return findElement;

	}

	public void enterText(WebElement element, String text) {

		element.sendKeys(text);

	}

	public void EntertoFrame(WebElement element) {
		driver.switchTo().frame(element);

	}

	public void ExitfromFrame() {

		driver.switchTo().defaultContent();

	}

	public void close() {
		driver.close();

	}

	String data = null;

	public String readData(String SheetName, int Rowno, int cellno) throws IOException {

		File file = new File("C:\\Users\\Prasanth\\eclipse-workspace\\Singleton\\Excel\\Readdata.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(SheetName);
		Row row = sheet.getRow(Rowno);
		Cell cell = row.getCell(cellno);
		CellType type = cell.getCellType();

		if (type.equals(1)) {

			data = cell.getStringCellValue();

		}

		if (type.equals(0)) {

			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
				data = format.format(date);

			} else {
				double d = cell.getNumericCellValue();

				long l = (long) d;

				data = String.valueOf(l);

			}
		}
		return data;

	}

}
