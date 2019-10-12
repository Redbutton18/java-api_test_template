package com.reqRes.automated.api.service.api.userData_service;

import com.reqRes.automated.api.AssertableResponse;
import com.reqRes.automated.api.service.api.Wd3SetupApiService;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class UserDataService extends Wd3SetupApiService {

    @Step("Send GET list of users")
    public AssertableResponse getListOfUsers(int pageNumber) {
        log.info("Get_ListOfUser {}");
        Response register =
                baseSetupHeaders()
                .when()
                .get("api/users?page=" + pageNumber)
                .then().extract().response();

        return new AssertableResponse(register);
    }

    @Step("Send GET user data")
    public AssertableResponse getUserData(int userID) {
        log.info("Get_UserData {}");
        Response register =
                baseSetupHeaders()
                        .when()
                        .get("api/users/" + userID)
                        .then().extract().response();

        return new AssertableResponse(register);
    }

}
