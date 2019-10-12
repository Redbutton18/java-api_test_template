package com.reqRes.automated;

import com.reqRes.automated.api.models.userManagementModel.Post_CreateNewUserModel;
import com.reqRes.automated.api.models.userManagementModel.Post_CreateNewUserResponseModel;
import com.reqRes.automated.api.models.userManagementModel.Put_UpdateUserDataResponseModel;
import com.reqRes.automated.api.service.api.userManagement_service.UserManagementService;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import static com.reqRes.automated.api.conditions.Conditions.statusCode;
import static org.testng.Assert.assertEquals;

public class UserManagementTest {


    String userID = "";

    UserManagementService userManagementService = new UserManagementService();

    @TmsLink(value = "")
    @Test(description = "Post create new user Test")
    public void testPostCreateNewUser() {

        Post_CreateNewUserModel post_createNewUserModel = new Post_CreateNewUserModel().randomize();
        String name = post_createNewUserModel.getName();
        String job = post_createNewUserModel.getJob();

        Post_CreateNewUserResponseModel post_createNewUserResponseModel =
                userManagementService.createNewUser(post_createNewUserModel)
                .shouldHave(statusCode(201))
                .responseAs(Post_CreateNewUserResponseModel.class);

        assertEquals(name, post_createNewUserResponseModel.getName());
        assertEquals(job, post_createNewUserResponseModel.getJob());

        userID = post_createNewUserResponseModel.getId();
    }

    @TmsLink(value = "")
    @Test(description = "Put update user data Test")
    public void testPutUpdateUserData() {
        Post_CreateNewUserModel post_createNewUserModel = new Post_CreateNewUserModel().randomize();

        String name = post_createNewUserModel.getName();
        String job = post_createNewUserModel.getJob();

        Put_UpdateUserDataResponseModel put_updateUserDataResponseModel =
                userManagementService.updateUserData(post_createNewUserModel, userID)
                .shouldHave(statusCode(200))
                .responseAs(Put_UpdateUserDataResponseModel.class);

        assertEquals(name, put_updateUserDataResponseModel.getName());
        assertEquals(job, put_updateUserDataResponseModel.getJob());
    }

    @TmsLink(value = "")
    @Test(description = "Delete user data Test")
    public void testDeleteUserData() {
        userManagementService.deleteUserData(userID)
                .shouldHave(statusCode(204));
    }
}
