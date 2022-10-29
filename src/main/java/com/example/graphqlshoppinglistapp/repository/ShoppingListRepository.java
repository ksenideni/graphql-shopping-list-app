package com.example.graphqlshoppinglistapp.repository;

import com.example.graphqlshoppinglistapp.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    Optional<ShoppingList> findByUserId(Long userId);
}
