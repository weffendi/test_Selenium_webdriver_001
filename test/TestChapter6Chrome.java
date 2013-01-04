import static org.junit.Assert.assertEquals;

import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;


@RunWith(BlockJUnit4ClassRunner.class)
public class TestChapter6Chrome extends TestCase {
    private static ChromeDriverService service;
    private WebDriver driver;

    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingChromeDriverExecutable(new File("C:\\localProgram\\webdriver\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
        driver.get("http://book.theautomatedtester.co.uk/chapter4");
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

    @Test
    public void testExample() {
        WebElement element = driver.findElement(By.id("selectLoad"));
        String value = element.getAttribute("value");
        assertEquals("Click to load the select below", value);
    }
}
