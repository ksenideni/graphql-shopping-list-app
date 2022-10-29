package com.example.graphqlshoppinglistapp.repository;

import com.example.graphqlshoppinglistapp.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemByShoppingListId(long shoppingListId);
}
