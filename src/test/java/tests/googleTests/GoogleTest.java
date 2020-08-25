package tests.googleTests;

import helper.CommonData;
import org.junit.jupiter.api.Test;
import tests.BaseTest;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

class GoogleTest extends BaseTest {

    CommonData commonData = new CommonData();

    String googleSite = "https://google.com";


    @Test
    void selenideSearchInGoogleTest() {
        open(googleSite);

        $(byName("q")).setValue(commonData.searchCriteriaSelenide)
                .pressEnter();

        $("html").shouldHave(text(commonData.searchResultSelenide));
    }

    @Test
    void googlePageElementsPresentTest() {
        open(googleSite);

        $("#logo-default").shouldBe(visible);
        $("#realbox").shouldBe(visible);
        $("#realbox-microphone").shouldBe(visible);
    }
}
