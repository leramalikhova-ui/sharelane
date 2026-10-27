package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AddRemovePage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By addButton = By.xpath("//button[text()='Add Element']");
    private By deleteButton = By.xpath("//button[text()='Delete']");

    public AddRemovePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
    }

    public void clickAddElement() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        button.click();
    }

    public void clickDeleteButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        button.click();
    }

    public int getDeleteButtonCount() {
        List<WebElement> buttons = driver.findElements(deleteButton);
        return buttons.size();
    }
}