package com.example.graphqlshoppinglistapp.service;

import com.example.graphqlshoppinglistapp.entity.ShoppingList;
import com.example.graphqlshoppinglistapp.entity.User;
import com.example.graphqlshoppinglistapp.repository.ShoppingListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShoppingListService {

    private final ShoppingListRepository shoppingListRepository;
    private final UserService userService;

    public ShoppingList findByUserId(long id) {
        return shoppingListRepository.findByUserId(id).orElseThrow();
    }

    public ShoppingList findById(long listId) {
        return shoppingListRepository.findById(listId).orElseThrow();
    }

    public ShoppingList createShoppingList(String name, long userId) {
        User user = userService.findById(userId);
        ShoppingList list = new ShoppingList();
        list.setName(name);
        list.setUser(user);
        return shoppingListRepository.save(list);
    }
}
