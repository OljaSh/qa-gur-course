package io.services;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class UserApiService extends ApiService{


    @Step("Логинимся")
    public ValidatableResponse loginWithRegisteredUser() {
        // @formatter:off
        return given()
                .auth()
                .oauth2("043530181985696189233e6f33aa0e91fa798604")
                .when()
                .get("https://api.github.com")
                .then()
                .statusCode(200);
        // @formatter:on
    }
}
