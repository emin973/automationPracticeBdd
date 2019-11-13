package com.automationpractice.utilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class DriverListener implements WebDriverEventListener {

	private Logger logger = Logger.getLogger(DriverListener.class);
	
	@Override
	public void beforeAlertAccept ( WebDriver driver ) {
		logger.info("beforeAlertAccept");
	}

	@Override
	public void afterAlertAccept ( WebDriver driver ) {
		logger.info("afterAlertAccept");
	}

	@Override
	public void afterAlertDismiss(WebDriver driver) {
		logger.info("afterAlertDismiss");
	}

	@Override
	public void beforeAlertDismiss(WebDriver driver) {
		logger.info("beforeAlertDismiss");
	}

	@Override
	public void beforeNavigateTo(String url, WebDriver driver) {
		logger.info("beforeNavigateTo");
	}

	@Override
	public void afterNavigateTo ( String url, WebDriver driver ) {
		logger.info("afterNavigateTo");
	}

	@Override
	public void beforeNavigateBack(WebDriver driver) {
		logger.info("beforeNavigateBack");
	}

	@Override
	public void afterNavigateBack ( WebDriver driver ) {
		logger.info("afterNavigateBack");	
	}

	@Override
	public void beforeNavigateForward(WebDriver driver) {
		logger.info("beforeNavigateForward");
	}

	@Override
	public void afterNavigateForward(WebDriver driver) {
		logger.info("afterNavigateForward");
	}

	@Override
	public void beforeNavigateRefresh(WebDriver driver) {
		logger.info("beforeNavigateRefresh");
	}

	@Override
	public void afterNavigateRefresh(WebDriver driver) {
		logger.info("afterNavigateRefresh");
	}

	@Override
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("beforeFindBy");
	}

	@Override
	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		logger.info("afterFindBy");
	}

	@Override
	public void beforeClickOn ( WebElement element, WebDriver driver ) {
		logger.info("beforeClickOn");
	}

	@Override
	public void afterClickOn ( WebElement element, WebDriver driver ) {
		logger.info("afterClickOn");
	}

	@Override
	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		logger.info("beforeChangeValueOf");
	}

	@Override
	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		logger.info("afterChangeValueOf");
	}

	@Override
	public void beforeScript(String script, WebDriver driver) {
		logger.info("beforeScript");
	}

	@Override
	public void afterScript(String script, WebDriver driver) {
		logger.info("afterScript");
	}

	@Override
	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		logger.info("beforeSwitchToWindow");
	}

	@Override
	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		logger.info("afterSwitchToWindow");
	}

	@Override
	public void onException ( Throwable throwable, WebDriver driver ) {
		logger.info("onException");
	}

	@Override
	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		logger.info("beforeGetScreenshotAs");
	}

	@Override
	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		logger.info("afterGetScreenshotAs");
	}

	@Override
	public void beforeGetText(WebElement element, WebDriver driver) {
		logger.info("beforeGetText");
	}

	@Override
	public void afterGetText(WebElement element, WebDriver driver, String text) {
		logger.info("afterGetText");
	}
}