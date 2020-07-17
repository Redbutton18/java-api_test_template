package com.reqRes.automated;

import com.reqRes.automated.api.models.userDataModel.listUsersDataResponseModel.ListUserDataResponseModel;
import com.reqRes.automated.api.models.userDataModel.userDataResponseModel.UserData;
import com.reqRes.automated.api.service.api.userData_service.UserDataService;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.reqRes.automated.api.conditions.Conditions.statusCode;
import static org.testng.Assert.assertEquals;

public class UsersDataTest {

    UserDataService userDataService = new UserDataService();
    int usersPerPage = 6;
    int totalNumberOfUsers = 12;
    int totalPages = 2;
    String company = "StatusCode Weekly";
    String companyUrl = "http://statuscode.org/";
    String text = "A weekly newsletter focusing on software development, infrastructure, the server, performance, and the stack end of things.";

    @TmsLink(value = "")
    @Test(description = "Get users data list Test")
    public void testGetUsersDataList() {
        int pageNumber = 2;
        ListUserDataResponseModel listUserDataResponseModel =
                userDataService.getListOfUsers(pageNumber)
                .shouldHave(statusCode(200))
                .responseAs(ListUserDataResponseModel.class);

        assertEquals(pageNumber, listUserDataResponseModel.getPage().intValue());
        assertEquals(usersPerPage, listUserDataResponseModel.getPerPage().intValue());
        assertEquals(totalNumberOfUsers, listUserDataResponseModel.getTotal().intValue());
        assertEquals(totalPages, listUserDataResponseModel.getTotalPages().intValue());
        assertEquals(listUserDataResponseModel.getData().size(), 6);
        assertEquals(listUserDataResponseModel.getAd().getCompany(), company);
        assertEquals(listUserDataResponseModel.getAd().getUrl(), companyUrl);
        assertEquals(listUserDataResponseModel.getAd().getText(), text);
    }

    @TmsLink(value = "")
    @Test(description = "Get user data Test")
    public void testGetUserData() {
        int userID = 3;
        UserData userData =
                userDataService.getUserData(userID)
                        .shouldHave(statusCode(200))
                        .responseAs(UserData.class);

        assertEquals(userData.getData().getId().intValue(), 3);
        assertEquals(userData.getData().getFirstName(), "Emma");
        assertEquals(userData.getData().getLastName(), "Wong");
        assertEquals(userData.getData().getEmail(), "emma.wong@reqres.in");
        assertEquals(userData.getData().getAvatar(), "https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
        assertEquals(userData.getAd().getCompany(), company);
        assertEquals(userData.getAd().getUrl(), companyUrl);
        assertEquals(userData.getAd().getText(), text);
    }

    @TmsLink(value = "")
    @Test(description = "Get non exist user data Test")
    public void testGetNonExistUserData() {
        int userID = 33;

        String resp =
                userDataService.getUserData(userID)
                        .shouldHave(statusCode(404))
                        .getResponseJsonBody();

        assertEquals(resp, "{}");

    }
}
