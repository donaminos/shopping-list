package fr.wemy.shopping.list.persistence.service;

import java.util.List;

import fr.wemy.shopping.list.domain.ShoppingList;

public interface IShoppingListService {

	public List<ShoppingList> getAll();

	ShoppingList findOne(String listId);

	public void create(ShoppingList shoppingList);

	void update(String id, ShoppingList shoppingList);

	void delete(String id);

}
