package io.qaguru.github;


import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    @Step("Создаем задачу с заданным названием")
    public Issue createIssue(String title) {
        final Issue toCreate = new Issue();
        toCreate.setTitle(title);
        // @formatter:off
        return given()
               .filter(new AllureRestAssured())
             //   .header("Authorization", "token  043530181985696189233e6f33aa0e91fa798604")
            //  .baseUri("https://api.github.com")
                .body(toCreate)
                .when()
                .post("/repos/OljaSh/qa-gur-course/issues")
                .then()
                .statusCode(201)
                .extract()
                .as(Issue.class);
        // @formatter:on
    }

    @Step("Удаляем задачу")
    public Issue closeIssue(String state){
        final Issue toClose = new Issue();
        toClose.setState(state);
        // @formatter:off
        return given()
                .filter(new AllureRestAssured())
                .header("Authorization", "token  043530181985696189233e6f33aa0e91fa798604")
                .baseUri("https://api.github.com")
                .body(toClose)
                .when()
                .patch("/repos/OljaSh/qa-gur-course/issues/4")
                .then()
                .statusCode(200)
                .extract()
                .as(Issue.class);
        // @formatter:on
    }

}