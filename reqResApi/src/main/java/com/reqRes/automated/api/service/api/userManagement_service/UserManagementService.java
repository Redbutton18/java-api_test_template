package com.reqRes.automated.api.service.api.userManagement_service;

import com.reqRes.automated.api.AssertableResponse;
import com.reqRes.automated.api.models.UserModel.Post_CreateNewUserModel;
import com.reqRes.automated.api.service.api.Wd3SetupApiService;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class UserManagementService extends Wd3SetupApiService {

    @Step("Send POST Create new User request")
    public AssertableResponse createNewUser(Post_CreateNewUserModel createNewUserModel) {
        log.info("Authorization {}", createNewUserModel);
        Response register =
                baseSetupHeaders()
                .body(createNewUserModel)
                .when()
                .post("api/users")
                .then().extract().response();

        return new AssertableResponse(register);
    }
}
