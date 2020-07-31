package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.logevents.SelenideLogger.removeAllListeners;

public class BaseTest {

    @BeforeAll()
    static void beforeAll() throws Exception {

    }

    @AfterAll
    static void tearDown() {
        removeAllListeners();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    @AfterEach
    public void cleanUp() {
        removeAllListeners();
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
    }
}
