package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;



public class Reusable {

	public static File screenshotFiles;
	protected static WebDriver driver;
	protected static WebElement element;
	protected static List<WebElement> webElementlist;
	public static int waittime = 30;
	
	protected static String totalAmount_expected;
	protected static String totalAmount_actual;
	

	public static void Launch_Browser_and_Application(String url) throws IOException, InterruptedException, AWTException {

		String driver_path = System.getProperty("user.dir") + "\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driver_path);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);

		// Zoom-out to 80%
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_MINUS);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_MINUS);
	}

	public static void addAgentAvailability(By bylocator1, By bylocator2) {
		WebElement ele = findElement(bylocator1);
		WebElement ele2 = findElement(bylocator2);
		Actions act = new Actions(driver);
		act.moveToElement(ele).moveToElement(ele2).click().build().perform();
	}

	public static void RightClick(By bylocator) throws InterruptedException {
		element = findElement(bylocator);
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public static void Waituntil(By bylocator, int secToWait) throws UnhandledAlertException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, secToWait);
			wait.until(ExpectedConditions.visibilityOfElementLocated(bylocator));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void WaituntilClickable(By bylocator, int secToWait) throws UnhandledAlertException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, secToWait);
			wait.until(ExpectedConditions.elementToBeClickable(bylocator));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void WaituntilElementNotFound(By bylocator, int secToWait) throws UnhandledAlertException {
		try {
			WebDriverWait wait = new WebDriverWait(driver, secToWait);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(bylocator));
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static void checkElementPresent(By bylocator, int howLongToWait) {
		WebDriverWait wait = new WebDriverWait(driver, howLongToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(bylocator));
	}

	public static void WaitUntilEleNotPresent(By bylocator, int howLongToWait) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, howLongToWait);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(bylocator));
		} catch (TimeoutException e) {
			System.out.println("Waiting time exceeded than what is expected");
		} catch (UnhandledAlertException e) {
			System.out.println(e);
		}
	}

	public void waitUntilElementNotPresent(By bylocator) throws InterruptedException {
		for (int i = 0; i < 500; i++) {
			if ((findElement(bylocator).isDisplayed()) == true) {
				Thread.sleep(2000);
			} else {
				break;
			}
		}
	}

	public static void InputText(By bylocator, String TexttoBeTyped) {
		Waituntil(bylocator, 10);
		element = driver.findElement(bylocator);
		if (element.isDisplayed() && element.isEnabled()) {
			element.sendKeys(TexttoBeTyped);
		}
	}

	public static void SwitchFrame(By bylocator) {
		try {
			Waituntil(bylocator, 30);
			WebElement frameXpath = findElement(bylocator);
			driver.switchTo().frame(frameXpath);
		} catch (UnhandledAlertException e) {
			System.out.println(e);
		}
	}

	// Usage - Exit from Child to Parent Frame
	public static void ExitFrame() {
		driver.switchTo().defaultContent();
	}

	public static void SelectFromDropDown_ByText(By bylocator, String ElementToSelect) {
		Waituntil(bylocator, 30);
		Select dropdown = new Select(driver.findElement(bylocator));
		dropdown.selectByVisibleText(ElementToSelect);
	}

	public void SelectFromDropDown_ByIndex(By bylocator, int Index) {
		Waituntil(bylocator, 30);
		Select dropdown = new Select(driver.findElement(bylocator));
		dropdown.selectByIndex(Index);
	}

	public static void ClickOn(By bylocator) throws InterruptedException {
		try {
			Waituntil(bylocator, 30);
			element = driver.findElement(bylocator);
			if (element.isDisplayed() && element.isEnabled()) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", element);
				driver.findElement(bylocator).click();
			}
		} catch (ElementClickInterceptedException a) {
			System.out.println(a.getMessage());
		} catch (ElementNotFoundException b) {
			System.out.println(b.getMessage());
		} catch (ElementNotVisibleException c) {
			System.out.println(c.getMessage());
		} catch (ElementNotInteractableException d) {
			System.out.println(d.getMessage());
		} catch (UnhandledAlertException e) {
			System.out.println(e);
		}
	}

	public static void WaitClick(By bylocator) throws InterruptedException {
		try {
			WaituntilClickable(bylocator, 30);
			element = driver.findElement(bylocator);
			if (element.isDisplayed() && element.isEnabled()) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].scrollIntoView(true);", element);
				driver.findElement(bylocator).click();
			}
		} catch (ElementClickInterceptedException a) {
			System.out.println(a.getMessage());
		} catch (ElementNotFoundException b) {
			System.out.println(b.getMessage());
		} catch (ElementNotVisibleException c) {
			System.out.println(c.getMessage());
		} catch (ElementNotInteractableException d) {
			System.out.println(d.getMessage());
		} catch (UnhandledAlertException e) {
			System.out.println(e);
		}
	}

	// Click Using JSE
	public void ClickOn_UsingJSE(By bylocator) throws InterruptedException {
		try {
			Waituntil(bylocator, 30);
			element = driver.findElement(bylocator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			if (element.isDisplayed() && element.isEnabled()) {
				executor.executeScript("arguments[0].click();", element);
			}
		} catch (ElementClickInterceptedException a) {
			System.out.println(a.getMessage());
		} catch (ElementNotFoundException b) {
			System.out.println(b.getMessage());
		} catch (ElementNotVisibleException c) {
			System.out.println(c.getMessage());
		} catch (ElementNotInteractableException d) {
			System.out.println(d.getMessage());
		} catch (UnhandledAlertException e) {
			System.out.println(e);
		}
	}

	// Usage - Click using Selenium action class
	public static void ClickUsingActions(By bylocator) {
		Waituntil(bylocator, 10);
		element = driver.findElement(bylocator);
		Actions act = new Actions(driver);
		act.click(element).build().perform();
	}

	public static WebElement findElement(By bylocator) {
		element = driver.findElement(bylocator);
		return element;
	}

	public static List<WebElement> findElements(By bylocator) {
		webElementlist = driver.findElements(bylocator);
		return webElementlist;
	}

	public static boolean isElementPresent(By locator) {
		boolean elePresent;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try {
			if (wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed()) {
				elePresent = true;
			} else {
				elePresent = false;
			}
		} catch (TimeoutException e) {
			elePresent = false;
		} catch (ElementNotFoundException e) {
			elePresent = false;
		}
		return elePresent;
	}

	public static void SimpleClick(By bylocator) {
		Waituntil(bylocator, 10);
		driver.findElement(bylocator).click();
	}

	public static void WaitUntil_TextIsDisplayed(By bylocator, int howLongToWait) {
		WebDriverWait wait = new WebDriverWait(driver, howLongToWait);
		wait.until(ExpectedConditions.visibilityOfElementLocated(bylocator));
	}

	public static void mouseHover(By Bylocator) {
		WebElement ele2 = findElement(Bylocator);
		Actions act = new Actions(driver);
		act.moveToElement(ele2).click().build().perform();
	}

	public static void Refresh_Page() {
		driver.navigate().refresh();
	}

	public static void ScrollToElement(By bylocator) {
		element = driver.findElement(bylocator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void ClearInputText(By locator) throws InterruptedException {
		driver.findElement(locator).clear();
		Thread.sleep(1000);
	}

	public static void ScrollToBottom() throws InterruptedException {
		Actions a = new Actions(driver);
		// scroll down a page
		for (int i = 0; i <= 1; i++) {
			a.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(1500);
		}
	}

	public static void ScrollTop() {
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.HOME);
	}

	public static void Close_Current_tab() {
		driver.close();
	}

	public static void Close_Browser() {
		driver.quit();
	}

	public static void ClickAndInput(By firstclick, By secondclick, String inputdata) throws InterruptedException {
		driver.findElement(firstclick).click();
		Thread.sleep(1000);
		driver.findElement(secondclick).sendKeys(inputdata);
	}

	// Usage - HIT Keyboard ENTER key
	public void InputKeyboard_Event_ENTER(By bylocator) {
		driver.findElement(bylocator).sendKeys(Keys.ENTER);
	}

	public static void ClickDownArrow_and_HitEnter(By bylocator) throws InterruptedException {
		driver.findElement(bylocator).sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
		Thread.sleep(2000);
	}

}