import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class BestPractices3 {
    WebDriver selenium;

    @Before
    public void setUp() {
        selenium = new FirefoxDriver();
    }

    @After
    public void tearDown() {
        selenium.quit();
    }

    @Test
    public void ShouldLoadTheHomePageAndThenCheckButtonOnChapter2() {
        Chapter2 ch2 = new Chapter2(selenium).get();
        ch2.isButtonDisplayed("but1");
    }
}
