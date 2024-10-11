package com.fancode.stepdefinitions;

import com.fancode.api.UserAPI;
import com.fancode.api.TodoAPI;
import com.fancode.pojo.User;
import com.fancode.pojo.Todo;
import com.fancode.utils.TestDataGenerator; // Import the TestDataGenerator class
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class FanCodeUserSteps {
    private static final Logger logger = LogManager.getLogger(FanCodeUserSteps.class);
    private List<User> allUsers;
    private List<User> fanCodeUsers;

    @Given("I have the list of all users")
    public void i_have_the_list_of_all_users() {
        allUsers = UserAPI.getAllUsers();
        logger.info("Retrieved {} users", allUsers.size());
    }

    @When("I filter users from FanCode city")
    public void i_filter_users_from_fan_code_city() {
        // Use TestDataGenerator to filter FanCode users
        fanCodeUsers = TestDataGenerator.generateFanCodeUsers(allUsers);
        logger.info("Filtered {} FanCode users", fanCodeUsers.size());
    }

    @Then("each FanCode user should have more than 50% of their todos completed")
    public void each_fan_code_user_should_have_more_than_50_of_their_todos_completed() {
        for (User user : fanCodeUsers) {
            List<Todo> userTodos = TodoAPI.getUserTodos(user.getId());
            double completionPercentage = TestDataGenerator.calculateCompletionPercentage(userTodos); // Use the method from TestDataGenerator
            logger.info("User {} has {}% todos completed", user.getId(), String.format("%.2f", completionPercentage));
            Assert.assertTrue(completionPercentage > 50,
                    "User " + user.getId() + " has only " + completionPercentage + "% todos completed");
        }
    }
}
