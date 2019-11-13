package com.automationpractice.utilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

public class DriverHelper {
	
    private String mainWindowhandle;
    private WebDriver driver;
	
	public DriverHelper ( WebDriver driver ) {
		this.driver = driver;
	}
    
    public void openUrl(String url) {
    	driver.get(url);
    	mainWindowhandle = driver.getWindowHandle();
    }
    
    public String getMainWindowhandle () {
    	return mainWindowhandle;
    }
    
    public void waitForElementVisibility ( By by, int timeOutInSeconds ) {
        new WebDriverWait(driver, timeOutInSeconds).
        until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    
    public WebElement getElement ( By by, int timeOutInSeconds ) {
        waitForElementVisibility(by, timeOutInSeconds);
        return driver.findElement(by);
    }
    
    public WebElement getElement ( By by, int index, int timeOutInSeconds ) {
        waitForElementVisibility(by, timeOutInSeconds);
        return driver.findElements(by).get(index - 1);
    }
    
    public List<WebElement> getElements ( By by, int timeOutInSeconds ) {
        waitForElementVisibility(by, timeOutInSeconds);
        return driver.findElements(by);
    }
    
    public void clickByLinkText ( String linkText, int timeOutInSeconds ) {
    	click(By.linkText(linkText), timeOutInSeconds);
    }
    
    public void click ( By by, int timeOutInSeconds ) {
        getElement(by, timeOutInSeconds).click();
//        Reporter.step.info("Clicked on element");
    }
    
    public void click ( By by, int index, int timeOutInSeconds ) {
    	//getElements return all web element
    	//.get(index) return an object of WebElement
        getElements(by, timeOutInSeconds).get(index - 1).click();
    }
    
    public void clickById ( String id, int timeOutInSeconds ) {
        getElement(By.id(id), timeOutInSeconds).click();
    }
    
    public void clickByXpath(String xpath, int timeOutInSeconds) {
    	getElement(By.xpath(xpath), timeOutInSeconds).click();
    }
    
    public void sendKeys ( By by, String text, int timeOutInSeconds ) {
    	WebElement textBox = getElement(by, timeOutInSeconds);
    	textBox.clear();
        textBox.sendKeys(text);
    }
    
    public String getText ( By by, int timeOutInSeconds ) {
        return getElement(by, timeOutInSeconds).getText().replaceAll("\\s+", " ").trim();
    }
    
    public void takeScreenshot () {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        // getScreenshotAs method to create image file
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            //Move image file to new destination
            //Copy file at destination
            FileUtils.copyFile(file, new File(System.getProperty("user.dir")  + "/target/screenshots"
                    + "/FileName" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static String takeScreenshotForReporting (WebDriver driver) {
        	long ms =System.currentTimeMillis();
        	String path = System.getProperty("user.dir")  + "/target/screenshots"
                    + "/FileName" + ms;
        	
        	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            // getScreenshotAs method to create image file
            File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
            try {
                //Move image file to new destination
                //Copy file at destination
                FileUtils.copyFile(file, new File(path + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            return path+".png";
        }
   
    
	public void switchToNewWindow() {
		Set<String> handles=driver.getWindowHandles();
		
		for(String h:handles) {
			if(h.equals(mainWindowhandle)) {
				System.out.println("driver will not switch");
			}else {
				driver.switchTo().window(h);
			}
		}
	}
	
	public void switchToMainWindow() {
		driver.switchTo().window(mainWindowhandle);
	}
	
	private void executeJS ( String script, WebElement webElement ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(script, webElement);
	}
	
	public void click1 ( By by ) {
		try {
			click(by, 15);
		} catch ( WebDriverException e ) {
//			Common.sleep(1);
			scrollToElement(by);
			click(by, 15);
		}
	}
	
	public void click2 ( By by ) {
		try {
			click(by, 15);
		} catch ( WebDriverException e ) {
			jsClick(by);
		}
	}
	
	public void jsClick ( By by ) {
		WebElement webElement = driver.findElement(by);
		executeJS("arguments[0].click()", webElement);
	}
	
	public void scrollToElement ( By by ) {
		WebElement webElement = getElement(by, 15);
		executeJS("arguments[0].scrollIntoView(true)", webElement);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true)", webElement);
	}
	
	public void scrollToElement ( int x, int y ) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(" + x + ", " + y + ")");
	}
	
	public void highlightElement ( By by ) {
		WebElement webElement = getElement(by, 15);
		executeJS("arguments[0].style.border='3px dotted red'", webElement);
	}
	
	public void validateEquals ( By by, String expectedText ) {
		if ( !getText(by, 15).equals(expectedText) ) {
			highlightElement(by);
			takeScreenshot();
			assertEquals(getText(by, 15), expectedText);
		}
	}
	
	public void validateEquals ( String actualText, String expectedText ) {
		if ( !actualText.equals(expectedText) ) {
//			JavascriptExecutor js = (JavascriptExecutor) driver;
//			js.executeScript("arguments[0].style.border='3px dotted red'", webElement);
			takeScreenshot();
			assertEquals(actualText, expectedText);
//			throw new AssertionError();
		}
	}
}


