package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ParametrizedTests {

    static Stream<Arguments> checkItemsInMenu() {
        return Stream.of(
                Arguments.of("Selenide", "selenide/selenide"),
                Arguments.of("Allure", "allure-framework/allure2")
        );
    }

    @BeforeEach
    void setup() {
        Selenide.open("https://github.com/");
    }

    @ValueSource(strings = {
            "Selenide", "Allure"
    })
    @ParameterizedTest(name = "В поисковой выдаче отображается 10 результатов по запросу {0}")
    void checkSearchResults(String testData) {
        $("input[placeholder='Search GitHub']").setValue(testData).pressEnter();
        $$(".repo-list-item").shouldHave(sizeGreaterThanOrEqual(10));
    }

    @CsvFileSource(resources = "/testData/checkSearchResultsForExpectedText.csv")
    @ParameterizedTest(name = "В поисковой по запросу {0} отображается результат {1}")
    void checkSearchResultsForExpectedText(String testData, String expectedText) {
        $("input[placeholder='Search GitHub']").setValue(testData).pressEnter();
        $(".repo-list").shouldHave(text(expectedText));
    }

    @MethodSource
    @ParameterizedTest(name = "В поисковой по запросу {0} отображается результат {1}")
    void checkItemsInMenu(String testData, String expectedText) {
        $("input[placeholder='Search GitHub']").setValue(testData).pressEnter();
        $(".repo-list").shouldHave(text(expectedText));
    }
}
