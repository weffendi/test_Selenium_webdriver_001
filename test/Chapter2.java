import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.junit.*;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class Chapter2 extends LoadableComponent<Chapter2> {
    WebDriver selenium;

    @FindBy(how = How.NAME, using = "verifybutton")
    WebElement verifybutton;

    public Chapter2(WebDriver selenium) {
        this.selenium = selenium;
        PageFactory.initElements(selenium, this);
    }

    @Override
    protected void load() {
        selenium.get("http://book.theautomatedtester.co.uk/chapter2");
    }

     @Override
     public void isLoaded() throws  Error {
        String url = selenium.getCurrentUrl();
        if (! url.endsWith("http://book.theautomatedtester.co.uk/chapter2")) {
          throw new Error("The wrong page has loaded");
        }
    }

    public boolean isButtonDisplayed(String button) {
        return selenium.findElement(By.id(button)).isDisplayed();
    }
}