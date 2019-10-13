package com.reqRes.automated;

import com.reqRes.automated.api.models.resourceDataModel.listResourceDataResponceModel.ListResourceDataResponseModel;
import com.reqRes.automated.api.models.resourceDataModel.resourceDataResponseModel.ResourceDataResponseModel;
import com.reqRes.automated.api.models.userDataModel.listUsersDataResponseModel.ListUserDataResponseModel;
import com.reqRes.automated.api.service.api.resourceData_service.ResourceDataService;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.reqRes.automated.api.conditions.Conditions.statusCode;
import static org.testng.Assert.assertEquals;

public class ResourceDataTest {

    ResourceDataService resourceDataService = new ResourceDataService();

    final int responsesPerPage = 6;
    int totalResources = 12;

    @TmsLink(value = "")
    @Test(description = "Get list of resources Test")
    public void testGetListOfResources() {
        ListResourceDataResponseModel listResourceDataResponseModel =
                resourceDataService.getListOfResouces()
                .shouldHave(statusCode(200))
                .responseAs(ListResourceDataResponseModel.class);

        assertEquals(responsesPerPage, listResourceDataResponseModel.getPerPage());
        assertEquals(totalResources, listResourceDataResponseModel.getTotal());
        assertEquals(listResourceDataResponseModel.getData().size(), 6);
    }

    @TmsLink(value = "")
    @Test(description = "Get resource data Test")
    public void testGetResourceData() {
        int resourceID = 3;

        ResourceDataResponseModel resourceDataResponseModel =
                resourceDataService.getResourceData(resourceID)
                .shouldHave(statusCode(200))
                .responseAs(ResourceDataResponseModel.class);

        assertEquals(resourceDataResponseModel.getData().getId(), resourceID);
        assertEquals(resourceDataResponseModel.getData().getName(), "true red");
        assertEquals(resourceDataResponseModel.getData().getYear(), 2002);
        assertEquals(resourceDataResponseModel.getData().getColor(), "#BF1932");
        assertEquals(resourceDataResponseModel.getData().getPantoneValue(), "19-1664");
    }

    @TmsLink(value = "")
    @Test(description = "Get non exist resource data Test")
    public void testGetNonExistResourceData() {
        resourceDataService.getResourceData(35)
                .shouldHave(statusCode(404));
    }
}
