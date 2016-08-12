package com.maven8919.index;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class IndexIntegrationTest {

	private static FirefoxDriver browser;

	@Value("${local.server.port}")
	private int port;

	@BeforeClass
	public static void openBrowser() {
		browser = new FirefoxDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testIndexPageShouldHaveALinkWithStartGameText() {
		String baseUrl = "http://localhost:" + port;
		browser.get(baseUrl);
		assertEquals("Start game", browser.findElementByTagName("a").getText());
	}
	
	@Test
	public void testIndexPageStartGameLinkShouldGoToGameCreationPage() {
		String baseUrl = "http://localhost:" + port;
		browser.get(baseUrl);
		browser.findElement(By.cssSelector("a[href*='game']")).click();
	}

	@AfterClass
	public static void closeBrowser() {
		browser.quit();
	}

}
