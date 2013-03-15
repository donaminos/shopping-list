package fr.wemy.shopping.list.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import fr.wemy.shopping.list.domain.ShoppingList;

public interface ShoppingListRepository extends
		MongoRepository<ShoppingList, String> {

}
