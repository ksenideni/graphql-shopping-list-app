package com.example.graphqlshoppinglistapp.controller;

import com.example.graphqlshoppinglistapp.entity.Item;
import com.example.graphqlshoppinglistapp.entity.ShoppingList;
import com.example.graphqlshoppinglistapp.service.ItemService;
import com.example.graphqlshoppinglistapp.service.ShoppingListService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class ShoppingListController {
    private final ItemService itemService;
    private final ShoppingListService shoppingListService;

    @SchemaMapping
    public List<Item> items(ShoppingList list) {
        return itemService.findByListId(list.getId());
    }

    @MutationMapping
    public ShoppingList createList(@Argument String name, @Argument long userId) {
        return shoppingListService.createShoppingList(name, userId);
    }


}
