package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckboxesPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By checkboxes = By.cssSelector("[type=checkbox]");

    public CheckboxesPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    public WebElement getCheckbox(int index) {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(checkboxes));
        return driver.findElements(checkboxes).get(index);
    }

    public boolean isChecked(int index) {
        return getCheckbox(index).isSelected();
    }

    public void setChecked(int index, boolean checked) {
        WebElement checkbox = getCheckbox(index);
        if (checkbox.isSelected() != checked) {
            checkbox.click();
        }
    }
}