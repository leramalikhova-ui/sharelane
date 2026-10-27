package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;

public class CheckboxesTest extends TestBase {

    @Test
    public void testCheckboxes() {
        CheckboxesPage page = new CheckboxesPage(driver, wait);
        page.open();

        // Проверяем, что первый чекбокс unchecked
        Assert.assertFalse(page.isChecked(0), "Первый чекбокс должен быть unchecked");

        // Отмечаем первый чекбокс
        page.setChecked(0, true);
        Assert.assertTrue(page.isChecked(0), "Первый чекбокс должен стать checked");

        // Проверяем, что второй чекбокс checked
        Assert.assertTrue(page.isChecked(1), "Второй чекбокс должен быть checked");

        // Снимаем второй чекбокс
        page.setChecked(1, false);
        Assert.assertFalse(page.isChecked(1), "Второй чекбокс должен стать unchecked");
    }
}