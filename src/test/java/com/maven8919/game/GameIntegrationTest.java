package com.maven8919.game;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GameIntegrationTest {

	private static FirefoxDriver browser;

	@Value("${local.server.port}")
	private int port;

	@BeforeClass
	public static void openBrowser() {
		browser = new FirefoxDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Before
	public void navigateToGamePage() {
		String baseUrl = "http://localhost:" + port;
		browser.get(baseUrl);
		browser.findElement(By.cssSelector("a[href*='game']")).click();
	}

	@Test
	public void testGamePageShouldHaveATextInputWithGirlLabel() {
		assertTrue(browser.findElementById("femalePlayerName").isDisplayed());
	}
	
	@Test
	public void testGamePageShouldHaveATextInputWithBoyLabel() {
		assertTrue(browser.findElementById("malePlayerName").isDisplayed());
	}

	@AfterClass
	public static void closeBrowser() {
		browser.quit();
	}

}
