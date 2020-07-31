package tests.yandexTest;

import helper.CommonData;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class YandexTest extends BaseTest {

    CommonData commonData = new CommonData();

    String siteYandex = "https://yandex.com/";


    @Test
    void selenideSearchInYandexTest() {
        open(siteYandex);

        $(byId("text")).setValue(commonData.searchCriteriaSelenide)
                .pressEnter();

        $("html").shouldHave(text(commonData.searchResultSelenide));
    }

    @Test
    void yandexLogoIsPresentTest() {
        open(siteYandex);

        $(byClassName("logo__image_bg")).shouldBe(visible);
    }

    @Test
    void yandexSearchBarIsPresent() {
        open(siteYandex);

        $(byId("text")).shouldBe(visible);
    }


}
