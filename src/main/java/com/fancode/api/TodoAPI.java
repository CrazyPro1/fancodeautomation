package com.fancode.api;

import com.fancode.pojo.Todo;
import com.fancode.utils.APIUtils;
import io.restassured.response.Response;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TodoAPI {
    private static final String TODOS_ENDPOINT = "/todos";

    public static List<Todo> getUserTodos(int userId) {
        Response response = APIUtils.get(TODOS_ENDPOINT);

        if (response.getStatusCode() != 200) {
            throw new RuntimeException("Failed to get todos for user ID " + userId + ": " + response.getStatusLine());
        }

        List<Todo> allTodos = Arrays.asList(response.as(Todo[].class));
        return allTodos.stream()
                .filter(todo -> todo.getUserId() == userId)
                .collect(Collectors.toList());
    }
}
