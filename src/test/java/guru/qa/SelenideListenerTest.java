package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest extends TestBase {

    @Test
    void searchWithListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/prodv27/qa-guru-hw");
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
