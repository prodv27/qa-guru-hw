package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем свой репозиторий")
    public void openRepositoryPage(String repo) {
        open(repo);
    }

    @Step("Переходим на таб Issue")
    public void openIssueTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем наличие Issue с номером {issue}")
    public void shouldSeeIssueWithNumber(Integer issue) {
        $(withText("#" + issue)).should(Condition.exist);
    }
}
