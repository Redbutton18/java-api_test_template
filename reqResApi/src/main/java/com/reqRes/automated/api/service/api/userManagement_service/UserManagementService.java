package com.reqRes.automated.api.service.api.userManagement_service;

import com.reqRes.automated.api.AssertableResponse;
import com.reqRes.automated.api.models.userManagementModel.Post_CreateNewUserModel;
import com.reqRes.automated.api.service.api.Wd3SetupApiService;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class UserManagementService extends Wd3SetupApiService {

    @Step("Send POST Create new User request")
    public AssertableResponse createNewUser(Post_CreateNewUserModel createNewUserModel) {
        log.info("Post_CreateNewUserModel {}", createNewUserModel);
        Response register =
                baseSetupHeaders()
                        .body(createNewUserModel)
                        .when()
                        .post("api/users")
                        .then().extract().response();

        return new AssertableResponse(register);
    }

    @Step("Send PUT Update User Data request")
    public AssertableResponse updateUserData(Post_CreateNewUserModel createNewUserModel, String userID) {
        log.info("Put_updateUserData{}");
        Response register =
                baseSetupHeaders()
                        .body(createNewUserModel)
                        .when()
                        .put("api/users/" + userID)
                        .then().extract().response();

        return new AssertableResponse(register);
    }

    @Step("Send DELETE User Data request")
    public AssertableResponse deleteUserData(String userID) {
        log.info("Delete_UserData{}");
        Response register =
                baseSetupHeaders()
                        .when()
                        .delete("api/users/" + userID)
                        .then().extract().response();

        return new AssertableResponse(register);
    }
}
