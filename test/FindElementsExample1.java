import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.internal.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Dictionary;
import java.lang.System.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class FindElementsExample1 {
    WebDriver driver;

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://book.theautomatedtester.co.uk/chapter1");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testExamples() {
        // implicit wait
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//div[@id='ajaxdiv']"));

        // explicit wait
        WebElement element = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return webDriver.findElement(By.xpath("//div[@id='ajaxdiv']"));
            }
        });
    }

}
