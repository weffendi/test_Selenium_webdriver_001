import static org.junit.Assert.assertEquals;

import com.opera.core.systems.OperaDriver;
import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class TestChapter6Opera {
    WebDriver driver;

    @Before
    public void setUp() {
        DesiredCapabilities c = DesiredCapabilities.opera();
        c.setCapability("opera.binary", "C:\\Users\\weffendi\\AppData\\Local\\Programs\\Opera\\opera.exe");
        driver = new OperaDriver(c);
        driver.get("http://book.theautomatedtester.co.uk/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExamples() {
        WebElement element = driver.findElement(By.linkText("Chapter4"));
        element.click();

        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().endsWith("chapter4");
            }
        });

        // Assert that we only have 1 link
        Assert.assertEquals(1, driver.findElements(By.linkText("Index")).size());
    }
}
