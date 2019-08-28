package ru.chausov.to_do_list.servlet.api;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;
import ru.chausov.to_do_list.data_base.entity.User;
import ru.chausov.to_do_list.data_base.repository.UserRepository;
import ru.chausov.to_do_list.servlet.UserController;

import java.util.HashMap;
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTests {

    @Autowired
    private UserController userController;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUserTest() throws Exception {
        User userToAdd = User.builder().username("username").password("123").build();

        Map<String, Object> model = new HashMap<>();

        ModelAndView modelAndView = userController.addUser(userToAdd, model);

        User addedUser = (User) modelAndView.getModel().get("user");

        Assert.assertEquals(userToAdd, addedUser);
    }

    @Test
    public void updateUserTest() throws Exception {
        User userToUpdate = User.builder().username("testUser").password("testPassword")
                .build();

        userRepository.save(userToUpdate);

        Map<String, Object> model = new HashMap<>();

        ModelAndView modelAndView = userController.updateUser(userToUpdate.getId().toString(),
                User.builder().name("TestName").password("123").build(),
                null,
                null,
                model);

        User updatedUser = (User) modelAndView.getModel().get("user");

        Assert.assertNotNull(updatedUser);
        Assert.assertNotEquals(updatedUser.getName(), userToUpdate.getName());
    }
}
