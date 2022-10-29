package com.example.graphqlshoppinglistapp.controller;

import com.example.graphqlshoppinglistapp.entity.Item;
import com.example.graphqlshoppinglistapp.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @MutationMapping
    public Item createItem(@Argument String title, @Argument String text, @Argument int quantity, @Argument long listId) {
        return itemService.createItem(title, text, quantity, listId);
    }

    @MutationMapping
    public Item completeItem(@Argument long itemId) {
        return itemService.completeItem(itemId);
    }
}
