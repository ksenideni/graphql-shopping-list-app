package com.example.graphqlshoppinglistapp.service;

import com.example.graphqlshoppinglistapp.entity.Item;
import com.example.graphqlshoppinglistapp.entity.ShoppingList;
import com.example.graphqlshoppinglistapp.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ShoppingListService shoppingListService;

    public List<Item> findByListId(long listId) {
        return itemRepository.findItemByShoppingListId(listId);
    }

    public Item createItem(String title, String text, int quantity, long listId) {
        Item item = new Item();
        item.setTitle(title);
        item.setText(text);
        item.setQuantity(quantity);
        item.setCompleted(false);
        ShoppingList list = shoppingListService.findById(listId);
        item.setShoppingList(list);
        return itemRepository.save(item);
    }

    public Item completeItem(long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow();
        item.setCompleted(true);
        return itemRepository.save(item);
    }
}
