import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selenide.*;

public class DrugAndDropTest {

    @BeforeAll
    static void beforeAll() {

        browserSize = "1920x1080";
        baseUrl = "https://the-internet.herokuapp.com";
    }

    SelenideElement figureA = $("#column-a");
    SelenideElement figureB = $("#column-b");

    @Test
    void checkDrugAndDropWithActions() {

        open("/drag_and_drop");

        actions().clickAndHold(figureA).moveToElement(figureB).release().perform();
        $(figureB).shouldHave(text("A"));
        $(figureA).shouldHave(text("B"));
    }

    @Test
    void checkDrugAndDrop() {

        open("/drag_and_drop");

        $(figureA).dragAndDropTo(figureB);
        $(figureB).shouldHave(text("A"));
        $(figureA).shouldHave(text("B"));
    }
}
