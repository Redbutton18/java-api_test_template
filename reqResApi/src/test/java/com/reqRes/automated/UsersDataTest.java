package com.reqRes.automated;

import com.reqRes.automated.api.models.userDataModel.listUsersDataResponseModel.ListUserDataResponseModel;
import com.reqRes.automated.api.models.userDataModel.listUsersDataResponseModel.DataItem;
import com.reqRes.automated.api.models.userDataModel.userDataResponseModel.UserData;
import com.reqRes.automated.api.service.api.userData_service.UserDataService;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.reqRes.automated.api.conditions.Conditions.bodyField;
import static com.reqRes.automated.api.conditions.Conditions.statusCode;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.core.Is.is;
import static org.testng.Assert.assertEquals;

public class UsersDataTest {

    UserDataService userDataService = new UserDataService();
    int usersPerPage = 6;
    int totalNumberOfUsers = 12;
    int totalPages = 2;

    @TmsLink(value = "")
    @Test(description = "Get users data list Test")
    public void testGetUsersDataList() {
        int pageNumber = 2;
        ListUserDataResponseModel listUserDataResponseModel =
                userDataService.getListOfUsers(pageNumber)
                .shouldHave(statusCode(200))
                .responseAs(ListUserDataResponseModel.class);

        assertEquals(pageNumber, listUserDataResponseModel.getPage());
        assertEquals(usersPerPage, listUserDataResponseModel.getPerPage());
        assertEquals(totalNumberOfUsers, listUserDataResponseModel.getTotal());
        assertEquals(totalPages, listUserDataResponseModel.getTotalPages());
        assertEquals(listUserDataResponseModel.getData().size(), 6);
    }

    @TmsLink(value = "")
    @Test(description = "Get user data Test")
    public void testGetUserData() {
        int userID = 3;
        UserData userData =
                userDataService.getUserData(userID)
                        .shouldHave(statusCode(200))
                        .responseAs(UserData.class);

        assertEquals(userData.getData().getId(), 3);
        assertEquals(userData.getData().getFirstName(), "Emma");
        assertEquals(userData.getData().getLastName(), "Wong");
        assertEquals(userData.getData().getEmail(), "emma.wong@reqres.in");
        assertEquals(userData.getData().getAvatar(), "https://s3.amazonaws.com/uifaces/faces/twitter/olegpogodaev/128.jpg");
    }

    @TmsLink(value = "")
    @Test(description = "Get non exist user data Test")
    public void testGetNonExistUserData() {
        int userID = 33;

        userDataService.getUserData(userID)
                        .shouldHave(statusCode(404));
    }
}
