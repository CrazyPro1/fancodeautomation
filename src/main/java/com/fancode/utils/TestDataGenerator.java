package com.fancode.utils;

import com.fancode.pojo.User;
import com.fancode.pojo.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class TestDataGenerator {
    public static List<User> generateFanCodeUsers(List<User> allUsers) {
        return allUsers.stream()
                .filter(TestDataGenerator::isFanCodeUser)
                .collect(Collectors.toList());
    }

    public static boolean isFanCodeUser(User user) {
        double lat = Double.parseDouble(user.getAddress().getGeo().getLat());
        double lng = Double.parseDouble(user.getAddress().getGeo().getLng());
        return lat >= -40 && lat <= 5 && lng >= 5 && lng <= 100;
    }

    public static double calculateCompletionPercentage(List<Todo> todos) {
        if (todos.isEmpty()) {
            return 0; // Return 0% if no todos are found
        }
        long completedTodos = todos.stream().filter(Todo::isCompleted).count();
        return (double) completedTodos / todos.size() * 100;
    }
}