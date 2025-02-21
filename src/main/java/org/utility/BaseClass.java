package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	// browser launch 1
	public static WebDriver launchBrowser(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		return driver;
		
	}

	// browser launch 2
	public static WebDriver browser(String browserName) {
		switch (browserName) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		return driver;

	}

	// browser launch 3
	public static WebDriver chromeBrowser() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver firefoxBrowser() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		return driver;
	}

	public static WebDriver edgeBrowser() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		return driver;
	}

	// incognito browser launch 4
	public static WebDriver chromeIncognito() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--incognito");
		driver = new ChromeDriver(op);
		return driver;
	}
	
	// url launch
	public static void urlLaunch(String url) {

		driver.get(url);
	}

	// maximize
	public static void maximize() {

		driver.manage().window().maximize();
	}

	// duration
	public static void implicitWait(long secs) {

		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}

	// sendkeys
	public static void sendkeys(WebElement e, String value) {

		e.sendKeys(value);
	}

	// clear
	public static void clear(WebElement e) {

		e.clear();
	}

	// click
	public static void click(WebElement e) {

		e.click();
	}

	// current url print
	public static String currentUrl() {

		String url = driver.getCurrentUrl();
		return url;

	}

	// current title print
	public static String title() {

		String title = driver.getTitle();
		return title;
	}

	// close the current tab
	public static void close() {

		driver.close();
	}

	// close the browser
	public static void quit() {

		driver.quit();
	}

	// print the text from webpage
	public static String getText(WebElement e) {

		String txt = e.getText();
		return txt;
	}

	public static String getAttribute(WebElement e) {

		String att = e.getAttribute("value");
		return att;
	}

	public static String getInnerText(WebElement e) {

		String att = e.getAttribute("innerText");
		return att;
	}

	// mouse actions
	public static void moveToElement(WebElement e) {

		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	public static void dragAndDrop(WebElement e1, WebElement e2) {
		Actions a = new Actions(driver);
		a.dragAndDrop(e1, e2).perform();
	}

	public static void dragAndDropby(WebElement e, int x, int y) {
		Actions a = new Actions(driver);
		a.dragAndDropBy(e, x, y).perform();
	}

	public static void clickAndHoldRelease(WebElement e1, WebElement e2) {
		Actions a = new Actions(driver);
		a.clickAndHold(e1).release(e2).perform();
	}

	public static void clickAndHold(WebElement e1) {
		Actions a = new Actions(driver);
		a.clickAndHold(e1).perform();
	}

	public static void release(WebElement e2) {
		Actions a = new Actions(driver);
		a.release(e2).perform();
	}

	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	public static void rightClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e);
	}

	// robot class
	public static void downKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}

	public static void upKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}

	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void controlKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_CONTROL);
	}

	public static void selectAll() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_A);
	}

	public static void copy() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_C);
	}

	public static void paste() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
	}

	public static void cut() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_X);
		r.keyRelease(KeyEvent.VK_X);
	}

	public static void save() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_S);
		r.keyRelease(KeyEvent.VK_S);
	}

	public static void tab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public static void alt() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ALT);
		r.keyRelease(KeyEvent.VK_ALT);
	}

	public static void shift() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_SHIFT);
		r.keyRelease(KeyEvent.VK_SHIFT);
	}

	public static void leftArrow() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_LEFT);
		r.keyRelease(KeyEvent.VK_LEFT);
	}

	public static void rightArrow() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_RIGHT);
		r.keyRelease(KeyEvent.VK_RIGHT);
	}

	// drop and down
	public static void selectByIndex(WebElement e, int i) {

		Select s = new Select(e);
		s.selectByIndex(i);
	}

	public static void selectByValue(WebElement e, String value) {

		Select s = new Select(e);
		s.selectByValue(value);
	}

	public static void selectByVisibleText(WebElement e, String text) {

		Select s = new Select(e);
		s.selectByVisibleText(text);
	}

	public static void selectAll(WebElement e, int count) {

		Select s = new Select(e);
		for (int i = 0; i < count; i++) {
			s.selectByIndex(i);
		}
	}

	// screenshot
	public static void screenShot(String screenName) throws IOException {

		TakesScreenshot tk = (TakesScreenshot) driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File dec = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Screenshots\\" + screenName +"_"+System.currentTimeMillis()+".png");
		FileUtils.copyFile(src, dec);
	}

	// java script executor

	public static void jsSendKeys(WebElement e, String name) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + name + "')", e);

	}

	public static void jsClick(WebElement e) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);

	}

	public static void jsScrollDown(WebElement e) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	public static void jsScrollUp(WebElement e) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);
	}

	public static Object jsPrint(WebElement e) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object es = js.executeScript("return arguments[0].getAttribute('value')", e);
		return es;
	}

	// Web Table
	public static void webTable(WebElement e, String txt) {

		List<WebElement> rows = e.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size(); i++) {
			WebElement row = rows.get(i);
			List<WebElement> datas = row.findElements(By.tagName("td"));
			for (int j = 0; j < datas.size(); j++) {
				WebElement data = datas.get(j);
				String text = data.getText();
				if (text.equalsIgnoreCase(txt)) {
					click(data);
				}
			}
		}

	}

	// frames
	public static void frame(WebElement e) {

		driver.switchTo().frame(e);
	}

	public static void defaultContent() {

		driver.switchTo().defaultContent();
	}

	public static void parentFrame() {

		driver.switchTo().parentFrame();
	}

	// Windows Handling
	public static void windowsHandling() {

		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for (String eachId : allId) {
			if (!parentId.equals(eachId)) {
				driver.switchTo().window(eachId);
			}
		}
	}

	public static void windowsHandlingIndex(int a) {

		Set<String> allId = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(allId);
		driver.switchTo().window(li.get(a));
	}

	// Excel Read from File
	public static String excelRead(String filename, String sheet, int row, int cell) throws IOException {

		File f1 = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + filename + ".xlsx");
		FileInputStream fo = new FileInputStream(f1);
		Workbook w = new XSSFWorkbook(fo);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);

		int type = c.getCellType();
		String value;
		if (type == 1) {
			value = c.getStringCellValue();
		} else {
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat s1 = new SimpleDateFormat("dd-MM-yy");
				value = s1.format(d);

			} else {
				double d = c.getNumericCellValue();
				long l = (long) d;
				value = String.valueOf(l);

			}
		}
		return value;

	}

}
