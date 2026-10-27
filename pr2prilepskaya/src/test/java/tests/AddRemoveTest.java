package tests;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddRemovePage;

public class AddRemoveTest extends TestBase {

    @Test
    public void testAddTwoElementsAndDeleteOne() {
        AddRemovePage page = new AddRemovePage(driver, wait);
        page.open();

        page.clickAddElement();
        page.clickAddElement();

        Assert.assertEquals(page.getDeleteButtonCount(), 2,
                "Должно быть 2 кнопки Delete после добавления 2 элементов");

        page.clickDeleteButton();

        Assert.assertEquals(page.getDeleteButtonCount(), 1,
                "Должна остаться 1 кнопка Delete после удаления одного элемента");
    }
}