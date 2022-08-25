package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FindJUnit5Test {

    @Test
    public void shouldFindJUnit5() {
        // - Откройте страницу Selenide в Github
        open("https://github.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $$("ul.repo-list li").first().$("a").click();
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));

        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        $("#wiki-wrapper").shouldHave(Condition.text("Welcome to the selenide wiki!"));

        // - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=wiki-pages-filter]").shouldHave(Condition.text("SoftAssertions"));

        // - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $("a[href*='SoftAssertions']").click();
        $("#wiki-body").shouldHave(Condition.text("Using JUnit5 extend test class"));
    }
}
