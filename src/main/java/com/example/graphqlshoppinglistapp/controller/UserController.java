package com.example.graphqlshoppinglistapp.controller;

import com.example.graphqlshoppinglistapp.entity.ShoppingList;
import com.example.graphqlshoppinglistapp.entity.User;
import com.example.graphqlshoppinglistapp.service.ShoppingListService;
import com.example.graphqlshoppinglistapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class UserController {
    private final ShoppingListService shoppingListService;
    private final UserService userService;

    @QueryMapping
    public User user(@Argument long userId) {
        return userService.findById(userId);
    }

    @SchemaMapping
    public ShoppingList list(User user) {
        return shoppingListService.findByUserId(user.getId());
    }

    @MutationMapping
    public User createUser(@Argument String userName) {
        return userService.createUser(userName);
    }


}
