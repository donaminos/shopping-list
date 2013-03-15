package fr.wemy.shopping.list.persistence.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import fr.wemy.shopping.list.domain.ShoppingList;
import fr.wemy.shopping.list.persistence.service.IShoppingListService;
import fr.wemy.shopping.list.repositories.ShoppingListRepository;

@Service
public class ShoppingListServiceImpl implements IShoppingListService {

	@Autowired
	ShoppingListRepository shoppingListRepository;

	@Override
	public List<ShoppingList> getAll() {
		return shoppingListRepository.findAll(new Sort(Direction.DESC,
				"lastViewDate"));
	}

	@Override
	public ShoppingList findOne(String id) {
		ShoppingList shoppingList = shoppingListRepository.findOne(id);
		shoppingList.setLastViewDate(new Date());
		shoppingListRepository.save(shoppingList);
		return shoppingList;
	}

	@Override
	public void create(ShoppingList shoppingList) {
		shoppingList.setLastViewDate(new Date());
		shoppingListRepository.save(shoppingList);
	}

	@Override
	public void update(String id, ShoppingList shoppingList) {
		shoppingList.setLastViewDate(new Date());
		shoppingList.setId(id);
		shoppingListRepository.save(shoppingList);
	}

	@Override
	public void delete(String id) {
		shoppingListRepository.delete(id);
	}

}
