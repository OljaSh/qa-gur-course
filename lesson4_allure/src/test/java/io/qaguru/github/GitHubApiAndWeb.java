package io.qaguru.github;


import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.services.UserApiService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GitHubApiAndWeb {

    private final BasicSteps webSteps = new BasicSteps();
    private final UserApiService userApiService = new UserApiService();

    private static final String REPOSITORY = "OljaSh/qa-gur-course";

    private final ApiSteps apiSteps = new ApiSteps();

    @BeforeEach
    public void initLogger() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .savePageSource(true)
                .screenshots(true));
    }



    @Test
    @DisplayName("Пользователь не должен найти отсутствующую Issue по номеру")
    public void shouldNotFindIssueByMissingNumber() {
        final Issue created = apiSteps.createIssue("Hello from second stream!)");

        webSteps.openMainPage();
        webSteps.searchForRepository(REPOSITORY);
        webSteps.openRepositoryByLink(REPOSITORY);
        webSteps.openIssuesPage();
        webSteps.shouldSeeIssueWithNumber(created.getNumber());
    }

    @Test
    @DisplayName("Пользователь не должен найти отсутствующую Issue по номеру")
    public void closeIssueTest() {
        apiSteps.closeIssue("closed");

       // webSteps.openMainPage();
        //webSteps.searchForRepository(REPOSITORY);
       // webSteps.openRepositoryByLink(REPOSITORY);
       // webSteps.openIssuesPage();
      //  webSteps.shouldSeeIssueWithNumber(created.getNumber());
    }


}