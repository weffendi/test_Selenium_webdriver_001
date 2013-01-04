import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesignPattern001 {
    WebDriver selenium;

    @Before
    public void setUp() {
        if(!"Page 2".equals(selenium.getTitle())) {
            selenium.get(
                    "http://book.theautomatedtester.co.uk/chapter2");
        }
    }

    @Test
    public void shouldCheckButtonOnChapter2Page() {
        loadHomePage();
        clickAndLoadChapter2();
        Assert.assertEquals(selenium.findElements(
                By.id("but1")).size(), 1);
    }

    @Test
    public void shouldCheckAnotherButtonOnChapter2Page() {
        loadHomePage();
        clickAndLoadChapter2();
        Assert.assertEquals(selenium.findElements(
                By.id("verifyButton")).size(), 1);
    }

    private void clickAndLoadChapter2() {
        selenium.findElement(By.linkText("Chapter2")).click();
    }

    private void loadHomePage() {
        selenium.get("http://book.theautomatedtester.co.uk");
    }


    @After
    public void tearDown() {
        selenium.quit();
    }
}

