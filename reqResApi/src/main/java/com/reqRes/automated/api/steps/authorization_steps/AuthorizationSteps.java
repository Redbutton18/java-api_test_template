package com.reqRes.automated.api.steps.authorization_steps;

import com.reqRes.automated.api.conditions.Conditions;
import com.reqRes.automated.api.models.authorizationModel.request.AuthorizationModel;
import com.reqRes.automated.api.properties.UserProp;
import com.reqRes.automated.api.service.api.authorization_service.AuthorizationService;
import io.qameta.allure.Step;

public class AuthorizationSteps {

    private AuthorizationService authorizationService = new AuthorizationService();

    @Step("Authorization by SuperUser return AuthToken")
    public String authorizationBySuperUser_returnAuthToken() {
        AuthorizationModel authorizationModel = new AuthorizationModel()
                .setEmail(UserProp.USER_EMAIL)
                .setPassword(UserProp.USER_PASSWORD);

        String authToken = authorizationService.userRegistration(authorizationModel)
                .shouldHave((Conditions.statusCode(200)))
                .getBodyByPath("token");

        return authToken;
    }

//    @Step("Authorization by user credential return AuthToken")
//    public String authorizationByUserCred_returnAuthToken(String userName, String password) {
//        AuthorizationModel authorizationModel = new AuthorizationModel()
//                .setEmail(userName)
//                .setPassword(password);
//
//        String authToken = authorizationService.authorization(authorizationModel)
//                .shouldHave((Conditions.statusCode(200)))
//                .getBodyByPath("result.token");
//
//        return authToken;
//    }

}
