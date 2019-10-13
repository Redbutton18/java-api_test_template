package com.reqRes.automated.api.service.api.resourceData_service;

import com.reqRes.automated.api.AssertableResponse;
import com.reqRes.automated.api.service.api.Wd3SetupApiService;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class ResourceDataService extends Wd3SetupApiService {

    @Step("Send GET list of resources")
    public AssertableResponse getListOfResouces() {
        log.info("Get_ListOfResources {}");
        Response register =
                baseSetupHeaders()
                .when()
                .get("api/unknown")
                .then().extract().response();

        return new AssertableResponse(register);
    }

    @Step("Send GET resource data")
    public AssertableResponse getResourceData(int resourceID) {
        log.info("Get_UserData {}");
        Response register =
                baseSetupHeaders()
                        .when()
                        .get("api/unknown/" + resourceID)
                        .then().extract().response();

        return new AssertableResponse(register);
    }

}
