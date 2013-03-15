package fr.wemy.shopping.list.web.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import fr.wemy.shopping.list.domain.ShoppingList;
import fr.wemy.shopping.list.persistence.service.IShoppingListService;

@Controller
@RequestMapping(value = "/shoppinglists")
public class ShoppingListController {

	@Autowired
	private IShoppingListService shoppingListService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public java.util.List<ShoppingList> getAll() {
		return shoppingListService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ShoppingList get(@PathVariable String id) {
		return shoppingListService.findOne(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ShoppingList create(@RequestBody ShoppingList shoppingList) {
		shoppingListService.create(shoppingList);
		return shoppingList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ShoppingList update(@PathVariable String id,
			@RequestBody ShoppingList shoppingList) {
		shoppingListService.update(id, shoppingList);
		return shoppingList;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable String id) {
		shoppingListService.delete(id);
	}

}
