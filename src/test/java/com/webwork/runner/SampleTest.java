package com.webwork.runner;
import com.microsoft.playwright.*;
import io.qameta.allure.Allure;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.nio.file.Paths;

  public class SampleTest {
    Playwright playwright;
    Browser browser;
    Page page;

    @BeforeClass
    public void setup() {
//      playwright = Playwright.create();
//      browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//      page = browser.newPage();
    }

    @Test
    public void testGoogleSearch() {
      try (Playwright playwright = Playwright.create()) {
        Browser browser = playwright.webkit().launch();
        Page page = browser.newPage();
        page.navigate("https://playwright.dev/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
      }
    }

    @AfterClass
    public void teardown() {
//      browser.close();
//      playwright.close();
    }


}
