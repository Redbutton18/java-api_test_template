package com.reqRes.automated.api.service.api.authorization_service;

import com.reqRes.automated.api.AssertableResponse;
import com.reqRes.automated.api.service.api.Wd3SetupApiService;
import com.reqRes.automated.api.models.authorizationModel.request.AuthorizationModel;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthorizationService extends Wd3SetupApiService {

    @Step("Send POST  request")
    public AssertableResponse userRegistration(AuthorizationModel authorizationModel) {
        log.info("Authorization {}", authorizationModel);
        Response register =
                baseSetupHeaders()
                        .body(authorizationModel)
                        .when()
                        .post("api/register")
                        .then().extract().response();
        return new AssertableResponse(register);
    }

}
