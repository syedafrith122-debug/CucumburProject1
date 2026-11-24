package org.reuseable;

import org.openqa.selenium.WebDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Select s;
	public static Alert e;

	public static void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	// web driver method
	public static void closeBrowser() {
		driver.close();
	}

	public static void quitBrowser() {
		driver.quit();
	}

	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public static void minimizeWindow() {
		driver.manage().window().minimize();
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateFront() {
		driver.navigate().forward();
	}

	public static void refreshPage() {
		driver.navigate().refresh();
	}

	public static void getCurrentUrl() {
		driver.getCurrentUrl();
	}

	// WebElement Methods

	public static void sendKeys(WebElement ele, String data) {
		ele.sendKeys(data);
	}

	public static void click(WebElement ele) {
		ele.click();
	}

	public static void clear(WebElement ele) {
		ele.clear();
	}


	// JavaScriptExeutor
	public static void jsClick(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public static void jsSendKeys(WebElement ele, String data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + data + "');", ele);
	}

	public static void jsScrollIntoView(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}

	public static String jsGetAttribute(WebElement ele,String Data) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (String) js.executeScript("return arguments[0].getAttribute('value');", ele);
	}

	// Take Screen Shot
	public static void takesnap(String name) throws IOException {
		TakesScreenshot t = (TakesScreenshot) driver;
		File temp = t.getScreenshotAs(OutputType.FILE);
		File taget = new File("C:\\Users\\AFRITH\\eclipse-workspace\\SampleMaven\\images" + name + ".png");
		FileUtils.copyFile(temp, taget);

	}

	// Select Method
	public static void selectByText(WebElement ele, String text) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}

	public static void selectByValue(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}

	public static void selectByIndex(WebElement ele, int index) {
		Select s = new Select(ele);
		s.selectByIndex(index);
	}

	// Actions method
	public static void mouseHover(WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}

	public static void rightClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.contextClick(ele).perform();
	}

	public static void doubleClick(WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	public static void dragAndDrop(WebElement src, WebElement desc) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, desc).perform();
	}

	// Robot method
	public static void robotEnter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void robotTab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public static void robotDown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	// Alert method

	public static void alertAccept() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public static void alertDismiss() {
		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public static void alertSendKeys(String text) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(text);
	}

	public static String alertGetText() {
		Alert a = driver.switchTo().alert();
		return a.getText();
	}

	// iframe
	public static void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void switchToFrameByNameOrId(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public static void switchToFrameByElement(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	// wait method

	public static WebElement waitForVisibility(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickability(By locator, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void waitForAlert(int seconds) {
		FluentWait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void waitForVisibility(WebElement ele, int seconds) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		w.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public static void pageLoadTimeout(int seconds) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
	}

	public static String getFromExcel(int shtid, int r, int c) throws Exception {
		File f = new File("C:\\Users\\AFRITH\\eclipse-workspace\\SampleMaven\\Excel\\Adactin data.xlsxs.xlsx");

		FileInputStream fs = new FileInputStream(f);

		Workbook book = new XSSFWorkbook(fs);

		Sheet sheet = book.getSheetAt(shtid);

		Row row = sheet.getRow(r);

		Cell cell = row.getCell(c);

		int Type = cell.getCellType();
		
		String value = "";
		if (Type == 1) {
			 value = cell.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
			value = sdf.format(date);
		} else {
			double dd = cell.getNumericCellValue();
			long l = (long) dd;
			value = String.valueOf(l);

		}
		return value;
	}



public static void writeToExcel(int sheetInd, int r, int c, String data) throws IOException {

    File f=new File("C:\\Users\\AFRITH\\eclipse-workspace\\SampleMaven\\Excel\\Adactin data.xlsxs.xlsx");

    

    Workbook book = new XSSFWorkbook();

    Sheet sht = book.getSheetAt(0);

    Row rw = sht.getRow(1);

    Cell cl = rw.getCell(9);

    cl.setCellValue("");

    FileOutputStream fo= new FileOutputStream(f);

    book.write(fo);
}

public static void updateToExcel(String sheetName, int r, int c, String data) throws IOException {

	File fs = new File("C:\\Users\\AFRITH\\eclipse-workspace\\SampleMaven\\Excel\\Adactin data.xlsxs.xlsx");

    FileInputStream f = new FileInputStream(fs);

    Workbook book = new XSSFWorkbook(f);

    Sheet sht = book.getSheet(sheetName);

    Row rw = sht.getRow(r);

    Cell cl = rw.getCell(c);

    cl.setCellValue(data);

    f.close();

    FileOutputStream fo = new FileOutputStream(fs);

    book.write(fo);



}

}




