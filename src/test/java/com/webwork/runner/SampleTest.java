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
      playwright = Playwright.create();
      browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      page = browser.newPage();
    }

    @Test
    public void testGoogleSearch() {
      page.navigate("https://www.google.com");
      page.fill("input[name='q']", "Playwright with Java");
      page.press("input[name='q']", "Enter");

      Allure.addAttachment("Google Page Screenshot", "image/png",
          Paths.get("screenshot.png").toAbsolutePath().toString());
    }

    @AfterClass
    public void teardown() {
      browser.close();
      playwright.close();
    }


}
