package com.fancode.api;


import com.fancode.pojo.User;
import com.fancode.utils.APIUtils;
import io.restassured.response.Response;


import java.util.Arrays;
import java.util.List;

public class UserAPI {
    private static final String USERS_ENDPOINT = "/users";

    public static List<User> getAllUsers() {
        Response response = APIUtils.get(USERS_ENDPOINT);

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to get users: " + response.getStatusLine());
        }

        return Arrays.asList(response.as(User[].class));
    }
}
