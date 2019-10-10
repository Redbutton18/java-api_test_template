package com.reqRes.automated;

import com.reqRes.automated.api.models.authorizationModel.request.AuthorizationModel;
import com.reqRes.automated.api.models.authorizationModel.response.AuthorizationResponseModel;
import com.reqRes.automated.api.service.api.authorization_service.AuthorizationService;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.reqRes.automated.api.conditions.Conditions.bodyField;
import static com.reqRes.automated.api.conditions.Conditions.statusCode;
import static com.reqRes.automated.api.properties.UserProp.USER_EMAIL;
import static com.reqRes.automated.api.properties.UserProp.USER_PASSWORD;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class AuthorizationTest {

    private AuthorizationService authorizationService = new AuthorizationService();

    @TmsLink(value = "")
    @Test(description = "Register User and Generate token for authorization Test")
    public void testRegisterUserAndGenerateTokenForAuthorization() {
        AuthorizationModel authorizationModel = new AuthorizationModel()
                .setEmail(USER_EMAIL)
                .setPassword(USER_PASSWORD);

        AuthorizationResponseModel authorizationResponseModel = authorizationService.userRegistration(authorizationModel)
                .shouldHave(statusCode(200))
                .responseAs(AuthorizationResponseModel.class);

        String token = authorizationResponseModel.getToken();
    }

    @TmsLink(value = "")
    @Test(description = "Register User Without Email Test")
    public void testRegisterUserWithoutEmail() {
        AuthorizationModel authorizationModel = new AuthorizationModel()
                .setPassword(USER_PASSWORD);

        authorizationService.userRegistration(authorizationModel)
                .shouldHave(statusCode(400),
                        bodyField("error", containsString("Missing email or username")));
    }

    @TmsLink(value = "")
    @Test(description = "Register User Without Password Test")
    public void testRegisterUserWithoutPassword() {
        AuthorizationModel authorizationModel = new AuthorizationModel()
                .setEmail(USER_EMAIL);

        authorizationService.userRegistration(authorizationModel)
                .shouldHave(statusCode(400),
                        bodyField("error", containsString("Missing password")));
    }



}
